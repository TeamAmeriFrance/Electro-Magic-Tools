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

package tombenpotter.emt.common.module.ic2.recipes;

import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import tombenpotter.emt.common.util.CraftingAspects;

public class UuMInfusionRecipes {

	public static ItemStack uuMCell = IC2Items.getItem("UuMatterCell");

	public static void add() {

		ItemStack iridium = IC2Items.getItem("iridiumOre").copy();
		iridium.stackSize = 2;
		uraniumToIridium = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", iridium, 4, CraftingAspects.uuMatterInfusions, IC2Items.getItem("Uran238"), new ItemStack[]{uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell});

		ItemStack uranium = IC2Items.getItem("Uran238").copy();
		uranium.stackSize = 2;
		diamondToUranium = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", uranium, 4, CraftingAspects.lesserUUMInfusions, new ItemStack(Items.diamond), new ItemStack[]{uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell});

		ItemStack diamond = new ItemStack(Items.diamond).copy();
		diamond.stackSize = 1;
		goldToDiamond = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", diamond, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Items.gold_ingot), new ItemStack[]{uuMCell, uuMCell, uuMCell, uuMCell});

		ItemStack gold = new ItemStack(Items.gold_ingot).copy();
		gold.stackSize = 2;
		ironToGold = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", gold, 4, CraftingAspects.cheapestUUMInfusions, new ItemStack(Items.iron_ingot), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack ironOre = new ItemStack(Blocks.iron_ore).copy();
		ironOre.stackSize = 16;
		stoneBricksToIronOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", ironOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Blocks.stonebrick), new ItemStack[]{uuMCell, uuMCell});

		/**
		 * ItemStack copperOre = Items.getItem("copperOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack copperOre = IC2Items.getItem("crushedCopperOre").copy();
		copperOre.stackSize = 32;
		arcaneStoneToCopperOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", copperOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 6), new ItemStack[]{uuMCell, uuMCell});

		/**
		 * ItemStack tinOre = Items.getItem("tinOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack tinOre = IC2Items.getItem("crushedTinOre").copy();
		tinOre.stackSize = 32;
		arcaneStoneBricksToTinOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", tinOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 7), new ItemStack[]{uuMCell, uuMCell});

		/**
		 * ItemStack leadOre = Items.getItem("leadOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack leadOre = IC2Items.getItem("crushedLeadOre").copy();
		leadOre.stackSize = 32;
		amberBlockToLeadOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", leadOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticOpaque, 1, 0), new ItemStack[]{uuMCell, uuMCell});

		ItemStack uraniumOre = IC2Items.getItem("uraniumOre").copy();
		uraniumOre.stackSize = 8;
		amberBricksToUraniumOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", uraniumOre, 4, CraftingAspects.lesserUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticOpaque, 1, 1), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack coal = new ItemStack(Items.coal, 1, 0).copy();
		coal.stackSize = 16;
		charcoalToCoal = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", coal, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Items.coal, 1, 1), new ItemStack[]{uuMCell, uuMCell});

		ItemStack stickyResin = IC2Items.getItem("resin").copy();
		stickyResin.stackSize = 21;
		shardToResin = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", stickyResin, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack redstone = new ItemStack(Items.redstone).copy();
		redstone.stackSize = 24;
		shardToRedstone = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", redstone, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack lapisLazuli = new ItemStack(Items.dye, 1, 4).copy();
		lapisLazuli.stackSize = 8;
		shardToLapis = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", lapisLazuli, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack glowstone = new ItemStack(Blocks.glowstone).copy();
		glowstone.stackSize = 1;
		glowstoneDustToBlock = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", glowstone, 4, CraftingAspects.cheapestUUMInfusions, new ItemStack(Items.glowstone_dust), new ItemStack[]{uuMCell});
	}

	public static InfusionRecipe uraniumToIridium;
	public static InfusionRecipe diamondToUranium;
	public static InfusionRecipe goldToDiamond;
	public static InfusionRecipe ironToGold;
	public static InfusionRecipe stoneBricksToIronOre;
	public static InfusionRecipe arcaneStoneToCopperOre;
	public static InfusionRecipe arcaneStoneBricksToTinOre;
	public static InfusionRecipe amberBlockToLeadOre;
	public static InfusionRecipe amberBricksToUraniumOre;
	public static InfusionRecipe charcoalToCoal;
	public static InfusionRecipe shardToResin;
	public static InfusionRecipe shardToRedstone;
	public static InfusionRecipe shardToLapis;
	public static InfusionRecipe glowstoneDustToBlock;
}
