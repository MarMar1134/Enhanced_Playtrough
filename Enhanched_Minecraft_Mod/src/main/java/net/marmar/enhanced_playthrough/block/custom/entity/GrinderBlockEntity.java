package net.marmar.enhanced_playthrough.block.custom.entity;

import net.marmar.enhanced_playthrough.block.custom.GrinderBlock;
import net.marmar.enhanced_playthrough.recipe.GrindingRecipe;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.menu.GrinderMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GrinderBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler inputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final ItemStackHandler outputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inputLazyHandler = LazyOptional.of(() -> this.inputHandler);
    private final LazyOptional<ItemStackHandler> outputLazyHandler = LazyOptional.of(() -> this.outputHandler);

    protected final ContainerData Data;
    private int progress = 0;
    private int maxProgress = 200;
    private int isTurnedOn = 0;

    public GrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ITEM_GRINDER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0, 1 -> GrinderBlockEntity.this.progress;
                    case 2 -> GrinderBlockEntity.this.isTurnedOn;
                    case 3 -> GrinderBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0, 1 -> GrinderBlockEntity.this.progress = i1;
                    case 2 -> GrinderBlockEntity.this.isTurnedOn = i1;
                    case 3 -> GrinderBlockEntity.this.maxProgress = i1;
                };
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    //Item handler getters
    public LazyOptional<ItemStackHandler> getInputLazyHandler(){
        return this.inputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getOutputLazyHandler(){
        return this.outputLazyHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            if (side == Direction.DOWN){
                return outputLazyHandler.cast();
            } else {
                return inputLazyHandler.cast();
            }
        }
        return super.getCapability(cap, side);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(3);

        inventory.setItem(0, inputHandler.getStackInSlot(0));
        inventory.setItem(1, outputHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inputLazyHandler.invalidate();
        outputLazyHandler.invalidate();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.grinder");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new GrinderMenu(i, inventory, this, this.Data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("grinder.input", inputHandler.serializeNBT());
        pTag.put("grinder.output", outputHandler.serializeNBT());
        pTag.putInt("grinder.turn_on", isTurnedOn);

        pTag.putInt("grinder.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        inputHandler.deserializeNBT(pTag.getCompound("grinder.input"));
        outputHandler.deserializeNBT(pTag.getCompound("grinder.output"));

        isTurnedOn = pTag.getInt("grinder.turn_on");
        progress = pTag.getInt("grinder.progress");
    }

    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {

        if (hasNeighbourSignal(pLevel, pPos)){
            if (hasRecipe()){
                increaseGrindProgress();

                sendUpdate();
            } else {
                resetGrindProgress();
            }
            pState = pState.setValue(GrinderBlock.ON, true);

            setIsTurnedOn(1);

            sendUpdate();
        } else {
            pState = pState.setValue(GrinderBlock.ON, false);

            resetGrindProgress();

            setIsTurnedOn(0);

            sendUpdate();
        }

        if (hasProcessFinished()){
            grindItem();

            resetGrindProgress();

            sendUpdate();
        }

        pLevel.setBlock(pPos, pState, 1);
        setChanged(pLevel, pPos, pState);
    }

    private boolean hasNeighbourSignal(Level level, BlockPos blockPos){
        if (level.isClientSide()){
            return false;
        }
        return level.hasNeighborSignal(blockPos);
    }

    private boolean hasRecipe() {
        Optional<GrindingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<GrindingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(1);

        inventory.setItem(0, inputHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(ModRecipes.GRINDING_TYPE.get(), inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.outputHandler.getStackInSlot(0).isEmpty() || this.outputHandler.getStackInSlot(0).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.outputHandler.getStackInSlot(0).getCount() + count <= this.outputHandler.getStackInSlot(0).getMaxStackSize();
    }

    private void resetGrindProgress() {
        progress = 0;
    }

    private void grindItem() {
        Optional<GrindingRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.inputHandler.extractItem(0, 1, false);

        this.outputHandler.setStackInSlot(0, new ItemStack(result.getItem(),
                this.outputHandler.getStackInSlot(0).getCount() + result.getCount()));
    }

    private void increaseGrindProgress() {
        progress++;
    }
    private boolean hasProcessFinished(){

        return progress >= maxProgress;
    }

    public void setIsTurnedOn(int isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }
}
