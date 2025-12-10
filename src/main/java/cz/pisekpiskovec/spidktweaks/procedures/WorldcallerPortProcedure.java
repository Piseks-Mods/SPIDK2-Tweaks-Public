package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class WorldcallerPortProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure WorldcallerPort!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure WorldcallerPort!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((world.getWorldInfo().getSpawnX()), (world.getWorldInfo().getSpawnY()), (world.getWorldInfo().getSpawnZ()));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((world.getWorldInfo().getSpawnX()), (world.getWorldInfo().getSpawnY()),
						(world.getWorldInfo().getSpawnZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
			}
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null,
					new BlockPos(world.getWorldInfo().getSpawnX(), world.getWorldInfo().getSpawnY(), world.getWorldInfo().getSpawnZ()),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.travel")),
					SoundCategory.PLAYERS, (float) 0.4, (float) 1);
		} else {
			((World) world).playSound((world.getWorldInfo().getSpawnX()), (world.getWorldInfo().getSpawnY()), (world.getWorldInfo().getSpawnZ()),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.travel")),
					SoundCategory.PLAYERS, (float) 0.4, (float) 1, false);
		}
		for (int index0 = 0; index0 < (int) (30); index0++) {
			entity.fallDistance = (float) (1);
		}
	}
}
