package net.marmar.enhanced_playthrough.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelting.BasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelting.MasonrySmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.epsmelting.SoulBasicSmeltingRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EPRecipes {
    //Registers
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EnhancedPlaythrough.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, EnhancedPlaythrough.MOD_ID);

    //Recipes
        //Basic Smelting
        public static final RegistryObject<RecipeSerializer<BasicSmeltingRecipe>> BASIC_SMELT_SERIALIZER =
                RECIPE_SERIALIZER.register("basic_smelting", () -> BasicSmeltingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<BasicSmeltingRecipe>> BASIC_SMELT_TYPE =
                RECIPE_TYPE.register("basic_smelting", () -> BasicSmeltingRecipe.Type.INSTANCE);

        //Soul basic smelting
        public static final RegistryObject<RecipeSerializer<SoulBasicSmeltingRecipe>> SOUL_BASIC_SMELT_SERIALIZER =
                    RECIPE_SERIALIZER.register("soul_basic_smelting", () -> SoulBasicSmeltingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<SoulBasicSmeltingRecipe>> SOUL_BASIC_SMELT_TYPE =
                RECIPE_TYPE.register("soul_basic_smelting", () -> SoulBasicSmeltingRecipe.Type.INSTANCE);

        //Masonry smelting
        public static final RegistryObject<RecipeSerializer<MasonrySmeltingRecipe>> MASONRY_SMELT_SERIALIZER =
                RECIPE_SERIALIZER.register("masonry_smelting", () -> MasonrySmeltingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<MasonrySmeltingRecipe>> MASONRY_SMELT_TYPE =
                RECIPE_TYPE.register("masonry_smelting", () -> MasonrySmeltingRecipe.Type.INSTANCE);

        //Ore alloying
        public static final RegistryObject<RecipeSerializer<AlloyRecipe>> ALLOY_SERIALIZER =
                RECIPE_SERIALIZER.register("ore_alloying", () -> AlloyRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<AlloyRecipe>> ALLOY_TYPE =
                RECIPE_TYPE.register("ore_alloying", () -> AlloyRecipe.Type.INSTANCE);

        //Super ore alloying
        public static final RegistryObject<RecipeSerializer<BlastAlloyRecipe>> SUPER_ALLOY_SERIALIZER =
                RECIPE_SERIALIZER.register("super_ore_alloying", () -> BlastAlloyRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<BlastAlloyRecipe>> SUPER_ALLOY_TYPE =
                RECIPE_TYPE.register("super_ore_alloying", () -> BlastAlloyRecipe.Type.INSTANCE);

        //Gem polishing
        public static final RegistryObject<RecipeSerializer<GemPolishingRecipe>> POLISHING_SERIALIZER =
                RECIPE_SERIALIZER.register("gem_polishing", () -> GemPolishingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<GemPolishingRecipe>> POLISHING_TYPE =
                RECIPE_TYPE.register("gem_polishing", () -> GemPolishingRecipe.Type.INSTANCE);

        //Primal grinding
        public static final RegistryObject<RecipeSerializer<PrimalGrindRecipe>> PRIMAL_GRIND_SERIALIZER =
                RECIPE_SERIALIZER.register("primal_grinding", () -> PrimalGrindRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<PrimalGrindRecipe>> PRIMAL_GRIND_TYPE =
                RECIPE_TYPE.register("primal_grinding", () -> PrimalGrindRecipe.Type.INSTANCE);

        //Mechanical grinding
        public static final RegistryObject<RecipeSerializer<MechanicalGrindRecipe>> MECHANICAL_GRIND_SERIALIZER =
                    RECIPE_SERIALIZER.register("mechanical_grinding", () -> MechanicalGrindRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<MechanicalGrindRecipe>> MECHANICAL_GRIND_TYPE =
                RECIPE_TYPE.register("mechanical_grinding", () -> MechanicalGrindRecipe.Type.INSTANCE);

    public static void register(IEventBus eventBus){
        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough recipe serializers...");
        RECIPE_SERIALIZER.register(eventBus);

        EnhancedPlaythrough.LOGGER.info("Registering Enhanced Playthrough recipe types...");
        RECIPE_TYPE.register(eventBus);
    }
}
