package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class SpicebushBranchAttackFloweringBudsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure SpicebushBranchAttackFloweringBuds!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double BaseDamage = 0;
		double BonusDamage = 0;
		double Coins = 0;
		double CoinIndex = 0;
		double BloomingAddition = 0;
		double RupturePotencyAddition = 0;
		double RupureStackAddition = 0;
		BaseDamage = 7;
		BonusDamage = 5;
		Coins = 1;
		CoinIndex = 0;
		BloomingAddition = 3;
		RupturePotencyAddition = 0;
		RupureStackAddition = 3;
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
