package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class ClocktowerVaultLootProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure ClocktowerVaultLoot!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure ClocktowerVaultLoot!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure ClocktowerVaultLoot!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure ClocktowerVaultLoot!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double toolChooser = 0;
		double swordChooser = 0;
		double pickaxeChooser = 0;
		double hoeChooser = 0;
		ItemStack damagedEnchantedIronSword = ItemStack.EMPTY;
		ItemStack damagedDiamondHoe = ItemStack.EMPTY;
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "vaultLooted")) == false) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("vaultLooted", (true));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			for (int index0 = 0; index0 < (int) (2); index0++) {
				toolChooser = (MathHelper.nextInt(new Random(), 1, 4));
				if (toolChooser == 1) {
					swordChooser = (MathHelper.nextInt(new Random(), 1, 6));
					if (swordChooser >= 1 && swordChooser <= 3) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									new ItemStack(Items.IRON_SWORD));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (swordChooser == 4 || swordChooser == 5) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									new ItemStack(Items.DIAMOND_SWORD));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (swordChooser == 6) {
						damagedEnchantedIronSword = new ItemStack(Items.IRON_SWORD);
						{
							ItemStack _ist = (damagedEnchantedIronSword);
							if (_ist.attemptDamageItem((int) (MathHelper.nextInt(new Random(), 1, 150)), new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									(EnchantmentHelper.addRandomEnchantment(new Random(), (damagedEnchantedIronSword), (int) 60, (true))));
							entityToSpawn.setPickupDelay((int) 10);
							entityToSpawn.setNoDespawn();
							world.addEntity(entityToSpawn);
						}
					}
				} else if (toolChooser == 2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5), new ItemStack(Items.IRON_AXE));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else if (toolChooser == 3) {
					pickaxeChooser = (MathHelper.nextInt(new Random(), 1, 10));
					if (swordChooser >= 1 && swordChooser <= 6) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									new ItemStack(Items.IRON_PICKAXE));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (swordChooser >= 7 && swordChooser <= 10) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									(EnchantmentHelper.addRandomEnchantment(new Random(), new ItemStack(Items.IRON_PICKAXE), (int) 60, (true))));
							entityToSpawn.setPickupDelay((int) 10);
							entityToSpawn.setNoDespawn();
							world.addEntity(entityToSpawn);
						}
					}
				} else if (toolChooser == 4) {
					pickaxeChooser = (MathHelper.nextInt(new Random(), 1, 13));
					if (swordChooser >= 1 && swordChooser <= 5) {
						damagedDiamondHoe = new ItemStack(Items.DIAMOND_HOE);
						{
							ItemStack _ist = (damagedDiamondHoe);
							if (_ist.attemptDamageItem((int) (MathHelper.nextInt(new Random(), 1, 1500)), new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5), (damagedDiamondHoe));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (swordChooser >= 6 && swordChooser <= 9) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									new ItemStack(Items.DIAMOND_HOE));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (swordChooser == 10 && swordChooser == 13) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									(EnchantmentHelper.addRandomEnchantment(new Random(), new ItemStack(Items.GOLDEN_HOE), (int) 60, (true))));
							entityToSpawn.setPickupDelay((int) 10);
							entityToSpawn.setNoDespawn();
							world.addEntity(entityToSpawn);
						}
					}
				}
			}
			if (Math.random() > 0.7) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5), new ItemStack(Blocks.CONDUIT));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			} else {
				if (Math.random() > 0.7) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
								new ItemStack(Items.HEART_OF_THE_SEA));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
					for (int index1 = 0; index1 < (int) (MathHelper.nextInt(new Random(), 0, 5)); index1++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.5), (z + 0.5),
									new ItemStack(Items.NAUTILUS_SHELL));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
