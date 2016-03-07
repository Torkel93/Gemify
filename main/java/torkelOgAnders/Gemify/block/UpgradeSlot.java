package torkelOgAnders.Gemify.block;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import torkelOgAnders.Gemify.Gemify;

public class UpgradeSlot extends Slot {

	public UpgradeSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_,
			int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack)
    {
		if (itemstack.getItem() == Gemify.speedUpgrade) return true;
        return false;
    }
	
	@Override
    public int getSlotStackLimit()
    {
        return 10;
    }
}
