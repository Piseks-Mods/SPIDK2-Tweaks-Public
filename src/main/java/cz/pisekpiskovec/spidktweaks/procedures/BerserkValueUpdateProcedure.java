package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class BerserkValueUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure BerserkValueUpdate!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure BerserkValueUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putDouble("PowerUpBerserkLoss", (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
	}
}
