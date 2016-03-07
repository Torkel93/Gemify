package torkelOgAnders.Gemify.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import torkelOgAnders.Gemify.Gemify;

public class BlockOreCyxanium extends Block {

	public BlockOreCyxanium(Material material) {
		super(material);
		this.setHardness(3.0F);
		this.setLightLevel(1.0F);
		this.setStepSound(this.soundTypeStone);
		
		
	}

	//Hvis blokken har en transparant bakgrunn må denne være med
		@Override
		public boolean isOpaqueCube(){
			return false;
			
		}
		
		@Override
		public Item getItemDropped(int metadata, Random rand, int fortune){
			return Gemify.gemCyxanium;
			
		}

	}
