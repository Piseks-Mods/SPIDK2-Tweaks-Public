package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.block.PolishedBedrockBlock;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class RingOfNullSpellProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure RingOfNullSpell!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure RingOfNullSpell!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure RingOfNullSpell!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure RingOfNullSpell!");
			return;
		}
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency direction for procedure RingOfNullSpell!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure RingOfNullSpell!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure RingOfNullSpell!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double localRaytraceDistance = 0;
		if (itemstack.getOrCreateTag().getBoolean("ringNullBlockStored")) {
			if (direction == Direction.DOWN) {
				world.setBlockState(new BlockPos(x, y - 1, z), PolishedBedrockBlock.block.getDefaultState(), 3);
			} else if (direction == Direction.UP) {
				world.setBlockState(new BlockPos(x, y + 1, z), PolishedBedrockBlock.block.getDefaultState(), 3);
			} else if (direction == Direction.NORTH) {
				world.setBlockState(new BlockPos(x, y, z - 1), PolishedBedrockBlock.block.getDefaultState(), 3);
			} else if (direction == Direction.SOUTH) {
				world.setBlockState(new BlockPos(x, y, z + 1), PolishedBedrockBlock.block.getDefaultState(), 3);
			} else if (direction == Direction.WEST) {
				world.setBlockState(new BlockPos(x - 1, y, z), PolishedBedrockBlock.block.getDefaultState(), 3);
			} else if (direction == Direction.EAST) {
				world.setBlockState(new BlockPos(x + 1, y, z), PolishedBedrockBlock.block.getDefaultState(), 3);
			}
			itemstack.getOrCreateTag().putBoolean("ringNullBlockStored", (false));
		} else {
			localRaytraceDistance = 0.5;
			for (int index0 = 0; index0 < (int) (5); index0++) {
				if ((world.getBlockState(new BlockPos(
						entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytraceDistance,
										entity.getLook(1f).y * localRaytraceDistance, entity.getLook(1f).z * localRaytraceDistance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
						entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytraceDistance,
										entity.getLook(1f).y * localRaytraceDistance, entity.getLook(1f).z * localRaytraceDistance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY(),
						entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytraceDistance,
										entity.getLook(1f).y * localRaytraceDistance, entity.getLook(1f).z * localRaytraceDistance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
						.getBlock() == PolishedBedrockBlock.block) {
					world.setBlockState(
							new BlockPos(
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytraceDistance,
													entity.getLook(1f).y * localRaytraceDistance, entity.getLook(1f).z * localRaytraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytraceDistance,
													entity.getLook(1f).y * localRaytraceDistance, entity.getLook(1f).z * localRaytraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY(),
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRaytraceDistance,
													entity.getLook(1f).y * localRaytraceDistance, entity.getLook(1f).z * localRaytraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
							Blocks.AIR.getDefaultState(), 3);
					itemstack.getOrCreateTag().putBoolean("ringNullBlockStored", (true));
					break;
				}
				localRaytraceDistance = (localRaytraceDistance + 1);
			}
		}
	}
}
