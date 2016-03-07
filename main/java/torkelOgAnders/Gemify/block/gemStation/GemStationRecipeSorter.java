package torkelOgAnders.Gemify.block.gemStation;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class GemStationRecipeSorter implements Comparator {

	final GemStationCraftingManager workSurface;

	public GemStationRecipeSorter(
			GemStationCraftingManager workSurfaceCraftingManager) {
		this.workSurface = workSurfaceCraftingManager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof GemStationShapelessRecipes && irecipe2 instanceof GemStationShapedRecipes ? 1: (irecipe2 instanceof GemStationShapelessRecipes && irecipe1 instanceof GemStationShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
