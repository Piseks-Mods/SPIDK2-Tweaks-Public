package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.item.ZinkovanejPlechItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class AdvancedCraftingTconstructCreativeSoulSlotProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingTconstructCreativeSoulSlot!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		double slotCnt = 0;
		double cntAir = 0;
		double cntWhiteDye = 0;
		double cntAluminiumIngot = 0;
		double cntCarrot = 0;
		double cntInkSac = 0;
		double cntSlimeCrystal = 0;
		double cntEnchantedGoldenApple = 0;
		double cntNetheriteScrap = 0;
		double cntDragonHead = 0;
		double cntMusicDisc = 0;
		double cntHead = 0;
		double cntEndCrystal = 0;
		double cntBookAndQuill = 0;
		double cntCobaltReinforcement = 0;
		double cntZinkovanejPlech = 0;
		slotID = 0;
		slotCnt = 25;
		cntAir = 0;
		cntWhiteDye = 0;
		cntAluminiumIngot = 0;
		cntCarrot = 0;
		cntInkSac = 0;
		cntSlimeCrystal = 0;
		cntEnchantedGoldenApple = 0;
		cntNetheriteScrap = 0;
		cntDragonHead = 0;
		cntMusicDisc = 0;
		cntHead = 0;
		cntEndCrystal = 0;
		cntBookAndQuill = 0;
		cntCobaltReinforcement = 0;
		cntZinkovanejPlech = 0;
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
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:dyes")).contains((new Object() {
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
				cntWhiteDye = (cntWhiteDye + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index2 = 0; index2 < (int) (slotCnt); index2++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/aluminum")).contains((new Object() {
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
				cntAluminiumIngot = (cntAluminiumIngot + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index3 = 0; index3 < (int) (slotCnt); index3++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:vegetables/carrot")).contains((new Object() {
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
				cntCarrot = (cntCarrot + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.INK_SAC) {
				cntInkSac = (cntInkSac + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index5 = 0; index5 < (int) (slotCnt); index5++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/slime_crystal"))
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
				cntSlimeCrystal = (cntSlimeCrystal + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index6 = 0; index6 < (int) (slotCnt); index6++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
				cntEnchantedGoldenApple = (cntEnchantedGoldenApple + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.NETHERITE_SCRAP) {
				cntNetheriteScrap = (cntNetheriteScrap + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index8 = 0; index8 < (int) (slotCnt); index8++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.DRAGON_HEAD) {
				cntDragonHead = (cntDragonHead + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index9 = 0; index9 < (int) (slotCnt); index9++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("minecraft:music_discs")).contains((new Object() {
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
				cntMusicDisc = (cntMusicDisc + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index10 = 0; index10 < (int) (slotCnt); index10++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:heads")).contains((new Object() {
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
				cntHead = (cntHead + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index11 = 0; index11 < (int) (slotCnt); index11++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.END_CRYSTAL) {
				cntEndCrystal = (cntEndCrystal + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index12 = 0; index12 < (int) (slotCnt); index12++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.WRITABLE_BOOK) {
				cntBookAndQuill = (cntBookAndQuill + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index13 = 0; index13 < (int) (slotCnt); index13++) {
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
		for (int index14 = 0; index14 < (int) (slotCnt); index14++) {
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
		return cntAir == 11 && cntWhiteDye == 1 && cntAluminiumIngot == 1 && cntCarrot == 1 && cntInkSac == 1 && cntSlimeCrystal == 1
				&& cntEnchantedGoldenApple == 1 && cntNetheriteScrap == 1 && cntDragonHead == 1 && cntMusicDisc == 1 && cntHead == 1
				&& cntEndCrystal == 1 && cntBookAndQuill == 1 && cntCobaltReinforcement == 1 && cntZinkovanejPlech == 1;
	}
}
