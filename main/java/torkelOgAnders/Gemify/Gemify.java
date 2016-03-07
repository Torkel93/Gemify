package torkelOgAnders.Gemify;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import torkelOgAnders.Gemify.block.BlockCyxanium;
import torkelOgAnders.Gemify.block.BlockEnderDiamond;
import torkelOgAnders.Gemify.block.BlockExynite;
import torkelOgAnders.Gemify.block.BlockNetherRadium;
import torkelOgAnders.Gemify.block.BlockOreCyxanium;
import torkelOgAnders.Gemify.block.BlockOreEnderDiamond;
import torkelOgAnders.Gemify.block.BlockOreExynite;
import torkelOgAnders.Gemify.block.BlockOreNetherRadium;
import torkelOgAnders.Gemify.block.BlockStabilizer;
import torkelOgAnders.Gemify.block.GemCrystalizer.GemCrystalizer;
import torkelOgAnders.Gemify.block.GemCrystalizer.RecipesGemCrystalizer;
import torkelOgAnders.Gemify.block.GemCrystalizer.TileEntityGemCrystalizer;
import torkelOgAnders.Gemify.block.GemInfuser.GemInfuser;
import torkelOgAnders.Gemify.block.GemInfuser.RecipesGemInfuser;
import torkelOgAnders.Gemify.block.GemInfuser.TileEntityGemInfuser;
import torkelOgAnders.Gemify.block.gemReinforcer.GemReinforcer;
import torkelOgAnders.Gemify.block.gemReinforcer.RecipesGemReinforcer;
import torkelOgAnders.Gemify.block.gemReinforcer.TileEntityGemReinforcer;
import torkelOgAnders.Gemify.block.gemStation.GemStation;
import torkelOgAnders.Gemify.block.improver.Improver;
import torkelOgAnders.Gemify.block.improver.RecipesImprover;
import torkelOgAnders.Gemify.block.improver.TileEntityImprover;
import torkelOgAnders.Gemify.block.multiblock.BlockReinforcer;
import torkelOgAnders.Gemify.block.multiblock.ItemSpecialBlock;
import torkelOgAnders.Gemify.block.multiblock.TileStabilizerMultiblock;
import torkelOgAnders.Gemify.block.seperator.RecipesSeperator;
import torkelOgAnders.Gemify.block.seperator.Seperator;
import torkelOgAnders.Gemify.block.seperator.TileEntitySeperator;
import torkelOgAnders.Gemify.block.shardCombiner.ShardCombiner;
import torkelOgAnders.Gemify.block.smelter.Smelter;
import torkelOgAnders.Gemify.block.smelter.TileEntitySmelter;
import torkelOgAnders.Gemify.item.Cyxanium.CyxaniumArmor;
import torkelOgAnders.Gemify.item.Cyxanium.CyxaniumAxe;
import torkelOgAnders.Gemify.item.Cyxanium.CyxaniumPickaxe;
import torkelOgAnders.Gemify.item.Cyxanium.CyxaniumSpade;
import torkelOgAnders.Gemify.item.Cyxanium.CyxaniumSword;
import torkelOgAnders.Gemify.item.EnderDiamond.EnderDiamondArmor;
import torkelOgAnders.Gemify.item.EnderDiamond.EnderDiamondAxe;
import torkelOgAnders.Gemify.item.EnderDiamond.EnderDiamondPickaxe;
import torkelOgAnders.Gemify.item.EnderDiamond.EnderDiamondSpade;
import torkelOgAnders.Gemify.item.EnderDiamond.EnderDiamondSword;
import torkelOgAnders.Gemify.item.NetherRadium.NetherRadiumArmor;
import torkelOgAnders.Gemify.item.NetherRadium.NetherRadiumAxe;
import torkelOgAnders.Gemify.item.NetherRadium.NetherRadiumPickaxe;
import torkelOgAnders.Gemify.item.NetherRadium.NetherRadiumSpade;
import torkelOgAnders.Gemify.item.NetherRadium.NetherRadiumSword;
import torkelOgAnders.Gemify.item.ReinforcedEnderDiamond.ReinforcedEnderDiamondArmor;
import torkelOgAnders.Gemify.item.ReinforcedEnderDiamond.ReinforcedEnderDiamondAxe;
import torkelOgAnders.Gemify.item.ReinforcedEnderDiamond.ReinforcedEnderDiamondPickaxe;
import torkelOgAnders.Gemify.item.ReinforcedEnderDiamond.ReinforcedEnderDiamondSpade;
import torkelOgAnders.Gemify.item.ReinforcedEnderDiamond.ReinforcedEnderDiamondSword;
import torkelOgAnders.Gemify.item.ReinforcedEnderDiamond.ReinforcedEnderDiamondUltimate;
import torkelOgAnders.Gemify.item.ReinforcedNetherRadium.ReinforcedNetherRadiumArmor;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "gf", name = "Gemify", version = "1.0")
public class Gemify {
	//Oprett nye items og blocks
		public static Item gemReinforcedNetherStar;
		
