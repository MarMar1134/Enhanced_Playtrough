package net.marmar.enhanced_playthrough.data;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.trim.EPTrimPatterns;
import net.marmar.enhanced_playthrough.util.damage.EPDamageTypes;
import net.marmar.enhanced_playthrough.worldgen.EPBiomeModifiers;
import net.marmar.enhanced_playthrough.worldgen.EPConfiguredFeatures;
import net.marmar.enhanced_playthrough.worldgen.EPPlacedFeatures;
import net.marmar.enhanced_playthrough.worldgen.structure.EPStructureSets;
import net.marmar.enhanced_playthrough.worldgen.structure.pool.EPStructureTemplatePools;
import net.marmar.enhanced_playthrough.worldgen.structure.EPStructures;
import net.marmar.enhanced_playthrough.worldgen.structure.processor.EPStructureProcessorLists;
import net.marmar.enhanced_playthrough.worldgen.structure.processor.EPStructureProcessors;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EPDataPackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PROCESSOR_LIST, EPStructureProcessorLists::bootstrap)
            .add(Registries.TEMPLATE_POOL, EPStructureTemplatePools::bootstrap)
            .add(Registries.STRUCTURE, EPStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, EPStructureSets::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, EPConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, EPPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, EPBiomeModifiers::bootstrap)
            .add(Registries.DAMAGE_TYPE, EPDamageTypes::bootstrap)
            .add(Registries.TRIM_PATTERN, EPTrimPatterns::bootstrap);

    public EPDataPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(EnhancedPlaythrough.MOD_ID));
    }
}
