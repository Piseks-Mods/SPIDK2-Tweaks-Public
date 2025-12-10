package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.BlockState;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import cz.pisekpiskovec.spidktweaks.potion.StaggerPotionEffect;
import cz.pisekpiskovec.spidktweaks.item.EnchantedPaperItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class BlockBrokenProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency world for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency x for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency y for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency z for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency blockstate for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency entity for procedure BlockBroken!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		Entity entity = (Entity) dependencies.get("entity");
		double oreRoll = 0;
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == StaggerPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
		if (BlockTags.getCollection().getTagByID(new ResourceLocation("forge:bookshelves")).contains(blockstate.getBlock())) {
			if (Math.random() < 0.03 + 0.03 * EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							new ItemStack(EnchantedPaperItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (Math.random() < 0.01 + 0.03 * EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							(EnchantmentHelper.addRandomEnchantment(new Random(), new ItemStack(Items.ENCHANTED_BOOK),
									(int) (MathHelper.nextInt(new Random(), 1, 10)), (false))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
		if (BlockTags.getCollection().getTagByID(new ResourceLocation("forge:stone")).contains(blockstate.getBlock())
				&& Math.random() < 0.03
						+ 0.03 * Math.max(
								EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)),
								new Object() {
									int check(Entity _entity) {
										if (_entity instanceof LivingEntity) {
											Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
											for (EffectInstance effect : effects) {
												if (effect.getPotion() == Effects.LUCK)
													return effect.getAmplifier();
											}
										}
										return 0;
									}
								}.check(entity))) {
			oreRoll = (MathHelper.nextInt(new Random(), 1, 10));
			if (oreRoll == 1) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/gold")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 2) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/iron")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 3) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/silver")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 4) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/copper")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 5) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/aluminium")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 6) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/lead")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 7) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/nickel")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 8) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/uranium")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 9) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/osmium")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (oreRoll == 10) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack((new Object() {
						public Item getRandomItem(ResourceLocation name) {
							ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
							return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
						}
					}.getRandomItem(new ResourceLocation("forge:nuggets/tin")))));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