		public static Item cyxaniumSword;
		public static Item cyxaniumPickaxe;
		public static Item cyxaniumSpade;
		public static Item cyxaniumAxe;
		public static Item cyxaniumHelm;	
		public static Item cyxaniumChest;
		public static Item cyxaniumLegs;
		public static Item cyxaniumBoots;
		
		public static Item netherRadiumSword;
		public static Item netherRadiumPickaxe;
		public static Item netherRadiumSpade;
		public static Item netherRadiumAxe;
		public static Item netherRadiumHelm;
		public static Item netherRadiumChest;
		public static Item netherRadiumLegs;
		public static Item netherRadiumBoots;
		
		public static Item enderDiamondSword;
		public static Item enderDiamondPickaxe;
		public static Item enderDiamondSpade;
		public static Item enderDiamondAxe;
		public static Item enderDiamondHelm;	
		public static Item enderDiamondChest;
		public static Item enderDiamondLegs;
		public static Item enderDiamondBoots;
		
		public static Item reinforcedEnderDiamondSword;
		public static Item reinforcedEnderDiamondPickaxe;
		public static Item reinforcedEnderDiamondSpade;
		public static Item reinforcedEnderDiamondAxe;
		public static Item reinforcedEnderDiamondUltimate;
		public static Item reinforcedEnderDiamondHelm;	
		public static Item reinforcedEnderDiamondChest;
		public static Item reinforcedEnderDiamondLegs;
		public static Item reinforcedEnderDiamondBoots;
		
		public static Item reinforcedNetherRadiumHelm;	
		public static Item reinforcedNetherRadiumChest;
		public static Item reinforcedNetherRadiumLegs;
		public static Item reinforcedNetherRadiumBoots;
		
		//Multiblock
		public static Block blockReinforcer;
		public static Block blockStabilizer;
		
		//Machines
		public static Block machineGemInfuser;
		public static Block machineGemInfuserActive;
		public static Block machineGemCrystalizer;
		public static Block machineGemCrystalizerActive;
		public static Block machineGemReinforcer;
		public static Block machineGemReinforcerActive;
		public static Block machineGemStation;
		public static Block machineShardCombiner;
		public static Block machineSeperator;
		public static Block machineSeperatorActive;
		public static Block machineImprover;
		public static Block machineImproverActive;
		public static Block machineSmelter;
		public static Block machineSmelterActive;
		
		public static Item speedUpgrade;
		public static Item diamondFrame;
		
		//GemBlocks
		public static Block blockExynite;
		public static Block blockCyxanium;
		public static Block blockNetherRadium;
		public static Block blockEnderDiamond;
		public static Block blockReinforcedEnderDiamond;
		
		
		
		//GemOre
		public static Block oreExynite;
		public static Block oreCyxanium;
		public static Block oreNetherRadium;
		public static Block oreEnderDiamond;
		
		//Gems
		public static Item gemExynite;
		public static Item gemCyxanium;
		public static Item gemNetherRadium;
		public static Item gemEnderDiamond;
		public static Item gemDiamerald;
		public static Item gemInfusedCoal;
		
		//Metal shards
		public static Item metalShardExynite;
		public static Item metalShardCyxanium;
		public static Item metalShardNetherRadium;
		public static Item metalShardEnderDiamond;
		public static Item metalShardReinforcedEnderDiamond;
		
		//Ingots
		public static Item ingotExynite;
		public static Item ingotCyxanium;
		public static Item ingotNetherRadium;
		public static Item ingotEnderDiamond;
		public static Item ingotReinforcedEnderDiamond;
		
		//SmeltingMaterial
		public static Item crustIron;
		public static Item crustGold;
		
		public static Item dustIron;
		public static Item dustGold;
		
		//Material
		// (String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
		public static final Item.ToolMaterial cyxaniumToolMaterial = EnumHelper.addToolMaterial("CyxaniumToolMaterial", 4, 15610, 10.0F, 6.0F, 30); 
		public static final Item.ToolMaterial netherRadiumToolMaterial = EnumHelper.addToolMaterial("NetherRadiumToolMaterial", 5, 15610, 14.0F, 10.0F, 30);
		public static final Item.ToolMaterial enderDiamondToolMaterial = EnumHelper.addToolMaterial("EnderDiamondToolMaterial", 6, 15610, 18.0F, 16.0F, 30); 
		public static final Item.ToolMaterial reinforcedEnderDiamondToolMaterial = EnumHelper.addToolMaterial("ReinforcedEnderDiamondToolMaterial", 50, -1, 10000.0F, 20.0F, 30); 
		public static final Item.ToolMaterial reinforcedEnderDiamondToolSwordMaterial = EnumHelper.addToolMaterial("ReinforcedEnderDiamondToolSwordMaterial", 1, -1, 10.0F, 8997.0F, 30);
		public static final Item.ToolMaterial reinforcedEnderDiamondToolUltimateMaterial = EnumHelper.addToolMaterial("ReinforcedEnderDiamondToolUltimateMaterial", 1000, -1, 10000.0F, 8999.0F, 100);
		
