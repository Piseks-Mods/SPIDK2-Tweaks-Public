package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModVariables;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class StaggerExpiredProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure StaggerExpired!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity instanceof PlayerEntity || entity instanceof ServerPlayerEntity)) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"data merge entity @s {NoAI:0b}");
				}
			}
		} else if (entity instanceof PlayerEntity || entity instanceof ServerPlayerEntity) {
			((LivingEntity) entity).getAttribute(net.minecraft.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.setBaseValue(((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).playerMovementSpeed));
			{
				double _setval = 0;
				entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerMovementSpeed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
