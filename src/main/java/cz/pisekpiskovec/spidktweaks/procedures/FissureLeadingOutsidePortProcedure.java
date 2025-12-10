package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class FissureLeadingOutsidePortProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure FissureLeadingOutsidePort!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure FissureLeadingOutsidePort!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure FissureLeadingOutsidePort!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure FissureLeadingOutsidePort!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double itr = 0;
		if ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_NETHER)) {
			if (entity.getPosY() < 128) {
				itr = 129;
				for (int index0 = 0; index0 < (int) (127); index0++) {
					if (world.isAirBlock(new BlockPos(x, itr, z)) && world.isAirBlock(new BlockPos(x, itr + 1, z))
							&& world.isAirBlock(new BlockPos(x, itr + 2, z))) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate((x + 0.5), itr, (z + 0.5));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 0.5), itr, (z + 0.5), _ent.rotationYaw,
										_ent.rotationPitch, Collections.emptySet());
							}
						}
						break;
					}
					itr = (itr + 1);
				}
			} else if (entity.getPosY() > 128) {
				itr = 127;
				for (int index1 = 0; index1 < (int) (127); index1++) {
					if (world.isAirBlock(new BlockPos(x, itr, z)) && world.isAirBlock(new BlockPos(x, itr - 1, z))
							&& world.isAirBlock(new BlockPos(x, itr - 2, z))) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate((x + 0.5), (itr - 1.5), (z + 0.5));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 0.5), (itr - 1.5), (z + 0.5), _ent.rotationYaw,
										_ent.rotationPitch, Collections.emptySet());
							}
						}
						break;
					}
					itr = (itr - 1);
				}
			}
		}
	}
}
