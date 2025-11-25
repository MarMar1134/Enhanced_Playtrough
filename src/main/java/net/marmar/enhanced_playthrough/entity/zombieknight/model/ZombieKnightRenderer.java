package net.marmar.enhanced_playthrough.entity.zombieknight.model;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class ZombieKnightRenderer extends AbstractZombieRenderer<ZombieKnight, ZombieModel<ZombieKnight>> {
    public ZombieKnightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ZombieModel<>(pContext.bakeLayer(EPModelLayers.ZOMBIE_KNIGHT)),
                new ZombieModel<>(pContext.bakeLayer(EPModelLayers.ZOMBIE_KNIGHT_INNER_ARMOR)),
                new ZombieModel<>(pContext.bakeLayer(EPModelLayers.ZOMBIE_KNIGHT_OUTER_ARMOR)));

        this.addLayer(new ZombieKnightOuterLayer<>(this, pContext.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie pEntity) {
        return ResourceLocation.fromNamespaceAndPath(EnhancedPlaythrough.MOD_ID, "textures/entity/zombie_knight/zombie_knight.png");
    }
}
