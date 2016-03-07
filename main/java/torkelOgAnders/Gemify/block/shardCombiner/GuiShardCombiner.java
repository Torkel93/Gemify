package torkelOgAnders.Gemify.block.shardCombiner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GuiShardCombiner extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation("gf:textures/gui/shardcombinergui.png");
	public GuiShardCombiner(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerShardCombiner(invPlayer, world, x, y, z));
		// TODO Auto-generated constructor stub
	
		this.xSize = 175;
		this.ySize = 138;
	
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Shard Combiner"), 90, 5, 0x000000);
		
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
