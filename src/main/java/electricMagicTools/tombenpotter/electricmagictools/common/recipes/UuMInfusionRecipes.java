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
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import electricMagicTools.tombenpotter.electricmagictools.common.lib.CraftingAspects;

public class UuMInfusionRecipes
{
	public static ItemStack uuMCell = Items.getItem("UuMatterCell");

	public static void add() {

		ItemStack iridium = Items.getItem("iridiumOre").copy();
		iridium.stackSize = 2;
		uraniumToIridium = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", iridium, 4, CraftingAspects.uuMatterInfusions, Items.getItem("Uran238"), new ItemStack[] { uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell });

		ItemStack uranium = Items.getItem("Uran238").copy();
		uranium.stackSize = 2;
		diamondToUranium = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", uranium, 4, CraftingAspects.lesserUUMInfusions, new ItemStack(Item.diamond), new ItemStack[] { uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell });

		ItemStack diamond = new ItemStack(Item.diamond).copy();
		diamond.stackSize = 1;
		goldToDiamond = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", diamond, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Item.ingotGold), new ItemStack[] { uuMCell, uuMCell, uuMCell, uuMCell });

		ItemStack gold = new ItemStack(Item.ingotGold).copy();
		gold.stackSize = 2;
		ironToGold = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", gold, 4, CraftingAspects.cheapestUUMInfusions, new ItemStack(Item.ingotIron), new ItemStack[] { uuMCell, uuMCell, uuMCell });

		ItemStack ironOre = new ItemStack(Block.oreIron).copy();
		ironOre.stackSize = 16;
		stoneBricksToIronOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", ironOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Block.stoneBrick), new ItemStack[] { uuMCell, uuMCell });

		/**
		 * ItemStack copperOre = Items.getItem("copperOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack copperOre = Items.getItem("crushedCopperOre").copy();
		copperOre.stackSize = 32;
		arcaneStoneToCopperOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", copperOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 6), new ItemStack[] { uuMCell, uuMCell });

		/**
		 * ItemStack tinOre = Items.getItem("tinOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack tinOre = Items.getItem("crushedTinOre").copy();
		tinOre.stackSize = 32;
		arcaneStoneBricksToTinOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", tinOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 7), new ItemStack[] { uuMCell, uuMCell });

		/**
		 * ItemStack leadOre = Items.getItem("leadOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack leadOre = Items.getItem("crushedLeadOre").copy();
		leadOre.stackSize = 32;
		amberBlockToLeadOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", leadOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticOpaque, 1, 0), new ItemStack[] { uuMCell, uuMCell });

		ItemStack coal = new ItemStack(Item.coal, 1, 0).copy();
		coal.stackSize = 16;
		charcoalToCoal = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", coal, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Item.coal, 1, 1), new ItemStack[] { uuMCell, uuMCell });

		ItemStack stickyResin = Items.getItem("resin").copy();
		stickyResin.stackSize = 21;
		shardToResin = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", stickyResin, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { uuMCell, uuMCell, uuMCell });

		ItemStack redstone = new ItemStack(Item.redstone).copy();
		redstone.stackSize = 24;
		shardToRedstone = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", redstone, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { uuMCell, uuMCell, uuMCell });

		ItemStack lapisLazuli = new ItemStack(Item.dyePowder, 1, 4).copy();
		lapisLazuli.stackSize = 8;
		shardToLapis = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", lapisLazuli, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[] { uuMCell, uuMCell, uuMCell });

		ItemStack glowstone = new ItemStack(Block.glowStone).copy();
		glowstone.stackSize = 1;
		glowstoneDustToBlock = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", glowstone, 4, CraftingAspects.cheapestUUMInfusions, new ItemStack(Item.glowstone), new ItemStack[] { uuMCell });

	}

	public static InfusionRecipe uraniumToIridium;
	public static InfusionRecipe diamondToUranium;
	public static InfusionRecipe goldToDiamond;
	public static InfusionRecipe ironToGold;
	public static InfusionRecipe stoneBricksToIronOre;
	public static InfusionRecipe arcaneStoneToCopperOre;
	public static InfusionRecipe arcaneStoneBricksToTinOre;
	public static InfusionRecipe amberBlockToLeadOre;
	public static InfusionRecipe charcoalToCoal;
	public static InfusionRecipe shardToResin;
	public static InfusionRecipe shardToRedstone;
	public static InfusionRecipe shardToLapis;
	public static InfusionRecipe glowstoneDustToBlock;
}
