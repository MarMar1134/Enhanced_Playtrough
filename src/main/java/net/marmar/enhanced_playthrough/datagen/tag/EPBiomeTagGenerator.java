package net.marmar.enhanced_playthrough.datagen.tag;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class EPBiomeTagGenerator extends BiomeTagsProvider {
    public EPBiomeTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, EnhancedPlaythrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(EPTags.Biomes.COLD_BIOMES).add(
                Biomes.FROZEN_RIVER,
                Biomes.FROZEN_PEAKS,
                Biomes.JAGGED_PEAKS,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.COLD_OCEAN,
                Biomes.DEEP_COLD_OCEAN,
                Biomes.SNOWY_BEACH,
                Biomes.SNOWY_PLAINS,
                Biomes.SNOWY_SLOPES,
                Biomes.TAIGA,
                Biomes.SNOWY_TAIGA,
                Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS,
                Biomes.WINDSWEPT_HILLS,
                Biomes.WINDSWEPT_FOREST
        );

        this.tag(EPTags.Biomes.WARM_BIOMES).add(
                Biomes.DESERT,
                Biomes.BADLANDS,
                Biomes.ERODED_BADLANDS,
                Biomes.WOODED_BADLANDS,
                Biomes.JUNGLE,
                Biomes.SPARSE_JUNGLE,
                Biomes.BAMBOO_JUNGLE,
                Biomes.SAVANNA,
                Biomes.SAVANNA_PLATEAU,
                Biomes.WINDSWEPT_SAVANNA,
                Biomes.WARM_OCEAN
        );

        this.tag(EPTags.Biomes.DESERT_BIOMES).add(
                Biomes.DESERT,
                Biomes.BADLANDS
        );

        this.tag(EPTags.Biomes.FROZEN_BIOMES).add(
                Biomes.FROZEN_RIVER,
                Biomes.FROZEN_PEAKS,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.SNOWY_BEACH,
                Biomes.SNOWY_PLAINS,
                Biomes.SNOWY_SLOPES,
                Biomes.SNOWY_TAIGA
        );

        this.tag(EPTags.Biomes.TEMPLATE_BIOMES).add(
                Biomes.PLAINS,
                Biomes.SUNFLOWER_PLAINS,
                Biomes.MEADOW,
                Biomes.FOREST,
                Biomes.BIRCH_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST,
                Biomes.FLOWER_FOREST,
                Biomes.BEACH,
                Biomes.LUKEWARM_OCEAN,
                Biomes.DEEP_LUKEWARM_OCEAN,
                Biomes.OCEAN
        );

        this.tag(EPTags.Biomes.HAS_JEWELER_HOUSE).add(
                Biomes.PLAINS,
                Biomes.MEADOW
        );

        this.tag(EPTags.Biomes.HAS_ANCIENT_LORDS_DOMAIN).add(
                Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA
        );

        this.tag(EPTags.Biomes.HUMIDITY_BIOMES).add(
                Biomes.JUNGLE,
                Biomes.BAMBOO_JUNGLE,
                Biomes.SPARSE_JUNGLE,
                Biomes.LUSH_CAVES
        );

        this.tag(EPTags.Biomes.CAN_SPAWN_ZOMBIE_KNIGHT).addTags(
                BiomeTags.IS_FOREST, BiomeTags.IS_BEACH,
                BiomeTags.IS_JUNGLE, BiomeTags.IS_MOUNTAIN,
                BiomeTags.IS_TAIGA, BiomeTags.IS_SAVANNA,
                BiomeTags.IS_OCEAN, BiomeTags.IS_RIVER
        ).add(
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.SNOWY_PLAINS
        );

        this.tag(EPTags.Biomes.CAN_SPAWN_SKELETON_BOWMASTER).addTags(
                EPTags.Biomes.TEMPLATE_BIOMES, EPTags.Biomes.WARM_BIOMES
        ).add(
                Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.JAGGED_PEAKS,Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST
        );

        this.tag(EPTags.Biomes.CAN_SPAWN_WERELLAGER).addTags(
                BiomeTags.IS_FOREST, BiomeTags.IS_JUNGLE, BiomeTags.IS_TAIGA
        );
    }
}
