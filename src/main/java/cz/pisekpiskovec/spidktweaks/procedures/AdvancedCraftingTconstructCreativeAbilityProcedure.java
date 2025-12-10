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

public class AdvancedCraftingTconstructCreativeAbilityProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingTconstructCreativeAbility!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		double slotCnt = 0;
		double cntAir = 0;
		double cntGoldenApple = 0;
		double cntLapisLazuliBlock = 0;
		double cntZinkovanejPlech = 0;
		double cntQueensSlime = 0;
		double cntDragonsBreath = 0;
		double cntNautilusShell = 0;
		double cntSearedMelter = 0;
		double cntTanks = 0;
		double cntBlastFurnace = 0;
		double cntHepatizonIngot = 0;
		double BronzeReinforcement = 0;
		double cntIchorBall = 0;
		double cntSilkyCloth = 0;
		double cntEnderPearl = 0;
		double cntDaylightSensor = 0;
		double cntCobaltIngot = 0;
		double cntFlint = 0;
		double cntShroomlight = 0;
		double cntHeartOfTheSea = 0;
		double cntCongealedSlime = 0;
		double cntPhantomMembrane = 0;
		double cntNetheriteScrap = 0;
		double cntSlimesteelIngot = 0;
		slotID = 0;
		slotCnt = 25;
		cntAir = 0;
		cntGoldenApple = 0;
		cntLapisLazuliBlock = 0;
		cntZinkovanejPlech = 0;
		cntQueensSlime = 0;
		cntDragonsBreath = 0;
		cntNautilusShell = 0;
		cntSearedMelter = 0;
		cntTanks = 0;
		cntBlastFurnace = 0;
		cntHepatizonIngot = 0;
		BronzeReinforcement = 0;
		cntIchorBall = 0;
		cntSilkyCloth = 0;
		cntEnderPearl = 0;
		cntDaylightSensor = 0;
		cntCobaltIngot = 0;
		cntFlint = 0;
		cntShroomlight = 0;
		cntHeartOfTheSea = 0;
		cntCongealedSlime = 0;
		cntPhantomMembrane = 0;
		cntNetheriteScrap = 0;
		cntSlimesteelIngot = 0;
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
			}.getItemStack((int) (slotID))).getItem() == Items.GOLDEN_APPLE) {
				cntGoldenApple = (cntGoldenApple + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.LAPIS_BLOCK.asItem()) {
				cntLapisLazuliBlock = (cntLapisLazuliBlock + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index3 = 0; index3 < (int) (slotCnt); index3++) {
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
		for (int index4 = 0; index4 < (int) (slotCnt); index4++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/queens_slime")).contains((new Object() {
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
				cntQueensSlime = (cntQueensSlime + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.DRAGON_BREATH) {
				cntDragonsBreath = (cntDragonsBreath + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.NAUTILUS_SHELL) {
				cntNautilusShell = (cntNautilusShell + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index7 = 0; index7 < (int) (slotCnt); index7++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/seared_melter"))
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
				cntSearedMelter = (cntSearedMelter + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index8 = 0; index8 < (int) (slotCnt); index8++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("tconstruct:tanks")).contains((new Object() {
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
				cntTanks = (cntTanks + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index9 = 0; index9 < (int) (slotCnt); index9++) {
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.BLAST_FURNACE.asItem()) {
				cntBlastFurnace = (cntBlastFurnace + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index10 = 0; index10 < (int) (slotCnt); index10++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/hepatizon")).contains((new Object() {
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
				cntHepatizonIngot = (cntHepatizonIngot + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index11 = 0; index11 < (int) (slotCnt); index11++) {
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
				BronzeReinforcement = (BronzeReinforcement + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index12 = 0; index12 < (int) (slotCnt); index12++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:slimeball/ichor")).contains((new Object() {
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
				cntIchorBall = (cntIchorBall + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index13 = 0; index13 < (int) (slotCnt); index13++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/silky_cloth"))
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
				cntSilkyCloth = (cntSilkyCloth + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.ENDER_PEARL) {
				cntEnderPearl = (cntEnderPearl + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index15 = 0; index15 < (int) (slotCnt); index15++) {
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.DAYLIGHT_DETECTOR.asItem()) {
				cntDaylightSensor = (cntDaylightSensor + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index16 = 0; index16 < (int) (slotCnt); index16++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/cobalt")).contains((new Object() {
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
				cntCobaltIngot = (cntCobaltIngot + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index17 = 0; index17 < (int) (slotCnt); index17++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.FLINT) {
				cntFlint = (cntFlint + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index18 = 0; index18 < (int) (slotCnt); index18++) {
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.SHROOMLIGHT.asItem()) {
				cntShroomlight = (cntShroomlight + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index19 = 0; index19 < (int) (slotCnt); index19++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.HEART_OF_THE_SEA) {
				cntHeartOfTheSea = (cntHeartOfTheSea + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index20 = 0; index20 < (int) (slotCnt); index20++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("tconstruct:congealed_slime")).contains((new Object() {
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
				cntCongealedSlime = (cntCongealedSlime + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index21 = 0; index21 < (int) (slotCnt); index21++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.PHANTOM_MEMBRANE) {
				cntPhantomMembrane = (cntPhantomMembrane + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index22 = 0; index22 < (int) (slotCnt); index22++) {
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
		for (int index23 = 0; index23 < (int) (slotCnt); index23++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:ingots/slimesteel")).contains((new Object() {
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
				cntSlimesteelIngot = (cntSlimesteelIngot + 1);
			}
			slotID = (slotID + 1);
		}
		return cntAir == 2 && cntGoldenApple == 1 && cntLapisLazuliBlock == 1 && cntZinkovanejPlech == 1 && cntQueensSlime == 1
				&& cntDragonsBreath == 1 && cntNautilusShell == 1 && cntSearedMelter == 1 && cntTanks == 1 && cntBlastFurnace == 1
				&& cntHepatizonIngot == 1 && BronzeReinforcement == 1 && cntIchorBall == 1 && cntSilkyCloth == 1 && cntEnderPearl == 1
				&& cntDaylightSensor == 1 && cntCobaltIngot == 1 && cntFlint == 1 && cntShroomlight == 1 && cntHeartOfTheSea == 1
				&& cntCongealedSlime == 1 && cntPhantomMembrane == 1 && cntNetheriteScrap == 1 && cntSlimesteelIngot == 1;
	}
}
