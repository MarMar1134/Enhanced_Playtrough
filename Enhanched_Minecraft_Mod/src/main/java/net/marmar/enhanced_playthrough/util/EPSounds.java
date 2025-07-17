package net.marmar.enhanced_playthrough.util;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<SoundEvent> GRIND_SOUND = registerSoundEvent("grind_sound");

    private static RegistryObject<SoundEvent> registerSoundEvent(String sound_name){
      return SOUND_EVENTS.register(sound_name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(EnhancedPlaythrough.MOD_ID, sound_name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
