package info.u_team.u_team_core.intern.data.provider;

import info.u_team.u_team_core.UCoreMod;
import info.u_team.u_team_core.data.CommonRecipeProvider;
import info.u_team.u_team_core.data.GenerationData;
import info.u_team.u_team_core.intern.init.UCoreRecipeSerializers;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SpecialRecipeBuilder;

public class UCoreRecipesProvider extends CommonRecipeProvider {
	
	public UCoreRecipesProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	public void register(RecipeOutput output) {
		SpecialRecipeBuilder.special(UCoreRecipeSerializers.CRAFTING_SPECIAL_ITEMDYE.get()).save(output, UCoreMod.MODID + ":custom_dyeable_item");
	}
	
}
