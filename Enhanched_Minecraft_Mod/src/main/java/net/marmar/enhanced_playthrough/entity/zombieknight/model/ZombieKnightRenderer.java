package net.marmar.enhanced_playthrough.entity.zombieknight.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class ZombieKnightRenderer extends MobRenderer<ZombieKnight, ZombieKnightModel<ZombieKnight>> {
    public ZombieKnightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieKnightModel<>(pContext.bakeLayer(EPModelLayers.ZOMBIE_KNIGHT_LAYER)), 0.5f);

        this.addLayer(new ItemInHandLayer<>(this, pContext.getItemInHandRenderer()));

        this.addLayer(new ZombieKnightOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(ZombieKnight pEntity) {
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "textures/entity/zombie_knight/zombie_knight.png");
    }
}
