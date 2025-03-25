package net.marmar.enhanced_playthrough.menu.alloyfurnace.screen;

import net.marmar.enhanced_playthrough.menu.alloyfurnace.AdobeAlloyFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeAlloyFurnaceScreen extends AbstractAlloyScreen<AdobeAlloyFurnaceMenu> {

    public AdobeAlloyFurnaceScreen(AdobeAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
