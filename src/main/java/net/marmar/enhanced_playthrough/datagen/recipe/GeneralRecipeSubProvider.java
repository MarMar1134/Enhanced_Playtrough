package net.marmar.enhanced_playthrough.datagen.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.datagen.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.recipe.leatherwork.CuringRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.grind.AbstractGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.GenericRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.EPSmithingRecipesBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Consumer;

public class GeneralRecipeSubProvider extends RecipeProvider {
    public GeneralRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addGeneralRecipes(Consumer<FinishedRecipe> consumer){
        stonecuttingRecipes(consumer);
        gemPolishingRecipes(consumer);
        grindingRecipes(consumer);
        leatherworkingRecipes(consumer);
    }

    private static void stonecuttingRecipes(Consumer<FinishedRecipe> consumer){
        //Polished stone
        stoneCutting(consumer, Items.STONE, EPBlocks.POLISHED_STONE.get(), 1);
        stoneCutting(consumer, Items.STONE, EPBlocks.POLISHED_STONE_SLAB.get(), 2);
        stoneCutting(consumer, Items.STONE, EPBlocks.POLISHED_STONE_STAIRS.get(), 1);
        stoneCutting(consumer, Items.STONE, EPBlocks.POLISHED_STONE_WALL.get(), 1);

        //Polished stone
        stoneCutting(consumer, EPBlocks.POLISHED_STONE.get(), EPBlocks.POLISHED_STONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.POLISHED_STONE.get(), EPBlocks.POLISHED_STONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.POLISHED_STONE.get(), EPBlocks.POLISHED_STONE_WALL.get(), 1);

        //Cobbled limestone
        stoneCutting(consumer, EPBlocks.COBBLED_LIMESTONE.get(), EPBlocks.COBBLED_LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.COBBLED_LIMESTONE.get(), EPBlocks.COBBLED_LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.COBBLED_LIMESTONE.get(), EPBlocks.COBBLED_LIMESTONE_WALL.get(), 1);

        //Limestone
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_WALL.get(), 1);

        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE.get(), 1);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_WALL.get(), 1);

        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_BRICKS.get(), 1);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.LIMESTONE.get(), EPBlocks.LIMESTONE_BRICK_WALL.get(), 1);

        //Polished limestone
        stoneCutting(consumer, EPBlocks.POLISHED_LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.POLISHED_LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.POLISHED_LIMESTONE.get(), EPBlocks.POLISHED_LIMESTONE_WALL.get(), 1);

        //Limestone bricks
        stoneCutting(consumer, EPBlocks.LIMESTONE_BRICKS.get(), EPBlocks.LIMESTONE_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.LIMESTONE_BRICKS.get(), EPBlocks.LIMESTONE_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.LIMESTONE_BRICKS.get(), EPBlocks.LIMESTONE_BRICK_WALL.get(), 1);

        //Cobbled soulstone
        stoneCutting(consumer, EPBlocks.COBBLED_SOULSTONE.get(), EPBlocks.COBBLED_SOULSTONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.COBBLED_SOULSTONE.get(), EPBlocks.COBBLED_SOULSTONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.COBBLED_SOULSTONE.get(), EPBlocks.COBBLED_SOULSTONE_WALL.get(), 1);

        //Soulstone
        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_WALL.get(), 1);

        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_BRICKS.get(), 1);
        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.SOULSTONE.get(), EPBlocks.SOULSTONE_BRICK_WALL.get(), 1);

        //Soulstone bricks
        stoneCutting(consumer, EPBlocks.SOULSTONE_BRICKS.get(), EPBlocks.SOULSTONE_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.SOULSTONE_BRICKS.get(), EPBlocks.SOULSTONE_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.SOULSTONE_BRICKS.get(), EPBlocks.SOULSTONE_BRICK_WALL.get(), 1);

        //Calibrated quartz
        stoneCutting(consumer, EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(), EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK.get(), 1);
        stoneCutting(consumer, EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(), EPBlocks.CALIBRATED_QUARTZ_PILLAR.get(), 1);
        stoneCutting(consumer, EPBlocks.CALIBRATED_QUARTZ_BLOCK.get(), EPBlocks.CALIBRATED_QUARTZ_BRICKS.get(), 1);
    }

    private static void gemPolishingRecipes(Consumer<FinishedRecipe> consumer){
        gemPolishing(consumer, EPItems.RAW_EMERALD.get(), "emerald", Items.EMERALD);
        gemPolishing(consumer, EPItems.RAW_SAPPHIRE.get(), "sapphire", EPItems.SAPPHIRE.get());
        gemPolishing(consumer, EPItems.RAW_RUBY.get(), "ruby", EPItems.RUBY.get());
        gemPolishing(consumer, EPItems.RAW_DIAMOND.get(), "diamond", Items.DIAMOND);
        gemPolishing(consumer, EPItems.RAW_GARNET.get(), "garnet", EPItems.GARNET.get());
    }

    private static void grindingRecipes(Consumer<FinishedRecipe> consumer){
        //Yerba mate
        primalItemGrinding(consumer, EPItems.YERBA_MATE.get(), "grounded_yerba_mate", EPItems.GROUNDED_YERBA_MATE.get(), 2);
        mechanicalItemGrinding(consumer, EPItems.YERBA_MATE.get(), "grounded_yerba_mate", EPItems.GROUNDED_YERBA_MATE.get(), 4);

        //Walnuts
        primalItemGrinding(consumer, EPItems.WALNUT.get(), "peeled_walnut", EPItems.PEELED_WALNUT.get(), 2);
        mechanicalItemGrinding(consumer, EPItems.WALNUT.get(), "peeled_walnut", EPItems.PEELED_WALNUT.get(), 4);

        //Flour
        primalItemGrinding(consumer, Items.WHEAT, "wheat_flour", EPItems.WHEAT_FLOUR.get(), 2);
        mechanicalItemGrinding(consumer, Items.WHEAT, "wheat_flour", EPItems.WHEAT_FLOUR.get(), 4);

        primalItemGrinding(consumer, Items.PUMPKIN, "pumpkin_flour", EPItems.PUMPKIN_FLOUR.get(), 2);
        mechanicalItemGrinding(consumer, Items.PUMPKIN, "pumpkin_flour", EPItems.PUMPKIN_FLOUR.get(), 4);

        //Sugar
        primalItemGrinding(consumer, Items.SUGAR_CANE, "sugar", Items.SUGAR, 2);
        mechanicalItemGrinding(consumer, Items.SUGAR_CANE, "sugar", Items.SUGAR, 3);

        //Bone meal
        primalItemGrinding(consumer, Items.BONE, "bone_meal", Items.BONE_MEAL, 2);
        mechanicalItemGrinding(consumer, Items.BONE, "bone_meal", Items.BONE_MEAL, 3);

        //String
        primalItemGrinding(consumer, ItemTags.WOOL, "string", Items.STRING, 3);
        mechanicalItemGrinding(consumer, ItemTags.WOOL, "string", Items.STRING, 4);

        primalItemGrinding(consumer, Items.COBWEB, "string", Items.STRING, 3);
        mechanicalItemGrinding(consumer, Items.COBWEB, "string", Items.STRING, 4);

        //Leather strips
        primalItemGrinding(consumer, Items.LEATHER, "leather", EPItems.LEATHER_STRIPS.get(), 2);
        mechanicalItemGrinding(consumer, Items.LEATHER, "leather", EPItems.LEATHER_STRIPS.get(), 4);

        //Sulfur from Blazes
        mechanicalItemGrinding(consumer, Items.BLAZE_ROD, "sulfur", EPItems.SULFUR.get(), 3);

        //Cobble types
        primalItemGrinding(consumer, Blocks.COBBLESTONE, "cobble", EPItems.COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.COBBLESTONE, "cobble", EPItems.COBBLE.get(), 4);

        primalItemGrinding(consumer, EPBlocks.COBBLED_LIMESTONE.get(), "limestone_cobble", EPItems.LIMESTONE_COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, EPBlocks.COBBLED_LIMESTONE.get(), "limestone_cobble", EPItems.LIMESTONE_COBBLE.get(), 4);

        mechanicalItemGrinding(consumer, Blocks.COBBLED_DEEPSLATE, "deepslate_cobble", EPItems.DEEPSLATE_COBBLE.get(), 2);

        primalItemGrinding(consumer, Blocks.BLACKSTONE, "blackstone_cobble", EPItems.BLACKSTONE_COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.BLACKSTONE, "blackstone_cobble", EPItems.BLACKSTONE_COBBLE.get(), 4);

        primalItemGrinding(consumer, Blocks.NETHERRACK, "netherrack_rubble", EPItems.NETHERRACK_RUBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.NETHERRACK, "netherrack_rubble", EPItems.NETHERRACK_RUBBLE.get(), 4);

        //Plant fiber
        primalItemGrinding(consumer, EPBlocks.TALL_REEDS.get(), "vegetable_fiber", EPItems.PLANT_FIBER.get(), 3);
        mechanicalItemGrinding(consumer, EPBlocks.TALL_REEDS.get(), "vegetable_fiber", EPItems.PLANT_FIBER.get(), 6);

        primalItemGrinding(consumer, EPBlocks.REEDS.get(), "vegetable_fiber", EPItems.PLANT_FIBER.get(), 2);
        mechanicalItemGrinding(consumer, EPBlocks.REEDS.get(), "vegetable_fiber", EPItems.PLANT_FIBER.get(), 4);

        primalItemGrinding(consumer, EPBlocks.SMALL_REEDS.get(), "vegetable_fiber", EPItems.PLANT_FIBER.get(), 1);
        mechanicalItemGrinding(consumer, EPBlocks.SMALL_REEDS.get(), "vegetable_fiber", EPItems.PLANT_FIBER.get(), 2);

        //Dyes
            //White
            primalItemGrinding(consumer, Items.BONE_MEAL, "white_dye", Items.WHITE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.BONE_MEAL, "white_dye", Items.WHITE_DYE, 4);

            primalItemGrinding(consumer, Items.LILY_OF_THE_VALLEY, "white_dye", Items.WHITE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.LILY_OF_THE_VALLEY, "white_dye", Items.WHITE_DYE, 4);

            //Light gray
            primalItemGrinding(consumer, Items.AZURE_BLUET, "light_gray_dye", Items.LIGHT_GRAY_DYE, 3);
            mechanicalItemGrinding(consumer, Items.AZURE_BLUET, "light_gray_dye", Items.LIGHT_GRAY_DYE, 4);

            primalItemGrinding(consumer, Items.OXEYE_DAISY, "light_gray_dye", Items.LIGHT_GRAY_DYE, 3);
            mechanicalItemGrinding(consumer, Items.OXEYE_DAISY, "light_gray_dye", Items.LIGHT_GRAY_DYE, 4);

            primalItemGrinding(consumer, Items.WHITE_TULIP, "light_gray_dye", Items.LIGHT_GRAY_DYE, 3);
            mechanicalItemGrinding(consumer, Items.WHITE_TULIP, "light_gray_dye", Items.LIGHT_GRAY_DYE, 4);

            //Black
            mechanicalItemGrinding(consumer, Items.WITHER_ROSE, "black_dye", Items.BLACK_DYE, 3);

            //Brown
            primalItemGrinding(consumer, Items.COCOA_BEANS, "brown_dye", Items.BROWN_DYE, 3);
            mechanicalItemGrinding(consumer, Items.COCOA_BEANS, "brown_dye", Items.BROWN_DYE, 4);

            //Red
            primalItemGrinding(consumer, Items.POPPY, "red_dye", Items.RED_DYE, 3);
            mechanicalItemGrinding(consumer, Items.POPPY, "red_dye", Items.RED_DYE, 4);

            primalItemGrinding(consumer, Items.RED_TULIP, "red_dye", Items.RED_DYE, 3);
            mechanicalItemGrinding(consumer, Items.RED_TULIP, "red_dye", Items.RED_DYE, 4);

            mechanicalItemGrinding(consumer, Items.ROSE_BUSH, "red_dye", Items.RED_DYE, 6);

            mechanicalItemGrinding(consumer, Items.BEETROOT, "red_dye", Items.RED_DYE, 2);

            //Orange
            primalItemGrinding(consumer, EPItems.ORANGE.get(), "orange_dye", Items.ORANGE_DYE, 2);
            mechanicalItemGrinding(consumer, EPItems.ORANGE.get(), "orange_dye", Items.ORANGE_DYE, 3);


            primalItemGrinding(consumer, Items.ORANGE_TULIP, "orange_dye", Items.ORANGE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.ORANGE_TULIP, "orange_dye", Items.ORANGE_DYE, 4);


            primalItemGrinding(consumer, Items.TORCHFLOWER, "orange_dye", Items.ORANGE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.TORCHFLOWER, "orange_dye", Items.ORANGE_DYE, 4);

            //Yellow
            primalItemGrinding(consumer, EPItems.LEMON.get(), "yellow_dye", Items.YELLOW_DYE, 2);
            mechanicalItemGrinding(consumer, EPItems.LEMON.get(), "yellow_dye", Items.YELLOW_DYE, 3);

            primalItemGrinding(consumer, Items.DANDELION, "yellow_dye", Items.YELLOW_DYE, 3);
            mechanicalItemGrinding(consumer, Items.DANDELION, "yellow_dye", Items.YELLOW_DYE, 4);

            mechanicalItemGrinding(consumer, Items.SUNFLOWER, "yellow_dye", Items.YELLOW_DYE, 6);

            //Cyan
            primalItemGrinding(consumer, Items.PITCHER_PLANT, "cyan_dye", Items.CYAN_DYE, 6);
            mechanicalItemGrinding(consumer, Items.PITCHER_PLANT, "cyan_dye", Items.CYAN_DYE, 6);

            primalItemGrinding(consumer, EPBlocks.COLD_LYRIUM.get().asItem(), "cyan_dye", Items.CYAN_DYE, 3);
            mechanicalItemGrinding(consumer, EPBlocks.COLD_LYRIUM.get().asItem(), "cyan_dye", Items.CYAN_DYE, 4);

            //Light blue
            primalItemGrinding(consumer, Items.BLUE_ORCHID, "light_blue_dye", Items.LIGHT_BLUE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.BLUE_ORCHID, "light_blue_dye", Items.LIGHT_BLUE_DYE, 4);

            //Blue
            mechanicalItemGrinding(consumer, Items.LAPIS_LAZULI, "blue_dye", Items.BLUE_DYE, 3);

            primalItemGrinding(consumer, Items.CORNFLOWER, "blue_dye", Items.BLUE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.CORNFLOWER, "blue_dye", Items.BLUE_DYE, 4);

            //Lime
            primalItemGrinding(consumer, EPItems.LIME_FRUIT.get(), "lime_dye", Items.LIME_DYE, 2);
            mechanicalItemGrinding(consumer, EPItems.LIME_FRUIT.get(), "lime_dye", Items.LIME_DYE, 3);

            primalItemGrinding(consumer, EPBlocks.SUCCULENT.get(), "lime_dye", Items.LIME_DYE, 2);
            mechanicalItemGrinding(consumer, EPBlocks.SUCCULENT.get(), "lime_dye", Items.LIME_DYE, 3);

            //Magenta
            primalItemGrinding(consumer, Items.ALLIUM, "magenta_dye", Items.MAGENTA_DYE, 3);
            mechanicalItemGrinding(consumer, Items.LILAC, "magenta_dye", Items.MAGENTA_DYE, 6);

            //Pink
            primalItemGrinding(consumer, Items.PINK_TULIP, "pink_dye", Items.PINK_DYE, 3);
            mechanicalItemGrinding(consumer, Items.PINK_TULIP, "pink_dye", Items.PINK_DYE, 4);

            mechanicalItemGrinding(consumer, Items.PEONY, "pink_dye", Items.PINK_DYE, 6);

            primalItemGrinding(consumer, Items.PINK_PETALS, "pink_dye", Items.PINK_DYE, 3);
            mechanicalItemGrinding(consumer, Items.PINK_PETALS, "pink_dye", Items.PINK_DYE, 4);

        //Dusts
        mechanicalItemGrinding(consumer, EPTags.Items.GOLD_GRINDABLE, "gold_dust", EPItems.GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.SILVER_GRINDABLE, "silver_dust", EPItems.SILVER_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.ALUMINUM_GRINDABLE, "aluminum_dust", EPItems.ALUMINUM_DUST.get(), 1);

        primalItemGrinding(consumer, EPTags.Items.ZINC_GRINDABLE, "zinc_dust", EPItems.ZINC_DUST.get(), 1);
        mechanicalItemGrinding(consumer, EPTags.Items.ZINC_GRINDABLE, "zinc_dust", EPItems.ZINC_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.TIN_GRINDABLE, "tin_dust", EPItems.TIN_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.TIN_GRINDABLE, "tin_dust", EPItems.TIN_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.COPPER_GRINDABLE, "copper_dust", EPItems.COPPER_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.COPPER_GRINDABLE, "copper_dust", EPItems.COPPER_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BRASS_GRINDABLE, "brass_dust", EPItems.BRASS_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.BRASS_GRINDABLE, "brass_dust", EPItems.BRASS_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BRONZE_GRINDABLE, "bronze_dust", EPItems.BRONZE_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.BRONZE_GRINDABLE, "bronze_dust", EPItems.BRONZE_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.ROSE_GOLD_GRINDABLE, "rose_gold_dust", EPItems.ROSE_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.IRON_GRINDABLE, "iron_dust", EPItems.IRON_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BRONZIUM_GRINDABLE, "bronzium_dust", EPItems.BRONZIUM_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.GREEN_GOLD_GRINDABLE, "green_gold_dust", EPItems.GREEN_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.STEEL_GRINDABLE, "steel_dust", EPItems.STEEL_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BLUE_GOLD_GRINDABLE, "blue_gold_dust", EPItems.BLUE_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.PURPLE_GOLD_GRINDABLE, "purple_gold_dust", EPItems.PURPLE_GOLD_DUST.get(), 1);
    }

    private static void leatherworkingRecipes(Consumer<FinishedRecipe> consumer){
        leatherworking(consumer, Items.RABBIT_HIDE, Fluids.WATER, 100, Items.LEATHER, 1);
        leatherworking(consumer, EPItems.COW_HIDE.get(), Fluids.WATER, 100, Items.LEATHER, 2);
        leatherworking(consumer, EPItems.PIG_HIDE.get(), Fluids.WATER, 100, Items.LEATHER, 2);
        leatherworking(consumer, EPItems.WERELLAGER_HIDE.get(), Fluids.WATER, 100, Items.LEATHER, 3);
    }

    //Helpers
    protected static void stoneCutting(Consumer<FinishedRecipe> consumer, ItemLike input, ItemLike output, int count){
        stoneCuttingBuilder(consumer, input, output, count);
    }

    protected static void smithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result){
        smithingTransformSerialize(consumer, template, base, addition, result);
    }

    protected static void bronziumSmithingTemplate(Consumer<FinishedRecipe> consumer, ItemLike bronzeItem, ItemLike brassItem, ItemLike bronziumItem){
        smithingUpgrade(consumer, EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get(), brassItem,
                EPItems.BRONZIUM_INGOT.get(), bronziumItem);
        smithingUpgrade(consumer, EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE.get(), bronzeItem,
                EPItems.BRONZIUM_INGOT.get(), bronziumItem);
    }

    protected static void reinforcedSmithingUpgrade(Consumer<FinishedRecipe> consume, ItemLike baseItem, ItemLike reinforcedItem){
        smithingUpgrade(consume, EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, EPItems.LEATHER_STRIPS.get(), reinforcedItem);
    }

    protected static void aluminumSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike aluminizedItem){
        smithingUpgrade(consumer, EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, EPItems.ALUMINUM_INGOT.get(), aluminizedItem);
    }

    protected static void goldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike pIngot, ItemLike resultItem){
        smithingUpgrade(consumer, EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE.get(), baseItem, pIngot, resultItem);
    }

    protected static void roseGoldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike resultItem){
        goldenSmithingUpgrade(consumer, baseItem, EPItems.ROSE_GOLD_INGOT.get(), resultItem);
    }

    protected static void greenGoldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike resultItem){
        goldenSmithingUpgrade(consumer, baseItem, EPItems.GREEN_GOLD_INGOT.get(), resultItem);
    }

    protected static void blueGoldenSmithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike resultItem){
        goldenSmithingUpgrade(consumer, baseItem, EPItems.BLUE_GOLD_INGOT.get(), resultItem);
    }

    //Grind
        //Primal
        protected static void primalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result, int count){
            oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, EPRecipes.PRIMAL_GRIND_SERIALIZER.get(), "from_primal_grinding");
        }
        protected static void primalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
            oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, EPRecipes.PRIMAL_GRIND_SERIALIZER.get(), "from_primal_grinding");
        }

        //Mechanical
        protected static void mechanicalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result, int count){
            oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, EPRecipes.MECHANICAL_GRIND_SERIALIZER.get(), "from_mechanical_grinding");
        }
        protected static void mechanicalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
            oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, EPRecipes.MECHANICAL_GRIND_SERIALIZER.get(), "from_mechanical_grinding");
        }

    //Polish
    protected static void gemPolishing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result){
        gemPolishingSerialize(pFinishedRecipeConsumer, ingredient, result, group);
    }

    //Leatherworking
    protected static void leatherworking(Consumer<FinishedRecipe> pConsumer, ItemLike pSkin, Fluid fluid, int pWaterAmount, ItemLike pLeatherType, int pLeatherAmount){
        CuringRecipeBuilder.leatherworking(Ingredient.of(pSkin), fluid, pWaterAmount, pLeatherType, pLeatherAmount)
                .unlockedBy(getHasName(pSkin),has(pSkin))
                .save(pConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(pLeatherType) + "_from_leatherworking_" + getItemName(pSkin));
    }

    //Builders
    protected static void smithingTransformSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result){
        EPSmithingRecipesBuilder.smithingTransform(template, Ingredient.of(base), Ingredient.of(addition), result)
                .unlockedBy(getHasName(base), has(base))
                .unlockedBy(getHasName(result), has(result))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(result) + "_from_smithing_" + getItemName(base) + "_with_" + getItemName(addition));
    }

    @SuppressWarnings("removal")
    protected static void smithingTrim(Consumer<FinishedRecipe> pConsumer, ItemLike template){
        SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(template), Ingredient.of(ItemTags.TRIMMABLE_ARMOR), Ingredient.of(ItemTags.TRIM_MATERIALS), RecipeCategory.MISC)
                .unlocks("has_smithing_template", has(template))
                .save(pConsumer, new ResourceLocation(EnhancedPlaythrough.MOD_ID, getItemName(template) + "_smithing_trim"));
    }

    protected static void stoneCuttingBuilder(Consumer<FinishedRecipe> consumer, ItemLike input, ItemLike result, int count){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, count)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(result) + "_from_stone_cutting_" + getItemName(input));
    }

    protected static void gemPolishingSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group){
        GenericRecipeBuilder.gemPolishing(Ingredient.of(input), output, group)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + "_from_gem_polishing_" + getItemName(input));
    }

    protected static void oreGrindingSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, int quantity, RecipeSerializer<? extends AbstractGrindRecipe> recipeSerializer, String recipeName){
        GenericRecipeBuilder.itemGrinding(Ingredient.of(input), output, group, quantity, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }

    protected static void oreGrindingTagSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> input, ItemLike output, String group, int quantity, RecipeSerializer<? extends AbstractGrindRecipe> recipeSerializer, String recipeName){
        GenericRecipeBuilder.itemGrinding(Ingredient.of(input), output, group, quantity, recipeSerializer)
                .unlockedBy(input.toString(), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
