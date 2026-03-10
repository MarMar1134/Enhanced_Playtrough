package net.marmar.enhanced_playthrough.util.enchantment;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<Enchantment> FINE_MINING =
            ENCHANTMENTS.register("fine_mining", ()-> new FineMiningEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> ROUGH_MINING =
            ENCHANTMENTS.register("rough_mining", ()-> new RoughMiningEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> POISON_TOUCH =
            ENCHANTMENTS.register("poison_touch", ()-> new PoisonTouchEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> LIVING_TOUCH =
            ENCHANTMENTS.register("living_touch", ()-> new LivingTouchEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> BLOODY_BLADE =
            ENCHANTMENTS.register("sharp_blade", ()-> new BloodyBladeEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> FROSTBITE =
            ENCHANTMENTS.register("frostbite", ()-> new FrostbiteEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static final RegistryObject<Enchantment> SILVER_BLESSING =
            ENCHANTMENTS.register("silver_blessing", () -> new SilverBlessingEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough enchantments...");
        ENCHANTMENTS.register(eventBus);
    }
}
