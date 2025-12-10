package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

import cz.pisekpiskovec.spidktweaks.item.PooItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class ToiletPoopProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure ToiletPoop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure ToiletPoop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure ToiletPoop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure ToiletPoop!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
					new AxisAlignedBB(x - (1 / 2d), (y + 0.5625) - (1 / 2d), z - (1 / 2d), x + (1 / 2d), (y + 0.5625) + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, (y + 0.5625), z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if ((entityiterator instanceof ServerPlayerEntity || entityiterator instanceof PlayerEntity) && entityiterator.isSneaking()) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5625), (z + 0.5), new ItemStack(PooItem.block));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
