package net.marmar.enhanced_playthrough.item.trim;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class EPTrimMaterials {
    public static final ResourceKey<TrimMaterial> ALUMINUM = registerKey("aluminum");
    public static final ResourceKey<TrimMaterial> SILVER = registerKey("silver");
    public static final ResourceKey<TrimMaterial> ZINC = registerKey("zinc");
    public static final ResourceKey<TrimMaterial> BRONZE = registerKey("bronze");
    public static final ResourceKey<TrimMaterial> BRASS = registerKey("brass");
    public static final ResourceKey<TrimMaterial> BRONZIUM = registerKey("bronzium");
    public static final ResourceKey<TrimMaterial> STEEL = registerKey("steel");
    public static final ResourceKey<TrimMaterial> ROSE_GOLD = registerKey("rose_gold");
    public static final ResourceKey<TrimMaterial> GREEN_GOLD = registerKey("green_gold");
    public static final ResourceKey<TrimMaterial> BLUE_GOLD = registerKey("blue_gold");
    public static final ResourceKey<TrimMaterial> RUBY = registerKey("ruby");
    public static final ResourceKey<TrimMaterial> SAPPHIRE = registerKey("sapphire");
    public static final ResourceKey<TrimMaterial> GARNET = registerKey("garnet");

    public static void bootstrap(BootstapContext<TrimMaterial> pContext){
        registerMaterial(pContext, ALUMINUM, EPItems.ALUMINUM_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#54585a")), 0.2f);
        registerMaterial(pContext, SILVER, EPItems.SILVER_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#7a7a7a")), 0.2f);
        registerMaterial(pContext, ZINC, EPItems.ZINC_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#444e66")), 0.8f);
        registerMaterial(pContext, BRONZE, EPItems.BRONZE_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#3c230f")), 0.5f);
        registerMaterial(pContext, BRASS, EPItems.BRASS_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#110f53")), 0.5f);
        registerMaterial(pContext, BRONZIUM, EPItems.BRONZIUM_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#310000")), 0.5f);
        registerMaterial(pContext, STEEL, EPItems.STEEL_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#2a3232")), 0.2f);
        registerMaterial(pContext, ROSE_GOLD, EPItems.ROSE_GOLD_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#9d4135")), 0.4f);
        registerMaterial(pContext, GREEN_GOLD, EPItems.GREEN_GOLD_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#42320f")), 0.7f);
        registerMaterial(pContext, BLUE_GOLD, EPItems.BLUE_GOLD_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#110f53")), 0.9f);
        registerMaterial(pContext, RUBY, EPItems.RUBY.get(), Style.EMPTY.withColor(TextColor.parseColor("#980e0e")), 0.4f);
        registerMaterial(pContext, SAPPHIRE, EPItems.SAPPHIRE.get(), Style.EMPTY.withColor(TextColor.parseColor("#000e7c")), 0.9f);
        registerMaterial(pContext, GARNET, EPItems.GARNET.get(), Style.EMPTY.withColor(TextColor.parseColor("#550000")), 0.4f);
    }

    public static void registerMaterial(BootstapContext<TrimMaterial> pContext, ResourceKey<TrimMaterial> pMaterial, Item pIngredient, Style pStyle, float pIndex){
        pContext.register(pMaterial, TrimMaterial.create(pMaterial.location().getPath(), pIngredient, pIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", pMaterial.location())).withStyle(pStyle), Map.of()));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<TrimMaterial> registerKey(String name){
        return ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }
}
