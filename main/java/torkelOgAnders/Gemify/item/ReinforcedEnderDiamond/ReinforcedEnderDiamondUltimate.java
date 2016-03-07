package torkelOgAnders.Gemify.item.ReinforcedEnderDiamond;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ReinforcedEnderDiamondUltimate extends ItemPickaxe {

	public ReinforcedEnderDiamondUltimate(ToolMaterial material) {
		super(material);
		
	}	
	
	@Override
	 public boolean func_150897_b(Block p_150897_1_){
      return p_150897_1_ == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 0 : (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0) : this.toolMaterial.getHarvestLevel() >= 0);
	 }
	
	@Override
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock && p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.sand && p_150893_2_.getMaterial() != Material.cactus && p_150893_2_.getMaterial() != Material.snow && p_150893_2_.getMaterial() != Material.clay && p_150893_2_.getMaterial() != Material.glass && p_150893_2_.getMaterial() != Material.grass && p_150893_2_.getMaterial() != Material.ground && p_150893_2_.getMaterial() != Material.leaves && p_150893_2_.getMaterial() != Material.piston && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.cloth && p_150893_2_.getMaterial() != Material.carpet && p_150893_2_.getMaterial() != Material.web ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
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
   	    int xInc = 6;	    	
	    int yInc = 6;	    	
	    int zInc = 6;
	    
	    int xDec = 5;
   	    int yDec = 5;    	   
   	    int zDec = 5;
   	    
   	    int i = 0;    	    
   	    //remove comments to get loot
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
                       if (world.getBlock(x, y, z) == Blocks.sand){
                          	world.setBlock(x, y, z, Blocks.air);
                          	//player.inventory.addItemStackToInventory(new ItemStack(Blocks.sand, 1));
                          	}
                       if (world.getBlock(x, y, z) == Blocks.sandstone){
                         	world.setBlock(x, y, z, Blocks.air);
                         	//player.inventory.addItemStackToInventory(new ItemStack(Blocks.sandstone, 1));
                         	}
                       	i++;
                   }	
   	    return i == 100;
   	    
   	}
	
	
}

