package net.marmar.enhanced_playthrough.event;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.trigger.EPCriteriaTriggers;
import net.marmar.enhanced_playthrough.util.trigger.weaponkill.WeaponKillUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedPlaythrough.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EPForgeBusEvents {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event){
        DamageSource source = event.getSource();

        if (!(source.getEntity() instanceof ServerPlayer player))
            return;

        ItemStack weapon = player.getMainHandItem();
        LivingEntity target = event.getEntity();

        if (weapon.is(EPItems.PURPLE_GOLD_IRON_DAGGER.get()) && target.getType().equals(EntityType.VILLAGER)){
            EnhancedPlaythrough.LOGGER.info("Current kills: {}", WeaponKillUtils.getKills(player, target.getType(), weapon));
            WeaponKillUtils.addKill(player, target.getType(), weapon);
        }

        EPCriteriaTriggers.KILLED_WITH_WEAPON.trigger(player, target, weapon);
    }
}
