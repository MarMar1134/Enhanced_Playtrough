package net.marmar.enhanced_playthrough.datagen.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.item.custom.tool.CustomToolItem;
import net.marmar.enhanced_playthrough.item.custom.tool.HandleTier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class EPItemModelProvider extends ItemModelProvider {
    public EPItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedPlaythrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Blocks with item
            //Polished stone
            blockWithItem(EPBlocks.POLISHED_STONE_SLAB);
            blockWithItem(EPBlocks.POLISHED_STONE_STAIRS);
            wallItem(EPBlocks.POLISHED_STONE_WALL, EPBlocks.POLISHED_STONE);

            //Cobbled limestone
            blockWithItem(EPBlocks.COBBLED_LIMESTONE_SLAB);
            blockWithItem(EPBlocks.COBBLED_LIMESTONE_STAIRS);
            wallItem(EPBlocks.COBBLED_LIMESTONE_WALL, EPBlocks.COBBLED_LIMESTONE);

            //Limestone
            blockWithItem(EPBlocks.LIMESTONE_SLAB);
            blockWithItem(EPBlocks.LIMESTONE_STAIRS);
            wallItem(EPBlocks.LIMESTONE_WALL, EPBlocks.LIMESTONE);

            //Polished limestone
            blockWithItem(EPBlocks.POLISHED_LIMESTONE_SLAB);
            blockWithItem(EPBlocks.POLISHED_LIMESTONE_STAIRS);
            wallItem(EPBlocks.POLISHED_LIMESTONE_WALL, EPBlocks.POLISHED_LIMESTONE);

            //Limestone bricks
            blockWithItem(EPBlocks.LIMESTONE_BRICK_SLAB);
            blockWithItem(EPBlocks.LIMESTONE_BRICK_STAIRS);
            wallItem(EPBlocks.LIMESTONE_BRICK_WALL, EPBlocks.LIMESTONE_BRICKS);

            //Cobbled soulstone
            blockWithItem(EPBlocks.COBBLED_SOULSTONE_SLAB);
            blockWithItem(EPBlocks.COBBLED_SOULSTONE_STAIRS);
            wallItem(EPBlocks.COBBLED_SOULSTONE_WALL, EPBlocks.COBBLED_SOULSTONE);

            //soulstone
            blockWithItem(EPBlocks.SOULSTONE_SLAB);
            blockWithItem(EPBlocks.SOULSTONE_STAIRS);
            wallItem(EPBlocks.SOULSTONE_WALL, EPBlocks.SOULSTONE);

            //soulstone bricks
            blockWithItem(EPBlocks.SOULSTONE_BRICK_SLAB);
            blockWithItem(EPBlocks.SOULSTONE_BRICK_STAIRS);
            wallItem(EPBlocks.SOULSTONE_BRICK_WALL, EPBlocks.SOULSTONE_BRICKS);

            //Firebrick
            blockWithItem(EPBlocks.FIREBRICKS);
            blockWithItem(EPBlocks.FIREBRICK_SLAB);
            blockWithItem(EPBlocks.FIREBRICK_STAIRS);
            wallItem(EPBlocks.FIREBRICK_WALL, EPBlocks.FIREBRICKS);

            //Wood
                //walnut
                saplingAndCropItem(EPBlocks.WALNUT_SAPLING);

                simpleBlockItem(EPBlocks.WALNUT_DOOR);
                trapdoorItem(EPBlocks.WALNUT_TRAPDOOR);

                buttonItem(EPBlocks.WALNUT_BUTTON, EPBlocks.WALNUT_PLANKS);

                blockWithItem(EPBlocks.WALNUT_PRESSURE_PLATE);

                blockWithItem(EPBlocks.WALNUT_SLAB);
                blockWithItem(EPBlocks.WALNUT_STAIRS);
                fenceItem(EPBlocks.WALNUT_FENCE, EPBlocks.WALNUT_PLANKS);
                blockWithItem(EPBlocks.WALNUT_FENCEGATE);

                simpleItem(EPItems.WALNUT_SIGN);
                simpleItem(EPItems.WALNUT_HANGING_SIGN);

                simpleItem(EPItems.WALNUT_BOAT);
                simpleItem(EPItems.WALNUT_CHEST_BOAT);

                //Apple
                saplingAndCropItem(EPBlocks.APPLE_SAPLING);
                saplingAndCropItem(EPBlocks.GREEN_APPLE_SAPLING);

                leavesWithFruitItem(EPBlocks.APPLE_LEAVES_WITH_FRUIT);
                leavesWithFruitItem(EPBlocks.GREEN_APPLE_LEAVES_WITH_FRUIT);

                simpleBlockItem(EPBlocks.APPLE_DOOR);
                trapdoorItem(EPBlocks.APPLE_TRAPDOOR);

                buttonItem(EPBlocks.APPLE_BUTTON, EPBlocks.APPLE_PLANKS);

                blockWithItem(EPBlocks.APPLE_PRESSURE_PLATE);

                blockWithItem(EPBlocks.APPLE_SLAB);
                blockWithItem(EPBlocks.APPLE_STAIRS);

                fenceItem(EPBlocks.APPLE_FENCE, EPBlocks.APPLE_PLANKS);
                blockWithItem(EPBlocks.APPLE_FENCEGATE);

                simpleItem(EPItems.APPLE_SIGN);
                simpleItem(EPItems.APPLE_HANGING_SIGN);

                simpleItem(EPItems.APPLE_BOAT);
                simpleItem(EPItems.APPLE_CHEST_BOAT);

                //Orange
                saplingAndCropItem(EPBlocks.ORANGE_SAPLING);

                leavesWithFruitItem(EPBlocks.ORANGE_LEAVES_WITH_FRUIT);

                simpleBlockItem(EPBlocks.ORANGE_DOOR);
                trapdoorItem(EPBlocks.ORANGE_TRAPDOOR);

                buttonItem(EPBlocks.ORANGE_BUTTON, EPBlocks.ORANGE_PLANKS);

                blockWithItem(EPBlocks.ORANGE_PRESSURE_PLATE);

                blockWithItem(EPBlocks.ORANGE_SLAB);
                blockWithItem(EPBlocks.ORANGE_STAIRS);

                fenceItem(EPBlocks.ORANGE_FENCE, EPBlocks.ORANGE_PLANKS);
                blockWithItem(EPBlocks.ORANGE_FENCEGATE);

                simpleItem(EPItems.ORANGE_SIGN);
                simpleItem(EPItems.ORANGE_HANGING_SIGN);

                simpleItem(EPItems.ORANGE_BOAT);
                simpleItem(EPItems.ORANGE_CHEST_BOAT);

                //Lemon
                saplingAndCropItem(EPBlocks.LEMON_SAPLING);

                leavesWithFruitItem(EPBlocks.LEMON_LEAVES_WITH_FRUIT);

                simpleBlockItem(EPBlocks.LEMON_DOOR);
                trapdoorItem(EPBlocks.LEMON_TRAPDOOR);

                buttonItem(EPBlocks.LEMON_BUTTON, EPBlocks.LEMON_PLANKS);

                blockWithItem(EPBlocks.LEMON_PRESSURE_PLATE);

                blockWithItem(EPBlocks.LEMON_SLAB);
                blockWithItem(EPBlocks.LEMON_STAIRS);

                fenceItem(EPBlocks.LEMON_FENCE, EPBlocks.LEMON_PLANKS);
                blockWithItem(EPBlocks.LEMON_FENCEGATE);

                simpleItem(EPItems.LEMON_SIGN);
                simpleItem(EPItems.LEMON_HANGING_SIGN);

                simpleItem(EPItems.LEMON_BOAT);
                simpleItem(EPItems.LEMON_CHEST_BOAT);

                //Lime
                saplingAndCropItem(EPBlocks.LIME_SAPLING);

                leavesWithFruitItem(EPBlocks.LIME_LEAVES_WITH_FRUIT);

        //Calibrated quartz
        blockWithItem(EPBlocks.CALIBRATED_QUARTZ_BLOCK);
        blockWithItem(EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK);
        blockWithItem(EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK);
        blockWithItem(EPBlocks.CALIBRATED_QUARTZ_PILLAR);

        //Wild crops
        doubleBlockItem(EPBlocks.WILD_CORN_CROP);
        saplingAndCropItem(EPBlocks.WILD_WHEAT_CROP);
        saplingAndCropItem(EPBlocks.WILD_TOMATO_CROP);

        //Plants
        saplingAndCropItem(EPBlocks.SMALL_REEDS);
        doubleBlockWithAgeItem(EPBlocks.REEDS);
        doubleBlockWithAgeItem(EPBlocks.KENAF);
        doubleBlockWithAgeItem(EPBlocks.TALL_REEDS);
        doubleBlockItem(EPBlocks.WATER_REEDS);

        //Flowers
        saplingAndCropItem(EPBlocks.COLD_LYRIUM);
        saplingAndCropItem(EPBlocks.SUCCULENT);

        //Block entities
        blockWithItem(EPBlocks.ADOBE_FURNACE);
        blockWithItem(EPBlocks.SOUL_FURNACE);

        blockWithItem(EPBlocks.MASONRY_FURNACE);

        blockWithItem(EPBlocks.ADOBE_ALLOY_FURNACE);
        blockWithItem(EPBlocks.SUPER_ALLOY_FURNACE);

        blockWithItem(EPBlocks.GEM_POLISHER);

        blockWithItem(EPBlocks.PRIMAL_GRINDER);
        blockWithItem(EPBlocks.MECHANICAL_GRINDER);

        simpleBlockItem(EPBlocks.GROWTH_DETECTOR);

        blockWithItem(EPBlocks.ALCHEMICAL_DUPLICATOR);

        blockWithItem(EPBlocks.LEATHERWORKER_STATION);

        //Food
        simpleItem(EPItems.ROTTEN_CARROT);

        simpleItem(EPItems.RICE_GRAINS);
        simpleItem(EPItems.RICE_BOWL);

        simpleItem(EPItems.YERBA_MATE);
        simpleItem(EPItems.GROUNDED_YERBA_MATE);
        simpleItem(EPItems.MATE);
        simpleItem(EPItems.EMPTY_MATE);

        simpleItem(EPItems.ZAPALLO);
        simpleItem(EPItems.ROTTEN_ZAPALLO);
        simpleItem(EPItems.COOKED_ZAPALLO);

        simpleItem(EPItems.EGGPLANT);
        simpleItem(EPItems.ROTTEN_EGGPLANT);
        simpleItem(EPItems.COOKED_EGGPLANT);

        simpleItem(EPItems.WILD_TOMATO);
        simpleItem(EPItems.TOMATO);
        simpleItem(EPItems.ROTTEN_TOMATO);

        simpleItem(EPItems.WILD_CORN);
        simpleItem(EPItems.CORN);
        simpleItem(EPItems.ROTTEN_CORN);
        simpleItem(EPItems.COOKED_CORN);

        simpleItem(EPItems.RAW_ROTTEN_STEW);
        simpleItem(EPItems.ROTTEN_STEW);

        simpleItem(EPItems.WHEAT_FLOUR);

        simpleItem(EPItems.PUMPKIN_FLOUR);

        simpleItem(EPItems.YEAST);

        simpleItem(EPItems.GREEN_APPLE);

        simpleItem(EPItems.ORANGE);

        simpleItem(EPItems.LEMON);

        simpleItem(EPItems.LIME_FRUIT);

        simpleItem(EPItems.WALNUT);
        simpleItem(EPItems.PEELED_WALNUT);

        //Seeds
        simpleItem(EPItems.YERBA_MATE_SEEDS);

        simpleItem(EPItems.ZAPALLO_SEEDS);

        simpleItem(EPItems.EGGPLANT_SEEDS);

        simpleItem(EPItems.TOMATO_SEEDS);

        simpleItem(EPItems.CORN_SEEDS);

        //Ores
        simpleItem(EPItems.SULFUR);

        simpleItem(EPItems.COPPER_NUGGET);

        simpleItem(EPItems.RAW_TIN);
        simpleItem(EPItems.TIN_INGOT);
        simpleItem(EPItems.TIN_NUGGET);

        simpleItem(EPItems.RAW_ZINC);
        simpleItem(EPItems.ZINC_INGOT);
        simpleItem(EPItems.ZINC_NUGGET);

        simpleItem(EPItems.BRASS_INGOT);
        simpleItem(EPItems.BRASS_NUGGET);

        simpleItem(EPItems.BRONZE_INGOT);
        simpleItem(EPItems.BRONZE_NUGGET);

        simpleItem(EPItems.STEEL_INGOT);
        simpleItem(EPItems.STEEL_NUGGET);

        simpleItem(EPItems.RAW_SILVER);
        simpleItem(EPItems.SILVER_INGOT);
        simpleItem(EPItems.SILVER_NUGGET);

        simpleItem(EPItems.RAW_ALUMINUM);
        simpleItem(EPItems.ALUMINUM_INGOT);
        simpleItem(EPItems.ALUMINUM_NUGGET);

        simpleItem(EPItems.ROSE_GOLD_INGOT);
        simpleItem(EPItems.ROSE_GOLD_NUGGET);

        simpleItem(EPItems.BRONZIUM_INGOT);
        simpleItem(EPItems.BRONZIUM_NUGGET);

        simpleItem(EPItems.GREEN_GOLD_INGOT);
        simpleItem(EPItems.GREEN_GOLD_NUGGET);

        simpleItem(EPItems.BLUE_GOLD_INGOT);
        simpleItem(EPItems.BLUE_GOLD_NUGGET);

        simpleItem(EPItems.PURPLE_GOLD_INGOT);
        simpleItem(EPItems.PURPLE_GOLD_NUGGET);

        //Gems
        simpleItem(EPItems.RAW_RUBY);
        simpleItem(EPItems.RAW_SAPPHIRE);
        simpleItem(EPItems.RAW_GARNET);
        simpleItem(EPItems.RAW_EMERALD);
        simpleItem(EPItems.RAW_DIAMOND);
        simpleItem(EPItems.COBALT);

        simpleItem(EPItems.RUBY);
        simpleItem(EPItems.SAPPHIRE);
        simpleItem(EPItems.GARNET);

        //Dusts
        simpleItem(EPItems.GOLD_DUST);
        simpleItem(EPItems.SILVER_DUST);
        simpleItem(EPItems.ALUMINUM_DUST);
        simpleItem(EPItems.ZINC_DUST);
        simpleItem(EPItems.TIN_DUST);
        simpleItem(EPItems.COPPER_DUST);
        simpleItem(EPItems.BRASS_DUST);
        simpleItem(EPItems.BRONZE_DUST);
        simpleItem(EPItems.ROSE_GOLD_DUST);
        simpleItem(EPItems.IRON_DUST);
        simpleItem(EPItems.BRONZIUM_DUST);
        simpleItem(EPItems.GREEN_GOLD_DUST);
        simpleItem(EPItems.STEEL_DUST);
        simpleItem(EPItems.BLUE_GOLD_DUST);
        simpleItem(EPItems.PURPLE_GOLD_DUST);

        //Manufactured
        simpleItem(EPItems.CALIBRATED_QUARTZ);

        //templates
        simpleItem(EPItems.REINFORCED_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(EPItems.BRONZIUM_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(EPItems.ALUMINUM_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(EPItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE);

        //Cobble
        simpleItem(EPItems.COBBLE);
        simpleItem(EPItems.LIMESTONE_COBBLE);
        simpleItem(EPItems.DEEPSLATE_COBBLE);
        simpleItem(EPItems.NETHERRACK_RUBBLE);
        simpleItem(EPItems.BLACKSTONE_COBBLE);
        simpleItem(EPItems.SOULSTONE_COBBLE);

        //Terracotta Shards
        simpleItem(EPItems.TERRACOTTA_SHARD);
        simpleItem(EPItems.WHITE_TERRACOTTA_SHARD);
        simpleItem(EPItems.ORANGE_TERRACOTTA_SHARD);
        simpleItem(EPItems.MAGENTA_TERRACOTTA_SHARD);
        simpleItem(EPItems.LIGHT_BLUE_TERRACOTTA_SHARD);
        simpleItem(EPItems.YELLOW_TERRACOTTA_SHARD);
        simpleItem(EPItems.LIME_TERRACOTTA_SHARD);
        simpleItem(EPItems.PINK_TERRACOTTA_SHARD);
        simpleItem(EPItems.GRAY_TERRACOTTA_SHARD);
        simpleItem(EPItems.LIGHT_GRAY_TERRACOTTA_SHARD);
        simpleItem(EPItems.CYAN_TERRACOTTA_SHARD);
        simpleItem(EPItems.PURPLE_TERRACOTTA_SHARD);
        simpleItem(EPItems.BLUE_TERRACOTTA_SHARD);
        simpleItem(EPItems.BROWN_TERRACOTTA_SHARD);
        simpleItem(EPItems.GREEN_TERRACOTTA_SHARD);
        simpleItem(EPItems.RED_TERRACOTTA_SHARD);
        simpleItem(EPItems.BLACK_TERRACOTTA_SHARD);

        //Rods
        simpleItem(EPItems.REINFORCED_STICK);
        simpleItem(EPItems.ALUMINUM_ROD);
        simpleItem(EPItems.PURPLE_GOLD_ROD);

        //Other materials
        simpleItem(EPItems.MUD_BRICK);
        simpleItem(EPItems.FIREBRICK);
        simpleItem(EPItems.LEATHER_STRIPS);
        simpleItem(EPItems.PLANT_FIBER);
        simpleItem(EPItems.REEDS_HEAD);
        simpleItem(EPItems.KENAF_BRANCH);
        simpleItem(EPItems.TALL_REEDS_HEAD);
        simpleItem(EPItems.WATER_REEDS_HEAD);
        simpleItem(EPItems.LIME);

        //Hide
        simpleItem(EPItems.COW_HIDE);
        simpleItem(EPItems.PIG_HIDE);
        simpleItem(EPItems.WERELLAGER_HIDE);

        //Spawn eggs
        spawnEggItem(EPItems.BANDIT_SPAWN_EGG);
        spawnEggItem(EPItems.ZOMBIE_KNIGHT_SPAWN_EGG);
        spawnEggItem(EPItems.SKELETON_BOWMASTER_SPAWN_EGG);
        spawnEggItem(EPItems.WERELLAGER_SPAWN_EGG);

        //Armors and tools
            //Other tools
            handheldItem(EPItems.FLINT_AND_COBBLE);
            handheldItem(EPItems.FLINT_AND_BRONZE);

            //Arrows
            simpleItem(EPItems.ALUMINUM_ARROW);

            //Wood
            handheldItem(EPItems.WOODEN_DAGGER);

            //Gold
            polisherItem(EPItems.GOLDEN_POLISHER, "golden");
            daggerItem(EPItems.GOLDEN_DAGGER, "golden");
                // Reinforced handle gold
                swordItem(EPItems.REINFORCED_GOLDEN_SWORD, "golden");
                daggerItem(EPItems.REINFORCED_GOLDEN_DAGGER, "golden");
                pickaxeItem(EPItems.REINFORCED_GOLDEN_PICKAXE, "golden");
                axeItem(EPItems.REINFORCED_GOLDEN_AXE, "golden");
                shovelItem(EPItems.REINFORCED_GOLDEN_SHOVEL, "golden");
                hoeItem(EPItems.REINFORCED_GOLDEN_HOE, "golden");
                polisherItem(EPItems.REINFORCED_GOLDEN_POLISHER, "golden");
                //Aluminum handle gold
                swordItem(EPItems.ALUMINUM_GOLDEN_SWORD, "golden");
                daggerItem(EPItems.ALUMINUM_GOLDEN_DAGGER, "golden");
                pickaxeItem(EPItems.ALUMINUM_GOLDEN_PICKAXE, "golden");
                axeItem(EPItems.ALUMINUM_GOLDEN_AXE, "golden");
                shovelItem(EPItems.ALUMINUM_GOLDEN_SHOVEL, "golden");
                 hoeItem(EPItems.ALUMINUM_GOLDEN_HOE, "golden");
                 polisherItem(EPItems.ALUMINUM_GOLDEN_POLISHER, "golden");
                 //Purple gold handle gold
                 swordItem(EPItems.PURPLE_GOLD_GOLDEN_SWORD, "golden");
                 daggerItem(EPItems.PURPLE_GOLD_GOLDEN_DAGGER, "golden");
                 pickaxeItem(EPItems.PURPLE_GOLD_GOLDEN_PICKAXE, "golden");
                 axeItem(EPItems.PURPLE_GOLD_GOLDEN_AXE, "golden");
                 shovelItem(EPItems.PURPLE_GOLD_GOLDEN_SHOVEL, "golden");
                 hoeItem(EPItems.PURPLE_GOLD_GOLDEN_HOE, "golden");
                 polisherItem(EPItems.PURPLE_GOLD_GOLDEN_POLISHER, "golden");

            //Silver
            swordItem(EPItems.SILVER_SWORD, "silver");
            daggerItem(EPItems.SILVER_DAGGER, "silver");
            pickaxeItem(EPItems.SILVER_PICKAXE, "silver");
            axeItem(EPItems.SILVER_AXE, "silver");
            shovelItem(EPItems.SILVER_SHOVEL, "silver");
            hoeItem(EPItems.SILVER_HOE, "silver");
            polisherItem(EPItems.SILVER_POLISHER, "silver");
                // Reinforced handle silver
                swordItem(EPItems.REINFORCED_SILVER_SWORD, "silver");
                daggerItem(EPItems.REINFORCED_SILVER_DAGGER, "silver");
                pickaxeItem(EPItems.REINFORCED_SILVER_PICKAXE, "silver");
                axeItem(EPItems.REINFORCED_SILVER_AXE, "silver");
                shovelItem(EPItems.REINFORCED_SILVER_SHOVEL, "silver");
                hoeItem(EPItems.REINFORCED_SILVER_HOE, "silver");
                polisherItem(EPItems.REINFORCED_SILVER_POLISHER, "silver");
                //Aluminum handle silver
                swordItem(EPItems.ALUMINUM_SILVER_SWORD, "silver");
                daggerItem(EPItems.ALUMINUM_SILVER_DAGGER, "silver");
                pickaxeItem(EPItems.ALUMINUM_SILVER_PICKAXE, "silver");
                axeItem(EPItems.ALUMINUM_SILVER_AXE, "silver");
                shovelItem(EPItems.ALUMINUM_SILVER_SHOVEL, "silver");
                 hoeItem(EPItems.ALUMINUM_SILVER_HOE, "silver");
                 polisherItem(EPItems.ALUMINUM_SILVER_POLISHER, "silver");
                 //Purple gold handle silver
                 swordItem(EPItems.PURPLE_GOLD_SILVER_SWORD, "silver");
                 daggerItem(EPItems.PURPLE_GOLD_SILVER_DAGGER, "silver");
                 pickaxeItem(EPItems.PURPLE_GOLD_SILVER_PICKAXE, "silver");
                 axeItem(EPItems.PURPLE_GOLD_SILVER_AXE, "silver");
                 shovelItem(EPItems.PURPLE_GOLD_SILVER_SHOVEL, "silver");
                 hoeItem(EPItems.PURPLE_GOLD_SILVER_HOE, "silver");
                 polisherItem(EPItems.PURPLE_GOLD_SILVER_POLISHER, "silver");

            trimmedArmorItem(EPItems.SILVER_HELMET);
            trimmedArmorItem(EPItems.SILVER_CHESTPLATE);
            trimmedArmorItem(EPItems.SILVER_LEGGINGS);
            trimmedArmorItem(EPItems.SILVER_BOOTS);

            //Stone
            handheldItem(EPItems.STONE_POLISHER);
            handheldItem(EPItems.STONE_DAGGER);

            //Bronze
            swordItem(EPItems.BRONZE_SWORD, "bronze");
            daggerItem(EPItems.BRONZE_DAGGER, "bronze");
            pickaxeItem(EPItems.BRONZE_PICKAXE, "bronze");
            axeItem(EPItems.BRONZE_AXE, "bronze");
            shovelItem(EPItems.BRONZE_SHOVEL, "bronze");
            hoeItem(EPItems.BRONZE_HOE, "bronze");
            polisherItem(EPItems.BRONZE_POLISHER, "bronze");
                //Reinforced handle bronze
                swordItem(EPItems.REINFORCED_BRONZE_SWORD, "bronze");
                daggerItem(EPItems.REINFORCED_BRONZE_DAGGER, "bronze");
                pickaxeItem(EPItems.REINFORCED_BRONZE_PICKAXE, "bronze");
                axeItem(EPItems.REINFORCED_BRONZE_AXE, "bronze");
                shovelItem(EPItems.REINFORCED_BRONZE_SHOVEL, "bronze");
                hoeItem(EPItems.REINFORCED_BRONZE_HOE, "bronze");
                polisherItem(EPItems.REINFORCED_BRONZE_POLISHER, "bronze");
                //Aluminum handle bronze
                swordItem(EPItems.ALUMINUM_BRONZE_SWORD, "bronze");
                daggerItem(EPItems.ALUMINUM_BRONZE_DAGGER, "bronze");
                pickaxeItem(EPItems.ALUMINUM_BRONZE_PICKAXE, "bronze");
                axeItem(EPItems.ALUMINUM_BRONZE_AXE, "bronze");
                shovelItem(EPItems.ALUMINUM_BRONZE_SHOVEL, "bronze");
                 hoeItem(EPItems.ALUMINUM_BRONZE_HOE, "bronze");
                 polisherItem(EPItems.ALUMINUM_BRONZE_POLISHER, "bronze");
                 //Purple gold handle bronze
                 swordItem(EPItems.PURPLE_GOLD_BRONZE_SWORD, "bronze");
                 daggerItem(EPItems.PURPLE_GOLD_BRONZE_DAGGER, "bronze");
                 pickaxeItem(EPItems.PURPLE_GOLD_BRONZE_PICKAXE, "bronze");
                 axeItem(EPItems.PURPLE_GOLD_BRONZE_AXE, "bronze");
                 shovelItem(EPItems.PURPLE_GOLD_BRONZE_SHOVEL, "bronze");
                 hoeItem(EPItems.PURPLE_GOLD_BRONZE_HOE, "bronze");
                 polisherItem(EPItems.PURPLE_GOLD_BRONZE_POLISHER, "bronze");

            trimmedArmorItem(EPItems.BRONZE_HELMET);
            trimmedArmorItem(EPItems.BRONZE_CHESTPLATE);
            trimmedArmorItem(EPItems.BRONZE_LEGGINGS);
            trimmedArmorItem(EPItems.BRONZE_BOOTS);

            //Brass
            swordItem(EPItems.BRASS_SWORD, "brass");
            daggerItem(EPItems.BRASS_DAGGER, "brass");
            pickaxeItem(EPItems.BRASS_PICKAXE, "brass");
            axeItem(EPItems.BRASS_AXE, "brass");
            shovelItem(EPItems.BRASS_SHOVEL, "brass");
            hoeItem(EPItems.BRASS_HOE, "brass");
            polisherItem(EPItems.BRASS_POLISHER, "brass");
                //Reinforced handle brass
                swordItem(EPItems.REINFORCED_BRASS_SWORD, "brass");
                daggerItem(EPItems.REINFORCED_BRASS_DAGGER, "brass");
                pickaxeItem(EPItems.REINFORCED_BRASS_PICKAXE, "brass");
                axeItem(EPItems.REINFORCED_BRASS_AXE, "brass");
                shovelItem(EPItems.REINFORCED_BRASS_SHOVEL, "brass");
                hoeItem(EPItems.REINFORCED_BRASS_HOE, "brass");
                polisherItem(EPItems.REINFORCED_BRASS_POLISHER, "brass");
                //Aluminum handle brass
                swordItem(EPItems.ALUMINUM_BRASS_SWORD, "brass");
                daggerItem(EPItems.ALUMINUM_BRASS_DAGGER, "brass");
                pickaxeItem(EPItems.ALUMINUM_BRASS_PICKAXE, "brass");
                axeItem(EPItems.ALUMINUM_BRASS_AXE, "brass");
                shovelItem(EPItems.ALUMINUM_BRASS_SHOVEL, "brass");
                 hoeItem(EPItems.ALUMINUM_BRASS_HOE, "brass");
                 polisherItem(EPItems.ALUMINUM_BRASS_POLISHER, "brass");
                 //Purple gold handle brass
                 swordItem(EPItems.PURPLE_GOLD_BRASS_SWORD, "brass");
                 daggerItem(EPItems.PURPLE_GOLD_BRASS_DAGGER, "brass");
                 pickaxeItem(EPItems.PURPLE_GOLD_BRASS_PICKAXE, "brass");
                 axeItem(EPItems.PURPLE_GOLD_BRASS_AXE, "brass");
                 shovelItem(EPItems.PURPLE_GOLD_BRASS_SHOVEL, "brass");
                 hoeItem(EPItems.PURPLE_GOLD_BRASS_HOE, "brass");
                 polisherItem(EPItems.PURPLE_GOLD_BRASS_POLISHER, "brass");

            trimmedArmorItem(EPItems.BRASS_HELMET);
            trimmedArmorItem(EPItems.BRASS_CHESTPLATE);
            trimmedArmorItem(EPItems.BRASS_LEGGINGS);
            trimmedArmorItem(EPItems.BRASS_BOOTS);

            //Rose Gold
            swordItem(EPItems.ROSE_GOLDEN_SWORD, "rose_golden");
            daggerItem(EPItems.ROSE_GOLDEN_DAGGER, "rose_golden");
            pickaxeItem(EPItems.ROSE_GOLDEN_PICKAXE, "rose_golden");
            axeItem(EPItems.ROSE_GOLDEN_AXE, "rose_golden");
            shovelItem(EPItems.ROSE_GOLDEN_SHOVEL, "rose_golden");
            hoeItem(EPItems.ROSE_GOLDEN_HOE, "rose_golden");
            polisherItem(EPItems.ROSE_GOLDEN_POLISHER, "rose_golden");
                //Reinforced handle rose gold
                swordItem(EPItems.REINFORCED_ROSE_GOLDEN_SWORD, "rose_golden");
                daggerItem(EPItems.REINFORCED_ROSE_GOLDEN_DAGGER, "rose_golden");
                pickaxeItem(EPItems.REINFORCED_ROSE_GOLDEN_PICKAXE, "rose_golden");
                axeItem(EPItems.REINFORCED_ROSE_GOLDEN_AXE, "rose_golden");
                shovelItem(EPItems.REINFORCED_ROSE_GOLDEN_SHOVEL, "rose_golden");
                hoeItem(EPItems.REINFORCED_ROSE_GOLDEN_HOE, "rose_golden");
                polisherItem(EPItems.REINFORCED_ROSE_GOLDEN_POLISHER, "rose_golden");
                //Aluminum handle rose gold
                swordItem(EPItems.ALUMINUM_ROSE_GOLDEN_SWORD, "rose_golden");
                daggerItem(EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER, "rose_golden");
                pickaxeItem(EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE, "rose_golden");
                axeItem(EPItems.ALUMINUM_ROSE_GOLDEN_AXE, "rose_golden");
                shovelItem(EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL, "rose_golden");
                 hoeItem(EPItems.ALUMINUM_ROSE_GOLDEN_HOE, "rose_golden");
                 polisherItem(EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER, "rose_golden");
                 //Purple gold handle rose gold
                 swordItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_SWORD, "rose_golden");
                 daggerItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_DAGGER, "rose_golden");
                 pickaxeItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_PICKAXE, "rose_golden");
                 axeItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_AXE, "rose_golden");
                 shovelItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_SHOVEL, "rose_golden");
                 hoeItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_HOE, "rose_golden");
                 polisherItem(EPItems.PURPLE_GOLD_ROSE_GOLDEN_POLISHER, "rose_golden");

            trimmedArmorItem(EPItems.ROSE_GOLDEN_HELMET);
            trimmedArmorItem(EPItems.ROSE_GOLDEN_CHESTPLATE);
            trimmedArmorItem(EPItems.ROSE_GOLDEN_LEGGINGS);
            trimmedArmorItem(EPItems.ROSE_GOLDEN_BOOTS);

            //Bronzium
            swordItem(EPItems.BRONZIUM_SWORD, "bronzium");
            daggerItem(EPItems.BRONZIUM_DAGGER, "bronzium");
            pickaxeItem(EPItems.BRONZIUM_PICKAXE, "bronzium");
            axeItem(EPItems.BRONZIUM_AXE, "bronzium");
            shovelItem(EPItems.BRONZIUM_SHOVEL, "bronzium");
            hoeItem(EPItems.BRONZIUM_HOE, "bronzium");
            polisherItem(EPItems.BRONZIUM_POLISHER, "bronzium");
                //Reinforced handle bronzium
                swordItem(EPItems.REINFORCED_BRONZIUM_SWORD, "bronzium");
                daggerItem(EPItems.REINFORCED_BRONZIUM_DAGGER, "bronzium");
                pickaxeItem(EPItems.REINFORCED_BRONZIUM_PICKAXE, "bronzium");
                axeItem(EPItems.REINFORCED_BRONZIUM_AXE, "bronzium");
                shovelItem(EPItems.REINFORCED_BRONZIUM_SHOVEL, "bronzium");
                hoeItem(EPItems.REINFORCED_BRONZIUM_HOE, "bronzium");
                polisherItem(EPItems.REINFORCED_BRONZIUM_POLISHER, "bronzium");
                //Aluminum handle bronzium
                swordItem(EPItems.ALUMINUM_BRONZIUM_SWORD, "bronzium");
                daggerItem(EPItems.ALUMINUM_BRONZIUM_DAGGER, "bronzium");
                pickaxeItem(EPItems.ALUMINUM_BRONZIUM_PICKAXE, "bronzium");
                axeItem(EPItems.ALUMINUM_BRONZIUM_AXE, "bronzium");
                shovelItem(EPItems.ALUMINUM_BRONZIUM_SHOVEL, "bronzium");
                 hoeItem(EPItems.ALUMINUM_BRONZIUM_HOE, "bronzium");
                 polisherItem(EPItems.ALUMINUM_BRONZIUM_POLISHER, "bronzium");
                 //Purple gold handle bronzium
                 swordItem(EPItems.PURPLE_GOLD_BRONZIUM_SWORD, "bronzium");
                 daggerItem(EPItems.PURPLE_GOLD_BRONZIUM_DAGGER, "bronzium");
                 pickaxeItem(EPItems.PURPLE_GOLD_BRONZIUM_PICKAXE, "bronzium");
                 axeItem(EPItems.PURPLE_GOLD_BRONZIUM_AXE, "bronzium");
                 shovelItem(EPItems.PURPLE_GOLD_BRONZIUM_SHOVEL, "bronzium");
                 hoeItem(EPItems.PURPLE_GOLD_BRONZIUM_HOE, "bronzium");
                 polisherItem(EPItems.PURPLE_GOLD_BRONZIUM_POLISHER, "bronzium");

            trimmedArmorItem(EPItems.BRONZIUM_HELMET);
            trimmedArmorItem(EPItems.BRONZIUM_CHESTPLATE);
            trimmedArmorItem(EPItems.BRONZIUM_LEGGINGS);
            trimmedArmorItem(EPItems.BRONZIUM_BOOTS);

            //Iron
            handheldItem(EPItems.IRON_POLISHER);
            handheldItem(EPItems.IRON_DAGGER);
                //Reinforced handle iron
                swordItem(EPItems.REINFORCED_IRON_SWORD, "iron");
                daggerItem(EPItems.REINFORCED_IRON_DAGGER, "iron");
                pickaxeItem(EPItems.REINFORCED_IRON_PICKAXE, "iron");
                axeItem(EPItems.REINFORCED_IRON_AXE, "iron");
                shovelItem(EPItems.REINFORCED_IRON_SHOVEL, "iron");
                hoeItem(EPItems.REINFORCED_IRON_HOE, "iron");
                polisherItem(EPItems.REINFORCED_IRON_POLISHER, "iron");
                //Aluminum handle iron
                swordItem(EPItems.ALUMINUM_IRON_SWORD, "iron");
                daggerItem(EPItems.ALUMINUM_IRON_DAGGER, "iron");
                pickaxeItem(EPItems.ALUMINUM_IRON_PICKAXE, "iron");
                axeItem(EPItems.ALUMINUM_IRON_AXE, "iron");
                shovelItem(EPItems.ALUMINUM_IRON_SHOVEL, "iron");
                 hoeItem(EPItems.ALUMINUM_IRON_HOE, "iron");
                 polisherItem(EPItems.ALUMINUM_IRON_POLISHER, "iron");
                 //Purple gold handle iron
                 swordItem(EPItems.PURPLE_GOLD_IRON_SWORD, "iron");
                 daggerItem(EPItems.PURPLE_GOLD_IRON_DAGGER, "iron");
                 pickaxeItem(EPItems.PURPLE_GOLD_IRON_PICKAXE, "iron");
                 axeItem(EPItems.PURPLE_GOLD_IRON_AXE, "iron");
                 shovelItem(EPItems.PURPLE_GOLD_IRON_SHOVEL, "iron");
                 hoeItem(EPItems.PURPLE_GOLD_IRON_HOE, "iron");
                 polisherItem(EPItems.PURPLE_GOLD_IRON_POLISHER, "iron");

            //Steel
            swordItem(EPItems.STEEL_SWORD, "steel");
            daggerItem(EPItems.STEEL_DAGGER, "steel");
            pickaxeItem(EPItems.STEEL_PICKAXE, "steel");
            axeItem(EPItems.STEEL_AXE, "steel");
            shovelItem(EPItems.STEEL_SHOVEL, "steel");
            hoeItem(EPItems.STEEL_HOE, "steel");
            polisherItem(EPItems.STEEL_POLISHER, "steel");
                //Reinforced handle steel
                swordItem(EPItems.REINFORCED_STEEL_SWORD, "steel");
                daggerItem(EPItems.REINFORCED_STEEL_DAGGER, "steel");
                pickaxeItem(EPItems.REINFORCED_STEEL_PICKAXE, "steel");
                axeItem(EPItems.REINFORCED_STEEL_AXE, "steel");
                shovelItem(EPItems.REINFORCED_STEEL_SHOVEL, "steel");
                hoeItem(EPItems.REINFORCED_STEEL_HOE, "steel");
                polisherItem(EPItems.REINFORCED_STEEL_POLISHER, "steel");
                //Aluminum handle steel
                swordItem(EPItems.ALUMINUM_STEEL_SWORD, "steel");
                daggerItem(EPItems.ALUMINUM_STEEL_DAGGER, "steel");
                pickaxeItem(EPItems.ALUMINUM_STEEL_PICKAXE, "steel");
                axeItem(EPItems.ALUMINUM_STEEL_AXE, "steel");
                shovelItem(EPItems.ALUMINUM_STEEL_SHOVEL, "steel");
                 hoeItem(EPItems.ALUMINUM_STEEL_HOE, "steel");
                 polisherItem(EPItems.ALUMINUM_STEEL_POLISHER, "steel");
                 //Purple gold handle steel
                 swordItem(EPItems.PURPLE_GOLD_STEEL_SWORD, "steel");
                 daggerItem(EPItems.PURPLE_GOLD_STEEL_DAGGER, "steel");
                 pickaxeItem(EPItems.PURPLE_GOLD_STEEL_PICKAXE, "steel");
                 axeItem(EPItems.PURPLE_GOLD_STEEL_AXE, "steel");
                 shovelItem(EPItems.PURPLE_GOLD_STEEL_SHOVEL, "steel");
                 hoeItem(EPItems.PURPLE_GOLD_STEEL_HOE, "steel");
                 polisherItem(EPItems.PURPLE_GOLD_STEEL_POLISHER, "steel");

            trimmedArmorItem(EPItems.STEEL_HELMET);
            trimmedArmorItem(EPItems.STEEL_CHESTPLATE);
            trimmedArmorItem(EPItems.STEEL_LEGGINGS);
            trimmedArmorItem(EPItems.STEEL_BOOTS);

            //Green Gold
            swordItem(EPItems.GREEN_GOLDEN_SWORD, "green_golden");
            daggerItem(EPItems.GREEN_GOLDEN_DAGGER, "green_golden");
            pickaxeItem(EPItems.GREEN_GOLDEN_PICKAXE, "green_golden");
            axeItem(EPItems.GREEN_GOLDEN_AXE, "green_golden");
            shovelItem(EPItems.GREEN_GOLDEN_SHOVEL, "green_golden");
            hoeItem(EPItems.GREEN_GOLDEN_HOE, "green_golden");
            polisherItem(EPItems.GREEN_GOLDEN_POLISHER, "green_golden");
                //Reinforced handle green gold
                swordItem(EPItems.REINFORCED_GREEN_GOLDEN_SWORD, "green_golden");
                daggerItem(EPItems.REINFORCED_GREEN_GOLDEN_DAGGER, "green_golden");
                pickaxeItem(EPItems.REINFORCED_GREEN_GOLDEN_PICKAXE, "green_golden");
                axeItem(EPItems.REINFORCED_GREEN_GOLDEN_AXE, "green_golden");
                shovelItem(EPItems.REINFORCED_GREEN_GOLDEN_SHOVEL, "green_golden");
                hoeItem(EPItems.REINFORCED_GREEN_GOLDEN_HOE, "green_golden");
                polisherItem(EPItems.REINFORCED_GREEN_GOLDEN_POLISHER, "green_golden");
                //Aluminum handle green gold
                swordItem(EPItems.ALUMINUM_GREEN_GOLDEN_SWORD, "green_golden");
                daggerItem(EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER, "green_golden");
                pickaxeItem(EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE, "green_golden");
                axeItem(EPItems.ALUMINUM_GREEN_GOLDEN_AXE, "green_golden");
                shovelItem(EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL, "green_golden");
                 hoeItem(EPItems.ALUMINUM_GREEN_GOLDEN_HOE, "green_golden");
                 polisherItem(EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER, "green_golden");
                 //Purple gold handle green gold
                 swordItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_SWORD, "green_golden");
                 daggerItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_DAGGER, "green_golden");
                 pickaxeItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_PICKAXE, "green_golden");
                 axeItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_AXE, "green_golden");
                 shovelItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_SHOVEL, "green_golden");
                 hoeItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_HOE, "green_golden");
                 polisherItem(EPItems.PURPLE_GOLD_GREEN_GOLDEN_POLISHER, "green_golden");

            trimmedArmorItem(EPItems.GREEN_GOLDEN_HELMET);
            trimmedArmorItem(EPItems.GREEN_GOLDEN_CHESTPLATE);
            trimmedArmorItem(EPItems.GREEN_GOLDEN_LEGGINGS);
            trimmedArmorItem(EPItems.GREEN_GOLDEN_BOOTS);

            //Blue gold
            swordItem(EPItems.BLUE_GOLDEN_SWORD, "blue_golden");
            daggerItem(EPItems.BLUE_GOLDEN_DAGGER, "blue_golden");
            pickaxeItem(EPItems.BLUE_GOLDEN_PICKAXE, "blue_golden");
            axeItem(EPItems.BLUE_GOLDEN_AXE, "blue_golden");
            shovelItem(EPItems.BLUE_GOLDEN_SHOVEL, "blue_golden");
            hoeItem(EPItems.BLUE_GOLDEN_HOE, "blue_golden");
            polisherItem(EPItems.BLUE_GOLDEN_POLISHER, "blue_golden");
                //Reinforced handle blue gold
                swordItem(EPItems.REINFORCED_BLUE_GOLDEN_SWORD, "blue_golden");
                daggerItem(EPItems.REINFORCED_BLUE_GOLDEN_DAGGER, "blue_golden");
                pickaxeItem(EPItems.REINFORCED_BLUE_GOLDEN_PICKAXE, "blue_golden");
                axeItem(EPItems.REINFORCED_BLUE_GOLDEN_AXE, "blue_golden");
                shovelItem(EPItems.REINFORCED_BLUE_GOLDEN_SHOVEL, "blue_golden");
                hoeItem(EPItems.REINFORCED_BLUE_GOLDEN_HOE, "blue_golden");
                polisherItem(EPItems.REINFORCED_BLUE_GOLDEN_POLISHER, "blue_golden");
                //Aluminum handle blue gold
                swordItem(EPItems.ALUMINUM_BLUE_GOLDEN_SWORD, "blue_golden");
                daggerItem(EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER, "blue_golden");
                pickaxeItem(EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE, "blue_golden");
                axeItem(EPItems.ALUMINUM_BLUE_GOLDEN_AXE, "blue_golden");
                shovelItem(EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL, "blue_golden");
                 hoeItem(EPItems.ALUMINUM_BLUE_GOLDEN_HOE, "blue_golden");
                 polisherItem(EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER, "blue_golden");
                 //Purple gold handle blue gold
                 swordItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_SWORD, "blue_golden");
                 daggerItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_DAGGER, "blue_golden");
                 pickaxeItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_PICKAXE, "blue_golden");
                 axeItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_AXE, "blue_golden");
                 shovelItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_SHOVEL, "blue_golden");
                 hoeItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_HOE, "blue_golden");
                 polisherItem(EPItems.PURPLE_GOLD_BLUE_GOLDEN_POLISHER, "blue_golden");

            trimmedArmorItem(EPItems.BLUE_GOLDEN_HELMET);
            trimmedArmorItem(EPItems.BLUE_GOLDEN_CHESTPLATE);
            trimmedArmorItem(EPItems.BLUE_GOLDEN_LEGGINGS);
            trimmedArmorItem(EPItems.BLUE_GOLDEN_BOOTS);

            //Diamond
            handheldItem(EPItems.DIAMOND_POLISHER);
            handheldItem(EPItems.DIAMOND_DAGGER);
                //Reinforced handle diamond
                swordItem(EPItems.REINFORCED_DIAMOND_SWORD, "diamond");
                daggerItem(EPItems.REINFORCED_DIAMOND_DAGGER, "diamond");
                pickaxeItem(EPItems.REINFORCED_DIAMOND_PICKAXE, "diamond");
                axeItem(EPItems.REINFORCED_DIAMOND_AXE, "diamond");
                shovelItem(EPItems.REINFORCED_DIAMOND_SHOVEL, "diamond");
                hoeItem(EPItems.REINFORCED_DIAMOND_HOE, "diamond");
                polisherItem(EPItems.REINFORCED_DIAMOND_POLISHER, "diamond");
                //Aluminum handle diamond
                swordItem(EPItems.ALUMINUM_DIAMOND_SWORD, "diamond");
                daggerItem(EPItems.ALUMINUM_DIAMOND_DAGGER, "diamond");
                pickaxeItem(EPItems.ALUMINUM_DIAMOND_PICKAXE, "diamond");
                axeItem(EPItems.ALUMINUM_DIAMOND_AXE, "diamond");
                shovelItem(EPItems.ALUMINUM_DIAMOND_SHOVEL, "diamond");
                 hoeItem(EPItems.ALUMINUM_DIAMOND_HOE, "diamond");
                 polisherItem(EPItems.ALUMINUM_DIAMOND_POLISHER, "diamond");
                 //Purple gold handle diamond
                 swordItem(EPItems.PURPLE_GOLD_DIAMOND_SWORD, "diamond");
                 daggerItem(EPItems.PURPLE_GOLD_DIAMOND_DAGGER, "diamond");
                 pickaxeItem(EPItems.PURPLE_GOLD_DIAMOND_PICKAXE, "diamond");
                 axeItem(EPItems.PURPLE_GOLD_DIAMOND_AXE, "diamond");
                 shovelItem(EPItems.PURPLE_GOLD_DIAMOND_SHOVEL, "diamond");
                 hoeItem(EPItems.PURPLE_GOLD_DIAMOND_HOE, "diamond");
                 polisherItem(EPItems.PURPLE_GOLD_DIAMOND_POLISHER, "diamond");

            //Netherite
            handheldItem(EPItems.NETHERITE_POLISHER);
            handheldItem(EPItems.NETHERITE_DAGGER);
        }

    private void swordItem(RegistryObject<Item> pSword, String pTier){
        if (!(pSword.get() instanceof CustomToolItem.Sword sword)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = sword.getHandleTier();

            this.withExistingParent(pSword.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_sword"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_sword"));
        }
    }

    private void daggerItem(RegistryObject<Item> pDagger, String pTier){
        if (!(pDagger.get() instanceof CustomToolItem.Dagger dagger)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = dagger.getHandleTier();

            this.withExistingParent(pDagger.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_dagger"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_sword"));
        }
    }

    private void axeItem(RegistryObject<Item> pAxe, String pTier){
        if (!(pAxe.get() instanceof CustomToolItem.Axe axe)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = axe.getHandleTier();

            this.withExistingParent(pAxe.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_axe"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_axe"));
        }
    }

    private void pickaxeItem(RegistryObject<Item> pPickaxe, String pTier){
        if (!(pPickaxe.get() instanceof CustomToolItem.Pickaxe pickaxe)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = pickaxe.getHandleTier();

            this.withExistingParent(pPickaxe.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_pickaxe"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_pickaxe"));
        }
    }

    private void shovelItem(RegistryObject<Item> pShovel, String pTier){
        if (!(pShovel.get() instanceof CustomToolItem.Shovel shovel)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = shovel.getHandleTier();

            this.withExistingParent(pShovel.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_shovel"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_shovel"));
        }
    }

    private void hoeItem(RegistryObject<Item> pHoe, String pTier){
        if (!(pHoe.get() instanceof CustomToolItem.Hoe hoe)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = hoe.getHandleTier();

            this.withExistingParent(pHoe.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_hoe"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_hoe"));
        }
    }

    private void polisherItem(RegistryObject<Item> pPolisher, String pTier){
        if (!(pPolisher.get() instanceof CustomToolItem.Polisher polisher)){
            throw new RuntimeException("The item passed must match argument");
        } else {
            HandleTier handleTier = polisher.getHandleTier();

            this.withExistingParent(pPolisher.getId().getPath(), mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + pTier + "_polisher"))
                    .texture("layer1", modLoc("item/handle/" + handleTier.getLiteral() + "_polisher"));
        }
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> pArmor) {
        if(pArmor.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {

                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = modLoc(armorItemPath);
                ResourceLocation trimResLoc = mcLoc(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = modLoc(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(pArmor.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                modLoc("item/" + pArmor.getId().getPath()));
            });
        }
    }
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture ("layer0",
                modLoc("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/handheld")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder spawnEggItem(RegistryObject<Item> pItem){
        return withExistingParent(pItem.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public void blockWithItem(RegistryObject<Block> block) {
        this.withExistingParent(EnhancedPlaythrough.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder doubleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture ("layer0",
                modLoc("block/" + item.getId().getPath() + "_upper"));
    }

    private ItemModelBuilder doubleBlockWithAgeItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("block/" + item.getId().getPath() + "_upper_1"));
    }

    private ItemModelBuilder leavesWithFruitItem(RegistryObject<Block> item){
        return withExistingParent(EnhancedPlaythrough.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(item.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(item.get()).getPath() + "_1"));
    }

    private ItemModelBuilder saplingAndCropItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("block/" + item.getId().getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",   modLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",   modLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",   modLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",   modLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }
}