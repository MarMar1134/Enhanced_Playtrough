package net.marmar.enhanced_playthrough.menu.screen.modfurnace;

import net.marmar.enhanced_playthrough.menu.modfurnace.SoulFurnaceMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SoulFurnaceScreen extends AbstractModFurnaceScreen<SoulFurnaceMenu> {
    public SoulFurnaceScreen(SoulFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelY = 5;

        if (isSpanish(Minecraft.getInstance())){
            this.titleLabelX = 36;
        } else {
            this.titleLabelX = 50;
        }
    }
}
