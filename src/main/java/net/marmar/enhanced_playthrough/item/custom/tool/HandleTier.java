package net.marmar.enhanced_playthrough.item.custom.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/**
 * This enum allows the devs to expand toolItems without making whole new tiers. The durabilityMultiplier has to be static because tool durability is defined on the
 * constructor, in contrast to attackDamage or attackSpeed, which are defined as attributes.
 * With a HandleTier, you can modify the speed, attack damage and durability points of a tool.
 */
public enum HandleTier {
    BASE("base", 1.0f, 1.0f, 0f, 0,
            Component.literal("")),
    REINFORCED("reinforced",1.1f, 1.0f, 0f, 0,
            Component.translatable("desc.enhanced_playthrough.reinforced_handle").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC)),
    ALUMINUM("aluminum", 1.2f, 1.0f, 0.1f, 1,
            Component.translatable("desc.enhanced_playthrough.aluminum_handle").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC)),
    PURPLE_GOLD("purple_gold", 0.9f, 1.0f, 0.1f, 2,
            Component.translatable("desc.enhanced_playthrough.purple_gold_handle").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

    private final String literal;
    private final float durabilityMultiplier;
    private final float attackDamageMultiplier;
    private final float attackSpeedMultiplier;
    private final int destroySpeedBonus;
    private final Component itemDesc;

    HandleTier(String pLiteral, float pDurabilityMultiplier, float pAttackDamageMultiplier, float pAttackSpeedMultiplier, int pDestroySpeedBonus, MutableComponent pItemDesc){
        this.literal = pLiteral;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.attackDamageMultiplier = pAttackDamageMultiplier;
        this.attackSpeedMultiplier = pAttackSpeedMultiplier;
        this.destroySpeedBonus = pDestroySpeedBonus;
        this.itemDesc = pItemDesc;
    }

    public String getLiteral() {
        return this.literal;
    }

    public float getDurabilityMultiplier() {
        return this.durabilityMultiplier;
    }

    public float getAttackDamageMultiplier() {
        return this.attackDamageMultiplier;
    }

    public float getAttackSpeedMultiplier() {
        return this.attackSpeedMultiplier;
    }

    public int getDestroySpeedBonus() {
        return this.destroySpeedBonus;
    }

    public Component getItemDesc() {
        return this.itemDesc;
    }
}
