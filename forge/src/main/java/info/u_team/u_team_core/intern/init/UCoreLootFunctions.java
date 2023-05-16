package info.u_team.u_team_core.intern.init;

import info.u_team.u_team_core.UCoreMod;
import info.u_team.u_team_core.api.registry.CommonRegister;
import info.u_team.u_team_core.api.registry.RegistryEntry;
import info.u_team.u_team_core.intern.loot.SetBlockEntityNBTLootFunction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;

public class UCoreLootFunctions {
	
	public static final CommonRegister<LootItemFunctionType> LOOT_FUNCTIONS = CommonRegister.create(Registries.LOOT_FUNCTION_TYPE, UCoreMod.MODID);
	
	public static final RegistryEntry<LootItemFunctionType> SET_BLOCKENTITY_NBT = LOOT_FUNCTIONS.register("set_blockentity_nbt", () -> new LootItemFunctionType(new SetBlockEntityNBTLootFunction.Serializer()));
	
	public static void register() {
		LOOT_FUNCTIONS.register();
	}
}
