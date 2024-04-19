package com.lothrazar.cyclic.block.generatorfuel;

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
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class RecipeGeneratorFuel implements Recipe<TileGeneratorFuel> {

	private ResourceLocation id;
	private ItemStack stack;
	public static List<RecipeGeneratorFuel> RECIPES = new ArrayList<>();
	
	static {
		for(Item item : RegistryManager.ACTIVE.getRegistry(Keys.ITEMS)) {
			ItemStack stack = new ItemStack(item);
			if(ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0) {
				new RecipeGeneratorFuel(new ResourceLocation(ModCyclic.MODID + ":generator_fuel/" + item.getDescriptionId()), stack);
			}
		}
	}
	
	public RecipeGeneratorFuel(ResourceLocation id, ItemStack stack) {
		this.id = id;
		this.stack = stack;
		RECIPES.add(this);
	}
	
	@Override
	public boolean matches(TileGeneratorFuel p_44002_, Level p_44003_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack assemble(TileGeneratorFuel p_44001_, RegistryAccess p_267165_) {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess p_267052_) {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public ItemStack getFuel() {
		return stack;
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return null;
	}

	@Override
	public RecipeType<?> getType() {
		return CyclicRecipeType.GENERATOR_FUEL.get();
	}
	
	public int getTicks() {
		return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
	}
	
	public int getRfPertick() {
		return TileGeneratorFuel.RF_PER_TICK.get();
	}

	public int getEnergyTotal() {
	  return (int) (this.getRfPertick() * this.getTicks());
	}

}
