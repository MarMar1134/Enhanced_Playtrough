package net.marmar.enhanced_playthrough.recipe.alchemicalduplication;

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

public class AlchemicalDuplicationRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final Item output;
    private final float xp;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    protected AlchemicalDuplicationRecipeBuilder(Ingredient pInput, Item pOutput, float pXp, RecipeSerializer<?> pSerializer){
        this.input = pInput;
        this.output = pOutput;
        this.xp = pXp;
        this.serializer = pSerializer;
    }

    public static AlchemicalDuplicationRecipeBuilder alchemicalDuplicating(Ingredient pInput, Item pOutput, float pXp){
        return new AlchemicalDuplicationRecipeBuilder(pInput, pOutput, pXp, EPRecipes.ALCHEMICAL_DUPLICATING_SERIALIZER.get());
    }

    @Override
    public AlchemicalDuplicationRecipeBuilder unlockedBy(String s, CriterionTriggerInstance criterionTriggerInstance) {
        this.advancement.addCriterion(s, criterionTriggerInstance);
        return this;
    }

    @Override
    public AlchemicalDuplicationRecipeBuilder group(@Nullable String s) {
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

        consumer.accept(new AlchemicalDuplicationRecipeBuilder.Result(recipeId, this.input, this.output, this.xp, this.advancement,
                recipeId.withPrefix("recipes/"), this.serializer));
    }

    private record Result(ResourceLocation recipeId, Ingredient input, Item output, float xp,
                          Advancement.Builder advancement, ResourceLocation advancementId,
                          RecipeSerializer<?> serializer) implements FinishedRecipe {

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
