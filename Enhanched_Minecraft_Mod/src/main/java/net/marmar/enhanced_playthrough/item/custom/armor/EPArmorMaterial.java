package net.marmar.enhanced_playthrough.item.custom.armor;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum EPArmorMaterial implements ArmorMaterial {
    SILVER("silver", 9, new int[]{2,6,3,2}, 21, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.of(EPItems.SILVER_INGOT.get())),
    BRONZE("bronze", 13, new int[]{1,4,3,2}, 12, SoundEvents.ARMOR_EQUIP_IRON, 0f, 0f,
            () -> Ingredient.of(EPItems.BRONZE_INGOT.get())),
    BRASS("brass", 8, new int[]{1,4,2,1}, 7, SoundEvents.ARMOR_EQUIP_IRON, 0F, 0F,
            () -> Ingredient.of(EPItems.BRASS_INGOT.get())),
    BRONZIUM("bronzium", 16, new int[]{2,6,4,3}, 14, SoundEvents.ARMOR_EQUIP_IRON, 0f, 0f,
            () -> Ingredient.of(EPItems.BRONZIUM_INGOT.get())),
    ROSE_GOLD("rose_gold", 8, new int[]{1,4,3,2}, 16, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0,
            () -> Ingredient.of(EPItems.ROSE_GOLD_INGOT.get())),
    STEEL("steel", 18, new int[]{2,7,5,3}, 16, SoundEvents.ARMOR_EQUIP_IRON, 1f, 0.05f,
            () -> Ingredient.of(EPItems.STEEL_INGOT.get())),
    GREEN_GOLD("green_gold", 13, new int[]{2,5,4,3}, 21, SoundEvents.ARMOR_EQUIP_GOLD, 0.5f, 0,
            () -> Ingredient.of(EPItems.GREEN_GOLD_INGOT.get())),
    BLUE_GOLD("blue_gold", 30, new int[]{3,8,6,3}, 15, SoundEvents.ARMOR_EQUIP_GOLD, 0f, 0,
            () -> Ingredient.of(EPItems.BLUE_GOLD_INGOT.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmenValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY = {11,16,16,13};

    EPArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmenValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmenValue = enchantmenValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmenValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return EnhancedPlaythrough.MOD_ID + ":" + this.name;
    }

    public String getTierName(){
        return  this.name + "_armor";
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
