package net.marmar.enhanced_playthrough.entity.bandit.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.bandit.Bandit;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class BanditRenderer extends MobRenderer<Bandit, BanditModel<Bandit>> {
    public BanditRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BanditModel<>(pContext.bakeLayer(EPModelLayers.BANDIT_LAYER)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, pContext.getItemInHandRenderer()) {
            public void render(PoseStack poseStack, MultiBufferSource pBuffer, int pPackedLight, Bandit pBandit, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pHeadJaw, float pHeadPitch) {
                if (pBandit.isAggressive()) {
                    super.render(poseStack, pBuffer, pPackedLight, pBandit, pLimbSwing, pLimbSwingAmount, pPartialTicks, pAgeInTicks, pHeadJaw, pHeadPitch);
                }
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Bandit bandit) {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/bandit.png");
    }

    protected void scale(Bandit pBandit, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    public void render(Bandit pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
