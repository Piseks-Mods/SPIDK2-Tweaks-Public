
package cz.pisekpiskovec.spidktweaks.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.SoundAdditionsAmbience;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.block.Blocks;

import cz.pisekpiskovec.spidktweaks.PiseksSpidkIiTweaksModElements;

@PiseksSpidkIiTweaksModElements.ModElement.Tag
public class DreamyWatersBiome extends PiseksSpidkIiTweaksModElements.ModElement {
	public static Biome biome;

	public DreamyWatersBiome(PiseksSpidkIiTweaksModElements instance) {
		super(instance, 257);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(-14062670).setWaterFogColor(329011)
						.withSkyColor(7972607).withFoliageColor(-14790270).withGrassColor(-984066)
						.setAmbientSound(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("ambient.underwater.loop")))
						.setMoodSound(new MoodSoundAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.underwater.enter")), 6000, 8, 2))
						.setAdditionsSound(new SoundAdditionsAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.underwater.loop.additions.rare")), 0.0111D))
						.setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.underwater.loop.additions.ultra_rare")), 12000, 24000, true))
						.setParticle(new ParticleEffectAmbience(ParticleTypes.BUBBLE, 0.015f)).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(),
								Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState())));
				biomeGenerationSettings.withStructure(StructureFeatures.BURIED_TREASURE);
				biomeGenerationSettings.withStructure(StructureFeatures.OCEAN_RUIN_WARM);
				biomeGenerationSettings.withStructure(StructureFeatures.RUINED_PORTAL_OCEAN);
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS
						.withConfiguration(new ProbabilityConfig(0.3F)).func_242731_b(11).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withOceanCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withExtraGoldOre(biomeGenerationSettings);
				DefaultBiomeFeatures.withEmeraldOre(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 3, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 1, 2, 6));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.DOLPHIN, 2, 2, 4));
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(-1.8f).scale(0.2f)
						.temperature(0.825f).downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("piseks_spidk_ii_tweaks:dreamy_waters"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
				new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), 1));
	}
}
