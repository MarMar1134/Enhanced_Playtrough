package net.marmar.enhanced_playthrough.util.tab;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
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
            event.getEntries().putAfter(Items.NETHERITE_AXE.getDefaultInstance(), EPItems.WOODEN_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(EPItems.WOODEN_DAGGER.get().getDefaultInstance(), EPItems.STONE_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(EPItems.STONE_DAGGER.get().getDefaultInstance(), EPItems.IRON_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(EPItems.IRON_DAGGER.get().getDefaultInstance(), EPItems.GOLDEN_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(EPItems.GOLDEN_DAGGER.get().getDefaultInstance(), EPItems.DIAMOND_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(EPItems.DIAMOND_DAGGER.get().getDefaultInstance(), EPItems.NETHERITE_DAGGER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)){
            event.getEntries().putAfter(Items.STONE_HOE.getDefaultInstance(), EPItems.STONE_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.IRON_HOE.getDefaultInstance(), EPItems.IRON_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.GOLDEN_HOE.getDefaultInstance(), EPItems.GOLDEN_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.DIAMOND_HOE.getDefaultInstance(), EPItems.DIAMOND_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.NETHERITE_HOE.getDefaultInstance(), EPItems.NETHERITE_POLISHER.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.FLINT_AND_STEEL.getDefaultInstance(), EPItems.FLINT_AND_BRONZE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(EPItems.FLINT_AND_BRONZE.get().getDefaultInstance(), EPItems.FLINT_AND_COBBLE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)){
            event.getEntries().putAfter(Items.PILLAGER_SPAWN_EGG.getDefaultInstance(), EPItems.BANDIT_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.ZOMBIE_SPAWN_EGG.getDefaultInstance(), EPItems.ZOMBIE_KNIGHT_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.SKELETON_SPAWN_EGG.getDefaultInstance(), EPItems.SKELETON_BOWMASTER_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WOLF_SPAWN_EGG.getDefaultInstance(), EPItems.WERELLAGER_SPAWN_EGG.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)){
            event.getEntries().putAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE.getDefaultInstance(), EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
