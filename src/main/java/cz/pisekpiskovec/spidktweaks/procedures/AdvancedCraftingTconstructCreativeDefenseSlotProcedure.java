package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.function.Supplier;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.item.ZinkovanejPlechItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class AdvancedCraftingTconstructCreativeDefenseSlotProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingTconstructCreativeDefenseSlot!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		double slotCnt = 0;
		double cntAir = 0;
		double cntBronzeReinforcement = 0;
		double cntScute = 0;
		double cntSearedReinforcement = 0;
		double cntGoldIngot = 0;
		double cntAnvil = 0;
		double cntEmeraldReinforcement = 0;
		double cntZinkovanejPlech = 0;
		double cntJeweledApple = 0;
		double cntCobaltReinforcement = 0;
		double cntDragonScale = 0;
		double cntGoldReinforcement = 0;
		slotID = 0;
		slotCnt = 25;
		cntAir = 0;
		cntBronzeReinforcement = 0;
		cntScute = 0;
		cntSearedReinforcement = 0;
		cntGoldIngot = 0;
		cntAnvil = 0;
		cntEmeraldReinforcement = 0;
		cntZinkovanejPlech = 0;
		cntJeweledApple = 0;
		cntCobaltReinforcement = 0;
		cntDragonScale = 0;
		cntGoldReinforcement = 0;
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
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/bronze_reinforcement"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntBronzeReinforcement = (cntBronzeReinforcement + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.SCUTE) {
				cntScute = (cntScute + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index3 = 0; index3 < (int) (slotCnt); index3++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/seared_reinforcement"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntSearedReinforcement = (cntSearedReinforcement + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index4 = 0; index4 < (int) (slotCnt); index4++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.GOLD_INGOT) {
				cntGoldIngot = (cntGoldIngot + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index5 = 0; index5 < (int) (slotCnt); index5++) {
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.ANVIL.asItem()) {
				cntAnvil = (cntAnvil + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index6 = 0; index6 < (int) (slotCnt); index6++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/emerald_reinfocement"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntEmeraldReinforcement = (cntEmeraldReinforcement + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index7 = 0; index7 < (int) (slotCnt); index7++) {
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
			}.getItemStack((int) (slotID))).getItem() == ZinkovanejPlechItem.block) {
				cntZinkovanejPlech = (cntZinkovanejPlech + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index8 = 0; index8 < (int) (slotCnt); index8++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/jeweled_apple"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntJeweledApple = (cntJeweledApple + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index9 = 0; index9 < (int) (slotCnt); index9++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/cobalt_reinforcement"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntCobaltReinforcement = (cntCobaltReinforcement + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index10 = 0; index10 < (int) (slotCnt); index10++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/dragon_scale"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntDragonScale = (cntDragonScale + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index11 = 0; index11 < (int) (slotCnt); index11++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/gold_reinforcement"))
					.contains((new Object() {
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
					}.getItemStack((int) (slotID))).getItem())) {
				cntGoldReinforcement = (cntGoldReinforcement + 1);
			}
			slotID = (slotID + 1);
		}
		return cntAir == 14 && cntBronzeReinforcement == 1 && cntScute == 1 && cntSearedReinforcement == 1 && cntGoldIngot == 1 && cntAnvil == 1
				&& cntEmeraldReinforcement == 1 && cntZinkovanejPlech == 1 && cntJeweledApple == 1 && cntCobaltReinforcement == 1
				&& cntDragonScale == 1 && cntGoldReinforcement == 1;
	}
}
