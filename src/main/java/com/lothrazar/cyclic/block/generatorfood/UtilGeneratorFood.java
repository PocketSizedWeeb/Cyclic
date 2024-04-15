package com.lothrazar.cyclic.block.generatorfood;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class UtilGeneratorFood {

	public static <T extends Recipe<?>> List<T> getRecipes(Level world, RecipeType<T> recipeType) {
        Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> recipes = ObfuscationReflectionHelper.getPrivateValue(RecipeManager.class, world.getRecipeManager(), "f_44007_");
        if (recipes != null) {
            Map<ResourceLocation, Recipe<?>> typedRecipes = recipes.get(recipeType);
            if (typedRecipes != null) {
                return (List<T>) typedRecipes.values().stream().collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }

}
