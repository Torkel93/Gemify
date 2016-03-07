package torkelOgAnders.Gemify.block.gemReinforcer;
	import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	@SideOnly(Side.CLIENT)
	public class GuiGemReinforcer extends GuiContainer{
		
		private TileEntityGemReinforcer tileGemReinforcer;
		private static final ResourceLocation texture = new ResourceLocation("gf:textures/gui/gemreinforcergui.png"); //guiTextures

		public GuiGemReinforcer(InventoryPlayer invPlayer, TileEntityGemReinforcer tile) {
			super(new ContainerGemReinforcer(invPlayer, tile));
			this.tileGemReinforcer = tile;
			
		}
		
		protected void drawGuiContainerForegroundLayer(int par1, int par2){
			String string = this.tileGemReinforcer.hasCustomInventoryName() ? this.tileGemReinforcer.getInventoryName() : I18n.format(this.tileGemReinforcer.getInventoryName(), new Object[0]);
			this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
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

		        if (this.tileGemReinforcer.isBurning())
		        {
		            
		        }

		        i1 = this.tileGemReinforcer.getCookProgressScaled(23);
		        this.drawTexturedModalRect(k + 97, l + 34, 176, 14, 23, 16);
		        
		        i1 = this.tileGemReinforcer.getCookProgressScaled(23);
		        this.drawTexturedModalRect(k + 97, l + 34, 176, 0, 23-i1, 16);

	    i1 = this.tileGemReinforcer.getCookProgressScaled(23);
	    this.drawTexturedModalRect(k + 47, l + 34, 176, 14, i1 + 1, 16);
		}

	}

