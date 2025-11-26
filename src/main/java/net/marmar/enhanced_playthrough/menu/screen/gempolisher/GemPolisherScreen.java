package net.marmar.enhanced_playthrough.menu.screen.gempolisher;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.gempolisher.GemPolisherMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

@SuppressWarnings("removal")
public class GemPolisherScreen extends AbstractContainerScreen<GemPolisherMenu> {
    private static final ResourceLocation Texture =
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/gui/gem_polisher_gui.png");
    public GemPolisherScreen(GemPolisherMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelY = 5;

        if (isSpanish(Minecraft.getInstance())){
            this.titleLabelX = 50;
        } else {
            this.titleLabelX = 58;
        }
    }

    protected boolean isSpanish(Minecraft instance){
        return switch (instance.getLanguageManager().getSelected()) {
            case "es_ar", "es_cl", "es_ec", "es_mx", "es_es", "es_uy", "es_ve" -> true;
            default -> false;
        };
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, Texture);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(Texture, x, y, 0, 0, imageWidth, imageHeight);
        renderUses(guiGraphics, x, y);
        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderUses(GuiGraphics graphics, int x, int y){
        if (menu.hasUses()){
            graphics.blit(Texture, x + 32 , y + 61, 176, 0, menu.usesCalculator(), 11);
        }
    }

    private void renderProgressArrow(GuiGraphics graphics, int x, int y){
        if (menu.isPolishing()){
            graphics.blit(Texture, x + 78, y + 35, 176, 12, menu.getScaledProgress(), 15);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);


    }
}
