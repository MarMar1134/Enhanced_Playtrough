package net.marmar.enhanced_playthrough.item.custom.food;

import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class StewItem extends Item {
    public StewItem(Properties pProperties) {
        super(pProperties.stacksTo(1).defaultDurability(5));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player) entity : null;

        if (player instanceof ServerPlayer){
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.hurtAndBreak(1, entity, (entity1 -> entity1.broadcastBreakEvent(entity1.getUsedItemHand())));

                if (pStack.is(EPItems.RAW_ROTTEN_STEW.get())){
                    entity.addEffect(new MobEffectInstance(MobEffects.POISON, 150, 2));
                } else if (pStack.is(EPItems.ROTTEN_STEW.get())) {
                    entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200));
                }
            }
        }

        if (pStack.getDamageValue() == 0){
            pStack.shrink(1);
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (pStack.isEmpty()) {
                return new ItemStack(Items.BOWL);
            }
        }

        entity.gameEvent(GameEvent.EAT);

        return pStack;
    }
}
