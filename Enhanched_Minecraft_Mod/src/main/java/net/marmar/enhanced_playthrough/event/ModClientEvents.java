package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlockEntities;
import net.marmar.enhanced_playthrough.entity.model.ModModelLayers;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void subscribeLayerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event){
        //Boats
            //Walnut
            event.registerLayerDefinition(ModModelLayers.WALNUT_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.WALNUT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            //Apple
            event.registerLayerDefinition(ModModelLayers.APPLE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.APPLE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            //Orange
            event.registerLayerDefinition(ModModelLayers.ORANGE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.ORANGE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            //Lemon
            event.registerLayerDefinition(ModModelLayers.LEMON_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModModelLayers.LEMON_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void subscribeBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.HANGING_SIGN_BLOCK_ENTITY.get(), HangingSignRenderer::new);
    }

}
