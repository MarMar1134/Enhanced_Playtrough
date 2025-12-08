package net.marmar.enhanced_playthrough.item.trim;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.ForgeRegistries;

public class EPTrimPatterns {
    public static final ResourceKey<TrimPattern> ANCIENT_ARMOR_TRIM = register("ancient");

    public static void bootstrap(BootstapContext<TrimPattern> pContext){
        registerPattern(pContext, ANCIENT_ARMOR_TRIM, EPItems.ANCIENT_ARMOR_TRIM_SMITHING_TEMPLATE.get());
    }

    public static void registerPattern(BootstapContext<TrimPattern> pContext, ResourceKey<TrimPattern> pPattern, Item pTemplate){
        pContext.register(pPattern, new TrimPattern(pPattern.location(), ForgeRegistries.ITEMS.getHolder(pTemplate).get(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", pPattern.location()))));
    }

    @SuppressWarnings("removal")
    public static ResourceKey<TrimPattern> register(String name){
        return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
