package net.marmar.enhanced_playthrough.data.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.block.custom.crop.*;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.AbstractEPFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.MasonryFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.grinder.PrimalGrinderBlock;
import net.marmar.enhanced_playthrough.block.custom.plant.DoublePlantGrowingHeadBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static net.marmar.enhanced_playthrough.block.custom.alloyfurnace.AbstractAlloyFurnaceBlock.BURNING;
import static net.minecraft.world.level.block.DoublePlantBlock.HALF;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

public class EPBlockStateProvider extends BlockStateProvider {

    public EPBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnhancedPlaythrough.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Polished stone
        blockWithItem(EPBlocks.POLISHED_STONE);
        slabBlock((SlabBlock) EPBlocks.POLISHED_STONE_SLAB.get(), blockTexture(EPBlocks.POLISHED_STONE.get()), blockTexture(EPBlocks.POLISHED_STONE.get()));
        stairsBlock((StairBlock) EPBlocks.POLISHED_STONE_STAIRS.get(), blockTexture(EPBlocks.POLISHED_STONE.get()));
        wallBlock((WallBlock) EPBlocks.POLISHED_STONE_WALL.get(), blockTexture(EPBlocks.POLISHED_STONE.get()));

        //Limestone
            //cobbled
            blockWithItem(EPBlocks.COBBLED_LIMESTONE);
            slabBlock((SlabBlock) EPBlocks.COBBLED_LIMESTONE_SLAB.get(), blockTexture(EPBlocks.COBBLED_LIMESTONE.get()), blockTexture(EPBlocks.COBBLED_LIMESTONE.get()));
            stairsBlock((StairBlock) EPBlocks.COBBLED_LIMESTONE_STAIRS.get(), blockTexture(EPBlocks.COBBLED_LIMESTONE.get()));
            wallBlock((WallBlock) EPBlocks.COBBLED_LIMESTONE_WALL.get(), blockTexture(EPBlocks.COBBLED_LIMESTONE.get()));

            //natural
            blockWithItem(EPBlocks.LIMESTONE);
            slabBlock((SlabBlock) EPBlocks.LIMESTONE_SLAB.get(), blockTexture(EPBlocks.LIMESTONE.get()), blockTexture(EPBlocks.LIMESTONE.get()));
            stairsBlock((StairBlock) EPBlocks.LIMESTONE_STAIRS.get(), blockTexture(EPBlocks.LIMESTONE.get()));
            wallBlock((WallBlock) EPBlocks.LIMESTONE_WALL.get(), blockTexture(EPBlocks.LIMESTONE.get()));

            //polished
            blockWithItem(EPBlocks.POLISHED_LIMESTONE);
            slabBlock((SlabBlock) EPBlocks.POLISHED_LIMESTONE_SLAB.get(), blockTexture(EPBlocks.POLISHED_LIMESTONE.get()), blockTexture(EPBlocks.POLISHED_LIMESTONE.get()));
            stairsBlock((StairBlock) EPBlocks.POLISHED_LIMESTONE_STAIRS.get(), blockTexture(EPBlocks.POLISHED_LIMESTONE.get()));
            wallBlock((WallBlock) EPBlocks.POLISHED_LIMESTONE_WALL.get(), blockTexture(EPBlocks.POLISHED_LIMESTONE.get()));

            //bricks
            blockWithItem(EPBlocks.LIMESTONE_BRICKS);
            slabBlock((SlabBlock) EPBlocks.LIMESTONE_BRICK_SLAB.get(), blockTexture(EPBlocks.LIMESTONE_BRICKS.get()), blockTexture(EPBlocks.LIMESTONE_BRICKS.get()));
            stairsBlock((StairBlock) EPBlocks.LIMESTONE_BRICK_STAIRS.get(), blockTexture(EPBlocks.LIMESTONE_BRICKS.get()));
            wallBlock((WallBlock) EPBlocks.LIMESTONE_BRICK_WALL.get(), blockTexture(EPBlocks.LIMESTONE_BRICKS.get()));

        //Soul
        blockWithItem(EPBlocks.SOUL_MUD);
        blockWithItem(EPBlocks.SOUL_MUD_BRICKS);
        slabBlock((SlabBlock) EPBlocks.SOUL_MUD_BRICK_SLAB.get(), blockTexture(EPBlocks.SOUL_MUD_BRICKS.get()), blockTexture(EPBlocks.SOUL_MUD_BRICKS.get()));
        stairsBlock((StairBlock) EPBlocks.SOUL_MUD_BRICK_STAIRS.get(), blockTexture(EPBlocks.SOUL_MUD_BRICKS.get()));
        wallBlock((WallBlock) EPBlocks.SOUL_MUD_BRICK_WALL.get(), blockTexture(EPBlocks.SOUL_MUD_BRICKS.get()));

