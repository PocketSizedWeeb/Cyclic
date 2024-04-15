package com.lothrazar.cyclic.block.generatorfood;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonObject;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.registry.CyclicRecipeType;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class RecipeGeneratorFood implements Recipe<TileGeneratorFood> {

	private final ResourceLocation id;
	private NonNullList<Ingredient> ingredients = NonNullList.create();
	private ItemStack input;
	private float foodVal;
	
	public RecipeGeneratorFood(ResourceLocation id, ItemStack stack) {
		this.id = id;
	    ingredients.add(Ingredient.of(stack));
	    this.input = stack;
	    this.foodVal = stack.getItem().getFoodProperties(stack, null).getNutrition() + stack.getItem().getFoodProperties(stack, null).getSaturationModifier();
	}
	
	@Override
	public boolean matches(TileGeneratorFood inv, Level level) {
		try {
		      TileGeneratorFood tile = inv;
		      return matches(tile.inputSlots.getStackInSlot(0), ingredients.get(0));
		    }
		    catch (ClassCastException e) {
		      return false;
		    }
	}

	public boolean matches(ItemStack current, Ingredient ing) {
	    if (ing == Ingredient.EMPTY) {
	      //it must be empty
	      return current.isEmpty();
	    }
	    if (current.isEmpty()) {
	      return ing == Ingredient.EMPTY;
	    }
	    return ing.test(current);
	  }
	
	@Override
	public ItemStack assemble(TileGeneratorFood inv, RegistryAccess ra) {
		return ItemStack.EMPTY;
	}

	@Override
	  public NonNullList<Ingredient> getIngredients() {
	    return ingredients;
	  }
	
	@Override
	  public boolean isSpecial() {
	    return true;
	  }
	
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess ra) {
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	public Ingredient at(int slot) {
	    return ingredients.get(slot);
	  }
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return CyclicRecipeType.GENERATOR_FOOD_S.get();
	}

	@Override
	public RecipeType<?> getType() {
		return CyclicRecipeType.GENERATOR_FOOD.get();
	}

	public ItemStack getInput() {
		return this.input;
	}
	
	public int getTicks() {
		return TileGeneratorFood.TICKS_PER_FOOD.get();
	}
	
	public int getRfPertick() {
		return TileGeneratorFood.RF_PER_TICK.get();
	}

	public int getEnergyTotal() {
	  return (int) (this.getRfPertick() * this.getTicks() * this.foodVal);
	}
	
	public static class SerializeGenerateFood implements RecipeSerializer<RecipeGeneratorFood> {

	    public SerializeGenerateFood() {}

	    /**
	     * The fluid stuff i was helped out a ton by looking at this https://github.com/mekanism/Mekanism/blob/921d10be54f97518c1f0cb5a6fc64bf47d5e6773/src/api/java/mekanism/api/SerializerHelper.java#L129
	     */
	    @Override
	    public RecipeGeneratorFood fromJson(ResourceLocation recipeId, JsonObject json) {
	      RecipeGeneratorFood r = null;
	      try {
	        ItemStack item = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "fuel"));
	        r = new RecipeGeneratorFood(recipeId, item);
	        System.out.print(recipeId.toString());
	      }
	      catch (Exception e) {
	        ModCyclic.LOGGER.error("Error loading recipe " + recipeId, e);
	      }
	      return r;
	    }

	    @Override
	    public @Nullable RecipeGeneratorFood fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
	      RecipeGeneratorFood r = new RecipeGeneratorFood(recipeId, buffer.readItem());
	      //server reading recipe from client or vice/versa 
	      return r;
	    }

	    public void toNetwork(FriendlyByteBuf buffer, RecipeGeneratorFood recipe) {
	      Ingredient zero = recipe.ingredients.get(0);
	      zero.toNetwork(buffer);
	      buffer.writeItem(recipe.input);
	    }
	    
	  }
	
}
