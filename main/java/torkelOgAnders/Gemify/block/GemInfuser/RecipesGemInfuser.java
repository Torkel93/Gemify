package torkelOgAnders.Gemify.block.GemInfuser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesGemInfuser {
	private static final RecipesGemInfuser gemInfuserBase = new RecipesGemInfuser();

	/** The list of smelting results. */
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final RecipesGemInfuser smelting() {
		return gemInfuserBase;
	}

	private RecipesGemInfuser()
    {
     // this.addSmeltingBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
      //this.addSmeltingItem(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
    }

	public void addSmeltingBlock(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.addSmeltingItem(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void addSmeltingItem(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.addSmelting(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void addSmelting(ItemStack inputstack, ItemStack outputstack, float exp)
    {
        this.smeltingList.put(inputstack, outputstack);
        this.experienceList.put(outputstack, Float.valueOf(exp));
    }


    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}