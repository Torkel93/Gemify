package torkelOgAnders.Gemify;
  
	 import torkelOgAnders.Gemify.block.GemCrystalizer.TileEntityGemCrystalizer;
import torkelOgAnders.Gemify.block.GemInfuser.TileEntityGemInfuser;
import torkelOgAnders.Gemify.block.gemReinforcer.TileEntityGemReinforcer;
import torkelOgAnders.Gemify.block.improver.TileEntityImprover;
import torkelOgAnders.Gemify.block.multiblock.TileStabilizerMultiblock;
import torkelOgAnders.Gemify.block.seperator.TileEntitySeperator;
import torkelOgAnders.Gemify.block.smelter.TileEntitySmelter;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
	  
	  public class ServerProxy {
	  
	  	public void registerRenderThings() {
	  
	  	}
	  
	  	public int addArmor(String armor) {
	  		return 0;
	  	}
	  	
	  	public void registerNetworkStuff(){
	  		NetworkRegistry.INSTANCE.registerGuiHandler(Gemify.modInstance, new GIGuiHandler());
	  	}
	  
	 	public void registerTileEntities(){
			GameRegistry.registerTileEntity(TileEntityGemInfuser.class, "gf:GemInfuser");
			GameRegistry.registerTileEntity(TileEntityGemCrystalizer.class, "gf:GemCrystalizer");
			GameRegistry.registerTileEntity(TileEntityGemReinforcer.class, "gf:GemReinforcer");
			GameRegistry.registerTileEntity(TileEntitySeperator.class, "gf:Seperator");
			GameRegistry.registerTileEntity(TileEntityImprover.class, "gf:Improver");
			GameRegistry.registerTileEntity(TileEntitySmelter.class, "gf:Smelter");
			GameRegistry.registerTileEntity(TileStabilizerMultiblock.class, "gf:MultiBlockStabilizer");
		}
	 }

