package net.marmar.enhanced_playthrough.data.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.recipe.grind.AbstractGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.GenericRecipeBuilder;
import net.marmar.enhanced_playthrough.recipe.recipebuilder.EPSmithingRecipesBuilder;
import net.marmar.enhanced_playthrough.recipe.recipecategory.ModRecipeCategory;
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
        //Smithing trims
        smithingTrim(consumer, EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get());

        //Bronzium
        bronziumSmithingTemplate(consumer, EPItems.BRASS_AXE.get(), EPItems.BRONZE_AXE.get(), EPItems.BRONZIUM_AXE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_PICKAXE.get(), EPItems.BRONZE_PICKAXE.get(), EPItems.BRONZIUM_PICKAXE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_SHOVEL.get(), EPItems.BRONZE_SHOVEL.get(), EPItems.BRONZIUM_SHOVEL.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_HOE.get(), EPItems.BRONZE_HOE.get(), EPItems.BRONZIUM_HOE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_POLISHER.get(), EPItems.BRONZE_POLISHER.get(), EPItems.BRONZIUM_POLISHER.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_SWORD.get(), EPItems.BRONZE_SWORD.get(), EPItems.BRONZIUM_SWORD.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_DAGGER.get(), EPItems.BRONZE_DAGGER.get(), EPItems.BRONZIUM_DAGGER.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_HELMET.get(), EPItems.BRONZE_HELMET.get(), EPItems.BRONZIUM_HELMET.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_CHESTPLATE.get(), EPItems.BRONZE_CHESTPLATE.get(), EPItems.BRONZIUM_CHESTPLATE.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_LEGGINGS.get(), EPItems.BRONZE_LEGGINGS.get(), EPItems.BRONZIUM_LEGGINGS.get());
        bronziumSmithingTemplate(consumer, EPItems.BRASS_BOOTS.get(), EPItems.BRONZE_BOOTS.get(), EPItems.BRONZIUM_BOOTS.get());

        //Aluminum variants
            //Wood
            aluminumSmithingTemplate(consumer, Items.WOODEN_AXE, EPItems.ALUMINUM_WOODEN_AXE.get());
            aluminumSmithingTemplate(consumer, Items.WOODEN_PICKAXE, EPItems.ALUMINUM_WOODEN_PICKAXE.get());
            aluminumSmithingTemplate(consumer, Items.WOODEN_SHOVEL, EPItems.ALUMINUM_WOODEN_SHOVEL.get());
            aluminumSmithingTemplate(consumer, Items.WOODEN_HOE, EPItems.ALUMINUM_WOODEN_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.WOODEN_DAGGER.get(), EPItems.ALUMINUM_WOODEN_DAGGER.get());

            //Stone
            aluminumSmithingTemplate(consumer, Items.STONE_AXE, EPItems.ALUMINUM_STONE_AXE.get());
            aluminumSmithingTemplate(consumer, Items.STONE_PICKAXE, EPItems.ALUMINUM_STONE_PICKAXE.get());
            aluminumSmithingTemplate(consumer, Items.STONE_SHOVEL, EPItems.ALUMINUM_STONE_SHOVEL.get());
            aluminumSmithingTemplate(consumer, Items.STONE_HOE, EPItems.ALUMINUM_STONE_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.STONE_POLISHER.get(), EPItems.ALUMINUM_STONE_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.STONE_DAGGER.get(), EPItems.ALUMINUM_STONE_DAGGER.get());

            //Gold
            aluminumSmithingTemplate(consumer, Items.GOLDEN_AXE, EPItems.ALUMINUM_GOLDEN_AXE.get());
            aluminumSmithingTemplate(consumer, Items.GOLDEN_PICKAXE, EPItems.ALUMINUM_GOLDEN_PICKAXE.get());
            aluminumSmithingTemplate(consumer, Items.GOLDEN_SHOVEL, EPItems.ALUMINUM_GOLDEN_SHOVEL.get());
            aluminumSmithingTemplate(consumer, Items.GOLDEN_HOE, EPItems.ALUMINUM_GOLDEN_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GOLDEN_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GOLDEN_DAGGER.get());

            //Silver
            aluminumSmithingTemplate(consumer, EPItems.SILVER_AXE.get(), EPItems.ALUMINUM_SILVER_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.SILVER_PICKAXE.get(), EPItems.ALUMINUM_SILVER_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.SILVER_SHOVEL.get(), EPItems.ALUMINUM_SILVER_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.SILVER_HOE.get(), EPItems.ALUMINUM_SILVER_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_SILVER_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.SILVER_DAGGER.get(), EPItems.ALUMINUM_SILVER_DAGGER.get());

            //Iron
            aluminumSmithingTemplate(consumer, Items.IRON_AXE, EPItems.ALUMINUM_IRON_AXE.get());
            aluminumSmithingTemplate(consumer, Items.IRON_PICKAXE, EPItems.ALUMINUM_IRON_PICKAXE.get());
            aluminumSmithingTemplate(consumer, Items.IRON_SHOVEL, EPItems.ALUMINUM_IRON_SHOVEL.get());
            aluminumSmithingTemplate(consumer, Items.IRON_HOE, EPItems.ALUMINUM_IRON_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.IRON_POLISHER.get(), EPItems.ALUMINUM_IRON_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.IRON_DAGGER.get(), EPItems.ALUMINUM_IRON_DAGGER.get());

            //Bronze
            aluminumSmithingTemplate(consumer, EPItems.BRONZE_AXE.get(), EPItems.ALUMINUM_BRONZE_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZE_PICKAXE.get(), EPItems.ALUMINUM_BRONZE_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZE_SHOVEL.get(), EPItems.ALUMINUM_BRONZE_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZE_HOE.get(), EPItems.ALUMINUM_BRONZE_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZE_POLISHER.get(), EPItems.ALUMINUM_BRONZE_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZE_DAGGER.get(), EPItems.ALUMINUM_BRONZE_DAGGER.get());

            //Brass
            aluminumSmithingTemplate(consumer, EPItems.BRASS_AXE.get(), EPItems.ALUMINUM_BRASS_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRASS_PICKAXE.get(), EPItems.ALUMINUM_BRASS_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRASS_SHOVEL.get(), EPItems.ALUMINUM_BRASS_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.BRASS_HOE.get(), EPItems.ALUMINUM_BRASS_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRASS_POLISHER.get(), EPItems.ALUMINUM_BRASS_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.BRASS_DAGGER.get(), EPItems.ALUMINUM_BRASS_DAGGER.get());

            //Rose Gold
            aluminumSmithingTemplate(consumer, EPItems.ROSE_GOLDEN_AXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.ROSE_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.ROSE_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.ROSE_GOLDEN_HOE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.ROSE_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.ROSE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

            //Bronzium
            aluminumSmithingTemplate(consumer, EPItems.BRONZIUM_AXE.get(), EPItems.ALUMINUM_BRONZIUM_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZIUM_PICKAXE.get(), EPItems.ALUMINUM_BRONZIUM_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZIUM_SHOVEL.get(), EPItems.ALUMINUM_BRONZIUM_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZIUM_HOE.get(), EPItems.ALUMINUM_BRONZIUM_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZIUM_POLISHER.get(), EPItems.ALUMINUM_BRONZIUM_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.BRONZIUM_DAGGER.get(), EPItems.ALUMINUM_BRONZIUM_DAGGER.get());

            //Steel
            aluminumSmithingTemplate(consumer, EPItems.STEEL_AXE.get(), EPItems.ALUMINUM_STEEL_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.STEEL_PICKAXE.get(), EPItems.ALUMINUM_STEEL_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.STEEL_SHOVEL.get(), EPItems.ALUMINUM_STEEL_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.STEEL_HOE.get(), EPItems.ALUMINUM_STEEL_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.STEEL_POLISHER.get(), EPItems.ALUMINUM_STEEL_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.STEEL_DAGGER.get(), EPItems.ALUMINUM_STEEL_DAGGER.get());

            //Green Gold
            aluminumSmithingTemplate(consumer, EPItems.GREEN_GOLDEN_AXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.GREEN_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.GREEN_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.GREEN_GOLDEN_HOE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.GREEN_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.GREEN_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

            //Blue Gold
            aluminumSmithingTemplate(consumer, EPItems.BLUE_GOLDEN_AXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BLUE_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
            aluminumSmithingTemplate(consumer, EPItems.BLUE_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
            aluminumSmithingTemplate(consumer, EPItems.BLUE_GOLDEN_HOE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.BLUE_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.BLUE_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

            //Diamond
            aluminumSmithingTemplate(consumer, Items.DIAMOND_AXE, EPItems.ALUMINUM_DIAMOND_AXE.get());
            aluminumSmithingTemplate(consumer, Items.DIAMOND_PICKAXE, EPItems.ALUMINUM_DIAMOND_PICKAXE.get());
            aluminumSmithingTemplate(consumer, Items.DIAMOND_SHOVEL, EPItems.ALUMINUM_DIAMOND_SHOVEL.get());
            aluminumSmithingTemplate(consumer, Items.DIAMOND_HOE, EPItems.ALUMINUM_DIAMOND_HOE.get());
            aluminumSmithingTemplate(consumer, EPItems.DIAMOND_POLISHER.get(), EPItems.ALUMINUM_DIAMOND_POLISHER.get());
            aluminumSmithingTemplate(consumer, EPItems.DIAMOND_DAGGER.get(), EPItems.ALUMINUM_DIAMOND_DAGGER.get());

        //Rose gold upgrade
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_HELMET, EPItems.ROSE_GOLDEN_HELMET.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_CHESTPLATE, EPItems.ROSE_GOLDEN_CHESTPLATE.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_LEGGINGS, EPItems.ROSE_GOLDEN_LEGGINGS.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_BOOTS, EPItems.ROSE_GOLDEN_BOOTS.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.ROSE_GOLDEN_PICKAXE.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.ROSE_GOLDEN_AXE.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.ROSE_GOLDEN_SWORD.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.ROSE_GOLDEN_SHOVEL.get());
        roseGoldenSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.ROSE_GOLDEN_HOE.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_AXE.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SWORD.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_ROSE_GOLDEN_HOE.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER.get());
        roseGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER.get());

        //Green gold upgrade
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_HELMET, EPItems.GREEN_GOLDEN_HELMET.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_CHESTPLATE, EPItems.GREEN_GOLDEN_CHESTPLATE.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_LEGGINGS, EPItems.GREEN_GOLDEN_LEGGINGS.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_BOOTS, EPItems.GREEN_GOLDEN_BOOTS.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.GREEN_GOLDEN_PICKAXE.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.GREEN_GOLDEN_AXE.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.GREEN_GOLDEN_SWORD.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.GREEN_GOLDEN_SHOVEL.get());
        greenGoldenSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.GREEN_GOLDEN_HOE.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_AXE.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SWORD.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_GREEN_GOLDEN_HOE.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER.get());
        greenGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER.get());

        //Blue gold upgrade
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_HELMET, EPItems.BLUE_GOLDEN_HELMET.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_CHESTPLATE, EPItems.BLUE_GOLDEN_CHESTPLATE.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_LEGGINGS, EPItems.BLUE_GOLDEN_LEGGINGS.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_BOOTS, EPItems.BLUE_GOLDEN_BOOTS.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_PICKAXE, EPItems.BLUE_GOLDEN_PICKAXE.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_AXE, EPItems.BLUE_GOLDEN_AXE.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_SWORD, EPItems.BLUE_GOLDEN_SWORD.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_SHOVEL, EPItems.BLUE_GOLDEN_SHOVEL.get());
        blueGoldenSmithingUpgrade(consumer, Items.GOLDEN_HOE, EPItems.BLUE_GOLDEN_HOE.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_POLISHER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_PICKAXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_AXE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_AXE.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SWORD.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SWORD.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_SHOVEL.get(), EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_HOE.get(), EPItems.ALUMINUM_BLUE_GOLDEN_HOE.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_POLISHER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER.get());
        blueGoldenSmithingUpgrade(consumer, EPItems.ALUMINUM_GOLDEN_DAGGER.get(), EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER.get());

        //Netherite
        smithingUpgrade(consumer, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, EPItems.DIAMOND_POLISHER.get(),
                Items.NETHERITE_INGOT, EPItems.NETHERITE_POLISHER.get());
        smithingUpgrade(consumer, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, EPItems.DIAMOND_DAGGER.get(),
                Items.NETHERITE_INGOT, EPItems.NETHERITE_DAGGER.get());
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

        //Soul
        stoneCutting(consumer, EPBlocks.SOUL_MUD_BRICKS.get(), EPBlocks.SOUL_MUD_BRICK_SLAB.get(), 2);
        stoneCutting(consumer, EPBlocks.SOUL_MUD_BRICKS.get(), EPBlocks.SOUL_MUD_BRICK_STAIRS.get(), 1);
        stoneCutting(consumer, EPBlocks.SOUL_MUD_BRICKS.get(), EPBlocks.SOUL_MUD_BRICK_WALL.get(), 1);

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
        //Misc
        primalItemGrinding(consumer, EPItems.YERBA_MATE.get(), "grounded_yerba_mate", EPItems.GROUNDED_YERBA_MATE.get(), 2);
        mechanicalItemGrinding(consumer, EPItems.YERBA_MATE.get(), "grounded_yerba_mate", EPItems.GROUNDED_YERBA_MATE.get(), 4);

        primalItemGrinding(consumer, EPItems.WALNUT.get(), "peeled_walnut", EPItems.PEELED_WALNUT.get(), 2);
        mechanicalItemGrinding(consumer, EPItems.WALNUT.get(), "peeled_walnut", EPItems.PEELED_WALNUT.get(), 4);

        primalItemGrinding(consumer, Items.WHEAT, "wheat_flour", EPItems.WHEAT_FLOUR.get(), 2);
        mechanicalItemGrinding(consumer, Items.WHEAT, "wheat_flour", EPItems.WHEAT_FLOUR.get(), 4);

        primalItemGrinding(consumer, Items.PUMPKIN, "pumpkin_flour", EPItems.PUMPKIN_FLOUR.get(), 2);
        mechanicalItemGrinding(consumer, Items.PUMPKIN, "pumpkin_flour", EPItems.PUMPKIN_FLOUR.get(), 4);

        primalItemGrinding(consumer, Items.SUGAR_CANE, "sugar", Items.SUGAR, 2);
        mechanicalItemGrinding(consumer, Items.SUGAR_CANE, "sugar", Items.SUGAR, 3);

        primalItemGrinding(consumer, Items.BONE, "bone_meal", Items.BONE_MEAL, 2);
        mechanicalItemGrinding(consumer, Items.BONE, "bone_meal", Items.BONE_MEAL, 3);

        primalItemGrinding(consumer, ItemTags.WOOL, "string", Items.STRING, 2);
        mechanicalItemGrinding(consumer, ItemTags.WOOL, "string", Items.STRING, 4);

        //Cobble
        primalItemGrinding(consumer, Blocks.COBBLESTONE, "cobble", EPItems.COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.COBBLESTONE, "cobble", EPItems.COBBLE.get(), 4);

        primalItemGrinding(consumer, EPBlocks.COBBLED_LIMESTONE.get(), "limestone_cobble", EPItems.LIMESTONE_COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, EPBlocks.COBBLED_LIMESTONE.get(), "limestone_cobble", EPItems.LIMESTONE_COBBLE.get(), 4);

        mechanicalItemGrinding(consumer, Blocks.COBBLED_DEEPSLATE, "deepslate_cobble", EPItems.DEEPSLATE_COBBLE.get(), 2);

        primalItemGrinding(consumer, Blocks.BLACKSTONE, "blackstone_cobble", EPItems.BLACKSTONE_COBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.BLACKSTONE, "blackstone_cobble", EPItems.BLACKSTONE_COBBLE.get(), 4);

        primalItemGrinding(consumer, Blocks.NETHERRACK, "netherrack_rubble", EPItems.NETHERRACK_RUBBLE.get(), 2);
        mechanicalItemGrinding(consumer, Blocks.NETHERRACK, "netherrack_rubble", EPItems.NETHERRACK_RUBBLE.get(), 4);

        //Reeds
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
            primalItemGrinding(consumer, EPItems.LIME.get(), "lime_dye", Items.LIME_DYE, 2);
            mechanicalItemGrinding(consumer, EPItems.LIME.get(), "lime_dye", Items.LIME_DYE, 3);

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
        mechanicalItemGrinding(consumer, EPTags.Items.GOLD_MANUFACTURABLE, "gold_dust", EPItems.GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.SILVER_MANUFACTURABLE, "silver_dust", EPItems.SILVER_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.ALUMINUM_MANUFACTURABLE, "aluminum_dust", EPItems.ALUMINUM_DUST.get(), 1);

        primalItemGrinding(consumer, EPTags.Items.ZINC_MANUFACTURABLE, "zinc_dust", EPItems.ZINC_DUST.get(), 1);
        mechanicalItemGrinding(consumer, EPTags.Items.ZINC_MANUFACTURABLE, "zinc_dust", EPItems.ZINC_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.TIN_MANUFACTURABLE, "tin_dust", EPItems.TIN_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.TIN_MANUFACTURABLE, "tin_dust", EPItems.TIN_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.COPPER_MANUFACTURABLE, "copper_dust", EPItems.COPPER_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.COPPER_MANUFACTURABLE, "copper_dust", EPItems.COPPER_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BRASS_MANUFACTURABLE, "brass_dust", EPItems.BRASS_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.BRASS_MANUFACTURABLE, "brass_dust", EPItems.BRASS_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BRONZE_MANUFACTURABLE, "bronze_dust", EPItems.BRONZE_DUST.get(), 1);
        primalItemGrinding(consumer, EPTags.Items.BRONZE_MANUFACTURABLE, "bronze_dust", EPItems.BRONZE_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.ROSE_GOLD_MANUFACTURABLE, "rose_gold_dust", EPItems.ROSE_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.IRON_MANUFACTURABLE, "iron_dust", EPItems.IRON_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BRONZIUM_MANUFACTURABLE, "bronzium_dust", EPItems.BRONZIUM_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.GREEN_GOLD_MANUFACTURABLE, "green_gold_dust", EPItems.GREEN_GOLD_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.STEEL_MANUFACTURABLE, "steel_dust", EPItems.STEEL_DUST.get(), 1);

        mechanicalItemGrinding(consumer, EPTags.Items.BLUE_GOLD_MANUFACTURABLE, "blue_gold_dust", EPItems.BLUE_GOLD_DUST.get(), 1);
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

    protected static void aluminumSmithingTemplate(Consumer<FinishedRecipe> consumer, ItemLike baseItem, ItemLike aluminizedItem){
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
                oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.GRIND, EPRecipes.PRIMAL_GRIND_SERIALIZER.get(), "from_primal_grinding");
            }
            protected static void primalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
                oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.GRIND, EPRecipes.PRIMAL_GRIND_SERIALIZER.get(), "from_primal_grinding");
            }

            //Mechanical
            protected static void mechanicalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result, int count){
                oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.MECHANICAL_GRIND, EPRecipes.MECHANICAL_GRIND_SERIALIZER.get(), "from_mechanical_grinding");
            }
            protected static void mechanicalItemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
                oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipeCategory.MECHANICAL_GRIND, EPRecipes.MECHANICAL_GRIND_SERIALIZER.get(), "from_mechanical_grinding");
            }

    //Polish
    protected static void gemPolishing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result){
        gemPolishingSerialize(pFinishedRecipeConsumer, ingredient, result, group);
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
