package net.marmar.enhanced_playthrough.block.grinder.entity;

import net.marmar.enhanced_playthrough.block.ModBlockEntities;
import net.marmar.enhanced_playthrough.block.grinder.PrimalGrinderBlock;
import net.marmar.enhanced_playthrough.menu.grinder.PrimalGrinderMenu;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
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

import java.util.List;
import java.util.Optional;

public class PrimalGrinderBlockEntity extends BlockEntity implements MenuProvider {
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

    private final ItemStackHandler fuelHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inputLazyHandler = LazyOptional.of(() -> this.inputHandler);
    private final LazyOptional<ItemStackHandler> outputLazyHandler = LazyOptional.of(() -> this.outputHandler);
    private final LazyOptional<ItemStackHandler> fuelLazyHandler = LazyOptional.of(() -> this.fuelHandler);

    protected final ContainerData Data;
    private int progress = 0, maxProgress = 250;
    private int burnTime = 0, maxBurnTime = 0;

    public PrimalGrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PRIMAL_GRINDER_BLOCK_ENTITY.get(), pPos, pBlockState);

        this.Data = new ContainerData(){
            @Override
            public int get(int i) {
                return switch (i){
                    case 0, 1 -> PrimalGrinderBlockEntity.this.progress;
                    case 2 -> PrimalGrinderBlockEntity.this.burnTime;
                    case 3 -> PrimalGrinderBlockEntity.this.maxBurnTime;
                    case 4 -> PrimalGrinderBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0, 1 -> PrimalGrinderBlockEntity.this.progress = i1;
                    case 2 -> PrimalGrinderBlockEntity.this.burnTime = i1;
                    case 3 -> PrimalGrinderBlockEntity.this.maxBurnTime = i1;
                    case 4 -> PrimalGrinderBlockEntity.this.maxProgress = i1;
                };
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
    }

    //Handler getters
    public ItemStackHandler getInputHandler() {
        return inputHandler;
    }
    public ItemStackHandler getFuelHandler() {
        return fuelHandler;
    }
    public ItemStackHandler getOutputHandler() {
        return outputHandler;
    }

    //Lazy handler getters
    public LazyOptional<ItemStackHandler> getInputLazyHandler(){
        return this.inputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getOutputLazyHandler(){
        return this.outputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getFuelLazyHandler() {
        return this.fuelLazyHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            if (side == Direction.DOWN){
                return outputLazyHandler.cast();
            } else if (side == Direction.UP){
                return fuelLazyHandler.cast();
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
        inventory.setItem(2, fuelHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inputLazyHandler.invalidate();
        outputLazyHandler.invalidate();
        fuelLazyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("primal_grinder.input", inputHandler.serializeNBT());
        pTag.put("primal_grinder.output", outputHandler.serializeNBT());
        pTag.put("primal_grinder.fuel", fuelHandler.serializeNBT());

        pTag.putInt("primal_grinder.burn_time", burnTime);
        pTag.putInt("primal_grinder.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        inputHandler.deserializeNBT(pTag.getCompound("primal_grinder.input"));
        outputHandler.deserializeNBT(pTag.getCompound("primal_grinder.output"));
        fuelHandler.deserializeNBT(pTag.getCompound("primal_grinder.fuel"));

        burnTime = pTag.getInt("primal_grinder.burn_time");
        progress = pTag.getInt("primal_grinder.progress");
    }

    protected void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (isBurning()){
            if (hasRecipe()){
                increaseGrindProgress();

                sendUpdate();
            } else {
                resetGrindProgress();
            }

            pState = pState.setValue(PrimalGrinderBlock.ON, true);
            decreaseBurnTime();
            sendUpdate();
        } else if (hasRecipe()){
            if (canBurn(fuelHandler.getStackInSlot(0))){
                burn();

                sendUpdate();
            }
        } else {
            pState = pState.setValue(PrimalGrinderBlock.ON, false);
            resetGrindProgress();
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

    public boolean canBurn(ItemStack stack) {
        return getFuelBurnTime(stack) > 0;
    }

    public int getFuelBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, ModRecipes.PRIMAL_GRINDING_TYPE.get());
    }

    private boolean isBurning(){
        return burnTime > 0;
    }

    private void burn(){
        this.maxBurnTime = getFuelBurnTime(this.fuelHandler.getStackInSlot(0));
        this.burnTime = this.maxBurnTime;
        this.fuelHandler.getStackInSlot(0).shrink(1);
    }

    private void decreaseBurnTime(){
        burnTime -= 1;
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    protected boolean hasRecipe() {
        Optional<PrimalGrindRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<PrimalGrindRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(1);

        inventory.setItem(0, inputHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(ModRecipes.PRIMAL_GRINDING_TYPE.get(), inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.outputHandler.getStackInSlot(0).isEmpty() || this.outputHandler.getStackInSlot(0).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.outputHandler.getStackInSlot(0).getCount() + count <= this.outputHandler.getStackInSlot(0).getMaxStackSize();
    }

    protected void resetGrindProgress() {
        progress = 0;
    }

    protected void grindItem() {
        Optional<PrimalGrindRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.inputHandler.extractItem(0, 1, false);

        this.outputHandler.setStackInSlot(0, new ItemStack(result.getItem(),
                this.outputHandler.getStackInSlot(0).getCount() + result.getCount()));
    }

    protected void increaseGrindProgress() {
        progress++;
    }

    protected boolean hasProcessFinished(){
        return progress >= maxProgress;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.primal_grinder");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new PrimalGrinderMenu(i, inventory, this, this.Data);
    }
}
