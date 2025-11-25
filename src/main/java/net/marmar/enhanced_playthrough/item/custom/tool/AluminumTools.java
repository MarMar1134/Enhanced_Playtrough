package net.marmar.enhanced_playthrough.item.custom.tool;

import net.marmar.enhanced_playthrough.item.custom.weapon.DaggerItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AluminumTools {
    public static class Sword extends SwordItem {
        public Sword(Tier pTier, Properties pProperties) {
            super(pTier, 3, -2.4f, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    public static class Dagger extends DaggerItem {
        public Dagger(Tier pTier, int pAttackDamageModifier, float pBaseBleedProbability, Properties pProperties) {
            super(pTier, pAttackDamageModifier, pBaseBleedProbability, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Pickaxe extends PickaxeItem {
        public Pickaxe(Tier pTier, Properties pProperties) {
            super(pTier, 1, -2.8f, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Axe extends AxeItem {
        public Axe(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Shovel extends ShovelItem {
        public Shovel(Tier pTier, Properties pProperties) {
            super(pTier, 1.5f, -3.0f, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Hoe extends HoeItem {
        public Hoe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
            super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
    public static class Polisher extends PolisherItem {

        public Polisher(Tier pTier, Properties pProperties) {
            super(pTier, pProperties.defaultDurability((int) (pTier.getUses() * 1.2f)));
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.aluminum_tool")
                    .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }
}
