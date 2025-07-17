package net.marmar.enhanced_playthrough.util.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FrostbiteEffect extends MobEffect {
    protected FrostbiteEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int pAmplifier) {
        if (!entity.canFreeze()){
            return;
        }

        applyEffectAccordingToAmplifier(entity, pAmplifier);
    }

    private void applyEffectAccordingToAmplifier(LivingEntity pEntity, int pAmplifier){
        if (pAmplifier == 0) {
            pEntity.setTicksFrozen(200);
        } else {
            pEntity.setTicksFrozen(200 * pAmplifier);
        }
    }
}
