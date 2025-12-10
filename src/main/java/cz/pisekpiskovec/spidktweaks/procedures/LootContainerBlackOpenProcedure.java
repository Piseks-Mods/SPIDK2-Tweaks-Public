package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Random;
import java.util.Map;
import java.util.Iterator;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModVariables;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class LootContainerBlackOpenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure LootContainerBlackOpen!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure LootContainerBlackOpen!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure LootContainerBlackOpen!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure LootContainerBlackOpen!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure LootContainerBlackOpen!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double BasePrice = 0;
		double DayNumber = 0;
		double DifficultyMultiplier = 0;
		double ResultPrice = 0;
		BasePrice = 0;
		DayNumber = PiseksSpidkIiTweaksModVariables.WorldVariables.get(world).daysJoindedTotal;
		if (world.getDifficulty() == Difficulty.PEACEFUL) {
			DifficultyMultiplier = 10;
		} else if (world.getDifficulty() == Difficulty.EASY) {
			DifficultyMultiplier = 8;
		} else if (world.getDifficulty() == Difficulty.NORMAL) {
			DifficultyMultiplier = 6;
		} else if (world.getDifficulty() == Difficulty.HARD) {
			DifficultyMultiplier = 5;
		}
		ResultPrice = (BasePrice * Math.min(100, Math.max(1, 1 + (DayNumber - 3) / DifficultyMultiplier)));
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) >= ResultPrice) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel(-((int) ResultPrice));
			world.destroyBlock(new BlockPos(x, y, z), false);
			if (Math.random() < 0.9) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:powerup/common")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (Math.random() < 0.09) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:powerup/rare")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (Math.random() < 0.01) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:powerup/legendary")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			{
				double _setval = ((entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).LootContainerOpenedCount + 1);
				entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LootContainerOpenedCount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (500 <= (entity.getCapability(PiseksSpidkIiTweaksModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PiseksSpidkIiTweaksModVariables.PlayerVariables())).LootContainerOpenedCount) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("piseks_spidk_ii_tweaks:treasuer_hunter"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("You need "
						+ (new java.text.DecimalFormat("#")
								.format(ResultPrice - ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)))
						+ " more XP levels to open this chest!")), (true));
			}
		}
	}
}
