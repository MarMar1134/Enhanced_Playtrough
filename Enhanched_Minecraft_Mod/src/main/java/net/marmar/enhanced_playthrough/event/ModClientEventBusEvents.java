package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.ModBlockEntities;
import net.marmar.enhanced_playthrough.block.custom.wood.ModWoodTypes;
import net.marmar.enhanced_playthrough.entity.ModEntities;
import net.marmar.enhanced_playthrough.entity.model.BanditModel;
import net.marmar.enhanced_playthrough.entity.model.BanditRenderer;
import net.marmar.enhanced_playthrough.entity.model.ModBoatRenderer;
import net.marmar.enhanced_playthrough.entity.model.ModModelLayers;
import net.marmar.enhanced_playthrough.menu.ModMenuTypes;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.AdobeAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.SoulAlloyScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.SuperAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.AdobeFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.SoulFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.gempolisher.GemPolisherScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.MechanicalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.PrimalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.MasonryFurnaceScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventBusEvents {
    @SubscribeEvent
    public static void subscribeEntityRenderers(FMLClientSetupEvent event){
        //Mobs
        EntityRenderers.register(ModEntities.BANDIT.get(), BanditRenderer::new);

        //Boats
        EntityRenderers.register(ModEntities.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
        EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));

        //Cobble
        EntityRenderers.register(ModEntities.THROWABLE_COBBLE.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public static void subscribeLayerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event){
        //Mobs
        event.registerLayerDefinition(ModModelLayers.BANDIT_LAYER, BanditModel::createBodyLayer);

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

    @SubscribeEvent
    public static void subscribeMenus(FMLClientSetupEvent onClientSetup){
        MenuScreens.register(ModMenuTypes.ADOBE_FURNACE_MENU.get(), AdobeFurnaceScreen::new);
        MenuScreens.register(ModMenuTypes.SOUL_FURNACE_MENU.get(), SoulFurnaceScreen::new);

        MenuScreens.register(ModMenuTypes.MASONRY_FURNACE_MENU.get(), MasonryFurnaceScreen::new);

        MenuScreens.register(ModMenuTypes.ADOBE_ALLOYING_FURNACE_MENU.get(), AdobeAlloyFurnaceScreen::new);
        MenuScreens.register(ModMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), SuperAlloyFurnaceScreen::new);
        MenuScreens.register(ModMenuTypes.SOUL_ALLOY_FURNACE_MENU.get(), SoulAlloyScreen::new);

        MenuScreens.register(ModMenuTypes.GEM_POLISHER_MENU.get(), GemPolisherScreen::new);

        MenuScreens.register(ModMenuTypes.PRIMAL_GRINDER_MENU.get(), PrimalGrinderScreen::new);
        MenuScreens.register(ModMenuTypes.MECHANICAL_GRINDER_MENU.get(), MechanicalGrinderScreen::new);
    }

    @SubscribeEvent
    public static void subscribeWoodTypes(FMLClientSetupEvent event){
        Sheets.addWoodType(ModWoodTypes.WALNUT);
        Sheets.addWoodType(ModWoodTypes.APPLE);
        Sheets.addWoodType(ModWoodTypes.ORANGE);
        Sheets.addWoodType(ModWoodTypes.LEMON);
    }
}
