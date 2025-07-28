package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.marmar.enhanced_playthrough.util.particle.BleedParticle;
import net.marmar.enhanced_playthrough.util.particle.EPParticleTypes;
import net.marmar.enhanced_playthrough.entity.bandit.Bandit;
import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EPEventBusEvents {
    @SubscribeEvent
    public static void registerParticleSpriteSet(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(EPParticleTypes.BLEED_PARTICLE.get(), BleedParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(EPEntityTypes.BANDIT.get(), Bandit.addAttributes().build());
        event.put(EPEntityTypes.ZOMBIE_KNIGHT.get(), ZombieKnight.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerMobSpawns(SpawnPlacementRegisterEvent event){
        event.register(EPEntityTypes.ZOMBIE_KNIGHT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ZombieKnight::checkZombieKnightSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
