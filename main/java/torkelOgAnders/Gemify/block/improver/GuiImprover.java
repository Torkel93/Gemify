package torkelOgAnders.Gemify.block.improver;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiImprover extends GuiContainer{
	
	private TileEntityImprover tileImprover;
	private static final ResourceLocation texture = new ResourceLocation("gf:textures/gui/improvergui.png"); //guiTextures

	public GuiImprover(InventoryPlayer invPlayer, TileEntityImprover tile) {
		super(new ContainerImprover(invPlayer, tile));
		this.tileImprover = tile;
		
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileImprover.hasCustomInventoryName() ? this.tileImprover.getInventoryName() : I18n.format(this.tileImprover.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, 7, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(texture);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	        int i1;

	        if (this.tileImprover.isBurning())
	        {
	            i1 = this.tileImprover.getBurnTimeRemainingScaled(12);
	            this.drawTexturedModalRect(k + 17, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
	        }

	        i1 = this.tileImprover.getCookProgressScaled(24);
	        this.drawTexturedModalRect(k + 40, l + 34, 176, 14, i1 + 1, 16);
	}

}
