package net.marmar.enhanced_playthrough.block;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.custom.plant.DesertFlowerBlock;
import net.marmar.enhanced_playthrough.block.custom.plant.DoublePlantGrowingHeadBlock;
import net.marmar.enhanced_playthrough.block.custom.plant.TallReedsBlock;
import net.marmar.enhanced_playthrough.block.custom.plant.WaterReedsBlock;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.AdobeAlloyFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.SoulAlloyFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.SuperAlloyFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.crop.*;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.AdobeFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.SoulFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.gempolisher.GemPolisherBlock;
import net.marmar.enhanced_playthrough.block.custom.grinder.MechanicalGrinderBlock;
import net.marmar.enhanced_playthrough.block.custom.grinder.PrimalGrinderBlock;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.MasonryFurnaceBlock;
import net.marmar.enhanced_playthrough.block.custom.growthdetector.GrowthDetectorBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.leaves.EPLeavesBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.EPLogsBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.EPPlanksBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.EPWoodTypes;
import net.marmar.enhanced_playthrough.block.custom.wood.leaves.LeavesWithFruitBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.sign.EPHangingSignBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.sign.EPStandingSignBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.sign.EPWallHangingSignBlock;
import net.marmar.enhanced_playthrough.block.custom.wood.sign.EPWallSignBlock;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.effect.EPMobEffects;
import net.marmar.enhanced_playthrough.worldgen.tree.grower.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EPBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedPlaythrough.MOD_ID);

    //Blocks
        //Wood
            //Walnut
            public static final RegistryObject<Block> WALNUT_SAPLING = registerBlockWithItem("walnut_sapling",
                    () -> new SaplingBlock(new WalnutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
            public static final RegistryObject<Block> WALNUT_LOG = registerBlockWithItem("walnut_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
            public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = registerBlockWithItem("stripped_walnut_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
            public static final RegistryObject<Block> WALNUT_WOOD = registerBlockWithItem("walnut_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
            public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = registerBlockWithItem("stripped_walnut_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
            public static final RegistryObject<Block> WALNUT_LEAVES = registerBlockWithItem("walnut_leaves",
                    () -> new EPLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
            public static final RegistryObject<Block> WALNUT_PLANKS = registerBlockWithItem("walnut_planks",
                    () -> new EPPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
            public static final RegistryObject<Block> WALNUT_DOOR = registerBlockWithItem("walnut_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_TRAPDOOR = registerBlockWithItem("walnut_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_BUTTON = registerBlockWithItem("walnut_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> WALNUT_PRESSURE_PLATE = registerBlockWithItem("walnut_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_SLAB = registerBlockWithItem("walnut_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
            public static final RegistryObject<Block> WALNUT_STAIRS = registerBlockWithItem("walnut_stair",
                    () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

            public static final RegistryObject<Block> WALNUT_FENCE = registerBlockWithItem("walnut_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
            public static final RegistryObject<Block> WALNUT_FENCEGATE = registerBlockWithItem("walnut_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

            public static final RegistryObject<Block> WALNUT_SIGN = BLOCKS.register("walnut_sign",
                    () -> new EPStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), EPWoodTypes.WALNUT));
            public static final RegistryObject<Block> WALNUT_WALL_SIGN = BLOCKS.register("walnut_wall_sign",
                    () -> new EPWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), EPWoodTypes.WALNUT));

            public static final RegistryObject<Block> WALNUT_HANGING_SIGN = BLOCKS.register("walnut_hanging_sign",
                    () -> new EPHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), EPWoodTypes.WALNUT));
            public static final RegistryObject<Block> WALNUT_WALL_HANGING_SIGN = BLOCKS.register("walnut_wall_hanging_sign",
                    () -> new EPWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), EPWoodTypes.WALNUT));

            //Apple
            public static final RegistryObject<Block> APPLE_SAPLING = registerBlockWithItem("apple_sapling",
                    () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
            public static final RegistryObject<Block> GREEN_APPLE_SAPLING = registerBlockWithItem("green_apple_sapling",
                    () -> new SaplingBlock(new GreenAppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
            public static final RegistryObject<Block> APPLE_LOG = registerBlockWithItem("apple_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
            public static final RegistryObject<Block> STRIPPED_APPLE_LOG = registerBlockWithItem("stripped_apple_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
            public static final RegistryObject<Block> APPLE_WOOD = registerBlockWithItem("apple_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
            public static final RegistryObject<Block> STRIPPED_APPLE_WOOD = registerBlockWithItem("stripped_apple_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
            public static final RegistryObject<Block> APPLE_LEAVES = registerBlockWithItem("apple_leaves",
                    () -> new EPLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
            public static final RegistryObject<Block> APPLE_LEAVES_WITH_FRUIT = registerBlockWithItem("apple_leaves_with_fruit",
                    () -> new LeavesWithFruitBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), () -> Items.APPLE));
            public static final RegistryObject<Block> GREEN_APPLE_LEAVES = registerBlockWithItem("green_apple_leaves",
                    () -> new EPLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
            public static final RegistryObject<Block> GREEN_APPLE_LEAVES_WITH_FRUIT = registerBlockWithItem("green_apple_leaves_with_fruit",
                    () -> new LeavesWithFruitBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), EPItems.GREEN_APPLE));
            public static final RegistryObject<Block> APPLE_PLANKS = registerBlockWithItem("apple_planks",
                    () -> new EPPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
            public static final RegistryObject<Block> APPLE_DOOR = registerBlockWithItem("apple_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_TRAPDOOR = registerBlockWithItem("apple_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_BUTTON = registerBlockWithItem("apple_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> APPLE_PRESSURE_PLATE = registerBlockWithItem("apple_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_SLAB = registerBlockWithItem("apple_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
            public static final RegistryObject<Block> APPLE_STAIRS = registerBlockWithItem("apple_stair",
                    () -> new StairBlock(() -> APPLE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

            public static final RegistryObject<Block> APPLE_FENCE = registerBlockWithItem("apple_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
            public static final RegistryObject<Block> APPLE_FENCEGATE = registerBlockWithItem("apple_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

            public static final RegistryObject<Block> APPLE_SIGN = BLOCKS.register("apple_sign",
                    () -> new EPStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), EPWoodTypes.APPLE));
            public static final RegistryObject<Block> APPLE_WALL_SIGN = BLOCKS.register("apple_wall_sign",
                    () -> new EPWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), EPWoodTypes.APPLE));

            public static final RegistryObject<Block> APPLE_HANGING_SIGN = BLOCKS.register("apple_hanging_sign",
                    () -> new EPHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), EPWoodTypes.APPLE));
            public static final RegistryObject<Block> APPLE_WALL_HANGING_SIGN = BLOCKS.register("apple_wall_hanging_sign",
                    () -> new EPWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), EPWoodTypes.APPLE));

            //Orange
            public static final RegistryObject<Block> ORANGE_SAPLING = registerBlockWithItem("orange_sapling",
                    () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
            public static final RegistryObject<Block> ORANGE_LOG = registerBlockWithItem("orange_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
            public static final RegistryObject<Block> STRIPPED_ORANGE_LOG = registerBlockWithItem("stripped_orange_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
            public static final RegistryObject<Block> ORANGE_WOOD = registerBlockWithItem("orange_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
            public static final RegistryObject<Block> STRIPPED_ORANGE_WOOD = registerBlockWithItem("stripped_orange_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
            public static final RegistryObject<Block> ORANGE_LEAVES = registerBlockWithItem("orange_leaves",
                    () -> new EPLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
            public static final RegistryObject<Block> ORANGE_LEAVES_WITH_FRUIT = registerBlockWithItem("orange_leaves_with_fruit",
                    () -> new LeavesWithFruitBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), EPItems.ORANGE));
            public static final RegistryObject<Block> ORANGE_PLANKS = registerBlockWithItem("orange_planks",
                    () -> new EPPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
            public static final RegistryObject<Block> ORANGE_DOOR = registerBlockWithItem("orange_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> ORANGE_TRAPDOOR = registerBlockWithItem("orange_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> ORANGE_BUTTON = registerBlockWithItem("orange_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> ORANGE_PRESSURE_PLATE = registerBlockWithItem("orange_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
            public static final RegistryObject<Block> ORANGE_SLAB = registerBlockWithItem("orange_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
            public static final RegistryObject<Block> ORANGE_STAIRS = registerBlockWithItem("orange_stair",
                    () -> new StairBlock(() -> ORANGE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

            public static final RegistryObject<Block> ORANGE_FENCE = registerBlockWithItem("orange_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
            public static final RegistryObject<Block> ORANGE_FENCEGATE = registerBlockWithItem("orange_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

            public static final RegistryObject<Block> ORANGE_SIGN = BLOCKS.register("orange_sign",
                    () -> new EPStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), EPWoodTypes.ORANGE));
            public static final RegistryObject<Block> ORANGE_WALL_SIGN = BLOCKS.register("orange_wall_sign",
                    () -> new EPWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), EPWoodTypes.ORANGE));

            public static final RegistryObject<Block> ORANGE_HANGING_SIGN = BLOCKS.register("orange_hanging_sign",
                    () -> new EPHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), EPWoodTypes.ORANGE));
            public static final RegistryObject<Block> ORANGE_WALL_HANGING_SIGN = BLOCKS.register("orange_wall_hanging_sign",
                    () -> new EPWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), EPWoodTypes.ORANGE));

            //Lemon
            public static final RegistryObject<Block> LEMON_SAPLING = registerBlockWithItem("lemon_sapling",
                    () -> new SaplingBlock(new LemonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
            public static final RegistryObject<Block> LEMON_LOG = registerBlockWithItem("lemon_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
            public static final RegistryObject<Block> STRIPPED_LEMON_LOG = registerBlockWithItem("stripped_lemon_log",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
            public static final RegistryObject<Block> LEMON_WOOD = registerBlockWithItem("lemon_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
            public static final RegistryObject<Block> STRIPPED_LEMON_WOOD = registerBlockWithItem("stripped_lemon_wood",
                    () -> new EPLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
            public static final RegistryObject<Block> LEMON_LEAVES = registerBlockWithItem("lemon_leaves",
                    () -> new EPLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
            public static final RegistryObject<Block> LEMON_LEAVES_WITH_FRUIT = registerBlockWithItem("lemon_leaves_with_fruit",
                    () -> new LeavesWithFruitBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), EPItems.LEMON));
            public static final RegistryObject<Block> LEMON_PLANKS = registerBlockWithItem("lemon_planks",
                    () -> new EPPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
            public static final RegistryObject<Block> LEMON_DOOR = registerBlockWithItem("lemon_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> LEMON_TRAPDOOR = registerBlockWithItem("lemon_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.OAK));
            public static final RegistryObject<Block> LEMON_BUTTON = registerBlockWithItem("lemon_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> LEMON_PRESSURE_PLATE = registerBlockWithItem("lemon_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
            public static final RegistryObject<Block> LEMON_SLAB = registerBlockWithItem("lemon_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
            public static final RegistryObject<Block> LEMON_STAIRS = registerBlockWithItem("lemon_stair",
                    () -> new StairBlock(() -> LEMON_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

            public static final RegistryObject<Block> LEMON_FENCE = registerBlockWithItem("lemon_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
            public static final RegistryObject<Block> LEMON_FENCEGATE = registerBlockWithItem("lemon_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

            public static final RegistryObject<Block> LEMON_SIGN = BLOCKS.register("lemon_sign",
                    () -> new EPStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), EPWoodTypes.LEMON));
            public static final RegistryObject<Block> LEMON_WALL_SIGN = BLOCKS.register("lemon_wall_sign",
                    () -> new EPWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), EPWoodTypes.LEMON));

            public static final RegistryObject<Block> LEMON_HANGING_SIGN = BLOCKS.register("lemon_hanging_sign",
                    () -> new EPHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), EPWoodTypes.LEMON));
            public static final RegistryObject<Block> LEMON_WALL_HANGING_SIGN = BLOCKS.register("lemon_wall_hanging_sign",
                    () -> new EPWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), EPWoodTypes.LEMON));

            //Lime
            public static final RegistryObject<Block> LIME_SAPLING = registerBlockWithItem("lime_sapling",
                    () -> new SaplingBlock(new LimeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
            public static final RegistryObject<Block> LIME_LEAVES = registerBlockWithItem("lime_leaves",
                    () -> new EPLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
        public static final RegistryObject<Block> LIME_LEAVES_WITH_FRUIT = registerBlockWithItem("lime_leaves_with_fruit",
                () -> new LeavesWithFruitBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), EPItems.LIME));

        //Polished stone
        public static final RegistryObject<Block> POLISHED_STONE = registerBlockWithItem("polished_stone",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_SLAB = registerBlockWithItem("polished_stone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_STAIRS = registerBlockWithItem("polished_stone_stair",
                () -> new StairBlock(() -> EPBlocks.POLISHED_STONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_WALL = registerBlockWithItem("polished_stone_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

        //Limestone
            //cobbled
            public static final RegistryObject<Block> COBBLED_LIMESTONE = registerBlockWithItem("cobbeled_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_SLAB = registerBlockWithItem("cobbeled_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_STAIRS = registerBlockWithItem("cobbeled_limestone_stair",
                    () -> new StairBlock(() -> COBBLED_LIMESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_WALL = registerBlockWithItem("cobbeled_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_WALL).requiresCorrectToolForDrops()));

            //natural
            public static final RegistryObject<Block> LIMESTONE = registerBlockWithItem("limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_SLAB = registerBlockWithItem("limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_STAIRS = registerBlockWithItem("limestone_stair",
                    () -> new StairBlock(() -> LIMESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_WALL = registerBlockWithItem("limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

            //polished
            public static final RegistryObject<Block> POLISHED_LIMESTONE = registerBlockWithItem("polished_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(EPBlocks.POLISHED_STONE.get()).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_SLAB = registerBlockWithItem("polished_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_STAIRS = registerBlockWithItem("polished_limestone_stair",
                    () -> new StairBlock(() -> EPBlocks.POLISHED_LIMESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_WALL = registerBlockWithItem("polished_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

            //bricks
            public static final RegistryObject<Block> LIMESTONE_BRICKS = registerBlockWithItem("limestone_brick",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_SLAB = registerBlockWithItem("limestone_brick_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_STAIRS = registerBlockWithItem("limestone_brick_stair",
                    () -> new StairBlock(() -> LIMESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_WALL = registerBlockWithItem("limestone_brick_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

        //Soul
        public static final RegistryObject<Block> SOUL_MUD = registerBlockWithItem("soul_mud",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICKS = registerBlockWithItem("soul_mud_brick",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_SLAB = registerBlockWithItem("soul_mud_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_STAIRS = registerBlockWithItem("soul_mud_brick_stair",
                () -> new StairBlock(() -> SOUL_MUD_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_WALL = registerBlockWithItem("soul_mud_brick_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

        //Firebricks
        public static final RegistryObject<Block> FIREBRICKS = registerBlockWithItem("firebricks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).requiresCorrectToolForDrops().strength(3.5F, 6)));
        public static final RegistryObject<Block> FIREBRICK_SLAB = registerBlockWithItem("firebrick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB).requiresCorrectToolForDrops().strength(3.5F, 6)));
        public static final RegistryObject<Block> FIREBRICK_STAIRS = registerBlockWithItem("firebrick_stair",
                () -> new StairBlock(() -> FIREBRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS).requiresCorrectToolForDrops().strength(3.5F, 6)));
        public static final RegistryObject<Block> FIREBRICK_WALL = registerBlockWithItem("firebrick_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL).requiresCorrectToolForDrops().strength(3.5F, 6)));

        //Ores
        public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlockWithItem("nether_copper_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> TIN_ORE = registerBlockWithItem("tin_ore",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_ORE).requiresCorrectToolForDrops()));
         public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlockWithItem("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> ZINC_ORE = registerBlockWithItem("zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlockWithItem("deepslate_zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> NETHER_ZINC_ORE = registerBlockWithItem("nether_zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> SULFUR_ORE = registerBlockWithItem("sulfur_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_ORE)
                        .requiresCorrectToolForDrops(), UniformInt.of(2, 4)));
        public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = registerBlockWithItem("deepslate_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 4)));
        public static final RegistryObject<Block> NETHER_SULFUR_ORE = registerBlockWithItem("nether_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

        public static final RegistryObject<Block> SILVER_ORE = registerBlockWithItem("silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GOLD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlockWithItem("deepslate_silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> RUBY_ORE = registerBlockWithItem("ruby_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlockWithItem("sapphire_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlockWithItem("deepslate_ruby_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops(), ConstantInt.of(3)));
        public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlockWithItem("deepslate_sapphire_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> NETHER_GARNET_ORE = registerBlockWithItem("nether_garnet_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> COBALT_ORE = registerBlockWithItem("cobalt_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
        public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlockWithItem("deepslate_cobalt_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

        //Bauxite
        public static final RegistryObject<Block> BAUXITE = registerBlockWithItem("bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> WHITE_BAUXITE = registerBlockWithItem("white_bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> LIGHT_GRAY_BAUXITE = registerBlockWithItem("light_gray_bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> BROWN_BAUXITE = registerBlockWithItem("brown_bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> RED_BAUXITE = registerBlockWithItem("red_bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> ORANGE_BAUXITE = registerBlockWithItem("orange_bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> YELLOW_BAUXITE = registerBlockWithItem("yellow_bauxite",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).requiresCorrectToolForDrops()));

        //Raw ores blocks
        public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlockWithItem("raw_silver_block",
                ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));
        public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = registerBlockWithItem("raw_aluminum_block",
                ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).strength(2, 3)));
        public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlockWithItem("raw_tin_block",
                ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).strength(2, 3)));
        public static final RegistryObject<Block> RAW_ZINC_BLOCK = registerBlockWithItem("raw_zinc_block",
                ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).strength(2, 3)));

        //Ores blocks
        public static final RegistryObject<Block> SILVER_BLOCK = registerBlockWithItem("silver_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
        public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlockWithItem("aluminum_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2, 3)));
        public static final RegistryObject<Block> TIN_BLOCK = registerBlockWithItem("tin_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2, 3)));
        public static final RegistryObject<Block> ZINC_BLOCK = registerBlockWithItem("zinc_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2, 3)));
        public static final RegistryObject<Block> BRASS_BLOCK = registerBlockWithItem("brass_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2, 3)));
        public static final RegistryObject<Block> BRONZE_BLOCK = registerBlockWithItem("bronze_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3, 3)));
        public static final RegistryObject<Block> ROSE_GOLD_BLOCK = registerBlockWithItem("rose_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3, 3)));
        public static final RegistryObject<Block> BRONZIUM_BLOCK = registerBlockWithItem("bronzium_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3.5F, 5)));
        public static final RegistryObject<Block> STEEL_BLOCK = registerBlockWithItem("steel_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6, 6)));
        public static final RegistryObject<Block> GREEN_GOLD_BLOCK = registerBlockWithItem("green_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BLUE_GOLD_BLOCK = registerBlockWithItem("blue_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6, 8)));

        //Calibrated quartz
        public static final RegistryObject<Block> CALIBRATED_QUARTZ_BLOCK = registerBlockWithItem("calibrated_quartz_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
        public static final RegistryObject<Block> SMOOTH_CALIBRATED_QUARTZ_BLOCK = registerBlockWithItem("smooth_calibrated_quartz_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
        public static final RegistryObject<Block> CHISELED_CALIBRATED_QUARTZ_BLOCK = registerBlockWithItem("chiseled_calibrated_quartz_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
        public static final RegistryObject<Block> CALIBRATED_QUARTZ_PILLAR = registerBlockWithItem("calibrated_quartz_pillar",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
        public static final RegistryObject<Block> CALIBRATED_QUARTZ_BRICKS = registerBlockWithItem("calibrated_quartz_bricks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));

    //Entity blocks
        //Basic furnaces
        public static final RegistryObject<Block> ADOBE_FURNACE = registerBlockWithItem("adobe_furnace",
                () -> new AdobeFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> SOUL_FURNACE = registerBlockWithItem("soul_furnace",
                () -> new SoulFurnaceBlock(BlockBehaviour.Properties.copy(EPBlocks.SOUL_MUD.get()).noOcclusion()));

        //Masonry furnace
        public static final RegistryObject<Block> MASONRY_FURNACE = registerBlockWithItem("masonry_furnace",
                () -> new MasonryFurnaceBlock(BlockBehaviour.Properties.copy(EPBlocks.FIREBRICKS.get()).noOcclusion()));

        //Alloy furnaces
        public static final RegistryObject<Block> ADOBE_ALLOY_FURNACE = registerBlockWithItem("adobe_alloy_furnace",
                () -> new AdobeAlloyFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> SUPER_ALLOY_FURNACE = registerBlockWithItem("super_alloy_furnace",
                () -> new SuperAlloyFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
        public static final RegistryObject<Block> SOUL_ALLOY_FURNACE = registerBlockWithItem("soul_alloy_furnace",
                () -> new SoulAlloyFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));

        //Gem polisher
        public static final RegistryObject<Block> GEM_POLISHER = registerBlockWithItem("gem_polisher",
                () -> new GemPolisherBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

        //Grinders
        public static final RegistryObject<Block> PRIMAL_GRINDER = registerBlockWithItem("primal_grinder",
                () -> new PrimalGrinderBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).noOcclusion()));
        public static final RegistryObject<Block> MECHANICAL_GRINDER = registerBlockWithItem("mechanical_grinder",
                () -> new MechanicalGrinderBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

        //Growth detector
        public static final RegistryObject<Block> GROWTH_DETECTOR = registerBlockWithItem("growth_detector",
                () -> new GrowthDetectorBlock(BlockBehaviour.Properties.copy(Blocks.COMPARATOR).noOcclusion()));

    //Crops
    public static final RegistryObject<Block> YERBA_MATE_CROP = BLOCKS.register("yerba_mate_crop",
            () -> new YerbaMateCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> ZAPALLO_CROP = BLOCKS.register("zapallo_crop",
            () -> new ZapalloCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> EGGPLANT_CROP = BLOCKS.register("eggplant_crop",
            () -> new EggplantCropBlock(BlockBehaviour.Properties.copy(EPBlocks.YERBA_MATE_CROP.get()).noOcclusion().noCollission()));
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.copy(EPBlocks.YERBA_MATE_CROP.get()).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(EPBlocks.YERBA_MATE_CROP.get()).noOcclusion().noCollission()));

    //Wild crops
        public static final RegistryObject<Block> WILD_WHEAT_CROP = registerBlockWithItem("wild_wheat_crop",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion().noCollission().sound(SoundType.CROP)));
        public static final RegistryObject<Block> WILD_TOMATO_CROP = registerBlockWithItem("wild_tomato_crop",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion().noCollission().sound(SoundType.CROP)));
        public static final RegistryObject<Block> WILD_CORN_CROP = registerBlockWithItem("wild_corn_crop",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).noOcclusion().noCollission().sound(SoundType.CROP)));

    //Other plants
    public static final RegistryObject<Block> SMALL_REEDS = registerBlockWithItem("small_reeds",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> REEDS = registerBlockWithItem("reeds",
            () -> new DoublePlantGrowingHeadBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> TALL_REEDS = registerBlockWithItem("tall_reeds",
            () -> new TallReedsBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> WATER_REEDS = registerBlockWithItem("water_reeds",
            () -> new WaterReedsBlock(BlockBehaviour.Properties.copy(Blocks.SMALL_DRIPLEAF).noOcclusion().noCollission()));

    public static final RegistryObject<Block> COLD_LYRIUM = registerBlockWithItem("cold_lyrium",
            () -> new FlowerBlock(EPMobEffects.FROSTBITE, 10, BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_COLD_LYRIUM = registerBlockWithItem("potted_cold_lyrium",
            () -> new FlowerPotBlock(()-> (FlowerPotBlock) Blocks.FLOWER_POT, EPBlocks.COLD_LYRIUM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> SUCCULENT = registerBlockWithItem("succulent",
            () -> new DesertFlowerBlock(() -> MobEffects.REGENERATION, 10, BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_SUCCULENT = registerBlockWithItem("potted_succulent",
            () -> new FlowerPotBlock(()-> (FlowerPotBlock) Blocks.FLOWER_POT, EPBlocks.SUCCULENT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM ).noOcclusion()));

    //Block register
    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> block){
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, ToReturn);
        return ToReturn;
    }

    private static <T extends Block> void RegisterBlockItem(String name, RegistryObject<T> block){
        EPItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //Final register
    public static void Register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
