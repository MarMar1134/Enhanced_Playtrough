package net.marmar.enhanced_playthrough.entity.skeletonbowmaster.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;

@SuppressWarnings("removal")
public class SkeletonBowmasterOuterLayer<T extends Mob & RangedAttackMob, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation SKELETON_BOWMASTER_OUTER_LOCATION = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/entity/skeleton_bowmaster/skeleton_bowmaster_outer.png");
    private final SkeletonModel<T> layerModel;

    public SkeletonBowmasterOuterLayer(RenderLayerParent<T, M> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer);
        this.layerModel = new SkeletonModel<>(pModelSet.bakeLayer(EPModelLayers.SKELETON_BOWMASTER_OUTER));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.layerModel, SKELETON_BOWMASTER_OUTER_LOCATION, pPoseStack, pBuffer, pPackedLight, pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch, pPartialTicks, 1.0F, 1.0F, 1.0F);
    }
}
