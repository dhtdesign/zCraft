package com.github.dhtdesign.zcraft.lists;

import com.github.dhtdesign.zcraft.ZCraft;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ZCraftArmourMaterial implements IArmorMaterial 
{
	cloth("cloth", 150, new int[] {4, 6, 5, 3}, 5, ZCraftItems.cloth,"item.armor.equip_diamond", 0.2F),
	obsidian("obsidian", 1500, new int[] {10, 12, 10, 9}, 25, ZCraftItems.obsidian_ingot,"item.armor.equip_diamond", 0.2F),
	emerald("emerald", 1200, new int[] {8, 10, 9, 7}, 25, Items.EMERALD,"item.armor.equip_diamond", 0.2F);
	
	
	
	private static final int[] max_damage_array = new int[] {13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	
	
	private ZCraftArmourMaterial(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness)
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}



	@Override
	public int getDurability(EquipmentSlotType slot) {

		return max_damage_array[slot.getIndex()] * this.durability;
	}



	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {

		return this.damageReductionAmounts[slot.getIndex()];
	}



	@Override
	public int getEnchantability() {
	
		return this.enchantability;
	}



	@Override
	public SoundEvent getSoundEvent() {
		
		return new SoundEvent(new ResourceLocation(equipSound));
	}



	@Override
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairItem);
	}



	@Override
	public String getName() {

		return ZCraft.MODID + ":" + this.name;
	}



	@Override
	public float getToughness() {
		
		return this.toughness;
	}



}
