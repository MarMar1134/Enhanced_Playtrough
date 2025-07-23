package net.marmar.enhanced_playthrough.data.advancement;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public interface ICustomAdvancementDisplays {
    ResourceLocation categoryBackGround();

    String categoryName();

    private Component advancementTitle(String advancementName){
        return Component.translatable("advancement." + EnhancedPlaythrough.MOD_ID + ".title." + categoryName() + "." + advancementName);
    }

    private Component advancementDesc(String advancementName){
        return Component.translatable("advancement." + EnhancedPlaythrough.MOD_ID + ".desc." + categoryName() + "." + advancementName);
    }

    private DisplayInfo baseDisplayInfo(ItemLike pIcon, Component title, Component desc, FrameType frameType){
        return new DisplayInfo(new ItemStack(pIcon.asItem()), title, desc, categoryBackGround(), frameType, true, true, false);
    }

    default DisplayInfo rootDisplayInfo(ItemLike pIcon, String advancementName){
        return new DisplayInfo(new ItemStack(pIcon.asItem()), advancementTitle(advancementName), advancementDesc(advancementName), categoryBackGround(), FrameType.TASK, false, false, false);
    }

    default DisplayInfo challengeDisplayInfo(ItemLike pIcon, String advancementName){
        return baseDisplayInfo(pIcon, advancementTitle(advancementName), advancementDesc(advancementName), FrameType.CHALLENGE);
    }

    default DisplayInfo taskDisplayInfo(ItemLike pIcon, String advancementName){
        return baseDisplayInfo(pIcon, advancementTitle(advancementName), advancementDesc(advancementName), FrameType.TASK);
    }

    default ResourceLocation advancementReward(String pAdvancementName){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, "advancements/" + pAdvancementName);
    }

    default InventoryChangeTrigger.TriggerInstance hasItems(ItemLike... pItems){
        return InventoryChangeTrigger.TriggerInstance.hasItems(pItems);
    }

    default InventoryChangeTrigger.TriggerInstance hasItems(ItemPredicate... pItems){
        return InventoryChangeTrigger.TriggerInstance.hasItems(pItems);
    }
}
