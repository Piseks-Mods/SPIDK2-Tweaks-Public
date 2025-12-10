package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import java.util.Map;

import cz.pisekpiskovec.spidktweaks.world.HamsterWheelGenerationGameRule;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class HamsterWheelGenerateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure HamsterWheelGenerate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure HamsterWheelGenerate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure HamsterWheelGenerate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure HamsterWheelGenerate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x + 1, y, z));
			int _amount = (int) (world.getWorldInfo().getGameRulesInstance().getInt(HamsterWheelGenerationGameRule.gamerule));
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x - 1, y, z));
			int _amount = (int) (world.getWorldInfo().getGameRulesInstance().getInt(HamsterWheelGenerationGameRule.gamerule));
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x, y + 1, z));
			int _amount = (int) (world.getWorldInfo().getGameRulesInstance().getInt(HamsterWheelGenerationGameRule.gamerule));
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x, y - 1, z));
			int _amount = (int) (world.getWorldInfo().getGameRulesInstance().getInt(HamsterWheelGenerationGameRule.gamerule));
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z + 1));
			int _amount = (int) (world.getWorldInfo().getGameRulesInstance().getInt(HamsterWheelGenerationGameRule.gamerule));
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z - 1));
			int _amount = (int) (world.getWorldInfo().getGameRulesInstance().getInt(HamsterWheelGenerationGameRule.gamerule));
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
	}
}
