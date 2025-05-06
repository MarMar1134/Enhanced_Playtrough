package net.marmar.enhanced_playthrough;

import net.marmar.enhanced_playthrough.block.ModBlocks;
import net.marmar.enhanced_playthrough.block.ModBlockEntities;
import net.marmar.enhanced_playthrough.Util.enchantment.ModEnchantments;
import net.marmar.enhanced_playthrough.entity.ModEntities;
import net.marmar.enhanced_playthrough.item.ModItems;
import net.marmar.enhanced_playthrough.Util.ModTabs;
import net.marmar.enhanced_playthrough.data.loot.ModLootModifiers;
import net.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.marmar.enhanced_playthrough.menu.ModMenuTypes;
import net.marmar.enhanced_playthrough.Util.ModSounds;
import net.marmar.enhanced_playthrough.entity.ModVillagers;
import net.marmar.enhanced_playthrough.worldgen.feature.ModFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnhancedPlaythrough.MOD_ID)
public class EnhancedPlaythrough
{
    public static final String MOD_ID = "enhanced_playthrough";

    public EnhancedPlaythrough(){

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.register(modEventBus);

        ModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModEnchantments.register(modEventBus);

        ModBlocks.Register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModEntities.register(modEventBus);

        ModFeatures.register(modEventBus);

    //Register for creative tabs
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::AddCreative);
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event){
    }
}
