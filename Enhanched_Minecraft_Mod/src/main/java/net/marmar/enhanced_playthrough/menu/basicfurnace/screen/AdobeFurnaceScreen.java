package net.marmar.enhanced_playthrough.menu.basicfurnace.screen;

import net.marmar.enhanced_playthrough.menu.basicfurnace.AdobeFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeFurnaceScreen extends AbstractBasicFurnaceScreen<AdobeFurnaceMenu> {

    public AdobeFurnaceScreen(AdobeFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
