package net.marmar.enhanced_playthrough.worldgen.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class OrangeFoliagePlacer extends FoliagePlacer {
    public static final Codec<OrangeFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance).and(Codec.intRange(0,16).fieldOf("height").forGetter(fp -> fp.height))
                    .apply(instance, OrangeFoliagePlacer::new));

    private final int height;

    public OrangeFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EPFoliagePlacers.ORANGE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pSetter, RandomSource pRandom,
                                 TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment,
                                 int pFoliageHeight, int pFoliageRadius, int pOffset) {
        this.placeLeavesRow(pLevel, pSetter, pRandom, pConfig, pAttachment.pos().above(-2),1,0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pSetter, pRandom, pConfig, pAttachment.pos().above(-1),2,0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pSetter, pRandom, pConfig, pAttachment.pos().above(0),2,0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pSetter, pRandom, pConfig, pAttachment.pos().above(1),1,0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pSetter, pRandom, pConfig, pAttachment.pos().above(2),0,0, pAttachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pLocalX == pRange && pLocalZ == pRange && pRange > 0;
    }
}
