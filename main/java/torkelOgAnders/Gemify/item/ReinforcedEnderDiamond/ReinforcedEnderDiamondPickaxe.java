package torkelOgAnders.Gemify.item.ReinforcedEnderDiamond;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ReinforcedEnderDiamondPickaxe extends ItemPickaxe {
public int harvestlevel;
	public ReinforcedEnderDiamondPickaxe(ToolMaterial material) {
		super(material);
		}
	
	
	@Override
	 public boolean func_150897_b(Block p_150897_1_){
       return p_150897_1_ == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 0 : (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0);
	   }
	
   
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world,
    	   
			
			// which block was in the target when clicked
    	    int xCoord, int yCoord, int zCoord, 
    	    // where on the target block was clicked (0.0-1.0)
    	    int side, float blockx, float blocky, float blockz){
    	    
    	    
    	    if (player.isSneaking()){
			return false;
			}
    	    	
    	    
    	    //SetMiningArea
    	    int xInc = 3;	    	
	    	int yInc = 3;	    	
	    	int zInc = 3;
	    	
	    	int xDec = 2;
    	    int yDec = 2;    	   
    	    int zDec = 2;
    	    
    	    if (side != 0 || side != 1){
    	    yDec = 1;
    	    }
    	    
    	    int i = 0;    	    
    	    for (int x = xCoord -xDec; x < xCoord + xInc; x++)
                for (int y = yCoord -yDec; y < yCoord + yInc; y++)
                    for (int z = zCoord -zDec; z < zCoord +zInc; z++) {
                        if (world.getBlock(x, y, z) == Blocks.stone){
                        	world.setBlock(x, y, z, Blocks.air);
                        	//player.inventory.addItemStackToInventory(new ItemStack(Blocks.stone, 1));
                        	}
                        if (world.getBlock(x, y, z) == Blocks.dirt){
                        	world.setBlock(x, y, z, Blocks.air);
                        	//player.inventory.addItemStackToInventory(new ItemStack(Blocks.dirt, 1));
                        	}
                        if (world.getBlock(x, y, z) == Blocks.gravel){
                        	world.setBlock(x, y, z, Blocks.air);
                        	//player.inventory.addItemStackToInventory(new ItemStack(Blocks.gravel, 1));
                        	}
                        if (world.getBlock(x, y, z) == Blocks.grass){
                        	world.setBlock(x, y, z, Blocks.air);
                        	//player.inventory.addItemStackToInventory(new ItemStack(Blocks.grass, 1));
                        	}
                        	i++;
                    }	
    	    return i == 100;
    	    
    	}
	}

