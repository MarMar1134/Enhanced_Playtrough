package net.marmar.enhanced_playthrough.menu.screen.leatherworker;

import com.mojang.blaze3d.systems.RenderSystem;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.menu.leatherworker.LeatherworkerStationMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.templates.FluidTank;

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
        renderFluidTooltip(guiGraphics, pMouseX, pMouseY);
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
            guiGraphics.blit(TEXTURE, x + 93, y + 35, 177, 0, arrowWidth, 17);
        }
    }

    private static int getFluidHeight(IFluidTank tank) {
        return (int) (48 * ((float) tank.getFluidAmount() / tank.getCapacity()));
    }


    private void renderFluidTooltip(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        FluidTank tank = this.menu.getBlockEntity().getWaterTank();
        FluidStack fluidStack = tank.getFluid();
        if (fluidStack.isEmpty()) return;

        int fluidHeight = getFluidHeight(tank);

        if (!isHovering(45, 19 + (48 - fluidHeight), 12, fluidHeight, pMouseX, pMouseY))
            return;

        Component tooltip = MutableComponent.create(fluidStack.getDisplayName().getContents())
                .append(" (%d/%d mB)".formatted(tank.getFluidAmount(), tank.getCapacity()));

        guiGraphics.renderTooltip(this.font, tooltip, pMouseX, pMouseY);
    }


    private void renderFluid(GuiGraphics guiGraphics, int x, int y) {
        FluidTank tank = this.menu.getBlockEntity().getWaterTank();

        if (tank == null){
            return;
        }

        FluidStack fluidStack = tank.getFluid();

        if (fluidStack.isEmpty()) {
            return;
        }

        IClientFluidTypeExtensions ext = IClientFluidTypeExtensions.of(fluidStack.getFluid());
        ResourceLocation stillTexture = ext.getStillTexture(fluidStack);

        if (stillTexture == null) {
            return;
        }

        TextureAtlasSprite sprite = this.minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(stillTexture);

        int tint = ext.getTintColor(fluidStack);

        guiGraphics.setColor(
                ((tint >> 16) & 0xFF) / 255f,
                ((tint >> 8) & 0xFF) / 255f,
                ((tint) & 0xFF) / 255f,
                ((tint >> 24) & 0xFF) / 255f);

        int fluidHeight = getFluidHeight(tank);

        guiGraphics.blit(x + 45, y + 19 + (48 - fluidHeight), 0, 12, fluidHeight, sprite);

        guiGraphics.setColor(1f, 1f, 1f, 1f);

    }
}