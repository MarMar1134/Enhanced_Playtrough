package net.marmar.enhanced_playthrough.menu.screen.modfurnace;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.epfurnace.AbstractEPFurnaceMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractModFurnaceScreen<T extends AbstractEPFurnaceMenu> extends AbstractContainerScreen<T> {
    private static final ResourceLocation Texture =
            ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, "textures/gui/basic_furnace_gui.png");

    public AbstractModFurnaceScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    protected boolean isSpanish(Minecraft instance){
        return switch (instance.getLanguageManager().getSelected()) {
            case "es_ar", "es_cl", "es_ec", "es_mx", "es_es", "es_uy", "es_ve" -> true;
            default -> false;
        };
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, Texture);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(Texture, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        renderFire(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(Texture, x + 80, y + 35, 176, 14, menu.getScaledProgress(), 17);
        }
    }

    private void renderFire(GuiGraphics guiGraphics, int x, int y){
        if(menu.isBurning()){
            guiGraphics.blit(Texture, x + 57, y + 37 + 12 - menu.getFireDecrease(), 176, 12 - menu.getFireDecrease(), 12, menu.getFireDecrease() + 1);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
