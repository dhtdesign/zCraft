package com.github.dhtdesign.zcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	public static ForgeConfigSpec.IntValue ore_chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;

	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");

		ore_chance = server
				.comment("Maximum number of ore veins that cans spawn in one chunk.")
				.defineInRange("oregen.ore_chance", 2, 1, 6);

		generate_overworld = server
				.comment("Decide if you want zCraft ores to spawn in the overworld")
				.define("oregen.generate_overworld", true);
	}

}
