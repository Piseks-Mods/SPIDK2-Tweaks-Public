package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class GravityOrbGlowProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure GravityOrbGlow!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		return itemstack.getOrCreateTag().getBoolean("orbActivated");
	}
}
