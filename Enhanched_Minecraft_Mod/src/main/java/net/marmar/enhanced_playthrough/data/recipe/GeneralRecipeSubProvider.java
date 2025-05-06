package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.data.tag.ModTags;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.recipe.grind.AbstractGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.GenericRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.ModSmithingTransformRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.recipecategory.ModRecipeCategory;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class GeneralRecipeSubProvider extends RecipeProvider {
    public GeneralRecipeSubProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static void addGeneralRecipes(Consumer<FinishedRecipe> consumer){
        smithingRecipes(consumer);
        stonecuttingRecipes(consumer);
        gemPolishingRecipes(consumer);
        grindingRecipes(consumer);

    }

    private static void smithingRecipes(Consumer<FinishedRecipe> consumer){
        //Bronzium
        bronziumSmithingTemplate(consumer, ModItems.BRASS_AXE.get(), ModItems.BRONZE_AXE.get(), ModItems.BRONZIUM_AXE.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_PICKAXE.get(), ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZIUM_PICKAXE.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_SHOVEL.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZIUM_SHOVEL.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_HOE.get(), ModItems.BRONZE_HOE.get(), ModItems.BRONZIUM_HOE.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_POLISHER.get(), ModItems.BRONZE_POLISHER.get(), ModItems.BRONZIUM_POLISHER.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_SWORD.get(), ModItems.BRONZE_SWORD.get(), ModItems.BRONZIUM_SWORD.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_HELMET.get(), ModItems.BRONZE_HELMET.get(), ModItems.BRONZIUM_HELMET.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_CHESTPLATE.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZIUM_CHESTPLATE.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_LEGGINGS.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZIUM_LEGGINGS.get());
        bronziumSmithingTemplate(consumer, ModItems.BRASS_BOOTS.get(), ModItems.BRONZE_BOOTS.get(), ModItems.BRONZIUM_BOOTS.get());

        //Netherite
        smithingUpgrade(consumer, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.DIAMOND_POLISHER.get(),
                Items.NETHERITE_INGOT, ModItems.NETHERITE_POLISHER.get());
    }

    private static void stonecuttingRecipes(Consumer<FinishedRecipe> consumer){
        //Stone
        stoneCutting(consumer, Items.STONE, ModBlocks.STONE_WALL.get(), 1);
        stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE.get(), 1);
        stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE_SLAB.get(), 2);
        stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE_STAIRS.get(), 1);
        stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE_WALL.get(), 1);

        //Polished diorite, andesite and granite walls
        stoneCutting(consumer, Items.POLISHED_DIORITE, ModBlocks.POLISHED_DIORITE_WALL.get(), 1);
        stoneCutting(consumer, Items.POLISHED_ANDESITE, ModBlocks.POLISHED_ANDESITE_WALL.get(), 1);
        stoneCutting(consumer, Items.POLISHED_GRANITE, ModBlocks.POLISHED_GRANITE_WALL.get(), 1);

        //Dripstone
        stoneCutting(consumer, Items.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_SLAB.get(), 2);
        stoneCutting(consumer, Items.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_STAIRS.get(), 1);
        stoneCutting(consumer, Items.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_WALL.get(), 1);

        //Polished stone
        stoneCutting(consumer, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_WALL.get(), 1);

        //Cobbled limestone
        stoneCutting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_WALL.get(), 1);

        //Limestone
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_WALL.get(), 1);

        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE.get(), 1);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_WALL.get(), 1);

        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICKS.get(), 1);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICK_WALL.get(), 1);

        //Polished limestone
        stoneCutting(consumer, ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_WALL.get(), 1);

        //Limestone bricks
        stoneCutting(consumer, ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_WALL.get(), 1);

        //Soul
        stoneCutting(consumer, ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_WALL.get(), 1);
    }

    private static void gemPolishingRecipes(Consumer<FinishedRecipe> consumer){
        gemPolishing(consumer, ModItems.RAW_EMERALD.get(), "gems", Items.EMERALD);
        gemPolishing(consumer, ModItems.RAW_SAPPHIRE.get(), "gems", ModItems.SAPPHIRE.get());
        gemPolishing(consumer, ModItems.RAW_RUBY.get(), "gems", ModItems.RUBY.get());
        gemPolishing(consumer, ModItems.RAW_DIAMOND.get(), "gems", Items.DIAMOND);
        gemPolishing(consumer, ModItems.RAW_GARNET.get(), "gems", ModItems.GARNET.get());
    }

    private static void grindingRecipes(Consumer<FinishedRecipe> consumer){
        //Misc
        primalItemGrinding(consumer, ModItems.YERBA_MATE.get(), "grounded_yerba_mate", ModItems.GROUNDED_YERBA_MATE.get(), 2);
        mechanicalItemGrinding(consumer, ModItems.YERBA_MATE.get(), "grounded_yerba_mate", ModItems.GROUNDED_YERBA_MATE.get(), 4);

        primalItemGrinding(consumer, Items.WHEAT, "wheat_flour", ModItems.WHEAT_FLOUR.get(), 2);
        mechanicalItemGrinding(consumer, Items.WHEAT, "wheat_flour", ModItems.WHEAT_FLOUR.get(), 4);

        primalItemGrinding(consumer, Items.PUMPKIN, "pumpkin_flour", ModItems.PUMPKIN_FLOUR.get(), 2);
        mechanicalItemGrinding(consumer, Items.PUMPKIN, "pumpkin_flour", ModItems.PUMPKIN_FLOUR.get(), 4);

        primalItemGrinding(consumer, Items.SUGAR_CANE, "sugar", Items.SUGAR, 2);
        mechanicalItemGrinding(consumer, Items.SUGAR_CANE, "sugar", Items.SUGAR, 3);

        primalItemGrinding(consumer, Items.BONE, "bone_meal", Items.BONE_MEAL, 2);
        mechanicalItemGrinding(consumer, Items.BONE, "bone_meal", Items.BONE_MEAL, 3);

        primalItemGrinding(consumer, ItemTags.WOOL, "string", Items.STRING, 2);
        mechanicalItemGrinding(consumer, ItemTags.WOOL, "string", Items.STRING, 4);

        //Cobble
        primalItemGrinding(consumer, Blocks.COBBLESTONE, "cobble", ModItems.COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.COBBLESTONE, "cobble", ModItems.COBBLE.get(), 4);

        primalItemGrinding(consumer, ModBlocks.COBBLED_LIMESTONE.get(), "limestone_cobble", ModItems.LIMESTONE_COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, ModBlocks.COBBLED_LIMESTONE.get(), "limestone_cobble", ModItems.LIMESTONE_COBBLE.get(), 4);

        mechanicalItemGrinding(consumer, Blocks.COBBLED_DEEPSLATE, "deepslate_cobble", ModItems.DEEPSLATE_COBBLE.get(), 2);

        primalItemGrinding(consumer, Blocks.BLACKSTONE, "blackstone_cobble", ModItems.BLACKSTONE_COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.BLACKSTONE, "blackstone_cobble", ModItems.BLACKSTONE_COBBLE.get(), 4);

        primalItemGrinding(consumer, Blocks.NETHERRACK, "netherrack_rubble", ModItems.NETHERRACK_RUBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.NETHERRACK, "netherrack_rubble", ModItems.NETHERRACK_RUBBLE.get(), 4);

        //Reeds
        primalItemGrinding(consumer, ModBlocks.TALL_REEDS.get(), "vegetable_fiber", ModItems.VEGETABLE_FIBBER.get(), 3);
        mechanicalItemGrinding(consumer, ModBlocks.TALL_REEDS.get(), "vegetable_fiber", ModItems.VEGETABLE_FIBBER.get(), 6);

        primalItemGrinding(consumer, ModBlocks.REEDS.get(), "vegetable_fiber", ModItems.VEGETABLE_FIBBER.get(), 2);
        mechanicalItemGrinding(consumer, ModBlocks.REEDS.get(), "vegetable_fiber", ModItems.VEGETABLE_FIBBER.get(), 4);

        primalItemGrinding(consumer, ModBlocks.SMALL_REEDS.get(), "vegetable_fiber", ModItems.VEGETABLE_FIBBER.get(), 1);
        mechanicalItemGrinding(consumer, ModBlocks.SMALL_REEDS.get(), "vegetable_fiber", ModItems.VEGETABLE_FIBBER.get(), 2);

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
            primalItemGrinding(consumer, ModItems.ORANGE.get(), "orange_dye", Items.ORANGE_DYE, 2);
            mechanicalItemGrinding(consumer, ModItems.ORANGE.get(), "orange_dye", Items.ORANGE_DYE, 3);


            primalItemGrinding(consumer, Items.ORANGE_TULIP, "orange_dye", Items.ORANGE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.ORANGE_TULIP, "orange_dye", Items.ORANGE_DYE, 4);


            primalItemGrinding(consumer, Items.TORCHFLOWER, "orange_dye", Items.ORANGE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.TORCHFLOWER, "orange_dye", Items.ORANGE_DYE, 4);

            //Yellow
            primalItemGrinding(consumer, ModItems.LEMON.get(), "yellow_dye", Items.YELLOW_DYE, 2);
            mechanicalItemGrinding(consumer, ModItems.LEMON.get(), "yellow_dye", Items.YELLOW_DYE, 3);

            primalItemGrinding(consumer, Items.DANDELION, "yellow_dye", Items.YELLOW_DYE, 3);
            mechanicalItemGrinding(consumer, Items.DANDELION, "yellow_dye", Items.YELLOW_DYE, 4);

            mechanicalItemGrinding(consumer, Items.SUNFLOWER, "yellow_dye", Items.YELLOW_DYE, 6);

            //Cyan
            primalItemGrinding(consumer, Items.PITCHER_PLANT, "cyan_dye", Items.CYAN_DYE, 6);
            mechanicalItemGrinding(consumer, Items.PITCHER_PLANT, "cyan_dye", Items.CYAN_DYE, 6);

            //Light blue
            primalItemGrinding(consumer, Items.BLUE_ORCHID, "light_blue_dye", Items.LIGHT_BLUE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.BLUE_ORCHID, "light_blue_dye", Items.LIGHT_BLUE_DYE, 4);

            //Blue
            mechanicalItemGrinding(consumer, Items.LAPIS_LAZULI, "blue_dye", Items.BLUE_DYE, 3);

            primalItemGrinding(consumer, Items.CORNFLOWER, "blue_dye", Items.BLUE_DYE, 3);
            mechanicalItemGrinding(consumer, Items.CORNFLOWER, "blue_dye", Items.BLUE_DYE, 4);

            //Lime
            primalItemGrinding(consumer, ModItems.LIME.get(), "lime_dye", Items.LIME_DYE, 2);
            mechanicalItemGrinding(consumer, ModItems.LIME.get(), "lime_dye", Items.LIME_DYE, 3);


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
        mechanicalItemGrinding(consumer, ModTags.Items.GOLD_MANUFACTURABLE, "gold_dust", ModItems.GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.SILVER_MANUFACTURABLE, "silver_dust", ModItems.SILVER_DUST.get(), 1);

        primalItemGrinding(consumer, ModTags.Items.ZINC_MANUFACTURABLE, "zinc_dust", ModItems.ZINC_DUST.get(), 1);
        mechanicalItemGrinding(consumer, ModTags.Items.ZINC_MANUFACTURABLE, "zinc_dust", ModItems.ZINC_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.TIN_MANUFACTURABLE, "tin_dust", ModItems.TIN_DUST.get(), 1);
        primalItemGrinding(consumer, ModTags.Items.TIN_MANUFACTURABLE, "tin_dust", ModItems.TIN_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.COPPER_MANUFACTURABLE, "copper_dust", ModItems.COPPER_DUST.get(), 1);
        primalItemGrinding(consumer, ModTags.Items.COPPER_MANUFACTURABLE, "copper_dust", ModItems.COPPER_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.BRASS_MANUFACTURABLE, "brass_dust", ModItems.BRASS_DUST.get(), 1);
        primalItemGrinding(consumer, ModTags.Items.BRASS_MANUFACTURABLE, "brass_dust", ModItems.BRASS_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.BRONZE_MANUFACTURABLE, "bronze_dust", ModItems.BRONZE_DUST.get(), 1);
        primalItemGrinding(consumer, ModTags.Items.BRONZE_MANUFACTURABLE, "bronze_dust", ModItems.BRONZE_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.ROSE_GOLD_MANUFACTURABLE, "rose_gold_dust", ModItems.ROSE_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.IRON_MANUFACTURABLE, "iron_dust", ModItems.IRON_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.BRONZIUM_MANUFACTURABLE, "bronzium_dust", ModItems.BRONZIUM_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.GREEN_GOLD_MANUFACTURABLE, "green_gold_dust", ModItems.GREEN_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.STEEL_MANUFACTURABLE, "steel_dust", ModItems.STEEL_DUST.get(), 1);

        mechanicalItemGrinding(consumer, ModTags.Items.BLUE_GOLD_MANUFACTURABLE, "blue_gold_dust", ModItems.BLUE_GOLD_DUST.get(), 1);
    }

    //Helpers
    protected static void stoneCutting(Consumer<FinishedRecipe> consumer, ItemLike input, ItemLike output, int count){
        stoneCuttingBuilder(consumer, input, RecipeCategory.BUILDING_BLOCKS, output, count, "from_stone_cutting");
    }

    protected static void smithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result){
        smithingTransformSerialize(consumer, template, base, addition, result, RecipeSerializer.SMITHING_TRANSFORM, "from_smithing");
    }

    protected static void bronziumSmithingTemplate(Consumer<FinishedRecipe> consumer, ItemLike bronzeItem, ItemLike brassItem, ItemLike bronziumItem){
        smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), brassItem,
                ModItems.BRONZIUM_INGOT.get(), bronziumItem);
        smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), bronzeItem,
                ModItems.BRONZIUM_INGOT.get(), bronziumItem);
    }

        //Grind
            //Primal
            protected static void primalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result, int count){
                oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.GRIND, ModRecipes.PRIMAL_GRINDING_SERIALIZER.get(), "from_primal_grinding");
            }
            protected static void primalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
                oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.GRIND, ModRecipes.PRIMAL_GRINDING_SERIALIZER.get(), "from_primal_grinding");
            }

            //Mechanical
            protected static void mechanicalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result, int count){
                oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.MECHANICAL_GRIND, ModRecipes.MECHANICAL_GRINDING_SERIALIZER.get(), "from_mechanical_grinding");
            }
            protected static void mechanicalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
                oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.MECHANICAL_GRIND, ModRecipes.MECHANICAL_GRINDING_SERIALIZER.get(), "from_mechanical_grinding");
            }

    //Polish
    protected static void gemPolishing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result){
        gemPolishingSerialize(pFinishedRecipeConsumer, ingredient, result, group, ModRecipes.POLISHING_SERIALIZER.get(), "from_gem_polishing");
    }

    //Builders
    protected static void smithingTransformSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result, RecipeSerializer<SmithingTransformRecipe> serializer, String recipeName){
        ModSmithingTransformRecipeBuilder.SmithingReipeBuilder(template, base, addition, result, serializer)
                .unlockedBy(getHasName(base), has(base))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(result) + "_" + recipeName + "_" + getItemName(base) + "_with_" + getItemName(addition));
    }

    protected static void stoneCuttingBuilder(Consumer<FinishedRecipe> consumer, ItemLike input, RecipeCategory category, ItemLike result, int count, String recipeName){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, result, count)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(result) + "_" + recipeName + "_" + getItemName(input));
    }

    protected static void gemPolishingSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<GemPolishingRecipe> recipeSerializer, String recipeName){
        GenericRecipeBuilder.gemPolishing(Ingredient.of(input), output, group, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) + "_" + recipeName + "_" + getItemName(input));
    }

    protected static void oreGrindingSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, int quantity, ModRecipeCategory pRecipeCategory, RecipeSerializer<? extends AbstractGrindRecipe> recipeSerializer, String recipeName){
        GenericRecipeBuilder.itemGrinding(Ingredient.of(input), output, group, quantity, pRecipeCategory, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }

    protected static void oreGrindingTagSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> input, ItemLike output, String group, int quantity, ModRecipeCategory pRecipeCategory, RecipeSerializer<? extends AbstractGrindRecipe> recipeSerializer, String recipeName){
        GenericRecipeBuilder.itemGrinding(Ingredient.of(input), output, group, quantity, pRecipeCategory, recipeSerializer)
                .unlockedBy(input.toString(), has(input))
                .save(pFinishedRecipeConsumer, EnhancedPlaythrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
