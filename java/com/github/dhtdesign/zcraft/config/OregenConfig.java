package com.github.dhtdesign.zcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	
	public static final String CATEGORY_ORE = "oregen";
	
	public static ForgeConfigSpec.IntValue ruby_ore_chance;
	public static ForgeConfigSpec.BooleanValue generate_ruby_ore;

	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config").push(CATEGORY_ORE);

		ruby_ore_chance = server
				.comment("Maximum number of ore veins that cans spawn in one chunk.")
				.defineInRange("ore_chance", 2, 1, 6);

		generate_ruby_ore = server
				.comment("Decide if you want Ruby ore to spawn in the overworld")
				.define("ruby_ore", true);
		server.pop();
	}

}
