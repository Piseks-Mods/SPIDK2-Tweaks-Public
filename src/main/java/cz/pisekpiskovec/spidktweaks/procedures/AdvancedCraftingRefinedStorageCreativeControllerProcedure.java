package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import cz.pisekpiskovec.spidktweaks.item.ChromaticIngotItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class AdvancedCraftingRefinedStorageCreativeControllerProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER
						.warn("Failed to load dependency entity for procedure AdvancedCraftingRefinedStorageCreativeController!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean row1 = false;
		boolean row2 = false;
		boolean row3 = false;
		boolean row4 = false;
		boolean row5 = false;
		row1 = ((new Object() {
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
		}.getItemStack((int) (0))).getItem() == ChromaticIngotItem.block && ItemTags.getCollection()
				.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
				}.getItemStack((int) (1))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/extrastorage/neural_processor"))
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
						}.getItemStack((int) (2))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (3))).getItem())
				&& (new Object() {
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
				}.getItemStack((int) (4))).getItem() == ChromaticIngotItem.block);
		row2 = (ItemTags.getCollection()
				.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
				}.getItemStack((int) (5))).getItem()) && ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/advanced_processor"))
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
						}.getItemStack((int) (6))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (7))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/advanced_processor"))
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
						}.getItemStack((int) (8))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (9))).getItem()));
		row3 = (ItemTags.getCollection()
				.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/quartz_enriched_iron"))
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
				}.getItemStack((int) (10))).getItem()) && ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (11))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/mekanism/creative_energy_cube"))
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
						}.getItemStack((int) (12))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (13))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/quartz_enriched_iron"))
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
						}.getItemStack((int) (14))).getItem()));
		row4 = (ItemTags.getCollection()
				.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
				}.getItemStack((int) (15))).getItem()) && ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/advanced_processor"))
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
						}.getItemStack((int) (16))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (17))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/advanced_processor"))
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
						}.getItemStack((int) (18))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (19))).getItem()));
		row5 = ((new Object() {
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
		}.getItemStack((int) (20))).getItem() == ChromaticIngotItem.block && ItemTags.getCollection()
				.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
				}.getItemStack((int) (21))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/quartz_enriched_iron"))
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
						}.getItemStack((int) (22))).getItem())
				&& ItemTags.getCollection()
						.getTagByID(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/input/refinedstorage/processor_binding"))
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
						}.getItemStack((int) (23))).getItem())
				&& (new Object() {
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
				}.getItemStack((int) (24))).getItem() == ChromaticIngotItem.block);
		return row1 && row2 && row3 && row4 && row5;
	}
}
