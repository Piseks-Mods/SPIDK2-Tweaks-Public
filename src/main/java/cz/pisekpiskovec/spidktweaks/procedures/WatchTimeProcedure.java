package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModVariables;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class WatchTimeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure WatchTime!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("It is " + new java.text.DecimalFormat("##.##")
					.format((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysTime >= 18000
									? (entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysTime / 1000 - 18
									: 24 - Math.abs((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).daysTime / 1000 - 18)))),
					(true));
		}
	}
}
