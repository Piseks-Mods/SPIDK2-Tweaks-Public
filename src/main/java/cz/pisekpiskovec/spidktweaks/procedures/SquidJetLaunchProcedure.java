package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.world.SquidJetVelocityGameRule;
import cz.pisekpiskovec.spidktweaks.world.SquidJetCooldownGameRule;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class SquidJetLaunchProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure SquidJetLaunch!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure SquidJetLaunch!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure SquidJetLaunch!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		entity.setMotion((entity.getMotion().getX()), (world.getWorldInfo().getGameRulesInstance().getInt(SquidJetVelocityGameRule.gamerule)),
				(entity.getMotion().getZ()));
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
					(int) (world.getWorldInfo().getGameRulesInstance().getInt(SquidJetCooldownGameRule.gamerule) / 20));
		if (Math.random() < (100 / (EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, itemstack) + 1)) / 100) {
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
