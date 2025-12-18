package net.marmar.enhanced_playthrough.item.custom.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class EPFoodProperties {
    //Others
    public static final FoodProperties MATE = new FoodProperties.Builder()
            .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200,1), 0.5f)
            .nutrition(4).saturationMod(0.6f)
            .alwaysEat().build();
    public static final FoodProperties RAW_ROTTEN_STEW = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 2), 1f)
            .nutrition(6).saturationMod(1.2f)
            .alwaysEat().build();
    public static final FoodProperties ROTTEN_STEW = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200, 2), 1f)
            .nutrition(6).saturationMod(1.2f)
            .alwaysEat().build();

    //Fruit
    public static final FoodProperties ORANGE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties LEMON = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties LIME = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.2f).build();
    public static final FoodProperties GREEN_APPLE = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.4f).build();
    public static final FoodProperties PEELED_WALNUT = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.4f).build();

    //Wild crops
    public static final FoodProperties WILD_TOMATO = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 1f)
            .nutrition(4).saturationMod(0.3f)
            .build();
    public static final FoodProperties WILD_CORN = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 1f)
            .nutrition(3).saturationMod(0.2f)
            .build();

    //Crops
    public static final FoodProperties RICE = new FoodProperties.Builder()
            .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.2f)
            .nutrition(1).saturationMod(0.1f)
            .build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1f).build();
    public static final FoodProperties ZAPALLO = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties EGGPLANT = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();

    //Cooked crops
    public static final FoodProperties COOKED_ZAPALLO = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_EGGPLANT = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties COOKED_CORN = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties RICE_BOWL = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.5f).build();

    //Rotten crops
    public static final FoodProperties ROTTEN_CARROT = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 1f)
            .nutrition(1).saturationMod(0.3f)
            .alwaysEat().build();
    public static final FoodProperties ROTTEN_TOMATO = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 1f)
            .nutrition(3).saturationMod(0.2f)
            .alwaysEat().build();
    public static final FoodProperties ROTTEN_CORN = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 1f)
            .nutrition(1).saturationMod(0.3f)
            .alwaysEat().build();
    public static final FoodProperties ROTTEN_ZAPALLO = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 1f)
            .nutrition(1).saturationMod(0.1f)
            .alwaysEat().build();
    public static final FoodProperties ROTTEN_EGGPLANT = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 1f)
            .nutrition(1).saturationMod(0.1f)
            .alwaysEat().build();
}
