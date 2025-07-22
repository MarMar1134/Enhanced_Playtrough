package net.marmar.enhanced_playthrough.recipe.epsmelting;

import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.recipecategory.ModRecipeCategory;
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
    private final ModRecipeCategory category;
    private final String group;

    public SoulBasicSmeltingRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, int pCookTime, ModRecipeCategory pCategory, String pGroup) {
        super(pInput, pOutput, pRecipeId, pCookTime, pCategory, pGroup);
        this.input = pInput;
        cookTime = pCookTime;
        this.category = pCategory;
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

        public final int defaultCookTime = 0;
        @Override
        public SoulBasicSmeltingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int cookTime = GsonHelper.getAsInt(jsonObject, "cooktime", defaultCookTime);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient input = Ingredient.fromJson(ingredientElement, false);

            return new SoulBasicSmeltingRecipe(input, output, resourceLocation, cookTime, recipeCategory, group);
        }

        @Override
        public @Nullable SoulBasicSmeltingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            int cookTime = friendlyByteBuf.readVarInt();

            Ingredient input = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new SoulBasicSmeltingRecipe(input, output, resourceLocation, cookTime, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SoulBasicSmeltingRecipe recipe) {
            friendlyByteBuf.writeEnum(recipe.category);

            friendlyByteBuf.writeUtf(recipe.group);

            friendlyByteBuf.writeVarInt(recipe.cookTime);

            recipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}
