
package cz.pisekpiskovec.spidktweaks;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import cz.pisekpiskovec.spidktweaks.item.PissBottleItem;
import cz.pisekpiskovec.spidktweaks.block.ToiletBlock;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class PissBottleCraftBrewingRecipe extends PiseksSpidkIiTweaksModElements.ModElement {
	public PissBottleCraftBrewingRecipe(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 590);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.GLASS_BOTTLE;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == ToiletBlock.block.asItem();
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(PissBottleItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
