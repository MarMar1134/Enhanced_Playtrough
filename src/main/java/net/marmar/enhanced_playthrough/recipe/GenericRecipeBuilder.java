package net.marmar.enhanced_playthrough.recipe;

import net.marmar.enhanced_playthrough.recipe.grind.AbstractGrindRecipe;
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

public class GenericRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private String group;
    private final Ingredient ingredient;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    private GenericRecipeBuilder(ItemLike pResult, int pCount, Ingredient pIngredient, String pGroup, RecipeSerializer<?> pSerializer) {
        this.result = pResult.asItem();
        this.group = pGroup;
        this.count = pCount;
        this.ingredient = pIngredient;
        this.serializer = pSerializer;
    }

    public static GenericRecipeBuilder generic(Ingredient pIngredient, ItemLike pResult, int pCount, String pGroup, RecipeSerializer<?> pSerializer){
        return new GenericRecipeBuilder(pResult, pCount, pIngredient, pGroup, pSerializer);
    }

    public static GenericRecipeBuilder gemPolishing(Ingredient pIngredient, ItemLike pResult, String pGroup) {
        return generic(pIngredient, pResult, 1, pGroup, EPRecipes.POLISHING_SERIALIZER.get());
    }

    public static GenericRecipeBuilder itemGrinding(Ingredient pIngredient, ItemLike pResult, String pGroup, int pCount, RecipeSerializer<? extends AbstractGrindRecipe> pSerializer) {
        return generic(pIngredient, pResult, pCount, pGroup, pSerializer);
    }

    @Override
    public GenericRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public GenericRecipeBuilder group(@Nullable String pGroupName) {
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
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe",
                RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(AdvancementRewards.Builder.recipe(resourceLocation))
                .requirements(RequirementsStrategy.OR);

        consumer.accept(new Result(resourceLocation, this.ingredient, this.result, this.group, this.count, this.advancement,
                resourceLocation.withPrefix("recipes/"), this.serializer));
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    private record Result(ResourceLocation id, Ingredient ingredient, Item result,
                          String group, int count, Advancement.Builder advancement, ResourceLocation resourceLocation,
                          RecipeSerializer<?> serializer) implements FinishedRecipe {

        public void serializeRecipeData(JsonObject pJson) {
                if (!this.group.isEmpty()) {
                    pJson.addProperty("group", this.group);
                }

                //Input
                pJson.add("ingredient", this.ingredient.toJson());

                //Output
                JsonObject output = new JsonObject();
                output.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

                if (this.count != 1) {
                    output.addProperty("count", this.count);
                }

                pJson.add("output", output);
            }

            public RecipeSerializer<?> getType() {
                return this.serializer;
            }

            public ResourceLocation getId() {
                return this.id;
            }

            @Nullable
            public JsonObject serializeAdvancement() {
                return this.advancement.serializeToJson();
            }

            @Nullable
            public ResourceLocation getAdvancementId() {
                return this.resourceLocation;
            }
        }
}
