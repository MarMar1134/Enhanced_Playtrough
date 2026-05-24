package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.block.custom.wood.EPWoodTypes;
import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.marmar.enhanced_playthrough.entity.bandit.model.BanditModel;
import net.marmar.enhanced_playthrough.entity.bandit.model.BanditRenderer;
import net.marmar.enhanced_playthrough.entity.boat.model.ModBoatRenderer;
import net.marmar.enhanced_playthrough.entity.EPModelLayers;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.model.WerellagerHumanModel;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.model.WerellagerLycanModel;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.model.WerellagerRenderer;
import net.marmar.enhanced_playthrough.entity.projectile.model.AluminumArrowRenderer;
import net.marmar.enhanced_playthrough.entity.skeletonbowmaster.model.SkeletonBowmasterRenderer;
import net.marmar.enhanced_playthrough.entity.zombieknight.model.ZombieKnightRenderer;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.menu.screen.alchemicalduplicator.AlchemicalDuplicatorScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.AdobeAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.SoulAlloyScreen;
import net.marmar.enhanced_playthrough.menu.screen.alloyfurnace.SuperAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.leatherworker.LeatherworkerStationScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.AdobeFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.SoulFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.screen.gempolisher.GemPolisherScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.MechanicalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.grinder.PrimalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.screen.modfurnace.MasonryFurnaceScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EPClientEventBusEvents {
    public static final CubeDeformation OUTER_ARMOR_DEFORMATION = new CubeDeformation(1.0F);
    public static final CubeDeformation INNER_ARMOR_DEFORMATION = new CubeDeformation(0.5F);

    @SubscribeEvent
    public static void subscribeEntityRenderers(FMLClientSetupEvent event){
        //Mobs
        EntityRenderers.register(EPEntityTypes.BANDIT.get(), BanditRenderer::new);
        EntityRenderers.register(EPEntityTypes.ZOMBIE_KNIGHT.get(), ZombieKnightRenderer::new);
        EntityRenderers.register(EPEntityTypes.SKELETON_BOWMASTER.get(), SkeletonBowmasterRenderer::new);
        EntityRenderers.register(EPEntityTypes.WERELLAGER.get(), WerellagerRenderer::new);

        //Boats
        EntityRenderers.register(EPEntityTypes.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
        EntityRenderers.register(EPEntityTypes.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));

        //Cobble
        EntityRenderers.register(EPEntityTypes.THROWABLE_COBBLE.get(), ThrownItemRenderer::new);

        //Aluminum arrow
        EntityRenderers.register(EPEntityTypes.ALUMINUM_ARROW.get(), AluminumArrowRenderer::new);

        //Flower pots
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EPBlocks.COLD_LYRIUM.getId(), EPBlocks.POTTED_COLD_LYRIUM));
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EPBlocks.SUCCULENT.getId(), EPBlocks.POTTED_SUCCULENT));
    }

    @SubscribeEvent
    public static void registerEntityLayerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event){
        //Bandit
        event.registerLayerDefinition(EPModelLayers.BANDIT, BanditModel::createBodyLayer);

        //Zombie knight
        event.registerLayerDefinition(EPModelLayers.ZOMBIE_KNIGHT, () ->
                LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 64));
        event.registerLayerDefinition(EPModelLayers.ZOMBIE_KNIGHT_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(EPModelLayers.ZOMBIE_KNIGHT_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(EPModelLayers.ZOMBIE_KNIGHT_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.25f), 0.0f), 64, 64));

        //Skeleton bowmaster
        event.registerLayerDefinition(EPModelLayers.SKELETON_BOWMASTER, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(EPModelLayers.SKELETON_BOWMASTER_INNER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(EPModelLayers.SKELETON_BOWMASTER_OUTER_ARMOR, () ->
                LayerDefinition.create(HumanoidArmorModel.createBodyLayer(OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(EPModelLayers.SKELETON_BOWMASTER_OUTER, () ->
                LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.2f), 0.0f), 64, 32));

        //Werellager
        event.registerLayerDefinition(EPModelLayers.WERELLAGER_HUMAN, WerellagerHumanModel::createBodyLayer);
        event.registerLayerDefinition(EPModelLayers.WERELLAGER_LYCAN, WerellagerLycanModel::createBodyLayer);

        //Boats
            //Walnut
            event.registerLayerDefinition(EPModelLayers.WALNUT_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(EPModelLayers.WALNUT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            //Apple
            event.registerLayerDefinition(EPModelLayers.APPLE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(EPModelLayers.APPLE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            //Orange
            event.registerLayerDefinition(EPModelLayers.ORANGE_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(EPModelLayers.ORANGE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

            //Lemon
            event.registerLayerDefinition(EPModelLayers.LEMON_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(EPModelLayers.LEMON_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void subscribeBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(EPBlockEntities.SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(EPBlockEntities.HANGING_SIGN_BLOCK_ENTITY.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void subscribeMenus(FMLClientSetupEvent onClientSetup){
        MenuScreens.register(EPMenuTypes.ADOBE_FURNACE_MENU.get(), AdobeFurnaceScreen::new);
        MenuScreens.register(EPMenuTypes.SOUL_FURNACE_MENU.get(), SoulFurnaceScreen::new);

        MenuScreens.register(EPMenuTypes.MASONRY_FURNACE_MENU.get(), MasonryFurnaceScreen::new);

        MenuScreens.register(EPMenuTypes.ADOBE_ALLOY_FURNACE_MENU.get(), AdobeAlloyFurnaceScreen::new);
        MenuScreens.register(EPMenuTypes.SUPER_ALLOY_FURNACE_MENU.get(), SuperAlloyFurnaceScreen::new);
        MenuScreens.register(EPMenuTypes.SOUL_ALLOY_FURNACE_MENU.get(), SoulAlloyScreen::new);

        MenuScreens.register(EPMenuTypes.GEM_POLISHER_MENU.get(), GemPolisherScreen::new);

        MenuScreens.register(EPMenuTypes.PRIMAL_GRINDER_MENU.get(), PrimalGrinderScreen::new);
        MenuScreens.register(EPMenuTypes.MECHANICAL_GRINDER_MENU.get(), MechanicalGrinderScreen::new);

        MenuScreens.register(EPMenuTypes.ALCHEMICAL_DUPLICATOR_MENU.get(), AlchemicalDuplicatorScreen::new);

        MenuScreens.register(EPMenuTypes.LEATHERWORKER_STATION_MENU.get(), LeatherworkerStationScreen::new);
    }

    @SubscribeEvent
    public static void subscribeWoodTypes(FMLClientSetupEvent event){
        Sheets.addWoodType(EPWoodTypes.WALNUT);
        Sheets.addWoodType(EPWoodTypes.APPLE);
        Sheets.addWoodType(EPWoodTypes.ORANGE);
        Sheets.addWoodType(EPWoodTypes.LEMON);
    }
}
