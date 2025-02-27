package net.marmar.enhanced_playthrough.item.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.level.Level;

public class TutorialBookItem extends WrittenBookItem {
    public TutorialBookItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack $$3 = pPlayer.getItemInHand(pHand);
        pPlayer.openItemGui($$3, pHand);
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess($$3, pLevel.isClientSide());
    }
}
