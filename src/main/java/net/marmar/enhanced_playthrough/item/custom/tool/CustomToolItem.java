package net.marmar.enhanced_playthrough.item.custom.tool;

import net.marmar.enhanced_playthrough.item.custom.weapon.DaggerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomToolItem {
    protected interface TieredHandleItem {
        HandleTier getHandleTier();
    }

    public static class Sword extends SwordItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Sword(Tier pTier, HandleTier pHandleTier, Properties pProperties){
            this(pTier, pHandleTier, 3, -2.4f, pProperties);
        }

        public Sword(Tier pTier, HandleTier pHandleTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier,
                    (int) (pAttackDamageModifier * pHandleTier.getAttackDamageMultiplier()),
                    pAttackSpeedModifier < 0
                            ? pAttackSpeedModifier + (-pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier())
                            : pAttackSpeedModifier + (pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier()),
                    pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));

            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }

    public static class Dagger extends DaggerItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Dagger(Tier pTier, HandleTier pHandleTier, int pAttackDamageModifier, float pBaseBleedProbability, Properties pProperties){
            this(pTier, pHandleTier, pAttackDamageModifier, -1f, pBaseBleedProbability, pProperties);
        }

        public Dagger(Tier pTier, HandleTier pHandleTier, int pAttackDamageModifier, float pAttackSpeedModifier, float pBaseBleedProbability, Properties pProperties) {
            super(pTier,
                    (int) (pAttackDamageModifier * pHandleTier.getAttackDamageMultiplier()),
                    pAttackSpeedModifier < 0
                            ? pAttackSpeedModifier + (-pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier())
                            : pAttackSpeedModifier + (pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier()),
                    pBaseBleedProbability,
                    pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));

            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }
    public static class Pickaxe extends PickaxeItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Pickaxe(Tier pTier, HandleTier pHandleTier, Properties pProperties){
            this(pTier, pHandleTier, 1, -2.8f, pProperties);
        }

        public Pickaxe(Tier pTier, HandleTier pHandleTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier,
                    (int) (pAttackDamageModifier * pHandleTier.getAttackDamageMultiplier()),
                    pAttackSpeedModifier < 0
                            ? pAttackSpeedModifier + (-pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier())
                            : pAttackSpeedModifier + (pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier()),
                    pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));

            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }
    public static class Axe extends AxeItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Axe(Tier pTier, HandleTier pHandleTier, float pAttackDamageModifier, Properties pProperties){
            this(pTier, pHandleTier, pAttackDamageModifier, -3.0f, pProperties);
        }

        public Axe(Tier pTier, HandleTier pHandleTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier,
                    (int) (pAttackDamageModifier * pHandleTier.getAttackDamageMultiplier()),
                    pAttackSpeedModifier < 0
                            ? pAttackSpeedModifier + (-pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier())
                            : pAttackSpeedModifier + (pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier()),
                    pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));

            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }
    public static class Shovel extends ShovelItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Shovel(Tier pTier, HandleTier pHandleTier, Properties pProperties){
            this(pTier, pHandleTier, 1.5f, -3.0f, pProperties);
        }

        public Shovel(Tier pTier, HandleTier pHandleTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier,
                    (int) (pAttackDamageModifier * pHandleTier.getAttackDamageMultiplier()),
                    pAttackSpeedModifier < 0
                            ? pAttackSpeedModifier + (-pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier())
                            : pAttackSpeedModifier + (pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier()),
                    pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));

            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }
    public static class Hoe extends HoeItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Hoe(Tier pTier, HandleTier pHandleTier, int pAttackDamageModifier, Properties pProperties){
            this(pTier, pHandleTier, pAttackDamageModifier, -3.0f, pProperties);
        }

        public Hoe(Tier pTier, HandleTier pHandleTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier,
                    (int) (pAttackDamageModifier * pHandleTier.getAttackDamageMultiplier()),
                    pAttackSpeedModifier < 0
                            ? pAttackSpeedModifier + (-pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier())
                            : pAttackSpeedModifier + (pAttackSpeedModifier * pHandleTier.getAttackSpeedMultiplier()),
                    pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));

            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }
    public static class Polisher extends PolisherItem implements TieredHandleItem {
        private final HandleTier handleTier;

        public Polisher(Tier pTier, HandleTier pHandleTier, Properties pProperties) {
            super(pTier, pProperties.defaultDurability((int) (pTier.getUses() * pHandleTier.getDurabilityMultiplier())));
            this.handleTier = pHandleTier;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            if (this.handleTier != HandleTier.BASE)
                pTooltipComponents.add(this.handleTier.getItemDesc());

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public HandleTier getHandleTier() {
            return this.handleTier;
        }
    }
}
