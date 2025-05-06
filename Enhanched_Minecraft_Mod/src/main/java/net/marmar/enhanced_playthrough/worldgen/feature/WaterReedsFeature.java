package net.marmar.enhanced_playthrough.worldgen.feature;

import com.mojang.serialization.Codec;
import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.custom.plant.WaterReedsBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

/*Code inspired on Farmer´s Delight WildRiceFeature class, used
* with the MIT licence. You can found the original code here:
* https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/common/world/feature/WildRiceFeature.java*/

public class WaterReedsFeature extends Feature<RandomPatchConfiguration> {
    public WaterReedsFeature(Codec<RandomPatchConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos origin = pContext.origin();
        RandomPatchConfiguration config = pContext.config();
        RandomSource rand = pContext.random();

        BlockPos blockpos = level.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, origin);

        int i = 0;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (int j = 0; j < config.tries(); ++j) {
            mutableBlockPos.set(blockpos).move(
                    rand.nextInt(config.xzSpread() + 1) - rand.nextInt(config.xzSpread() + 1),
                    rand.nextInt(config.ySpread() + 1) - rand.nextInt(config.ySpread() + 1),
                    rand.nextInt(config.xzSpread() + 1) - rand.nextInt(config.xzSpread() + 1));

            if (level.getBlockState(mutableBlockPos).getBlock() == Blocks.WATER && level.getBlockState(mutableBlockPos.above()).getBlock() == Blocks.AIR) {
                BlockState bottomBlockState = ModBlocks.WATER_REEDS.get().defaultBlockState().setValue(WaterReedsBlock.HALF, DoubleBlockHalf.LOWER);
                if (bottomBlockState.canSurvive(level, mutableBlockPos)) {
                    DoublePlantBlock.placeAt(level, bottomBlockState, mutableBlockPos, 2);
                    ++i;
                }
            }
        }

        return i > 0;
    }
}
