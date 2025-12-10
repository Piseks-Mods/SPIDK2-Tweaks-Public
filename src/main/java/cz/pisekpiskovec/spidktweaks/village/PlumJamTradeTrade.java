
package cz.pisekpiskovec.spidktweaks.village;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicTrade;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerProfession;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import cz.pisekpiskovec.spidktweaks.item.PlumJamItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlumJamTradeTrade {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.BUTCHER) {
			trades.get(1).add(new BasicTrade(new ItemStack(Items.EMERALD), new ItemStack(PlumJamItem.block, (int) (3)), 16, 5, 0.05f));
		}
	}
}
