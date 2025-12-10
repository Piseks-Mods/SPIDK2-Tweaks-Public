package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.spidktweaks.world.HealingBedHungerGameRule;
import cz.pisekpiskovec.spidktweaks.world.HealingBedHealGameRule;
import cz.pisekpiskovec.spidktweaks.world.HealingBedBonusDividerGameRule;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class HealingBedProcedureProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityEndSleep(PlayerWakeUpEvent event) {
			Entity entity = event.getEntity();
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure HealingBedProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure HealingBedProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double bonus = 0;
		bonus = 0;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + world.getWorldInfo().getGameRulesInstance()
				.getInt(HealingBedHealGameRule.gamerule) > ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)) {
			bonus = ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
					+ world.getWorldInfo().getGameRulesInstance().getInt(HealingBedHealGameRule.gamerule))
					- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
			bonus = (bonus / world.getWorldInfo().getGameRulesInstance().getInt(HealingBedBonusDividerGameRule.gamerule));
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
						+ world.getWorldInfo().getGameRulesInstance().getInt(HealingBedHealGameRule.gamerule)));
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getFoodStats()
					.setFoodLevel((int) (world.getWorldInfo().getGameRulesInstance().getInt(HealingBedHungerGameRule.gamerule) - bonus < 0
							? 20
							: ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0)
									- world.getWorldInfo().getGameRulesInstance().getInt(HealingBedHungerGameRule.gamerule) + bonus));
	}
}
