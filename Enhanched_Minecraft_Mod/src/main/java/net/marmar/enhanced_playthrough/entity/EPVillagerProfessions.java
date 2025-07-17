package net.marmar.enhanced_playthrough.entity;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPVillagerProfessions {
    //Registers
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(
            ForgeRegistries.POI_TYPES, EnhancedPlaythrough.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(
            ForgeRegistries.VILLAGER_PROFESSIONS, EnhancedPlaythrough.MOD_ID);

    //POI types
    public static final RegistryObject<PoiType> JEWELER_POI = POI_TYPES.register("jeweler_poi",
            () -> new PoiType(ImmutableSet.copyOf(EPBlocks.GEM_POLISHER.get().getStateDefinition().getPossibleStates()),
                    1,1));

    //Villager professions
    public static final RegistryObject<VillagerProfession> JEWELER = VILLAGER_PROFESSIONS.register("jeweler",
            () -> new VillagerProfession("jeweler", poiTypeHolder -> poiTypeHolder.get() == JEWELER_POI.get(), poiTypeHolder -> poiTypeHolder.get() == JEWELER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
