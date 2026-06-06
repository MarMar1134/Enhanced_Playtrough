package net.marmar.enhanced_playthrough.block.custom.leatherworker;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.menu.leatherworker.LeatherworkerStationMenu;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.recipe.leatherwork.LeatherworkRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LeatherworkerStationBlockEntity extends BlockEntity implements MenuProvider {
    //Lime
    private final ItemStackHandler limeHandler =  new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> lazyLimeHandler = LazyOptional.of(() -> limeHandler);

    //Water
    private final ItemStackHandler bucketHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> lazyBucketHandler = LazyOptional.of(()-> bucketHandler);

    private final FluidTank waterTank = new FluidTank(1000) {
        @Override
        protected void onContentsChanged() {
            super.onContentsChanged();
            setChanged();
        }
    };

    private final LazyOptional<FluidTank> lazyWaterTank = LazyOptional.of(()-> waterTank);

    //Skin
    private final ItemStackHandler skinHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> lazySkinHandler = LazyOptional.of(()-> skinHandler);

    //Leather
    private final ItemStackHandler leatherHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> lazyLeatherHandler = LazyOptional.of(()-> leatherHandler);

    protected final ContainerData data;
    private int progress = 0;
    private final int maxProgress = 250;

    public LeatherworkerStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(EPBlockEntities.LEATHERWORKER_STATION_BLOCK_ENTITY.get(), pPos, pBlockState);

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> LeatherworkerStationBlockEntity.this.waterTank.getFluidAmount();
                    case 1 -> LeatherworkerStationBlockEntity.this.progress;
                    case 2 -> LeatherworkerStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {

            }

            @Override
            public int getCount() {
                return 3;
            }
        };
    }

    //Lime slot getters
    public ItemStackHandler getLimeHandler() {
        return this.limeHandler;
    }

    public LazyOptional<ItemStackHandler> getLazyLimeHandler() {
        return this.lazyLimeHandler;
    }

    //Bucket slot getters
    public ItemStackHandler getBucketHandler() {
        return this.bucketHandler;
    }

    public LazyOptional<ItemStackHandler> getLazyBucketHandler() {
        return this.lazyBucketHandler;
    }

    //Water tank getters
    public FluidTank getWaterTank() {
        return this.waterTank;
    }

    public LazyOptional<FluidTank> getLazyWaterTank() {
        return this.lazyWaterTank;
    }

    //Skin slot getters
    public ItemStackHandler getSkinHandler() {
        return this.skinHandler;
    }

    public LazyOptional<ItemStackHandler> getLazySkinHandler() {
        return this.lazySkinHandler;
    }

    //Leather slot getters
    public ItemStackHandler getLeatherHandler() {
        return this.leatherHandler;
    }

    public LazyOptional<ItemStackHandler> getLazyLeatherHandler() {
        return this.lazyLeatherHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER && side != null){
            return switch (side){
                case DOWN -> this.lazyLeatherHandler.cast();
                case WEST -> this.lazyBucketHandler.cast();
                case EAST -> this.lazySkinHandler.cast();
                case UP, NORTH, SOUTH -> super.getCapability(cap, side);
            };
        }

        if (cap == ForgeCapabilities.FLUID_HANDLER){
            return this.lazyWaterTank.cast();
        }

        return super.getCapability(cap, side);
    }

    public void drops(){
        SimpleContainer inv = new SimpleContainer(4);

        inv.setItem(0, this.limeHandler.getStackInSlot(0));
        inv.setItem(1, this.bucketHandler.getStackInSlot(0));
        inv.setItem(2, this.skinHandler.getStackInSlot(0));
        inv.setItem(3, this.leatherHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyLimeHandler.invalidate();
        this.lazyBucketHandler.invalidate();
        this.lazyWaterTank.invalidate();
        this.lazySkinHandler.invalidate();
        this.lazyLeatherHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("leatherworker.limeSlot", this.limeHandler.serializeNBT());
        pTag.put("leatherworker.bucketSlot", this.bucketHandler.serializeNBT());
        pTag.put("leatherworker.waterTank", this.waterTank.writeToNBT(new CompoundTag()));
        pTag.put("leatherworker.skinSlot", this.skinHandler.serializeNBT());
        pTag.put("leatherworker.leatherSlot", this.leatherHandler.serializeNBT());

        pTag.putInt("leatherworker.progress", this.progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.limeHandler.deserializeNBT(pTag.getCompound("leatherworker.limeSlot"));
        this.bucketHandler.deserializeNBT(pTag.getCompound("leatherworker.bucketSlot"));
        this.waterTank.readFromNBT(pTag.getCompound("leatherworker.waterTank"));
        this.skinHandler.deserializeNBT(pTag.getCompound("leatherworker.skinSlot"));
        this.leatherHandler.deserializeNBT(pTag.getCompound("leatherworker.leatherSlot"));

        this.progress = pTag.getInt("leatherworker.progress");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        CompoundTag tag = pkt.getTag();
        if (tag != null) load(tag);
    }

    protected void sendUpdate() {
        setChanged();

        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }

    private boolean canInsertAmountIntoLeatherSlot(int amount) {
        return this.leatherHandler.getStackInSlot(0).getCount() + amount <= this.leatherHandler.getStackInSlot(0).getMaxStackSize();
    }

    private boolean canInsertItemIntoLeatherSlot(Item item){
        return this.leatherHandler.getStackInSlot(0).is(item) || this.leatherHandler.getStackInSlot(0).isEmpty();
    }

    private Optional<LeatherworkRecipe> getCurrentRecipe() {
        SimpleContainer inv = new SimpleContainer(1);

        inv.setItem(0, this.skinHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(EPRecipes.LEATHERWORKING_TYPE.get(), inv, this.level);
    }

    private void tryConsumeWaterBucket() {
        LazyOptional<IFluidHandlerItem> bucketCap = this.bucketHandler.getStackInSlot(0).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM);

        bucketCap.ifPresent(itemFluidHandler -> {
            FluidStack inBucket = itemFluidHandler.getFluidInTank(0);

            if (inBucket.isEmpty() || !inBucket.getFluid().isSame(Fluids.WATER)) {
                return;
            }

            if (!this.waterTank.isEmpty() && !this.waterTank.getFluid().isFluidEqual(inBucket)) {
                return;
            }

            int amountToDrain = this.waterTank.getCapacity() - this.waterTank.getFluidAmount();
            int canDrain = itemFluidHandler.drain(amountToDrain, IFluidHandler.FluidAction.SIMULATE).getAmount();

            if (canDrain <= 0) {
                return;
            }

            FluidStack drained = itemFluidHandler.drain(amountToDrain, IFluidHandler.FluidAction.EXECUTE);
            this.waterTank.fill(drained, IFluidHandler.FluidAction.EXECUTE);

            this.bucketHandler.setStackInSlot(0, itemFluidHandler.getContainer());
        });
    }

    private boolean hasRecipe() {
        Optional<LeatherworkRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        FluidStack fluidInput = recipe.get().getFluidInput();

        if (!this.waterTank.getFluid().isFluidEqual(fluidInput)) {
            return false;
        }

        if (this.waterTank.getFluidAmount() < recipe.get().getFluidAmount()) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoLeatherSlot(result.getCount()) && canInsertItemIntoLeatherSlot(result.getItem());
    }

    private void leatherworkSkin() {
        Optional<LeatherworkRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.limeHandler.extractItem(0, 1, false);
        this.waterTank.drain(recipe.get().getFluidAmount(), IFluidHandler.FluidAction.EXECUTE);
        this.skinHandler.extractItem(0, 1, false);

        int currentCount = this.leatherHandler.getStackInSlot(0).getCount();

        this.leatherHandler.setStackInSlot(0, new ItemStack(result.getItem(), currentCount + recipe.get().getLeatherAmount()));
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (this.limeHandler.getStackInSlot(0).isEmpty()) {
            if (this.progress != 0) {
                this.progress = 0;
                sendUpdate();
            }
        }

        if (this.waterTank.getFluidAmount() < this.waterTank.getCapacity()) {
            tryConsumeWaterBucket();
            sendUpdate();
        }

        if (hasRecipe()) {
            this.progress++;
            if (this.progress >= this.maxProgress) {
                this.progress = 0;
                leatherworkSkin();
                sendUpdate();
            }
        } else {
            this.progress = 0;
            sendUpdate();
        }

        setChanged(pLevel, pPos, pState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.leatherworker_station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new LeatherworkerStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }
}