        //Firebrick
        blockWithItem(EPBlocks.FIREBRICKS);
        slabBlock((SlabBlock) EPBlocks.FIREBRICK_SLAB.get(), blockTexture(EPBlocks.FIREBRICKS.get()), blockTexture(EPBlocks.FIREBRICKS.get()));
        stairsBlock((StairBlock) EPBlocks.FIREBRICK_STAIRS.get(), blockTexture(EPBlocks.FIREBRICKS.get()));
        wallBlock((WallBlock) EPBlocks.FIREBRICK_WALL.get(), blockTexture(EPBlocks.FIREBRICKS.get()));

        //ores
        blockWithItem(EPBlocks.NETHER_COPPER_ORE);

        blockWithItem(EPBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(EPBlocks.TIN_ORE);

        blockWithItem(EPBlocks.ZINC_ORE);
        blockWithItem(EPBlocks.DEEPSLATE_ZINC_ORE);
        blockWithItem(EPBlocks.NETHER_ZINC_ORE);

        blockWithItem(EPBlocks.DEEPSLATE_SULFUR_ORE);
        blockWithItem(EPBlocks.SULFUR_ORE);
        blockWithItem(EPBlocks.NETHER_SULFUR_ORE);

        blockWithItem(EPBlocks.SILVER_ORE);
        blockWithItem(EPBlocks.DEEPSLATE_SILVER_ORE);

        blockWithItem(EPBlocks.RUBY_ORE);
        blockWithItem(EPBlocks.SAPPHIRE_ORE);

        blockWithItem(EPBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(EPBlocks.DEEPSLATE_SAPPHIRE_ORE);

        blockWithItem(EPBlocks.NETHER_GARNET_ORE);

        blockWithItem(EPBlocks.COBALT_ORE);
        blockWithItem(EPBlocks.DEEPSLATE_COBALT_ORE);

        //Bauxite
        blockWithItem(EPBlocks.BAUXITE);
        blockWithItem(EPBlocks.WHITE_BAUXITE);
        blockWithItem(EPBlocks.LIGHT_GRAY_BAUXITE);
        blockWithItem(EPBlocks.BROWN_BAUXITE);
        blockWithItem(EPBlocks.RED_BAUXITE);
        blockWithItem(EPBlocks.ORANGE_BAUXITE);
        blockWithItem(EPBlocks.YELLOW_BAUXITE);

        //Raw ore blocks
        blockWithItem(EPBlocks.RAW_SILVER_BLOCK);
        blockWithItem(EPBlocks.RAW_ALUMINUM_BLOCK);
        blockWithItem(EPBlocks.RAW_TIN_BLOCK);
        blockWithItem(EPBlocks.RAW_ZINC_BLOCK);

        //Ore blocks
        blockWithItem(EPBlocks.SILVER_BLOCK);
        blockWithItem(EPBlocks.ALUMINUM_BLOCK);
        blockWithItem(EPBlocks.TIN_BLOCK);
        blockWithItem(EPBlocks.ZINC_BLOCK);
        blockWithItem(EPBlocks.BRASS_BLOCK);
        blockWithItem(EPBlocks.BRONZE_BLOCK);
        blockWithItem(EPBlocks.BRONZIUM_BLOCK);
        blockWithItem(EPBlocks.ROSE_GOLD_BLOCK);
        blockWithItem(EPBlocks.STEEL_BLOCK);
        blockWithItem(EPBlocks.GREEN_GOLD_BLOCK);
        blockWithItem(EPBlocks.BLUE_GOLD_BLOCK);

        //Calibrated quartz
        orientableBlockWithSide(EPBlocks.CALIBRATED_QUARTZ_BLOCK.get());
        smoothCalibratedQuartz(EPBlocks.SMOOTH_CALIBRATED_QUARTZ_BLOCK.get());
        orientableBlock(EPBlocks.CHISELED_CALIBRATED_QUARTZ_BLOCK.get());
        logBlock((RotatedPillarBlock) EPBlocks.CALIBRATED_QUARTZ_PILLAR.get());
        blockWithItem(EPBlocks.CALIBRATED_QUARTZ_BRICKS);

        //Crops
        makeYerbaMateCrop((CropBlock) EPBlocks.YERBA_MATE_CROP.get(), "yerba_mate_stage","yerba_mate_stage");
        makeZapalloCrop((CropBlock) EPBlocks.ZAPALLO_CROP.get(), "zapallo_stage","zapallo_stage");
        makeEggplantCrop((CropBlock) EPBlocks.EGGPLANT_CROP.get(), "eggplant_stage","eggplant_stage");
        makeTomatoCrop((CropBlock) EPBlocks.TOMATO_CROP.get(), "tomato_stage","tomato_stage");
        makeCornCrop((CropBlock) EPBlocks.CORN_CROP.get(), "corn_stage","corn_stage");

        //Wild crops
        doublePlantBlock(EPBlocks.WILD_CORN_CROP);
        plantBlock(EPBlocks.WILD_WHEAT_CROP, false);
        plantBlock(EPBlocks.WILD_TOMATO_CROP, true);

        //Plants
        doublePlantWithAgeBlock(EPBlocks.REEDS);
        plantBlock(EPBlocks.SMALL_REEDS, true);
        doublePlantWithAgeBlock(EPBlocks.TALL_REEDS);
        doublePlantBlock(EPBlocks.WATER_REEDS);

        //Flowers
        flowerWithPotBlock(EPBlocks.COLD_LYRIUM, EPBlocks.POTTED_COLD_LYRIUM);

        flowerWithPotBlock(EPBlocks.SUCCULENT, EPBlocks.POTTED_SUCCULENT);

        //Block entities
        furnaceBlock(EPBlocks.ADOBE_FURNACE);
        furnaceBlock(EPBlocks.SOUL_FURNACE);

        furnaceBlock(EPBlocks.MASONRY_FURNACE);

        furnaceBlock(EPBlocks.ADOBE_ALLOY_FURNACE);
        furnaceBlock(EPBlocks.SUPER_ALLOY_FURNACE);
        furnaceBlock(EPBlocks.SOUL_ALLOY_FURNACE);

        simpleBlockWithItem(EPBlocks.GEM_POLISHER.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_polisher")));

        grinderBlock(EPBlocks.PRIMAL_GRINDER);
        grinderBlock(EPBlocks.MECHANICAL_GRINDER);

        //Wood
            //walnut
            saplingBlock(EPBlocks.WALNUT_SAPLING);

            logBlock((RotatedPillarBlock) EPBlocks.WALNUT_LOG.get());
            blockItem(EPBlocks.WALNUT_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_WALNUT_LOG.get(), blockTexture(EPBlocks.STRIPPED_WALNUT_LOG.get()),
                    modLoc("block/stripped_walnut_log_top"));
            blockItem(EPBlocks.STRIPPED_WALNUT_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.WALNUT_WOOD.get(), blockTexture(EPBlocks.WALNUT_LOG.get()), blockTexture(EPBlocks.WALNUT_LOG.get()));
            blockItem(EPBlocks.WALNUT_WOOD);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_WALNUT_WOOD.get(), blockTexture(EPBlocks.STRIPPED_WALNUT_LOG.get()), blockTexture(EPBlocks.STRIPPED_WALNUT_LOG.get()));
            blockItem(EPBlocks.STRIPPED_WALNUT_WOOD);

            leavesBlock(EPBlocks.WALNUT_LEAVES);

            blockWithItem(EPBlocks.WALNUT_PLANKS);

            doorBlockWithRenderType((DoorBlock) EPBlocks.WALNUT_DOOR.get(), modLoc("block/walnut_door_bottom"), modLoc("block/walnut_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) EPBlocks.WALNUT_TRAPDOOR.get(), modLoc("block/walnut_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) EPBlocks.WALNUT_BUTTON.get(), blockTexture(EPBlocks.WALNUT_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) EPBlocks.WALNUT_PRESSURE_PLATE.get(), blockTexture(EPBlocks.WALNUT_PLANKS.get()));

            slabBlock((SlabBlock) EPBlocks.WALNUT_SLAB.get(), blockTexture(EPBlocks.WALNUT_PLANKS.get()), blockTexture(EPBlocks.WALNUT_PLANKS.get()));
            stairsBlock((StairBlock) EPBlocks.WALNUT_STAIRS.get(), blockTexture(EPBlocks.WALNUT_PLANKS.get()));
            fenceBlock((FenceBlock) EPBlocks.WALNUT_FENCE.get(), blockTexture(EPBlocks.WALNUT_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) EPBlocks.WALNUT_FENCEGATE.get(), blockTexture(EPBlocks.WALNUT_PLANKS.get()));

            signBlock((StandingSignBlock) EPBlocks.WALNUT_SIGN.get(), (WallSignBlock) EPBlocks.WALNUT_WALL_SIGN.get(),
                    blockTexture(EPBlocks.WALNUT_PLANKS.get()));

            hangingSignBlock(EPBlocks.WALNUT_HANGING_SIGN.get(), EPBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                    blockTexture(EPBlocks.WALNUT_PLANKS.get()));

            //Apple
            saplingBlock(EPBlocks.APPLE_SAPLING);
            saplingBlock(EPBlocks.GREEN_APPLE_SAPLING);

            logBlock((RotatedPillarBlock) EPBlocks.APPLE_LOG.get());
            blockItem(EPBlocks.APPLE_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_APPLE_LOG.get(), blockTexture(EPBlocks.STRIPPED_APPLE_LOG.get()),
                    modLoc("block/stripped_apple_log_top"));
            blockItem(EPBlocks.STRIPPED_APPLE_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.APPLE_WOOD.get(), blockTexture(EPBlocks.APPLE_LOG.get()), blockTexture(EPBlocks.APPLE_LOG.get()));
            blockItem(EPBlocks.APPLE_WOOD);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_APPLE_WOOD.get(), blockTexture(EPBlocks.STRIPPED_APPLE_LOG.get()), blockTexture(EPBlocks.STRIPPED_APPLE_LOG.get()));
            blockItem(EPBlocks.STRIPPED_APPLE_WOOD);

            leavesBlock(EPBlocks.APPLE_LEAVES);
            leavesBlock(EPBlocks.GREEN_APPLE_LEAVES);

            blockWithItem(EPBlocks.APPLE_PLANKS);

            doorBlockWithRenderType((DoorBlock) EPBlocks.APPLE_DOOR.get(), modLoc("block/apple_door_bottom"), modLoc("block/apple_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) EPBlocks.APPLE_TRAPDOOR.get(), modLoc("block/apple_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) EPBlocks.APPLE_BUTTON.get(), blockTexture(EPBlocks.APPLE_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) EPBlocks.APPLE_PRESSURE_PLATE.get(), blockTexture(EPBlocks.APPLE_PLANKS.get()));

            slabBlock((SlabBlock) EPBlocks.APPLE_SLAB.get(), blockTexture(EPBlocks.APPLE_PLANKS.get()), blockTexture(EPBlocks.APPLE_PLANKS.get()));
            stairsBlock((StairBlock) EPBlocks.APPLE_STAIRS.get(), blockTexture(EPBlocks.APPLE_PLANKS.get()));

            fenceBlock((FenceBlock) EPBlocks.APPLE_FENCE.get(), blockTexture(EPBlocks.APPLE_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) EPBlocks.APPLE_FENCEGATE.get(), blockTexture(EPBlocks.APPLE_PLANKS.get()));

            signBlock((StandingSignBlock) EPBlocks.APPLE_SIGN.get(), (WallSignBlock) EPBlocks.APPLE_WALL_SIGN.get(),
                    blockTexture(EPBlocks.APPLE_PLANKS.get()));

            hangingSignBlock(EPBlocks.APPLE_HANGING_SIGN.get(), EPBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    blockTexture(EPBlocks.APPLE_PLANKS.get()));

            //Orange
            saplingBlock(EPBlocks.ORANGE_SAPLING);

            logBlock((RotatedPillarBlock) EPBlocks.ORANGE_LOG.get());
            blockItem(EPBlocks.ORANGE_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_ORANGE_LOG.get(), blockTexture(EPBlocks.STRIPPED_ORANGE_LOG.get()),
                    modLoc("block/stripped_orange_log_top"));
            blockItem(EPBlocks.STRIPPED_ORANGE_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.ORANGE_WOOD.get(), blockTexture(EPBlocks.ORANGE_LOG.get()), blockTexture(EPBlocks.ORANGE_LOG.get()));
            blockItem(EPBlocks.ORANGE_WOOD);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_ORANGE_WOOD.get(), blockTexture(EPBlocks.STRIPPED_ORANGE_LOG.get()), blockTexture(EPBlocks.STRIPPED_ORANGE_LOG.get()));
            blockItem(EPBlocks.STRIPPED_ORANGE_WOOD);

