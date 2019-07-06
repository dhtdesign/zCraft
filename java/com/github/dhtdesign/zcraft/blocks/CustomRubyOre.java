package com.github.dhtdesign.zcraft.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

public class CustomRubyOre extends Block{
	
	
	 public CustomRubyOre(Properties properties) {
		super(properties);
		
	}

	@Override
	 public int getHarvestLevel(BlockState state)

	 {

	     return 2;

	 }

}
