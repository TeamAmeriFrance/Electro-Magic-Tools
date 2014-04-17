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

import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.common.config.ConfigItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.ItemRegistry;

public class EMTInitRecipes {

	public static void add() {

		/** Crafting Recipes **/
		ironOmnitool = GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.ironOmnitool), "X", "Z", "Y", 'X', new ItemStack(IC2Items.getItem("chainsaw").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Y', new ItemStack(IC2Items.getItem("miningDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Z', IC2Items.getItem("plateiron"));

		diamondChainsaw = GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.diamondChainsaw), " X ", "XYX", 'X', new ItemStack(Items.diamond), 'Y', new ItemStack(IC2Items.getItem("chainsaw").getItem(), 1, OreDictionary.WILDCARD_VALUE));

		if (Loader.isModLoaded("gregtech_addon") == false) {
			GameRegistry.addShapedRecipe(IC2Items.getItem("diamondDrill"), " Y ", "YXY", 'Y', new ItemStack(Items.diamond), 'X', new ItemStack(IC2Items.getItem("miningDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE));
		} else {
			System.out.println("[EMT] Gregtech Addon detected. Disabling the fix for the Diamond Drill recipe.");
		}

		GameRegistry.addRecipe(IC2Items.getItem("nanoHelmet"), "XYX", "XZX", 'X', IC2Items.getItem("carbonPlate"), 'Y', new ItemStack(IC2Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Z', new ItemStack(IC2Items.getItem("nightvisionGoggles").getItem(), 1, OreDictionary.WILDCARD_VALUE));

		GameRegistry.addShapedRecipe(IC2Items.getItem("generator"), "X", "Y", "Z", 'X', new ItemStack(IC2Items.getItem("chargedReBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Y', IC2Items.getItem("machine"), 'Z', new ItemStack(Blocks.furnace));

		GameRegistry.addShapedRecipe(IC2Items.getItem("generator"), "X", "Y", "Z", 'X', IC2Items.getItem("reBattery"), 'Y', IC2Items.getItem("machine"), 'Z', new ItemStack(Blocks.furnace));

		/** Smelting Recipes **/
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.itemEMTItems, 1, 1), new ItemStack(ConfigItems.itemResource, 1, 6), 0.0F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.itemEMTItems, 1, 2), new ItemStack(ConfigItems.itemResource, 1, 6), 0.0F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.itemEMTItems, 1, 3), new ItemStack(ConfigItems.itemResource, 1, 3), 0.0F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.itemEMTItems, 1, 4), new ItemStack(ConfigItems.itemResource, 1, 3), 0.0F);

	}

	public static IRecipe ironOmnitool;
	public static IRecipe diamondChainsaw;
}
