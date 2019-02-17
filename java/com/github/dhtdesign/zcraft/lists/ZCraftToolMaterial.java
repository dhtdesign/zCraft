package com.github.dhtdesign.zcraft.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ZCraftToolMaterial implements IItemTier
{
	obsidian(10.0f, 9.0f, 2000, 3, 25, ZCraftItems.obsidian_shard),
	emerald(12.0f, 9.0f, 2800, 3, 25, ZCraftItems.obsidian_shard);
	
	private float attackDamage, efficiancy;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	
	
	private ZCraftToolMaterial(float attackDamage, float efficiancy, int durability, int harvestLevel, int enchantability, Item repairMaterial) 
	{
		this.attackDamage = attackDamage;
		this.efficiancy = efficiancy;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		
	}



	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}



	@Override
	public float getEfficiency() 
	{
		return this.efficiancy;
	}



	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}



	@Override
	public int getHarvestLevel() 
	{
		return this.harvestLevel;
	}



	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}



	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairMaterial);
	}

}
