package net.marmar.enhanced_playthrough.menu.alloyfurnace;

import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;

public class PrimitiveAlloyFurnaceMenu extends AbstractAlloyFurnaceMenu {
    public PrimitiveAlloyFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(EPMenuTypes.PRIMITIVE_ALLOY_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public PrimitiveAlloyFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(EPMenuTypes.PRIMITIVE_ALLOY_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}
