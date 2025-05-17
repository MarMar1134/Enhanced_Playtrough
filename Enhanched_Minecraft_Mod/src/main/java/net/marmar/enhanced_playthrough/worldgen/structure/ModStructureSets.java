package net.marmar.enhanced_playthrough.worldgen.structure;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSets {
    public static final ResourceKey<StructureSet> JEWELER_HOUSE = registryKey("jeweler_house");

    public static void bootstrap(BootstapContext<StructureSet> pContext){
        HolderGetter<Structure> structureGetter = pContext.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomesGetter = pContext.lookup(Registries.BIOME);

        pContext.register(JEWELER_HOUSE, new StructureSet(structureGetter.getOrThrow(ModStructures.JEWELER_HOUSE),
                new RandomSpreadStructurePlacement(40, 10, RandomSpreadType.LINEAR, 16113412)));
    }

    private static ResourceKey<StructureSet> registryKey(String name){
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
