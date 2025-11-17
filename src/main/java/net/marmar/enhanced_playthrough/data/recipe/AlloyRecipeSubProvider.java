package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.AlloyRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.recipecategory.AlloyRecipeCategory;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class AlloyRecipeSubProvider extends RecipeProvider {
    public AlloyRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addAlloyRecipes(Consumer<FinishedRecipe> consumer){
        //Brass
        oreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_ZINC.get(), EPItems.BRASS_INGOT.get(), "brass_ingot");

        superOreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_ZINC.get(), EPItems.BRASS_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "brass_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, EPItems.ZINC_INGOT.get(), EPItems.BRASS_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "brass_ingot");

        //Bronze
        oreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_TIN.get(), EPItems.BRONZE_INGOT.get(), "bronze_ingot");

        superOreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_TIN.get(), EPItems.BRONZE_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "bronze_ingot");
        superOreAlloying(consumer, Items.COPPER_INGOT, EPItems.TIN_INGOT.get(), EPItems.BRONZE_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "bronze_ingot");

        //Rose gold
        goldenAlloy(consumer, Items.RAW_GOLD, Items.RAW_COPPER, EPItems.ROSE_GOLD_INGOT.get(), 1,
                AlloyRecipeCategory.SIMPLE_ALLOY, "rose_gold_ingot");
        goldenAlloy(consumer, Items.GOLD_INGOT, Items.COPPER_INGOT, EPItems.ROSE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "rose_gold_ingot");

        //Bronzium
        superOreAlloying(consumer, EPItems.BRONZE_INGOT.get(), EPItems.BRASS_INGOT.get(), EPItems.BRONZIUM_INGOT.get(),
                AlloyRecipeCategory.COMPLEX_ALLOY, "bronzium_ingot");

        //Firebrick
        superOreAlloying(consumer, EPItems.RAW_ALUMINUM.get(), Items.CLAY_BALL, EPItems.FIREBRICK.get(), 2,
                AlloyRecipeCategory.SIMPLE_ALLOY, "firebrick");
        superOreAlloying(consumer, EPItems.ALUMINUM_DUST.get(), Items.CLAY_BALL, EPItems.FIREBRICK.get(), 4,
                AlloyRecipeCategory.SIMPLE_ALLOY, "firebrick");

        //Green gold
        goldenAlloy(consumer, Items.RAW_GOLD, EPItems.RAW_SILVER.get(), EPItems.GREEN_GOLD_INGOT.get(), 1,
                AlloyRecipeCategory.SIMPLE_ALLOY, "green_gold_ingot");
        goldenAlloy(consumer, Items.GOLD_INGOT, EPItems.SILVER_INGOT.get(), EPItems.GREEN_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "green_gold_ingot");

        //Steel
        oreAlloying(consumer, Items.RAW_IRON, Items.COAL, EPItems.STEEL_INGOT.get(), "steel_ingot");

        superOreAlloying(consumer, Items.RAW_IRON, Items.COAL, EPItems.STEEL_INGOT.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "steel_ingot");
        superOreAlloying(consumer, Items.IRON_INGOT, Items.COAL, EPItems.STEEL_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "steel_ingot");

        //Blue gold
        goldenAlloy(consumer, Items.RAW_GOLD, EPItems.COBALT.get(), EPItems.BLUE_GOLD_INGOT.get(), 1,
                AlloyRecipeCategory.SIMPLE_ALLOY, "blue_gold_ingot");
        goldenAlloy(consumer, Items.GOLD_INGOT, EPItems.COBALT.get(), EPItems.BLUE_GOLD_INGOT.get(), 2,
                AlloyRecipeCategory.COMPLEX_ALLOY, "blue_gold_ingot");

        //Calibrated quartz
        oreAlloying(consumer, Items.QUARTZ, EPItems.RAW_TIN.get(), EPItems.CALIBRATED_QUARTZ.get(), "calibrated_quartz");
        superOreAlloying(consumer, Items.QUARTZ, EPItems.RAW_TIN.get(), EPItems.CALIBRATED_QUARTZ.get(),
                AlloyRecipeCategory.SIMPLE_ALLOY, "calibrated_quartz");
    }

    //Unlockment triggers
    private static InventoryChangeTrigger.TriggerInstance HAS_GOLD_INGOT_AND(ItemLike pOther){
        return InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT, pOther);
    }
    private static InventoryChangeTrigger.TriggerInstance HAS_RAW_GOLD_AND(ItemLike pOther){
        return InventoryChangeTrigger.TriggerInstance.hasItems(Items.RAW_GOLD, pOther);
    }

    private static InventoryChangeTrigger.TriggerInstance HAS_MATERIALS(ItemLike pFirst, ItemLike pSecond){
        return InventoryChangeTrigger.TriggerInstance.hasItems(pFirst, pSecond);
    }

    //Serializers
    protected static void singleIngredientAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike ingredient, ItemLike result, int count, AlloyRecipeCategory pCategory, String pGroup){
        oreAlloySerialize(pConsumer, ingredient, ingredient, result, pCategory, pGroup);
        superOreAlloySerialize(pConsumer, ingredient, ingredient, result, pCategory, pGroup, count);
    }

    protected static void oreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, String group){
        oreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, AlloyRecipeCategory.SIMPLE_ALLOY, group);
        oreAlloySerialize(pFinishedRecipeConsumer, secondIngredient, firstIngredient, result, AlloyRecipeCategory.SIMPLE_ALLOY, group);
    }
    protected static void goldenAlloy(Consumer<FinishedRecipe> pConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, int count, AlloyRecipeCategory recipeCategory, String group){
        goldenSuperOreAlloySerialize(pConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, count);
        goldenSuperOreAlloySerialize(pConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, count);
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, int count, AlloyRecipeCategory recipeCategory, String group){
        superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group, count);
        superOreAlloySerialize(pFinishedRecipeConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, count);
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, AlloyRecipeCategory recipeCategory, String group){
        superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, recipeCategory, group,1);
        superOreAlloySerialize(pFinishedRecipeConsumer, secondIngredient, firstIngredient, result, recipeCategory, group, 1);
    }

    protected static void oreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group){
        boolean isSameIngredient = firstIngredient == secondIngredient;

        if (!isSameIngredient){
            AlloyRecipeBuilder.oreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group)
                    .unlockedBy("has_required_materials", HAS_MATERIALS(firstIngredient, secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_alloying_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else {
            AlloyRecipeBuilder.oreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group)
                    .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_alloying_" + getItemName(firstIngredient));
        }
    }

    protected static void superOreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, int count){
        boolean isSameIngredient = firstIngredient == secondIngredient;

        if (!isSameIngredient){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_required_materials", HAS_MATERIALS(firstIngredient, secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_super_alloying_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_super_alloying_" + getItemName(firstIngredient));
        }
    }

    protected static void goldenSuperOreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, AlloyRecipeCategory recipeCategory, String group, int count){
        if (firstIngredient.equals(Items.RAW_GOLD)){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_RAW_GOLD_AND(secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_super_alloying_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else if (secondIngredient.equals(Items.RAW_GOLD)){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_RAW_GOLD_AND(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_super_alloying_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else if (firstIngredient.equals(Items.GOLD_INGOT)) {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_GOLD_INGOT_AND(secondIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_super_alloying_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        } else {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), recipeCategory, output, group, count)
                    .unlockedBy("has_gold_and_other", HAS_GOLD_INGOT_AND(firstIngredient))
                    .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_from_super_alloying_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
        }
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
