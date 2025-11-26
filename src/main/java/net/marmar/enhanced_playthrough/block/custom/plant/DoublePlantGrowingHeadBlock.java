package net.marmar.enhanced_playthrough.block.custom.plant;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.Nullable;

public class DoublePlantGrowingHeadBlock extends DoublePlantBlock implements BonemealableBlock {
    public static final int MAX_AGE = 1;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
    public static final EnumProperty<DoubleBlockHalf> HALF;

    public DoublePlantGrowingHeadBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(AGE, 0).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(AGE) < MAX_AGE;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return;

        if (pState.getValue(AGE) != MAX_AGE && pLevel.getRawBrightness(pPos.above(), 0) >= 9 &&
            ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(10) == 0)) {

            BlockState blockstate = pState.setValue(AGE, 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
            ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        boolean isMaxAge = pState.getValue(AGE) == MAX_AGE;

        if (pState.getValue(HALF).equals(DoubleBlockHalf.UPPER)){
            if (!isMaxAge && pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)){
                return InteractionResult.PASS;
            } else if (isMaxAge) {
                int maxHeads = 1 + pLevel.random.nextInt(2);
                popResource(pLevel, pPos, new ItemStack(this.getDefaultHead(), maxHeads));
                pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);

                BlockState newBlockState = pState.setValue(AGE, 0);
                pLevel.setBlock(pPos, newBlockState, 2);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, newBlockState));
                return InteractionResult.sidedSuccess(pLevel.isClientSide);
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    protected Item getDefaultHead(){
        return EPItems.REEDS_HEAD.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE, HALF);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pState.getValue(AGE) < MAX_AGE && pState.getValue(HALF) == DoubleBlockHalf.UPPER;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        pLevel.setBlock(pPos, pState.setValue(AGE, MAX_AGE), 2);
    }

    public Integer getCurrentAge(BlockState blockState){
        return blockState.getValue(AGE);
    }

    static {
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    }
}
