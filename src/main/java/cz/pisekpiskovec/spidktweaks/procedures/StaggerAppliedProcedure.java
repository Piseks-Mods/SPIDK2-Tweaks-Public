package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModVariables;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class StaggerAppliedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure StaggerApplied!");
				return;
			}
				Entity entity = (Entity) dependencies.get("entity");
		if (!(entity instanceof PlayerEntity||entity instanceof ServerPlayerEntity)) {{
	Entity _ent = entity;
	if(!_ent.world.isRemote && _ent.world.getServer() != null) {
		_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource()
			.withFeedbackDisabled().withPermissionLevel(4), "data merge entity @s {NoAI:1b}");
	}
}}else if (entity instanceof PlayerEntity||entity instanceof ServerPlayerEntity) {{
  double _setval = ((LivingEntity) entity).getAttribute(net.minecraft.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getValue();
  entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.playerMovementSpeed = _setval;
    capability.syncPlayerVariables(entity);
  });
}((LivingEntity) entity).getAttribute(net.minecraft.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0);}
	}
}
