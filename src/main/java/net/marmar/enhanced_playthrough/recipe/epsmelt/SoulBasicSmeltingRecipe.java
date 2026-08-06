package net.marmar.enhanced_playthrough.recipe.epsmelt;

import net.marmar.enhanced_playthrough.block.EPBlocks;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SoulBasicSmeltingRecipe extends AbstractEPSmeltingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final int cookTime;
    private final String group;

    public SoulBasicSmeltingRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, int pCookTime, String pGroup) {
        super(pInput, pOutput, pRecipeId, pCookTime, pGroup);
        this.input = pInput;
        this.cookTime = pCookTime;
        this.group = pGroup;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return input.test(simpleContainer.getItem(0));
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
        return new ItemStack(EPBlocks.SOUL_FURNACE.get());
    }

    public static class Type implements RecipeType<SoulBasicSmeltingRecipe>{
        public static final Type INSTANCE = new Type();
    }
    public static class Serializer implements RecipeSerializer<SoulBasicSmeltingRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public SoulBasicSmeltingRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group");

            int cookTime = GsonHelper.getAsInt(jsonObject, "cooktime", 200);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient input = Ingredient.fromJson(ingredientElement, false);

            return new SoulBasicSmeltingRecipe(input, output, pRecipeId, cookTime, group);
        }

        @Override
        public @Nullable SoulBasicSmeltingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            int cookTime = pBuffer.readVarInt();

            Ingredient input = Ingredient.fromNetwork(pBuffer);

            ItemStack output = pBuffer.readItem();

            return new SoulBasicSmeltingRecipe(input, output, pRecipeId, cookTime, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, SoulBasicSmeltingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);

            pBuffer.writeVarInt(pRecipe.cookTime);

            pRecipe.input.toNetwork(pBuffer);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
