package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.item.LeafItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class LeafArmorEffectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure LeafArmorEffect!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure LeafArmorEffect!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY)
				.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
						.equals(new ResourceLocation("bamboo_jungle"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
								.equals(new ResourceLocation("bamboo_jungle_hills"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
								.equals(new ResourceLocation("jungle"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
								.equals(new ResourceLocation("jungle_hills"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
								.equals(new ResourceLocation("modified_jungle"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
								.equals(new ResourceLocation("modified_jungle_edge"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
								.equals(new ResourceLocation("jungle_edge"))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 1));
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
					.getItem() == LeafItem.boots
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
							.getItem() == LeafItem.legs
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
							.getItem() == LeafItem.body
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
							.getItem() == LeafItem.helmet) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 10, (int) 0));
			}
		}
	}
}
