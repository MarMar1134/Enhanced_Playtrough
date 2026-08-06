package net.marmar.enhanced_playthrough.util.trigger.weaponkill;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class WeaponKillUtils {
    public static int getKills(ServerPlayer pPlayer, EntityType<?> pTarget, ItemStack pWeapon){
        ResourceLocation weaponId = ForgeRegistries.ITEMS.getKey(pWeapon.getItem());
        ResourceLocation targetId = ForgeRegistries.ENTITY_TYPES.getKey(pTarget);

        if (weaponId == null || targetId == null){
            EnhancedPlaythrough.LOGGER.warn("Weapon or Entity are null while trying to read weapon kills: {}, {}", weaponId, targetId);
            return 0;
        }

        CompoundTag playerData = pPlayer.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);

        CompoundTag rootTag = playerData.getCompound(EnhancedPlaythrough.MOD_ID);
        CompoundTag weaponKillsTag = rootTag.getCompound("weapon_kills");
        CompoundTag weaponTag = weaponKillsTag.getCompound(weaponId.toString());

        return weaponTag.getInt(targetId.toString());
    }

    public static void addKill(ServerPlayer pPlayer, EntityType<?> pTarget, ItemStack pWeapon){
        int currentKills = WeaponKillUtils.getKills(pPlayer, pTarget, pWeapon);

        ResourceLocation weaponId = ForgeRegistries.ITEMS.getKey(pWeapon.getItem());
        ResourceLocation targetId = ForgeRegistries.ENTITY_TYPES.getKey(pTarget);

        if (weaponId == null || targetId == null){
            EnhancedPlaythrough.LOGGER.warn("Weapon or Entity are null while trying to insert new weapon kill: {}, {}", weaponId, targetId);
            return;
        }

        //We get the tags first
        CompoundTag playerData = pPlayer.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);

        CompoundTag rootTag = playerData.getCompound(EnhancedPlaythrough.MOD_ID);
        CompoundTag weaponKillsTag = rootTag.getCompound("weapon_kills");
        CompoundTag weaponTag = weaponKillsTag.getCompound(weaponId.toString());

        //We add the new kill
        weaponTag.putInt(targetId.toString(), currentKills + 1);

        //We reinsert all the tags in order
        weaponKillsTag.put(weaponId.toString(), weaponTag);
        rootTag.put("weapon_kills", weaponKillsTag);
        playerData.put(EnhancedPlaythrough.MOD_ID, rootTag);

        pPlayer.getPersistentData().put(Player.PERSISTED_NBT_TAG, playerData);
    }
}
