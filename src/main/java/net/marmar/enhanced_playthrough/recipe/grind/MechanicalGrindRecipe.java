package net.marmar.enhanced_playthrough.recipe.grind;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.marmar.enhanced_playthrough.block.EPBlocks;
import net.marmar.enhanced_playthrough.recipe.category.ModRecipeCategory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.Nullable;

public class MechanicalGrindRecipe extends AbstractGrindRecipe {
    private final Ingredient input;
    private final ModRecipeCategory category;
    private final String group;

    public MechanicalGrindRecipe(Ingredient pInput, ItemStack pOutput, ResourceLocation pRecipeId, ModRecipeCategory pCategory, String pGroup) {
        super(pInput, pOutput, pRecipeId);
        this.input = pInput;
        this.category = pCategory;
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
        return new ItemStack(EPBlocks.MECHANICAL_GRINDER.get());
    }

    public static class Type implements RecipeType<MechanicalGrindRecipe>{
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<MechanicalGrindRecipe>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public MechanicalGrindRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new MechanicalGrindRecipe(ingredient, output, resourceLocation, recipeCategory, group);
        }

        @Override
        public @Nullable MechanicalGrindRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new MechanicalGrindRecipe(ingredient, output, resourceLocation, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, MechanicalGrindRecipe mechanicalGrindRecipe) {
            friendlyByteBuf.writeEnum(mechanicalGrindRecipe.category);

            friendlyByteBuf.writeUtf(mechanicalGrindRecipe.group);

            mechanicalGrindRecipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(mechanicalGrindRecipe.getResultItem(null), false);
        }
    }
}
