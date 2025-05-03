package net.marmar.enhanced_playthrough.data.language;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.data.advancement.AdvancementCategory;
import net.marmar.enhanced_playthrough.entity.boat.ModBoatEntity;
import net.marmar.enhanced_playthrough.entity.boat.ModChestBoatEntity;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public abstract class AbstractModLanguageProvider extends LanguageProvider {
    public AbstractModLanguageProvider(PackOutput output, String locale) {
        super(output, EnhancedPlaythrough.MOD_ID, locale);
    }

    protected void addDeathMessages(String damageType, String message, String killByPlayer){
        this.add("death.attack." + damageType, "%1$s " + message);
        this.add("death.attack." + damageType + ".player", "%1$s " + message + " %1$s");
    }

    private void addAdvancementTitle(AdvancementCategory advancementCategory, String advancementName, String translation){
        this.add("advancement." + EnhancedPlaythrough.MOD_ID + ".title." + advancementCategory.getCategory() + "." + advancementName, translation);
    }

    private void addAdvancementDesc(AdvancementCategory advancementCategory, String advancementName, String translation){
        this.add("advancement." + EnhancedPlaythrough.MOD_ID + ".desc." + advancementCategory.getCategory() + "." + advancementName, translation);
    }

    protected void addSurvivalAdvancement(String pAdvancementName, String pAdvancementTitle, String pAdvancementDesc){
        addAdvancementTitle(AdvancementCategory.SURVIVAL, pAdvancementName, pAdvancementTitle);
        addAdvancementDesc(AdvancementCategory.SURVIVAL, pAdvancementName, pAdvancementDesc);
    }

    protected void addGemAdvancement(String pAdvancementName, String pAdvancementTitle, String pAdvancementDesc){
        addAdvancementTitle(AdvancementCategory.GEMS, pAdvancementName, pAdvancementTitle);
        addAdvancementDesc(AdvancementCategory.GEMS, pAdvancementName, pAdvancementDesc);
    }

    protected void addDescription(String descriptionName, String translation){
        this.add("desc." + EnhancedPlaythrough.MOD_ID + "." + descriptionName, translation);
    }

    protected void addSoundDescription(String sound_name, String translation){
        this.add("sound." + EnhancedPlaythrough.MOD_ID + "." + sound_name, translation);
    }

    protected void addJeiCategory(String category, String translation){
        this.add("jei." + EnhancedPlaythrough.MOD_ID + "." + category, translation);
    }

    protected void addJadeConfigTranslation(String block, String translation){
        this.add("config.jade.plugin_" + EnhancedPlaythrough.MOD_ID + "." + block, translation);
    }

    protected void addCreativeTab(String tabName, String translation){
        this.add("creativetab." + EnhancedPlaythrough.MOD_ID + "." + tabName, translation);
    }

    protected void addSmithingTitles(String pAppliesTo, String pIngredients){
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + ".applies_to_title", pAppliesTo);
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + ".ingredients_title", pIngredients);
    }

    protected void addSmithingTranslations(RegistryObject<Item> pItem, String pItemTranslation, String smithingMaterial, String title, String appliesTo, String ingredients, String baseSlotDesc, String addSlotDesc){
        addItem(pItem, pItemTranslation);
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + "." + smithingMaterial + ".title", title);
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + "." + smithingMaterial + ".applies_to", appliesTo);
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + "." + smithingMaterial + ".ingredients", ingredients);
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + "." + smithingMaterial + ".base_slot_description", baseSlotDesc);
        this.add("smithing." + EnhancedPlaythrough.MOD_ID + "." + smithingMaterial + ".additions_slot_description", addSlotDesc);
    }

    protected void addSign(RegistryObject<Item> sign, String signTranslation){
        this.add("block." + EnhancedPlaythrough.MOD_ID + "." + sign.get(), signTranslation);
    }

    protected void addHangingSign(RegistryObject<Item> hangingSign, String hangingSignTranslation){
        this.add("block." + EnhancedPlaythrough.MOD_ID + "." + hangingSign.get(), hangingSignTranslation);
    }

    protected void addBoatEntity(RegistryObject<EntityType<ModBoatEntity>> entity, String name){
        this.add(entity.get(), name);
    }
    protected void addChestBoatEntity(RegistryObject<EntityType<ModChestBoatEntity>> entity, String name){
        this.add(entity.get(), name);
    }

    private void addPotion(String potionName, String potionType, String translation){
        this.add("item.minecraft." + potionType + ".effect." + potionName, translation);
    }

    protected void addAcid(String potionName, String translation){
        addPotion(potionName, "potion", translation);
        addPotion(potionName, "splash_potion", translation);
        addPotion(potionName, "lingering_potion", translation);
    }

    protected void addGuiElements(String blockGui, String translation){
        this.add("gui." + EnhancedPlaythrough.MOD_ID + "." + blockGui + ".text", translation);
    }

    protected void addEnchantmentDesc(String enchantmentName, String description){
        this.add("enchantment." + EnhancedPlaythrough.MOD_ID + "." + enchantmentName + ".desc", description);
    }

    protected void addVillagerProfession(String profession, String translation){
        this.add("entity.minecraft.villager." + EnhancedPlaythrough.MOD_ID + "." + profession, translation);
    }

    protected void addVillagerProfession(String profession){
        this.add("entity.minecraft.villager." + EnhancedPlaythrough.MOD_ID + "." + profession, profession);
    }
}
