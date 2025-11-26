package net.marmar.enhanced_playthrough.entity.projectile.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.projectile.AluminumArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class AluminumArrowRenderer extends ArrowRenderer<AluminumArrowEntity> {
    public AluminumArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureLocation(AluminumArrowEntity pEntity) {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/projectiles/aluminum_arrow.png");
    }
}
