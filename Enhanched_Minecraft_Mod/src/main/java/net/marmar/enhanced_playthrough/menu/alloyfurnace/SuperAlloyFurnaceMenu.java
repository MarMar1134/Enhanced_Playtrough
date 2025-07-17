package net.marmar.enhanced_playthrough.menu.alloyfurnace;

import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SuperAlloyFurnaceMenu extends AbstractAlloyFurnaceMenu {

    public SuperAlloyFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(EPMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public SuperAlloyFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(EPMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}
