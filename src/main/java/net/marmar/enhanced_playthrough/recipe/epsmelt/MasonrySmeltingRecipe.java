package net.marmar.enhanced_playthrough.recipe.epsmelt;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.category.ModRecipeCategory;
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
    private final ModRecipeCategory category;
    private final String group;

    public MasonrySmeltingRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, int pCookTime, ModRecipeCategory pCategory, String pGroup) {
        super(pInput, pOutput, pRecipeId, pCookTime, pCategory, pGroup);
        this.input = pInput;
        cookTime = pCookTime;
        this.category = pCategory;
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

        public final int defaultCookingTime = 0;
        @Override
        public MasonrySmeltingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int cookTime = GsonHelper.getAsInt(jsonObject, "cooktime", defaultCookingTime);

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new MasonrySmeltingRecipe(ingredient, output,resourceLocation, cookTime, recipeCategory, group);
        }

        @Override
        public @Nullable MasonrySmeltingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            int cookTime = friendlyByteBuf.readVarInt();

            Ingredient input = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new MasonrySmeltingRecipe(input, output, resourceLocation, cookTime, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, MasonrySmeltingRecipe masonrySmeltingRecipe) {
            friendlyByteBuf.writeEnum(masonrySmeltingRecipe.category);

            friendlyByteBuf.writeUtf(masonrySmeltingRecipe.group);

            friendlyByteBuf.writeVarInt(masonrySmeltingRecipe.cookTime);

            masonrySmeltingRecipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(masonrySmeltingRecipe.getResultItem(null), false);
        }
    }
}
