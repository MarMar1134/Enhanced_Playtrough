package net.marmar.enhanced_playthrough.util.effect;

import net.marmar.enhanced_playthrough.util.damage.EPDamageSources;
import net.marmar.enhanced_playthrough.util.particle.EPParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.phys.Vec3;

public class BleedingEffect extends MobEffect {
    protected BleedingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int pAmplifier) {
        if (entity instanceof AbstractSkeleton){
            return;
        }

        if (entity.tickCount % 20 == 0){
            applyEffectAccordingToAmplifier(entity, pAmplifier);
        }

        addParticles(entity);
    }

    private void applyEffectAccordingToAmplifier(LivingEntity pEntity, int pAmplifier){
        switch (pAmplifier){
            case 1:
                pEntity.hurt(new EPDamageSources(pEntity.level().registryAccess()).bleed(), 2F);
                break;
            case 2:
                pEntity.hurt(new EPDamageSources(pEntity.level().registryAccess()).bleed(), 3F);
                break;
            default:
                pEntity.hurt(new EPDamageSources(pEntity.level().registryAccess()).bleed(), 1.5F * pAmplifier);
        }
    }



    //Credit goes to iron431 for this method.
    // Source: https://github.com/iron431/irons-spells-n-spellbooks/blob/1.20.1/src/main/java/io/redspace/ironsspellbooks/effect/AbyssalShroudEffect.java#L89
    public void addParticles(LivingEntity pEntity){
        if (pEntity instanceof AbstractSkeleton){
            return;
        }

        Vec3 backwards = pEntity.getForward().scale(.003).reverse().add(0, 0.02, 0);
        var random = pEntity.getRandom();
        for (int i = 0; i < 1; i++) {
            Vec3 motion = new Vec3(
                    random.nextFloat() * 2 - 0.5f,
                    random.nextFloat() * 2 - 0.5f,
                    random.nextFloat() * 2 - 0.5f
            );
            motion = motion.scale(0.04f).add(backwards);
            pEntity.level().addParticle(EPParticleTypes.BLEED_PARTICLE.get(), pEntity.getRandomX(0.4f), pEntity.getRandomY(), pEntity.getRandomZ(0.4f),
                    motion.x, -motion.y, motion.z);
        }
    }
}
