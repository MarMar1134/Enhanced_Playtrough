package net.marmar.enhanced_playthrough.worldgen.structure;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.data.tag.ModTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class ModStructures {
    public static final ResourceKey<Structure> JEWELER_HOUSE = registryKey("jeweler_house");

    public static void bootstrap(BootstapContext<Structure> pContext){
        HolderGetter<Biome> biomesGetter = pContext.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> structureGetter = pContext.lookup(Registries.TEMPLATE_POOL);

        pContext.register(JEWELER_HOUSE, houseStructure(biomesGetter, structureGetter,
                ModTags.Biomes.JEWELER_HOUSE, ModStructureTemplatePools.JEWELER_HOUSE_START_POOL));
    }

    private static JigsawStructure houseStructure(HolderGetter<Biome> biomesGetter, HolderGetter<StructureTemplatePool> structureGetter, TagKey<Biome> pBiomes, ResourceKey<StructureTemplatePool> pHouse){
        return new JigsawStructure(structure(biomesGetter.getOrThrow(pBiomes), TerrainAdjustment.NONE), structureGetter.getOrThrow(pHouse),
                2, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> pBiomes, Map<MobCategory, StructureSpawnOverride> pSpawnOverrides, GenerationStep.Decoration pStep, TerrainAdjustment pTerrainAdaptation) {
        return new Structure.StructureSettings(pBiomes, pSpawnOverrides, pStep, pTerrainAdaptation);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> pBiomes, GenerationStep.Decoration pStep, TerrainAdjustment pTerrainAdaptation) {
        return structure(pBiomes, Map.of(), pStep, pTerrainAdaptation);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> pBiomes, TerrainAdjustment pTerrainAdaptation) {
        return structure(pBiomes, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, pTerrainAdaptation);
    }

    public static ResourceKey<Structure> registryKey(String name){
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
