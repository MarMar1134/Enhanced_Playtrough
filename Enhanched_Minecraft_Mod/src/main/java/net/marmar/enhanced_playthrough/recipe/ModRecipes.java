package net.marmar.enhanced_playthrough.recipe;

import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.recipe.alloy.AlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.alloy.BlastAlloyRecipe;
import net.marmar.enhanced_playthrough.recipe.basicsmelt.BasicSmeltRecipe;
import net.marmar.enhanced_playthrough.recipe.basicsmelt.SoulBasicSmeltRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.MechanicalGrindRecipe;
import net.marmar.enhanced_playthrough.recipe.grind.PrimalGrindRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    //Registers
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EnhancedPlaythrough.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, EnhancedPlaythrough.MOD_ID);

    //Recipes
        //Basic Smelting
        public static final RegistryObject<RecipeSerializer<BasicSmeltRecipe>> BASIC_SMELTING_SERIALIZER =
                RECIPE_SERIALIZER.register("basic_smelting", () -> BasicSmeltRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<BasicSmeltRecipe>> BASIC_SMELTING_TYPE =
                RECIPE_TYPE.register("basic_smelting", () -> BasicSmeltRecipe.Type.INSTANCE);

        //Soul basic smelting
        public static final RegistryObject<RecipeSerializer<SoulBasicSmeltRecipe>> SOUL_BASIC_SMELTING_SERIALIZER =
                    RECIPE_SERIALIZER.register("soul_basic_smelting", () -> SoulBasicSmeltRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<SoulBasicSmeltRecipe>> SOUL_BASIC_SMELTING_TYPE =
                RECIPE_TYPE.register("soul_basic_smelting", () -> SoulBasicSmeltRecipe.Type.INSTANCE);

        //Ore alloying
        public static final RegistryObject<RecipeSerializer<AlloyRecipe>> ALLOYING_SERIALIZER =
                RECIPE_SERIALIZER.register("ore_alloying", () -> AlloyRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<AlloyRecipe>> ALLOYING_TYPE =
                RECIPE_TYPE.register("ore_alloying", () -> AlloyRecipe.Type.INSTANCE);

        //Super ore alloying
        public static final RegistryObject<RecipeSerializer<BlastAlloyRecipe>> SUPER_ALLOYING_SERIALIZER =
                RECIPE_SERIALIZER.register("super_ore_alloying", () -> BlastAlloyRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<BlastAlloyRecipe>> SUPER_ALLOYING_TYPE =
                RECIPE_TYPE.register("super_ore_alloying", () -> BlastAlloyRecipe.Type.INSTANCE);

        //Gem polishing
        public static final RegistryObject<RecipeSerializer<GemPolishingRecipe>> POLISHING_SERIALIZER =
                RECIPE_SERIALIZER.register("gem_polishing", () -> GemPolishingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<GemPolishingRecipe>> POLISHING_TYPE =
                RECIPE_TYPE.register("gem_polishing", () -> GemPolishingRecipe.Type.INSTANCE);

        //Grinding
        public static final RegistryObject<RecipeSerializer<PrimalGrindRecipe>> PRIMAL_GRINDING_SERIALIZER =
                RECIPE_SERIALIZER.register("primal_grinding", () -> PrimalGrindRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<PrimalGrindRecipe>> PRIMAL_GRINDING_TYPE =
                RECIPE_TYPE.register("primal_grinding", () -> PrimalGrindRecipe.Type.INSTANCE);

        public static final RegistryObject<RecipeSerializer<MechanicalGrindRecipe>> MECHANICAL_GRINDING_SERIALIZER =
                RECIPE_SERIALIZER.register("mechanical_grinding", () -> MechanicalGrindRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<MechanicalGrindRecipe>> MECHANICAL_GRINDING_TYPE =
                RECIPE_TYPE.register("mechanical_grinding", () -> MechanicalGrindRecipe.Type.INSTANCE);

    public static void Register(IEventBus eventBus){
        RECIPE_SERIALIZER.register(eventBus);
        RECIPE_TYPE.register(eventBus);
    }
}
