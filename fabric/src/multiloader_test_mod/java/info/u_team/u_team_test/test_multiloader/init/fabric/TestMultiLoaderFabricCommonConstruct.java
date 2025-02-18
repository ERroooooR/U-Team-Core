package info.u_team.u_team_test.test_multiloader.init.fabric;

import info.u_team.u_team_core.api.construct.Construct;
import info.u_team.u_team_core.api.construct.ModConstruct;
import info.u_team.u_team_test.test_multiloader.TestMultiLoaderReference;

@Construct(modid = TestMultiLoaderReference.MODID)
public class TestMultiLoaderFabricCommonConstruct implements ModConstruct {
	
	@Override
	public void construct() {
		TestMultiLoaderFabricBiomeModifications.register();
		TestMultiLoaderFabricLootTableModifications.register();
		TestMultiLoaderFabricTransactionRegister.register();
	}
	
}
