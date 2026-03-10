package net.marmar.enhanced_playthrough.block.custom.epfurnace.entity;

import net.marmar.enhanced_playthrough.block.custom.epfurnace.AbstractEPFurnaceBlock;
import net.marmar.enhanced_playthrough.recipe.epsmelt.AbstractEPSmeltingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class AbstractEPFurnaceBlockEntity extends BlockEntity {
    private final ItemStackHandler inputHandler = new ItemStackHandler(1){
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
    private final ItemStackHandler outputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inputLazyHandler = LazyOptional.of(() -> this.inputHandler),
            fuelLazyHandler = LazyOptional.of(() -> this.fuelHandler),
            outputLazyHandler = LazyOptional.of(() -> this.outputHandler);

    protected final ContainerData data;
    private final RecipeType<? extends AbstractEPSmeltingRecipe> recipeType;
    private int progress = 0, maxProgress = 0;
    private int burnTime = 0, maxBurnTime = 0;

    public AbstractEPFurnaceBlockEntity(@NotNull BlockEntityType<? extends AbstractEPFurnaceBlockEntity> pType, BlockPos pPos, BlockState pBlockState, RecipeType<? extends AbstractEPSmeltingRecipe> recipe) {
        super(pType, pPos, pBlockState);
        this.recipeType = recipe;
        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> AbstractEPFurnaceBlockEntity.this.progress;
                    case 1 -> AbstractEPFurnaceBlockEntity.this.maxProgress;
                    case 2 -> AbstractEPFurnaceBlockEntity.this.burnTime;
                    case 3 -> AbstractEPFurnaceBlockEntity.this.maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0 -> AbstractEPFurnaceBlockEntity.this.progress = i1;
                    case 1 -> AbstractEPFurnaceBlockEntity.this.maxProgress = i1;
                    case 2 -> AbstractEPFurnaceBlockEntity.this.burnTime = i1;
                    case 3 -> AbstractEPFurnaceBlockEntity.this.maxBurnTime = i1;

                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };

        //If something went wrong, the base maxProgress is set to 10 seconds/200 ticks
        this.maxProgress = 200;
    }

    //Handler getters (used on Jade compatibility)
    public ItemStackHandler getInputHandler() {
        return this.inputHandler;
    }

    public ItemStackHandler getFuelHandler() {
        return this.fuelHandler;
    }

    public ItemStackHandler getOutputHandler() {
        return this.outputHandler;
    }

    //Lazy handler getters (used on the menu)
    public LazyOptional<ItemStackHandler> getInputLazyHandler(){
        return this.inputLazyHandler;
    }

    public LazyOptional<ItemStackHandler> getFuelLazyHandler(){
        return this.fuelLazyHandler;
    }

    public LazyOptional<ItemStackHandler> getOutputLazyHandler(){
        return this.outputLazyHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            if (side == Direction.UP){
                return fuelLazyHandler.cast();
            } else if (side == Direction.DOWN){
                return outputLazyHandler.cast();
            } else {
                return inputLazyHandler.cast();
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inputLazyHandler.invalidate();
        fuelLazyHandler.invalidate();
        outputLazyHandler.invalidate();
    }

    //When the block is destroyed, drops all his contents
    public void Drops(){
        SimpleContainer inventory = new SimpleContainer(3);

        inventory.setItem(0, inputHandler.getStackInSlot(0));
        inventory.setItem(1, fuelHandler.getStackInSlot(0));
        inventory.setItem(2, outputHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    //Without this method, all the items would lose each time the player closes his world
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("mod_furnace.input", inputHandler.serializeNBT());
        pTag.put("mod_furnace.fuel", fuelHandler.serializeNBT());
        pTag.put("mod_furnace.output", outputHandler.serializeNBT());

        pTag.putInt("mod_furnace.progress", this.progress);
        pTag.putInt("mod_furnace.burnTime", this.burnTime);

        super.saveAdditional(pTag);
    }

    //Load NBT data to the block entity
    @Override
    public void load(CompoundTag pTag) {
        inputHandler.deserializeNBT(pTag.getCompound("mod_furnace.input"));
        fuelHandler.deserializeNBT(pTag.getCompound("mod_furnace.fuel"));
        outputHandler.deserializeNBT(pTag.getCompound("mod_furnace.output"));

        this.progress = pTag.getInt("mod_furnace.progress");
        this.burnTime = pTag.getInt("mod_furnace.burnTime");

        super.load(pTag);
    }

    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, AbstractEPFurnaceBlockEntity entity){
        //If it has any fuel, checks if the item inside has an associated recipe
        if (entity.isBurning()){
            if (entity.hasRecipe()){
                //If it has a recipe, sets the maxProgress matching the recipeType and then gradually increments the smeltProgress
                entity.setMaxProgress(entity.getCurrentRecipe());

                entity.increaseSmeltProgress();

                entity.sendUpdate();
            } else {
                //If the item is removed or the fuel drains, the progress is reset
                entity.resetProgress();
            }
            //Wherever has a recipe or not, sends an update telling the game that the furnace is on
            pState = pState.setValue(AbstractEPFurnaceBlock.BURNING, true);

            entity.decreaseBurnTime();

            entity.sendUpdate();
        //If it doesn't have fuel, checks if the item has a matching recipe
        } else if (entity.hasRecipe()){
            //Then, checks if the item on the fuelSlot can be burned and, if it can, consumes it
            if (entity.canBurn(entity.fuelHandler.getStackInSlot(0))){
                entity.burn();

                entity.sendUpdate();
            }
        //Like on the other case, sends an update telling that the furnace ran out of fuel
        } else {
            pState = pState.setValue(AbstractEPFurnaceBlock.BURNING, false);

            entity.resetProgress();

            entity.sendUpdate();
        }

        //If progress == maxProgress, removes an item from the inputSlot and put the result on the outputSlot
        if (entity.hasProcessFinished()){
            entity.smeltItem();

            entity.resetProgress();

            entity.sendUpdate();
        }

        //Tells the block if it needs to be changed
        pLevel.setBlock(pPos, pState, 1);
        setChanged(pLevel, pPos, pState);
    }

    //checks if the passed item has a "burntime" parameter on his metadata
    public boolean canBurn(ItemStack stack) {
        return getRecipeBurnTime(stack) > 0;
    }

    //returns the required burning time of the current recipe
    public int getRecipeBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, this.recipeType);
    }

    //checks if the burn time is mayor than 0
    private boolean isBurning(){
        return burnTime > 0;
    }

    //takes an item from the Fuel Slot, then copies his "burntime" metadata and gives it to burntime
    private void burn(){
        this.maxBurnTime = getRecipeBurnTime(this.fuelHandler.getStackInSlot(0));
        this.burnTime = this.maxBurnTime;
        this.fuelHandler.getStackInSlot(0).shrink(1);
    }

    //Simply decreases the burn time
    private void decreaseBurnTime(){
        burnTime -= 1;
    }

    //Resets the smelting progress
    private void resetProgress() {
        progress = 0;
    }

    //Increases the smelting progress
    private void increaseSmeltProgress() {
        progress++;
    }

    //Checks if the current smelt has finished
    private boolean hasProcessFinished (){
        return progress >= maxProgress;
    }

    //Returns the current progress
    public int getProgress() {
        return progress;
    }

    //Sets the maxProgress according to the recipeType
    public void setMaxProgress(Optional<? extends AbstractEPSmeltingRecipe> pRecipe){
        this.maxProgress = pRecipe.get().getCookTime();
    }

    //Gets the current maxProgress
    public int getMaxProgress() {
        return maxProgress;
    }

    //Returns the current recipe found
    protected Optional<? extends AbstractEPSmeltingRecipe> getCurrentRecipe(){
        SimpleContainer inv = new SimpleContainer(1);

        inv.setItem(0, inputHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(this.recipeType, inv, level);
    }

    //Checks if the item on the inputSlot has a recipe
    protected boolean hasRecipe(){
        Optional<? extends AbstractEPSmeltingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        } else {
            ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

            return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
        }
    }

    //Crafts the result of the recipe
    protected void smeltItem(){
        Optional<? extends AbstractEPSmeltingRecipe> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().getResultItem(getLevel().registryAccess());

        inputHandler.extractItem(0, 1, false);

        this.outputHandler.setStackInSlot(0, new ItemStack(output.getItem(),
                this.outputHandler.getStackInSlot(0).getCount() + output.getCount()));
    }

    //Checks if the result of the selected recipe matches the item in the Result Slot
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.outputHandler.getStackInSlot(0).isEmpty() || this.outputHandler.getStackInSlot(0).is(item);
    }

    //Checks if the item in the Result Slot is not in his maximum capacity
    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.outputHandler.getStackInSlot(0).getCount() + count <= this.outputHandler.getStackInSlot(0).getMaxStackSize();
    }
}
