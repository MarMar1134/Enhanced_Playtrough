package net.marmar.enhanced_playthrough.block.custom.wood.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class LeavesWithFruitBlock extends EPLeavesBlock {
    public static final int MAX_AGE = 1;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
    public static final IntegerProperty DISTANCE;
    public static final BooleanProperty PERSISTENT;
    public static final BooleanProperty WATERLOGGED;
    public static final BooleanProperty GROWS;
    private final Supplier<Item> fruit;

    public LeavesWithFruitBlock(Properties pProperties, Supplier<Item> pFruit) {
        super(pProperties);
        this.fruit = pFruit;
        this.registerDefaultState(this.defaultBlockState().setValue(AGE, 1).setValue(GROWS, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE, DISTANCE, PERSISTENT, WATERLOGGED, GROWS);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (pPlacer instanceof Player){
            pLevel.setBlock(pPos, pState.setValue(AGE, 0), 2);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(AGE) < MAX_AGE || super.isRandomlyTicking(pState);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(AGE) != MAX_AGE && pState.getValue(GROWS) && pRandom.nextFloat() < 0.25f) {
            BlockState blockstate = pState.setValue(AGE, 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
            ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
        }

        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        boolean isMaxAge = pState.getValue(AGE) == MAX_AGE;
        boolean grows = pState.getValue(GROWS);

        if (grows && pPlayer.getItemInHand(pHand).is(Items.SHEARS)){
            pLevel.playSound(null, pPos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);

            BlockState newState = pState.setValue(GROWS, false);
            newState.setValue(AGE, 0);
            pLevel.setBlock(pPos, newState, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, newState));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }

        if (grows && isMaxAge){
            int maxFruits = pLevel.random.nextInt(2) + 1;
            popResource(pLevel, pPos, new ItemStack(this.fruit.get(), maxFruits));

            pLevel.playSound(null, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);

            BlockState newBlockState = pState.setValue(AGE, 0);
            pLevel.setBlock(pPos, newBlockState, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, newBlockState));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    public IntegerProperty getAgeProperty(){
        return AGE;
    }

    static {
        DISTANCE = BlockStateProperties.DISTANCE;
        PERSISTENT = BlockStateProperties.PERSISTENT;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        GROWS = BooleanProperty.create("grows");
    }
}
