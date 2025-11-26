package net.marmar.enhanced_playthrough;

import net.marmar.enhanced_playthrough.util.effect.EPMobEffects;
import net.marmar.enhanced_playthrough.util.particle.EPParticleTypes;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.block.EPBlockEntities;
import net.marmar.enhanced_playthrough.util.enchantment.EPEnchantments;
import net.marmar.enhanced_playthrough.entity.EPEntityTypes;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.util.tab.EPTabs;
import net.marmar.enhanced_playthrough.data.loottable.modifier.EPLootModifiers;
import net.marmar.enhanced_playthrough.recipe.EPRecipes;
import net.marmar.enhanced_playthrough.menu.EPMenuTypes;
import net.marmar.enhanced_playthrough.entity.villager.EPVillagerProfessions;
import net.marmar.enhanced_playthrough.util.EPSoundEvents;
import net.marmar.enhanced_playthrough.worldgen.feature.EPFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnhancedPlaythrough.MOD_ID)
@SuppressWarnings("removal")
public class EnhancedPlaythrough {
    public static final String MOD_ID = "enhanced_playthrough";

    public EnhancedPlaythrough(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EPLootModifiers.register(modEventBus);

        EPTabs.register(modEventBus);
        EPItems.register(modEventBus);
        EPEnchantments.register(modEventBus);

        EPBlocks.Register(modEventBus);
        EPBlockEntities.register(modEventBus);

        EPSoundEvents.register(modEventBus);

        EPMenuTypes.register(modEventBus);
        EPRecipes.register(modEventBus);

        EPVillagerProfessions.register(modEventBus);

        EPEntityTypes.register(modEventBus);

        EPFeatures.register(modEventBus);

        EPMobEffects.register(modEventBus);
        EPParticleTypes.register(modEventBus);

        //Register
        MinecraftForge.EVENT_BUS.register(this);
    }
}
