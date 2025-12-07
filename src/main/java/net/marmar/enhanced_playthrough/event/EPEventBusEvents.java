package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.projectile.AluminumArrowEntity;
import net.marmar.enhanced_playthrough.entity.projectile.CobbleProjectileEntity;
import net.marmar.enhanced_playthrough.entity.skeletonbowmaster.SkeletonBowmaster;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.particle.BleedParticle;
import net.marmar.enhanced_playthrough.util.particle.EPParticleTypes;
import net.marmar.enhanced_playthrough.entity.bandit.Bandit;
import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EPEventBusEvents {
    @SubscribeEvent
    public static void registerDispensableEntities(FMLCommonSetupEvent event){
        //Cobble pieces
        DispenserBlock.registerBehavior(EPItems.COBBLE.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.LIMESTONE_COBBLE.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.BLACKSTONE_COBBLE.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.DEEPSLATE_COBBLE.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.NETHERRACK_RUBBLE.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });

        //Terracotta shards
        DispenserBlock.registerBehavior(EPItems.TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.WHITE_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.ORANGE_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.MAGENTA_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.LIGHT_BLUE_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.YELLOW_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.LIME_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.PINK_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.GRAY_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.LIGHT_GRAY_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.CYAN_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.PURPLE_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.BLUE_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.BROWN_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.GREEN_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.RED_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });
        DispenserBlock.registerBehavior(EPItems.BLACK_TERRACOTTA_SHARD.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new CobbleProjectileEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()),
                        (cobbleProjectileEntity -> cobbleProjectileEntity.setItem(pStack)));
            }
        });

        //Aluminum arrow
        DispenserBlock.registerBehavior(EPItems.ALUMINUM_ARROW.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                AluminumArrowEntity aluminumArrow = new AluminumArrowEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z());
                aluminumArrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return aluminumArrow;
            }
        });
    }

    @SubscribeEvent
    public static void registerParticleSpriteSet(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(EPParticleTypes.BLEED_PARTICLE.get(), BleedParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(EPEntityTypes.BANDIT.get(), Bandit.addAttributes().build());
        event.put(EPEntityTypes.ZOMBIE_KNIGHT.get(), ZombieKnight.createAttributes().build());
        event.put(EPEntityTypes.SKELETON_BOWMASTER.get(), SkeletonBowmaster.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerMobSpawns(SpawnPlacementRegisterEvent event){
        event.register(EPEntityTypes.ZOMBIE_KNIGHT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ZombieKnight::checkZombieKnightSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EPEntityTypes.SKELETON_BOWMASTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SkeletonBowmaster::checkSkeletonBowmasterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }
}
