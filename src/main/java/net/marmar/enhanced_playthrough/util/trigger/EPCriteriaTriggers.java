package net.marmar.enhanced_playthrough.util.trigger;

import net.marmar.enhanced_playthrough.util.trigger.weaponkill.WeaponKillTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class EPCriteriaTriggers {
    public static WeaponKillTrigger KILLED_WITH_WEAPON;

    public static void register(){
        KILLED_WITH_WEAPON = CriteriaTriggers.register(new WeaponKillTrigger());
    }
}
