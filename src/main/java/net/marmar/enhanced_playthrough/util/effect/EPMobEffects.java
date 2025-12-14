package net.marmar.enhanced_playthrough.util.effect;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EPMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(
            Registries.MOB_EFFECT, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding",
            ()-> new BleedingEffect(MobEffectCategory.HARMFUL, 7742255));
    public static final RegistryObject<MobEffect> FROSTBITE = MOB_EFFECTS.register("frostbite",
            ()-> new FrostbiteEffect(MobEffectCategory.NEUTRAL, 9562354));

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough mob effects...");
        MOB_EFFECTS.register(eventBus);
    }
}
