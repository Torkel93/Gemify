package torkelOgAnders.Gemify.block.shardCombiner;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class ShardCombinerRecipeSorter implements Comparator {

	final ShardCombinerCraftingManager workSurface;

	public ShardCombinerRecipeSorter(
			ShardCombinerCraftingManager workSurfaceCraftingManager) {
		this.workSurface = workSurfaceCraftingManager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof ShardCombinerShapelessRecipes && irecipe2 instanceof ShardCombinerShapedRecipes ? 1: (irecipe2 instanceof ShardCombinerShapelessRecipes && irecipe1 instanceof ShardCombinerShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
