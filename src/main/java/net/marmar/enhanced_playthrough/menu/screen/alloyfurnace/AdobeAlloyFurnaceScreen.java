package net.marmar.enhanced_playthrough.menu.screen.alloyfurnace;

import net.marmar.enhanced_playthrough.menu.alloyfurnace.AdobeAlloyFurnaceMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeAlloyFurnaceScreen extends AbstractAlloyScreen<AdobeAlloyFurnaceMenu> {
    public AdobeAlloyFurnaceScreen(AdobeAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelY = 5;

        if (isSpanish(Minecraft.getInstance())){
            this.titleLabelX = 20;
        } else {
            this.titleLabelX = 38;
        }
    }
}
