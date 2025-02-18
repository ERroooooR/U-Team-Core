package info.u_team.u_team_core.data.builder;

import info.u_team.u_team_core.intern.init.UCoreRecipeSerializers;
import info.u_team.u_team_core.util.RecipeBuilderUtil;
import net.minecraft.advancements.Advancement.Builder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

public class NoMirrorShapedRecipeBuilder extends ShapedRecipeBuilder {
	
	public NoMirrorShapedRecipeBuilder(RecipeCategory cateogry, ItemLike item, int count) {
		super(cateogry, item, count);
	}
	
	public static NoMirrorShapedRecipeBuilder noMirrorShapedRecipe(RecipeCategory cateogry, ItemLike item) {
		return noMirrorShapedRecipe(cateogry, item, 1);
	}
	
	public static NoMirrorShapedRecipeBuilder noMirrorShapedRecipe(RecipeCategory cateogry, ItemLike item, int count) {
		return new NoMirrorShapedRecipeBuilder(cateogry, item, count);
	}
	
	@Override
	public void save(RecipeOutput output, ResourceLocation location) {
		super.save(new RecipeOutput() {
			
			@Override
			public Builder advancement() {
				return output.advancement();
			}
			
			@Override
			public void accept(FinishedRecipe recipe) {
				output.accept(RecipeBuilderUtil.getRecipeWithSerializer(recipe, UCoreRecipeSerializers.NO_MIRROR_SHAPED));
			}
		}, location);
	}
}
