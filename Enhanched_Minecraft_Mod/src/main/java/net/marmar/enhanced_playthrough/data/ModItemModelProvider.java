package net.marmar.enhanced_playthrough.data;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedPlaythrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Blocks with item
            //Stone
            wallItem(ModBlocks.STONE_WALL, Blocks.STONE);

            //D,A,G
            wallItem(ModBlocks.POLISHED_DIORITE_WALL, Blocks.POLISHED_DIORITE);
            wallItem(ModBlocks.POLISHED_ANDESITE_WALL, Blocks.POLISHED_ANDESITE);
            wallItem(ModBlocks.POLISHED_GRANITE_WALL, Blocks.POLISHED_GRANITE);

            //Dripstone
            blockWithItem(ModBlocks.DRIPSTONE_SLAB);
            blockWithItem(ModBlocks.DRIPSTONE_STAIRS);
            wallItem(ModBlocks.DRIPSTONE_WALL, Blocks.DRIPSTONE_BLOCK);

            //Polished stone
            blockWithItem(ModBlocks.POLISHED_STONE_SLAB);
            blockWithItem(ModBlocks.POLISHED_STONE_STAIRS);
            wallItem(ModBlocks.POLISHED_STONE_WALL, ModBlocks.POLISHED_STONE);

            //Cobbled limestone
            blockWithItem(ModBlocks.COBBLED_LIMESTONE_SLAB);
            blockWithItem(ModBlocks.COBBLED_LIMESTONE_STAIRS);
            wallItem(ModBlocks.COBBLED_LIMESTONE_WALL, ModBlocks.COBBLED_LIMESTONE);

            //Limestone
            blockWithItem(ModBlocks.LIMESTONE_SLAB);
            blockWithItem(ModBlocks.LIMESTONE_STAIRS);
            wallItem(ModBlocks.LIMESTONE_WALL, ModBlocks.LIMESTONE);

            //Polished limestone
            blockWithItem(ModBlocks.POLISHED_LIMESTONE_SLAB);
            blockWithItem(ModBlocks.POLISHED_LIMESTONE_STAIRS);
            wallItem(ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.POLISHED_LIMESTONE);

            //Limestone bricks
            blockWithItem(ModBlocks.LIMESTONE_BRICK_SLAB);
            blockWithItem(ModBlocks.LIMESTONE_BRICK_STAIRS);
            wallItem(ModBlocks.LIMESTONE_BRICK_WALL, ModBlocks.LIMESTONE_BRICKS);

            //Soul
            blockWithItem(ModBlocks.SOUL_MUD_BRICK_SLAB);
            blockWithItem(ModBlocks.SOUL_MUD_BRICK_STAIRS);
            wallItem(ModBlocks.SOUL_MUD_BRICK_WALL, ModBlocks.SOUL_MUD_BRICKS);

            //Wood
                //walnut
                saplingAndCropItem(ModBlocks.WALNUT_SAPLING);

                simpleBlockItem(ModBlocks.WALNUT_DOOR);
                trapdoorItem(ModBlocks.WALNUT_TRAPDOOR);

                buttonItem(ModBlocks.WALNUT_BUTTON, ModBlocks.WALNUT_PLANKS);

                blockWithItem(ModBlocks.WALNUT_PRESSURE_PLATE);

                blockWithItem(ModBlocks.WALNUT_SLAB);
                blockWithItem(ModBlocks.WALNUT_STAIRS);
                fenceItem(ModBlocks.WALNUT_FENCE, ModBlocks.WALNUT_PLANKS);
                blockWithItem(ModBlocks.WALNUT_FENCEGATE);

                simpleItem(ModItems.WALNUT_SIGN);
                simpleItem(ModItems.WALNUT_HANGING_SIGN);

                simpleItem(ModItems.WALNUT_BOAT);
                simpleItem(ModItems.WALNUT_CHEST_BOAT);

                //Apple
                saplingAndCropItem(ModBlocks.APPLE_SAPLING);
                saplingAndCropItem(ModBlocks.GREEN_APPLE_SAPLING);

                simpleBlockItem(ModBlocks.APPLE_DOOR);
                trapdoorItem(ModBlocks.APPLE_TRAPDOOR);

                buttonItem(ModBlocks.APPLE_BUTTON, ModBlocks.APPLE_PLANKS);

                blockWithItem(ModBlocks.APPLE_PRESSURE_PLATE);

                blockWithItem(ModBlocks.APPLE_SLAB);
                blockWithItem(ModBlocks.APPLE_STAIRS);

                fenceItem(ModBlocks.APPLE_FENCE, ModBlocks.APPLE_PLANKS);
                blockWithItem(ModBlocks.APPLE_FENCEGATE);

                simpleItem(ModItems.APPLE_SIGN);
                simpleItem(ModItems.APPLE_HANGING_SIGN);

                simpleItem(ModItems.APPLE_BOAT);
                simpleItem(ModItems.APPLE_CHEST_BOAT);


                //Orange
                saplingAndCropItem(ModBlocks.ORANGE_SAPLING);

                simpleBlockItem(ModBlocks.ORANGE_DOOR);
                trapdoorItem(ModBlocks.ORANGE_TRAPDOOR);

                buttonItem(ModBlocks.ORANGE_BUTTON, ModBlocks.ORANGE_PLANKS);

                blockWithItem(ModBlocks.ORANGE_PRESSURE_PLATE);

                blockWithItem(ModBlocks.ORANGE_SLAB);
                blockWithItem(ModBlocks.ORANGE_STAIRS);

                fenceItem(ModBlocks.ORANGE_FENCE, ModBlocks.ORANGE_PLANKS);
                blockWithItem(ModBlocks.ORANGE_FENCEGATE);

                simpleItem(ModItems.ORANGE_SIGN);
                simpleItem(ModItems.ORANGE_HANGING_SIGN);

                simpleItem(ModItems.ORANGE_BOAT);
                simpleItem(ModItems.ORANGE_CHEST_BOAT);

                //Lemon
                saplingAndCropItem(ModBlocks.LEMON_SAPLING);

                simpleBlockItem(ModBlocks.LEMON_DOOR);
                trapdoorItem(ModBlocks.LEMON_TRAPDOOR);

                buttonItem(ModBlocks.LEMON_BUTTON, ModBlocks.LEMON_PLANKS);

                blockWithItem(ModBlocks.LEMON_PRESSURE_PLATE);

                blockWithItem(ModBlocks.LEMON_SLAB);
                blockWithItem(ModBlocks.LEMON_STAIRS);

                fenceItem(ModBlocks.LEMON_FENCE, ModBlocks.LEMON_PLANKS);
                blockWithItem(ModBlocks.LEMON_FENCEGATE);

                simpleItem(ModItems.LEMON_SIGN);
                simpleItem(ModItems.LEMON_HANGING_SIGN);

                simpleItem(ModItems.LEMON_BOAT);
                simpleItem(ModItems.LEMON_CHEST_BOAT);


                //Lime
                saplingAndCropItem(ModBlocks.LIME_SAPLING);

        //Wild crops
        doubleBlockItem(ModBlocks.WILD_CORN);
        saplingAndCropItem(ModBlocks.WILD_WHEAT);
        saplingAndCropItem(ModBlocks.WILD_TOMATO);

        //Plants
        doubleBlockItem(ModBlocks.WATER_REEDS);
        doubleBlockItem(ModBlocks.TALL_REEDS);
        doubleBlockItem(ModBlocks.REEDS);
        saplingAndCropItem(ModBlocks.SMALL_REEDS);

        simpleItem(ModItems.RICE_GRAINS);
        simpleItem(ModItems.RICE_BOWL);
        simpleItem(ModItems.YERBA_MATE);

        simpleItem(ModItems.GROUNDED_YERBA_MATE);
        simpleItem(ModItems.MATE);
        simpleItem(ModItems.EMPTY_MATE);

        simpleItem(ModItems.ZAPALLO);
        simpleItem(ModItems.COOKED_ZAPALLO);

        simpleItem(ModItems.EGGPLANT);
        simpleItem(ModItems.COOKED_EGGPLANT);

        simpleItem(ModItems.WILD_TOMATO);
        simpleItem(ModItems.TOMATO);

        simpleItem(ModItems.WILD_CORN);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.COOKED_CORN);

        simpleItem(ModItems.WHEAT_FLOUR);

        simpleItem(ModItems.PUMPKIN_FLOUR);

        simpleItem(ModItems.YEAST);

        simpleItem(ModItems.GREEN_APPLE);

        simpleItem(ModItems.ORANGE);

        simpleItem(ModItems.LEMON);

        simpleItem(ModItems.LIME);

        simpleItem(ModItems.WALNUT);
        simpleItem(ModItems.PEELED_WALNUT);

        //Seeds
        simpleItem(ModItems.YERBA_MATE_SEEDS);

        simpleItem(ModItems.ZAPALLO_SEEDS);

        simpleItem(ModItems.EGGPLANT_SEEDS);

        simpleItem(ModItems.TOMATO_SEEDS);

        simpleItem(ModItems.CORN_SEEDS);

        //Ores
        simpleItem(ModItems.SULFUR);

        simpleItem(ModItems.COPPER_NUGGET);

        simpleItem(ModItems.RAW_TIN);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.TIN_NUGGET);

        simpleItem(ModItems.RAW_ZINC);
        simpleItem(ModItems.ZINC_INGOT);
        simpleItem(ModItems.ZINC_NUGGET);

        simpleItem(ModItems.BRASS_INGOT);
        simpleItem(ModItems.BRASS_NUGGET);

        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.BRONZE_NUGGET);

        simpleItem(ModItems.STEEL_INGOT);

        simpleItem(ModItems.RAW_SILVER);
        simpleItem(ModItems.SILVER_INGOT);
        simpleItem(ModItems.SILVER_NUGGET);

        simpleItem(ModItems.ROSE_GOLD_INGOT);
        simpleItem(ModItems.ROSE_GOLD_NUGGET);

        simpleItem(ModItems.BRONZIUM_INGOT);
        simpleItem(ModItems.BRONZIUM_NUGGET);

        simpleItem(ModItems.GREEN_GOLD_INGOT);
        simpleItem(ModItems.GREEN_GOLD_NUGGET);

        simpleItem(ModItems.BLUE_GOLD_INGOT);
        simpleItem(ModItems.BLUE_GOLD_NUGGET);

        simpleItem(ModItems.RAW_RUBY);
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.RAW_GARNET);
        simpleItem(ModItems.RAW_EMERALD);
        simpleItem(ModItems.RAW_DIAMOND);
        simpleItem(ModItems.COBALT);

        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.GARNET);

        //Dusts
        simpleItem(ModItems.GOLD_DUST);
        simpleItem(ModItems.SILVER_DUST);
        simpleItem(ModItems.ZINC_DUST);
        simpleItem(ModItems.TIN_DUST);
        simpleItem(ModItems.COPPER_DUST);
        simpleItem(ModItems.BRASS_DUST);
        simpleItem(ModItems.BRONZE_DUST);
        simpleItem(ModItems.ROSE_GOLD_DUST);
        simpleItem(ModItems.IRON_DUST);
        simpleItem(ModItems.BRONZIUM_DUST);
        simpleItem(ModItems.GREEN_GOLD_DUST);
        simpleItem(ModItems.STEEL_DUST);
        simpleItem(ModItems.BLUE_GOLD_DUST);

        //templates
        simpleItem(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE);

        //Cobble
        simpleItem(ModItems.COBBLE);
        simpleItem(ModItems.LIMESTONE_COBBLE);
        simpleItem(ModItems.DEEPSLATE_COBBLE);
        simpleItem(ModItems.NETHERRACK_RUBBLE);
        simpleItem(ModItems.BLACKSTONE_COBBLE);

        //Other materials
        simpleItem(ModItems.MUD_BRICK);
        simpleItem(ModItems.VEGETABLE_FIBBER);
        simpleItem(ModItems.REED_HEAD);
        simpleItem(ModItems.WATER_REED_HEAD);

        //Armors and tools
            //Gold
            HandheldItem(ModItems.GOLDEN_POLISHER);

            //Silver
            HandheldItem(ModItems.SILVER_SWORD);
            HandheldItem(ModItems.SILVER_PICKAXE);
            HandheldItem(ModItems.SILVER_AXE);
            HandheldItem(ModItems.SILVER_SHOVEL);
            HandheldItem(ModItems.SILVER_HOE);
            HandheldItem(ModItems.SILVER_POLISHER);

            trimmedArmorItem(ModItems.SILVER_HELMET);
            trimmedArmorItem(ModItems.SILVER_CHESTPLATE);
            trimmedArmorItem(ModItems.SILVER_LEGGINGS);
            trimmedArmorItem(ModItems.SILVER_BOOTS);

            //Stone
            HandheldItem(ModItems.STONE_POLISHER);

            //Bronze
            HandheldItem(ModItems.BRONZE_SWORD);
            HandheldItem(ModItems.BRONZE_PICKAXE);
            HandheldItem(ModItems.BRONZE_AXE);
            HandheldItem(ModItems.BRONZE_SHOVEL);
            HandheldItem(ModItems.BRONZE_HOE);
            HandheldItem(ModItems.BRONZE_POLISHER);

            trimmedArmorItem(ModItems.BRONZE_HELMET);
            trimmedArmorItem(ModItems.BRONZE_CHESTPLATE);
            trimmedArmorItem(ModItems.BRONZE_LEGGINGS);
            trimmedArmorItem(ModItems.BRONZE_BOOTS);

            //Brass
            HandheldItem(ModItems.BRASS_SWORD);
            HandheldItem(ModItems.BRASS_PICKAXE);
            HandheldItem(ModItems.BRASS_AXE);
            HandheldItem(ModItems.BRASS_SHOVEL);
            HandheldItem(ModItems.BRASS_HOE);
            HandheldItem(ModItems.BRASS_POLISHER);

            trimmedArmorItem(ModItems.BRASS_HELMET);
            trimmedArmorItem(ModItems.BRASS_CHESTPLATE);
            trimmedArmorItem(ModItems.BRASS_LEGGINGS);
            trimmedArmorItem(ModItems.BRASS_BOOTS);

            //Rose Gold
            HandheldItem(ModItems.ROSE_GOLDEN_SWORD);
            HandheldItem(ModItems.ROSE_GOLDEN_PICKAXE);
            HandheldItem(ModItems.ROSE_GOLDEN_AXE);
            HandheldItem(ModItems.ROSE_GOLDEN_SHOVEL);
            HandheldItem(ModItems.ROSE_GOLDEN_HOE);
            HandheldItem(ModItems.ROSE_GOLDEN_POLISHER);

            trimmedArmorItem(ModItems.ROSE_GOLDEN_HELMET);
            trimmedArmorItem(ModItems.ROSE_GOLDEN_CHESTPLATE);
            trimmedArmorItem(ModItems.ROSE_GOLDEN_LEGGINGS);
            trimmedArmorItem(ModItems.ROSE_GOLDEN_BOOTS);

            //Bronzium
            HandheldItem(ModItems.BRONZIUM_SWORD);
            HandheldItem(ModItems.BRONZIUM_PICKAXE);
            HandheldItem(ModItems.BRONZIUM_AXE);
            HandheldItem(ModItems.BRONZIUM_SHOVEL);
            HandheldItem(ModItems.BRONZIUM_HOE);
            HandheldItem(ModItems.BRONZIUM_POLISHER);

            trimmedArmorItem(ModItems.BRONZIUM_HELMET);
            trimmedArmorItem(ModItems.BRONZIUM_CHESTPLATE);
            trimmedArmorItem(ModItems.BRONZIUM_LEGGINGS);
            trimmedArmorItem(ModItems.BRONZIUM_BOOTS);

            //Iron
            HandheldItem(ModItems.IRON_POLISHER);

            //Steel
            HandheldItem(ModItems.STEEL_SWORD);
            HandheldItem(ModItems.STEEL_PICKAXE);
            HandheldItem(ModItems.STEEL_AXE);
            HandheldItem(ModItems.STEEL_SHOVEL);
            HandheldItem(ModItems.STEEL_HOE);
            HandheldItem(ModItems.STEEL_POLISHER);

            trimmedArmorItem(ModItems.STEEL_HELMET);
            trimmedArmorItem(ModItems.STEEL_CHESTPLATE);
            trimmedArmorItem(ModItems.STEEL_LEGGINGS);
            trimmedArmorItem(ModItems.STEEL_BOOTS);

            //Green Gold
            HandheldItem(ModItems.GREEN_GOLDEN_SWORD);
            HandheldItem(ModItems.GREEN_GOLDEN_PICKAXE);
            HandheldItem(ModItems.GREEN_GOLDEN_AXE);
            HandheldItem(ModItems.GREEN_GOLDEN_SHOVEL);
            HandheldItem(ModItems.GREEN_GOLDEN_HOE);
            HandheldItem(ModItems.GREEN_GOLDEN_POLISHER);

            trimmedArmorItem(ModItems.GREEN_GOLDEN_HELMET);
            trimmedArmorItem(ModItems.GREEN_GOLDEN_CHESTPLATE);
            trimmedArmorItem(ModItems.GREEN_GOLDEN_LEGGINGS);
            trimmedArmorItem(ModItems.GREEN_GOLDEN_BOOTS);

            //Blue gold
            HandheldItem(ModItems.BLUE_GOLDEN_SWORD);
            HandheldItem(ModItems.BLUE_GOLDEN_PICKAXE);
            HandheldItem(ModItems.BLUE_GOLDEN_AXE);
            HandheldItem(ModItems.BLUE_GOLDEN_SHOVEL);
            HandheldItem(ModItems.BLUE_GOLDEN_HOE);
            HandheldItem(ModItems.BLUE_GOLDEN_POLISHER);

            trimmedArmorItem(ModItems.BLUE_GOLDEN_HELMET);
            trimmedArmorItem(ModItems.BLUE_GOLDEN_CHESTPLATE);
            trimmedArmorItem(ModItems.BLUE_GOLDEN_LEGGINGS);
            trimmedArmorItem(ModItems.BLUE_GOLDEN_BOOTS);

            //Diamond
            HandheldItem(ModItems.DIAMOND_POLISHER);

            //Netherite
            HandheldItem(ModItems.NETHERITE_POLISHER);


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
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
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

    private ItemModelBuilder HandheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EnhancedPlaythrough.MOD_ID, "item/" + item.getId().getPath()));
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