package info.u_team.u_team_core.item;

import java.util.function.Supplier;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import net.minecraft.item.Item.Properties;

public class UBucketItem extends BucketItem {
	
	public UBucketItem(Properties properties, Supplier<? extends Fluid> fluid) {
		this(null, properties, fluid);
	}
	
	public UBucketItem(ItemGroup group, Properties properties, Supplier<? extends Fluid> fluid) {
		super(fluid, group == null ? properties : properties.tab(group));
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT compound) {
		return new FluidBucketWrapper(stack);
	}
}
