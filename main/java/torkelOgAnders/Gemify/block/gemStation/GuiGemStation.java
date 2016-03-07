package torkelOgAnders.Gemify.block.gemStation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GuiGemStation extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation("gf:textures/gui/gemstationgui.png");
	public GuiGemStation(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerGemStation(invPlayer, world, x, y, z));
		// TODO Auto-generated constructor stub
	
		this.xSize = 176;
		this.ySize = 188;
	
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Gem Station"), 105, 10, 0x82ffd6);
		
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
