package net.marmar.enhanced_playthrough.Util.tab;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VanillaTabs {
    @SubscribeEvent
    public static void addItemsToVanilla(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey().equals(CreativeModeTabs.COMBAT)){
            event.getEntries().putAfter(Items.NETHERITE_AXE.getDefaultInstance(), ModItems.WOODEN_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ModItems.WOODEN_DAGGER.get().getDefaultInstance(), ModItems.STONE_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ModItems.STONE_DAGGER.get().getDefaultInstance(), ModItems.IRON_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ModItems.IRON_DAGGER.get().getDefaultInstance(), ModItems.GOLDEN_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ModItems.GOLDEN_DAGGER.get().getDefaultInstance(), ModItems.DIAMOND_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ModItems.DIAMOND_DAGGER.get().getDefaultInstance(), ModItems.NETHERITE_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)){
            event.getEntries().putAfter(Items.STONE_HOE.getDefaultInstance(), ModItems.STONE_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.IRON_HOE.getDefaultInstance(), ModItems.IRON_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.GOLDEN_HOE.getDefaultInstance(), ModItems.GOLDEN_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.DIAMOND_HOE.getDefaultInstance(), ModItems.DIAMOND_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.NETHERITE_HOE.getDefaultInstance(), ModItems.NETHERITE_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)){
            event.getEntries().putAfter(Items.PILLAGER_SPAWN_EGG.getDefaultInstance(), ModItems.BANDIT_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
