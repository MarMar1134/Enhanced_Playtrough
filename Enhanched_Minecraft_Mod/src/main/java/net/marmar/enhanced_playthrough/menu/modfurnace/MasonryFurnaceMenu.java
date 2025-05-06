package net.marmar.enhanced_playthrough.menu.modfurnace;

import net.marmar.enhanced_playthrough.menu.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MasonryFurnaceMenu extends AbstractModFurnaceMenu {

    public MasonryFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.MASONRY_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public MasonryFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.MASONRY_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}
