package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class GravityOrbActivationProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure GravityOrbActivation!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putBoolean("orbActivated", (!itemstack.getOrCreateTag().getBoolean("orbActivated")));
	}
}
