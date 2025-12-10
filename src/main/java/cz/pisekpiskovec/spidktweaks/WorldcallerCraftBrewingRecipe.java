
package cz.pisekpiskovec.spidktweaks;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import cz.pisekpiskovec.spidktweaks.item.WorldcallerItem;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class WorldcallerCraftBrewingRecipe extends PiseksSpidkIiTweaksModElements.ModElement {
	public WorldcallerCraftBrewingRecipe(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 540);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.GLOWSTONE_DUST;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.ENDER_PEARL;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(WorldcallerItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
