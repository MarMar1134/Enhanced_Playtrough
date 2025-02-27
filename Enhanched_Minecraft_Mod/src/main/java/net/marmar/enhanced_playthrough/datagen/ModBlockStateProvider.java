package net.marmar.enhanced_playthrough.datagen;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.custom.crops.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnhancedPlaythrough.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Stone
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

        blockWithItem(ModBlocks.RUBI_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_RUBI_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        blockWithItem(ModBlocks.NETHER_GARNET_ORE);

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

        //Crops
        makeYerbaMateCrop((CropBlock) ModBlocks.YERBA_MATE_CROP.get(), "yerba_mate_stage","yerba_mate_stage");
        makeZapalloCrop((CropBlock) ModBlocks.ZAPALLO_CROP.get(), "zapallo_stage","zapallo_stage");
        makeEggplantCrop((CropBlock) ModBlocks.EGGPLANT_CROP.get(), "eggplant_stage","eggplant_stage");
        makeTomatoCrop((CropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_stage","tomato_stage");
        makeCornCrop((CropBlock) ModBlocks.CORN_CROP.get(), "corn_stage","corn_stage");
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
}
