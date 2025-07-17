package net.marmar.enhanced_playthrough.menu.epfurnace;

import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MasonryFurnaceMenu extends AbstractEPFurnaceMenu {

    public MasonryFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(EPMenuTypes.MASONRY_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public MasonryFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(EPMenuTypes.MASONRY_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}
