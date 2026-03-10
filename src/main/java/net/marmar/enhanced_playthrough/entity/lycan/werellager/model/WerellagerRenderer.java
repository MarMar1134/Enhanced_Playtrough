package net.marmar.enhanced_playthrough.entity.lycan.werellager.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.marmar.enhanced_playthrough.entity.lycan.AbstractLycanMob;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.Werellager;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WerellagerRenderer extends MobRenderer<Werellager, EntityModel<Werellager>> {
    private final WerellagerHumanModel<Werellager> humanModel;
    private final WerellagerLycanModel<Werellager> lycanModel;

    public WerellagerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WerellagerHumanModel<>(pContext.bakeLayer(EPModelLayers.WERELLAGER_HUMAN)), 0.5f);
        this.humanModel = (WerellagerHumanModel<Werellager>) this.model;
        this.lycanModel = new WerellagerLycanModel<>(pContext.bakeLayer(EPModelLayers.WERELLAGER_LYCAN));
    }

    @Override
    @SuppressWarnings("removal")
    @NotNull
    public ResourceLocation getTextureLocation(Werellager pEntity) {
        if (pEntity.getState() == AbstractLycanMob.LycanState.LYCAN_FORM) {
            return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/werellager/werellager_lycan.png");
        }
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/werellager/werellager_human.png");
    }

    @Override
    public void render(@NotNull Werellager pEntity, float pEntityYaw, float pPartialTicks, @NotNull PoseStack pMatrixStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.getState() == AbstractLycanMob.LycanState.LYCAN_FORM) {
            this.model = this.lycanModel;
        } else {
            this.model = this.humanModel;
        }

        this.model.setupAnim(pEntity, pPartialTicks, 0, pEntity.tickCount + pPartialTicks, pEntity.getYHeadRot(), pEntity.getXRot());

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
