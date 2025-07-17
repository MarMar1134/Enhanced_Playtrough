package net.marmar.enhanced_playthrough.menu.epfurnace;

import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SoulFurnaceMenu extends AbstractEPFurnaceMenu {
    public SoulFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(EPMenuTypes.SOUL_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public SoulFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(EPMenuTypes.SOUL_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}
