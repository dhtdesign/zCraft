package com.github.dhtdesign.zcraft.world;

import com.github.dhtdesign.zcraft.config.OregenConfig;
import com.github.dhtdesign.zcraft.lists.ZCraftBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	public static void setupOreGeneration() 
	{
		if (OregenConfig.generate_ruby_ore.get()) 
		{

			for (Biome biome : ForgeRegistries.BIOMES) 
			{

				biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ZCraftBlocks.ruby_ore.getDefaultState(), OregenConfig.ruby_ore_chance.get())));
			}

		}
	}

}
