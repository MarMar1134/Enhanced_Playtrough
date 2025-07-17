package net.marmar.enhanced_playthrough.recipe.grind;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.recipecategory.ModRecipeCategory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.jetbrains.annotations.Nullable;

public class PrimalGrindRecipe extends AbstractGrindRecipe{
    private final Ingredient input;
    private final ModRecipeCategory category;
    private final String group;

    public PrimalGrindRecipe(Ingredient input, ItemStack output, ResourceLocation id, ModRecipeCategory category, String group) {
        super(input, output, id);
        this.input = input;
        this.category = category;
        this.group = group;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(EPBlocks.PRIMAL_GRINDER.get());
    }

    public static class Type implements RecipeType<PrimalGrindRecipe>{
        public static final Type INSTANCE = new Type();
        private static final String ID = "primal_grinding";
    }

    public static class Serializer implements RecipeSerializer<PrimalGrindRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "primal_grinding");

        @Override
        public PrimalGrindRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new PrimalGrindRecipe(ingredient, output, resourceLocation, recipeCategory, group);
        }

        @Override
        public @Nullable PrimalGrindRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new PrimalGrindRecipe(ingredient, output, resourceLocation, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, PrimalGrindRecipe primalGrindRecipe) {
            friendlyByteBuf.writeEnum(primalGrindRecipe.category);

            friendlyByteBuf.writeUtf(primalGrindRecipe.group);

            primalGrindRecipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(primalGrindRecipe.getResultItem(null), false);
        }
    }
}
