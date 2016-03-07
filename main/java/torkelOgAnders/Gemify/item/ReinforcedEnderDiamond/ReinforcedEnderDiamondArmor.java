package torkelOgAnders.Gemify.item.ReinforcedEnderDiamond;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import torkelOgAnders.Gemify.Gemify;

public class ReinforcedEnderDiamondArmor extends ItemArmor {

	public ReinforcedEnderDiamondArmor(ArmorMaterial armorMaterial,
			int renderIndex, int armourType) {
		super(armorMaterial, renderIndex, armourType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {

		if (this.armorType == 2) {
			return "gf:textures/models/armor/gemreinforcedenderdiamondarmor2.png";
		}
		return "gf:textures/models/armor/gemreinforcedenderdiamondarmor1.png";
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

			if (helmet.getItem() == Gemify.reinforcedEnderDiamondHelm
					&& chestplate.getItem() == Gemify.reinforcedEnderDiamondChest
					&& leggings.getItem() == Gemify.reinforcedEnderDiamondLegs
					&& boots.getItem() == Gemify.reinforcedEnderDiamondBoots) {

				player.capabilities.allowFlying = true;
				player.capabilities.disableDamage = true;

			}

		} else {

			player.capabilities.allowFlying = false;
			player.capabilities.disableDamage = false;
			player.capabilities.isFlying = false;
		}
		
		if (player.getCurrentArmor(0) != null) {
			ItemStack boots = player.getCurrentArmor(0);
			if (boots.getItem() == Gemify.reinforcedEnderDiamondBoots) {
				player.fallDistance = 0.0f;
				player.capabilities.setPlayerWalkSpeed(0.25F);
				player.capabilities.setFlySpeed(0.2F);
				player.stepHeight = 3;
				//player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 200));
			}	
		} else {
		player.capabilities.setPlayerWalkSpeed(0.1F);
		player.capabilities.setFlySpeed(0.05F);
		player.stepHeight = 0.5F;
		}
		
		if (player.getCurrentArmor(3) != null) {
			ItemStack helm = player.getCurrentArmor(3);
			if (helm.getItem() == Gemify.reinforcedEnderDiamondHelm) {
				//player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 100));
				//player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 100));
				

			}
		}
		if (player.getCurrentArmor(1) != null) {
			ItemStack legs = player.getCurrentArmor(1);
			if (legs.getItem() == Gemify.reinforcedEnderDiamondLegs) {
				player.stepHeight = 3;
				//player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 200));
			}	
		} else {
		player.stepHeight = 0.5F;
		}
	}
}
