package info.u_team.u_team_core.util;

import java.util.function.Supplier;

import com.google.gson.JsonObject;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

/**
 * Utility methods for recipes
 *
 * @author HyCraftHD
 */
public class RecipeBuilderUtil {
	
	/**
	 * Returns a {@link FinishedRecipe} with a custom serializer.
	 *
	 * @param recipe Finished recipe
	 * @param serializer Serializer
	 * @return Finished recipe with serializer
	 */
	public static FinishedRecipe getRecipeWithSerializer(FinishedRecipe recipe, Supplier<? extends RecipeSerializer<?>> serializer) {
		return new FinishedRecipe() {
			
			@Override
			public void serializeRecipeData(JsonObject json) {
				recipe.serializeRecipeData(json);
			}
			
			@Override
			public RecipeSerializer<?> type() {
				return serializer.get();
			}
			
			@Override
			public ResourceLocation id() {
				return recipe.id();
			}
			
			@Override
			public AdvancementHolder advancement() {
				return recipe.advancement();
			}
			
		};
	}
	
}