            leavesBlock(EPBlocks.ORANGE_LEAVES);

            blockWithItem(EPBlocks.ORANGE_PLANKS);

            doorBlockWithRenderType((DoorBlock) EPBlocks.ORANGE_DOOR.get(), modLoc("block/orange_door_bottom"), modLoc("block/orange_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) EPBlocks.ORANGE_TRAPDOOR.get(), modLoc("block/orange_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) EPBlocks.ORANGE_BUTTON.get(), blockTexture(EPBlocks.ORANGE_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) EPBlocks.ORANGE_PRESSURE_PLATE.get(), blockTexture(EPBlocks.ORANGE_PLANKS.get()));

            slabBlock((SlabBlock) EPBlocks.ORANGE_SLAB.get(), blockTexture(EPBlocks.ORANGE_PLANKS.get()), blockTexture(EPBlocks.ORANGE_PLANKS.get()));
            stairsBlock((StairBlock) EPBlocks.ORANGE_STAIRS.get(), blockTexture(EPBlocks.ORANGE_PLANKS.get()));

            fenceBlock((FenceBlock) EPBlocks.ORANGE_FENCE.get(), blockTexture(EPBlocks.ORANGE_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) EPBlocks.ORANGE_FENCEGATE.get(), blockTexture(EPBlocks.ORANGE_PLANKS.get()));

