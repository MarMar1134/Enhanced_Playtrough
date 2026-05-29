package net.marmar.enhanced_playthrough.item.custom.weapon;

import net.marmar.enhanced_playthrough.util.effect.EPMobEffects;
import net.marmar.enhanced_playthrough.util.enchantment.BloodyBladeEnchantment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DaggerItem extends WeaponItem {
    private final float baseBleedProbability;

    protected DaggerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, float pBaseBleedProbability, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, -1F, pProperties);
        this.baseBleedProbability = pBaseBleedProbability;
    }

    public boolean hasBloodyBladeEnchantment(ItemStack pStack){
        AtomicBoolean hasBleedingEnchant = new AtomicBoolean(false);

        pStack.getAllEnchantments().forEach((enchantment, integer) ->
                hasBleedingEnchant.set(enchantment instanceof BloodyBladeEnchantment));

        return hasBleedingEnchant.get();
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        float bleedProbability = this.baseBleedProbability * pAttacker.getRandom().nextFloat();

        if (bleedProbability < 0.025f && !hasBloodyBladeEnchantment(pStack)){
            pTarget.addEffect(new MobEffectInstance(EPMobEffects.BLEEDING.get(), 200, 0, true, true));
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        int baseProbability = (int) (this.baseBleedProbability * 100);
        String translatedProbability = switch (baseProbability) {
            case 10 -> "10%";
            case 25 -> "25%";
            case 30 -> "30%";
            default -> "0%";
        };

        pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.dagger_bleed").withStyle(ChatFormatting.DARK_GREEN)
                .append(translatedProbability).withStyle(ChatFormatting.DARK_GREEN));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
