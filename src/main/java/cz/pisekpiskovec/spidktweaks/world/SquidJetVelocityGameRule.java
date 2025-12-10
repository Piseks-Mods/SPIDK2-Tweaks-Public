package cz.pisekpiskovec.spidktweaks.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import java.lang.reflect.Method;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class SquidJetVelocityGameRule extends PiseksSpidkIiTweaksModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.IntegerValue> gamerule = GameRules.register("squidJetVelocity", GameRules.Category.PLAYER,
			create(3));

	public SquidJetVelocityGameRule(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 310);
	}

	public static GameRules.RuleType<GameRules.IntegerValue> create(int defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223559_b", int.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.IntegerValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
