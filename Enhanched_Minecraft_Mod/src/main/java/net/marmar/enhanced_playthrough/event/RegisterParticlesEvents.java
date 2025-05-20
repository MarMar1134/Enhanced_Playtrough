package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.Util.particle.BleedParticle;
import net.marmar.enhanced_playthrough.Util.particle.ModParticles;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterParticlesEvents {
    @SubscribeEvent
    public static void registerParticleSpriteSet(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.BLEED_PARTICLE.get(), BleedParticle.Provider::new);
    }
}
