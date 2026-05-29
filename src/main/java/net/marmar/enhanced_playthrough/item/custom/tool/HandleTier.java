package net.marmar.enhanced_playthrough.item.custom.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/**
 * This enum allows the devs to expand toolItems without making whole new tiers. The durabilityMultiplier has to be static because tool durability is defined on the
 * constructor, in contrast to attackDamage or attackSpeed, which are defined as attributes.
 * Alongside durability, attackDamage can also be modified by this enum.
 */
public enum HandleTier {
    BASE("base", 1.0f, 0f, 0f, Component.literal("")),
    REINFORCED("reinforced",1.1f, 0f, 0f, Component.translatable("desc.enhanced_playthrough.leather_stick_tool")
            .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC)),
    ALUMINUM("aluminum", 1.2f, 0f, 0.5f, Component.translatable("desc.enhanced_playthrough.aluminum_stick_tool")
            .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

    private final String literal;
    private final float durabilityMultiplier;
    private final float attackDamageMultiplier;
    private final float attackSpeedMultiplier;
    private final Component itemDesc;

    HandleTier(String pLiteral, float pDurabilityModifier, float pAttackDamageMultiplier, float pAttackSpeedModifier, MutableComponent pItemDesc){
        this.literal = pLiteral;
        this.durabilityMultiplier = pDurabilityModifier;
        this.attackDamageMultiplier = pAttackDamageMultiplier;
        this.attackSpeedMultiplier = pAttackSpeedModifier;
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
        return attackSpeedMultiplier;
    }

    public Component getItemDesc() {
        return this.itemDesc;
    }
}
