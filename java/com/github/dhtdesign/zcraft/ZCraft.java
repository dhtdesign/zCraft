package com.github.dhtdesign.zcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dhtdesign.zcraft.config.Config;
import com.github.dhtdesign.zcraft.config.Tool_Armor_Config;
import com.github.dhtdesign.zcraft.items.CustomAxeItem;
import com.github.dhtdesign.zcraft.items.CustomPickaxeItem;
import com.github.dhtdesign.zcraft.items.ItemChargedPearl;
import com.github.dhtdesign.zcraft.lists.ZCraftArmourMaterial;
import com.github.dhtdesign.zcraft.lists.ZCraftBlocks;
import com.github.dhtdesign.zcraft.lists.ZCraftItems;
import com.github.dhtdesign.zcraft.lists.ZCraftToolMaterial;
import com.github.dhtdesign.zcraft.util.ZItemGroup;
import com.github.dhtdesign.zcraft.util.ZToolGroup;
import com.github.dhtdesign.zcraft.world.OreGeneration;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("zcraft")
public class ZCraft 
{
	
	
	public static ZCraft instance;
	public static final String MODID = "zcraft";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup ZCRAFT_ITEMS = new ZItemGroup();
	public static final ItemGroup ZCRAFT_TOOLS = new ZToolGroup();
	
