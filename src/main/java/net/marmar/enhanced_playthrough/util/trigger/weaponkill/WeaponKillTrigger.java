package net.marmar.enhanced_playthrough.util.trigger.weaponkill;

import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("removal")
public class WeaponKillTrigger extends SimpleCriterionTrigger<WeaponKillTrigger.TriggerInstance> {
    public static final ResourceLocation ID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "killed_with_weapon");

    @Override
    public ResourceLocation getId() {
        return WeaponKillTrigger.ID;
    }

    @Override
    protected WeaponKillTrigger.TriggerInstance createInstance(JsonObject pJson, ContextAwarePredicate pPlayerPredicate, DeserializationContext pContext) {
        EntityPredicate entity = EntityPredicate.fromJson(pJson.get("entity"));

        ItemPredicate weapon = ItemPredicate.fromJson(pJson.get("weapon"));

        MinMaxBounds.Ints requiredKills = MinMaxBounds.Ints.fromJson(pJson.get("required_kills"));

        return new WeaponKillTrigger.TriggerInstance(pPlayerPredicate, entity, weapon, requiredKills);
    }

    public void trigger(ServerPlayer pPlayer, LivingEntity pTarget, ItemStack pWeapon) {
        this.trigger(pPlayer, instance ->
                instance.matches(pPlayer, pTarget, pWeapon));
    }

    public static WeaponKillTrigger.TriggerInstance killedWithWeapon(EntityPredicate.Builder pEntity, ItemPredicate.Builder pWeapon, MinMaxBounds.Ints pRequiredKills){
        return new WeaponKillTrigger.TriggerInstance(ContextAwarePredicate.ANY, pEntity.build(), pWeapon.build(), pRequiredKills);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final EntityPredicate entity;
        private final ItemPredicate weapon;
        private final MinMaxBounds.Ints requiredKills;

        public TriggerInstance(ContextAwarePredicate pPlayer, EntityPredicate pEntity, ItemPredicate pWeapon, MinMaxBounds.Ints pRequiredKills) {
            super(WeaponKillTrigger.ID, pPlayer);

            this.entity = pEntity;
            this.weapon = pWeapon;
            this.requiredKills = pRequiredKills;
        }

        public boolean matches(ServerPlayer pPlayer, LivingEntity pTarget, ItemStack pWeapon) {

            if (!this.weapon.matches(pWeapon))
                return false;

            if (!entity.matches(pPlayer, pTarget))
                return false;

            return this.requiredKills.matches(WeaponKillUtils.getKills(pPlayer, pTarget.getType(), pWeapon));
        }

        @Override
        public JsonObject serializeToJson(SerializationContext pConditions) {
            JsonObject advancement = super.serializeToJson(pConditions);

            advancement.add("entity", this.entity.serializeToJson());
            advancement.add("weapon", this.weapon.serializeToJson());
            advancement.add("required_kills", this.requiredKills.serializeToJson());

            return advancement;
        }
    }
}