            signBlock((StandingSignBlock) EPBlocks.ORANGE_SIGN.get(), (WallSignBlock) EPBlocks.ORANGE_WALL_SIGN.get(),
                    blockTexture(EPBlocks.ORANGE_PLANKS.get()));

            hangingSignBlock(EPBlocks.ORANGE_HANGING_SIGN.get(), EPBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    blockTexture(EPBlocks.ORANGE_PLANKS.get()));

            //Lemon
            saplingBlock(EPBlocks.LEMON_SAPLING);

            logBlock((RotatedPillarBlock) EPBlocks.LEMON_LOG.get());
            blockItem(EPBlocks.LEMON_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_LEMON_LOG.get(), blockTexture(EPBlocks.STRIPPED_LEMON_LOG.get()),
                    modLoc( "block/stripped_lemon_log_top"));
            blockItem(EPBlocks.STRIPPED_LEMON_LOG);

            axisBlock((RotatedPillarBlock) EPBlocks.LEMON_WOOD.get(), blockTexture(EPBlocks.LEMON_LOG.get()), blockTexture(EPBlocks.LEMON_LOG.get()));
            blockItem(EPBlocks.LEMON_WOOD);

            axisBlock((RotatedPillarBlock) EPBlocks.STRIPPED_LEMON_WOOD.get(), blockTexture(EPBlocks.STRIPPED_LEMON_LOG.get()), blockTexture(EPBlocks.STRIPPED_LEMON_LOG.get()));
            blockItem(EPBlocks.STRIPPED_LEMON_WOOD);

