package net.marmar.enhanced_playthrough.worldgen.structure.processor;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EPStructureProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<StructureProcessorType<PopulateLibraryProcessor>> POPULATE_LIBRARY =
            PROCESSORS.register("populate_library", () -> () -> PopulateLibraryProcessor.CODEC);

    public static void register(IEventBus eventBus){
        PROCESSORS.register(eventBus);
    }
}
