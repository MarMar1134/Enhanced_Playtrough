package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.AlloyRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.recipecategory.AlloyRecipeCategory;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
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
        oreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_ZINC.get(), ModItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");

        superOreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_ZINC.get(), ModItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, ModItems.ZINC_INGOT.get(), ModItems.BRASS_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "brass_ingot");

        //Bronze
        oreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_TIN.get(), ModItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");

        superOreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_TIN.get(), ModItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, ModItems.TIN_INGOT.get(), ModItems.BRONZE_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "bronze_ingot");

        //Rose gold
        goldenAlloy(consumer, Items.RAW_GOLD, Items.RAW_COPPER, ModItems.ROSE_GOLD_INGOT.get(), 1,
                AlloyRecipeCategory.SIMPLE_ALLOY, "rose_gold_ingot");
        goldenAlloy(consumer, Items.GOLD_INGOT, Items.COPPER_INGOT, ModItems.ROSE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "rose_gold_ingot");

        //Bronzium
        superOreAlloying(consumer, ModItems.BRONZE_INGOT.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_INGOT.get(),
                AlloyRecipeCategory.COMPLEX_ALLOY, "bronzium_ingot");

        //Firebrick
        singleIngredientAlloying(consumer, Items.CLAY_BALL, ModItems.FIREBRICK.get(), 2,
                AlloyRecipeCategory.SIMPLE_ALLOY, "firebrick");

        //Green gold
        goldenAlloy(consumer, Items.RAW_GOLD, ModItems.RAW_SILVER.get(), ModItems.GREEN_GOLD_INGOT.get(), 1,
                AlloyRecipeCategory.SIMPLE_ALLOY, "green_gold_ingot");
        goldenAlloy(consumer, Items.GOLD_INGOT, ModItems.SILVER_INGOT.get(), ModItems.GREEN_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "green_gold_ingot");

        //Steel
        oreAlloying(consumer, Items.RAW_IRON, Items.COAL, ModItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");

        superOreAlloying(consumer, Items.RAW_IRON, Items.COAL, ModItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");
        superOreAlloying(consumer, Items.IRON_INGOT, Items.COAL, ModItems.STEEL_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "steel_ingot");

        //Blue gold
        goldenAlloy(consumer, Items.RAW_GOLD, ModItems.COBALT.get(), ModItems.BLUE_GOLD_INGOT.get(), 1,
                AlloyRecipeCategory.SIMPLE_ALLOY, "blue_gold_ingot");
        goldenAlloy(consumer, Items.GOLD_INGOT, ModItems.COBALT.get(), ModItems.BLUE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "blue_gold_ingot");
    }

    private static InventoryChangeTrigger.TriggerInstance HAS_GOLD_INGOT_AND(ItemLike pOther){
        return InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT, pOther);
    }
    private static InventoryChangeTrigger.TriggerInstance HAS_RAW_GOLD_AND(ItemLike pOther){
        return InventoryChangeTrigger.TriggerInstance.hasItems(Items.RAW_GOLD, pOther);
    }

    protected static void singleIngredientAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike ingredient, ItemLike result, int count, AlloyRecipeCategory pCategory, String pGroup){
        oreAlloySerialize(pConsumer, ingredient, ingredient, result, pCategory, pGroup, "from_alloying");
        superOreAlloySerialize(pConsumer, ingredient, ingredient, result, pCategory, pGroup, count, "from_super_alloying");
    }

    protected static void oreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, AlloyRecipeCategory recipeCategory, String group){
        oreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, "from_alloying");
        oreAlloySerialize(pFinishedRecipeConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, "from_alloying");
    }
    protected static void goldenAlloy(Consumer<FinishedRecipe> pConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, int count, AlloyRecipeCategory recipeCategory, String group){
        goldenSuperOreAlloySerialize(pConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, count, "from_super_alloying");
        goldenSuperOreAlloySerialize(pConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, count, "from_super_alloying");
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, int count, AlloyRecipeCategory recipeCategory, String group){
        superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, count, "from_super_alloying");
        superOreAlloySerialize(pFinishedRecipeConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, count, "from_super_alloying");
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, AlloyRecipeCategory recipeCategory, String group){
        superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group,1, "from_super_alloying");
        superOreAlloySerialize(pFinishedRecipeConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, 1, "from_super_alloying");
    }

    protected static void oreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, String recipeName){
        boolean isSameIngredient = firstIngredient == secondIngredient;

        if (!isSameIngredient){
            AlloyRecipeBuilder.oreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group)
                    .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                    .unlockedBy(getHasName(secondIngredient), has(secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else {
            AlloyRecipeBuilder.oreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group)
                    .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient));
        }
    }

    protected static void superOreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, int count, String recipeName){
        boolean isSameIngredient = firstIngredient == secondIngredient;

        if (!isSameIngredient){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                    .unlockedBy(getHasName(secondIngredient), has(secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient));
        }
    }

    protected static void goldenSuperOreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, int count, String recipeName){
        if (firstIngredient.equals(Items.RAW_GOLD)){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_RAW_GOLD_AND(secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else if (secondIngredient.equals(Items.RAW_GOLD)){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_RAW_GOLD_AND(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else if (firstIngredient.equals(Items.GOLD_INGOT)) {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_GOLD_INGOT_AND(secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_GOLD_INGOT_AND(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        }
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
