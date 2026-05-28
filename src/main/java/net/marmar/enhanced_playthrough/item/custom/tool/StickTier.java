package net.marmar.enhanced_playthrough.item.custom.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/**
 * This enum allows the devs to expand toolItems without making whole new tiers. The durabilityMultiplier has to be static because tool durability is defined on the
 * constructor, in contrast to attackDamage or attackSpeed, which are defined as attributes.
 * Alongside durability, attackDamage can also be modified by this enum.
 */
public enum StickTier {
    BASE(1.0f, 0f, Component.literal("")),
    LEATHER(1.1f, 0f, Component.translatable("desc.enhanced_playthrough.leather_stick_tool")
            .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC)),
    ALUMINUM(1.2f, 0f, Component.translatable("desc.enhanced_playthrough.aluminum_stick_tool")
            .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

    private final float durabilityMultiplier;
    private final float attackDamageMultiplier;
    private final Component itemDesc;

    StickTier(float pDurabilityModifier, float pAttackDamageMultiplier, MutableComponent pItemDesc){
        this.durabilityMultiplier = pDurabilityModifier;
        this.attackDamageMultiplier = pAttackDamageMultiplier;
        this.itemDesc = pItemDesc;
    }

    public float getDurabilityMultiplier() {
        return this.durabilityMultiplier;
    }

    public float getAttackDamageMultiplier() {
        return this.attackDamageMultiplier;
    }

    public Component getItemDesc() {
        return this.itemDesc;
    }
}
