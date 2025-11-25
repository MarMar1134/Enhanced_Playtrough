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
    //Jeweler house
    public static final ResourceKey<StructureSet> JEWELER_HOUSE = registryKey("jeweler_house");

    //Bandit camp
    public static final ResourceKey<StructureSet> BANDIT_CAMP = registryKey("bandit_camp");

    public static void bootstrap(BootstapContext<StructureSet> context){
        HolderGetter<Structure> structureGetter = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomesGetter = context.lookup(Registries.BIOME);

        context.register(JEWELER_HOUSE, new StructureSet(structureGetter.getOrThrow(ModStructures.JEWELER_HOUSE),
                new RandomSpreadStructurePlacement(40, 10, RandomSpreadType.LINEAR, 16113412)));
        context.register(BANDIT_CAMP, new StructureSet(structureGetter.getOrThrow(ModStructures.BANDIT_CAMP),
                new RandomSpreadStructurePlacement(25, 20, RandomSpreadType.LINEAR, 33121233)));
    }

    private static ResourceKey<StructureSet> registryKey(String name){
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, name));
    }
}
