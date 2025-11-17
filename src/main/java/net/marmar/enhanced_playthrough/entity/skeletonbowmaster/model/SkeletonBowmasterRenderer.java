package net.marmar.enhanced_playthrough.entity.skeletonbowmaster.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;

public class SkeletonBowmasterRenderer extends SkeletonRenderer {
    public SkeletonBowmasterRenderer(EntityRendererProvider.Context context) {
        super(context, EPModelLayers.SKELETON_BOWMASTER, EPModelLayers.SKELETON_BOWMASTER_INNER_ARMOR, EPModelLayers.SKELETON_BOWMASTER_OUTER_ARMOR);
        this.addLayer(new SkeletonBowmasterOuterLayer<>(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton pEntity) {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/skeleton_bowmaster/skeleton_bowmaster.png");
    }
}
