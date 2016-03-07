package torkelOgAnders.Gemify;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import torkelOgAnders.Gemify.block.gemStation.GemStationCraftingManager;
import torkelOgAnders.Gemify.block.shardCombiner.ShardCombinerCraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void loadRecipes() {
		
		//Registrere Recipes		
		
		//Blocks
		
		
		GameRegistry.addRecipe(new ItemStack(Gemify.blockExynite, 1), new Object[]{"III",
			 																	   "III",
			 																	   "III", 'I', Gemify.ingotExynite});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.blockCyxanium, 1), new Object[]{"III",
			 																 		"III",
			 																 		"III", 'I', Gemify.ingotCyxanium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.blockNetherRadium, 1), new Object[]{"III",
																						"III",
																						"III", 'I', Gemify.ingotNetherRadium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.blockEnderDiamond, 1), new Object[]{"III",
																				 		"III",
																				 		"III", 'I', Gemify.ingotEnderDiamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.blockReinforcedEnderDiamond, 1), new Object[]{"III",
				 																				  "III",
				 																				  "III", 'I', Gemify.ingotReinforcedEnderDiamond});
		
		//Reingot
		GameRegistry.addShapelessRecipe(new ItemStack(Gemify.ingotExynite, 9), new ItemStack(Gemify.blockExynite, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Gemify.ingotCyxanium, 9), new ItemStack(Gemify.blockCyxanium, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Gemify.ingotNetherRadium, 9), new ItemStack(Gemify.blockNetherRadium, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Gemify.ingotEnderDiamond, 9), new ItemStack(Gemify.blockEnderDiamond, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Gemify.ingotReinforcedEnderDiamond, 9), new ItemStack(Gemify.blockReinforcedEnderDiamond, 1));
		
		//Machines
		GameRegistry.addRecipe(new ItemStack(Gemify.machineGemStation, 1), new Object[]{"EEE",
																						"X X",
																						"X X", 'E', Gemify.ingotEnderDiamond, 'X', Gemify.ingotExynite});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.machineShardCombiner, 1), new Object[]{"EEE",
			"X X",
			"X X", 'E', Items.iron_ingot, 'X', Items.gold_ingot});
		
		
		GameRegistry.addRecipe(new ItemStack(Gemify.machineGemCrystalizer, 1), new Object[]{"IGI",
			 																	            "DED",
			 																	            "IDI", 'I', Blocks.iron_block, 'G', Blocks.gold_block, 'D', Blocks.diamond_block, 'E', Blocks.emerald_block});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.machineGemInfuser, 1), new Object[]{"IGI",
	            "DED",
	            "IDI", 'I', Blocks.iron_block, 'G', Gemify.ingotNetherRadium, 'D', Gemify.blockCyxanium, 'E', Gemify.blockExynite});

		
		GameRegistry.addRecipe(new ItemStack(Gemify.machineSmelter, 1), new Object[]{" D ",
	            																	 "DGD",
	            																	 " D ", 'G', Blocks.gold_block, 'D', Gemify.diamondFrame});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.machineImprover, 1), new Object[]{" D ",
																					  "DGD",
																					  " D ", 'G', Blocks.diamond_block, 'D', Gemify.diamondFrame});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.machineSeperator, 1), new Object[]{" D ",
			 																		   "DGD",
			 																		   " D ", 'G', Gemify.blockCyxanium, 'D', Gemify.diamondFrame});


		
		//Other
		GameRegistry.addRecipe(new ItemStack(Gemify.blockStabilizer, 4), new Object[]{"ECE",
																			   		  "ENE",
																			   		  "ECE", 'E', Gemify.ingotExynite, 'C', Gemify.ingotCyxanium, 'N', Gemify.ingotNetherRadium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.diamondFrame, 2), new Object[]{"DID",
	   		  																	   "IDI",
	   		  																	   "DID", 'D', Items.diamond, 'I', Items.iron_ingot});
	
		
		//Cyxanium Gear&Tools
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumPickaxe, 1), new Object[]{"CCC",
			   																   		  " D ",
			   																   		  " D ", 'C', Gemify.ingotCyxanium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumSword, 1), new Object[]{" C ",
			   																		" C ",
			   																		" D ", 'C', Gemify.ingotCyxanium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumSpade, 1), new Object[]{" C ",
			   																		" D ",
			   																		" D ", 'C', Gemify.ingotCyxanium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumAxe, 1), new Object[]{" CC",
																				  " DC",
																				  " D ", 'C', Gemify.ingotCyxanium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumAxe, 1), new Object[]{"CC ",
			  																	  "CD ",
			  																	  " D ", 'C', Gemify.ingotCyxanium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumHelm, 1), new Object[]{"CCC",
			  																	   "C C",
			  																	   "   ", 'C', Gemify.ingotCyxanium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumChest, 1), new Object[]{"C C",
																					"CCC",
																					"CCC", 'C', Gemify.ingotCyxanium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumLegs, 1), new Object[]{"CCC",
			  																	   "C C",
			  																	   "C C", 'C', Gemify.ingotCyxanium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.cyxaniumBoots, 1), new Object[]{"   ",
			  																		"C C",
			  																		"C C", 'C', Gemify.ingotCyxanium});
		
		//Nether Radium Gear&Tools
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumPickaxe, 1), new Object[]{"CCC",
			   																   		      " D ",
			   																   		      " D ", 'C', Gemify.ingotNetherRadium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumSword, 1), new Object[]{" C ",
			   																		    " C ",
			   																		    " D ", 'C', Gemify.ingotNetherRadium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumSpade, 1), new Object[]{" C ",
			   																		    " D ",
			   																		    " D ", 'C', Gemify.ingotNetherRadium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumAxe, 1), new Object[]{" CC",
																				      " DC",
																				      " D ", 'C', Gemify.ingotNetherRadium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumAxe, 1), new Object[]{"CC ",
			  																	      "CD ",
			  																	      " D ", 'C', Gemify.ingotNetherRadium, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumHelm, 1), new Object[]{"CCC",
			  																	       "C C",
			  																	       "   ", 'C', Gemify.ingotNetherRadium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumChest, 1), new Object[]{"C C",
																					    "CCC",
																					    "CCC", 'C', Gemify.ingotNetherRadium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumLegs, 1), new Object[]{"CCC",
			  																	   	   "C C",
			  																	   	   "C C", 'C', Gemify.ingotNetherRadium});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.netherRadiumBoots, 1), new Object[]{"   ",
			  																		    "C C",
			  																		    "C C", 'C', Gemify.ingotNetherRadium});
		
		//Ender Diamond Gear&Tools
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondPickaxe, 1), new Object[]{"CCC",
			   																   		      " D ",
			   																   		      " D ", 'C', Gemify.ingotEnderDiamond, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondSword, 1), new Object[]{" C ",
			   																		    " C ",
			   																		    " D ", 'C', Gemify.ingotEnderDiamond, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondSpade, 1), new Object[]{" C ",
			   																		    " D ",
			   																		    " D ", 'C', Gemify.ingotEnderDiamond, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondAxe, 1), new Object[]{" CC",
																				      " DC",
																				      " D ", 'C', Gemify.ingotEnderDiamond, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondAxe, 1), new Object[]{"CC ",
			  																	      "CD ",
			  																	      " D ", 'C', Gemify.ingotEnderDiamond, 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondHelm, 1), new Object[]{"CCC",
			  																	       "C C",
			  																	       "   ", 'C', Gemify.ingotEnderDiamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondChest, 1), new Object[]{"C C",
																					    "CCC",
																					    "CCC", 'C', Gemify.ingotEnderDiamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondLegs, 1), new Object[]{"CCC",
			  																	   	   "C C",
			  																	   	   "C C", 'C', Gemify.ingotEnderDiamond});
		
		GameRegistry.addRecipe(new ItemStack(Gemify.enderDiamondBoots, 1), new Object[]{"   ",
			  																		    "C C",
			  																		    "C C", 'C', Gemify.ingotEnderDiamond});
		
		
		//ShardCombiner	
		ShardCombinerCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.ingotExynite, 1), new Object[]{"SS", "SS",'S', Gemify.metalShardExynite});
		ShardCombinerCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.ingotCyxanium, 1), new Object[]{"SS","SS",'S', Gemify.metalShardCyxanium});
		ShardCombinerCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.ingotNetherRadium, 1), new Object[]{"SS", "SS", 'S', Gemify.metalShardNetherRadium});
		ShardCombinerCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.ingotEnderDiamond, 1), new Object[]{"SS", "SS", 'S', Gemify.metalShardEnderDiamond});
		ShardCombinerCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.ingotReinforcedEnderDiamond, 1), new Object[]{"SS", "SS", 'S', Gemify.metalShardReinforcedEnderDiamond});
		
		
		
		//GemStation
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondUltimate, 1), new Object[] {" EEE ",
																																 "CEPEC",
																																 "NSXAN",
																																 "CEWEC",
																																 " DDD ", 'E', Gemify.ingotReinforcedEnderDiamond, 'C', Gemify.ingotCyxanium,
																												 'P', Gemify.reinforcedEnderDiamondPickaxe, 'N', Gemify.ingotNetherRadium,
																												 'S', Gemify.reinforcedEnderDiamondSpade, 'X', Gemify.gemReinforcedNetherStar,
																												 'A', Gemify.reinforcedEnderDiamondAxe, 'W', Gemify.reinforcedEnderDiamondSword,
																												 'D', Gemify.gemDiamerald});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondSword, 1), new Object[] {"  E  ",
																															  " EEE ",
																															  " EXE ",
																															  " EEE  ",
																															  "  D  ", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
																															  		   'X', Gemify.gemReinforcedNetherStar});
				
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondAxe, 1), new Object[] {" EEE ",
																															" EXEE",
																															" EEEE",
																															"  D  ",
																															"  D  ", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
																																	  		   'X', Gemify.gemReinforcedNetherStar});
				
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondSpade, 1), new Object[] {"  E  ",
																															  " EEE ",
																															  " EXE ",
																															  "  D  ",
																															  "  D  ", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
																																	           'X', Gemify.gemReinforcedNetherStar});
				
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondPickaxe, 1), new Object[] {"  E  ",
					  																										 	" EEE ",
					  																											 "EEXEE",
					  																											 "  D  ",
					  																											 "  D  ", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
					  																									 	    		  'X', Gemify.gemReinforcedNetherStar});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondHelm, 1), new Object[] {"EEEEE",
			 																												 "E X E",
			 																												 "EEEEE",
			 																												 "     ",
			 																												 "     ", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
			 																												 		  'X', Gemify.gemReinforcedNetherStar});	
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondChest, 1), new Object[] {"E   E",
																															  "EE EE",
																															  "EEXEE",
																															  "EEEEE",
																															  "EEEEE", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
																															  		   'X', Gemify.gemReinforcedNetherStar});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondLegs, 1), new Object[] {"EEEEE",
			 																												 "EEXEE",
			 																												 "EE EE",
			 																												 "EE EE",
			 																												 "EE EE", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
			 																												          'X', Gemify.gemReinforcedNetherStar});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedEnderDiamondBoots, 1), new Object[] {"    E",
			 																												  "    E",
			 																												  "E EEX",
			 																												  "E    ",
			 																												  "XEE  ", 'E', Gemify.ingotReinforcedEnderDiamond, 'D', Items.diamond,
			 																												            'X', Gemify.gemReinforcedNetherStar});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.blockReinforcer, 1), new Object[] {"DIIID",
			  																												  "IIDII",
			  																												  "IDDDI",
			  																												  "IIDII",
			  																												  "DIIID", 'E', Items.iron_ingot, 'D', Items.diamond});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedNetherRadiumHelm, 1), new Object[] {"     ",
			  																									  			 "  I  ",
			  																									  			 " IAI ",
			  																									  			 "  I  ",
			  																									  			 "     ", 'A', Gemify.reinforcedEnderDiamondHelm, 'I', Gemify.ingotNetherRadium});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedNetherRadiumHelm, 1), new Object[] {"     ",
	  			 "  I  ",
	  			 " IAI ",
	  			 "  I  ",
	  			 "     ", 'A', Gemify.reinforcedEnderDiamondHelm, 'I', Gemify.ingotNetherRadium});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedNetherRadiumChest, 1), new Object[] {"     ",
	  			 "  I  ",
	  			 " IAI ",
	  			 "  I  ",
	  			 "     ", 'A', Gemify.reinforcedEnderDiamondChest, 'I', Gemify.ingotNetherRadium});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedNetherRadiumLegs, 1), new Object[] {"     ",
	  			 "  I  ",
	  			 " IAI ",
	  			 "  I  ",
	  			 "     ", 'A', Gemify.reinforcedEnderDiamondLegs, 'I', Gemify.ingotNetherRadium});
		
		GemStationCraftingManager.getInstance().addRecipe(new ItemStack(Gemify.reinforcedNetherRadiumBoots, 1), new Object[] {"     ",
	  			 "  I  ",
	  			 " IAI ",
	  			 "  I  ",
	  			 "     ", 'A', Gemify.reinforcedEnderDiamondBoots, 'I', Gemify.ingotNetherRadium});
	}
}
