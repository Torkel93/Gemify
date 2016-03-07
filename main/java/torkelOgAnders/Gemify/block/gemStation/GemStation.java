package torkelOgAnders.Gemify.block.gemStation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import torkelOgAnders.Gemify.Gemify;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GemStation extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon workSurfaceTop;
	
	public GemStation() {
		super(Material.wood);
		
		this.setHardness(3.5F);
		this.setResistance(5.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		return side == 1 ? this.workSurfaceTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("gf:gemstation");
		this.workSurfaceTop = iconRegister.registerIcon("gf:gemstationtop");
	}
	
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		
		if (!player.isSneaking()) {
			player.openGui(Gemify.modInstance, 3, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
}
