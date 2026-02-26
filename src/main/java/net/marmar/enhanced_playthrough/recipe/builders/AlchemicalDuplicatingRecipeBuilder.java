package net.marmar.enhanced_playthrough.recipe.builders;

import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
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
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class AlchemicalDuplicatingRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final Item output;
    private final float xp;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    protected AlchemicalDuplicatingRecipeBuilder(Ingredient pInput, Item pOutput, float pXp, RecipeSerializer<?> pSerializer){
        this.input = pInput;
        this.output = pOutput;
        this.xp = pXp;
        this.serializer = pSerializer;
    }

    public static AlchemicalDuplicatingRecipeBuilder alchemicalDuplicating(Ingredient pInput, Item pOutput, float pXp){
        return new AlchemicalDuplicatingRecipeBuilder(pInput, pOutput, pXp, EPRecipes.ALCHEMICAL_DUPLICATING_SERIALIZER.get());
    }

    @Override
    public AlchemicalDuplicatingRecipeBuilder unlockedBy(String s, CriterionTriggerInstance criterionTriggerInstance) {
        this.advancement.addCriterion(s, criterionTriggerInstance);
        return this;
    }

    @Override
    public AlchemicalDuplicatingRecipeBuilder group(@Nullable String s) {
        return this;
    }

    @Override
    public Item getResult() {
        return this.output;
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe",
                        RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(RequirementsStrategy.OR);

        consumer.accept(new Result(recipeId, this.input, this.output, this.xp, this.advancement,
                recipeId.withPrefix("recipes/"), this.serializer));
    }

    private static class Result implements FinishedRecipe {
        private final ResourceLocation recipeId;
        private final Ingredient input;
        private final Item output;
        private final float xp;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> serializer;

        private Result(ResourceLocation pId, Ingredient pInput, Item pOutput, float pXp, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, RecipeSerializer<?> pSerializer) {
            this.recipeId = pId;
            this.input = pInput;
            this.output = pOutput;
            this.xp = pXp;
            this.advancement = pAdvancement;
            this.serializer = pSerializer;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject jsonObject) {
            //Input
            jsonObject.add("input", this.input.toJson());

            //Output
            JsonObject output = new JsonObject();
            output.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output).toString());

            jsonObject.add("output", output);

            //Xp
            jsonObject.addProperty("xp", this.xp);
        }

        @Override
        public ResourceLocation getId() {
            return this.recipeId;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
