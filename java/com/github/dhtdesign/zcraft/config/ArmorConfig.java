package com.github.dhtdesign.zcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ArmorConfig {
	
	
	
	public static ForgeConfigSpec.BooleanValue 	obsidian_armor;
	public static ForgeConfigSpec.BooleanValue 	emerald_armor;
	

	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{

		obsidian_armor = server
				.comment("Decide if you want Obsidian Armor")
				.define("tools.obsidian_armor", true);
		
		emerald_armor = server
				.comment("Decide if you want Obsidian Armor")
				.define("tools.emerald_armor", true);
	}

}
