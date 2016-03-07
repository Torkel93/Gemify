package torkelOgAnders.Gemify.block.seperator;



import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import torkelOgAnders.Gemify.Gemify;
import torkelOgAnders.Gemify.block.improver.TileEntityImprover;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntitySeperator extends TileEntity implements ISidedInventory {

	
	private static final int[] slotsTop = new int[] { 0 };
	private static final int[] slotsBottom = new int[] {5, 4, 3, 2, 1 };
	private static final int[] slotsSides = new int[] { 1 };

	public ItemStack[] furnaceItemStacks = new ItemStack[6];

	public int furnaceBurnTime;
	public int currentBurnTime;
	public int furnaceCookTime;
	
	private String furnaceName;

	public void furnaceName(String string){
		this.furnaceName = string;
	}
	
	@Override
	public int getSizeInventory() {
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.furnaceItemStacks[slot];
	}

	public int getUpgrades(){
		
		int upgrades = 0;
		int maxupgrades = 10;
		if (this.furnaceItemStacks[5] == null) return upgrades;
		if (this.furnaceItemStacks[5].getItem() == Gemify.speedUpgrade){
			upgrades = this.furnaceItemStacks[5].stackSize;
			if(upgrades >= maxupgrades){
				upgrades = maxupgrades;
			}
		}
		
		return upgrades;
	}
	
	public int getSmeltTime(){
		return 200 - (this.getUpgrades()*19);
	}
	
	
	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.furnaceItemStacks[par1] != null) {
			ItemStack itemstack;
			if (this.furnaceItemStacks[par1].stackSize <= par2) {
				itemstack = this.furnaceItemStacks[par1];
				this.furnaceItemStacks[par1] = null;
				return itemstack;
			} else {
				itemstack = this.furnaceItemStacks[par1].splitStack(par2);

				if (this.furnaceItemStacks[par1].stackSize == 0) {
					this.furnaceItemStacks[par1] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.furnaceItemStacks[slot] != null) {
			ItemStack itemstack = this.furnaceItemStacks[slot];
			this.furnaceItemStacks[slot] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.furnaceItemStacks[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.furnaceName : "Seperator";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.furnaceName != null && this.furnaceName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tabCompound1 = tagList.getCompoundTagAt(i);
			byte byte0 = tabCompound1.getByte("Slot");

			if (byte0 >= 0 && byte0 < this.furnaceItemStacks.length) {
				this.furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tabCompound1);
			}
		}

		this.furnaceBurnTime = tagCompound.getShort("BurnTime");
		this.furnaceCookTime = tagCompound.getShort("CookTime");
		this.currentBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

	if (tagCompound.hasKey("CustomName", 8)) {
			this.furnaceName = tagCompound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setShort("BurnTime", (short) this.furnaceBurnTime);
		tagCompound.setShort("CookTime", (short) this.furnaceCookTime);
		NBTTagList tagList = new NBTTagList();

		for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
			if (this.furnaceItemStacks[i] != null) {
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setByte("Slot", (byte) i);
				this.furnaceItemStacks[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}

		tagCompound.setTag("Items", tagList);

		if (this.hasCustomInventoryName()) {
			tagCompound.setString("CustomName", this.furnaceName);
		}
	}

	@SideOnly(Side.CLIENT)
public int getCookProgressScaled(int par1) {
		return this.furnaceCookTime * par1 / this.getSmeltTime();
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentBurnTime <= 0) {
			this.currentBurnTime = this.getSmeltTime();
		}

		return this.furnaceBurnTime * par1 / this.currentBurnTime;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	public void updateEntity() {
		boolean flag = this.furnaceBurnTime > 0;
		boolean flag1 = false;
		
		

		if (this.furnaceBurnTime > 0 && this.furnaceCookTime >= 1) {
			this.furnaceBurnTime -= this.getUpgrades()+1;
		}

		if (!this.worldObj.isRemote) {
			checkForMachines();
			if (this.furnaceBurnTime <= 0 && this.canSmelt()) {
				this.currentBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

				if (this.furnaceBurnTime > 0) {
					flag1 = true;
					if (this.furnaceItemStacks[1] != null) {
						--this.furnaceItemStacks[1].stackSize;

						if (this.furnaceItemStacks[1].stackSize == 0) {
							this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.furnaceCookTime;
				if (this.furnaceCookTime >= this.getSmeltTime()) {
					this.furnaceCookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			} else {
				this.furnaceCookTime = 0;
			}
		}

		if (flag != this.furnaceBurnTime > 0) {
			flag1 = true;
			Seperator.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}

		if (flag1) {
			this.markDirty();
		}
	}

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = RecipesSeperator.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			if (itemstack == null) return false;
			if (this.furnaceItemStacks[2] == null || this.furnaceItemStacks[3] == null || this.furnaceItemStacks[4] == null) return true;
			if (!this.furnaceItemStacks[2].isItemEqual(itemstack) && !this.furnaceItemStacks[3].isItemEqual(itemstack)) return false;
			int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
			int result2 = furnaceItemStacks[3].stackSize + itemstack.stackSize;
			int result3 = furnaceItemStacks[4].stackSize + itemstack.stackSize;
			return (result <= this.furnaceItemStacks[2].getMaxStackSize()) || (result2 <= this.furnaceItemStacks[3].getMaxStackSize()) || (result3 <= this.furnaceItemStacks[4].getMaxStackSize());
		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack = RecipesSeperator.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

			if (this.furnaceItemStacks[2] == null) {
				this.furnaceItemStacks[2] = itemstack.copy();
			} else if (this.furnaceItemStacks[2].getItem() == itemstack.getItem() && this.furnaceItemStacks[2].stackSize + itemstack.stackSize <= this.furnaceItemStacks[2].getMaxStackSize()) {
				this.furnaceItemStacks[2].stackSize += itemstack.stackSize;
			}
			else if (this.furnaceItemStacks[3] == null) {
				this.furnaceItemStacks[3] = itemstack.copy();
			}
			else if (this.furnaceItemStacks[3].getItem() == itemstack.getItem() && this.furnaceItemStacks[3].stackSize + itemstack.stackSize <= this.furnaceItemStacks[3].getMaxStackSize()) {
				this.furnaceItemStacks[3].stackSize += itemstack.stackSize;
			}
			else if (this.furnaceItemStacks[4] == null) {
				this.furnaceItemStacks[4] = itemstack.copy();
			}
			else if (this.furnaceItemStacks[4].getItem() == itemstack.getItem() && this.furnaceItemStacks[4].stackSize + itemstack.stackSize <= this.furnaceItemStacks[4].getMaxStackSize()) {
				this.furnaceItemStacks[4].stackSize += itemstack.stackSize;
			}
			
			--this.furnaceItemStacks[0].stackSize;

			if(this.furnaceItemStacks[0].stackSize <= 0){
				this.furnaceItemStacks[0] = null;
			}
		}
	}
	
	
	public int ejectItems(int slot, int x, int y, int z){
		
			TileEntityImprover machine = (TileEntityImprover) worldObj.getTileEntity(x, y, z);
			
			ItemStack outitemstack = this.getStackInSlot(slot);
			if (this.furnaceItemStacks[slot] != null){
			if (machine.furnaceItemStacks[0] == null) {
					machine.furnaceItemStacks[0] = outitemstack.copy();
					outitemstack.stackSize = 0;
					if(this.furnaceItemStacks[slot].stackSize <= 0){
						this.furnaceItemStacks[slot] = null;
					}
					return machine.furnaceItemStacks[0].stackSize;
				}
				else if (outitemstack.getItem() == machine.furnaceItemStacks[0].getItem() && machine.furnaceItemStacks[0].stackSize <= 63 && this.furnaceItemStacks[slot] != null) {
					
						int hvormye = 64 - machine.furnaceItemStacks[0].stackSize;
						if (outitemstack.stackSize <= hvormye){
							hvormye = outitemstack.stackSize;
						}
						machine.furnaceItemStacks[0].stackSize += hvormye;
						outitemstack.stackSize -= hvormye;	
						if(this.furnaceItemStacks[slot].stackSize <= 0){
							this.furnaceItemStacks[slot] = null;
						}
						return machine.furnaceItemStacks[0].stackSize;
					}	
				}	
			
		
		return 64;
	}	
	
	public void checkForMachines(){
		
		for(int x = this.xCoord -1; x <= this.xCoord +2; x += 2) {
			if (checkForMachine(x, this.yCoord, this.zCoord)) {
				if (ejectItems(2, x, this.yCoord, this.zCoord) <= 64){
					if (ejectItems(3, x, this.yCoord, this.zCoord) <= 64){
						ejectItems(4, x, this.yCoord, this.zCoord);
					}
				}
			}
		}
		for (int z = this.zCoord -1; z <= this.zCoord +2; z += 2){
			if (checkForMachine(this.xCoord, this.yCoord, z)) {
				if (ejectItems(2, this.xCoord, this.yCoord, z) <= 64){
					if (ejectItems(3, this.xCoord, this.yCoord, z) <= 64){
						ejectItems(4, this.xCoord, this.yCoord, z);
				
					}
				}
			}
		}	
	}
	
	public boolean checkForMachine(int x, int y, int z){
		
		Block block = worldObj.getBlock(x, y, z);
		if (block == Gemify.machineImprover || block == Gemify.machineImproverActive){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	//Sette burntime
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
				Block block = Block.getBlockFromItem(item);
				
				//if(block == Blocks.iron_ore){
				//	return 50;
				//}
				
				//if(block.getMaterial() == Material.rock){
					//return 300;
				//}
			}
			
			if(item == Items.coal) return 1600;
			if(item == Gemify.gemInfusedCoal) return 54400;
			// if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("EMERALD")) return 300;
			return GameRegistry.getFuelValue(itemstack);
		}
	}
	//
	

	
	
	
	
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {
		return par1 == 2 ? false : par1 == 3 ? false : par1 == 4 ? false : par1 == 5 ? false : (par1 == 1 ? isItemFuel(itemstack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack itemstack, int par3) {
		return this.isItemValidForSlot(par1, itemstack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
		return par3 != 0 || par1 != 1 || itemstack.getItem() == Items.bucket;
	}

}