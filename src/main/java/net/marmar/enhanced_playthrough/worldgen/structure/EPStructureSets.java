package net.marmar.enhanced_playthrough.worldgen.structure;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class EPStructureSets {
    //Jeweler house
    public static final ResourceKey<StructureSet> JEWELER_HOUSE = registryKey("jeweler_house");

    //Bandit camp
    public static final ResourceKey<StructureSet> BANDIT_CAMP = registryKey("bandit_camp");

    //Ancient lord's domain
    public static final ResourceKey<StructureSet> ANCIENT_LORDS_DOMAIN = registryKey("ancient_lords_domain");

    public static void bootstrap(BootstapContext<StructureSet> context){
        HolderGetter<Structure> structureGetter = context.lookup(Registries.STRUCTURE);

        context.register(JEWELER_HOUSE, new StructureSet(structureGetter.getOrThrow(EPStructures.JEWELER_HOUSE),
                new RandomSpreadStructurePlacement(40, 10, RandomSpreadType.LINEAR, 16113412)));
        context.register(BANDIT_CAMP, new StructureSet(structureGetter.getOrThrow(EPStructures.BANDIT_CAMP),
                new RandomSpreadStructurePlacement(25, 20, RandomSpreadType.LINEAR, 33121233)));

        context.register(ANCIENT_LORDS_DOMAIN, new StructureSet(structureGetter.getOrThrow(EPStructures.ANCIENT_LORDS_DOMAIN),
                new RandomSpreadStructurePlacement(60, 40, RandomSpreadType.LINEAR, 1074514779)));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<StructureSet> registryKey(String name){
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