		//(String name, int durability, int[] reductionAmounts, int enchantability)
		public static final ItemArmor.ArmorMaterial cyxaniumArmorMaterial = EnumHelper.addArmorMaterial("CyxaniumArmorMaterial", 330, new int[]{3,8,6,4}, 30);
		public static final ItemArmor.ArmorMaterial netherRadiumArmorMaterial = EnumHelper.addArmorMaterial("NetherRadiumArmorMaterial", 330, new int[]{4,8,6,4}, 30);
		public static final ItemArmor.ArmorMaterial enderDiamondArmorMaterial = EnumHelper.addArmorMaterial("EnderDiamondArmorMaterial", 330, new int[]{5,8,6,4}, 30);
		public static final ItemArmor.ArmorMaterial reinforcedEnderDiamondArmorMaterial = EnumHelper.addArmorMaterial("ReinforcedEnderDiamondArmorMaterial", -1, new int[]{5,9,7,4}, 100);
		
		
		
		
		@EventHandler
		public void preInit(FMLPreInitializationEvent event) 
		{

			//Item/block initialization and registering
			speedUpgrade = new Item().setUnlocalizedName("SpeedUpgrade").setTextureName("gf:speedupgrade").setCreativeTab(tabGemify);
			diamondFrame = new Item().setUnlocalizedName("DiamondFrame").setTextureName("gf:diamondframe").setCreativeTab(tabGemify);
			gemReinforcedNetherStar = new Item().setUnlocalizedName("GemReinforcedNetherStar").setTextureName("gf:reinforcednetherstar").setCreativeTab(tabGemify);
			gemInfusedCoal = new Item().setUnlocalizedName("InfusedCoal").setTextureName("gf:infusedcoal").setCreativeTab(tabGemify);
			
			cyxaniumSword = new CyxaniumSword(cyxaniumToolMaterial).setUnlocalizedName("CyxaniumSword").setTextureName("gf:cyxaniumsword").setCreativeTab(tabGemify);
			cyxaniumPickaxe = new CyxaniumPickaxe(cyxaniumToolMaterial).setUnlocalizedName("CyxaniumPickaxe").setTextureName("gf:cyxaniumpickaxe").setCreativeTab(tabGemify);
			cyxaniumSpade = new CyxaniumSpade(cyxaniumToolMaterial).setUnlocalizedName("CyxaniumSpade").setTextureName("gf:cyxaniumshovel").setCreativeTab(tabGemify);
			cyxaniumAxe = new CyxaniumAxe(cyxaniumToolMaterial).setUnlocalizedName("CyxaniumAxe").setTextureName("gf:cyxaniumaxe").setCreativeTab(tabGemify);
			cyxaniumHelm = new CyxaniumArmor(cyxaniumArmorMaterial, 0, 0).setUnlocalizedName("CyxaniumHelm").setTextureName("gf:cyxaniumhelm").setCreativeTab(tabGemify);
			cyxaniumChest = new CyxaniumArmor(cyxaniumArmorMaterial, 0, 1).setUnlocalizedName("CyxaniumChest").setTextureName("gf:cyxaniumchest").setCreativeTab(tabGemify);
			cyxaniumLegs = new CyxaniumArmor(cyxaniumArmorMaterial, 0, 2).setUnlocalizedName("CyxaniumLegs").setTextureName("gf:cyxaniumlegs").setCreativeTab(tabGemify);
			cyxaniumBoots = new CyxaniumArmor(cyxaniumArmorMaterial, 0, 3).setUnlocalizedName("CyxaniumBoots").setTextureName("gf:cyxaniumboots").setCreativeTab(tabGemify);
			
			netherRadiumSword = new NetherRadiumSword(netherRadiumToolMaterial).setUnlocalizedName("NetherRadiumSword").setTextureName("gf:netherradiumsword").setCreativeTab(tabGemify);
			netherRadiumPickaxe = new NetherRadiumPickaxe(netherRadiumToolMaterial).setUnlocalizedName("NetherRadiumPickaxe").setTextureName("gf:netherradiumpickaxe").setCreativeTab(tabGemify);
			netherRadiumSpade = new NetherRadiumSpade(netherRadiumToolMaterial).setUnlocalizedName("NetherRadiumSpade").setTextureName("gf:netherradiumshovel").setCreativeTab(tabGemify);
			netherRadiumAxe = new NetherRadiumAxe(netherRadiumToolMaterial).setUnlocalizedName("NetherRadiumAxe").setTextureName("gf:netherradiumaxe").setCreativeTab(tabGemify);
			netherRadiumHelm = new NetherRadiumArmor(netherRadiumArmorMaterial, 0, 0).setUnlocalizedName("NetherRadiumHelm").setTextureName("gf:netherradiumhelm").setCreativeTab(tabGemify);
			netherRadiumChest = new NetherRadiumArmor(netherRadiumArmorMaterial, 0, 1).setUnlocalizedName("NetherRadiumChest").setTextureName("gf:netherradiumchest").setCreativeTab(tabGemify);
			netherRadiumLegs = new NetherRadiumArmor(netherRadiumArmorMaterial, 0, 2).setUnlocalizedName("NetherRadiumLegs").setTextureName("gf:netherradiumlegs").setCreativeTab(tabGemify);
			netherRadiumBoots = new NetherRadiumArmor(netherRadiumArmorMaterial, 0, 3).setUnlocalizedName("NetherRadiumBoots").setTextureName("gf:netherradiumboots").setCreativeTab(tabGemify);
			
			enderDiamondSword = new EnderDiamondSword(enderDiamondToolMaterial).setUnlocalizedName("EnderDiamondSword").setTextureName("gf:enderdiamondsword").setCreativeTab(tabGemify);
			enderDiamondPickaxe = new EnderDiamondPickaxe(enderDiamondToolMaterial).setUnlocalizedName("EnderDiamondPickaxe").setTextureName("gf:enderdiamondpickaxe").setCreativeTab(tabGemify);
			enderDiamondSpade = new EnderDiamondSpade(enderDiamondToolMaterial).setUnlocalizedName("EnderDiamondSpade").setTextureName("gf:enderdiamondspade").setCreativeTab(tabGemify);
			enderDiamondAxe = new EnderDiamondAxe(enderDiamondToolMaterial).setUnlocalizedName("EnderDiamondAxe").setTextureName("gf:enderdiamondaxe").setCreativeTab(tabGemify);
			enderDiamondHelm = new EnderDiamondArmor(enderDiamondArmorMaterial, 0, 0).setUnlocalizedName("EnderDiamondHelm").setTextureName("gf:enderdiamondhelm").setCreativeTab(tabGemify);
			enderDiamondChest = new EnderDiamondArmor(enderDiamondArmorMaterial, 0, 1).setUnlocalizedName("EnderDiamondChest").setTextureName("gf:enderdiamondchest").setCreativeTab(tabGemify);
			enderDiamondLegs = new EnderDiamondArmor(enderDiamondArmorMaterial, 0, 2).setUnlocalizedName("EnderDiamondLegs").setTextureName("gf:enderdiamondlegs").setCreativeTab(tabGemify);
			enderDiamondBoots = new EnderDiamondArmor(enderDiamondArmorMaterial, 0, 3).setUnlocalizedName("EnderDiamondBoots").setTextureName("gf:enderdiamondboots").setCreativeTab(tabGemify);
			
			reinforcedEnderDiamondSword = new ReinforcedEnderDiamondSword(reinforcedEnderDiamondToolSwordMaterial).setUnlocalizedName("ReinforcedEnderDiamondSword").setTextureName("gf:gemreinforcedenderdiamondsword").setCreativeTab(tabGemify);
			reinforcedEnderDiamondPickaxe = new ReinforcedEnderDiamondPickaxe(reinforcedEnderDiamondToolMaterial).setUnlocalizedName("ReinforcedEnderDiamondPickaxe").setTextureName("gf:gemreinforcedenderdiamondpickaxe").setCreativeTab(tabGemify);
			reinforcedEnderDiamondSpade = new ReinforcedEnderDiamondSpade(reinforcedEnderDiamondToolMaterial).setUnlocalizedName("ReinforcedEnderDiamondSpade").setTextureName("gf:gemreinforcedenderdiamondspade").setCreativeTab(tabGemify);
			reinforcedEnderDiamondAxe = new ReinforcedEnderDiamondAxe(reinforcedEnderDiamondToolMaterial).setUnlocalizedName("ReinforcedEnderDiamondAxe").setTextureName("gf:gemreinforcedenderdiamondaxe").setCreativeTab(tabGemify);
			reinforcedEnderDiamondUltimate = new ReinforcedEnderDiamondUltimate(reinforcedEnderDiamondToolUltimateMaterial).setUnlocalizedName("ReinforcedEnderDiamondUltimate").setTextureName("gf:gemreinforcedenderdiamondultimate").setCreativeTab(tabGemify);			
			reinforcedEnderDiamondHelm = new ReinforcedEnderDiamondArmor(reinforcedEnderDiamondArmorMaterial, 0, 0).setUnlocalizedName("ReinforcedEnderDiamondHelm").setTextureName("gf:gemreinforcedenderdiamondhelm").setCreativeTab(tabGemify);
			reinforcedEnderDiamondChest = new ReinforcedEnderDiamondArmor(reinforcedEnderDiamondArmorMaterial, 0, 1).setUnlocalizedName("ReinforcedEnderDiamondChest").setTextureName("gf:gemreinforcedenderdiamondchest").setCreativeTab(tabGemify);
			reinforcedEnderDiamondLegs = new ReinforcedEnderDiamondArmor(reinforcedEnderDiamondArmorMaterial, 0, 2).setUnlocalizedName("ReinforcedEnderDiamondLegs").setTextureName("gf:gemreinforcedenderdiamondlegs").setCreativeTab(tabGemify);
			reinforcedEnderDiamondBoots = new ReinforcedEnderDiamondArmor(reinforcedEnderDiamondArmorMaterial, 0, 3).setUnlocalizedName("ReinforcedEnderDiamondBoots").setTextureName("gf:gemreinforcedenderdiamondboots").setCreativeTab(tabGemify);
			
			reinforcedNetherRadiumHelm = new ReinforcedNetherRadiumArmor(reinforcedEnderDiamondArmorMaterial, 0, 0).setUnlocalizedName("ReinforcedNetherRadiumHelm").setTextureName("gf:gemreinforcednetherradiumhelm").setCreativeTab(tabGemify);
			reinforcedNetherRadiumChest = new ReinforcedNetherRadiumArmor(reinforcedEnderDiamondArmorMaterial, 0, 1).setUnlocalizedName("ReinforcedNetherRadiumChest").setTextureName("gf:gemreinforcednetherradiumchest").setCreativeTab(tabGemify);
			reinforcedNetherRadiumLegs = new ReinforcedNetherRadiumArmor(reinforcedEnderDiamondArmorMaterial, 0, 2).setUnlocalizedName("ReinforcedNetherRadiumLegs").setTextureName("gf:gemreinforcednetherradiumlegs").setCreativeTab(tabGemify);
			reinforcedNetherRadiumBoots = new ReinforcedNetherRadiumArmor(reinforcedEnderDiamondArmorMaterial, 0, 3).setUnlocalizedName("ReinforcedNetherRadiumBoots").setTextureName("gf:gemreinforcednetherradiumboots").setCreativeTab(tabGemify);
			
			
			
			blockExynite = new BlockExynite(Material.rock).setBlockName("BlockExynite").setBlockTextureName("gf:blockexynite").setCreativeTab(tabGemify);
			blockCyxanium = new BlockCyxanium(Material.rock).setBlockName("BlockCyxanium").setBlockTextureName("gf:blockcyxanium").setCreativeTab(tabGemify);
			blockNetherRadium = new BlockNetherRadium(Material.rock).setBlockName("BlockNetherRadium").setBlockTextureName("gf:blocknetherradium").setCreativeTab(tabGemify);
			blockEnderDiamond = new BlockEnderDiamond(Material.rock).setBlockName("BlockEnderDiamond").setBlockTextureName("gf:blockenderdiamond").setCreativeTab(tabGemify);
			blockReinforcedEnderDiamond = new BlockEnderDiamond(Material.rock).setBlockName("BlockReinforcedEnderDiamond").setBlockTextureName("gf:blockreinforcedenderdiamond").setCreativeTab(tabGemify);
			
			oreExynite = new BlockOreExynite(Material.rock).setBlockName("OreExynite").setBlockTextureName("gf:exyniteore").setCreativeTab(tabGemify);
			oreCyxanium = new BlockOreCyxanium(Material.rock).setBlockName("OreCyxanium").setBlockTextureName("gf:cyxaniumore").setCreativeTab(tabGemify);
			oreNetherRadium = new BlockOreNetherRadium(Material.rock).setBlockName("OreNetherRadium").setBlockTextureName("gf:netherradiumore").setCreativeTab(tabGemify);
			oreEnderDiamond = new BlockOreEnderDiamond(Material.rock).setBlockName("OreEnderDiamond").setBlockTextureName("gf:enderdiamondore").setCreativeTab(tabGemify);
			
			gemExynite = new Item().setUnlocalizedName("GemExynite").setTextureName("gf:exynite").setCreativeTab(tabGemify);
			gemCyxanium = new Item().setUnlocalizedName("GemCyxanium").setTextureName("gf:cyxanium").setCreativeTab(tabGemify);
			gemNetherRadium = new Item().setUnlocalizedName("GemNetherRadium").setTextureName("gf:netherradium").setCreativeTab(tabGemify);
			gemEnderDiamond = new Item().setUnlocalizedName("GemEnderDiamond").setTextureName("gf:enderdiamond").setCreativeTab(tabGemify);
			gemDiamerald = new Item().setUnlocalizedName("GemDiamerald").setTextureName("gf:diamerald").setCreativeTab(tabGemify);
			
			
			metalShardExynite = new Item().setUnlocalizedName("MetalShardExynite").setTextureName("gf:exyniteshard").setCreativeTab(tabGemify);
			metalShardCyxanium = new Item().setUnlocalizedName("MetalShardCyxanium").setTextureName("gf:cyxaniumshard").setCreativeTab(tabGemify);
			metalShardNetherRadium = new Item().setUnlocalizedName("MetalShardNetherRadium").setTextureName("gf:netherradiumshard").setCreativeTab(tabGemify);
			metalShardEnderDiamond = new Item().setUnlocalizedName("MetalShardEnderDiamond").setTextureName("gf:enderdiamondshard").setCreativeTab(tabGemify);
			metalShardReinforcedEnderDiamond = new Item().setUnlocalizedName("MetalShardReinforcedEnderDiamond").setTextureName("gf:reinforcedenderdiamondshard").setCreativeTab(tabGemify);
			
			ingotExynite = new Item().setUnlocalizedName("IngotExynite").setTextureName("gf:exyniteingot").setCreativeTab(tabGemify);
			ingotCyxanium = new Item().setUnlocalizedName("IngotCyxanium").setTextureName("gf:cyxaniumingot").setCreativeTab(tabGemify);
			ingotNetherRadium = new Item().setUnlocalizedName("IngotNetherRadium").setTextureName("gf:netherradiumingot").setCreativeTab(tabGemify);
			ingotEnderDiamond = new Item().setUnlocalizedName("IngotEnderDiamond").setTextureName("gf:enderdiamondingot").setCreativeTab(tabGemify);
			ingotReinforcedEnderDiamond = new Item().setUnlocalizedName("IngotReinforcedEnderDiamond").setTextureName("gf:gemreinforcedenderdiamondingot").setCreativeTab(tabGemify);
			
			
			crustIron = new Item().setUnlocalizedName("CrustIron").setTextureName("gf:crustiron").setCreativeTab(tabGemify);
			crustGold = new Item().setUnlocalizedName("CrustGold").setTextureName("gf:crustgold").setCreativeTab(tabGemify);
			
			dustIron = new Item().setUnlocalizedName("DustIron").setTextureName("gf:dustiron").setCreativeTab(tabGemify);
			dustGold = new Item().setUnlocalizedName("DustGold").setTextureName("gf:dustgold").setCreativeTab(tabGemify);
			
			
			blockReinforcer = new BlockReinforcer().setBlockName("BlockReinforcer").setHardness(2.0F).setBlockTextureName("gf:gemreinforcerunstable").setCreativeTab(tabGemify);
			blockStabilizer = new BlockStabilizer(Material.rock).setBlockName("BlockStabilizer").setHardness(1.0F).setBlockTextureName("gf:blockstabilizer").setCreativeTab(tabGemify);
			
			machineGemInfuser = new GemInfuser(false).setBlockName("GemInfuser").setHardness(2.0F).setCreativeTab(tabGemify);
			machineGemInfuserActive = new GemInfuser(true).setBlockName("GemInfuserActive").setHardness(2.0F);
			machineGemCrystalizer = new GemCrystalizer(false).setBlockName("GemCrystalizer").setHardness(2.0F).setCreativeTab(tabGemify);
			machineGemCrystalizerActive = new GemCrystalizer(true).setBlockName("GemCrystalizerActive").setHardness(2.0F);
			machineGemReinforcer = new GemReinforcer(false).setBlockName("GemReinforcer").setHardness(2.0F).setCreativeTab(tabGemify);
			machineGemReinforcerActive = new GemReinforcer(true).setBlockName("GemReinforcerActive").setHardness(2.0F);
			machineGemStation = new GemStation().setBlockName("GemStation").setCreativeTab(tabGemify);
			machineShardCombiner = new ShardCombiner().setBlockName("ShardCombiner").setCreativeTab(tabGemify);
			machineSeperator = new Seperator(false).setBlockName("Seperator").setHardness(2.0F).setCreativeTab(tabGemify);
			machineSeperatorActive = new Seperator(true).setBlockName("SeperatorActive").setHardness(2.0F);
			machineImprover = new Improver(false).setBlockName("Improver").setHardness(2.0F).setCreativeTab(tabGemify);
			machineImproverActive = new Improver(true).setBlockName("ImproverActive").setHardness(2.0F);
			machineSmelter = new Smelter(false).setBlockName("Smelter").setHardness(2.0F).setCreativeTab(tabGemify);
			machineSmelterActive = new Smelter(true).setBlockName("SmelterActive").setHardness(2.0F);
			
			
			//Register items
			

			//other
			GameRegistry.registerItem(gemReinforcedNetherStar, gemReinforcedNetherStar.getUnlocalizedName());
			GameRegistry.registerItem(speedUpgrade, speedUpgrade.getUnlocalizedName());
			GameRegistry.registerItem(diamondFrame, diamondFrame.getUnlocalizedName());
			GameRegistry.registerItem(gemInfusedCoal, gemInfusedCoal.getUnlocalizedName());
			
			//Tools&Armor
			GameRegistry.registerItem(cyxaniumSword, cyxaniumSword.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumPickaxe, cyxaniumPickaxe.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumSpade, cyxaniumSpade.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumAxe, cyxaniumAxe.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumHelm, cyxaniumHelm.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumChest, cyxaniumChest.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumLegs, cyxaniumLegs.getUnlocalizedName());
			GameRegistry.registerItem(cyxaniumBoots, cyxaniumBoots.getUnlocalizedName());
			
			GameRegistry.registerItem(netherRadiumSword, netherRadiumSword.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumPickaxe, netherRadiumPickaxe.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumSpade, netherRadiumSpade.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumAxe, netherRadiumAxe.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumHelm, netherRadiumHelm.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumChest, netherRadiumChest.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumLegs, netherRadiumLegs.getUnlocalizedName());
			GameRegistry.registerItem(netherRadiumBoots, netherRadiumBoots.getUnlocalizedName());
			
			GameRegistry.registerItem(enderDiamondSword, enderDiamondSword.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondPickaxe, enderDiamondPickaxe.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondSpade, enderDiamondSpade.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondAxe, enderDiamondAxe.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondHelm, enderDiamondHelm.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondChest, enderDiamondChest.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondLegs, enderDiamondLegs.getUnlocalizedName());
			GameRegistry.registerItem(enderDiamondBoots, enderDiamondBoots.getUnlocalizedName());
			
			
			
			GameRegistry.registerItem(reinforcedEnderDiamondSword, reinforcedEnderDiamondSword.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondPickaxe, reinforcedEnderDiamondPickaxe.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondSpade, reinforcedEnderDiamondSpade.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondAxe, reinforcedEnderDiamondAxe.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondUltimate, reinforcedEnderDiamondUltimate.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondHelm, reinforcedEnderDiamondHelm.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondChest, reinforcedEnderDiamondChest.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondLegs, reinforcedEnderDiamondLegs.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedEnderDiamondBoots, reinforcedEnderDiamondBoots.getUnlocalizedName());
			
			GameRegistry.registerItem(reinforcedNetherRadiumHelm, reinforcedNetherRadiumHelm.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedNetherRadiumChest, reinforcedNetherRadiumChest.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedNetherRadiumLegs, reinforcedNetherRadiumLegs.getUnlocalizedName());
			GameRegistry.registerItem(reinforcedNetherRadiumBoots, reinforcedNetherRadiumBoots.getUnlocalizedName());
			
			
			//Blocks
			GameRegistry.registerBlock(blockExynite, blockExynite.getUnlocalizedName());
			GameRegistry.registerBlock(blockCyxanium, blockCyxanium.getUnlocalizedName());
			GameRegistry.registerBlock(blockNetherRadium, blockNetherRadium.getUnlocalizedName());
			GameRegistry.registerBlock(blockEnderDiamond, blockEnderDiamond.getUnlocalizedName());
			GameRegistry.registerBlock(blockReinforcedEnderDiamond, blockReinforcedEnderDiamond.getUnlocalizedName());
			
			//Ore
			GameRegistry.registerBlock(oreExynite, oreExynite.getUnlocalizedName());
			GameRegistry.registerBlock(oreCyxanium, oreCyxanium.getUnlocalizedName());
			GameRegistry.registerBlock(oreNetherRadium, oreNetherRadium.getUnlocalizedName());
			GameRegistry.registerBlock(oreEnderDiamond, oreEnderDiamond.getUnlocalizedName());
			
			
			//Gems
			GameRegistry.registerItem(gemExynite, gemExynite.getUnlocalizedName());
			GameRegistry.registerItem(gemCyxanium, gemCyxanium.getUnlocalizedName());
			GameRegistry.registerItem(gemNetherRadium, gemNetherRadium.getUnlocalizedName());
			GameRegistry.registerItem(gemEnderDiamond, gemEnderDiamond.getUnlocalizedName());
			GameRegistry.registerItem(gemDiamerald, gemDiamerald.getUnlocalizedName());
			
			//MetalShards
			GameRegistry.registerItem(metalShardExynite, metalShardExynite.getUnlocalizedName());
			GameRegistry.registerItem(metalShardCyxanium, metalShardCyxanium.getUnlocalizedName());
			GameRegistry.registerItem(metalShardNetherRadium, metalShardNetherRadium.getUnlocalizedName());
			GameRegistry.registerItem(metalShardEnderDiamond, metalShardEnderDiamond.getUnlocalizedName());
			GameRegistry.registerItem(metalShardReinforcedEnderDiamond, metalShardReinforcedEnderDiamond.getUnlocalizedName());
			
			//Ingots
			GameRegistry.registerItem(ingotExynite, ingotExynite.getUnlocalizedName());
			GameRegistry.registerItem(ingotCyxanium, ingotCyxanium.getUnlocalizedName());
			GameRegistry.registerItem(ingotNetherRadium, ingotNetherRadium.getUnlocalizedName());
			GameRegistry.registerItem(ingotEnderDiamond, ingotEnderDiamond.getUnlocalizedName());
			GameRegistry.registerItem(ingotReinforcedEnderDiamond, ingotReinforcedEnderDiamond.getUnlocalizedName());
			
			//SmeltingMaterial
			GameRegistry.registerItem(crustIron, crustIron.getUnlocalizedName());
			GameRegistry.registerItem(crustGold, crustGold.getUnlocalizedName());
			
			GameRegistry.registerItem(dustIron, dustIron.getUnlocalizedName());
			GameRegistry.registerItem(dustGold, dustGold.getUnlocalizedName());
			
			
			//HalfMachine
			GameRegistry.registerBlock(blockReinforcer, ItemSpecialBlock.class, blockReinforcer.getUnlocalizedName());
			GameRegistry.registerBlock(blockStabilizer, blockStabilizer.getUnlocalizedName());
			
			//Machines
			GameRegistry.registerBlock(machineGemInfuser, machineGemInfuser.getUnlocalizedName());
			GameRegistry.registerBlock(machineGemInfuserActive, machineGemInfuserActive.getUnlocalizedName());
			GameRegistry.registerBlock(machineGemCrystalizer, machineGemCrystalizer.getUnlocalizedName());
			GameRegistry.registerBlock(machineGemCrystalizerActive, machineGemCrystalizerActive.getUnlocalizedName());
			GameRegistry.registerBlock(machineGemReinforcer, machineGemReinforcer.getUnlocalizedName());
			GameRegistry.registerBlock(machineGemReinforcerActive, machineGemReinforcerActive.getUnlocalizedName());
			GameRegistry.registerBlock(machineGemStation, machineGemStation.getUnlocalizedName());
			GameRegistry.registerBlock(machineShardCombiner, machineShardCombiner.getUnlocalizedName());
			GameRegistry.registerBlock(machineSeperator, machineSeperator.getUnlocalizedName());
			GameRegistry.registerBlock(machineSeperatorActive, machineSeperatorActive.getUnlocalizedName());
			GameRegistry.registerBlock(machineImprover, machineImprover.getUnlocalizedName());
			GameRegistry.registerBlock(machineImproverActive, machineImproverActive.getUnlocalizedName());
			GameRegistry.registerBlock(machineSmelter, machineSmelter.getUnlocalizedName());
			GameRegistry.registerBlock(machineSmelterActive, machineSmelterActive.getUnlocalizedName());
			
			//Gem Infuser Smelting Recipes
			//RecipesGemInfuser.smelting().addSmeltingBlock(Blocks.dirt, new ItemStack(Items.cooked_porkchop), 1);
			RecipesGemInfuser.smelting().addSmeltingItem(Items.emerald, new ItemStack(Gemify.gemDiamerald), 1.0F);
			RecipesGemInfuser.smelting().addSmeltingItem(Items.coal, new ItemStack(Gemify.gemInfusedCoal), 1.0F);
			
			//Gem Crystalizer Smelting Recipes
			//RecipesGemCrystalizer.smelting().addSmeltingBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
		    RecipesGemCrystalizer.smelting().addSmeltingItem(Gemify.gemExynite, new ItemStack(Gemify.metalShardExynite), 0.35F);
		    RecipesGemCrystalizer.smelting().addSmeltingItem(Gemify.gemCyxanium, new ItemStack(Gemify.metalShardCyxanium), 0.35F);
		    RecipesGemCrystalizer.smelting().addSmeltingItem(Gemify.gemNetherRadium, new ItemStack(Gemify.metalShardNetherRadium), 0.35F);
		    RecipesGemCrystalizer.smelting().addSmeltingItem(Gemify.gemEnderDiamond, new ItemStack(Gemify.metalShardEnderDiamond), 0.35F);
		    
		    //Gem Reinforcer Smelting recipes
		    RecipesGemReinforcer.smelting().addSmeltingItem(Gemify.metalShardEnderDiamond, new ItemStack(Gemify.metalShardReinforcedEnderDiamond), 2.35F);
		    RecipesGemReinforcer.smelting().addSmeltingItem(Items.nether_star, new ItemStack(Gemify.gemReinforcedNetherStar), 2.35F);
		   
		    //Seperator
		    RecipesSeperator.smelting().addSmeltingBlock(Blocks.iron_ore, new ItemStack(Gemify.crustIron, 3), 0.35F);
		    RecipesSeperator.smelting().addSmeltingBlock(Blocks.gold_ore, new ItemStack(Gemify.crustGold, 3), 0.35F);
		   
		    //Improver
		    RecipesImprover.smelting().addSmeltingItem(Gemify.crustIron, new ItemStack(Gemify.dustIron, 1), 0.35F);
		    RecipesImprover.smelting().addSmeltingItem(Gemify.crustGold, new ItemStack(Gemify.dustGold, 1), 0.35F);
		    RecipesImprover.smelting().addSmeltingBlock(Blocks.iron_ore, new ItemStack(Gemify.dustIron, 2), 0.35F);
		    RecipesImprover.smelting().addSmeltingBlock(Blocks.gold_ore, new ItemStack(Gemify.dustGold, 2), 0.35F);
		    
		    //Smelter
		    GameRegistry.addSmelting(Gemify.dustGold, new ItemStack(Items.gold_ingot, 1), 0.35F);
		    GameRegistry.addSmelting(Gemify.dustIron, new ItemStack(Items.iron_ingot, 1), 0.35F);
		   
		   
		    //World Generation
		    GameRegistry.registerWorldGenerator(new ExyniteGenerator(), 0);
			//Config handling
			
			
		}
		
		
		
