package com.github.dhtdesign.zcraft;

import com.github.dhtdesign.zcraft.lists.ZCraftItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class ZItemGroup extends ItemGroup
{
	public ZItemGroup() {
		super("zcrafttab");
	}
	
	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(ZCraftItems.obsidian_shard);
	}

}
