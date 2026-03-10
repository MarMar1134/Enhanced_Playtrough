package net.marmar.enhanced_playthrough.entity;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.bandit.Bandit;
import net.marmar.enhanced_playthrough.entity.boat.EPBoatEntity;
import net.marmar.enhanced_playthrough.entity.boat.EPChestBoatEntity;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.Werellager;
import net.marmar.enhanced_playthrough.entity.projectile.AluminumArrowEntity;
import net.marmar.enhanced_playthrough.entity.projectile.CobbleProjectileEntity;
import net.marmar.enhanced_playthrough.entity.skeletonbowmaster.SkeletonBowmaster;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EnhancedPlaythrough.MOD_ID);

    //Mobs
    public static final RegistryObject<EntityType<Bandit>> BANDIT =
            ENTITY_TYPES.register("bandit", ()-> EntityType.Builder.of(Bandit::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("bandit"));
    public static final RegistryObject<EntityType<ZombieKnight>> ZOMBIE_KNIGHT =
            ENTITY_TYPES.register("zombie_knight", () -> EntityType.Builder.of(ZombieKnight::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).build("zombie_knight"));
    public static final RegistryObject<EntityType<SkeletonBowmaster>> SKELETON_BOWMASTER =
            ENTITY_TYPES.register("skeleton_bowmaster", () -> EntityType.Builder.of(SkeletonBowmaster::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).build("skeleton_bowmaster"));
    public static final RegistryObject<EntityType<Werellager>> WERELLAGER =
            ENTITY_TYPES.register("werellager", () -> EntityType.Builder.of(Werellager::new, MobCategory.CREATURE)
                    .sized(0.6f, 2f).build("werellager"));

    //Boats
    public static final RegistryObject<EntityType<EPBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<EPBoatEntity>of(EPBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<EPChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<EPChestBoatEntity>of(EPChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));

    //Projectiles
    public static final RegistryObject<EntityType<CobbleProjectileEntity>> THROWABLE_COBBLE =
            ENTITY_TYPES.register("throwable_cobble", () -> EntityType.Builder.<CobbleProjectileEntity>of(CobbleProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("throwable_cobble"));
    public static final RegistryObject<EntityType<AluminumArrowEntity>> ALUMINUM_ARROW =
            ENTITY_TYPES.register("aluminum_arrow", () -> EntityType.Builder.<AluminumArrowEntity>of(AluminumArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
                    .build("aluminum_arrow"));

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough entities...");
        ENTITY_TYPES.register(eventBus);
    }
}
