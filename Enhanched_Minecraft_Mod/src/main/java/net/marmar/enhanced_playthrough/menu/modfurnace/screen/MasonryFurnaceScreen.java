package net.marmar.enhanced_playthrough.menu.modfurnace.screen;

import net.marmar.enhanced_playthrough.menu.modfurnace.MasonryFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class MasonryFurnaceScreen extends AbstractModFurnaceScreen<MasonryFurnaceMenu> {
    public MasonryFurnaceScreen(MasonryFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
