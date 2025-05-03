package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.AlloyRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.recipecategory.AlloyRecipeCategory;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class AlloyRecipeSubProvider extends RecipeProvider {
    public AlloyRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addAlloyRecipes(Consumer<FinishedRecipe> consumer){
        //Brass
        oreAlloying(consumer, ModItems.RAW_ZINC.get(), Items.RAW_COPPER, ModItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");
        oreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_ZINC.get(), ModItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");

        superOreAlloying(consumer, ModItems.RAW_ZINC.get(), Items.RAW_COPPER, ModItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");
        superOreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_ZINC.get(), ModItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");
        superOreAlloying(consumer, ModItems.ZINC_INGOT.get(), Items.COPPER_INGOT, ModItems.BRASS_INGOT.get(),
                2, AlloyRecipeCategory.COMPLEX_ALLOY, "brass_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, ModItems.ZINC_INGOT.get(), ModItems.BRASS_INGOT.get(),
                2, AlloyRecipeCategory.COMPLEX_ALLOY, "brass_ingot");

        //Bronze
        oreAlloying(consumer, ModItems.RAW_TIN.get(), Items.RAW_COPPER, ModItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");
        oreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_TIN.get(), ModItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");

        superOreAlloying(consumer, ModItems.RAW_TIN.get(), Items.RAW_COPPER, ModItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");
        superOreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_TIN.get(), ModItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");
        superOreAlloying(consumer, ModItems.TIN_INGOT.get(), Items.COPPER_INGOT, ModItems.BRONZE_INGOT.get(),
                2, AlloyRecipeCategory.COMPLEX_ALLOY, "bronze_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, ModItems.TIN_INGOT.get(), ModItems.BRONZE_INGOT.get(),
                2, AlloyRecipeCategory.COMPLEX_ALLOY, "bronze_ingot");

        //Rose gold
        superOreAlloying(consumer, Items.RAW_GOLD, Items.RAW_COPPER, ModItems.ROSE_GOLD_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "rose_gold_ingot");
        superOreAlloying(consumer, Items.RAW_COPPER, Items.RAW_GOLD, ModItems.ROSE_GOLD_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "rose_gold_ingot");
        superOreAlloying(consumer, Items.GOLD_INGOT, Items.COPPER_INGOT, ModItems.ROSE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "rose_gold_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, Items.GOLD_INGOT, ModItems.ROSE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "rose_gold_ingot");

        //Bronzium
        superOreAlloying(consumer, ModItems.BRASS_INGOT.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_INGOT.get(),
                AlloyRecipeCategory.COMPLEX_ALLOY, "bronzium_ingot");
        superOreAlloying(consumer, ModItems.BRONZE_INGOT.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_INGOT.get(),
                AlloyRecipeCategory.COMPLEX_ALLOY, "bronzium_ingot");

        //Green gold
        superOreAlloying(consumer, Items.RAW_GOLD, ModItems.RAW_SILVER.get(), ModItems.GREEN_GOLD_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "green_gold_ingot");
        superOreAlloying(consumer, ModItems.RAW_SILVER.get(), Items.RAW_GOLD, ModItems.GREEN_GOLD_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "green_gold_ingot");
        superOreAlloying(consumer, Items.GOLD_INGOT, ModItems.SILVER_INGOT.get(), ModItems.GREEN_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "green_gold_ingot");
        superOreAlloying(consumer, ModItems.SILVER_INGOT.get(), Items.GOLD_INGOT, ModItems.GREEN_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "green_gold_ingot");

        //Steel
        oreAlloying(consumer, Items.COAL, Items.RAW_IRON, ModItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");
        oreAlloying(consumer, Items.RAW_IRON, Items.COAL, ModItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");

        superOreAlloying(consumer, Items.COAL, Items.RAW_IRON, ModItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");
        superOreAlloying(consumer, Items.RAW_IRON, Items.COAL, ModItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");
        superOreAlloying(consumer, Items.COAL, Items.IRON_INGOT, ModItems.STEEL_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "steel_ingot");
        superOreAlloying(consumer, Items.IRON_INGOT, Items.COAL, ModItems.STEEL_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "steel_ingot");

        //Blue gold
        superOreAlloying(consumer, Items.RAW_GOLD, ModItems.COBALT.get(), ModItems.BLUE_GOLD_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "blue_gold_ingot");
        superOreAlloying(consumer, ModItems.COBALT.get(), Items.RAW_GOLD, ModItems.BLUE_GOLD_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "blue_gold_ingot");
        superOreAlloying(consumer, Items.GOLD_INGOT, ModItems.COBALT.get(), ModItems.BLUE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "blue_gold_ingot");
        superOreAlloying(consumer, ModItems.COBALT.get(), Items.GOLD_INGOT, ModItems.BLUE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "blue_gold_ingot");
    }

    protected static void oreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, AlloyRecipeCategory recipeCategory, String group){
        oreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, ModRecipes.ALLOYING_SERIALIZER.get(), "from_alloying");
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, int count, AlloyRecipeCategory recipeCategory, String group){
        superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, count, ModRecipes.SUPER_ALLOYING_SERIALIZER.get(), "from_super_alloying");
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, AlloyRecipeCategory recipeCategory, String group){
        superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group,1, ModRecipes.SUPER_ALLOYING_SERIALIZER.get(), "from_super_alloying");
    }

    protected static void oreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, RecipeSerializer<AlloyRecipe> recipeSerializer, String recipeName){
        AlloyRecipeBuilder.oreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, recipeSerializer)
                .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                .unlockedBy(getHasName(secondIngredient), has(secondIngredient))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
    }

    protected static void superOreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, int count, RecipeSerializer<BlastAlloyRecipe> recipeSerializer, String recipeName){
        AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count, recipeSerializer)
                .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                .unlockedBy(getHasName(secondIngredient), has(secondIngredient))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

    }
}
