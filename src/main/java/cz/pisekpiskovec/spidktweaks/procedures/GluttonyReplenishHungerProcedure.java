package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class GluttonyReplenishHungerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure GluttonyReplenishHunger!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure GluttonyReplenishHunger!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof PlayerEntity)
			((PlayerEntity) sourceentity).getFoodStats()
					.setFoodLevel((int) (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
							+ Math.max(1, ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									% ((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0))));
	}
}
