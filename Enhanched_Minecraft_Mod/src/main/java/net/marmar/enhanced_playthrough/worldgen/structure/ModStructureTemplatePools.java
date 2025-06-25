package net.marmar.enhanced_playthrough.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.Optional;
import java.util.function.Function;

public class ModStructureTemplatePools {
    //Jeweler house
    public static final ResourceKey<StructureTemplatePool> JEWELER_HOUSE_START_POOL = registryKey("jeweler_house/start_pool");

    //Bandit camp
    public static final ResourceKey<StructureTemplatePool> BANDIT_CAMP_START_POOL = registryKey("bandit_camp/start_pool");
    public static final ResourceKey<StructureTemplatePool> BANDIT_ENTITY = registryKey("bandit_camp/bandit");

    public static void bootstrap(BootstapContext<StructureTemplatePool> pContext){
        //Holder getters
        HolderGetter<StructureTemplatePool> poolGetter = pContext.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorGetter = pContext.lookup(Registries.PROCESSOR_LIST);

        //Holders
        Holder<StructureProcessorList> streetHolder = processorGetter.getOrThrow(ProcessorLists.STREET_PLAINS);
        Holder<StructureProcessorList> mossy10Percent = processorGetter.getOrThrow(ProcessorLists.MOSSIFY_10_PERCENT);
        Holder<StructureTemplatePool> emptyFallback = poolGetter.getOrThrow(Pools.EMPTY);

        //Register
        pContext.register(JEWELER_HOUSE_START_POOL, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(singlePoolElement(
                "jeweler_house/jeweler_house", mossy10Percent), 1)), StructureTemplatePool.Projection.RIGID));

        pContext.register(BANDIT_CAMP_START_POOL, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(singlePoolElement(
                "bandit_camp/bandit_camp", mossy10Percent), 1)), StructureTemplatePool.Projection.RIGID));
        pContext.register(BANDIT_ENTITY, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(singlePoolElement(
                "bandit_camp/entities/bandit", mossy10Percent), 1)), StructureTemplatePool.Projection.RIGID));
    }

    public static Function<StructureTemplatePool.Projection, ModSinglePoolElement> singlePoolElement(String pName, Holder<StructureProcessorList> pProcessor){
        return (projection) -> new ModSinglePoolElement(structureNBTLocation(pName), Either.left(new ResourceLocation(EnhancedPlaythrough.MOD_ID, pName)), pProcessor, projection);
    }

    private static Optional<String> structureNBTLocation(String pName){
        return Optional.of(EnhancedPlaythrough.MOD_ID + ":" + pName);
    }

    public static ResourceKey<StructureTemplatePool> registryKey(String name){
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
