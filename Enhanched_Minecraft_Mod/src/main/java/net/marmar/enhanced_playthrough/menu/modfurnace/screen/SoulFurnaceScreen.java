package net.marmar.enhanced_playthrough.menu.modfurnace.screen;

import net.marmar.enhanced_playthrough.menu.modfurnace.SoulFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SoulFurnaceScreen extends AbstractModFurnaceScreen<SoulFurnaceMenu> {
    public SoulFurnaceScreen(SoulFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
