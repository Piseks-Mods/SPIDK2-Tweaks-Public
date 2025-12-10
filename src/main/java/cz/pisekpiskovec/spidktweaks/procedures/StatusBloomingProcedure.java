package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.spidktweaks.potion.StaggerPotionEffect;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class StatusBloomingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingHurtEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
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
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure StatusBlooming!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure StatusBlooming!");
			return;
		}
		if (dependencies.get("amount") == null) {
			if (!dependencies.containsKey("amount"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency amount for procedure StatusBlooming!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double amount = dependencies.get("amount") instanceof Integer ? (int) dependencies.get("amount") : (double) dependencies.get("amount");
		if (entity.getPersistentData().getDouble("StatusBloomingResistance") > 0 && entity.getPersistentData().getDouble("StatusBloomingCount") > 0) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					entity.getPersistentData().putDouble("StatusBloomingCount", (entity.getPersistentData().getDouble("StatusBloomingCount") - 1));
					entity.getPersistentData().putDouble("StatusBloomingResistance",
							(entity.getPersistentData().getDouble("StatusBloomingResistance") - 1));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 0);
		}
		if (entity.getPersistentData().getDouble("StatusBloomingCount") >= 5) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					entity.attackEntityFrom(DamageSource.MAGIC,
							(float) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									* entity.getPersistentData().getDouble("StatusBloomingCount")) / 100 + amount));
					entity.getPersistentData().putDouble("StatusBloomingCount", 0);
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(StaggerPotionEffect.potion, (int) 600, (int) 0));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 0);
		} else if (entity.getPersistentData().getDouble("StatusBloomingCount") > 0) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).giveExperiencePoints((int) -(entity.getPersistentData().getDouble("StatusBloomingCount") * 5));
					}
					entity.getPersistentData().putDouble("StatusBloomingCount", (entity.getPersistentData().getDouble("StatusBloomingCount") - 1));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 0);
		}
	}
}
