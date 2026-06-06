package net.marmar.enhanced_playthrough.recipe.leatherwork;

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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class LeatherworkRecipeBuilder implements RecipeBuilder {
    private final Ingredient skin;
    private final Fluid fluid;
    private final int fluidAmount;
    private final Item leather;
    private final int leatherAmount;
    private String group;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    protected LeatherworkRecipeBuilder(Ingredient skin, Fluid fluid, int fluidAmount, ItemLike leather, int leatherAmount, RecipeSerializer<?> serializer) {
        this.skin = skin;
        this.fluid = fluid;
        this.fluidAmount = fluidAmount;
        this.leather = leather.asItem();
        this.leatherAmount = leatherAmount;
        this.serializer = serializer;
    }

    public static LeatherworkRecipeBuilder leatherworking(Ingredient pSkin, Fluid pFluid, int pFluidAmount, ItemLike pLeather, int pAmount){
        return new LeatherworkRecipeBuilder(pSkin, pFluid, pFluidAmount, pLeather, pAmount, EPRecipes.LEATHERWORKING_SERIALIZER.get());
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.leather;
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);

        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);

        consumer.accept(new LeatherworkRecipeBuilder.Result(pRecipeId, this.skin, this.fluid, this.fluidAmount, this.leather, this.leatherAmount,
                this.advancement, pRecipeId.withPrefix("recipes/"), this.serializer));
    }

    private record Result(ResourceLocation recipeId, Ingredient skin, Fluid fluid, int waterAmount, Item leather,
                          int leatherAmount, Advancement.Builder advancement, ResourceLocation advancementId,
                          RecipeSerializer<?> serializer) implements FinishedRecipe {

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            //Input
            JsonObject input = new JsonObject();
            input.add("item", this.skin.toJson());

                //Fluid
                ResourceLocation fluid = ForgeRegistries.FLUIDS.getKey(this.fluid);
                input.addProperty("fluid", fluid.toString());
                input.addProperty("fluid_amount", this.waterAmount);

            pJson.add("input", input);

            //Fluid
//            ResourceLocation fluid = ForgeRegistries.FLUIDS.getKey(this.fluid);
//            pJson.addProperty("fluid", fluid.toString());

            //Output
            JsonObject output = new JsonObject();

            JsonObject leather = new JsonObject();
            leather.addProperty("item", ForgeRegistries.ITEMS.getKey(this.leather).toString());
            output.add("item", leather);
            output.addProperty("leather_amount", this.leatherAmount);

            pJson.add("output", output);
        }

        @Override
        public ResourceLocation getId() {
                return this.recipeId;
        }

        @Override public RecipeSerializer<?> getType() {
                return this.serializer;
        }

        @Override public @Nullable JsonObject serializeAdvancement() {
                return this.advancement.serializeToJson();
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
                return this.advancementId;
        }
    }
}
