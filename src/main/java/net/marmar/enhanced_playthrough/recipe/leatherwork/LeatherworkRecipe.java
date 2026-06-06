package net.marmar.enhanced_playthrough.recipe.leatherwork;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class LeatherworkRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation recipeId;
    private final Ingredient skin;
    private final FluidStack water;
    private final int fluidAmount;
    private final ItemStack leather;
    private final int leatherAmount;

    public LeatherworkRecipe(ResourceLocation recipeId, Ingredient skin, FluidStack water, int fluidAmount, ItemStack leather, int leatherAmount) {
        this.recipeId = recipeId;
        this.skin = skin;
        this.water = water;
        this.fluidAmount = fluidAmount;
        this.leather = leather;
        this.leatherAmount = leatherAmount;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return this.skin.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.leather.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.leather.copy();
    }

    public FluidStack getFluidInput()  {
        return this.water;
    }

    public int getFluidAmount() {
        return fluidAmount;
    }

    public int getLeatherAmount() {
        return leatherAmount;
    }

    @Override
    public ResourceLocation getId() {
        return this.recipeId;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<LeatherworkRecipe> {
        public static final Type INSTANCE = new Type();
    }

    @SuppressWarnings("removal")
    public static class Serializer implements RecipeSerializer<LeatherworkRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public LeatherworkRecipe fromJson(ResourceLocation pRecipeId, JsonObject jsonObject) {
            //Input
            JsonObject inputObject = GsonHelper.getAsJsonObject(jsonObject, "input", null);

            JsonElement ingredientElement = GsonHelper.isArrayNode(inputObject, "item") ? GsonHelper.getAsJsonArray(inputObject, "item") : GsonHelper.getAsJsonObject(inputObject, "item");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            //Water
            Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(inputObject.get("fluid").getAsString()));
            int fluidAmount = GsonHelper.getAsInt(inputObject, "fluid_amount", 0);

            FluidStack fluidStack = new FluidStack(fluid, fluidAmount);

            //Output
            JsonObject outputObject = GsonHelper.getAsJsonObject(jsonObject, "output", null);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(outputObject, "item"));
            int outputAmount = GsonHelper.getAsInt(outputObject, "leather_amount", 0);

            return new LeatherworkRecipe(pRecipeId, ingredient, fluidStack, fluidAmount, output, outputAmount);
        }

        @Override
        public @Nullable LeatherworkRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);

            FluidStack fluid  = FluidStack.readFromPacket(pBuffer);
            int fluidAmount = pBuffer.readVarInt();

            ItemStack output = pBuffer.readItem();
            int amount = pBuffer.readVarInt();

            return new LeatherworkRecipe(pRecipeId, input, fluid, fluidAmount, output, amount);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, LeatherworkRecipe pRecipe) {
            pRecipe.skin.toNetwork(pBuffer);

            pRecipe.getFluidInput().writeToPacket(pBuffer);
            pBuffer.writeVarInt(pRecipe.fluidAmount);

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
            pBuffer.writeVarInt(pRecipe.leatherAmount);
        }
    }
}
