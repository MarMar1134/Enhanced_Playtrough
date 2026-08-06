package net.marmar.enhanced_playthrough.recipe.epsmelt;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class MasonrySmeltingRecipe extends AbstractEPSmeltingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final int cookTime;
    private final String group;

    public MasonrySmeltingRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, int pCookTime, String pGroup) {
        super(pInput, pOutput, pRecipeId, pCookTime, pGroup);
        this.input = pInput;
        cookTime = pCookTime;
        this.group = pGroup;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        return !level.isClientSide && input.test(simpleContainer.getItem(0));
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
        return new ItemStack(EPBlocks.MASONRY_FURNACE.get());
    }

    public static class Type implements RecipeType<MasonrySmeltingRecipe>{
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<MasonrySmeltingRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public MasonrySmeltingRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group");

            int cookTime = GsonHelper.getAsInt(jsonObject, "cooktime", 200);

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new MasonrySmeltingRecipe(ingredient, output,pRecipeId, cookTime, group);
        }

        @Override
        public @Nullable MasonrySmeltingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            int cookTime = pBuffer.readVarInt();

            Ingredient input = Ingredient.fromNetwork(pBuffer);

            ItemStack output = pBuffer.readItem();

            return new MasonrySmeltingRecipe(input, output, pRecipeId, cookTime, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, MasonrySmeltingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);

            pBuffer.writeVarInt(pRecipe.cookTime);

            pRecipe.input.toNetwork(pBuffer);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
