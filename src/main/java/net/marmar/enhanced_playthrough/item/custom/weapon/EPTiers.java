package net.marmar.enhanced_playthrough.item.custom.weapon;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.item.EPItems;
import net.marmar.enhanced_playthrough.data.tag.EPTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class EPTiers {
    @SuppressWarnings("removal")
    private static ResourceLocation modLoc(String pPath){
        return new ResourceLocation(EnhancedPlaythrough.MOD_ID, pPath);
    }

    public static final Tier SILVER = TierSortingRegistry.registerTier(
            new ForgeTier(0, 64, 10f, 0f, 21,
                    EPTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(EPItems.SILVER_INGOT.get())),
            modLoc("silver_armor"), List.of(Tiers.GOLD), List.of(Tiers.IRON));

    public static final Tier BRASS = TierSortingRegistry.registerTier(
            new ForgeTier(1, 120, 5f, 1f, 7,
                    EPTags.Blocks.NEEDS_BRASS_TOOL, () -> Ingredient.of(EPItems.BRASS_INGOT.get())),
            modLoc("brass_armor"), List.of(Tiers.STONE), List.of(Tiers.IRON));

    public static final Tier BRONZE = TierSortingRegistry.registerTier(
            new ForgeTier(1, 200, 5f, 1.5f, 7,
                    EPTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(EPItems.BRONZE_INGOT.get())),
            modLoc("bronze_armor"), List.of(Tiers.STONE), List.of(Tiers.IRON));

    public static final Tier ROSE_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(1, 350, 7.5f, 2f, 20,
                    EPTags.Blocks.NEEDS_ROSE_GOLD_TOOL, () -> Ingredient.of(EPItems.ROSE_GOLD_INGOT.get())),
            modLoc("rose_gold_armor"), List.of(Tiers.STONE), List.of(Tiers.IRON));

    public static final Tier BRONZIUM = TierSortingRegistry.registerTier(
            new ForgeTier(1, 500, 6f, 2f, 14,
                    EPTags.Blocks.NEEDS_BRONZIUM_TOOL, () -> Ingredient.of(EPItems.BRONZIUM_INGOT.get())),
            modLoc("bronzium_armor"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(2, 908, 6f, 2.5f, 16,
                    EPTags.Blocks.NEEDS_STEEL_TOOL,() -> Ingredient.of(EPItems.STEEL_INGOT.get())),
            modLoc("steel_armor"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier GREEN_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(2, 500, 14f, 2f, 21,
                    EPTags.Blocks.NEEDS_GREEN_GOLD_TOOL, () -> Ingredient.of(EPItems.GREEN_GOLD_INGOT.get())),
            modLoc("green_gold_armor"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier BLUE_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1200, 16f, 2.5f, 24,
                    EPTags.Blocks.NEEDS_BLUE_GOLD_TOOL, () -> Ingredient.of(EPItems.BLUE_GOLD_INGOT.get())),
            modLoc("blue_gold_armor"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
