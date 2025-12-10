package cz.pisekpiskovec.spidktweaks.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import java.lang.reflect.Method;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class EnableAcidRainGameRule extends PiseksSpidkIiTweaksModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("enableAcidRain", GameRules.Category.MISC,
			create(true));

	public EnableAcidRainGameRule(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 307);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
