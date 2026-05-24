package net.marmar.enhanced_playthrough.menu.screen.leatherworker;

import com.mojang.blaze3d.systems.RenderSystem;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.leatherworker.LeatherworkerStationMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LeatherworkerStationScreen extends AbstractContainerScreen<LeatherworkerStationMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,
            "textures/gui/leatherworker_station_gui.png");

    public LeatherworkerStationScreen(LeatherworkerStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelY = 5;

        this.titleLabelX = 40;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(guiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderFluid(guiGraphics, x, y);
        renderArrowProgress(guiGraphics, x, y);
    }

    private void renderArrowProgress(GuiGraphics guiGraphics, int x, int y){
        int arrowWidth = this.menu.getScaledProgress();

        if (arrowWidth > 0) {
            guiGraphics.blit(TEXTURE, x + 93, y + 35, 177, 0, arrowWidth, 15);
        }
    }

    private void renderFluid(GuiGraphics guiGraphics, int x, int y) {
        int fluidHeight = this.menu.getScaledFluidLevel(48);

        if (fluidHeight > 0) {
            guiGraphics.blit(TEXTURE, x + 36, y + 18 + (48 - fluidHeight), 176, 18 + (48 - fluidHeight), 12, fluidHeight);
        }
    }
}