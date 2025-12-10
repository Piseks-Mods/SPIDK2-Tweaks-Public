
package cz.pisekpiskovec.spidktweaks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class UrineatniteShovelItem extends PiseksSpidkIiTweaksModElements.ModElement {
	@ObjectHolder("piseks_spidk_ii_tweaks:urineatnite_shovel")
	public static final Item block = null;

	public UrineatniteShovelItem(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 482);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 3046;
			}

			public float getEfficiency() {
				return 13.5f;
			}

			public float getAttackDamage() {
				return 7.75f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(UrineatniteIngotItem.block));
			}
		}, 1, -2.5f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
		}.setRegistryName("urineatnite_shovel"));
	}
}
