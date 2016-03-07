package torkelOgAnders.Gemify.block.GemCrystalizer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGemCrystalizer extends Container {
	
	private TileEntityGemCrystalizer tileGemCrystalizer;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public ContainerGemCrystalizer(InventoryPlayer player, TileEntityGemCrystalizer tileEntityFurnace){
		this.tileGemCrystalizer = tileEntityFurnace;
		this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(player.player, tileEntityFurnace, 2, 116, 35));
		int i;
		
		for(i = 0; i < 3; ++i){
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(player, i , 8 + i * 18 , 142));
		}
	}

	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.tileGemCrystalizer.furnaceCookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileGemCrystalizer.furnaceBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileGemCrystalizer.currentBurnTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.tileGemCrystalizer.furnaceCookTime){
				craft.sendProgressBarUpdate(this, 0, this.tileGemCrystalizer.furnaceCookTime);
			}
			
			if(this.lastBurnTime != this.tileGemCrystalizer.furnaceBurnTime){
				craft.sendProgressBarUpdate(this, 1, this.tileGemCrystalizer.furnaceBurnTime);
			}
			
			if(this.lastItemBurnTime != this.tileGemCrystalizer.currentBurnTime){
				craft.sendProgressBarUpdate(this, 2, this.tileGemCrystalizer.currentBurnTime);
			}
		}
		
		this.lastBurnTime = this.tileGemCrystalizer.furnaceBurnTime;
		this.lastCookTime = this.tileGemCrystalizer.furnaceCookTime;
		this.lastItemBurnTime = this.tileGemCrystalizer.currentBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileGemCrystalizer.furnaceCookTime = par2;
		}
		
		if(par1 == 1){
			this.tileGemCrystalizer.furnaceBurnTime = par2;
		}
		
		if(par1 == 2){
			this.tileGemCrystalizer.currentBurnTime = par2;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileGemCrystalizer.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(RecipesGemCrystalizer.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityGemCrystalizer.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(par2 >=3 && par2 < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}

}
