package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class AdvancedCraftingGridTakeFromOutputProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingGridTakeFromOutput!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		slotID = 0;
		for (int index0 = 0; index0 < (int) (25); index0++) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (slotID))).decrStackSize((int) (1));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			slotID = (slotID + 1);
		}
	}
}
