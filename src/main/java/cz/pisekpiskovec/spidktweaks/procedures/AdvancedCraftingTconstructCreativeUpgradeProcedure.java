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

public class AdvancedCraftingTconstructCreativeUpgradeProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingTconstructCreativeUpgrade!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double slotID = 0;
		double slotCnt = 0;
		double cntAir = 0;
		double cntDiamond = 0;
		double cntEmerald = 0;
		double cntExperienceBottle = 0;
		double cntTotemOfUndying = 0;
		double ctnIronReinforcement = 0;
		double cntBlazePowder = 0;
		double cntWitherRose = 0;
		double cntGhastTear = 0;
		double cntNecroticBone = 0;
		double cntGlisteringMelonSlice = 0;
		double cntGunpowder = 0;
		double cntRedstoneBlock = 0;
		double cntPrismarine = 0;
		double cntGlowstone = 0;
		double cntFeather = 0;
		double cntRabbitsFoot = 0;
		double cntKelp = 0;
		double cntNetheriteItemFrame = 0;
		double cntCryingObsidian = 0;
		double cntCactus = 0;
		double cntCobweb = 0;
		double cntZinkovanejPlech = 0;
		slotID = 0;
		slotCnt = 25;
		cntAir = 0;
		cntDiamond = 0;
		cntEmerald = 0;
		cntExperienceBottle = 0;
		cntTotemOfUndying = 0;
		ctnIronReinforcement = 0;
		cntBlazePowder = 0;
		cntWitherRose = 0;
		cntGhastTear = 0;
		cntNecroticBone = 0;
		cntGlisteringMelonSlice = 0;
		cntGunpowder = 0;
		cntRedstoneBlock = 0;
		cntPrismarine = 0;
		cntGlowstone = 0;
		cntFeather = 0;
		cntRabbitsFoot = 0;
		cntKelp = 0;
		cntNetheriteItemFrame = 0;
		cntCryingObsidian = 0;
		cntCactus = 0;
		cntCobweb = 0;
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
			}.getItemStack((int) (slotID))).getItem() == Items.DIAMOND) {
				cntDiamond = (cntDiamond + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.EMERALD) {
				cntEmerald = (cntEmerald + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.EXPERIENCE_BOTTLE) {
				cntExperienceBottle = (cntExperienceBottle + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.TOTEM_OF_UNDYING) {
				cntTotemOfUndying = (cntTotemOfUndying + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index5 = 0; index5 < (int) (slotCnt); index5++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/iron_reinforcement"))
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
				ctnIronReinforcement = (ctnIronReinforcement + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.BLAZE_POWDER) {
				cntBlazePowder = (cntBlazePowder + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.WITHER_ROSE.asItem()) {
				cntWitherRose = (cntWitherRose + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.GHAST_TEAR) {
				cntGhastTear = (cntGhastTear + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index9 = 0; index9 < (int) (slotCnt); index9++) {
			if (ItemTags.getCollection().getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/necrotic_bone"))
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
				cntNecroticBone = (cntNecroticBone + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index10 = 0; index10 < (int) (slotCnt); index10++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.GLISTERING_MELON_SLICE) {
				cntGlisteringMelonSlice = (cntGlisteringMelonSlice + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.GUNPOWDER) {
				cntGunpowder = (cntGunpowder + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.REDSTONE_BLOCK.asItem()) {
				cntRedstoneBlock = (cntRedstoneBlock + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index13 = 0; index13 < (int) (slotCnt); index13++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.PRISMARINE_CRYSTALS) {
				cntPrismarine = (cntPrismarine + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.GLOWSTONE.asItem()) {
				cntGlowstone = (cntGlowstone + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Items.FEATHER) {
				cntFeather = (cntFeather + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index16 = 0; index16 < (int) (slotCnt); index16++) {
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
			}.getItemStack((int) (slotID))).getItem() == Items.RABBIT_FOOT) {
				cntRabbitsFoot = (cntRabbitsFoot + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.KELP.asItem()) {
				cntKelp = (cntKelp + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index18 = 0; index18 < (int) (slotCnt); index18++) {
			if (ItemTags.getCollection()
					.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/tconstruct/netherite_item_frame"))
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
				cntNetheriteItemFrame = (cntNetheriteItemFrame + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.CRYING_OBSIDIAN.asItem()) {
				cntCryingObsidian = (cntCryingObsidian + 1);
			}
			slotID = (slotID + 1);
		}
		slotID = 0;
		for (int index20 = 0; index20 < (int) (slotCnt); index20++) {
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.CACTUS.asItem()) {
				cntCactus = (cntCactus + 1);
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
			}.getItemStack((int) (slotID))).getItem() == Blocks.COBWEB.asItem()) {
				cntCobweb = (cntCobweb + 1);
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
			}.getItemStack((int) (slotID))).getItem() == ZinkovanejPlechItem.block) {
				cntZinkovanejPlech = (cntZinkovanejPlech + 1);
			}
			slotID = (slotID + 1);
		}
		return cntAir == 2 && cntDiamond == 1 && cntEmerald == 1 && cntExperienceBottle == 1 && cntTotemOfUndying == 1 && ctnIronReinforcement == 2
				&& cntBlazePowder == 1 && cntWitherRose == 1 && cntGhastTear == 1 && cntNecroticBone == 1 && cntGlisteringMelonSlice == 1
				&& cntGunpowder == 1 && cntRedstoneBlock == 1 && cntPrismarine == 1 && cntGlowstone == 1 && cntFeather == 1 && cntRabbitsFoot == 1
				&& cntKelp == 1 && cntNetheriteItemFrame == 1 && cntCryingObsidian == 1 && cntCactus == 1 && cntCobweb == 1
				&& cntZinkovanejPlech == 1;
	}
}
