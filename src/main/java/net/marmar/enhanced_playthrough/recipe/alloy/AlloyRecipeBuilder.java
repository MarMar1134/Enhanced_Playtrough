package net.marmar.enhanced_playthrough.recipe.alloy;

import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

/**
 * The following class serializes recipe data used on any alloy recipe. It takes the {@code alloyRecipe}
 * parameters and, using the specified serializer, makes a JSON file that Minecraft can read and decode.
 */
public class AlloyRecipeBuilder implements RecipeBuilder {
    private final Ingredient firstIngredient;
    private final Ingredient secondIngredient;
    private final Item result;
    private final int count;
    private final int alloyTime;
    private final float xpAmount;
    private String group;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    private AlloyRecipeBuilder(String pGroup, int pAlloyTime, ItemLike pResult, int pCount, float pXp, Ingredient firstIngredient, Ingredient secondIngredient, RecipeSerializer<?> pSerializer) {
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.result = pResult.asItem();
        this.count = pCount;
        this.alloyTime = pAlloyTime;
        this.xpAmount = pXp;
        this.group = pGroup;
        this.serializer = pSerializer;
    }

    /**
     * Developers should use this method when adding custom alloy recipes to its forks.
     * @param pFirst the item used on the first slot
     * @param pSecond the item used on the second slot
     * @param pAlloyTime the amount of time it takes the recipe to be completed
     * @param pResult the alloy
     * @param pCount the amount of items given per alloy
     * @param pGroup the group with the alloy belongs
     * @param pSerializer the custom serializer
     */
    public static AlloyRecipeBuilder genericAlloy(Ingredient pFirst, Ingredient pSecond, int pAlloyTime, ItemLike pResult, int pCount, float pXp, String pGroup, RecipeSerializer<? extends AbstractAlloyRecipe> pSerializer){
        return new AlloyRecipeBuilder(pGroup, pAlloyTime, pResult, pCount, pXp, pFirst, pSecond, pSerializer);
    }

    public static AlloyRecipeBuilder primitiveOreAlloying(Ingredient pFirst, Ingredient pSecond, ItemLike pResult, float pXp, String pGroup){
        return genericAlloy(pFirst, pSecond, 300, pResult, 1, pXp, pGroup, EPRecipes.PRIMITIVE_ALLOY_SERIALIZER.get());
    }

    public static AlloyRecipeBuilder oreAlloying(Ingredient pFirst, Ingredient pSecond, ItemLike pResult, float pXp, String pGroup) {
        return genericAlloy(pFirst, pSecond, 200, pResult, 1, pXp, pGroup, EPRecipes.ALLOY_SERIALIZER.get());
    }

    public static AlloyRecipeBuilder superOreAlloying(Ingredient pFirst, Ingredient pSecond, ItemLike pResult, float pXp, String pGroup, int pCount) {
        return genericAlloy(pFirst, pSecond, 100, pResult, pCount, pXp, pGroup, EPRecipes.SUPER_ALLOY_SERIALIZER.get());
    }

    @Override
    public AlloyRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public AlloyRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);

        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
                .rewards(AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);

        consumer.accept(new AlloyRecipeBuilder.Result(resourceLocation, this.firstIngredient, this.secondIngredient, this.result, this.count, this.xpAmount,
                this.alloyTime, this.group, this.advancement, resourceLocation.withPrefix("recipes/"), this.serializer));
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    private record Result(ResourceLocation recipeId, Ingredient firstIngredient, Ingredient secondIngredient,
                          Item result, int count, float xpAmount, int alloyTime,
                          String group, Advancement.Builder advancement, ResourceLocation advancementId,
                          RecipeSerializer<?> serializer) implements FinishedRecipe {

        public void serializeRecipeData(JsonObject pJson) {
                if (!this.group.isEmpty())
                    pJson.addProperty("group", this.group);

                pJson.addProperty("alloytime", this.alloyTime);

                pJson.addProperty("xp", this.xpAmount);

                //Inputs
                JsonArray inputArray = new JsonArray();

            inputArray.add(this.firstIngredient.toJson());
            inputArray.add(this.secondIngredient.toJson());

            pJson.add("ingredients", inputArray);

                //Output
                JsonObject outputObject = new JsonObject();

                outputObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

                if (this.count != 1)
                    outputObject.addProperty("count", this.count);

                pJson.add("output", outputObject);
            }

            public RecipeSerializer<?> getType() {
                return this.serializer;
            }

            public ResourceLocation getId() {
                return this.recipeId;
            }

            @Nullable
            public JsonObject serializeAdvancement() {
                return this.advancement.serializeToJson();
            }

            @Nullable
            public ResourceLocation getAdvancementId() {
                return this.advancementId;
            }
        }
}
