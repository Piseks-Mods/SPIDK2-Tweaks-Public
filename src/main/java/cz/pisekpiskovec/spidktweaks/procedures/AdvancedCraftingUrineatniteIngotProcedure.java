package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.item.PissBottleItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class AdvancedCraftingUrineatniteIngotProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingUrineatniteIngot!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		double slotCnt = 0;
		double cntAir = 0;
		double cntPissBottle = 0;
		double cntNetheriteIngot = 0;
		slotID = 0;
		slotCnt = 25;
		cntAir = 0;
		cntPissBottle = 0;
		cntNetheriteIngot = 0;
		for (int index0 = 0; index0 < (int) (slotCnt); index0++) {
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (slotID))).getItem() == (ItemStack.EMPTY).getItem()) {
				cntAir = (cntAir + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index1 = 0; index1 < (int) (slotCnt); index1++) {
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (slotID))).getItem() == PissBottleItem.block) {
				cntPissBottle = (cntPissBottle + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index2 = 0; index2 < (int) (slotCnt); index2++) {
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (slotID))).getItem() == Items.NETHERITE_INGOT) {
				cntNetheriteIngot = (cntNetheriteIngot + 1);
			}
			slotID = (slotID + 1);
		}
		return cntAir == 23 && cntPissBottle == 1 && cntNetheriteIngot == 1;
	}
}
