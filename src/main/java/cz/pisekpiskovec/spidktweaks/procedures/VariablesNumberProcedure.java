package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModVariables;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class VariablesNumberProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency arguments for procedure VariablesNumber!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure VariablesNumber!");
			return;
		}
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		if ((StringArgumentType.getString(arguments, "name")).equals("daysJoined")) {
			if (DoubleArgumentType.getDouble(arguments, "value") < 0) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Value out of reach!"), (false));
				}
			} else {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "value"));
					(new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.daysJoined = _setval;
						capability.syncPlayerVariables((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()));
					});
				}
			}
		} else if ((StringArgumentType.getString(arguments, "name")).equals("daysTime")) {
			if (DoubleArgumentType.getDouble(arguments, "value") < 0) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Value out of reach!"), (false));
				}
			} else {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "value"));
					(new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.daysTime = _setval;
						capability.syncPlayerVariables((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()));
					});
				}
			}
		}
	}
}
