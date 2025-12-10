
package cz.pisekpiskovec.spidktweaks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class CompressedNetheriteBlendItem extends PiseksSpidkIiTweaksModElements.ModElement {
	@ObjectHolder("piseks_spidk_ii_tweaks:compressed_netherite_blend")
	public static final Item block = null;

	public CompressedNetheriteBlendItem(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 243);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("compressed_netherite_blend");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
