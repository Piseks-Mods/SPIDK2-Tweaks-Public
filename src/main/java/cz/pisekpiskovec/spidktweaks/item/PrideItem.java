
package cz.pisekpiskovec.spidktweaks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;

import java.util.List;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class PrideItem extends PiseksSpidkIiTweaksModElements.ModElement {
	@ObjectHolder("piseks_spidk_ii_tweaks:pride")
	public static final Item block = null;

	public PrideItem(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 346;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 7.4f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.GILDED_BLACKSTONE));
			}
		}, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7oThree coins sword"));
				list.add(new StringTextComponent("[ I ] Inflict 3 Rupture"));
				list.add(new StringTextComponent("\u00A7rSubject to change: Coin Status Effect and Coin count"));
			}
		}.setRegistryName("pride"));
	}
}
