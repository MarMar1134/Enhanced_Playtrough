package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.builder.AlchemicalDuplicatingRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class AlchemicalDuplicatingSubProvider extends RecipeProvider {
    public AlchemicalDuplicatingSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addAlchemicalDuplicatingRecipes(Consumer<FinishedRecipe> pConsumer){
        //Ores
        alchemicalDuplicating(pConsumer, Items.RAW_COPPER, Items.COPPER_INGOT, 0.3f);
        alchemicalDuplicating(pConsumer, EPItems.RAW_TIN.get(), EPItems.TIN_INGOT.get(), 0.3f);
        alchemicalDuplicating(pConsumer, EPItems.RAW_ZINC.get(), EPItems.ZINC_INGOT.get(), 0.3f);
        alchemicalDuplicating(pConsumer, Items.RAW_IRON, Items.IRON_INGOT, 0.4f);
        alchemicalDuplicating(pConsumer, Items.RAW_GOLD, Items.GOLD_INGOT, 0.5f);
        alchemicalDuplicating(pConsumer, EPItems.RAW_SILVER.get(), EPItems.SILVER_INGOT.get(), 0.5f);
        alchemicalDuplicating(pConsumer, EPItems.RAW_ALUMINUM.get(), EPItems.ALUMINUM_INGOT.get(), 0.6f);
    }

    private static void alchemicalDuplicating(Consumer<FinishedRecipe> pConsumer, TagKey<Item> pInput, ItemLike pOutput, float pXp){
        AlchemicalDuplicatingRecipeBuilder.alchemicalDuplicating(Ingredient.of(pInput), pOutput.asItem(), pXp)
                .unlockedBy("has_" + pInput, has(pInput))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) + "_from_alchemical_duplicating");
    }

    private static void alchemicalDuplicating(Consumer<FinishedRecipe> pConsumer, ItemLike pInput, ItemLike pOutput, float pXp){
        AlchemicalDuplicatingRecipeBuilder.alchemicalDuplicating(Ingredient.of(pInput), pOutput.asItem(), pXp)
                .unlockedBy(getHasName(pInput), has(pInput))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) + "_from_alchemical_duplicating");
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
