package net.marmar.enhanced_playthrough.block;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.custom.alchemicalduplicator.AlchemicalDuplicatorBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.AdobeAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.SoulAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.SuperAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.entity.AdobeFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.entity.SoulFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.gempolisher.GemPolisherBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.grinder.entity.MechanicalGrinderBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.grinder.entity.PrimalGrinderBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.epfurnace.entity.MasonryFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.growthdetector.GrowthDetectorBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.leatherworker.LeatherworkerStationBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.wood.sign.entity.EPHangingSignBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.wood.sign.entity.EPSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<BlockEntityType<AdobeFurnaceBlockEntity>> ADOBE_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("adobe_furnace",
                    () -> BlockEntityType.Builder.of(AdobeFurnaceBlockEntity::new, EPBlocks.ADOBE_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoulFurnaceBlockEntity>> SOUL_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soul_furnace",
                    () -> BlockEntityType.Builder.of(SoulFurnaceBlockEntity::new, EPBlocks.SOUL_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<MasonryFurnaceBlockEntity>> MASONRY_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("masonry_furnace",
                    () -> BlockEntityType.Builder.of(MasonryFurnaceBlockEntity::new, EPBlocks.MASONRY_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<AdobeAlloyFurnaceBlockEntity>> ADOBE_ALLOY_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("adobe_alloy_furnace",
                    () -> BlockEntityType.Builder.of(AdobeAlloyFurnaceBlockEntity::new, EPBlocks.ADOBE_ALLOY_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SuperAlloyFurnaceBlockEntity>> SUPER_ALLOY_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("super_alloy_furnace",
                    () -> BlockEntityType.Builder.of(SuperAlloyFurnaceBlockEntity::new, EPBlocks.SUPER_ALLOY_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoulAlloyFurnaceBlockEntity>> SOUL_ALLOY_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soul_alloy_furnace",
                    () -> BlockEntityType.Builder.of(SoulAlloyFurnaceBlockEntity::new, EPBlocks.SOUL_ALLOY_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<GemPolisherBlockEntity>> GEM_POLISHER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_polisher_block",
                    () -> BlockEntityType.Builder.of(GemPolisherBlockEntity::new, EPBlocks.GEM_POLISHER.get()).build(null));

    public static final RegistryObject<BlockEntityType<PrimalGrinderBlockEntity>> PRIMAL_GRINDER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("primal_grinder_block",
                    () -> BlockEntityType.Builder.of(PrimalGrinderBlockEntity::new, EPBlocks.PRIMAL_GRINDER.get()).build(null));
    public static final RegistryObject<BlockEntityType<MechanicalGrinderBlockEntity>> MECHANICAL_GRINDER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mechanical_grinder_block",
                    () -> BlockEntityType.Builder.of(MechanicalGrinderBlockEntity::new, EPBlocks.MECHANICAL_GRINDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlchemicalDuplicatorBlockEntity>> ALCHEMICAL_DUPLICATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("alchemical_duplicator_block",
                    () -> BlockEntityType.Builder.of(AlchemicalDuplicatorBlockEntity::new, EPBlocks.ALCHEMICAL_DUPLICATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<LeatherworkerStationBlockEntity>> LEATHERWORKER_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("leatherworker_station_block_entity",
                    () -> BlockEntityType.Builder.of(LeatherworkerStationBlockEntity::new, EPBlocks.LEATHERWORKER_STATION.get()).build(null));

    //Signs
    public static final RegistryObject<BlockEntityType<EPSignBlockEntity>> SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mod_sign_block", () -> BlockEntityType
                    .Builder.of(EPSignBlockEntity::new,
                            EPBlocks.WALNUT_SIGN.get(), EPBlocks.WALNUT_WALL_SIGN.get(),
                            EPBlocks.APPLE_SIGN.get(), EPBlocks.APPLE_WALL_SIGN.get(),
                            EPBlocks.ORANGE_SIGN.get(), EPBlocks.ORANGE_WALL_SIGN.get(),
                            EPBlocks.LEMON_SIGN.get(), EPBlocks.LEMON_WALL_SIGN.get())
                    .build(null));

    //Hanging signs
    public static final RegistryObject<BlockEntityType<EPHangingSignBlockEntity>> HANGING_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mod_hanging_sign_block", () -> BlockEntityType
                    .Builder.of(EPHangingSignBlockEntity::new,
                            EPBlocks.WALNUT_HANGING_SIGN.get(), EPBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                            EPBlocks.APPLE_HANGING_SIGN.get(), EPBlocks.APPLE_WALL_HANGING_SIGN.get(),
                            EPBlocks.ORANGE_HANGING_SIGN.get(), EPBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                            EPBlocks.LEMON_HANGING_SIGN.get(), EPBlocks.LEMON_WALL_HANGING_SIGN.get())
                    .build(null));

    //Growth detector
    public static final RegistryObject<BlockEntityType<GrowthDetectorBlockEntity>> GROWTH_DETECTOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("growth_detector_block", () -> BlockEntityType
                    .Builder.of(GrowthDetectorBlockEntity::new, EPBlocks.GROWTH_DETECTOR.get()).build(null));

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough block entities...");
        BLOCK_ENTITIES.register(eventBus);
    }
}
