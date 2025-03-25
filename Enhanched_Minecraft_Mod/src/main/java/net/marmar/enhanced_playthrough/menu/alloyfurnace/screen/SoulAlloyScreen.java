package net.marmar.enhanced_playthrough.menu.alloyfurnace.screen;

import net.marmar.enhanced_playthrough.menu.alloyfurnace.SoulAlloyFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SoulAlloyScreen extends AbstractAlloyScreen<SoulAlloyFurnaceMenu>{
    public SoulAlloyScreen(SoulAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
