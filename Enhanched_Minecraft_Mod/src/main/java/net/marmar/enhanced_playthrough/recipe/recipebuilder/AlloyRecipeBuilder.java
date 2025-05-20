package net.marmar.enhanced_playthrough.recipe.recipebuilder;

import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.recipecategory.AlloyRecipeCategory;
import net.minecraft.advancements.Advancement;
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

public class AlloyRecipeBuilder implements RecipeBuilder {
    private final Ingredient firstIngredient;
    private final Ingredient secondIngredient;
    private final Item result;
    private final int count;
    private final int alloyTime;
    private final AlloyRecipeCategory category;
    private String group;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    private AlloyRecipeBuilder(AlloyRecipeCategory recipeCategory, String pGroup, int alloyingTime, ItemLike pResult, int count, Ingredient firstIngredient, Ingredient secondIngredient, RecipeSerializer<?> pSerializer) {
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.result = pResult.asItem();
        this.count = count;
        this.alloyTime = alloyingTime;
        this.category = recipeCategory;
        this.group = pGroup;
        this.serializer = pSerializer;
    }

    public static AlloyRecipeBuilder oreAlloying(Ingredient firstIngredient, Ingredient secondIngredient, AlloyRecipeCategory recipeCategory, ItemLike pResult, String group) {
        return new AlloyRecipeBuilder(recipeCategory, group, 200, pResult, 1, firstIngredient, secondIngredient, ModRecipes.ALLOYING_SERIALIZER.get());
    }

    public static AlloyRecipeBuilder superOreAlloying(Ingredient firstIngredient, Ingredient secondIngredient, AlloyRecipeCategory recipeCategory, ItemLike pResult, String group, int count) {
        return new AlloyRecipeBuilder(recipeCategory, group, 100, pResult, count, firstIngredient, secondIngredient, ModRecipes.SUPER_ALLOYING_SERIALIZER.get());
    }



    @Override
    public AlloyRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public AlloyRecipeBuilder group(@javax.annotation.Nullable String pGroupName) {
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
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        consumer.accept(new AlloyRecipeBuilder.Result(resourceLocation, this.firstIngredient, this.secondIngredient, this.result, this.count, this.alloyTime, this.category, this.group, this.advancement, resourceLocation.withPrefix("recipes/"), this.serializer));
    }
    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
    static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient firstIngredient;
        private final Ingredient secondIngredient;
        private final Item result;
        private final int count;
        private final int alloyTime;
        private final AlloyRecipeCategory category;
        private String group;
        private final Advancement.Builder advancement;
        private final ResourceLocation resourceLocation;
        private final RecipeSerializer<?> serializer;

        public Result(ResourceLocation pId, Ingredient firstIngredient, Ingredient secondIngredient, Item pResult, int count, int alloyingTime, AlloyRecipeCategory recipeCategory, String pGroup, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, RecipeSerializer<?> pSerializer) {
            this.id = pId;
            this.firstIngredient = firstIngredient;
            this.secondIngredient = secondIngredient;
            this.result = pResult;
            this.count = count;
            this.alloyTime = alloyingTime;
            this.category = recipeCategory;
            this.group = pGroup;
            this.advancement = pAdvancement;
            this.resourceLocation = pAdvancementId;
            this.serializer = pSerializer;
        }
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()){
                pJson.addProperty("group", this.group);
            }

            pJson.addProperty("category", this.category.getSerializedName());


                pJson.addProperty("alloytime", this.alloyTime);

                JsonArray inputArray = new JsonArray();

                inputArray.add(this.firstIngredient.toJson());
                inputArray.add(this.secondIngredient.toJson());

                pJson.add("ingredients", inputArray);

            //Output
            JsonObject outputObject = new JsonObject();

            outputObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

            if(this.count != 1){
                outputObject.addProperty("count", this.count);
            }

            pJson.add("output", outputObject);
        }

        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        public ResourceLocation getId() {
            return this.id;
        }

        @javax.annotation.Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.resourceLocation;
        }
    }
}
