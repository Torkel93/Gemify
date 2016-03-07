package torkelOgAnders.Gemify.item.NetherRadium;

import net.minecraft.item.ItemSword;

public class NetherRadiumSword extends ItemSword {

	public NetherRadiumSword(ToolMaterial material) {
		super(material);
		this.setMaxDamage(getMaxDamage());
	}
}
