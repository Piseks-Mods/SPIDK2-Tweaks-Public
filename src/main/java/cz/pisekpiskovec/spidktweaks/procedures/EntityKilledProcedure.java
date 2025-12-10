package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.spidktweaks.item.HorsemeatItem;
import cz.pisekpiskovec.spidktweaks.item.HandItem;
import cz.pisekpiskovec.spidktweaks.item.DraculaItem;
import cz.pisekpiskovec.spidktweaks.item.CookedHorsemeatItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class EntityKilledProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure EntityKilled!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure EntityKilled!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EntityKilled!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((entity instanceof PlayerEntity || entity instanceof ServerPlayerEntity)
				&& (sourceentity instanceof PlayerEntity || sourceentity instanceof ServerPlayerEntity)
				&& EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)) >= 3
				&& Math.random() < 0.01 * (EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)) - 2)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (entity.getPosX() + 0.5), (entity.getPosY() + 0.5), (entity.getPosZ() + 0.5),
						new ItemStack(HandItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if (entity instanceof HorseEntity && (sourceentity instanceof PlayerEntity || sourceentity instanceof ServerPlayerEntity)
				&& Math.random() < 0.25) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (entity.getPosX() + 0.5), (entity.getPosY() + 0.5), (entity.getPosZ() + 0.5),
						new ItemStack(HorsemeatItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		} else if (entity instanceof HorseEntity && entity.isBurning()
				&& (sourceentity instanceof PlayerEntity || sourceentity instanceof ServerPlayerEntity) && Math.random() < 0.25) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (entity.getPosX() + 0.5), (entity.getPosY() + 0.5), (entity.getPosZ() + 0.5),
						new ItemStack(CookedHorsemeatItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == DraculaItem.block) {
			((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("PowerUpDraculaCount",
							(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getOrCreateTag().getDouble("PowerUpDraculaCount") + 1));
		}
	}
}
