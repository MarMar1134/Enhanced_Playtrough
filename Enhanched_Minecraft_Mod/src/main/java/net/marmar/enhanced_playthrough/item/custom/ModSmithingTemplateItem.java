package net.marmar.enhanced_playthrough.item.custom;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    //Vanilla features
    private static final ResourceLocation EMPTY_SLOT_HELMET;
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE;
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS;
    private static final ResourceLocation EMPTY_SLOT_BOOTS;
    private static final ResourceLocation EMPTY_SLOT_HOE;
    private static final ResourceLocation EMPTY_SLOT_AXE;
    private static final ResourceLocation EMPTY_SLOT_SWORD;
    private static final ResourceLocation EMPTY_SLOT_SHOVEL;
    private static final ResourceLocation EMPTY_SLOT_PICKAXE;
    private static final ResourceLocation EMPTY_SLOT_INGOT;

    //Styles
    private static final ChatFormatting TITLES;
    private static final ChatFormatting DESCS;

    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredient, Component pUpgradeDesc, Component pBaseSlotDesc, Component AddSlotDesc, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons) {
        super(pAppliesTo, pIngredient, pUpgradeDesc, pBaseSlotDesc, AddSlotDesc, baseSlotEmptyIcons, additionalSlotEmptyIcons);
    }

    private static List<ResourceLocation> createSmithingUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createSmithingUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    public static ModSmithingTemplateItem CreateSmithingUpgradeTemplate(String material){
        Component SMITHING_UPGRADE = Component.translatable("smithing." + EnhancedPlaythrough.MOD_ID + "." + material + ".title").withStyle(TITLES);
        Component APPLIES_TO = Component.translatable("smithing." + EnhancedPlaythrough.MOD_ID + "." + material + ".applies_to").withStyle(DESCS);
        Component INGREDIENTS = Component.translatable("smithing." + EnhancedPlaythrough.MOD_ID + "." + material + ".ingredients").withStyle(DESCS);
        Component BASE_SLOT_DESCRIPTION = Component.translatable("smithing." + EnhancedPlaythrough.MOD_ID + "." + material + ".base_slot_description");
        Component ADDITIONS_SLOT_DESCRIPTION = Component.translatable("smithing." + EnhancedPlaythrough.MOD_ID + "." + material + ".additions_slot_description");
        return new ModSmithingTemplateItem(APPLIES_TO, INGREDIENTS, SMITHING_UPGRADE, BASE_SLOT_DESCRIPTION, ADDITIONS_SLOT_DESCRIPTION, createSmithingUpgradeIconList(), createSmithingUpgradeMaterialList());
    }

    static {
        TITLES = ChatFormatting.GRAY;
        DESCS = ChatFormatting.BLUE;

        //Vanilla features
        EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
        EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
        EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
        EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
        EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
        EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    }
}
