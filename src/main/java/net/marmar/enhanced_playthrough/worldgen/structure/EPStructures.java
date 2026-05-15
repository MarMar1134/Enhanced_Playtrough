package net.marmar.enhanced_playthrough.worldgen.structure;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.marmar.enhanced_playthrough.worldgen.structure.pool.AncientLordsDomainPools;
import net.marmar.enhanced_playthrough.worldgen.structure.pool.EPStructureTemplatePools;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
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

public class EPStructures {
    //Jeweler house
    public static final ResourceKey<Structure> JEWELER_HOUSE = registryKey("jeweler_house");

    //Bandit camp
    public static final ResourceKey<Structure> BANDIT_CAMP = registryKey("bandit_camp");

    //Ancient Lord's Domain
    public static final ResourceKey<Structure> ANCIENT_LORDS_DOMAIN = registryKey("ancient_lords_domain");

    public static void bootstrap(BootstapContext<Structure> context){
        HolderGetter<Biome> biomesGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> structureGetter = context.lookup(Registries.TEMPLATE_POOL);

        context.register(JEWELER_HOUSE, houseStructure(biomesGetter, structureGetter,
                EPTags.Biomes.HAS_JEWELER_HOUSE, EPStructureTemplatePools.JEWELER_HOUSE_START_POOL));
        context.register(BANDIT_CAMP, campStructure(biomesGetter, structureGetter,
                BiomeTags.IS_FOREST, EPStructureTemplatePools.BANDIT_CAMP_START_POOL, EPEntityTypes.BANDIT.get()));

        context.register(ANCIENT_LORDS_DOMAIN, ancientLordsDomainStructure(biomesGetter, structureGetter,
                EPTags.Biomes.HAS_ANCIENT_LORDS_DOMAIN, AncientLordsDomainPools.START_POOL));
    }

    private static JigsawStructure houseStructure(HolderGetter<Biome> biomesGetter, HolderGetter<StructureTemplatePool> structureGetter, TagKey<Biome> pBiomes, ResourceKey<StructureTemplatePool> pHouse){
        return new JigsawStructure(structure(biomesGetter.getOrThrow(pBiomes), TerrainAdjustment.NONE), structureGetter.getOrThrow(pHouse),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG);
    }

    private static JigsawStructure campStructure(HolderGetter<Biome> biomesGetter, HolderGetter<StructureTemplatePool> structureGetter, TagKey<Biome> pBiomes, ResourceKey<StructureTemplatePool> pCamp, EntityType<?> pMob){
       return new JigsawStructure(structure(biomesGetter.getOrThrow(pBiomes),
                Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                        WeightedRandomList.create(new MobSpawnSettings.SpawnerData(pMob, 1, 1, 3)))),
                GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), structureGetter.getOrThrow(pCamp),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG);
    }

    private static JigsawStructure ancientLordsDomainStructure(HolderGetter<Biome> biomesGetter, HolderGetter<StructureTemplatePool> structureGetter, TagKey<Biome> pBiomes, ResourceKey<StructureTemplatePool> pStartPool){
        return new JigsawStructure(structure(biomesGetter.getOrThrow(pBiomes),
                Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.PIECE,
                        WeightedRandomList.create(
                                new MobSpawnSettings.SpawnerData(EPEntityTypes.ZOMBIE_KNIGHT.get(), 2, 2, 3),
                                new MobSpawnSettings.SpawnerData(EPEntityTypes.SKELETON_BOWMASTER.get(), 1, 2, 3)
                        )
                )),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES, TerrainAdjustment.BEARD_THIN), structureGetter.getOrThrow(pStartPool),
                7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.MOTION_BLOCKING);
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

    @SuppressWarnings("removal")
    public static ResourceKey<Structure> registryKey(String name){
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
