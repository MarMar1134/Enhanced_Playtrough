package net.marmar.enhanced_playthrough.menu.leatherworker;

import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.block.custom.leatherworker.LeatherworkerStationBlockEntity;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class LeatherworkerStationMenu extends AbstractContainerMenu {
    private final LeatherworkerStationBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public LeatherworkerStationMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(3));
    }

    public LeatherworkerStationMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(EPMenuTypes.LEATHERWORKER_STATION_MENU.get(), pContainerId);
        this.blockEntity = (LeatherworkerStationBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        createSlots((LeatherworkerStationBlockEntity) entity);
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addDataSlots(data);
    }

    public int getScaledProgress() {
        int progress = this.data.get(1);
        int maxProgress = this.data.get(2);
        int arrowSize = 23;

        return (maxProgress != 0 && progress != 0) ? progress * arrowSize / maxProgress : 0;
    }

    public int getScaledFluidLevel(int barHeight) {
        int amount = this.data.get(0);
        int capacity = 1000;
        return amount != 0 ? amount * barHeight / capacity : 0;
    }


    public LeatherworkerStationBlockEntity getBlockEntity() {
        return this.blockEntity;
    }

    private void createSlots(LeatherworkerStationBlockEntity pLeatherworker) {
        //Lime slot
        pLeatherworker.getLazyLimeHandler().ifPresent(itemStackHandler -> {
            addSlot(new SlotItemHandler(itemStackHandler, 0, 13, 19){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return super.mayPlace(stack);
                }
            });
        });

        //Bucket slot
        pLeatherworker.getLazyBucketHandler().ifPresent(itemStackHandler -> {
            addSlot(new SlotItemHandler(itemStackHandler, 0, 13, 51){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                }
            });
        });

        //Skin slot
        pLeatherworker.getLazySkinHandler().ifPresent(itemStackHandler -> {
            addSlot(new SlotItemHandler(itemStackHandler, 0, 63, 35));
        });

        //Leather slot
        pLeatherworker.getLazyLeatherHandler().ifPresent(itemStackHandler -> {
            addSlot(new SlotItemHandler(itemStackHandler, 0, 134, 35){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
        });
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    private static final int PLAYER_MAIN_ROWS = 3;
    private static final int PLAYER_COLS = 9;
    private static final int HOTBAR_SIZE = 9;
    private static final int PLAYER_SLOT_COUNT = PLAYER_MAIN_ROWS * PLAYER_COLS + HOTBAR_SIZE;
    private static final int PLAYER_FIRST_SLOT = 0;

    private static final int TE_FIRST_SLOT = PLAYER_SLOT_COUNT;
    private static final int TE_SLOT_LIME = TE_FIRST_SLOT;
    private static final int TE_SLOT_BUCKET = TE_FIRST_SLOT + 1;
    private static final int TE_SLOT_SKIN = TE_FIRST_SLOT + 2;
    private static final int TE_SLOT_LEATHER = TE_FIRST_SLOT + 3;
    private static final int TE_SLOT_COUNT = 4;

    @Override
    public ItemStack quickMoveStack(Player player, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack source     = sourceSlot.getItem();
        ItemStack sourceCopy = source.copy();

        if (pIndex < PLAYER_SLOT_COUNT) {
            if (!moveItemStackTo(source, TE_FIRST_SLOT, TE_SLOT_LEATHER, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex == TE_SLOT_LEATHER) {
            if (!moveItemStackTo(source, PLAYER_FIRST_SLOT, PLAYER_SLOT_COUNT, true)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (!moveItemStackTo(source, PLAYER_FIRST_SLOT, PLAYER_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        }

        if (source.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, source);
        return sourceCopy;
    }


    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(this.level, this.blockEntity.getBlockPos()),
                pPlayer, EPBlocks.LEATHERWORKER_STATION.get());
    }
}
