package net.marmar.enhanced_playthrough.menu.alchemicalduplicator;

import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.block.custom.alchemicalduplicator.AlchemicalDuplicatorBlockEntity;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class AlchemicalDuplicatorMenu extends AbstractContainerMenu {
    public final AlchemicalDuplicatorBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public AlchemicalDuplicatorMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData){
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(6));
    }

    public AlchemicalDuplicatorMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(EPMenuTypes.ALCHEMICAL_DUPLICATOR_MENU.get(), pContainerId);
        this.blockEntity = (AlchemicalDuplicatorBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        createSlots((AlchemicalDuplicatorBlockEntity) entity);
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addDataSlots(data);
    }

    private void createSlots(AlchemicalDuplicatorBlockEntity alchemicalDuplicator){
        //Blaze powder
        alchemicalDuplicator.getSulfurSlotLazyHandler().ifPresent(itemStackHandler ->
                addSlot(new SlotItemHandler(itemStackHandler, 0, 16, 22){
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return stack.is(EPItems.SULFUR.get());
            }
        }));

        //Book
        alchemicalDuplicator.getBookSlotLazyHandler().ifPresent(itemStackHandler ->
                addSlot(new SlotItemHandler(itemStackHandler, 0, 144, 22){
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return stack.is(Items.ENCHANTED_BOOK);
            }
        }));

        //Input
        alchemicalDuplicator.getInputSlotLazyHandler().ifPresent(itemStackHandler -> {
            addSlot(new SlotItemHandler(itemStackHandler, 0, 80, 22){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return stack.is(EPTags.Items.ALCHEMICAL_DUPLICATING_INGREDIENT);
                }
            });
        });

        //Outputs
        alchemicalDuplicator.getOutputSlotLazyHandler().ifPresent(itemStackHandler -> {
            addSlot(new SlotItemHandler(itemStackHandler, 0, 33, 56){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
            addSlot(new SlotItemHandler(itemStackHandler, 1, 65, 56){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
            addSlot(new SlotItemHandler(itemStackHandler, 2, 96, 56){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
            addSlot(new SlotItemHandler(itemStackHandler, 3, 127, 56){
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return false;
                }
            });
        });
    }

    public int getPowderLeft(){
        return this.data.get(0);
    }

    public int getBookUses(){
        return this.data.get(1);
    }

    public int getMaxBookUses(){
        return this.data.get(2);
    }

    public int getBookLevel(){
        return this.data.get(3);
    }

    public boolean isDupping(){
        return this.data.get(4) > 0;
    }

    public int getScaledProgress(){
        int progress = this.data.get(4);
        int maxProgress = this.data.get(5);
        int arrowSize = 16;

        return maxProgress != 0 && progress != 0 ? progress * arrowSize / maxProgress : 0;
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 7;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, EPBlocks.ALCHEMICAL_DUPLICATOR.get());
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
}
