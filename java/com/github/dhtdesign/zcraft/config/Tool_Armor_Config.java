package com.github.dhtdesign.zcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Tool_Armor_Config {
	public static final String CATEGORY_ITEMS = "items";
	public static final String CATEGORY_TOOLS = "tools";
	public static final String CATEGORY_ARMOR = "armor";
	
	public static ForgeConfigSpec.BooleanValue 	OBSIDIAN_TOOLS;
	public static ForgeConfigSpec.BooleanValue 	EMERALD_TOOLS;
	public static ForgeConfigSpec.BooleanValue 	OBSIDIAN_ARMOR;
	public static ForgeConfigSpec.BooleanValue 	EMERALD_ARMOR;
	

	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Tool & Armor Settings").push(CATEGORY_ITEMS);
		server.pop();
		
		
		server.comment("Tool Settings").push(CATEGORY_TOOLS);
		OBSIDIAN_TOOLS = server
				.comment("Decide if you want Obsidian Tools")
				.define("obsidian_tools", true);
		
		EMERALD_TOOLS = server
				.comment("Decide if you want Emerald Tools")
				.define("emerald_tools", true);
		server.pop();
		
		server.comment("Armor Settings").push(CATEGORY_ARMOR);
		OBSIDIAN_ARMOR = server
				.comment("Decide if you want Obsidian Armor")
				.define("obsidian_armor", true);
		
		EMERALD_ARMOR = server
				.comment("Decide if you want Emerald Armor")
				.define("emerald_armor", true);
		server.pop();
	}

}