		@EventHandler
		public void init(FMLInitializationEvent event) {
			//Tile entities
			GameRegistry.registerTileEntity(TileEntityGemInfuser.class, "gf:GemInfuser");
			GameRegistry.registerTileEntity(TileEntityGemCrystalizer.class, "gf:GemCrystalizer");
			GameRegistry.registerTileEntity(TileEntityGemReinforcer.class, "gf:GemReinforcer");
			GameRegistry.registerTileEntity(TileStabilizerMultiblock.class, "gf:MultiBlockStabilizer");
			GameRegistry.registerTileEntity(TileEntitySeperator.class, "gf:Seperator");
			GameRegistry.registerTileEntity(TileEntityImprover.class, "gf:Improver");
			GameRegistry.registerTileEntity(TileEntitySmelter.class, "gf:Smelter");
			
			//Proxy, TileEntity, entity, GUI and Packet Registering
			NetworkRegistry.INSTANCE.registerGuiHandler(modInstance, new GIGuiHandler());
			
			//Registrere Recipes		
			Recipes.loadRecipes();
		}
	            
		                    
	                    
		public static CreativeTabs tabGemify = new CreativeTabs("tabGemify"){
			@Override
			public Item getTabIconItem(){
				return new ItemStack(Gemify.gemDiamerald).getItem();
			}
		};
		@Instance("gf")
	 	public static Gemify modInstance;

		
		
}
	        
	
	            