package com.github.dhtdesign.zcraft.items;




import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomCheeseItem extends Item{

	public CustomCheeseItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		
		
		 if (!worldIn.isRemote) {
	          entityLiving.clearActivePotions();
	       }
		 
		 return new ItemStack();
	}
	

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		
		
	     
		
		tooltip.add(1, new StringTextComponent(TextFormatting.DARK_GRAY +"Remove effects from player"));


	}


	
}
