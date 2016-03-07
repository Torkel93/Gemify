package torkelOgAnders.Gemify.block.gemReinforcer;

	import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	public class ContainerGemReinforcer extends Container {
		
		private TileEntityGemReinforcer tileGemReinforcer;
		private int lastCookTime;
		private int lastBurnTime;
		private int lastItemBurnTime;
		
		public ContainerGemReinforcer(InventoryPlayer player, TileEntityGemReinforcer tileEntityFurnace){
			this.tileGemReinforcer = tileEntityFurnace;
			this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 30, 35));
			this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 120, 35));
			this.addSlotToContainer(new SlotFurnace(player.player, tileEntityFurnace, 2, 75, 35));
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
			craft.sendProgressBarUpdate(this, 0, this.tileGemReinforcer.furnaceCookTime);
			craft.sendProgressBarUpdate(this, 1, this.tileGemReinforcer.furnaceBurnTime);
			craft.sendProgressBarUpdate(this, 2, this.tileGemReinforcer.currentBurnTime);
		}
		
		public void detectAndSendChanges(){
			super.detectAndSendChanges();
			for(int i = 0; i < this.crafters.size(); ++i){
				ICrafting craft = (ICrafting) this.crafters.get(i);
				
				if(this.lastCookTime != this.tileGemReinforcer.furnaceCookTime){
					craft.sendProgressBarUpdate(this, 0, this.tileGemReinforcer.furnaceCookTime);
				}
				
				if(this.lastBurnTime != this.tileGemReinforcer.furnaceBurnTime){
					craft.sendProgressBarUpdate(this, 1, this.tileGemReinforcer.furnaceBurnTime);
				}
				
				if(this.lastItemBurnTime != this.tileGemReinforcer.currentBurnTime){
					craft.sendProgressBarUpdate(this, 2, this.tileGemReinforcer.currentBurnTime);
				}
			}
			
			this.lastBurnTime = this.tileGemReinforcer.furnaceBurnTime;
			this.lastCookTime = this.tileGemReinforcer.furnaceCookTime;
			this.lastItemBurnTime = this.tileGemReinforcer.currentBurnTime;
		}
		
		@SideOnly(Side.CLIENT)
		public void updateProgressBar(int par1, int par2){
			if(par1 == 0){
				this.tileGemReinforcer.furnaceCookTime = par2;
			}
			
			if(par1 == 1){
				this.tileGemReinforcer.furnaceBurnTime = par2;
			}
			
			if(par1 == 2){
				this.tileGemReinforcer.currentBurnTime = par2;
			}
		}
		
		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return this.tileGemReinforcer.isUseableByPlayer(player);
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
					if(RecipesGemReinforcer.smelting().getSmeltingResult(itemstack1) != null){
						if(!this.mergeItemStack(itemstack1, 0, 1, false)){
							return null;
						}
					}else if(TileEntityGemReinforcer.isItemFuel(itemstack1)){
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

