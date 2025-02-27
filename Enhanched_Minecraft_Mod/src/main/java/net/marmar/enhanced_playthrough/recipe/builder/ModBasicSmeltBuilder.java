package net.marmar.enhanced_playthrough.recipe.builder;

import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.category.ModRecipeCategory;
import net.marmar.enhanced_playthrough.recipe.basic.BasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.basic.SoulBasicSmeltingRecipe;
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

public class ModBasicSmeltBuilder implements RecipeBuilder {
    private final Ingredient ingredient;
    private final Item result;
    private final int cookTime;
    private final ModRecipeCategory category;
    private String group;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    private ModBasicSmeltBuilder(ModRecipeCategory recipeCategory, String pGroup, int cookTime, ItemLike pResult, Ingredient ingredient, RecipeSerializer<?> pSerializer) {
        this.ingredient = ingredient;
        this.result = pResult.asItem();
        this.cookTime = cookTime;
        this.category = recipeCategory;
        this.group = pGroup;
        this.serializer = pSerializer;
    }

    @Override
    public ModBasicSmeltBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public ModBasicSmeltBuilder group(@javax.annotation.Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    public static ModBasicSmeltBuilder basicSmelting(Ingredient input, ItemLike result, String group, RecipeSerializer<BasicSmeltingRecipe> serializer){
        return new ModBasicSmeltBuilder(ModRecipeCategory.BASIC_SMELT, group, 300, result, input, serializer);
    }

    public static ModBasicSmeltBuilder soulBasicSmelting(Ingredient input, ItemLike result, String group, RecipeSerializer<SoulBasicSmeltingRecipe> serializer){
        return new ModBasicSmeltBuilder(ModRecipeCategory.SOUL_BASIC_SMELT, group, 200, result, input, serializer);
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        consumer.accept(new ModBasicSmeltBuilder.Result(resourceLocation, this.ingredient, this.result, this.cookTime, this.category, this.group, this.advancement, resourceLocation.withPrefix("recipes/"), this.serializer));
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
        private String group;
        private final Advancement.Builder advancement;
        private final ResourceLocation resourceLocation;
        private final RecipeSerializer<?> serializer;

        public Result(ResourceLocation pId, Ingredient ingredient, Item pResult, int alloyingTime, ModRecipeCategory recipeCategory, String pGroup, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, RecipeSerializer<?> pSerializer) {
            this.id = pId;
            this.ingredient = ingredient;
            this.result = pResult;
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
