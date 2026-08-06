package net.marmar.enhanced_playthrough.datagen.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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
        primitiveOreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_ZINC.get(), EPItems.BRASS_INGOT.get(), 0.3f, "brass_ingot");

        oreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_ZINC.get(), EPItems.BRASS_INGOT.get(), 0.3f, "brass_ingot");

        superOreAlloying(consumer, EPTags.Items.COPPER_ALLOYABLE, EPTags.Items.ZINC_ALLOYABLE, EPItems.BRASS_INGOT.get(), 0.3f, "brass_ingot");

        //Bronze
        primitiveOreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_TIN.get(), EPItems.BRONZE_INGOT.get(), 0.4f, "bronze_ingot");

        oreAlloying(consumer, Items.RAW_COPPER, EPItems.RAW_TIN.get(), EPItems.BRONZE_INGOT.get(), 0.4f, "bronze_ingot");

        superOreAlloying(consumer, EPTags.Items.COPPER_ALLOYABLE, EPTags.Items.TIN_ALLOYABLE, EPItems.BRONZE_INGOT.get(), 0.4f, "bronze_ingot");

        //Rose gold
        oreAlloying(consumer, Items.RAW_GOLD, Items.RAW_COPPER, EPItems.ROSE_GOLD_INGOT.get(), 1f, "rose_gold_ingot");

        superOreAlloying(consumer, EPTags.Items.GOLD_ALLOYABLE, EPTags.Items.COPPER_ALLOYABLE, EPItems.ROSE_GOLD_INGOT.get(), 1f, "rose_gold_ingot");

        //Bronzium
        superOreAlloying(consumer, EPItems.BRONZE_INGOT.get(), EPItems.BRASS_INGOT.get(), EPItems.BRONZIUM_INGOT.get(), 0.5f,"bronzium_ingot");

        //Firebrick
        superOreAlloying(consumer, EPItems.RAW_ALUMINUM.get(), Items.CLAY_BALL, EPItems.FIREBRICK.get(), 2f,"firebrick");
        superOreAlloying(consumer, EPItems.ALUMINUM_DUST.get(), Items.CLAY_BALL, EPItems.FIREBRICK.get(), 2, 4f,"firebrick");

        //Lime
        oreAlloying(consumer, EPItems.COBBLE.get(), Items.CLAY_BALL, EPItems.LIME.get(), 2f, "lime");

        superOreAlloying(consumer, EPItems.COBBLE.get(), Items.CLAY_BALL, EPItems.LIME.get(), 2f, "lime");

        //Green gold
        superOreAlloying(consumer, EPTags.Items.GOLD_ALLOYABLE, EPTags.Items.SILVER_ALLOYABLE, EPItems.GREEN_GOLD_INGOT.get(), 1f, "green_gold_ingot");

        //Steel
        oreAlloying(consumer, Items.RAW_IRON, Items.COAL, EPItems.STEEL_INGOT.get(), 0.4f, "steel_ingot");

        superOreAlloying(consumer, EPTags.Items.IRON_ALLOYABLE, Items.COAL, EPItems.STEEL_INGOT.get(), 0.4f, "steel_ingot");

        //Blue gold
        superOreAlloying(consumer, EPTags.Items.GOLD_ALLOYABLE, EPItems.COBALT.get(), EPItems.BLUE_GOLD_INGOT.get(), 1f, "blue_gold_ingot");

        //Purple gold
        superOreAlloying(consumer, Items.RAW_GOLD, EPItems.RAW_ALUMINUM.get(), EPItems.PURPLE_GOLD_INGOT.get(), 1f, "purple_gold_ingot");

        //Calibrated quartz
        oreAlloying(consumer, Items.QUARTZ, EPItems.RAW_TIN.get(), EPItems.CALIBRATED_QUARTZ.get(), 0.4f, "calibrated_quartz");

        superOreAlloying(consumer, Items.QUARTZ, EPItems.RAW_TIN.get(), EPItems.CALIBRATED_QUARTZ.get(), 0.4f,"calibrated_quartz");
    }

    //Serializers
    protected static void singleIngredientAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike ingredient, ItemLike result, int count, float xp, String pGroup){
        oreAlloySerialize(pConsumer, ingredient, ingredient, result, pGroup, xp);
        superOreAlloySerializeWithItem(pConsumer, ingredient, ingredient, result, pGroup, count, xp);
    }

    protected static void primitiveOreAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pResult, float pXp, String pGroup){
        primitiveAlloySerialize(pConsumer, pFirst, pSecond, pResult, pXp, pGroup);
        primitiveAlloySerialize(pConsumer, pSecond, pFirst, pResult, pXp, pGroup);
    }

    protected static void oreAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pResult, float pXp, String Group){
        oreAlloySerialize(pConsumer, pFirst, pSecond, pResult, Group, pXp);
        oreAlloySerialize(pConsumer, pSecond, pFirst, pResult, Group, pXp);
    }

    protected static void superOreAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pResult, int pCount, float pXp, String pGroup){
        superOreAlloySerializeWithItem(pConsumer, pFirst, pSecond, pResult, pGroup, pCount, pXp);
        superOreAlloySerializeWithItem(pConsumer, pSecond, pFirst, pResult, pGroup, pCount, pXp);
    }
    protected static void superOreAlloying(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pResult, float pXp, String pGroup){
        superOreAlloySerializeWithItem(pConsumer, pFirst, pSecond, pResult, pGroup,1, pXp);
        superOreAlloySerializeWithItem(pConsumer, pSecond, pFirst, pResult, pGroup, 1, pXp);
    }

    protected static void superOreAlloying(Consumer<FinishedRecipe> pConsumer, TagKey<Item> pFirst, ItemLike pSecond, ItemLike pResult, float pXp, String pGroup){
        superOreAlloySerializeWithFirstTag(pConsumer, pFirst, pSecond, pResult, pGroup,1, pXp);
        superOreAlloySerializeWithSecondTag(pConsumer, pSecond, pFirst, pResult, pGroup, 1, pXp);
    }

    protected static void superOreAlloying(Consumer<FinishedRecipe> pConsumer, TagKey<Item> pFirst, TagKey<Item> pSecond, ItemLike pResult, float pXp, String pGroup){
        superOreAlloySerializeWithBothTags(pConsumer, pFirst, pSecond, pResult, pGroup,1, pXp);
        superOreAlloySerializeWithBothTags(pConsumer, pSecond, pFirst, pResult, pGroup, 1, pXp);
    }

    private static void primitiveAlloySerialize(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pOutput, float pXp, String pGroup){
        boolean isSameIngredient = pFirst == pSecond;

        if (!isSameIngredient){
            AlloyRecipeBuilder.primitiveOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup)
                    .unlockedBy(getHasName(pFirst), has(pFirst))
                    .unlockedBy(getHasName(pSecond), has(pSecond))
                    .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) + "_from_primitive_alloying_" + getItemName(pFirst) + "_and_" + getItemName(pSecond));
        } else {
            AlloyRecipeBuilder.primitiveOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup)
                    .unlockedBy(getHasName(pFirst), has(pFirst))
                    .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) + "_from_primitive_alloying_" + getItemName(pFirst));
        }
    }

    private static void oreAlloySerialize(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pOutput, String pGroup, float pXp){
        boolean isSameIngredient = pFirst == pSecond;

        if (!isSameIngredient){
            AlloyRecipeBuilder.oreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup)
                    .unlockedBy(getHasName(pFirst), has(pFirst))
                    .unlockedBy(getHasName(pSecond), has(pSecond))
                    .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_alloying_" + getItemName(pFirst) + "_and_" + getItemName(pSecond));
        } else {
            AlloyRecipeBuilder.oreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup)
                    .unlockedBy(getHasName(pFirst), has(pFirst))
                    .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_alloying_" + getItemName(pFirst));
        }
    }

    private static void superOreAlloySerializeWithItem(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, ItemLike pSecond, ItemLike pOutput, String pGroup, int pCount, float pXp){
        boolean isSameIngredient = pFirst == pSecond;

        if (!isSameIngredient){
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup, pCount)
                    .unlockedBy(getHasName(pFirst), has(pFirst))
                    .unlockedBy(getHasName(pSecond), has(pSecond))
                    .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_super_alloying_" + getItemName(pFirst) + "_and_" + getItemName(pSecond));
        } else {
            AlloyRecipeBuilder.superOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup, pCount)
                    .unlockedBy(getHasName(pFirst), has(pFirst))
                    .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_super_alloying_" + getItemName(pFirst));
        }
    }

    private static void superOreAlloySerializeWithFirstTag(Consumer<FinishedRecipe> pConsumer, TagKey<Item> pFirst, ItemLike pSecond, ItemLike pOutput, String pGroup, int pCount, float pXp){
        AlloyRecipeBuilder.superOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup, pCount)
                .unlockedBy(pFirst.toString(), has(pFirst))
                .unlockedBy(getHasName(pSecond), has(pSecond))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_super_alloying_" + pFirst.location().getPath() + "_and_" + getItemName(pSecond));
    }

    private static void superOreAlloySerializeWithSecondTag(Consumer<FinishedRecipe> pConsumer, ItemLike pFirst, TagKey<Item> pSecond, ItemLike pOutput, String pGroup, int pCount, float pXp){
        AlloyRecipeBuilder.superOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup, pCount)
                .unlockedBy(getHasName(pFirst), has(pFirst))
                .unlockedBy(pSecond.toString(), has(pSecond))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_super_alloying_" + getItemName(pFirst) + "_and_" + pSecond.location().getPath());
    }

    private static void superOreAlloySerializeWithBothTags(Consumer<FinishedRecipe> pConsumer, TagKey<Item> pFirst, TagKey<Item> pSecond, ItemLike pOutput, String pGroup, int pCount, float pXp){
        AlloyRecipeBuilder.superOreAlloying(Ingredient.of(pFirst), Ingredient.of(pSecond), pOutput, pXp, pGroup, pCount)
                .unlockedBy(pFirst.toString(), has(pFirst))
                .unlockedBy(pSecond.toString(), has(pSecond))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pOutput) +  "_from_super_alloying_" + pFirst.location().getPath() + "_and_" + pSecond.location().getPath());
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
