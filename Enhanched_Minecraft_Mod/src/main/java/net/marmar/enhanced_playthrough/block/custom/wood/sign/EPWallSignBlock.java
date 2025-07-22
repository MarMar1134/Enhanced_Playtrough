package net.marmar.enhanced_playthrough.block.custom.wood.sign;

import net.marmar.enhanced_playthrough.block.custom.wood.sign.entity.EPSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class EPWallSignBlock extends WallSignBlock {
    public EPWallSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EPSignBlockEntity(pPos, pState);
    }
}
