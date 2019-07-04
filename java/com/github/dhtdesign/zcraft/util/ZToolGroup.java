package com.github.dhtdesign.zcraft.util;

import com.github.dhtdesign.zcraft.lists.ZCraftItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class ZToolGroup extends ItemGroup
{
	public ZToolGroup() {
		super("zcrafttab_tools");
	}
	
	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(ZCraftItems.flint_axe);
	}

}
