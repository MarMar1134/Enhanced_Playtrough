package net.marmar.enhanced_playthrough.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PolisherItem extends TieredItem implements IForgeItem, Vanishable {
    private final Tier tier;
    private final float attackAttribute;
    private final float speedAttribute;
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public PolisherItem(Tier pTier, Properties pProperties) {
        super(pTier,pProperties);

        this.tier = pTier;

        this.speedAttribute = (pTier.getSpeed() / 2) - 1f;
        this.attackAttribute = (pTier.getAttackDamageBonus() / 2) -1f;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackAttribute, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", this.speedAttribute, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("desc.enhanced_playthrough.polisher_item").withStyle(ChatFormatting.BLUE));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public @NotNull Item asItem() {
        return super.asItem();
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return super.isDamaged(stack);
    }

    public float getAttackAttribute() {
        return attackAttribute;
    }

    public float getSpeedAttribute() {
        return speedAttribute;
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    public Tier getTier(){
        return this.tier;
    }
}