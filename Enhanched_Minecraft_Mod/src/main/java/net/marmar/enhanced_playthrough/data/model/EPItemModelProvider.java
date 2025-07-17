package net.marmar.enhanced_playthrough.data.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.item.EPItems;
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

@SuppressWarnings({"nullable"})
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

            //Soul
            blockWithItem(EPBlocks.SOUL_MUD_BRICK_SLAB);
            blockWithItem(EPBlocks.SOUL_MUD_BRICK_STAIRS);
            wallItem(EPBlocks.SOUL_MUD_BRICK_WALL, EPBlocks.SOUL_MUD_BRICKS);

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

        //Wild crops
        doubleBlockItem(EPBlocks.WILD_CORN);
        saplingAndCropItem(EPBlocks.WILD_WHEAT);
        saplingAndCropItem(EPBlocks.WILD_TOMATO);

        //Plants
        saplingAndCropItem(EPBlocks.SMALL_REEDS);
        doubleBlockItem(EPBlocks.REEDS);
        doubleBlockItem(EPBlocks.TALL_REEDS);
        doubleBlockItem(EPBlocks.WATER_REEDS);

        //Flowers
        saplingAndCropItem(EPBlocks.COLD_LYRIUM);
        saplingAndCropItem(EPBlocks.SUCCULENT);

        //Food
        simpleItem(EPItems.RICE_GRAINS);
        simpleItem(EPItems.RICE_BOWL);
        simpleItem(EPItems.YERBA_MATE);

        simpleItem(EPItems.GROUNDED_YERBA_MATE);
        simpleItem(EPItems.MATE);
        simpleItem(EPItems.EMPTY_MATE);

        simpleItem(EPItems.ZAPALLO);
        simpleItem(EPItems.COOKED_ZAPALLO);

        simpleItem(EPItems.EGGPLANT);
        simpleItem(EPItems.COOKED_EGGPLANT);

        simpleItem(EPItems.WILD_TOMATO);
        simpleItem(EPItems.TOMATO);

        simpleItem(EPItems.WILD_CORN);
        simpleItem(EPItems.CORN);
        simpleItem(EPItems.COOKED_CORN);

        simpleItem(EPItems.WHEAT_FLOUR);

        simpleItem(EPItems.PUMPKIN_FLOUR);

        simpleItem(EPItems.YEAST);

        simpleItem(EPItems.GREEN_APPLE);

        simpleItem(EPItems.ORANGE);

        simpleItem(EPItems.LEMON);

        simpleItem(EPItems.LIME);

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

        //templates
        simpleItem(EPItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE);
        simpleItem(EPItems.ALUMINUM_SMITHING_UPGRADE_TEMPLATE);

        //Cobble
        simpleItem(EPItems.COBBLE);
        simpleItem(EPItems.LIMESTONE_COBBLE);
        simpleItem(EPItems.DEEPSLATE_COBBLE);
        simpleItem(EPItems.NETHERRACK_RUBBLE);
        simpleItem(EPItems.BLACKSTONE_COBBLE);

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

        //Other materials
        simpleItem(EPItems.MUD_BRICK);
        simpleItem(EPItems.FIREBRICK);
        simpleItem(EPItems.ALUMINUM_ROD);
        simpleItem(EPItems.VEGETABLE_FIBBER);
        simpleItem(EPItems.REED_HEAD);
        simpleItem(EPItems.WATER_REED_HEAD);

        //Spawn eggs
        spawnEggItem(EPItems.BANDIT_SPAWN_EGG);

        //Armors and tools
            //Other tools
            handheldItem(EPItems.FLINT_AND_COBBLE);
            handheldItem(EPItems.FLINT_AND_BRONZE);

            //Wood
            handheldItem(EPItems.WOODEN_DAGGER);
                //Aluminum wood
                handheldItem(EPItems.ALUMINUM_WOODEN_SWORD);
                handheldItem(EPItems.ALUMINUM_WOODEN_DAGGER);
                handheldItem(EPItems.ALUMINUM_WOODEN_PICKAXE);
                handheldItem(EPItems.ALUMINUM_WOODEN_AXE);
                handheldItem(EPItems.ALUMINUM_WOODEN_SHOVEL);
                handheldItem(EPItems.ALUMINUM_WOODEN_HOE);

            //Gold
            handheldItem(EPItems.GOLDEN_POLISHER);
            handheldItem(EPItems.GOLDEN_DAGGER);
                //Aluminum gold
                handheldItem(EPItems.ALUMINUM_GOLDEN_SWORD);
                handheldItem(EPItems.ALUMINUM_GOLDEN_DAGGER);
                handheldItem(EPItems.ALUMINUM_GOLDEN_PICKAXE);
                handheldItem(EPItems.ALUMINUM_GOLDEN_AXE);
                handheldItem(EPItems.ALUMINUM_GOLDEN_SHOVEL);
                handheldItem(EPItems.ALUMINUM_GOLDEN_HOE);
                handheldItem(EPItems.ALUMINUM_GOLDEN_POLISHER);

            //Silver
            handheldItem(EPItems.SILVER_SWORD);
            handheldItem(EPItems.SILVER_DAGGER);
            handheldItem(EPItems.SILVER_PICKAXE);
            handheldItem(EPItems.SILVER_AXE);
            handheldItem(EPItems.SILVER_SHOVEL);
            handheldItem(EPItems.SILVER_HOE);
            handheldItem(EPItems.SILVER_POLISHER);
                //Aluminum silver
                handheldItem(EPItems.ALUMINUM_SILVER_SWORD);
                handheldItem(EPItems.ALUMINUM_SILVER_DAGGER);
                handheldItem(EPItems.ALUMINUM_SILVER_PICKAXE);
                handheldItem(EPItems.ALUMINUM_SILVER_AXE);
                handheldItem(EPItems.ALUMINUM_SILVER_SHOVEL);
                handheldItem(EPItems.ALUMINUM_SILVER_HOE);
                handheldItem(EPItems.ALUMINUM_SILVER_POLISHER);

            trimmedArmorItem(EPItems.SILVER_HELMET);
            trimmedArmorItem(EPItems.SILVER_CHESTPLATE);
            trimmedArmorItem(EPItems.SILVER_LEGGINGS);
            trimmedArmorItem(EPItems.SILVER_BOOTS);

            //Stone
            handheldItem(EPItems.STONE_POLISHER);
            handheldItem(EPItems.STONE_DAGGER);
                //Aluminum stone
                handheldItem(EPItems.ALUMINUM_STONE_SWORD);
                handheldItem(EPItems.ALUMINUM_STONE_DAGGER);
                handheldItem(EPItems.ALUMINUM_STONE_PICKAXE);
                handheldItem(EPItems.ALUMINUM_STONE_AXE);
                handheldItem(EPItems.ALUMINUM_STONE_SHOVEL);
                handheldItem(EPItems.ALUMINUM_STONE_HOE);
                handheldItem(EPItems.ALUMINUM_STONE_POLISHER);

            //Bronze
            handheldItem(EPItems.BRONZE_SWORD);
            handheldItem(EPItems.BRONZE_DAGGER);
            handheldItem(EPItems.BRONZE_PICKAXE);
            handheldItem(EPItems.BRONZE_AXE);
            handheldItem(EPItems.BRONZE_SHOVEL);
            handheldItem(EPItems.BRONZE_HOE);
            handheldItem(EPItems.BRONZE_POLISHER);
                //Aluminum bronze
                handheldItem(EPItems.ALUMINUM_BRONZE_SWORD);
                handheldItem(EPItems.ALUMINUM_BRONZE_DAGGER);
                handheldItem(EPItems.ALUMINUM_BRONZE_PICKAXE);
                handheldItem(EPItems.ALUMINUM_BRONZE_AXE);
                handheldItem(EPItems.ALUMINUM_BRONZE_SHOVEL);
                handheldItem(EPItems.ALUMINUM_BRONZE_HOE);
                handheldItem(EPItems.ALUMINUM_BRONZE_POLISHER);

            trimmedArmorItem(EPItems.BRONZE_HELMET);
            trimmedArmorItem(EPItems.BRONZE_CHESTPLATE);
            trimmedArmorItem(EPItems.BRONZE_LEGGINGS);
            trimmedArmorItem(EPItems.BRONZE_BOOTS);

            //Brass
            handheldItem(EPItems.BRASS_SWORD);
            handheldItem(EPItems.BRASS_DAGGER);
            handheldItem(EPItems.BRASS_PICKAXE);
            handheldItem(EPItems.BRASS_AXE);
            handheldItem(EPItems.BRASS_SHOVEL);
            handheldItem(EPItems.BRASS_HOE);
            handheldItem(EPItems.BRASS_POLISHER);
                //Aluminum brass
                handheldItem(EPItems.ALUMINUM_BRASS_SWORD);
                handheldItem(EPItems.ALUMINUM_BRASS_DAGGER);
                handheldItem(EPItems.ALUMINUM_BRASS_PICKAXE);
                handheldItem(EPItems.ALUMINUM_BRASS_AXE);
                handheldItem(EPItems.ALUMINUM_BRASS_SHOVEL);
                handheldItem(EPItems.ALUMINUM_BRASS_HOE);
                handheldItem(EPItems.ALUMINUM_BRASS_POLISHER);

            trimmedArmorItem(EPItems.BRASS_HELMET);
            trimmedArmorItem(EPItems.BRASS_CHESTPLATE);
            trimmedArmorItem(EPItems.BRASS_LEGGINGS);
            trimmedArmorItem(EPItems.BRASS_BOOTS);

            //Rose Gold
            handheldItem(EPItems.ROSE_GOLDEN_SWORD);
            handheldItem(EPItems.ROSE_GOLDEN_DAGGER);
            handheldItem(EPItems.ROSE_GOLDEN_PICKAXE);
            handheldItem(EPItems.ROSE_GOLDEN_AXE);
            handheldItem(EPItems.ROSE_GOLDEN_SHOVEL);
            handheldItem(EPItems.ROSE_GOLDEN_HOE);
            handheldItem(EPItems.ROSE_GOLDEN_POLISHER);
                //Aluminum rose gold
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_SWORD);
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_DAGGER);
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_PICKAXE);
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_AXE);
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_SHOVEL);
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_HOE);
                handheldItem(EPItems.ALUMINUM_ROSE_GOLDEN_POLISHER);

            trimmedArmorItem(EPItems.ROSE_GOLDEN_HELMET);
            trimmedArmorItem(EPItems.ROSE_GOLDEN_CHESTPLATE);
            trimmedArmorItem(EPItems.ROSE_GOLDEN_LEGGINGS);
            trimmedArmorItem(EPItems.ROSE_GOLDEN_BOOTS);

            //Bronzium
            handheldItem(EPItems.BRONZIUM_SWORD);
            handheldItem(EPItems.BRONZIUM_DAGGER);
            handheldItem(EPItems.BRONZIUM_PICKAXE);
            handheldItem(EPItems.BRONZIUM_AXE);
            handheldItem(EPItems.BRONZIUM_SHOVEL);
            handheldItem(EPItems.BRONZIUM_HOE);
            handheldItem(EPItems.BRONZIUM_POLISHER);
                //Aluminum bronzium
                handheldItem(EPItems.ALUMINUM_BRONZIUM_SWORD);
                handheldItem(EPItems.ALUMINUM_BRONZIUM_DAGGER);
                handheldItem(EPItems.ALUMINUM_BRONZIUM_PICKAXE);
                handheldItem(EPItems.ALUMINUM_BRONZIUM_AXE);
                handheldItem(EPItems.ALUMINUM_BRONZIUM_SHOVEL);
                handheldItem(EPItems.ALUMINUM_BRONZIUM_HOE);
                handheldItem(EPItems.ALUMINUM_BRONZIUM_POLISHER);

            trimmedArmorItem(EPItems.BRONZIUM_HELMET);
            trimmedArmorItem(EPItems.BRONZIUM_CHESTPLATE);
            trimmedArmorItem(EPItems.BRONZIUM_LEGGINGS);
            trimmedArmorItem(EPItems.BRONZIUM_BOOTS);

            //Iron
            handheldItem(EPItems.IRON_POLISHER);
            handheldItem(EPItems.IRON_DAGGER);
                //Aluminum iron
                handheldItem(EPItems.ALUMINUM_IRON_SWORD);
                handheldItem(EPItems.ALUMINUM_IRON_DAGGER);
                handheldItem(EPItems.ALUMINUM_IRON_PICKAXE);
                handheldItem(EPItems.ALUMINUM_IRON_AXE);
                handheldItem(EPItems.ALUMINUM_IRON_SHOVEL);
                handheldItem(EPItems.ALUMINUM_IRON_HOE);
                handheldItem(EPItems.ALUMINUM_IRON_POLISHER);

            //Steel
            handheldItem(EPItems.STEEL_SWORD);
            handheldItem(EPItems.STEEL_DAGGER);
            handheldItem(EPItems.STEEL_PICKAXE);
            handheldItem(EPItems.STEEL_AXE);
            handheldItem(EPItems.STEEL_SHOVEL);
            handheldItem(EPItems.STEEL_HOE);
            handheldItem(EPItems.STEEL_POLISHER);
                //Aluminum steel
                handheldItem(EPItems.ALUMINUM_STEEL_SWORD);
                handheldItem(EPItems.ALUMINUM_STEEL_DAGGER);
                handheldItem(EPItems.ALUMINUM_STEEL_PICKAXE);
                handheldItem(EPItems.ALUMINUM_STEEL_AXE);
                handheldItem(EPItems.ALUMINUM_STEEL_SHOVEL);
                handheldItem(EPItems.ALUMINUM_STEEL_HOE);
                handheldItem(EPItems.ALUMINUM_STEEL_POLISHER);

            trimmedArmorItem(EPItems.STEEL_HELMET);
            trimmedArmorItem(EPItems.STEEL_CHESTPLATE);
            trimmedArmorItem(EPItems.STEEL_LEGGINGS);
            trimmedArmorItem(EPItems.STEEL_BOOTS);

            //Green Gold
            handheldItem(EPItems.GREEN_GOLDEN_SWORD);
            handheldItem(EPItems.GREEN_GOLDEN_DAGGER);
            handheldItem(EPItems.GREEN_GOLDEN_PICKAXE);
            handheldItem(EPItems.GREEN_GOLDEN_AXE);
            handheldItem(EPItems.GREEN_GOLDEN_SHOVEL);
            handheldItem(EPItems.GREEN_GOLDEN_HOE);
            handheldItem(EPItems.GREEN_GOLDEN_POLISHER);
                //Aluminum green gold
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_SWORD);
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_DAGGER);
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_PICKAXE);
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_AXE);
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_SHOVEL);
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_HOE);
                handheldItem(EPItems.ALUMINUM_GREEN_GOLDEN_POLISHER);

            trimmedArmorItem(EPItems.GREEN_GOLDEN_HELMET);
            trimmedArmorItem(EPItems.GREEN_GOLDEN_CHESTPLATE);
            trimmedArmorItem(EPItems.GREEN_GOLDEN_LEGGINGS);
            trimmedArmorItem(EPItems.GREEN_GOLDEN_BOOTS);

            //Blue gold
            handheldItem(EPItems.BLUE_GOLDEN_SWORD);
            handheldItem(EPItems.BLUE_GOLDEN_DAGGER);
            handheldItem(EPItems.BLUE_GOLDEN_PICKAXE);
            handheldItem(EPItems.BLUE_GOLDEN_AXE);
            handheldItem(EPItems.BLUE_GOLDEN_SHOVEL);
            handheldItem(EPItems.BLUE_GOLDEN_HOE);
            handheldItem(EPItems.BLUE_GOLDEN_POLISHER);
                //Aluminum blue gold
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_SWORD);
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_DAGGER);
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_PICKAXE);
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_AXE);
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_SHOVEL);
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_HOE);
                handheldItem(EPItems.ALUMINUM_BLUE_GOLDEN_POLISHER);

            trimmedArmorItem(EPItems.BLUE_GOLDEN_HELMET);
            trimmedArmorItem(EPItems.BLUE_GOLDEN_CHESTPLATE);
            trimmedArmorItem(EPItems.BLUE_GOLDEN_LEGGINGS);
            trimmedArmorItem(EPItems.BLUE_GOLDEN_BOOTS);

            //Diamond
            handheldItem(EPItems.DIAMOND_POLISHER);
            handheldItem(EPItems.DIAMOND_DAGGER);
                //Aluminum diamond
                handheldItem(EPItems.ALUMINUM_DIAMOND_SWORD);
                handheldItem(EPItems.ALUMINUM_DIAMOND_DAGGER);
                handheldItem(EPItems.ALUMINUM_DIAMOND_PICKAXE);
                handheldItem(EPItems.ALUMINUM_DIAMOND_AXE);
                handheldItem(EPItems.ALUMINUM_DIAMOND_SHOVEL);
                handheldItem(EPItems.ALUMINUM_DIAMOND_HOE);
                handheldItem(EPItems.ALUMINUM_DIAMOND_POLISHER);

            //Netherite
            handheldItem(EPItems.NETHERITE_POLISHER);
            handheldItem(EPItems.NETHERITE_DAGGER);


        }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = EnhancedPlaythrough.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
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
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture ("layer0",
                new ResourceLocation(EnhancedPlaythrough.MOD_ID,
                        "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EnhancedPlaythrough.MOD_ID, "item/" + item.getId().getPath()));
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
                new ResourceLocation("item/generated")).texture ("layer0",
                new ResourceLocation(EnhancedPlaythrough.MOD_ID,
                        "block/" + item.getId().getPath() + "_upper"));
    }

    private ItemModelBuilder saplingAndCropItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedPlaythrough.MOD_ID,"block/" + item.getId().getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedPlaythrough.MOD_ID,"item/" + item.getId().getPath()));
    }
}