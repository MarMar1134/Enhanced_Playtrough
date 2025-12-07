package net.marmar.enhanced_playthrough.worldgen.structure.pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.worldgen.structure.processor.EPStructureProcessorLists;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.Optional;
import java.util.function.Function;

public class AncientLordsDomainPools {
    public static final ResourceKey<StructureTemplatePool> START_POOL = registryKey("ancient_lords_domain/start_pool");
    public static final ResourceKey<StructureTemplatePool> ROOMS_POOL = registryKey("ancient_lords_domain/rooms_pool");
    public static final ResourceKey<StructureTemplatePool> TRESSURES_POOL =registryKey("ancient_lords_domain/tressures_pool");
    public static final ResourceKey<StructureTemplatePool> HALLWAYS_POOL = registryKey("ancient_lords_domain/hallways_pool");
    public static final ResourceKey<StructureTemplatePool> VERTICAL_ROOMS_POOL = registryKey("ancient_lords_domain/vertical_rooms_pool");
    public static final ResourceKey<StructureTemplatePool> TERMINATOR_POOL = registryKey("ancient_lords_domain/terminator_pool");

    public static void bootstrap(BootstapContext<StructureTemplatePool> pContext){
        //Holder getters
        HolderGetter<StructureTemplatePool> poolGetter = pContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorGetter = pContext.lookup(Registries.PROCESSOR_LIST);

        //Holders
        Holder<StructureTemplatePool> emptyFallback = poolGetter.getOrThrow(Pools.EMPTY);

        Holder<StructureProcessorList> ancientLordsDecay = processorGetter.getOrThrow(EPStructureProcessorLists.ANCIENT_LORDS_DECAY);
        Holder<StructureProcessorList> populateLibrary = processorGetter.getOrThrow(EPStructureProcessorLists.POPULATE_ANCIENT_LIBRARY);

        pContext.register(START_POOL, new StructureTemplatePool(emptyFallback, ImmutableList.of(
                Pair.of(singlePoolElement("ancient_lords_domain/start/main_door", ancientLordsDecay), 1)
        ), StructureTemplatePool.Projection.RIGID));

        pContext.register(TERMINATOR_POOL, new StructureTemplatePool(emptyFallback, ImmutableList.of(
                Pair.of(singlePoolElement("ancient_lords_domain/end/terminator_1", ancientLordsDecay), 2),
                Pair.of(singlePoolElement("ancient_lords_domain/end/terminator_2", ancientLordsDecay), 1)
        ), StructureTemplatePool.Projection.RIGID));

        pContext.register(ROOMS_POOL, new StructureTemplatePool(poolGetter.getOrThrow(TERMINATOR_POOL), ImmutableList.of(
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/small_center", ancientLordsDecay), 4),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/training_room", ancientLordsDecay), 3),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/small_library", populateLibrary), 3),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/center_with_stairs", ancientLordsDecay), 3),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/storage_room_2", ancientLordsDecay), 3),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/bedroom_1", ancientLordsDecay), 2),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/bedroom_2", ancientLordsDecay), 2),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/storage_room_1", ancientLordsDecay), 2),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/throne_room", ancientLordsDecay), 2),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/center_with_hole", ancientLordsDecay), 1),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/big_center", ancientLordsDecay), 1)
        ), StructureTemplatePool.Projection.RIGID));

        pContext.register(TRESSURES_POOL, new StructureTemplatePool(poolGetter.getOrThrow(TERMINATOR_POOL), ImmutableList.of(
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/tressure_room_1", ancientLordsDecay), 1),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/tressure_room_2", ancientLordsDecay), 1)
        ), StructureTemplatePool.Projection.RIGID));

        pContext.register(HALLWAYS_POOL, new StructureTemplatePool(poolGetter.getOrThrow(TERMINATOR_POOL), ImmutableList.of(
                Pair.of(singlePoolElement("ancient_lords_domain/hallways/hallway_1", ancientLordsDecay), 4),
                Pair.of(singlePoolElement("ancient_lords_domain/hallways/hallway_2", ancientLordsDecay), 4),
                Pair.of(singlePoolElement("ancient_lords_domain/hallways/hallway_3", ancientLordsDecay), 4)
        ), StructureTemplatePool.Projection.RIGID));

        pContext.register(VERTICAL_ROOMS_POOL, new StructureTemplatePool(poolGetter.getOrThrow(TERMINATOR_POOL), ImmutableList.of(
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/vertical_center", ancientLordsDecay), 2),
                Pair.of(singlePoolElement("ancient_lords_domain/rooms/big_library", populateLibrary), 1)
        ), StructureTemplatePool.Projection.RIGID));
    }

    @SuppressWarnings("removal")
    public static Function<StructureTemplatePool.Projection, EPSinglePoolElement> singlePoolElement(String pName, Holder<StructureProcessorList> pProcessor){
        return (projection) -> new EPSinglePoolElement(pieceName(pName), Either.left(new ResourceLocation(EnhancedPlaythrough.MOD_ID, pName)), pProcessor, projection);
    }

    private static Optional<String> pieceName(String pName){
        return Optional.of(EnhancedPlaythrough.MOD_ID + ":" + pName);
    }

    @SuppressWarnings("removal")
    public static ResourceKey<StructureTemplatePool> registryKey(String name){
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
