package net.marmar.enhanced_playthrough.worldgen.structure.processor;

import com.google.common.collect.ImmutableList;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;

public class EPStructureProcessorLists {
    public static final ResourceKey<StructureProcessorList> ANCIENT_LORDS_DECAY = registerKey("ancient_lords_decay");
    public static final ResourceKey<StructureProcessorList> POPULATE_ANCIENT_LIBRARY = registerKey("populate_ancient_library");

    public static void bootstrap(BootstapContext<StructureProcessorList> pContext){
        registerProcessor(pContext, ANCIENT_LORDS_DECAY, ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.3f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.defaultBlockState())
                ))));

        registerProcessor(pContext, POPULATE_ANCIENT_LIBRARY, ImmutableList.of(
                new PopulateLibraryProcessor(),
                new RuleProcessor(ImmutableList.of(
                        new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.3f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.defaultBlockState())
                ))));
    }

    private static void registerProcessor(BootstapContext<StructureProcessorList> pContext, ResourceKey<StructureProcessorList> pKey, List<StructureProcessor> pProcessors){
        pContext.register(pKey, new StructureProcessorList(pProcessors));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<StructureProcessorList> registerKey(String name){
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
