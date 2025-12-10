package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.block.EmberwoodStemBlock;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class EmberwoodSaplingGrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure EmberwoodSaplingGrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure EmberwoodSaplingGrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure EmberwoodSaplingGrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure EmberwoodSaplingGrow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double growExtra = 0;
		double index = 0;
		{
			BlockPos _bp = new BlockPos(x, y, z);
			BlockState _bs = EmberwoodStemBlock.block.getDefaultState();
			world.setBlockState(_bp, _bs, 3);
		}
		growExtra = (MathHelper.nextInt(new Random(), 0, 3));
		index = 1;
		for (int index0 = 0; index0 < (int) (growExtra); index0++) {
			if (world.isAirBlock(new BlockPos(x, y + index, z))) {
				{
					BlockPos _bp = new BlockPos(x, y + index, z);
					BlockState _bs = EmberwoodStemBlock.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
				index = (index + 1);
			} else {
				break;
			}
		}
	}
}
