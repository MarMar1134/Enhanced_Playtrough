package net.marmar.enhanced_playthrough.recipe.builders;

import com.google.gson.JsonObject;
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
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class EPSmithingRecipesBuilder implements RecipeBuilder {
    private final Ingredient addition;
    private final Ingredient base;
    private final Item result;
    private final Item template;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<? extends SmithingRecipe> serializer;

    public EPSmithingRecipesBuilder(Ingredient addition, Ingredient base, ItemLike result, ItemLike template, RecipeSerializer<? extends SmithingRecipe> serializer) {
        this.addition = addition;
        this.base = base;
        this.result = result.asItem();
        this.template = template.asItem();
        this.serializer = serializer;
    }

    public static EPSmithingRecipesBuilder smithingTransform(ItemLike template, Ingredient base, Ingredient addition, ItemLike result){
        return new EPSmithingRecipesBuilder(addition, base, result, template, RecipeSerializer.SMITHING_TRANSFORM);
    }

    @Override
    public RecipeBuilder unlockedBy(String s, CriterionTriggerInstance criterionTriggerInstance) {
        this.advancement.addCriterion(s, criterionTriggerInstance);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        return null;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        consumer.accept(new Result(resourceLocation, this.addition, this.base, this.result, this.template, this.advancement, resourceLocation.withPrefix("recipes/"), this.serializer));
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient addition;
        private final Ingredient base;
        private final Item result;
        private final Item template;
        private final Advancement.Builder advancement;
        private final ResourceLocation resourceLocation;
        private final RecipeSerializer<? extends SmithingRecipe> serializer;

        public Result(ResourceLocation id, Ingredient addition, Ingredient base, Item result, Item template, Advancement.Builder advancement, ResourceLocation resourceLocation, RecipeSerializer<? extends SmithingRecipe> serializer) {
            this.id = id;
            this.addition = addition;
            this.base = base;
            this.result = result;
            this.template = template;
            this.advancement = advancement;
            this.resourceLocation = resourceLocation;
            this.serializer = serializer;
        }

        @Override
        public void serializeRecipeData(JsonObject jsonObject) {
            //addition
            jsonObject.add("addition", this.addition.toJson());

            //base
            jsonObject.add("base", this.base.toJson());

            //result
            if (this.result != null){
                JsonObject result = new JsonObject();
                result.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
                jsonObject.add("result", result);
            }

            //template
            JsonObject template = new JsonObject();
            template.addProperty("item", ForgeRegistries.ITEMS.getKey(this.template).toString());
            jsonObject.add("template", template);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
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
            return this.resourceLocation;
        }
    }
}
