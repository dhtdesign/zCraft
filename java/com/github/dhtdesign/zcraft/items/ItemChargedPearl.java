package com.github.dhtdesign.zcraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemChargedPearl extends Item {

	public ItemChargedPearl(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack)
    {
		return true;
    }
}
