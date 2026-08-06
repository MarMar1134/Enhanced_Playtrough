package net.marmar.enhanced_playthrough.recipe.grind;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.block.EPBlocks;
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
    private final String group;

    public PrimalGrindRecipe(Ingredient Input, ItemStack pOutput, ResourceLocation pRecipeId, String pGroup) {
        super(Input, pOutput, pRecipeId);
        this.input = Input;
        this.group = pGroup;
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
    }

    public static class Serializer implements RecipeSerializer<PrimalGrindRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public PrimalGrindRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group");

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new PrimalGrindRecipe(ingredient, output, pRecipeId, group);
        }

        @Override
        public @Nullable PrimalGrindRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);

            ItemStack output = pBuffer.readItem();

            return new PrimalGrindRecipe(ingredient, output, pRecipeId, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, PrimalGrindRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);

            pRecipe.input.toNetwork(pBuffer);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
