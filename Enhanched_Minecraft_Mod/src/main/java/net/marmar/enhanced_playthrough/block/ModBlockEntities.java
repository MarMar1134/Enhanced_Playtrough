package net.marmar.enhanced_playthrough.block;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.AdobeAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.SoulAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.alloyfurnace.entity.SuperAlloyFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.basicfurnace.entity.AdobeFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.basicfurnace.entity.SoulFurnaceBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.gempolisher.entity.GemPolisherBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.grinder.entity.MechanicalGrinderBlockEntity;
import net.marmar.enhanced_playthrough.block.custom.grinder.entity.PrimalGrinderBlockEntity;
import net.marmar.enhanced_playthrough.block.wood.sign.entity.ModHangingSignBlockEntity;
import net.marmar.enhanced_playthrough.block.wood.sign.entity.ModSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<BlockEntityType<AdobeFurnaceBlockEntity>> ADOBE_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("adobe_furnace", () -> BlockEntityType
                    .Builder.of(AdobeFurnaceBlockEntity::new,ModBlocks.ADOBE_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoulFurnaceBlockEntity>> SOUL_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soul_furnace", () -> BlockEntityType
                    .Builder.of(SoulFurnaceBlockEntity::new,ModBlocks.SOUL_FURNACE.get()).build(null));


    public static final RegistryObject<BlockEntityType<AdobeAlloyFurnaceBlockEntity>> ADOBE_ALLOYING_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("adobe_alloying_furnace", () -> BlockEntityType
                    .Builder.of(AdobeAlloyFurnaceBlockEntity::new,ModBlocks.ADOBE_ALLOYING_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SuperAlloyFurnaceBlockEntity>> SUPER_ALLOYING_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("super_alloying_furnace", () -> BlockEntityType
                    .Builder.of(SuperAlloyFurnaceBlockEntity::new,ModBlocks.SUPER_ALLOYING_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoulAlloyFurnaceBlockEntity>> SOUL_ALLOY_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soul_alloy_furnace", () -> BlockEntityType
                    .Builder.of(SoulAlloyFurnaceBlockEntity::new,ModBlocks.SOUL_ALLOY_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<GemPolisherBlockEntity>> GEM_POLISHER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_polisher_block", () -> BlockEntityType
                    .Builder.of(GemPolisherBlockEntity::new,ModBlocks.GEM_POLISHER.get()).build(null));

    public static final RegistryObject<BlockEntityType<PrimalGrinderBlockEntity>> PRIMAL_GRINDER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("primal_grinder_block", () -> BlockEntityType
                    .Builder.of(PrimalGrinderBlockEntity::new,ModBlocks.PRIMAL_GRINDER.get()).build(null));
    public static final RegistryObject<BlockEntityType<MechanicalGrinderBlockEntity>> MECHANICAL_GRINDER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mechanical_grinder_block", () -> BlockEntityType
                    .Builder.of(MechanicalGrinderBlockEntity::new,ModBlocks.MECHANICAL_GRINDER.get()).build(null));

    //Signs
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mod_sign_block", () -> BlockEntityType
                    .Builder.of(ModSignBlockEntity::new,
                            ModBlocks.WALNUT_SIGN.get(), ModBlocks.WALNUT_WALL_SIGN.get(),
                            ModBlocks.APPLE_SIGN.get(), ModBlocks.APPLE_WALL_SIGN.get(),
                            ModBlocks.ORANGE_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get(),
                            ModBlocks.LEMON_SIGN.get(), ModBlocks.LEMON_WALL_SIGN.get())
                    .build(null));

    //Hanging signs
    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> HANGING_SIGN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mod_hanging_sign_block", () -> BlockEntityType
                    .Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.WALNUT_HANGING_SIGN.get(), ModBlocks.WALNUT_WALL_HANGING_SIGN.get(),
                            ModBlocks.APPLE_HANGING_SIGN.get(), ModBlocks.APPLE_WALL_HANGING_SIGN.get(),
                            ModBlocks.ORANGE_HANGING_SIGN.get(), ModBlocks.ORANGE_WALL_HANGING_SIGN.get(),
                            ModBlocks.LEMON_HANGING_SIGN.get(), ModBlocks.LEMON_WALL_HANGING_SIGN.get())
                    .build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
