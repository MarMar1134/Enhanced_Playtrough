package net.marmar.enhanced_playthrough.item.custom.tool;

import net.marmar.enhanced_playthrough.item.custom.weapon.DaggerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomToolItem {
    public static class Sword extends SwordItem {
        private final StickTier stickTier;
        public Sword(Tier pTier, StickTier pStickTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, (int) (pAttackDamageModifier + pStickTier.getAttackDamageMultiplier()), pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        public Sword(Tier pTier, StickTier pStickTier, Properties pProperties){
            this(pTier, pStickTier, 3, -2.4f, pProperties);
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    public static class Dagger extends DaggerItem {
        private final StickTier stickTier;
        public Dagger(Tier pTier, StickTier pStickTier, int pAttackDamageModifier, float pBaseBleedProbability, Properties pProperties) {
            super(pTier, (int) (pAttackDamageModifier + pStickTier.getAttackDamageMultiplier()), pBaseBleedProbability, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Pickaxe extends PickaxeItem {
        private final StickTier stickTier;
        public Pickaxe(Tier pTier, StickTier pStickTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, (int) (pAttackDamageModifier + pStickTier.getAttackDamageMultiplier()), pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        public Pickaxe(Tier pTier, StickTier pStickTier, Properties pProperties){
            this(pTier, pStickTier, 1, -2.8f, pProperties);
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Axe extends AxeItem {
        private final StickTier stickTier;
        public Axe(Tier pTier, StickTier pStickTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, (int) (pAttackDamageModifier + pStickTier.getAttackDamageMultiplier()), pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        public Axe(Tier pTier, StickTier pStickTier, float pAttackDamageModifier, Properties pProperties){
            this(pTier, pStickTier, pAttackDamageModifier, -3.0f, pProperties);
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Shovel extends ShovelItem {
        private final StickTier stickTier;
        public Shovel(Tier pTier, StickTier pStickTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, (int) (pAttackDamageModifier + pStickTier.getAttackDamageMultiplier()), pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        public Shovel(Tier pTier, StickTier pStickTier, Properties pProperties){
            this(pTier, pStickTier, 1.5f, -3.0f, pProperties);
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Hoe extends HoeItem {
        private final StickTier stickTier;
        public Hoe(Tier pTier, StickTier pStickTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, (int) (pAttackDamageModifier + pStickTier.getAttackDamageMultiplier()), pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        public Hoe(Tier pTier, StickTier pStickTier, int pAttackDamageModifier, Properties pProperties){
            this(pTier, pStickTier, pAttackDamageModifier, -3.0f, pProperties);
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Polisher extends PolisherItem {
        private final StickTier stickTier;
        public Polisher(Tier pTier, StickTier pStickTier, Properties pProperties) {
            super(pTier, pProperties.defaultDurability((int) (pTier.getUses() * pStickTier.getDurabilityMultiplier())));
            this.stickTier = pStickTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.stickTier != StickTier.BASE)
                pTooltipComponents.add(this.stickTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
}
