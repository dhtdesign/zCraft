package com.github.dhtdesign.zcraft.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.github.dhtdesign.zcraft.ZCraft;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config 
{
	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SERVER;
	
	private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CLIENT;
	
	static
	{
		OregenConfig.init(server_builder, client_builder);
		Tool_Armor_Config.init(server_builder, client_builder);
		
		
		
		SERVER = server_builder.build();
		CLIENT = client_builder.build();
	}

	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		ZCraft.LOGGER.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		ZCraft.LOGGER.info("Built config: " + path);
		file.load();
		ZCraft.LOGGER.info("Loaded config: " + path);
		config.setConfig(file);
	}
	
}
