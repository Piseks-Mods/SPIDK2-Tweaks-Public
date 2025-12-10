package cz.pisekpiskovec.spidktweaks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.AttributeModifier;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.spidktweaks.item.SneakersItem;
import cz.pisekpiskovec.spidktweaks.item.RedPillItem;
import cz.pisekpiskovec.spidktweaks.item.PrideItem;
import cz.pisekpiskovec.spidktweaks.item.PiggyBankItem;
import cz.pisekpiskovec.spidktweaks.item.OrangeJuiceItem;
import cz.pisekpiskovec.spidktweaks.item.JuiceItem;
import cz.pisekpiskovec.spidktweaks.item.JanniksFrogItem;
import cz.pisekpiskovec.spidktweaks.item.DumbbellItem;
import cz.pisekpiskovec.spidktweaks.item.DraculaItem;
import cz.pisekpiskovec.spidktweaks.item.DanisMilkItem;
import cz.pisekpiskovec.spidktweaks.item.BulldozerItem;
import cz.pisekpiskovec.spidktweaks.item.BluePillItem;
import cz.pisekpiskovec.spidktweaks.item.BerserkItem;
import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksMod;

public class CalculatingAttributeModifiersProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void addAttributeModifier(ItemAttributeModifierEvent event) {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("itemstack", event.getItemStack());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksSpidkIiTweaksMod.LOGGER.warn("Failed to load dependency itemstack for procedure CalculatingAttributeModifiers!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getItem() == PrideItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(ForgeMod.REACH_DISTANCE.get(), (new AttributeModifier(UUID.fromString("f24444da-9232-48f9-b11e-8debe62345ce"),
						"piseks_spidk_ii_tweaks." + "pride_attack_reach", 2, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == BluePillItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ARMOR,
						(new AttributeModifier(UUID.fromString("8e0527d1-9988-4fd0-97bc-49dbcc4d61e6"), "piseks_spidk_ii_tweaks." + "blue_pill_eff",
								((itemstack).getCount() * 0.01), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
		if (itemstack.getItem() == RedPillItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("67059860-8644-4dee-bdda-128ad6d934d2"), "piseks_spidk_ii_tweaks." + "red_pill_eff",
								((itemstack).getCount() * 0.01), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
		if (itemstack.getItem() == DumbbellItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("87f844a1-c39e-43e5-80a3-85d7a8e54beb"), "piseks_spidk_ii_tweaks." + "dumbbell_eff",
								((itemstack).getCount() * 0.01), AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (itemstack.getItem() == SneakersItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("033ced23-d950-449a-b7f5-750fa3660878"), "piseks_spidk_ii_tweaks." + "sneakers_eff",
								((itemstack).getCount() * 0.01), AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (itemstack.getItem() == OrangeJuiceItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_SPEED,
						(new AttributeModifier(UUID.fromString("46763159-baf4-4987-bd2b-3de335730a9f"),
								"piseks_spidk_ii_tweaks." + "orange_juice_eff", ((itemstack).getCount() * 0.01),
								AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (itemstack.getItem() == JuiceItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_SPEED,
						(new AttributeModifier(UUID.fromString("2e51e380-5840-11f0-b588-325096b39f47"), "piseks_spidk_ii_tweaks." + "juice_eff",
								((itemstack).getCount() * 0.15), AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (itemstack.getItem() == DanisMilkItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS,
						(new AttributeModifier(UUID.fromString("32d7e1e8-5840-11f0-a6d1-325096b39f47"), "piseks_spidk_ii_tweaks." + "danis_milk_eff",
								((itemstack).getCount() * 2), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == DraculaItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH,
						(new AttributeModifier(UUID.fromString("39fa6ce0-59d8-11f0-b4d4-325096b39f47"), "piseks_spidk_ii_tweaks." + "dracula_eff",
								(itemstack.getOrCreateTag().getDouble("PowerUpDraculaCount") * 0.01), AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (itemstack.getItem() == JanniksFrogItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(ForgeMod.SWIM_SPEED.get(), (new AttributeModifier(UUID.fromString("7eccbd9e-5840-11f0-ae83-325096b39f47"),
						"piseks_spidk_ii_tweaks." + "frog_eff", ((itemstack).getCount() * 0.1), AttributeModifier.Operation.MULTIPLY_BASE)));
			}
		}
		if (itemstack.getItem() == PiggyBankItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.LUCK,
						(new AttributeModifier(UUID.fromString("a55c05dc-5840-11f0-bf8f-325096b39f47"), "piseks_spidk_ii_tweaks." + "piggy_bank_eff",
								((itemstack).getCount() * 2), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == BulldozerItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK,
						(new AttributeModifier(UUID.fromString("a55c05dc-5840-11f0-bf8f-325096b39f47"), "piseks_spidk_ii_tweaks." + "bulldozer_eff",
								((itemstack).getCount() * 1), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == BerserkItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("bfad75fe-5b6c-11f0-9511-325096b39f47"), "piseks_spidk_ii_tweaks." + "berserk_eff",
								(itemstack.getOrCreateTag().getDouble("PowerUpBerserkLoss") * 0.01), AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
	}
}
