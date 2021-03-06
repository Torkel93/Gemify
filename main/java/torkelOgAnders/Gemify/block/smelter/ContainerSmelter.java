package torkelOgAnders.Gemify.block.smelter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import torkelOgAnders.Gemify.block.UpgradeSlot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerSmelter extends Container {
	
	private TileEntitySmelter tileSmelter;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public ContainerSmelter(InventoryPlayer player, TileEntitySmelter tileEntityFurnace){
		this.tileSmelter = tileEntityFurnace;
		this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 17, 17));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 17, 53));
		this.addSlotToContainer(new SlotFurnace(player.player,tileEntityFurnace, 2, 77, 35));
		this.addSlotToContainer(new SlotFurnace(player.player,tileEntityFurnace, 3, 107, 35));
		this.addSlotToContainer(new SlotFurnace(player.player, tileEntityFurnace, 4, 137, 35));
		this.addSlotToContainer(new UpgradeSlot(tileEntityFurnace, 5, 155, 5));
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
		craft.sendProgressBarUpdate(this, 0, this.tileSmelter.furnaceCookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileSmelter.furnaceBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileSmelter.currentBurnTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.tileSmelter.furnaceCookTime){
				craft.sendProgressBarUpdate(this, 0, this.tileSmelter.furnaceCookTime);
			}
			
			if(this.lastBurnTime != this.tileSmelter.furnaceBurnTime){
				craft.sendProgressBarUpdate(this, 1, this.tileSmelter.furnaceBurnTime);
			}
			
			if(this.lastItemBurnTime != this.tileSmelter.currentBurnTime){
				craft.sendProgressBarUpdate(this, 2, this.tileSmelter.currentBurnTime);
			}
			
		}
		
		this.lastBurnTime = this.tileSmelter.furnaceBurnTime;
		this.lastCookTime = this.tileSmelter.furnaceCookTime;
		this.lastItemBurnTime = this.tileSmelter.currentBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileSmelter.furnaceCookTime = par2;
		}
		
		if(par1 == 1){
			this.tileSmelter.furnaceBurnTime = par2;
		}
		
		if(par1 == 2){
			this.tileSmelter.currentBurnTime = par2;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileSmelter.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2 || par2 == 3 || par2 == 4 || par2 == 5){ //changed in par2 == 3 & par2 == 4
				if(!this.mergeItemStack(itemstack1, 6, 42, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntitySmelter.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(par2 >=5 && par2 < 33){
					if(!this.mergeItemStack(itemstack1, 32, 41, false)){
						return null;
					}
				}else if(par2 >= 32 && par2 < 41 && !this.mergeItemStack(itemstack1, 6, 32, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 6, 42, false)){
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
