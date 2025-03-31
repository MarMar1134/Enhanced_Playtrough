package net.marmar.enhanced_playthrough.datagen.language;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
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

    protected void addAdvancementTitle(String advancementCategory, String advancementName, String translation){
        this.add("advancement." + EnhancedPlaythrough.MOD_ID + ".title." + advancementCategory + "." + advancementName, translation);
    }

    protected void addAdvancementDesc(String advancementCategory, String advancementName, String translation){
        this.add("advancement." + EnhancedPlaythrough.MOD_ID + ".desc." + advancementCategory + "." + advancementName, translation);
    }

    protected void addDescription(String descriptionName, String translation){
        this.add("desc." + EnhancedPlaythrough.MOD_ID + "." + descriptionName, translation);
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

    protected void addSmithingTranslations(String smithingMaterial, String title, String appliesTo, String ingredients, String baseSlotDesc, String addSlotDesc){
        this.add("smithing." + smithingMaterial + ".title", title);
        this.add("smithing." + smithingMaterial + ".applies_to", appliesTo);
        this.add("smithing." + smithingMaterial + ".ingredients", ingredients);
        this.add("smithing." + smithingMaterial + ".base_slot_description", baseSlotDesc);
        this.add("smithing." + smithingMaterial + ".additions_slot_description", addSlotDesc);
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
