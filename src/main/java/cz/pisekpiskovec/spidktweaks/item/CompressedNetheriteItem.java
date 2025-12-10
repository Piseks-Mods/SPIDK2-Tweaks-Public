
package cz.pisekpiskovec.spidktweaks.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import cz.pisekpiskovec.spidktweaks.block.CompressedNetheriteBlockBlock;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class CompressedNetheriteItem extends PiseksSpidkIiTweaksModElements.ModElement {
	@ObjectHolder("piseks_spidk_ii_tweaks:compressed_netherite_helmet")
	public static final Item helmet = null;
	@ObjectHolder("piseks_spidk_ii_tweaks:compressed_netherite_chestplate")
	public static final Item body = null;
	@ObjectHolder("piseks_spidk_ii_tweaks:compressed_netherite_leggings")
	public static final Item legs = null;
	@ObjectHolder("piseks_spidk_ii_tweaks:compressed_netherite_boots")
	public static final Item boots = null;

	public CompressedNetheriteItem(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 333;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{6, 6, 6, 6}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 60;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CompressedNetheriteBlockBlock.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "compressed_netherite";
			}

			@Override
			public float getToughness() {
				return 9f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.9f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "piseks_spidk_ii_tweaks:textures/models/armor/compressed_netherite__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("compressed_netherite_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "piseks_spidk_ii_tweaks:textures/models/armor/compressed_netherite__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("compressed_netherite_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "piseks_spidk_ii_tweaks:textures/models/armor/compressed_netherite__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("compressed_netherite_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "piseks_spidk_ii_tweaks:textures/models/armor/compressed_netherite__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("compressed_netherite_boots"));
	}

}
