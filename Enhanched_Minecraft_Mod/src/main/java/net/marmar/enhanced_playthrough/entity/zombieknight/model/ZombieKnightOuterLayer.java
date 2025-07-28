package net.marmar.enhanced_playthrough.entity.zombieknight.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class ZombieKnightOuterLayer<T extends ZombieKnight> extends RenderLayer<T, ZombieKnightModel<T>> {
    private static final ResourceLocation ZOMBIE_KNIGHT_OUTER_LAYER = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/zombie_knight/zombie_knight_outer_layer.png");
    private final ZombieKnightModel<T> model;

    public ZombieKnightOuterLayer(RenderLayerParent<T, ZombieKnightModel<T>> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer);
        this.model = new ZombieKnightModel<>(pModelSet.bakeLayer(EPModelLayers.ZOMBIE_KNIGHT_OUTER_LAYER));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, ZOMBIE_KNIGHT_OUTER_LAYER, pPoseStack, pBuffer, pPackedLight, pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch, pPartialTick, 1.0F, 1.0F, 1.0F);
    }
}
