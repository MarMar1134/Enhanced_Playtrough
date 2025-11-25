package net.marmar.enhanced_playthrough.util;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, EnhancedPlaythrough.MOD_ID);

    //Blocks
    public static final RegistryObject<SoundEvent> GRIND_SOUND = registerSoundEvents("grind_sound");

    //Zombie knight
    public static final RegistryObject<SoundEvent> ZOMBIE_KNIGHT_AMBIENT = registerSoundEvents("zombie_knight_ambient");
    public static final RegistryObject<SoundEvent> ZOMBIE_KNIGHT_STEP = registerSoundEvents("zombie_knight_step");
    public static final RegistryObject<SoundEvent> ZOMBIE_KNIGHT_HURT = registerSoundEvents("zombie_knight_hurt");
    public static final RegistryObject<SoundEvent> ZOMBIE_KNIGHT_DEATH = registerSoundEvents("zombie_knight_death");

    //Skeleton bowmaster
    public static final RegistryObject<SoundEvent> SKELETON_BOWMASTER_AMBIENT = registerSoundEvents("skeleton_bowmaster_ambient");
    public static final RegistryObject<SoundEvent> SKELETON_BOWMASTER_STEP = registerSoundEvents("skeleton_bowmaster_step");
    public static final RegistryObject<SoundEvent> SKELETON_BOWMASTER_HURT = registerSoundEvents("skeleton_bowmaster_hurt");
    public static final RegistryObject<SoundEvent> SKELETON_BOWMASTER_DEATH = registerSoundEvents("skeleton_bowmaster_death");

    private static RegistryObject<SoundEvent> registerSoundEvents(String sound_name){
      return SOUND_EVENTS.register(sound_name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, sound_name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
