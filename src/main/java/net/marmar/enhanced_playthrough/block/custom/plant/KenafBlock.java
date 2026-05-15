package net.marmar.enhanced_playthrough.block.custom.plant;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.world.item.Item;

public class KenafBlock extends DoublePlantGrowingHeadBlock {
    public KenafBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected Item getDefaultHead() {
        return EPItems.KENAF_BRANCH.get();
    }
}
