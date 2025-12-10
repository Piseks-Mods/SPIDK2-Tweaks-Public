package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModVariables;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class DayOverlapProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
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
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure DayOverlap!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure DayOverlap!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysTime + 1);
			entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.daysTime = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysTime > 24000) {
			{
				double _setval = ((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysJoined + 1);
				entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.daysJoined = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysTime - 24000);
				entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.daysTime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			PiseksSpidkIiTweaksModVariables.WorldVariables
					.get(world).daysJoindedTotal = (PiseksSpidkIiTweaksModVariables.WorldVariables.get(world).daysJoindedTotal + 1);
			PiseksSpidkIiTweaksModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
