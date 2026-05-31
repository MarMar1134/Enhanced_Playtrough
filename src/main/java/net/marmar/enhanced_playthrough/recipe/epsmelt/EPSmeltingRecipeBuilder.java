package net.marmar.enhanced_playthrough.recipe.epsmelt;

import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.recipe.category.ModRecipeCategory;
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

/**
 * The following class serializes data of {@code EPSmeltRecipes} and makes them possible to be data driven.
 * It takes the {@code EPSmeltRecipes} and its {@code RecipeSerializer}, and with that generates the JSON file.
 */
public class EPSmeltingRecipeBuilder implements RecipeBuilder {
    private final Ingredient ingredient;
    private final Item result;
    private final int cookTime;
    private final ModRecipeCategory category;
    private String group;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    private EPSmeltingRecipeBuilder(ModRecipeCategory recipeCategory, String pGroup, int cookTime, ItemLike pResult, Ingredient ingredient, RecipeSerializer<?> pSerializer) {
        this.ingredient = ingredient;
        this.result = pResult.asItem();
        this.cookTime = cookTime;
        this.category = recipeCategory;
        this.group = pGroup;
        this.serializer = pSerializer;
    }

    @Override
    public EPSmeltingRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public EPSmeltingRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    public static EPSmeltingRecipeBuilder genericSmelting(Ingredient input, ItemLike result, int pCookTime, ModRecipeCategory pCategory, String pGroup, RecipeSerializer<? extends AbstractEPSmeltingRecipe> pSerializer){
        return new EPSmeltingRecipeBuilder(pCategory, pGroup, pCookTime, result, input, pSerializer);
    }

    public static EPSmeltingRecipeBuilder basicSmelting(Ingredient input, ItemLike result, String group){
        return genericSmelting(input, result, 300, ModRecipeCategory.BASIC_SMELT, group, EPRecipes.BASIC_SMELT_SERIALIZER.get());
    }

    public static EPSmeltingRecipeBuilder soulBasicSmelting(Ingredient input, ItemLike result, String group){
        return genericSmelting(input, result, 200, ModRecipeCategory.SOUL_BASIC_SMELT, group, EPRecipes.SOUL_BASIC_SMELT_SERIALIZER.get());
    }

    public static EPSmeltingRecipeBuilder masonrySmelting(Ingredient input, ItemLike result, String group){
        return genericSmelting(input, result, 100, ModRecipeCategory.MASONRY_SMELT, group, EPRecipes.MASONRY_SMELT_SERIALIZER.get());
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        consumer.accept(new EPSmeltingRecipeBuilder.Result(resourceLocation, this.ingredient, this.result, this.cookTime, this.category, this.group, this.advancement, resourceLocation.withPrefix("recipes/"), this.serializer));
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient ingredient;
        private final Item result;
        private final int alloyTime;
        private final ModRecipeCategory category;
        private final String group;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> serializer;

        public Result(ResourceLocation pId, Ingredient ingredient, Item pResult, int alloyingTime, ModRecipeCategory recipeCategory, String pGroup, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, RecipeSerializer<?> pSerializer) {
            this.id = pId;
            this.ingredient = ingredient;
            this.result = pResult;
            this.alloyTime = alloyingTime;
            this.category = recipeCategory;
            this.group = pGroup;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
            this.serializer = pSerializer;
        }
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) pJson.addProperty("group", this.group);

            pJson.addProperty("category", this.category.getSerializedName());

            pJson.addProperty("cooktime", this.alloyTime);

            pJson.add("ingredient", this.ingredient.toJson());

            //Output
            JsonObject outputObject = new JsonObject();

            outputObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

            pJson.add("output", outputObject);
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
            return this.advancementId;
        }
    }
}