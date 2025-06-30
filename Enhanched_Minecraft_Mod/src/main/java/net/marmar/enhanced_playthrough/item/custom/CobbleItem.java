package net.marmar.enhanced_playthrough.item.custom;

import net.marmar.enhanced_playthrough.entity.CobbleProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CobbleItem extends Item {
    private final int cobbleDamage;

    public CobbleItem(Properties pProperties, int cobbleDamage) {
        super(pProperties);
        this.cobbleDamage = cobbleDamage;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);

        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!pLevel.isClientSide) {
            CobbleProjectileEntity cobble = new CobbleProjectileEntity(pLevel, pPlayer, this.cobbleDamage);
            cobble.setItem(itemStack);
            cobble.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(cobble);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        pPlayer.getCooldowns().addCooldown(this, 10);
        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
    }
}