            leavesBlock(EPBlocks.LEMON_LEAVES);

            blockWithItem(EPBlocks.LEMON_PLANKS);

            doorBlockWithRenderType((DoorBlock) EPBlocks.LEMON_DOOR.get(), modLoc("block/lemon_door_bottom"), modLoc("block/lemon_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) EPBlocks.LEMON_TRAPDOOR.get(), modLoc("block/lemon_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) EPBlocks.LEMON_BUTTON.get(), blockTexture(EPBlocks.LEMON_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) EPBlocks.LEMON_PRESSURE_PLATE.get(), blockTexture(EPBlocks.LEMON_PLANKS.get()));

            slabBlock((SlabBlock) EPBlocks.LEMON_SLAB.get(), blockTexture(EPBlocks.LEMON_PLANKS.get()), blockTexture(EPBlocks.LEMON_PLANKS.get()));
            stairsBlock((StairBlock) EPBlocks.LEMON_STAIRS.get(), blockTexture(EPBlocks.LEMON_PLANKS.get()));

            fenceBlock((FenceBlock) EPBlocks.LEMON_FENCE.get(), blockTexture(EPBlocks.LEMON_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) EPBlocks.LEMON_FENCEGATE.get(), blockTexture(EPBlocks.LEMON_PLANKS.get()));

