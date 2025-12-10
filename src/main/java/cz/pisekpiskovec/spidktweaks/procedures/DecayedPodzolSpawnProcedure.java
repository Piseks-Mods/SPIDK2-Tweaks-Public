package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.FlowingFluidBlock;

import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class DecayedPodzolSpawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure DecayedPodzolSpawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure DecayedPodzolSpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure DecayedPodzolSpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure DecayedPodzolSpawn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double mobPicker = 0;
		if (world.getWorldInfo().getGameRulesInstance().getBoolean(GameRules.DO_MOB_SPAWNING) && world.getLight(new BlockPos(x, y + 1, z)) <= 1) {
			if ((world.isAirBlock(new BlockPos(x, y + 1, z))
					|| (world.getFluidState(new BlockPos(x, y + 1, z)).getBlockState()).getBlock() instanceof FlowingFluidBlock)
					&& world.isAirBlock(new BlockPos(x, y + 2, z))) {
				while (true) {
					mobPicker = (MathHelper.nextInt(new Random(), 17, 30));
					if (mobPicker == 17
							&& (world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.WATER) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new DrownedEntity(EntityType.DROWNED, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 18 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("warped_forest"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new PiglinEntity(EntityType.PIGLIN, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 19 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("nether_wastes"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new ZombifiedPiglinEntity(EntityType.ZOMBIFIED_PIGLIN, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 20 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("nether_wastes"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new BlazeEntity(EntityType.BLAZE, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 21 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new CreeperEntity(EntityType.CREEPER, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 22 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("desert"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new HuskEntity(EntityType.HUSK, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 23 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("warped_forest"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new PiglinBruteEntity(EntityType.field_242287_aj, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 24 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new PillagerEntity(EntityType.PILLAGER, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 25 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new SkeletonEntity(EntityType.SKELETON, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 26 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("dark_forest"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new VindicatorEntity(EntityType.VINDICATOR, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 27 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("swamp"))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new WitchEntity(EntityType.WITCH, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 28 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new ZombieEntity(EntityType.ZOMBIE, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 29 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)
							&& y < world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) && Math.random() < 0.05) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new ZombieVillagerEntity(EntityType.ZOMBIE_VILLAGER, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 30 && world.isAirBlock(new BlockPos(x, y + 3, z))) {
						if (Math.random() < 0.5) {
							if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
									&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
											.equals(new ResourceLocation("the_end"))) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new EndermanEntity(EntityType.ENDERMAN, (World) world);
									entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							}
						} else {
							if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
									&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
											.equals(new ResourceLocation("nether_wastes"))) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, (World) world);
									entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							}
						}
						break;
					}
				}
			} else if ((world.isAirBlock(new BlockPos(x, y + 1, z))
					|| (world.getFluidState(new BlockPos(x, y + 1, z)).getBlockState()).getBlock() instanceof FlowingFluidBlock)
					&& !world.isAirBlock(new BlockPos(x, y + 2, z))) {
				while (true) {
					mobPicker = (MathHelper.nextInt(new Random(), 2, 15));
					if (mobPicker == 2 && y < world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new CaveSpiderEntity(EntityType.CAVE_SPIDER, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 3
							&& (world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.WATER) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon drowned ~ ~ ~ {IsBaby:1b}");
						}
						break;
					}
					if (mobPicker == 4 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("warped_forest"))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon piglin ~ ~ ~ {IsBaby:1b}");
						}
						break;
					}
					if (mobPicker == 5 && y > world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new SpiderEntity(EntityType.SPIDER, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 6 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("nether_wastes"))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon zombified_piglin ~ ~ ~ {IsBaby:1b}");
						}
						break;
					}
					if (mobPicker == 7 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_END)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new EndermiteEntity(EntityType.ENDERMITE, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 8 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("crimson_forest"))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon hoglin ~ ~ ~ {Age:-24000}");
						}
						break;
					}
					if (mobPicker == 9 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("desert"))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon husk ~ ~ ~ {IsBaby:1b}");
						}
						break;
					}
					if (mobPicker == 10 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("basalt_deltas"))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon magma_cube ~ ~ ~ {Size:0}");
						}
						break;
					}
					if (mobPicker == 11 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_END)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new PhantomEntity(EntityType.PHANTOM, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 12 && y < world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new SilverfishEntity(EntityType.SILVERFISH, (World) world);
							entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						break;
					}
					if (mobPicker == 13 && world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
							&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
									.equals(new ResourceLocation("swamp"))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon slime ~ ~ ~ {Size:0}");
						}
						break;
					}
					if (mobPicker == 14 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon zombie ~ ~ ~ {IsBaby:1b}");
						}
						break;
					}
					if (mobPicker == 15 && (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD)
							&& y < world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) && Math.random() < 0.05) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 1), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "summon zombie_villager ~ ~ ~ {IsBaby:1b}");
						}
						break;
					}
				}
			}
		}
	}
}
