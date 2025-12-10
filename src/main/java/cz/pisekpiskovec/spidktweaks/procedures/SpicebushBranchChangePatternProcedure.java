package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class SpicebushBranchChangePatternProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure SpicebushBranchChangePattern!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SpicebushBranchChangePattern!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure SpicebushBranchChangePattern!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putDouble("SPBranchAttackPattern", (MathHelper.nextInt(new Random(), 1, 8)));
		if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 1) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Scattering Fragrance"), (true));
			}
			SpicebushBranchAttackScatteringFragranceProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 2) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Pungent Fragrance"), (true));
			}
			SpicebushBranchAttackPungentFragranceProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 3) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Flowering Buds"), (true));
			}
			SpicebushBranchAttackFloweringBudsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 4) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Like Flowers in Full Bloom..."), (true));
			}
			SpicebushBranchAttackLikeFlowersinFullBloomProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 5) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Magnificent Spring Breeze"), (true));
			}
			SpicebushBranchAttackMagnificentSpringBreezeProcedure.executeProcedure(
					Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 6) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Must Cover With Dirt"), (true));
			}
			SpicebushBranchAttackMustCoverWithDirtProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 7) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Withering Flower"), (true));
			}
			SpicebushBranchAttackWitheringFlowerProcedure.executeProcedure(
					Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (itemstack.getOrCreateTag().getDouble("SPBranchAttackPattern") == 8) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Culminating Fragrance"), (true));
			}
			SpicebushBranchAttackCulminatingFragranceProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
		{
			ItemStack _ist = itemstack;
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
	}
}
