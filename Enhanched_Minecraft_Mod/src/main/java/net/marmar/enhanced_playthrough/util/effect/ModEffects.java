package net.marmar.enhanced_playthrough.util.effect;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(
            Registries.MOB_EFFECT, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<MobEffect> BLEEDING = MOD_EFFECTS.register("bleeding",
            ()-> new BleedingEffect(MobEffectCategory.HARMFUL, 7742255));

    public static void register(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }
}
