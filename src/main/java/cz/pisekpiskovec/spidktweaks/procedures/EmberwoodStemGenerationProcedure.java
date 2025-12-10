package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class EmberwoodStemGenerationProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure EmberwoodStemGeneration!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure EmberwoodStemGeneration!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure EmberwoodStemGeneration!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure EmberwoodStemGeneration!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double validCheck = 0;
		double validHold = 0;
		validCheck = (MathHelper.nextInt(new Random(), 1, 3));
		validHold = 0;
		for (int index0 = 0; index0 < (int) (validCheck); index0++) {
			if (BlockTags.getCollection().getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:emberwood_stem_valid_generation"))
					.contains((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock())) {
				validHold = (validHold + 1);
			}
		}
		return validCheck == validHold;
	}
}