            signBlock((StandingSignBlock) EPBlocks.LEMON_SIGN.get(), (WallSignBlock) EPBlocks.LEMON_WALL_SIGN.get(),
                    blockTexture(EPBlocks.LEMON_PLANKS.get()));

            hangingSignBlock(EPBlocks.LEMON_HANGING_SIGN.get(), EPBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    blockTexture(EPBlocks.LEMON_PLANKS.get()));

            //Lime
            saplingBlock(EPBlocks.LIME_SAPLING);
            leavesBlock(EPBlocks.LIME_LEAVES);
    }

    //Crop model builders
        //Yerba mate
        public void makeYerbaMateCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> yerbaMateStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] yerbaMateStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((YerbaMateCropBlock) block).getAgeProperty()),
                    modLoc( "block/" + textureName + state.getValue(((YerbaMateCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }

        //Zapallo
        public void makeZapalloCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> zapalloStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] zapalloStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ZapalloCropBlock) block).getAgeProperty()),
                    modLoc( "block/" + textureName + state.getValue(((ZapalloCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }

        //Eggplant
        public void makeEggplantCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> eggplantStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] eggplantStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((EggplantCropBlock) block).getAgeProperty()),
                    modLoc( "block/" + textureName + state.getValue(((EggplantCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }

        //Tomato
        public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> tomatoStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] tomatoStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                    modLoc( "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }

        //Corn
        public void makeCornCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                    modLoc( "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }

    //Other model builders
    public void blockWithItem(RegistryObject<Block> pBlock){
        simpleBlockWithItem(pBlock.get(), cubeAll(pBlock.get()));
    }

    public void blockItem(RegistryObject<Block> pBlock) {
        simpleBlockItem(pBlock.get(), new ModelFile.UncheckedModelFile(EnhancedPlaythrough.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath()));
    }

    public void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), mcLoc("block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void plantBlock(RegistryObject<Block> pBlock, boolean isCross){
        if (isCross){
            simpleBlock(pBlock.get(), models().cross(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), blockTexture(pBlock.get())).renderType("cutout"));
        } else {
            simpleBlock(pBlock.get(), models().crop(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), blockTexture(pBlock.get())).renderType("cutout"));
        }
    }

    protected ConfiguredModel[] doublePlantModel(BlockState state, RegistryObject<Block> pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath() + "_";

        ConfiguredModel[] plantModel = new ConfiguredModel[1];

        plantModel[0] = new ConfiguredModel(models().cross(path + state.getValue(HALF),
                modLoc("block/" + path + state.getValue(HALF))).renderType("cutout"));

        return plantModel;
    }

    public void doublePlantBlock(RegistryObject<Block> pBlock){
        Function<BlockState, ConfiguredModel[]> model = blockState -> doublePlantModel(blockState, pBlock);

        getVariantBuilder(pBlock.get()).forAllStates(model);
    }

    protected ConfiguredModel[] furnaceModel(BlockState state, RegistryObject<Block> pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath();

        ModelFile blockModels = models().orientable(
                state.getValue(BURNING) ? path + "_on" : path,
                modLoc("block/" + path + "_side"),
                state.getValue(BURNING) ?modLoc("block/" + path + "_front_on") :
                        modLoc("block/" + path + "_front"),
                modLoc("block/" + path + "_top")
        );

        return ConfiguredModel.builder().modelFile(blockModels).rotationY((int) state.getValue(FACING).toYRot()).build();
    }

    protected ConfiguredModel[] masonryFurnaceModel(BlockState state, RegistryObject<Block> pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath();

        ModelFile blockModels = models().orientableWithBottom(
                state.getValue(BURNING) ? path + "_on" : path,
                modLoc("block/" + path + "_side"),
                state.getValue(BURNING) ? modLoc("block/" + path + "_front_on") :
                        modLoc("block/" + path + "_front"),
                modLoc("block/" + path + "_bottom"),
                state.getValue(BURNING) ? modLoc("block/" + path + "_top_on")
                        : modLoc("block/" + path + "_top")
        );

        return ConfiguredModel.builder().modelFile(blockModels).rotationY((int) state.getValue(FACING).toYRot()).build();
    }

    protected ConfiguredModel[] alloyFurnaceModel(BlockState state, RegistryObject<Block> pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath();

        ModelFile blockModels = models().orientableWithBottom(
                state.getValue(BURNING) ? path + "_on" : path,
                modLoc("block/" + path + "_side"),
                state.getValue(BURNING) ? modLoc("block/" + path + "_front_on") :
                        modLoc("block/" + path + "_front"),
                modLoc("block/" + path + "_bottom"),
                modLoc("block/" + path + "_top")
        );

        return ConfiguredModel.builder().modelFile(blockModels).rotationY((int) state.getValue(FACING).toYRot()).build();
    }

    public void furnaceBlock(RegistryObject<Block> pBlock){
        Function<BlockState, ConfiguredModel[]> model = pBlock.get() instanceof AbstractEPFurnaceBlock
                ? blockState -> furnaceModel(blockState, pBlock)
                : blockState -> alloyFurnaceModel(blockState, pBlock);

        if (pBlock.get() instanceof MasonryFurnaceBlock) model  = state -> masonryFurnaceModel(state, pBlock);

        getVariantBuilder(pBlock.get()).forAllStates(model);
    }

    protected ConfiguredModel[] grinderModel(BlockState state, RegistryObject<Block> pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath();

        ModelFile blockModels = models().orientableWithBottom(
                state.getValue(PrimalGrinderBlock.ON) ? path + "_on" : path,
                modLoc("block/" + path + "_side"),
                state.getValue(PrimalGrinderBlock.ON) ? modLoc("block/" + path + "_front_on") :
                        modLoc("block/" + path + "_front"),
                modLoc("block/" + path + "_bottom"),
                modLoc("block/" + path + "_top")
        );

        return ConfiguredModel.builder().modelFile(blockModels)
                .rotationY((int) state.getValue(FACING).toYRot())
                .build();
    }

    public void grinderBlock(RegistryObject<Block> pBlock){
        Function<BlockState, ConfiguredModel[]> model = blockState -> grinderModel(blockState, pBlock);

        getVariantBuilder(pBlock.get()).forAllStates(model);
    }

    protected ConfiguredModel[] doublePlantWithAgeModel(BlockState state, DoublePlantGrowingHeadBlock pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock).getPath() + "_";

        ConfiguredModel[] plantModel = new ConfiguredModel[1];

        plantModel[0] = new ConfiguredModel(models().cross(path + state.getValue(HALF) + "_" + pBlock.getCurrentAge(state),
                        modLoc(state.getValue(HALF) == DoubleBlockHalf.LOWER
                        ? "block/" + path + state.getValue(HALF)
                        : "block/" + path + state.getValue(HALF) + "_" + pBlock.getCurrentAge(state)))
                        .renderType("cutout"));

        return plantModel;
    }

    public void doublePlantWithAgeBlock(RegistryObject<Block> pBlock){
        Function<BlockState, ConfiguredModel[]> model = blockState ->
                doublePlantWithAgeModel(blockState, (DoublePlantGrowingHeadBlock) pBlock.get());

        getVariantBuilder(pBlock.get()).forAllStates(model);
    }

    public void flowerWithPotBlock(RegistryObject<Block> pFlower, RegistryObject<Block> pPottedFlower){
        plantBlock(pFlower, true);

        simpleBlockWithItem(pPottedFlower.get(), models().singleTexture("potted_" + blockName(pFlower.get()), mcLoc("flower_pot_cross"), "plant",
                blockTexture(pFlower.get())).renderType("cutout"));
    }

    public void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(blockName(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    public void orientableBlockWithSide(Block pBlock){
        ModelFile blockModel = models().cubeBottomTop(blockName(pBlock), blockTextureWithExtra(pBlock, "side"),
                blockTextureWithExtra(pBlock, "bottom"), blockTextureWithExtra(pBlock, "top"));

        simpleBlock(pBlock, blockModel);
    }

    public void orientableBlock(Block pBlock){
        ModelFile blockModel = models().cubeTop(blockName(pBlock),blockTextureWithExtra(pBlock, "side"),
                blockTextureWithExtra(pBlock, "top"));

        simpleBlock(pBlock, blockModel);
    }

    public void smoothCalibratedQuartz(Block pBlock){
        ModelFile blockModel = models().cubeAll(blockName(pBlock),modLoc("block/calibrated_quartz_block_bottom"));

        simpleBlock(pBlock, blockModel);
    }

    //Helpers
    public String blockName(Block block) {
        return blockKey(block).getPath();
    }

    public ResourceLocation blockTextureWithExtra(Block block, String orientation) {
        ResourceLocation name = blockKey(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + "_" + orientation);
    }

    public ResourceLocation blockKey(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
