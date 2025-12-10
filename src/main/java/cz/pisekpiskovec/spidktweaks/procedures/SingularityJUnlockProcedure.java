package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.state.properties.ChestType;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class SingularityJUnlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure SingularityJUnlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure SingularityJUnlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure SingularityJUnlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure SingularityJUnlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure SingularityJUnlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		slotID = (MathHelper.nextInt(new Random(), 0, (int) (new Object() {
			public int getContainerSize(IWorld world, BlockPos pos) {
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent instanceof ChestTileEntity) {
					ChestTileEntity _block = (ChestTileEntity) _ent;
					return _block.getSizeInventory();
				}
				return 0;
			}

			public int getAmount(IWorld world, BlockPos pos) {
				Block block = world.getBlockState(pos).getBlock();
				if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
					ChestType chestType = world.getBlockState(pos).get(ChestBlock.TYPE);

					if (!ChestType.SINGLE.equals(chestType)) {
						return getContainerSize(world, pos) * 2;
					}
				}
				return getContainerSize(world, pos);
			}
		}.getAmount(world, new BlockPos(x, y, z)) - 1)));
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos(x, y, z), (int) (slotID))).getDisplayName().getString() + " x"
					+ new java.text.DecimalFormat("##").format(new Object() {
						public int getAmount(IWorld world, BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(world, new BlockPos(x, y, z), (int) (slotID))))), (true));
		}
	}
}
