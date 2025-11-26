package net.marmar.enhanced_playthrough.menu.screen.grinder;

import com.mojang.blaze3d.systems.RenderSystem;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.grinder.PrimalGrinderMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

@SuppressWarnings("removal")
public class PrimalGrinderScreen extends AbstractContainerScreen<PrimalGrinderMenu> {
    private static final ResourceLocation Texture =
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/gui/primal_grinder_gui.png");

    public PrimalGrinderScreen(PrimalGrinderMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelY = 5;

        if (isSpanish(Minecraft.getInstance())){
            this.titleLabelX = 65;
        } else {
            this.titleLabelX = 75;
        }
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

        renderFireProgress(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isGrinding()) {
            guiGraphics.blit(Texture, x + 80, y + 36, 176, 14, menu.getScaledProgress(), 17);
        }
    }

    private void renderFireProgress(GuiGraphics graphics, int x, int y){
        if (menu.isBurning()){
            graphics.blit(Texture, x + 45, y + 38 + 12 - menu.getFireDecrease(), 176, 13 - menu.getFireDecrease(), 13, menu.getFireDecrease() + 1);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
