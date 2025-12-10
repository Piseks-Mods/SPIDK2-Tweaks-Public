package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.spidktweaks.item.PrideItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class PrideAbilityProcedure {
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
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure PrideAbility!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure PrideAbility!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PrideAbility!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double damageBase = 0;
		double damageResult = 0;
		boolean headA = false;
		boolean headB = false;
		boolean headC = false;
		if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == PrideItem.block) {
			damageBase = (((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).experienceLevel : 0) / 4);
			damageResult = damageBase;
			if (Math.random() < 0.5) {
				headA = (true);
				damageResult = (damageResult + damageBase);
				entity.getPersistentData().putDouble("StatusRuptureCount", (entity.getPersistentData().getDouble("StatusRuptureCount") + 1));
				entity.getPersistentData().putDouble("StatusRupturePotency", (entity.getPersistentData().getDouble("StatusRupturePotency") + 3));
				{
					ItemStack _ist = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
			if (Math.random() < 0.5) {
				headB = (true);
				damageResult = (damageResult + damageBase);
				{
					ItemStack _ist = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
			if (Math.random() < 0.5) {
				headC = (true);
				damageResult = (damageResult + damageBase);
				{
					ItemStack _ist = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(sourceentity.getPosX(), sourceentity.getPosY(), sourceentity.getPosZ()),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")),
						SoundCategory.PLAYERS, (float) 1, (float) (headA || headB || headC ? 1.25 : 0.55));
			} else {
				((World) world).playSound((sourceentity.getPosX()), (sourceentity.getPosY()), (sourceentity.getPosZ()),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")),
						SoundCategory.PLAYERS, (float) 1, (float) (headA || headB || headC ? 1.25 : 0.55), false);
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent((new java.text.DecimalFormat("##").format(damageBase) + " + "
						+ new java.text.DecimalFormat("##").format(headA ? damageBase : 0) + " + "
						+ new java.text.DecimalFormat("##").format(headB ? damageBase : 0) + " + "
						+ new java.text.DecimalFormat("##").format(headC ? damageBase : 0) + " = "
						+ new java.text.DecimalFormat("##").format(damageResult))), (true));
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("player_attack.item").setDamageBypassesArmor(), (float) damageResult);
			}
			if (sourceentity instanceof PlayerEntity) {
				((PlayerEntity) sourceentity).giveExperiencePoints((int) -damageResult);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		}
	}
}