	public ZCraft() 
	{

		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "zcraft-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "zcraft-client.toml");
		
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("zcraft-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("zcraft-server.toml").toString());

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) 
	{
		OreGeneration.setupOreGeneration();
		
		
		LOGGER.info("Setup method registered");

	}
	
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		
		LOGGER.info("ClientRegistries method registered");
	}
	

	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegisrtyEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
	
			
			event.getRegistry().registerAll
			(
					//Items
					ZCraftItems.ruby = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("ruby")),
					ZCraftItems.cloth = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("cloth")),
					ZCraftItems.obsidian_ingot = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("obsidian_ingot")),
					ZCraftItems.obsidian_shard = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("obsidian_shard")),
					ZCraftItems.diamond_shard = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("diamond_shard")),
					ZCraftItems.emerald_shard = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("emerald_shard")),
					ZCraftItems.coin = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("coin")),
					ZCraftItems.coin_left = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("coin_left")),
					ZCraftItems.coin_right = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("coin_right")),
					
					ZCraftItems.pouch = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("pouch")),
					ZCraftItems.bag = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("bag")),

					ZCraftItems.charged_pearl = new ItemChargedPearl(new Item.Properties().group(ZCRAFT_ITEMS).maxStackSize(16)).setRegistryName(location("charged_pearl")),

					//Food
					ZCraftItems.cheese = new Item(new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(location("cheese")),
					
					//Blocks
					ZCraftItems.ruby_block = new BlockItem(ZCraftBlocks.ruby_block, new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(ZCraftBlocks.ruby_block.getRegistryName()),
					ZCraftItems.ruby_ore = new BlockItem(ZCraftBlocks.ruby_ore, new Item.Properties().group(ZCRAFT_ITEMS)).setRegistryName(ZCraftBlocks.ruby_ore.getRegistryName()),
							
					
					//Tools
					ZCraftItems.flint_axe = new CustomAxeItem(ZCraftToolMaterial.flint, -3.0f, -2.5f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("flint_axe")),
					ZCraftItems.flint_hoe = new HoeItem(ZCraftToolMaterial.flint, -3.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("flint_hoe")),
					ZCraftItems.flint_pickaxe = new CustomPickaxeItem(ZCraftToolMaterial.flint, -3, -3.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("flint_pickaxe")),
					ZCraftItems.flint_shovel = new ShovelItem(ZCraftToolMaterial.flint, -3.0f, -3.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("flint_shovel")),
					ZCraftItems.flint_sword = new SwordItem(ZCraftToolMaterial.flint, -1, -1.5f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("flint_sword")),

					
					//Armors
					ZCraftItems.cloth_helmet = new ArmorItem(ZCraftArmourMaterial.cloth, EquipmentSlotType.HEAD, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("cloth_helmet")),
					ZCraftItems.cloth_chestplate = new ArmorItem(ZCraftArmourMaterial.cloth, EquipmentSlotType.CHEST, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("cloth_chestplate")),
					ZCraftItems.cloth_leggings = new ArmorItem(ZCraftArmourMaterial.cloth, EquipmentSlotType.LEGS, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("cloth_leggings")),
					ZCraftItems.cloth_boots = new ArmorItem(ZCraftArmourMaterial.cloth, EquipmentSlotType.FEET, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("cloth_boots"))
	
			);
			
			if(Tool_Armor_Config.OBSIDIAN_TOOLS.get())
			{
				event.getRegistry().registerAll(
					ZCraftItems.obsidian_axe = new CustomAxeItem(ZCraftToolMaterial.obsidian, -1.0f, -3.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_axe")),
					ZCraftItems.obsidian_pickaxe = new CustomPickaxeItem(ZCraftToolMaterial.obsidian, -4, -2.8f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_pickaxe")),
					ZCraftItems.obsidian_shovel = new ShovelItem(ZCraftToolMaterial.obsidian, -3.5f, -3.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_shovel")),
					ZCraftItems.obsidian_sword = new SwordItem(ZCraftToolMaterial.obsidian, 0, -2.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_sword"))
				);
				
			}
			
			if(Tool_Armor_Config.EMERALD_TOOLS.get())
			{
				event.getRegistry().registerAll(
					ZCraftItems.emerald_axe = new CustomAxeItem(ZCraftToolMaterial.emerald, -1.0f, 0.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_axe")),
					ZCraftItems.emerald_pickaxe = new CustomPickaxeItem(ZCraftToolMaterial.emerald, -4, 0.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_pickaxe")),
					ZCraftItems.emerald_shovel = new ShovelItem(ZCraftToolMaterial.emerald, -3.5f, 0.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_shovel")),
					ZCraftItems.emerald_sword = new SwordItem(ZCraftToolMaterial.emerald, 0, 0.0f, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_sword"))
				);
			}
			
			if(Tool_Armor_Config.OBSIDIAN_ARMOR.get())
			{
				event.getRegistry().registerAll(	
					ZCraftItems.obsidian_helmet = new ArmorItem(ZCraftArmourMaterial.obsidian, EquipmentSlotType.HEAD, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_helmet")),
					ZCraftItems.obsidian_chestplate = new ArmorItem(ZCraftArmourMaterial.obsidian, EquipmentSlotType.CHEST, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_chestplate")),
					ZCraftItems.obsidian_leggings = new ArmorItem(ZCraftArmourMaterial.obsidian, EquipmentSlotType.LEGS, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_leggings")),
					ZCraftItems.obsidian_boots = new ArmorItem(ZCraftArmourMaterial.obsidian, EquipmentSlotType.FEET, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("obsidian_boots"))
				);
			}
			
			if(Tool_Armor_Config.EMERALD_ARMOR.get())
			{
				event.getRegistry().registerAll(
					ZCraftItems.emerald_helmet = new ArmorItem(ZCraftArmourMaterial.emerald, EquipmentSlotType.HEAD, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_helmet")),
					ZCraftItems.emerald_chestplate = new ArmorItem(ZCraftArmourMaterial.emerald, EquipmentSlotType.CHEST, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_chestplate")),
					ZCraftItems.emerald_leggings = new ArmorItem(ZCraftArmourMaterial.emerald, EquipmentSlotType.LEGS, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_leggings")),
					ZCraftItems.emerald_boots = new ArmorItem(ZCraftArmourMaterial.emerald, EquipmentSlotType.FEET, new Item.Properties().group(ZCRAFT_TOOLS)).setRegistryName(location("emerald_boots"))
				);
			}
			
			
			
			
			
			
			LOGGER.info("Items Registered.");
		}
		
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll
			(
					ZCraftBlocks.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(2).sound(SoundType.METAL)).setRegistryName(location("ruby_block")),
					ZCraftBlocks.ruby_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(2).sound(SoundType.STONE)).setRegistryName(location("ruby_ore"))
					
			);
			
			 
			LOGGER.info("Blocks Registered.");
		}
		
		
		
		
	}
	
	
	private static ResourceLocation location(String name) 
	{
		return new ResourceLocation(MODID, name);
	}
	
	
	
}















































