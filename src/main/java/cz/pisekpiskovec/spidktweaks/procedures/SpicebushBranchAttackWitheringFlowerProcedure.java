package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class SpicebushBranchAttackWitheringFlowerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure SpicebushBranchAttackWitheringFlower!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SpicebushBranchAttackWitheringFlower!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double BaseDamage = 0;
		double BonusDamage = 0;
		double Coins = 0;
		double CoinIndex = 0;
		double BloomingAddition = 0;
		double RupturePotencyAddition = 0;
		double RupureStackAddition = 0;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) / ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getMaxHealth()
				: -1) < ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
						/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Clash Lost"), (false));
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Clash Won"), (false));
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) / ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getMaxHealth()
				: -1) == ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
						/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)) {
			if (Math.random() < 0.5) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Clash Lost"), (false));
				}
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Clash Won"), (false));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Clash Won"), (false));
				}
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Clash Lost"), (false));
				}
				sourceentity.getPersistentData().putDouble("StatusBloomingCount",
						(sourceentity.getPersistentData().getDouble("StatusBloomingCount") + 3));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Clash Won"), (false));
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Clash Lost"), (false));
			}
			sourceentity.getPersistentData().putDouble("StatusBloomingCount",
					(sourceentity.getPersistentData().getDouble("StatusBloomingCount") + 3));
		}
		BaseDamage = 8;
		BonusDamage = 1;
		Coins = 3;
		CoinIndex = 0;
		BloomingAddition = 0;
		RupturePotencyAddition = 0;
		RupureStackAddition = 0;
		for (int index0 = 0; index0 < (int) (Coins); index0++) {
			if (Math.random() < 0.5) {
				BaseDamage = (BaseDamage + BonusDamage);
			}
			entity.getPersistentData().putDouble("StatusBloomingCount",
					(entity.getPersistentData().getDouble("StatusBloomingCount") + BloomingAddition));
			entity.getPersistentData().putDouble("StatusRupturePotency",
					(entity.getPersistentData().getDouble("StatusRupturePotency") + RupturePotencyAddition));
			entity.getPersistentData().putDouble("StatusRuptureCount",
					(entity.getPersistentData().getDouble("StatusRuptureCount") + RupureStackAddition));
		}
		entity.attackEntityFrom(DamageSource.MAGIC, (float) BaseDamage);
	}
}
