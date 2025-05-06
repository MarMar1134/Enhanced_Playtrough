package net.marmar.enhanced_playthrough.menu.modfurnace.screen;

import net.marmar.enhanced_playthrough.menu.modfurnace.AdobeFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeFurnaceScreen extends AbstractModFurnaceScreen<AdobeFurnaceMenu> {

    public AdobeFurnaceScreen(AdobeFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
