package com.lothrazar.cyclic.compat.jei;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.generatorfood.RecipeGeneratorFood;
import com.lothrazar.cyclic.block.generatorfuel.RecipeGeneratorFuel;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.library.util.ChatUtil;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class GenfuelRecipeCategory implements IRecipeCategory<RecipeGeneratorFuel>{

	private static final int FONT = 4210752;
	private static final ResourceLocation ID = new ResourceLocation(ModCyclic.MODID, "generator_fuel");
	static final RecipeType<RecipeGeneratorFuel> TYPE = new RecipeType<>(ID, RecipeGeneratorFuel.class);
	private IDrawable gui;
	private IDrawable icon;
	
	public GenfuelRecipeCategory(IGuiHelper helper) {
	    gui = helper.drawableBuilder(new ResourceLocation(ModCyclic.MODID, "textures/jei/generator_item.png"), 0, 0, 118, 32).setTextureSize(118, 32).build();
	    icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.GENERATOR_FUEL.get()));
	}
	
	@Override
	public RecipeType<RecipeGeneratorFuel> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return ChatUtil.ilang(BlockRegistry.GENERATOR_FUEL.get().getDescriptionId());
	}

	@Override
	public IDrawable getBackground() {
		return gui;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void draw(RecipeGeneratorFuel recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics ms, double mouseX, double mouseY) {
		var font = Minecraft.getInstance().font;
		ms.drawString(font, recipe.getTicks() + " t", 60, 0, FONT);
	    ms.drawString(font, recipe.getRfPertick() + " RF/t", 60, 10, FONT);
	    ms.drawString(font, recipe.getEnergyTotal() + " RF", 60, 20, FONT);
	}
	
	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeGeneratorFuel recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 6, 7).addItemStack(recipe.getFuel());
		
	}

}