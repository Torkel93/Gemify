package torkelOgAnders.Gemify.item.EnderDiamond;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import torkelOgAnders.Gemify.Gemify;

public class EnderDiamondArmor extends ItemArmor {

	public EnderDiamondArmor(ArmorMaterial armorMaterial, int renderIndex,
			int armourType) {
		super(armorMaterial, renderIndex, armourType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (this.armorType == 2) {
			return "gf:textures/models/armor/enderdiamondarmor2.png";
		}
		return "gf:textures/models/armor/enderdiamondarmor1.png";
	}


	@Override
	public void onArmorTick(World world, EntityPlayer player,
		ItemStack itemstack) {

	// Checks if you are wearing the entire body of armor, remove sections
	// of statement below to get your result.

	if (player.getCurrentArmor(3) != null
			&& player.getCurrentArmor(2) != null
			&& player.getCurrentArmor(1) != null
			&& player.getCurrentArmor(0) != null) {

		ItemStack helmet = player.getCurrentArmor(3);

		ItemStack chestplate = player.getCurrentArmor(2);

		ItemStack leggings = player.getCurrentArmor(1);

		ItemStack boots = player.getCurrentArmor(0);

		if (helmet.getItem() == Gemify.enderDiamondHelm
				&& chestplate.getItem() == Gemify.enderDiamondChest
				&& leggings.getItem() == Gemify.enderDiamondLegs
				&& boots.getItem() == Gemify.enderDiamondBoots) {

			player.capabilities.allowFlying = true;
			player.fallDistance = 0.0F;

		}

	} else {

		player.capabilities.allowFlying = false;
		player.capabilities.isFlying = false;
		}
	}
}