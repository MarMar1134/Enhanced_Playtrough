package net.marmar.enhanced_playthrough;

import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.ModBlockEntities;
import net.marmar.enhanced_playthrough.block.wood.ModWoodTypes;
import net.marmar.enhanced_playthrough.Util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.entity.ModEntities;
import net.marmar.enhanced_playthrough.entity.model.ModBoatRenderer;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.marmar.enhanced_playthrough.menu.grinder.screen.MechanicalGrinderScreen;
import net.marmar.enhanced_playthrough.menu.grinder.screen.PrimalGrinderScreen;
import net.marmar.enhanced_playthrough.Util.ModTabs;
import net.marmar.enhanced_playthrough.data.loot.ModLootModifiers;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.screen.AdobeAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.screen.SoulAlloyScreen;
import net.marmar.enhanced_playthrough.menu.alloyfurnace.screen.SuperAlloyFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.basicfurnace.screen.AdobeFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.basicfurnace.screen.SoulFurnaceScreen;
import net.marmar.enhanced_playthrough.menu.gempolisher.screen.GemPolisherScreen;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.menu.ModMenuTypes;
import net.marmar.enhanced_playthrough.Util.sound.ModSounds;
import net.marmar.enhanced_playthrough.entity.villager.ModVillagers;
import net.marmar.enhanced_playthrough.worldgen.feature.ModFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnhancedPlaythrough.MOD_ID)
public class EnhancedPlaythrough
{
    public static final String MOD_ID = "enhanced_playthrough";

    public EnhancedPlaythrough(){

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.register(modEventBus);

        ModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModEnchantments.register(modEventBus);

        ModBlocks.Register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModEntities.register(modEventBus);

        ModFeatures.register(modEventBus);

    //Register for creative tabs
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::AddCreative);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =  Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            //Menus
            MenuScreens.register(ModMenuTypes.ADOBE_FURNACE_MENU.get(), AdobeFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.SOUL_FURNACE_MENU.get(), SoulFurnaceScreen::new);

            MenuScreens.register(ModMenuTypes.ADOBE_ALLOYING_FURNACE_MENU.get(), AdobeAlloyFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), SuperAlloyFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.SOUL_ALLOY_FURNACE_MENU.get(), SoulAlloyScreen::new);

            MenuScreens.register(ModMenuTypes.GEM_POLISHER_MENU.get(), GemPolisherScreen::new);

            MenuScreens.register(ModMenuTypes.PRIMAL_GRINDER_MENU.get(), PrimalGrinderScreen::new);
            MenuScreens.register(ModMenuTypes.MECHANICAL_GRINDER_MENU.get(), MechanicalGrinderScreen::new);

            //Entities
            EntityRenderers.register(ModEntities.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));

            //Wood types
            Sheets.addWoodType(ModWoodTypes.WALNUT);
            Sheets.addWoodType(ModWoodTypes.APPLE);
            Sheets.addWoodType(ModWoodTypes.ORANGE);
            Sheets.addWoodType(ModWoodTypes.LEMON);
        }
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event){
    }
}
