package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import cz.pisekpiskovec.spidktweaks.item.UrineatniteIngotItem;
import cz.pisekpiskovec.spidktweaks.item.PrideItem;
import cz.pisekpiskovec.spidktweaks.item.GluttonyItem;
import cz.pisekpiskovec.spidktweaks.block.FissureLeadingOutsideBlock;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class AdvancedCraftingTableRecipeManagerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure AdvancedCraftingTableRecipeManager!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure AdvancedCraftingTableRecipeManager!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double outputID = 0;
		ItemStack itemControl = ItemStack.EMPTY;
		outputID = 25;
		if (AdvancedCraftingMekanismCreativeEnergyCubeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack((new Object() {
							public Item getRandomItem(ResourceLocation name) {
								ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
								return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
							}
						}.getRandomItem(
								new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/mekanism/creative_energy_cube"))));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingRefinedStorageCreativePortableGridProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack((new Object() {
							public Item getRandomItem(ResourceLocation name) {
								ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
								return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
							}
						}.getRandomItem(new ResourceLocation(
								"piseks_spidk_ii_tweaks:advanced_crafting_table/output/refinedstorage/creative_portable_grid"))));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingRefinedStorageCreativeControllerProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack((new Object() {
							public Item getRandomItem(ResourceLocation name) {
								ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
								return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
							}
						}.getRandomItem(
								new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/refinedstorage/creative_controller"))));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingRefinedStorageCreativeWirelessGridProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack((new Object() {
							public Item getRandomItem(ResourceLocation name) {
								ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
								return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
							}
						}.getRandomItem(new ResourceLocation(
								"piseks_spidk_ii_tweaks:advanced_crafting_table/output/refinedstorage/creative_wireless_grid"))));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingTconstructCreativeUpgradeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			itemControl = new ItemStack((new Object() {
				public Item getRandomItem(ResourceLocation name) {
					ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
					return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
				}
			}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/tconstruct/creative_slot"))));
			(itemControl).getOrCreateTag().putString("slot", "upgrades");
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (itemControl);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingTconstructCreativeDefenseSlotProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			itemControl = new ItemStack((new Object() {
				public Item getRandomItem(ResourceLocation name) {
					ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
					return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
				}
			}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/tconstruct/creative_slot"))));
			(itemControl).getOrCreateTag().putString("slot", "defense");
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (itemControl);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingTconstructCreativeAbilityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			itemControl = new ItemStack((new Object() {
				public Item getRandomItem(ResourceLocation name) {
					ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
					return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
				}
			}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/tconstruct/creative_slot"))));
			(itemControl).getOrCreateTag().putString("slot", "abilities");
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (itemControl);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingTconstructCreativeSoulSlotProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			itemControl = new ItemStack((new Object() {
				public Item getRandomItem(ResourceLocation name) {
					ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
					return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
				}
			}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/tconstruct/creative_slot"))));
			(itemControl).getOrCreateTag().putString("slot", "souls");
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (itemControl);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingBotaniaManaTabletProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			itemControl = new ItemStack((new Object() {
				public Item getRandomItem(ResourceLocation name) {
					ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
					return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
				}
			}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/botania/mana_tablet"))));
			(itemControl).getOrCreateTag().putDouble("mana", 500000);
			(itemControl).getOrCreateTag().putBoolean("creative", (true));
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (itemControl);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingBotaniaTheEverlastingGuiltyPoolProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack((new Object() {
							public Item getRandomItem(ResourceLocation name) {
								ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
								return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
							}
						}.getRandomItem(new ResourceLocation("piseks_spidk_ii_tweaks:advanced_crafting_table/output/botania/creative_pool"))));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingFissureLeadingOutsideProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(FissureLeadingOutsideBlock.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingPrideProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(PrideItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingUrineatniteIngotProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
				&& world.getWorldInfo().getDayTime() >= 13000 && world.getWorldInfo().getDayTime() <= 23000) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(UrineatniteIngotItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (AdvancedCraftingGluttonyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(GluttonyItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else {
			if (entity instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (outputID))).putStack(ItemStack.EMPTY);
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
