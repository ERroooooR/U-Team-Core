package info.u_team.u_team_core.intern.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import info.u_team.u_team_core.intern.init.UCoreLootFunctions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class SetBlockEntityNBTLootFunction extends LootItemConditionalFunction {
	
	public static LootItemConditionalFunction.Builder<?> builder() {
		return simpleBuilder(SetBlockEntityNBTLootFunction::new);
	}
	
	private SetBlockEntityNBTLootFunction(LootItemCondition[] conditions) {
		super(conditions);
	}
	
	@Override
	public ItemStack run(ItemStack stack, LootContext context) {
		if (context.hasParam(LootContextParams.BLOCK_ENTITY)) {
			final BlockEntity blockEntity = context.getParam(LootContextParams.BLOCK_ENTITY);
			blockEntity.saveToItem(stack);
		}
		return stack;
	}
	
	@Override
	public LootItemFunctionType getType() {
		return UCoreLootFunctions.SET_BLOCKENTITY_NBT.get();
	}
	
	public static class Serializer extends LootItemConditionalFunction.Serializer<SetBlockEntityNBTLootFunction> {
		
		@Override
		public SetBlockEntityNBTLootFunction deserialize(JsonObject object, JsonDeserializationContext deserializationContext, LootItemCondition[] conditions) {
			return new SetBlockEntityNBTLootFunction(conditions);
		}
	}
}
