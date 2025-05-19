package net.marmar.enhanced_playthrough.item.custom.weapon;

import net.minecraft.world.item.Tier;

public class DaggerItem extends WeaponItem {
    public DaggerItem(Tier pTier, int pAttackDamageModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, -1F, -1F, pProperties);
    }
}
