package torkelOgAnders.Gemify;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import torkelOgAnders.Gemify.block.GemCrystalizer.ContainerGemCrystalizer;
import torkelOgAnders.Gemify.block.GemCrystalizer.GuiGemCrystalizer;
import torkelOgAnders.Gemify.block.GemCrystalizer.TileEntityGemCrystalizer;
import torkelOgAnders.Gemify.block.GemInfuser.ContainerGemInfuser;
import torkelOgAnders.Gemify.block.GemInfuser.GuiGemInfuser;
import torkelOgAnders.Gemify.block.GemInfuser.TileEntityGemInfuser;
import torkelOgAnders.Gemify.block.gemReinforcer.ContainerGemReinforcer;
import torkelOgAnders.Gemify.block.gemReinforcer.GuiGemReinforcer;
import torkelOgAnders.Gemify.block.gemReinforcer.TileEntityGemReinforcer;
import torkelOgAnders.Gemify.block.gemStation.ContainerGemStation;
import torkelOgAnders.Gemify.block.gemStation.GuiGemStation;
import torkelOgAnders.Gemify.block.improver.ContainerImprover;
import torkelOgAnders.Gemify.block.improver.GuiImprover;
import torkelOgAnders.Gemify.block.improver.TileEntityImprover;
import torkelOgAnders.Gemify.block.seperator.ContainerSeperator;
import torkelOgAnders.Gemify.block.seperator.GuiSeperator;
import torkelOgAnders.Gemify.block.seperator.TileEntitySeperator;
import torkelOgAnders.Gemify.block.shardCombiner.ContainerShardCombiner;
import torkelOgAnders.Gemify.block.shardCombiner.GuiShardCombiner;
import torkelOgAnders.Gemify.block.smelter.ContainerSmelter;
import torkelOgAnders.Gemify.block.smelter.GuiSmelter;
import torkelOgAnders.Gemify.block.smelter.TileEntitySmelter;
import cpw.mods.fml.common.network.IGuiHandler;

public class GIGuiHandler implements IGuiHandler {
	 
	public GIGuiHandler (){
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if(ID == 0){
			TileEntityGemInfuser tileEntityFurnace = (TileEntityGemInfuser) world.getTileEntity(x, y, z);
			return new ContainerGemInfuser(player.inventory, tileEntityFurnace);
		}
		if(ID == 1){
			TileEntityGemCrystalizer tileEntityFurnace = (TileEntityGemCrystalizer) world.getTileEntity(x, y, z);
			return new ContainerGemCrystalizer(player.inventory, tileEntityFurnace);
		}
		if(ID == 2){
			TileEntityGemReinforcer tileEntityFurnace = (TileEntityGemReinforcer) world.getTileEntity(x, y, z);
			return new ContainerGemReinforcer(player.inventory, tileEntityFurnace);
		}
		if(ID == 3) {
			return ID == 3 && world.getBlock(x, y, z) == Gemify.machineGemStation ? new ContainerGemStation(player.inventory, world, x, y, z) : null;
		}
		if(ID == 4) {
			return ID == 4 && world.getBlock(x, y, z) == Gemify.machineShardCombiner ? new ContainerShardCombiner(player.inventory, world, x, y, z) : null;
		}
		if(ID == 5){
			TileEntitySeperator tileEntityFurnace = (TileEntitySeperator) world.getTileEntity(x, y, z);
			return new ContainerSeperator(player.inventory, tileEntityFurnace);
		}
		
		if(ID == 6){
			TileEntityImprover tileEntityFurnace = (TileEntityImprover) world.getTileEntity(x, y, z);
			return new ContainerImprover(player.inventory, tileEntityFurnace);
		}
		
		if(ID == 7){
			TileEntitySmelter tileEntityFurnace = (TileEntitySmelter) world.getTileEntity(x, y, z);
			return new ContainerSmelter(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityGemInfuser tileEntityTestContainer = (TileEntityGemInfuser) world.getTileEntity(x, y, z);
			return new GuiGemInfuser(player.inventory, tileEntityTestContainer);
		}
		if(ID == 1){
			TileEntityGemCrystalizer tileEntityTestContainer = (TileEntityGemCrystalizer) world.getTileEntity(x, y, z);
			return new GuiGemCrystalizer(player.inventory, tileEntityTestContainer);
		}
		if(ID == 2){
			TileEntityGemReinforcer tileEntityTestContainer = (TileEntityGemReinforcer) world.getTileEntity(x, y, z);
			return new GuiGemReinforcer(player.inventory, tileEntityTestContainer);
		}
		if(ID == 3) {
			return ID == 3 && world.getBlock(x, y, z) == Gemify.machineGemStation ? new GuiGemStation(player.inventory, world, x, y, z) : null;
		}
		if(ID == 4) {
			return ID == 4 && world.getBlock(x, y, z) == Gemify.machineShardCombiner ? new GuiShardCombiner(player.inventory, world, x, y, z) : null;
		}
		if(ID == 5){
			TileEntitySeperator tileEntityTestContainer = (TileEntitySeperator) world.getTileEntity(x, y, z);
			return new GuiSeperator(player.inventory, tileEntityTestContainer);
		}
		
		if(ID == 6){
			TileEntityImprover tileEntityTestContainer = (TileEntityImprover) world.getTileEntity(x, y, z);
			return new GuiImprover(player.inventory, tileEntityTestContainer);
		}
		
		if(ID == 7){
			TileEntitySmelter tileEntityTestContainer = (TileEntitySmelter) world.getTileEntity(x, y, z);
			return new GuiSmelter(player.inventory, tileEntityTestContainer);
		}
		return null;
	}
}
