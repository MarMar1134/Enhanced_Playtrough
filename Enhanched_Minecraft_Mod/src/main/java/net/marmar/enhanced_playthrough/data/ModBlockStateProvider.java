package net.marmar.enhanced_playthrough.data;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.crops.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static net.minecraft.world.level.block.DoublePlantBlock.HALF;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnhancedPlaythrough.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Stone
        wallBlock((WallBlock) ModBlocks.STONE_WALL.get(), blockTexture(Blocks.STONE));

        //Polished diorite, andesite and granite
        wallBlock((WallBlock) ModBlocks.POLISHED_DIORITE_WALL.get(), blockTexture(Blocks.POLISHED_DIORITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_ANDESITE_WALL.get(), blockTexture(Blocks.POLISHED_ANDESITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_GRANITE_WALL.get(), blockTexture(Blocks.POLISHED_GRANITE));

        //Dripstone
        slabBlock((SlabBlock) ModBlocks.DRIPSTONE_SLAB.get(), blockTexture(Blocks.DRIPSTONE_BLOCK), blockTexture(Blocks.DRIPSTONE_BLOCK));
        stairsBlock((StairBlock) ModBlocks.DRIPSTONE_STAIRS.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));
        wallBlock((WallBlock) ModBlocks.DRIPSTONE_WALL.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));

        //Polished stone
        blockWithItem(ModBlocks.POLISHED_STONE);
        slabBlock((SlabBlock) ModBlocks.POLISHED_STONE_SLAB.get(), blockTexture(ModBlocks.POLISHED_STONE.get()), blockTexture(ModBlocks.POLISHED_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_STONE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_STONE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_STONE_WALL.get(), blockTexture(ModBlocks.POLISHED_STONE.get()));

        //Limestone
            //cobbled
            blockWithItem(ModBlocks.COBBLED_LIMESTONE);
            slabBlock((SlabBlock) ModBlocks.COBBLED_LIMESTONE_SLAB.get(), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));
            stairsBlock((StairBlock) ModBlocks.COBBLED_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));
            wallBlock((WallBlock) ModBlocks.COBBLED_LIMESTONE_WALL.get(), blockTexture(ModBlocks.COBBLED_LIMESTONE.get()));

            //natural
            blockWithItem(ModBlocks.LIMESTONE);
            slabBlock((SlabBlock) ModBlocks.LIMESTONE_SLAB.get(), blockTexture(ModBlocks.LIMESTONE.get()), blockTexture(ModBlocks.LIMESTONE.get()));
            stairsBlock((StairBlock) ModBlocks.LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.LIMESTONE.get()));
            wallBlock((WallBlock) ModBlocks.LIMESTONE_WALL.get(), blockTexture(ModBlocks.LIMESTONE.get()));

            //polished
            blockWithItem(ModBlocks.POLISHED_LIMESTONE);
            slabBlock((SlabBlock) ModBlocks.POLISHED_LIMESTONE_SLAB.get(), blockTexture(ModBlocks.POLISHED_LIMESTONE.get()), blockTexture(ModBlocks.POLISHED_LIMESTONE.get()));
            stairsBlock((StairBlock) ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_LIMESTONE.get()));
            wallBlock((WallBlock) ModBlocks.POLISHED_LIMESTONE_WALL.get(), blockTexture(ModBlocks.POLISHED_LIMESTONE.get()));

            //bricks
            blockWithItem(ModBlocks.LIMESTONE_BRICKS);
            slabBlock((SlabBlock) ModBlocks.LIMESTONE_BRICK_SLAB.get(), blockTexture(ModBlocks.LIMESTONE_BRICKS.get()), blockTexture(ModBlocks.LIMESTONE_BRICKS.get()));
            stairsBlock((StairBlock) ModBlocks.LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.LIMESTONE_BRICKS.get()));
            wallBlock((WallBlock) ModBlocks.LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.LIMESTONE_BRICKS.get()));

        //Soul
        blockWithItem(ModBlocks.SOUL_MUD);
        blockWithItem(ModBlocks.SOUL_MUD_BRICKS);
        slabBlock((SlabBlock) ModBlocks.SOUL_MUD_BRICK_SLAB.get(), blockTexture(ModBlocks.SOUL_MUD_BRICKS.get()), blockTexture(ModBlocks.SOUL_MUD_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.SOUL_MUD_BRICK_STAIRS.get(), blockTexture(ModBlocks.SOUL_MUD_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.SOUL_MUD_BRICK_WALL.get(), blockTexture(ModBlocks.SOUL_MUD_BRICKS.get()));

        //ores
        blockWithItem(ModBlocks.NETHER_COPPER_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(ModBlocks.TIN_ORE);

        blockWithItem(ModBlocks.ZINC_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ZINC_ORE);
        blockWithItem(ModBlocks.NETHER_ZINC_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_SULFUR_ORE);
        blockWithItem(ModBlocks.SULFUR_ORE);
        blockWithItem(ModBlocks.NETHER_SULFUR_ORE);

        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);

        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        blockWithItem(ModBlocks.NETHER_GARNET_ORE);

        blockWithItem(ModBlocks.COBALT_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_COBALT_ORE);

        //Ores blocks
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.ZINC_BLOCK);
        blockWithItem(ModBlocks.BRASS_BLOCK);
        blockWithItem(ModBlocks.BRONZE_BLOCK);
        blockWithItem(ModBlocks.BRONZIUM_BLOCK);
        blockWithItem(ModBlocks.ROSE_GOLD_BLOCK);
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.GREEN_GOLD_BLOCK);
        blockWithItem(ModBlocks.BLUE_GOLD_BLOCK);

        //Crops
        makeYerbaMateCrop((CropBlock) ModBlocks.YERBA_MATE_CROP.get(), "yerba_mate_stage","yerba_mate_stage");
        makeZapalloCrop((CropBlock) ModBlocks.ZAPALLO_CROP.get(), "zapallo_stage","zapallo_stage");
        makeEggplantCrop((CropBlock) ModBlocks.EGGPLANT_CROP.get(), "eggplant_stage","eggplant_stage");
        makeTomatoCrop((CropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_stage","tomato_stage");
        makeCornCrop((CropBlock) ModBlocks.CORN_CROP.get(), "corn_stage","corn_stage");

        //Wild crops
        doublePlantBlock(ModBlocks.WILD_CORN);
        wildCropBlock(ModBlocks.WILD_WHEAT, false);
        wildCropBlock(ModBlocks.WILD_TOMATO, true);

        //Plants
        doublePlantBlock(ModBlocks.WATER_REEDS);
        doublePlantBlock(ModBlocks.TALL_REEDS);
        doublePlantBlock(ModBlocks.REEDS);
        wildCropBlock(ModBlocks.SMALL_REEDS, true);



        //EntityBlocks
        simpleBlockWithItem(ModBlocks.GEM_POLISHER.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_polisher")));

        //Wood
            //walnut
            saplingBlock(ModBlocks.WALNUT_SAPLING);

            logBlock((RotatedPillarBlock) ModBlocks.WALNUT_LOG.get());
            blockItem(ModBlocks.WALNUT_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_LOG.get(), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()),
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/stripped_walnut_log_top"));
            blockItem(ModBlocks.STRIPPED_WALNUT_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.WALNUT_WOOD.get(), blockTexture(ModBlocks.WALNUT_LOG.get()), blockTexture(ModBlocks.WALNUT_LOG.get()));
            blockItem(ModBlocks.WALNUT_WOOD);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_WOOD.get(), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()));
            blockItem(ModBlocks.STRIPPED_WALNUT_WOOD);

            leavesBlock(ModBlocks.WALNUT_LEAVES);

            blockWithItem(ModBlocks.WALNUT_PLANKS);

            doorBlockWithRenderType((DoorBlock) ModBlocks.WALNUT_DOOR.get(), modLoc("block/walnut_door_bottom"), modLoc("block/walnut_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.WALNUT_TRAPDOOR.get(), modLoc("block/walnut_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) ModBlocks.WALNUT_BUTTON.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) ModBlocks.WALNUT_PRESSURE_PLATE.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));

            slabBlock((SlabBlock) ModBlocks.WALNUT_SLAB.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
            stairsBlock((StairBlock) ModBlocks.WALNUT_STAIRS.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
            fenceBlock((FenceBlock) ModBlocks.WALNUT_FENCE.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) ModBlocks.WALNUT_FENCEGATE.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));

            signBlock((StandingSignBlock) ModBlocks.WALNUT_SIGN.get(), (WallSignBlock) ModBlocks.WALNUT_WALL_SIGN.get(),
                    blockTexture(ModBlocks.WALNUT_PLANKS.get()));

            hangingSignBlock(ModBlocks.WALNUT_HANGING_SIGN.get(), ModBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.WALNUT_PLANKS.get()));

            //Apple
            saplingBlock(ModBlocks.APPLE_SAPLING);
            saplingBlock(ModBlocks.GREEN_APPLE_SAPLING);

            logBlock((RotatedPillarBlock) ModBlocks.APPLE_LOG.get());
            blockItem(ModBlocks.APPLE_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_APPLE_LOG.get(), blockTexture(ModBlocks.STRIPPED_APPLE_LOG.get()),
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/stripped_apple_log_top"));
            blockItem(ModBlocks.STRIPPED_APPLE_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.APPLE_WOOD.get(), blockTexture(ModBlocks.APPLE_LOG.get()), blockTexture(ModBlocks.APPLE_LOG.get()));
            blockItem(ModBlocks.APPLE_WOOD);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_APPLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_APPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_APPLE_LOG.get()));
            blockItem(ModBlocks.STRIPPED_APPLE_WOOD);

            leavesBlock(ModBlocks.APPLE_LEAVES);
            leavesBlock(ModBlocks.GREEN_APPLE_LEAVES);

            blockWithItem(ModBlocks.APPLE_PLANKS);

            doorBlockWithRenderType((DoorBlock) ModBlocks.APPLE_DOOR.get(), modLoc("block/apple_door_bottom"), modLoc("block/apple_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.APPLE_TRAPDOOR.get(), modLoc("block/apple_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) ModBlocks.APPLE_BUTTON.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) ModBlocks.APPLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));

            slabBlock((SlabBlock) ModBlocks.APPLE_SLAB.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            stairsBlock((StairBlock) ModBlocks.APPLE_STAIRS.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));

            fenceBlock((FenceBlock) ModBlocks.APPLE_FENCE.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) ModBlocks.APPLE_FENCEGATE.get(), blockTexture(ModBlocks.APPLE_PLANKS.get()));

            signBlock((StandingSignBlock) ModBlocks.APPLE_SIGN.get(), (WallSignBlock) ModBlocks.APPLE_WALL_SIGN.get(),
                    blockTexture(ModBlocks.APPLE_PLANKS.get()));

            hangingSignBlock(ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.APPLE_PLANKS.get()));

            //Orange
            saplingBlock(ModBlocks.ORANGE_SAPLING);

            logBlock((RotatedPillarBlock) ModBlocks.ORANGE_LOG.get());
            blockItem(ModBlocks.ORANGE_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ORANGE_LOG.get(), blockTexture(ModBlocks.STRIPPED_ORANGE_LOG.get()),
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/stripped_orange_log_top"));
            blockItem(ModBlocks.STRIPPED_ORANGE_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.ORANGE_WOOD.get(), blockTexture(ModBlocks.ORANGE_LOG.get()), blockTexture(ModBlocks.ORANGE_LOG.get()));
            blockItem(ModBlocks.ORANGE_WOOD);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ORANGE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_ORANGE_LOG.get()), blockTexture(ModBlocks.STRIPPED_ORANGE_LOG.get()));
            blockItem(ModBlocks.STRIPPED_ORANGE_WOOD);

            leavesBlock(ModBlocks.ORANGE_LEAVES);

            blockWithItem(ModBlocks.ORANGE_PLANKS);

            doorBlockWithRenderType((DoorBlock) ModBlocks.ORANGE_DOOR.get(), modLoc("block/orange_door_bottom"), modLoc("block/orange_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.ORANGE_TRAPDOOR.get(), modLoc("block/orange_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) ModBlocks.ORANGE_BUTTON.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) ModBlocks.ORANGE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            slabBlock((SlabBlock) ModBlocks.ORANGE_SLAB.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
            stairsBlock((StairBlock) ModBlocks.ORANGE_STAIRS.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            fenceBlock((FenceBlock) ModBlocks.ORANGE_FENCE.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) ModBlocks.ORANGE_FENCEGATE.get(), blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            signBlock((StandingSignBlock) ModBlocks.ORANGE_SIGN.get(), (WallSignBlock) ModBlocks.ORANGE_WALL_SIGN.get(),
                    blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            hangingSignBlock(ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.ORANGE_PLANKS.get()));

            //Lemon
            saplingBlock(ModBlocks.LEMON_SAPLING);

            logBlock((RotatedPillarBlock) ModBlocks.LEMON_LOG.get());
            blockItem(ModBlocks.LEMON_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LEMON_LOG.get(), blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()),
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/stripped_lemon_log_top"));
            blockItem(ModBlocks.STRIPPED_LEMON_LOG);

            axisBlock((RotatedPillarBlock) ModBlocks.LEMON_WOOD.get(), blockTexture(ModBlocks.LEMON_LOG.get()), blockTexture(ModBlocks.LEMON_LOG.get()));
            blockItem(ModBlocks.LEMON_WOOD);

            axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LEMON_WOOD.get(), blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()), blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()));
            blockItem(ModBlocks.STRIPPED_LEMON_WOOD);

            leavesBlock(ModBlocks.LEMON_LEAVES);

            blockWithItem(ModBlocks.LEMON_PLANKS);

            doorBlockWithRenderType((DoorBlock) ModBlocks.LEMON_DOOR.get(), modLoc("block/lemon_door_bottom"), modLoc("block/lemon_door_top"), "cutout");

            trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.LEMON_TRAPDOOR.get(), modLoc("block/lemon_trapdoor"), true, "cutout");

            buttonBlock((ButtonBlock) ModBlocks.LEMON_BUTTON.get(), blockTexture(ModBlocks.LEMON_PLANKS.get()));

            pressurePlateBlock((PressurePlateBlock) ModBlocks.LEMON_PRESSURE_PLATE.get(), blockTexture(ModBlocks.LEMON_PLANKS.get()));

            slabBlock((SlabBlock) ModBlocks.LEMON_SLAB.get(), blockTexture(ModBlocks.LEMON_PLANKS.get()), blockTexture(ModBlocks.LEMON_PLANKS.get()));
            stairsBlock((StairBlock) ModBlocks.LEMON_STAIRS.get(), blockTexture(ModBlocks.LEMON_PLANKS.get()));

            fenceBlock((FenceBlock) ModBlocks.LEMON_FENCE.get(), blockTexture(ModBlocks.LEMON_PLANKS.get()));
            fenceGateBlock((FenceGateBlock) ModBlocks.LEMON_FENCEGATE.get(), blockTexture(ModBlocks.LEMON_PLANKS.get()));

            signBlock((StandingSignBlock) ModBlocks.LEMON_SIGN.get(), (WallSignBlock) ModBlocks.LEMON_WALL_SIGN.get(),
                    blockTexture(ModBlocks.LEMON_PLANKS.get()));

            hangingSignBlock(ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get(),
                    blockTexture(ModBlocks.LEMON_PLANKS.get()));

            //Lime
            saplingBlock(ModBlocks.LIME_SAPLING);
            leavesBlock(ModBlocks.LIME_LEAVES);
    }
    //Crops
        //Yerba mate
        public void makeYerbaMateCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> yerbaMateStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] yerbaMateStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((YerbaMateCropBlock) block).getAgeProperty()),
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + textureName + state.getValue(((YerbaMateCropBlock) block).getAgeProperty()))).renderType("cutout"));

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
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + textureName + state.getValue(((ZapalloCropBlock) block).getAgeProperty()))).renderType("cutout"));

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
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + textureName + state.getValue(((EggplantCropBlock) block).getAgeProperty()))).renderType("cutout"));

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
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

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
                    new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(EnhancedPlaythrough.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void doublePlantBlock(RegistryObject<Block> pBlock){
        Function<BlockState, ConfiguredModel[]> model = blockState -> doublePlantModel(blockState, pBlock);

        getVariantBuilder(pBlock.get()).forAllStates(model);
    }

    private ConfiguredModel[] doublePlantModel(BlockState state, RegistryObject<Block> pBlock){
        String path = ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath() + "_";

        ConfiguredModel[] plantModel = new ConfiguredModel[1];

        plantModel[0] = new ConfiguredModel(models().cross(path + state.getValue(HALF),
                new ResourceLocation(EnhancedPlaythrough.MOD_ID, "block/" + path + state.getValue(HALF))).renderType("cutout"));

        return plantModel;
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void wildCropBlock(RegistryObject<Block> pBlock, boolean isCross){
        if (isCross){
            simpleBlock(pBlock.get(), models().cross(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), blockTexture(pBlock.get())).renderType("cutout"));
        } else {
            simpleBlock(pBlock.get(), models().crop(ForgeRegistries.BLOCKS.getKey(pBlock.get()).getPath(), blockTexture(pBlock.get())).renderType("cutout"));
        }
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
