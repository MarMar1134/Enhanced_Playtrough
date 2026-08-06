package net.marmar.enhanced_playthrough.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class GemPolishingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final ResourceLocation id;
    private final String group;

    public GemPolishingRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation RecipeId, String pGroup) {
        this.input = pInput;
        this.output = pOutput;
        this.id = RecipeId;
        this.group = pGroup;
    }

    public Ingredient getIngredient() {
        return this.input;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return input.test(simpleContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GemPolishingRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return GemPolishingRecipe.Type.INSTANCE;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(EPBlocks.GEM_POLISHER.get());
    }

    public static class Type implements RecipeType<GemPolishingRecipe>{
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<GemPolishingRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public GemPolishingRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group");

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new GemPolishingRecipe(ingredient, output, pRecipeId, group);
        }

        @Override
        public @Nullable GemPolishingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();

            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);

            ItemStack output = pBuffer.readItem();

            return new GemPolishingRecipe(ingredient, output, pRecipeId, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, GemPolishingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);

            pRecipe.input.toNetwork(pBuffer);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
