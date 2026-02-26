package net.marmar.enhanced_playthrough.block.custom.growthdetector;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.marmar.enhanced_playthrough.block.custom.growthdetector.GrowthDetectorBlock.*;

public class GrowthDetectorBlockEntity extends BlockEntity {
    private int outputSignal;

    public GrowthDetectorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.GROWTH_DETECTOR_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public int calculateOutputSignal(BlockGetter pLevel, BlockPos pPos, BlockState pState){
        Direction facing = pState.getValue(FACING);
        BlockState detectedBlockState = pLevel.getBlockState(pPos.relative(facing.getOpposite()));
        int currentAge = 0;

        if (detectedBlockState.getBlock() instanceof CropBlock crop){
            currentAge = crop.getAge(detectedBlockState);

            //If the crop is fully grown, returns tha maximum signal allowed by vanilla
            if (currentAge == crop.getMaxAge()){
                return 15;

            //When the crop is still growing, the output is given depending on the plant's age
            } else return switch (crop.getMaxAge()) {
                case 1 -> 7;
                case 2 -> currentAge * 7;
                case 3, 4 -> Math.min(currentAge * 4, 14);
                case 5 -> currentAge * 3;
                default -> Math.min(currentAge * 2, 14);
            };
        }

        return currentAge;
    }

    public int getOutputSignal(){
        return this.outputSignal;
    }

    public void setOutputSignal(int outputSignal) {
        this.outputSignal = outputSignal;
    }

    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState){
        int currentPower = calculateOutputSignal(pLevel, pPos, pState);

        pState = pState.setValue(POWER, currentPower);

        setOutputSignal(currentPower);
        pLevel.setBlock(pPos, pState, 1);
        sendUpdate();

        if (currentPower != 0){
            pState = pState.setValue(POWERED, true);
        } else {
            pState = pState.setValue(POWERED, false);
        }
        pLevel.setBlock(pPos, pState, 1);
        sendUpdate();

        setChanged(pLevel, pPos, pState);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("output_signal", this.outputSignal);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.outputSignal = pTag.getInt("output_signal");
    }
}
