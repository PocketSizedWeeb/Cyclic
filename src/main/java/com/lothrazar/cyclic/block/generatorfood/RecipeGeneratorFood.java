package com.lothrazar.cyclic.block.generatorfood;

import java.util.ArrayList;
import java.util.List;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.registry.CyclicRecipeType;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class RecipeGeneratorFood implements Recipe<TileGeneratorFood> {

	private final ResourceLocation id;
	private ItemStack input;
	private float foodVal;
	public static List<RecipeGeneratorFood> RECIPES = new ArrayList<>();
	
	static {
		for(Item item : RegistryManager.ACTIVE.getRegistry(Keys.ITEMS)) {
			ItemStack stack = new ItemStack(item);
			if(stack.isEdible()) {
				new RecipeGeneratorFood(new ResourceLocation(ModCyclic.MODID + ":generator_food/" + item.getDescriptionId()), stack);
			}
		}
	}
	
	public RecipeGeneratorFood(ResourceLocation id, ItemStack stack) {
		this.id = id;
	    this.input = stack;
	    this.foodVal = stack.getItem().getFoodProperties(stack, null).getNutrition() + stack.getItem().getFoodProperties(stack, null).getSaturationModifier();
	    RECIPES.add(this);
	}
	
	@Override
	public boolean matches(TileGeneratorFood inv, Level level) {
		return false;
	}
	
	@Override
	public ItemStack assemble(TileGeneratorFood inv, RegistryAccess ra) {
		return ItemStack.EMPTY;
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
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return null;
	}

	@Override
	public RecipeType<?> getType() {
		return CyclicRecipeType.GENERATOR_FOOD.get();
	}

	public ItemStack getFuel() {
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
	
}