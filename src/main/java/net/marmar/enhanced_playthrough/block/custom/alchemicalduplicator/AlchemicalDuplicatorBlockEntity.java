package net.marmar.enhanced_playthrough.block.custom.alchemicalduplicator;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.menu.alchemicalduplicator.AlchemicalDuplicatorMenu;
import net.marmar.enhanced_playthrough.recipe.AlchemicalDuplicatingRecipe;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class AlchemicalDuplicatorBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler inputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final ItemStackHandler blazePowderHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final ItemStackHandler bookHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final ItemStackHandler outputsHandler = new ItemStackHandler(4){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inputLazyHandler = LazyOptional.of(() -> this.inputHandler);
    private final LazyOptional<ItemStackHandler> blazePowderLazyHandler = LazyOptional.of(() -> this.blazePowderHandler);
    private final LazyOptional<ItemStackHandler> bookLazyHandler = LazyOptional.of(() -> this.bookHandler);
    private final LazyOptional<ItemStackHandler> outputsLazyHandler = LazyOptional.of(() -> this.outputsHandler);

    protected final ContainerData data;

    private int blazePowderLeft = 0;
    private int bookUses = 0, maxBookUses = 0, bookLevel = 0;
    private int progress = 0, maxProgress = 200;

    public AlchemicalDuplicatorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.ALCHEMICAL_DUPLICATOR_BLOCK_ENTITY.get(), pPos, pBlockState);

        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 ->  AlchemicalDuplicatorBlockEntity.this.blazePowderLeft;
                    case 1 -> AlchemicalDuplicatorBlockEntity.this.bookUses;
                    case 2 -> AlchemicalDuplicatorBlockEntity.this.maxBookUses;
                    case 3 -> AlchemicalDuplicatorBlockEntity.this.bookLevel;
                    case 4 -> AlchemicalDuplicatorBlockEntity.this.progress;
                    case 5 -> AlchemicalDuplicatorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0 ->  AlchemicalDuplicatorBlockEntity.this.blazePowderLeft = i1;
                    case 1 -> AlchemicalDuplicatorBlockEntity.this.bookUses = i1;
                    case 2 -> AlchemicalDuplicatorBlockEntity.this.maxBookUses = i1;
                    case 3 -> AlchemicalDuplicatorBlockEntity.this.bookLevel = i1;
                    case 4 -> AlchemicalDuplicatorBlockEntity.this.progress = i1;
                    case 5 -> AlchemicalDuplicatorBlockEntity.this.maxProgress = i1;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };
    }

    //Handler getters
    public ItemStackHandler getInputHandler() {
        return inputHandler;
    }
    public ItemStackHandler getBlazePowderHandler() {
        return blazePowderHandler;
    }
    public ItemStackHandler getBookHandler() {
        return bookHandler;
    }
    public ItemStackHandler getOutputsHandler() {
        return outputsHandler;
    }

    //Lazy handler getters
    public LazyOptional<ItemStackHandler> getInputLazyHandler() {
        return inputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getBlazePowderLazyHandler() {
        return blazePowderLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getBookLazyHandler() {
        return bookLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getOutputsLazyHandler() {
        return outputsLazyHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            if (side == Direction.DOWN){
                return outputsLazyHandler.cast();
            } else if (side == Direction.WEST){
                return blazePowderLazyHandler.cast();
            } else if (side == Direction.EAST){
                return bookLazyHandler.cast();
            } else if (side == Direction.UP){
                return inputLazyHandler.cast();
            }
        }

        return super.getCapability(cap, side);
    }

    public void drops(){
        SimpleContainer inv = new SimpleContainer(7);

        inv.setItem(0, this.blazePowderHandler.getStackInSlot(0));
        inv.setItem(1, this.bookHandler.getStackInSlot(0));
        inv.setItem(2, this.inputHandler.getStackInSlot(0));

        for (int i = 0; i < this.outputsHandler.getSlots(); i++){
            inv.setItem(i + 3, this.outputsHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.blazePowderLazyHandler.invalidate();
        this.bookLazyHandler.invalidate();
        this.inputLazyHandler.invalidate();
        this.outputsLazyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("blazeSlot", this.blazePowderHandler.serializeNBT());
        pTag.put("bookSlot", this.bookHandler.serializeNBT());
        pTag.put("inputSlot", this.inputHandler.serializeNBT());
        pTag.put("outputSlots", this.outputsHandler.serializeNBT());

        pTag.putInt("powderLeft", this.blazePowderLeft);
        pTag.putInt("bookUses", this.bookUses);
        pTag.putInt("bookLevel", this.bookLevel);
        pTag.putInt("progress", this.progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.blazePowderHandler.deserializeNBT(pTag.getCompound("blazeSlot"));
        this.bookHandler.deserializeNBT(pTag.getCompound("bookSlot"));
        this.inputHandler.deserializeNBT(pTag.getCompound("inputSlot"));
        this.outputsHandler.deserializeNBT(pTag.getCompound("outputSlots"));

        this.blazePowderLeft = pTag.getInt("powderLeft");
        this.bookUses = pTag.getInt("bookUses");
        this.bookLevel = pTag.getInt("bookLevel");
        this.progress = pTag.getInt("progress");
    }

    protected void sendUpdate() {
        setChanged();

        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }

    private boolean hasPowderLeft(){
        return this.blazePowderLeft > 0;
    }

    private void decreasePowder(){
        this.blazePowderLeft--;
    }

    private void consumePowder(){
        this.blazePowderHandler.getStackInSlot(0).shrink(1);
        this.blazePowderLeft = 64;
    }

    private boolean isFortuneBook(ItemStack bookStack){
        if (!bookStack.is(Items.ENCHANTED_BOOK)){
            return false;
        }

        Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(bookStack);

        return enchants.containsKey(Enchantments.BLOCK_FORTUNE);
    }

    private int getBookLevel(ItemStack bookStack){
        if (!isFortuneBook(bookStack)) return 0;

        Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(bookStack);

        return enchants.getOrDefault(Enchantments.BLOCK_FORTUNE, 0);
    }

    private boolean hasBookUses() {
        return this.bookUses > 0;
    }

    private void tryConsumeBook(){
        if (isFortuneBook(this.bookHandler.getStackInSlot(0))){
            this.bookLevel = getBookLevel(this.bookHandler.getStackInSlot(0));
            this.bookUses = switch (this.bookLevel){
                case 1 -> 128;
                case 2 -> 64;
                case 3 -> 32;
                default -> 0;
            };

            this.bookHandler.getStackInSlot(0).shrink(1);
            this.bookHandler.setStackInSlot(0, new ItemStack(Items.BOOK));

            this.maxBookUses = this.bookUses;
        } else {
            this.bookUses = 0;
            this.maxBookUses = 0;
        }
    }

    private void decreaseBookUses(){
        this.bookUses--;
    }

    private Optional<AlchemicalDuplicatingRecipe> getCurrentRecipe(){
        SimpleContainer inv = new SimpleContainer(1);

        inv.setItem(0, this.inputHandler.getStackInSlot(0));

        Optional<AlchemicalDuplicatingRecipe> recipe = this.level.getRecipeManager()
                .getRecipeFor(EPRecipes.ALCHEMICAL_DUPLICATING_TYPE.get(), inv, level);

        return recipe;
    }

    private boolean isDupping(){
        return this.progress != 0;
    }

    private boolean hasFinishedDupping(){
        return this.progress >= this.maxProgress;
    }

    private void increaseDuppingProgress(){
        this.progress++;
    }

    private void resetProgress(){
        this.progress = 0;
    }

    private boolean canInsertItemIntoOutputSlot(Item item){
        for (int i = 0; i < this.outputsHandler.getSlots(); i++){
            if (this.outputsHandler.getStackInSlot(i).is(item) || this.outputsHandler.getStackInSlot(i).isEmpty())
                return true;
        }

        return false;
    }

    private boolean canInsertAmountIntoOutputSlot(int amount){
        for (int i = 0; i < this.outputsHandler.getSlots(); i++){
            if (this.outputsHandler.getStackInSlot(i).getCount() + amount <= this.outputsHandler.getStackInSlot(i).getMaxStackSize()){
                return true;
            }
        }
        return false;
    }

    private boolean hasRecipe(){
        Optional<AlchemicalDuplicatingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private void duplicateItem(){
        Optional<AlchemicalDuplicatingRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        EnhancedPlaythrough.LOGGER.info("Book uses:{}", this.bookUses);

        EnhancedPlaythrough.LOGGER.info("Book level: {}", this.bookLevel);

        this.inputHandler.extractItem(0, 1, false);

        int copies = this.bookLevel + 1;

        for (int i = 0; i < copies; i++){
            this.outputsHandler.setStackInSlot(i, new ItemStack(result.getItem(),
                    this.outputsHandler.getStackInSlot(i).getCount() + result.getCount()));
        }
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState){
        if (!hasBookUses() && isFortuneBook(this.bookHandler.getStackInSlot(0))) {
            tryConsumeBook();
            pLevel.playSound(null, pPos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1f, 0.5f);
            sendUpdate();
        }

        if (hasRecipe() && hasPowderLeft()){
            increaseDuppingProgress();

            sendUpdate();
        } else if (hasRecipe() && !this.blazePowderHandler.getStackInSlot(0).isEmpty()){
            consumePowder();

            sendUpdate();
        } else {
            resetProgress();

            sendUpdate();
        }

        if (hasFinishedDupping()){
            decreasePowder();

            resetProgress();

            pLevel.playSound(null, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 0.5f);
            duplicateItem();

            if (hasBookUses()){
                decreaseBookUses();
            } else {
                this.bookLevel = 0;
            }

            sendUpdate();
        }

        if (isDupping()) {
            pState = pState.setValue(AlchemicalDuplicatorBlock.LIT, true);
        } else {
            pState = pState.setValue(AlchemicalDuplicatorBlock.LIT, false);
        }

        pLevel.setBlock(pPos, pState, 1);
        setChanged(pLevel, pPos, pState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block." + EnhancedPlaythrough.MOD_ID + ".alchemical_duplicator");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AlchemicalDuplicatorMenu(i, inventory, this, this.data);
    }
}
