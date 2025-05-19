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
            event.getEntries().putAfter(Items.WOODEN_SWORD.getDefaultInstance(), ModItems.WOODEN_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.STONE_SWORD.getDefaultInstance(), ModItems.STONE_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.IRON_SWORD.getDefaultInstance(), ModItems.IRON_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.GOLDEN_SWORD.getDefaultInstance(), ModItems.GOLDEN_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.DIAMOND_SWORD.getDefaultInstance(), ModItems.DIAMOND_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.NETHERITE_SWORD.getDefaultInstance(), ModItems.NETHERITE_DAGGER.get().getDefaultInstance(),
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
    }
}
