package net.marmar.enhanced_playthrough.worldgen.feature;

import com.mojang.serialization.Codec;
import net.marmar.enhanced_playthrough.block.EPBlocks;
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

/*Code inspired on Farmer´s Delight WildRiceFeature class, used with the permissions of the MIT licence.
* You can found the original code here:
* https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/common/world/feature/WildRiceFeature.java*/

public class WaterReedsFeature extends Feature<RandomPatchConfiguration> {
    public WaterReedsFeature(Codec<RandomPatchConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> pContext) {
        WorldGenLevel level = pContext.level();
        BlockPos sourcePos = pContext.origin();
        RandomPatchConfiguration config = pContext.config();
        RandomSource random = pContext.random();

        BlockPos blockPos = level.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, sourcePos);

        int i = 0;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (int j = 0; j < config.tries(); ++j) {
            mutableBlockPos.set(blockPos).move(
                    random.nextInt(config.xzSpread() + 1) - random.nextInt(config.xzSpread() + 1),
                    random.nextInt(config.ySpread() + 1) - random.nextInt(config.ySpread() + 1),
                    random.nextInt(config.xzSpread() + 1) - random.nextInt(config.xzSpread() + 1));

            if (level.getBlockState(mutableBlockPos).getBlock() == Blocks.WATER && level.getBlockState(mutableBlockPos.above()).getBlock() == Blocks.AIR) {
                BlockState bottomBlockState = EPBlocks.WATER_REEDS.get().defaultBlockState().setValue(WaterReedsBlock.HALF, DoubleBlockHalf.LOWER);
                if (bottomBlockState.canSurvive(level, mutableBlockPos)) {
                    DoublePlantBlock.placeAt(level, bottomBlockState, mutableBlockPos, 2);
                    ++i;
                }
            }
        }

        return i > 0;
    }
}
