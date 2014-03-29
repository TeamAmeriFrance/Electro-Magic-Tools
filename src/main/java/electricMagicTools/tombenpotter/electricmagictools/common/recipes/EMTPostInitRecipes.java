/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 * 
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/
package electricMagicTools.tombenpotter.electricmagictools.common.recipes;

import ic2.api.item.Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import ic2.core.util.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import cpw.mods.fml.common.registry.GameRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.BlockRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.ItemRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.lib.CraftingAspects;

public class EMTPostInitRecipes
{

	public static void add() {

		/** Infusion Recipes **/

		thaumiumDrill = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Drill", new ItemStack(ItemRegistry.thaumiumDrill), 5, CraftingAspects.thaumiumDrillCrafting, new ItemStack(Items.getItem("diamondDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.diamond), new ItemStack(Item.diamond), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), Items.getItem("denseplateiron") });

		thaumiumChainsaw = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Chainsaw", new ItemStack(ItemRegistry.thaumiumChainsaw), 5, CraftingAspects.thaumiumChainsawCrafting, new ItemStack(ItemRegistry.diamondChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.diamond), new ItemStack(Item.diamond), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), Items.getItem("denseplateiron") });

		thaumicQuantumHelmet = ThaumcraftApi.addInfusionCraftingRecipe("Quantum Goggles of Revealing", new ItemStack(ItemRegistry.quantumThaumicHelmet), 6, CraftingAspects.thaumicQuantumHelmetCrafting, new ItemStack(ItemRegistry.nanoThaumicHelmet, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.diamond), new ItemStack(Item.bucketMilk), new ItemStack(Items.getItem("quantumHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), Items.getItem("iridiumPlate"), Items.getItem("advancedCircuit") });

		thaumicNanoHelmet = ThaumcraftApi.addInfusionCraftingRecipe("Nanosuit Goggles of Revealing", new ItemStack(ItemRegistry.nanoThaumicHelmet), 5, CraftingAspects.thaumicNanoHelmetCrafting, new ItemStack(ItemRegistry.electricGoggles, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.diamond), new ItemStack(Item.ingotGold), new ItemStack(Items.getItem("nanoHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), Items.getItem("carbonPlate"), Items.getItem("electronicCircuit") });

		thaumiumOmnitool = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Omnitool", new ItemStack(ItemRegistry.thaumiumOmnitool), 6, CraftingAspects.thaumiumOmnitoolCrafting, new ItemStack(ItemRegistry.thaumiumChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(ItemRegistry.thaumiumDrill, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), Items.getItem("carbonPlate"), Items.getItem("plateobsidian") });

		diamondOmnitoolToThaumium = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Omnitool", new ItemStack(ItemRegistry.thaumiumOmnitool), 6, CraftingAspects.thaumiumOmnitoolCrafting, new ItemStack(ItemRegistry.diamondOmnitool, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Block.blockDiamond), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), new ItemStack(Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), Items.getItem("carbonPlate"), Items.getItem("advancedCircuit") });

		explosionFocus = ThaumcraftApi.addInfusionCraftingRecipe("Explosion Focus", new ItemStack(ItemRegistry.explosionFocus), 6, CraftingAspects.laserFocusCrafting, new ItemStack(ConfigItems.itemFocusHellbat, 1), new ItemStack[] { new ItemStack(Items.getItem("miningLaser").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.arrow), new ItemStack(Item.gunpowder), new ItemStack(Item.fireworkCharge), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemWispEssence, 1) });

		shieldFocus = ThaumcraftApi.addInfusionCraftingRecipe("Shield Focus", new ItemStack(ItemRegistry.shieldFocus), 4, CraftingAspects.shieldFocusCrafting, new ItemStack(ConfigItems.itemFocusPortableHole, 1), new ItemStack[] { Items.getItem("reinforcedStone"), Items.getItem("reinforcedGlass"), Items.getItem("reinforcedStone"), Items.getItem("reinforcedGlass"), new ItemStack(Block.slowSand), new ItemStack(Block.obsidian), new ItemStack(Block.obsidian) });

		potentiaGenerator = ThaumcraftApi.addInfusionCraftingRecipe("Potentia Generator", new ItemStack(BlockRegistry.essentiaGens, 1, 0), 6, CraftingAspects.potentiaGeneratorCrafting, Items.getItem("semifluidGenerator"), new ItemStack[] { new ItemStack(Item.diamond), new ItemStack(ConfigItems.itemFocusTrade), new ItemStack(Block.hopperBlock), new ItemStack(ConfigBlocks.blockJar), Items.getItem("mvTransformer"), Items.getItem("advancedMachine"), Items.getItem("orewashingplant"), Items.getItem("scrap") });

		streamChainsaw = ThaumcraftApi.addInfusionCraftingRecipe("Chainsaw of the Stream", new ItemStack(ItemRegistry.streamChainsaw), 6, CraftingAspects.streamChaisnawCrafting, new ItemStack(ItemRegistry.thaumiumChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.bucketWater), new ItemStack(ConfigItems.itemAxeElemental), new ItemStack(ConfigBlocks.blockMagicalLog), new ItemStack(Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), Items.getItem("compressedPlantBall"), Items.getItem("iridiumPlate"), Items.getItem("overclockerUpgrade") });

		rockbreakerDrill = ThaumcraftApi.addInfusionCraftingRecipe("Drill of the Rockbreaker", new ItemStack(ItemRegistry.rockbreakerDrill), 6, CraftingAspects.rockbreakerDrillCrafting, new ItemStack(ItemRegistry.thaumiumDrill, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.flintAndSteel), new ItemStack(Item.fireballCharge), new ItemStack(ConfigItems.itemPickElemental), new ItemStack(ConfigItems.itemShovelElemental), new ItemStack(Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), Items.getItem("reinforcedStone"), Items.getItem("iridiumPlate"), Items.getItem("overclockerUpgrade") });

		thorHammer = ThaumcraftApi.addInfusionCraftingRecipe("Mjolnir", new ItemStack(ItemRegistry.thorHammer), 7, CraftingAspects.thorHammerCrafting, new ItemStack(ItemRegistry.taintedThorHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(ItemRegistry.lightningSummoner), new ItemStack(ItemRegistry.lightningSummoner), new ItemStack(ConfigItems.itemSwordElemental), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemFocusShock), Items.getItem("rubber") });

		superchargedThorHammer = ThaumcraftApi.addInfusionCraftingRecipe("Supercharged Mjolnir", new ItemStack(ItemRegistry.electricThorHammer), 10, CraftingAspects.superchargedThorHammerCrafting, new ItemStack(ItemRegistry.thorHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(ItemRegistry.lightningSummoner), new ItemStack(ItemRegistry.lightningSummoner), new ItemStack(Block.web), new ItemStack(ConfigItems.itemFocusHellbat), new ItemStack(ConfigItems.itemSwordElemental), new ItemStack(Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), Items.getItem("iridiumPlate"), Items.getItem("iridiumPlate"), new ItemStack(Items.getItem("nanoSaber").getItem(), 1, OreDictionary.WILDCARD_VALUE) });

		wandRecharger = ThaumcraftApi.addInfusionCraftingRecipe("Industrial Wand Charging Station", new ItemStack(BlockRegistry.emtMachines, 1, 0), 6, CraftingAspects.wandCharger, new ItemStack(ConfigBlocks.blockStoneDevice, 1, 5), new ItemStack[] { Items.getItem("replicator"), Items.getItem("iridiumPlate"), new ItemStack(Block.blockDiamond), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigBlocks.blockJar) });

		solarHelmetRevealing = ThaumcraftApi.addInfusionCraftingRecipe("Solar Helmet of Revealing", new ItemStack(ItemRegistry.solarHelmetRevealing), 5, CraftingAspects.solarHelmetRevealing, new ItemStack(ItemRegistry.quantumThaumicHelmet, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(BlockRegistry.emtSolars, 1, 1), Items.getItem("glassFiberCableItem"), new ItemStack(Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemShard, 1, 4) });

		electricBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe("Electric Boots of the Traveller", new ItemStack(ItemRegistry.electricBootsTraveller), 2, CraftingAspects.electricBootsTravel, new ItemStack(ConfigItems.itemBootsTraveller), new ItemStack[] { new ItemStack(Item.diamond), Items.getItem("elemotor"), Items.getItem("coil"), Items.getItem("hazmatBoots"), new ItemStack(Items.getItem("advBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemWispEssence) });

		nanoBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe("Nano Boots of the Traveller", new ItemStack(ItemRegistry.nanoBootsTraveller), 2, CraftingAspects.nanoBootsTravel, new ItemStack(ItemRegistry.electricBootsTraveller, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Item.diamond), new ItemStack(Items.getItem("nanoBoots").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemWispEssence), new ItemStack(ConfigItems.itemWispEssence) });

		quantumBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe("Quantum Boots of the Traveller", new ItemStack(ItemRegistry.quantumBootsTraveller), 2, CraftingAspects.quantumBootsTravel, new ItemStack(ItemRegistry.nanoBootsTraveller, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { new ItemStack(Block.blockDiamond), new ItemStack(Items.getItem("quantumBoots").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), Items.getItem("iridiumPlate"), new ItemStack(ConfigItems.itemWispEssence), new ItemStack(ConfigItems.itemWispEssence), new ItemStack(ConfigItems.itemWispEssence) });

		etheralProcessor = ThaumcraftApi.addInfusionCraftingRecipe("Etheral Processor", new ItemStack(BlockRegistry.emtMachines, 1, 1), 3, CraftingAspects.etherealProcessor, Items.getItem("macerator"), new ItemStack[] { Items.getItem("electroFurnace"), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), new ItemStack(Block.whiteStone), new ItemStack(Block.whiteStone), new ItemStack(Block.blockIron), new ItemStack(Block.blockIron), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate) });

		tripleCompressedSolar = ThaumcraftApi.addInfusionCraftingRecipe("Compressed Solars", new ItemStack(BlockRegistry.emtSolars, 1, 2), 2, CraftingAspects.compressedSolars, new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack[] { new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 1) });

		electricHoeGrowth = ThaumcraftApi.addInfusionCraftingRecipe("Electric Hoe of Growth", new ItemStack(ItemRegistry.electricHoeGrowth), 4, CraftingAspects.electricHoeGrowth, new ItemStack(ConfigItems.itemHoeElemental), new ItemStack[] { new ItemStack(Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.getItem("electricHoe").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.dyePowder, 1, 15), Items.getItem("elemotor"), Items.getItem("coil"), new ItemStack(Block.sapling, 1, OreDictionary.WILDCARD_VALUE) });

		chargeFocus = ThaumcraftApi.addInfusionCraftingRecipe("Wand Focus: Charging", new ItemStack(ItemRegistry.chargeFocus), 4, CraftingAspects.chargeFocus, new ItemStack(Items.getItem("advBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { Items.getItem("generator"), Items.getItem("batBox"), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ItemRegistry.thaumiumPlate), new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE) });

		/** Arcane Worktable Recipes **/

		diamondOmnitool = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Diamond Omnitool", new ItemStack(ItemRegistry.diamondOmnitool), CraftingAspects.diamondOmnitoolCrafting, new ItemStack(ItemRegistry.diamondChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.getItem("diamondDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE));

		ironOmnitoolToDiamond = ThaumcraftApi.addArcaneCraftingRecipe("Diamond Omnitool", new ItemStack(ItemRegistry.diamondOmnitool), CraftingAspects.diamondOmnitoolCrafting, "XAX", "XBX", "XAX", 'X', new ItemStack(Item.diamond), 'A', Items.getItem("advancedCircuit"), 'B', new ItemStack(ItemRegistry.ironOmnitool, 1, OreDictionary.WILDCARD_VALUE));

		christmasFocus = ThaumcraftApi.addArcaneCraftingRecipe("Kris-tmas Focus", new ItemStack(ItemRegistry.christmasFocus), CraftingAspects.christmasFocusCrafting, "XYX", "YZY", "XYX", 'X', new ItemStack(Block.blockSnow), 'Y', new ItemStack(Block.pumpkin), 'Z', new ItemStack(ConfigItems.itemFocusFrost));

		electricGoggles = ThaumcraftApi.addArcaneCraftingRecipe("Electric Goggles", new ItemStack(ItemRegistry.electricGoggles), CraftingAspects.electricGogglesCrafting, " Y ", "AZA", "BXB", 'Z', new ItemStack(ConfigItems.itemGoggles), 'X', Items.getItem("electronicCircuit"), 'Y', new ItemStack(Item.helmetDiamond), 'A', new ItemStack(Items.getItem("chargedReBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B', Item.redstoneRepeater);

		shieldBlock = ThaumcraftApi.addArcaneCraftingRecipe("Shield Block", new ItemStack(BlockRegistry.shield, 8), CraftingAspects.shieldBlockCrafting, "XYX", "X X", "XYX", 'X', new ItemStack(Block.glass), 'Y', new ItemStack(Block.obsidian));

		tinyUranium = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Tiny Uranium", new ItemStack(Items.getItem("smallUran235").getItem(), 7), CraftingAspects.tinyUraniumCrafting, Items.getItem("Uran238"));

		compressedSolar = ThaumcraftApi.addArcaneCraftingRecipe("Compressed Solars", new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.compressedSolars, "XXX", "XXX", "XXX", 'X', Items.getItem("solarPanel"));

		doubleCompressedSolar = ThaumcraftApi.addArcaneCraftingRecipe("Compressed Solars", new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.compressedSolars, "XXX", "XXX", "XXX", 'X', new ItemStack(BlockRegistry.emtSolars, 1, 0));

		electricScribingTools = ThaumcraftApi.addArcaneCraftingRecipe("Electric Scribing Tools", new ItemStack(ItemRegistry.electricScribingTools), CraftingAspects.electricScribingTools, "YXY", "XZX", "YXY", 'Y', Items.getItem("electronicCircuit"), 'X', new ItemStack(ConfigItems.itemInkwell), 'Z', new ItemStack(Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE));

		/** Crucible Recipes **/

		ignisGenerator = ThaumcraftApi.addCrucibleRecipe("Ignis Generator", new ItemStack(BlockRegistry.essentiaGens, 1, 1), new ItemStack(BlockRegistry.essentiaGens, 1, 0), CraftingAspects.ignisGeneratorCrafting);

		auramGenerator = ThaumcraftApi.addCrucibleRecipe("Auram Generator", new ItemStack(BlockRegistry.essentiaGens, 1, 2), new ItemStack(BlockRegistry.essentiaGens, 1, 0), CraftingAspects.auramGeneratorCrafting);

		arborGenerator = ThaumcraftApi.addCrucibleRecipe("Arbor Generator", new ItemStack(BlockRegistry.essentiaGens, 1, 3), new ItemStack(BlockRegistry.essentiaGens, 1, 0), CraftingAspects.arborGeneratorCrafting);

		saxumGenerator = ThaumcraftApi.addCrucibleRecipe("Saxum Generator", new ItemStack(BlockRegistry.essentiaGens, 1, 4), new ItemStack(BlockRegistry.essentiaGens, 1, 0), CraftingAspects.saxumGenerator);

		waterSolar = ThaumcraftApi.addCrucibleRecipe("Water Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 3), new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.waterSolars);

		doubleWaterSolar = ThaumcraftApi.addCrucibleRecipe("Water Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 4), new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.waterSolars);

		tripleWaterSolar = ThaumcraftApi.addCrucibleRecipe("Water Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 5), new ItemStack(BlockRegistry.emtSolars, 1, 2), CraftingAspects.waterSolars);

		darkSolar = ThaumcraftApi.addCrucibleRecipe("Entropy Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 6), new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.darkSolars);

		doubleDarkSolar = ThaumcraftApi.addCrucibleRecipe("Entropy Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 7), new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.darkSolars);

		tripleDarkSolar = ThaumcraftApi.addCrucibleRecipe("Entropy Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 8), new ItemStack(BlockRegistry.emtSolars, 1, 2), CraftingAspects.darkSolars);

		orderSolar = ThaumcraftApi.addCrucibleRecipe("Order Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 9), new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.orderSolars);

		doubleOrderSolar = ThaumcraftApi.addCrucibleRecipe("Order Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 10), new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.orderSolars);

		tripleOrderSolar = ThaumcraftApi.addCrucibleRecipe("Order Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 11), new ItemStack(BlockRegistry.emtSolars, 1, 2), CraftingAspects.orderSolars);

		fireSolar = ThaumcraftApi.addCrucibleRecipe("Fire Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 12), new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.fireSolars);

		doubleFireSolar = ThaumcraftApi.addCrucibleRecipe("Fire Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 13), new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.fireSolars);

		tripleFireSolar = ThaumcraftApi.addCrucibleRecipe("Fire Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 14), new ItemStack(BlockRegistry.emtSolars, 1, 2), CraftingAspects.fireSolars);

		airSolar = ThaumcraftApi.addCrucibleRecipe("Air Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars, 1, 15), new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.airSolars);

		doubleAirSolar = ThaumcraftApi.addCrucibleRecipe("Air Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars2, 1, 0), new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.airSolars);

		tripleAirSolar = ThaumcraftApi.addCrucibleRecipe("Air Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars2, 1, 1), new ItemStack(BlockRegistry.emtSolars, 1, 2), CraftingAspects.airSolars);

		earthSolar = ThaumcraftApi.addCrucibleRecipe("Earth Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars2, 1, 2), new ItemStack(BlockRegistry.emtSolars, 1, 0), CraftingAspects.earthSolars);

		doubleEarthSolar = ThaumcraftApi.addCrucibleRecipe("Earth Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars2, 1, 3), new ItemStack(BlockRegistry.emtSolars, 1, 1), CraftingAspects.earthSolars);

		tripleEarthSolar = ThaumcraftApi.addCrucibleRecipe("Earth Infused Solar Panels", new ItemStack(BlockRegistry.emtSolars2, 1, 4), new ItemStack(BlockRegistry.emtSolars, 1, 2), CraftingAspects.earthSolars);

		portableNode = ThaumcraftApi.addCrucibleRecipe("Portable Node", new ItemStack(BlockRegistry.portableNode), new ItemStack(ConfigItems.itemJarFilled), CraftingAspects.portableNode);

		/** IC2 Stuff related recipes **/

		/* Ore Clusters Macerator Recipes */
		ItemStack ironClusterRecipe = Items.getItem("smallIronDust").copy();
		ironClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 16)), null, ironClusterRecipe);

		ItemStack goldClusterRecipe = Items.getItem("smallGoldDust").copy();
		goldClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 31)), null, goldClusterRecipe);

		ItemStack copperClusterRecipe = Items.getItem("smallCopperDust").copy();
		copperClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 17)), null, copperClusterRecipe);

		ItemStack tinClusterRecipe = Items.getItem("smallTinDust").copy();
		tinClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 18)), null, tinClusterRecipe);

		ItemStack silverClusterRecipe = Items.getItem("smallSilverDust").copy();
		silverClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 19)), null, silverClusterRecipe);

		ItemStack leadClusterRecipe = Items.getItem("smallLeadDust").copy();
		leadClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 20)), null, leadClusterRecipe);

		/* Thaumium Plates Recipes */
		thaumiumPlate = GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.thaumiumPlate), "X", "Y", "Z", 'Y', new ItemStack(ConfigItems.itemResource, 1, 2), 'X', new ItemStack(Items.getItem("ForgeHammer").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Z', new ItemStack(Block.obsidian));
		Recipes.metalformerRolling.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemResource, 1, 2)), null, new ItemStack(ItemRegistry.thaumiumPlate));

		/* Ore Processing for Amber and Cinnabar */
		ItemStack crushedAmberRecipe = new ItemStack(ItemRegistry.itemEMTItems, 1, 1);
		crushedAmberRecipe.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigBlocks.blockCustomOre, 1, 7)), null, crushedAmberRecipe);

		ItemStack crushedCinnabarRecipe = new ItemStack(ItemRegistry.itemEMTItems, 1, 3);
		crushedCinnabarRecipe.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigBlocks.blockCustomOre, 1, 0)), null, crushedCinnabarRecipe);

		NBTTagCompound waterAmount = new NBTTagCompound();
		waterAmount.setInteger("amount", 1000);

		Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegistry.itemEMTItems, 1, 1)), waterAmount, new ItemStack[] { new ItemStack(ItemRegistry.itemEMTItems, 1, 2), StackUtil.copyWithSize(Ic2Items.smallCopperDust, 2), Ic2Items.stoneDust });
		Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegistry.itemEMTItems, 1, 3)), waterAmount, new ItemStack[] { new ItemStack(ItemRegistry.itemEMTItems, 1, 4), StackUtil.copyWithSize(Ic2Items.smallTinDust, 2), Ic2Items.stoneDust });

		NBTTagCompound heatAmount = new NBTTagCompound();
		heatAmount.setInteger("minHeat", 1000);

		Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegistry.itemEMTItems, 1, 2)), heatAmount, new ItemStack[] { Ic2Items.smallCopperDust, new ItemStack(ConfigItems.itemResource, 1, 6) });
		Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegistry.itemEMTItems, 1, 4)), heatAmount, new ItemStack[] { Ic2Items.smallTinDust, new ItemStack(ConfigItems.itemResource, 1, 3) });
	}

	public static InfusionRecipe thaumiumDrill;
	public static InfusionRecipe thaumiumChainsaw;
	public static InfusionRecipe thaumicQuantumHelmet;
	public static InfusionRecipe thaumiumOmnitool;
	public static InfusionRecipe thaumicNanoHelmet;
	public static InfusionRecipe explosionFocus;
	public static InfusionRecipe shieldFocus;
	public static InfusionRecipe potentiaGenerator;
	public static InfusionRecipe streamChainsaw;
	public static InfusionRecipe rockbreakerDrill;
	public static InfusionRecipe thorHammer;
	public static InfusionRecipe superchargedThorHammer;
	public static InfusionRecipe wandRecharger;
	public static InfusionRecipe solarHelmetRevealing;
	public static InfusionRecipe electricBootsTravel;
	public static InfusionRecipe nanoBootsTravel;
	public static InfusionRecipe quantumBootsTravel;
	public static InfusionRecipe diamondOmnitoolToThaumium;
	public static InfusionRecipe etheralProcessor;
	public static InfusionRecipe tripleCompressedSolar;
	public static InfusionRecipe electricHoeGrowth;
	public static InfusionRecipe chargeFocus;

	public static ShapelessArcaneRecipe diamondOmnitool;
	public static ShapelessArcaneRecipe tinyUranium;
	public static ShapedArcaneRecipe christmasFocus;
	public static ShapedArcaneRecipe electricGoggles;
	public static ShapedArcaneRecipe shieldBlock;
	public static ShapedArcaneRecipe compressedSolar;
	public static ShapedArcaneRecipe doubleCompressedSolar;
	public static ShapedArcaneRecipe ironOmnitoolToDiamond;
	public static ShapedArcaneRecipe electricScribingTools;

	public static CrucibleRecipe ignisGenerator;
	public static CrucibleRecipe auramGenerator;
	public static CrucibleRecipe arborGenerator;
	public static CrucibleRecipe saxumGenerator;
	public static CrucibleRecipe waterSolar;
	public static CrucibleRecipe doubleWaterSolar;
	public static CrucibleRecipe tripleWaterSolar;
	public static CrucibleRecipe darkSolar;
	public static CrucibleRecipe doubleDarkSolar;
	public static CrucibleRecipe tripleDarkSolar;
	public static CrucibleRecipe orderSolar;
	public static CrucibleRecipe doubleOrderSolar;
	public static CrucibleRecipe tripleOrderSolar;
	public static CrucibleRecipe fireSolar;
	public static CrucibleRecipe doubleFireSolar;
	public static CrucibleRecipe tripleFireSolar;
	public static CrucibleRecipe airSolar;
	public static CrucibleRecipe doubleAirSolar;
	public static CrucibleRecipe tripleAirSolar;
	public static CrucibleRecipe earthSolar;
	public static CrucibleRecipe doubleEarthSolar;
	public static CrucibleRecipe tripleEarthSolar;
	public static CrucibleRecipe portableNode;

	public static IRecipe thaumiumPlate;
}
