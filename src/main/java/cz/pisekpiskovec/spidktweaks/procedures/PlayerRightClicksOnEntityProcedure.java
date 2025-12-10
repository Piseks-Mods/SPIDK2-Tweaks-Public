package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collection;

import cz.pisekpiskovec.spidktweaks.potion.StaggerPotionEffect;
import cz.pisekpiskovec.spidktweaks.item.GluttonyItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class PlayerRightClicksOnEntityProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
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

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure PlayerRightClicksOnEntity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerRightClicksOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PlayerRightClicksOnEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		boolean GluttonyCoin2Head = false;
		double GluttonyFoodLevelBit = 0;
		double GluttonyFoodLevelPenalty = 0;
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == StaggerPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(sourceentity)) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
		if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == GluttonyItem.block) {
			GluttonyCoin2Head = (false);
			GluttonyFoodLevelBit = (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0) / 3);
			GluttonyFoodLevelPenalty = 0;
			if (Math.random() < 0.5) {
				GluttonyFoodLevelPenalty = (GluttonyFoodLevelPenalty + GluttonyFoodLevelBit);
			}
			if (Math.random() < 0.5) {
				GluttonyCoin2Head = (true);
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Heads rolled"), (true));
				}
				GluttonyFoodLevelPenalty = (GluttonyFoodLevelPenalty + GluttonyFoodLevelBit);
			}
			if (Math.random() < 0.5) {
				GluttonyFoodLevelPenalty = (GluttonyFoodLevelPenalty + GluttonyFoodLevelBit);
			}
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(
								(sourceentity.getPosX())
										- ((((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
												+ EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING,
														((sourceentity instanceof LivingEntity)
																? ((LivingEntity) sourceentity).getHeldItemMainhand()
																: ItemStack.EMPTY)))
												/ 2d),
								(sourceentity.getPosY())
										- ((((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
												+ EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING,
														((sourceentity instanceof LivingEntity)
																? ((LivingEntity) sourceentity).getHeldItemMainhand()
																: ItemStack.EMPTY)))
												/ 2d),
								(sourceentity.getPosZ())
										- ((((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
												+ EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING,
														((sourceentity instanceof LivingEntity)
																? ((LivingEntity) sourceentity).getHeldItemMainhand()
																: ItemStack.EMPTY)))
												/ 2d),
								(sourceentity.getPosX())
										+ ((((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
												+ EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING,
														((sourceentity instanceof LivingEntity)
																? ((LivingEntity) sourceentity).getHeldItemMainhand()
																: ItemStack.EMPTY)))
												/ 2d),
								(sourceentity.getPosY())
										+ ((((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
												+ EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING,
														((sourceentity instanceof LivingEntity)
																? ((LivingEntity) sourceentity).getHeldItemMainhand()
																: ItemStack.EMPTY)))
												/ 2d),
								(sourceentity.getPosZ())
										+ ((((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
												+ EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING,
														((sourceentity instanceof LivingEntity)
																? ((LivingEntity) sourceentity).getHeldItemMainhand()
																: ItemStack.EMPTY)))
												/ 2d)),
						null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf((sourceentity.getPosX()), (sourceentity.getPosY()), (sourceentity.getPosZ()))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((ForgeRegistries.ENTITIES.getKey(entity.getType()).toString())
							.equals(ForgeRegistries.ENTITIES.getKey(entityiterator.getType()).toString())) {
						if (((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1)
								/ ((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getMaxHealth()
										: -1) < ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
												/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)) {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("Clash Lost"), (true));
							}
							entityiterator.getPersistentData().putDouble("StatusRuptureCount",
									(entityiterator.getPersistentData().getDouble("StatusRuptureCount") + 2));
						} else if (((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1)
								/ ((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getMaxHealth()
										: -1) == ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
												/ ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMaxHealth() : -1)) {
							if (Math.random() < 0.5) {
								if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
									((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("Clash Lost"), (true));
								}
								entityiterator.getPersistentData().putDouble("StatusRuptureCount",
										(entityiterator.getPersistentData().getDouble("StatusRuptureCount") + 2));
							} else {
								if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
									((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("Clash Won"), (true));
								}
							}
						} else {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("Clash Won"), (true));
							}
						}
						if (GluttonyCoin2Head) {
							entityiterator.getPersistentData().putDouble("StatusRupturePotency",
									(entityiterator.getPersistentData().getDouble("StatusRupturePotency") + 3));
						}
						entityiterator.attackEntityFrom(DamageSource.STARVE, (float) (GluttonyFoodLevelPenalty
								* (1 + 0.1 * Math.floor(entityiterator.getPersistentData().getDouble("StatusRupturePotency") / 3))));
						{
							ItemStack _ist = ((sourceentity instanceof LivingEntity)
									? ((LivingEntity) sourceentity).getHeldItemMainhand()
									: ItemStack.EMPTY);
							if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
					}
				}
			}
			if (sourceentity instanceof PlayerEntity)
				((PlayerEntity) sourceentity).getFoodStats().setFoodLevel(
						(int) Math.max(0, ((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel() : 0)
								- GluttonyFoodLevelBit));
		}
	}
}
