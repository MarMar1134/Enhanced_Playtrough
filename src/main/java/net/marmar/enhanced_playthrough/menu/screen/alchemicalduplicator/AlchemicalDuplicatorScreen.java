package net.marmar.enhanced_playthrough.menu.screen.alchemicalduplicator;

import com.mojang.blaze3d.systems.RenderSystem;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.alchemicalduplicator.AlchemicalDuplicatorMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlchemicalDuplicatorScreen extends AbstractContainerScreen<AlchemicalDuplicatorMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID,
            "textures/gui/alchemical_duplicator_gui.png");

    public AlchemicalDuplicatorScreen(AlchemicalDuplicatorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;
        this.titleLabelY = 5;

        this.titleLabelX = 40;
    }

//    protected boolean isSpanish(Minecraft instance){
//        return switch (instance.getLanguageManager().getSelected()) {
//            case "es_ar", "es_cl", "es_ec", "es_mx", "es_es", "es_uy", "es_ve" -> true;
//            default -> false;
//        };
//    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderPowderBar(guiGraphics, x, y);
        renderBookLevel(guiGraphics, x, y);
        renderBookBar(guiGraphics, x, y);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderPowderBar(GuiGraphics guiGraphics, int x, int y){
        int powder = menu.getPowderLeft();
        if (powder <= 0) return;

        int maxWidth = 46;
        int width = powder * maxWidth / 64;

        guiGraphics.blit(TEXTURE, x + 33 + (maxWidth - width), y + 27, 112 + (maxWidth - width), 166, width, 6);
    }

    private void renderBookBar(GuiGraphics guiGraphics, int x, int y){
        int uses = menu.getBookUses();
        if (uses <= 0) return;

        int maxBookUses = menu.getMaxBookUses() != 0 ? menu.getMaxBookUses() : 1;

        int maxWidth = 46;
        int width = uses * maxWidth / maxBookUses;

        guiGraphics.blit(TEXTURE, x + 97, y + 27, 112, 173, width, 6);
    }

    private void renderBookLevel(GuiGraphics guiGraphics, int x, int y){
        int bookLevel = menu.getBookLevel();
        if (bookLevel == 0) return;

        switch (bookLevel){
            case 1 -> guiGraphics.blit(TEXTURE, x + 160, y + 12, 176, 0, 12, 10);
            case 2 -> guiGraphics.blit(TEXTURE, x + 160, y + 12, 176, 0, 12, 23);
            case 3 -> guiGraphics.blit(TEXTURE, x + 160, y + 12, 176, 0, 12, 36);
        }
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y){
        if (menu.isDupping()){
            guiGraphics.blit(TEXTURE, x + 33, y + 39, 0, 166, 110, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
