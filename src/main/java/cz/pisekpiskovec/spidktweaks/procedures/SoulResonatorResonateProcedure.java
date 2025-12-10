package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collection;

import cz.pisekpiskovec.spidktweaks.world.HealingRuneEffectStrenghtGameRule;
import cz.pisekpiskovec.spidktweaks.block.HealingRuneBlock;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class SoulResonatorResonateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure SoulResonatorResonate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure SoulResonatorResonate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure SoulResonatorResonate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure SoulResonatorResonate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == HealingRuneBlock.block) {
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (6 / 2d), (y + 1) - (6 / 2d), z - (6 / 2d), x + (6 / 2d), (y + 1) + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, (y + 1), z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.REGENERATION)
										return true;
								}
							}
							return false;
						}
					}.check(entityiterator))) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 30,
									(int) (world.getWorldInfo().getGameRulesInstance().getInt(HealingRuneEffectStrenghtGameRule.gamerule)), (true),
									(false)));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SOUL, (entityiterator.getPosX()), (entityiterator.getPosY()),
									(entityiterator.getPosZ()), (int) 25, 3, 3, 3, 1);
						}
					}
				}
			}
		} else if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.EMERALD_BLOCK) {
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (6 / 2d), (y + 1) - (6 / 2d), z - (6 / 2d), x + (6 / 2d), (y + 1) + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, (y + 1), z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == Effects.REGENERATION)
										return true;
								}
							}
							return false;
						}
					}.check(entityiterator))) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).removePotionEffect(Effects.BAD_OMEN);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.SOUL, (entityiterator.getPosX()), (entityiterator.getPosY()),
									(entityiterator.getPosZ()), (int) 25, 3, 3, 3, 1);
						}
					}
				}
			}
		}
	}
}
