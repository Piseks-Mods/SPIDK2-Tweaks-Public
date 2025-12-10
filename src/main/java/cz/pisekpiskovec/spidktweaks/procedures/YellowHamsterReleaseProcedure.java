package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.entity.HamsterYellowEntity;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class YellowHamsterReleaseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure YellowHamsterRelease!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure YellowHamsterRelease!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure YellowHamsterRelease!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure YellowHamsterRelease!");
			return;
		}
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency direction for procedure YellowHamsterRelease!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure YellowHamsterRelease!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure YellowHamsterRelease!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (direction == Direction.UP) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HamsterYellowEntity.CustomEntity(HamsterYellowEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), (float) Math.random(), (float) Math.random());
				entityToSpawn.setRenderYawOffset((float) Math.random());
				entityToSpawn.setRotationYawHead((float) Math.random());
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			(itemstack).shrink((int) 1);
		} else if (direction == Direction.DOWN) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HamsterYellowEntity.CustomEntity(HamsterYellowEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 0.5), (y - 1), (z + 0.5), (float) Math.random(), (float) Math.random());
				entityToSpawn.setRenderYawOffset((float) Math.random());
				entityToSpawn.setRotationYawHead((float) Math.random());
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			(itemstack).shrink((int) 1);
		} else if (direction == Direction.NORTH) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HamsterYellowEntity.CustomEntity(HamsterYellowEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 0.5), y, (z - 1), (float) Math.random(), (float) Math.random());
				entityToSpawn.setRenderYawOffset((float) Math.random());
				entityToSpawn.setRotationYawHead((float) Math.random());
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			(itemstack).shrink((int) 1);
		} else if (direction == Direction.SOUTH) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HamsterYellowEntity.CustomEntity(HamsterYellowEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 0.5), y, (z + 1), (float) Math.random(), (float) Math.random());
				entityToSpawn.setRenderYawOffset((float) Math.random());
				entityToSpawn.setRotationYawHead((float) Math.random());
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			(itemstack).shrink((int) 1);
		} else if (direction == Direction.EAST) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HamsterYellowEntity.CustomEntity(HamsterYellowEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 1), y, (z + 0.5), (float) Math.random(), (float) Math.random());
				entityToSpawn.setRenderYawOffset((float) Math.random());
				entityToSpawn.setRotationYawHead((float) Math.random());
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			(itemstack).shrink((int) 1);
		} else if (direction == Direction.WEST) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HamsterYellowEntity.CustomEntity(HamsterYellowEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x - 1), y, (z + 0.5), (float) Math.random(), (float) Math.random());
				entityToSpawn.setRenderYawOffset((float) Math.random());
				entityToSpawn.setRotationYawHead((float) Math.random());
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			(itemstack).shrink((int) 1);
		}
	}
}
