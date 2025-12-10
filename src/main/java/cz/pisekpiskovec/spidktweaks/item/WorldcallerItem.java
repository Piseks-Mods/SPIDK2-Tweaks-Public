
package cz.pisekpiskovec.spidktweaks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import cz.pisekpiskovec.spidktweaks.procedures.WorldcallerPortProcedure;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class WorldcallerItem extends PiseksSpidkIiTweaksModElements.ModElement {
	@ObjectHolder("piseks_spidk_ii_tweaks:worldcaller")
	public static final Item block = null;

	public WorldcallerItem(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 538);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("worldcaller");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			WorldcallerPortProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
