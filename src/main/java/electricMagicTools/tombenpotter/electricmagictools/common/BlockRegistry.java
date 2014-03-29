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
package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEMTMachines;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEMTSolars;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEMTSolars2;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEssentiaGenerators;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockPortableNode;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockShield;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemBlockEMTMachines;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemBlockEMTSolars;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemBlockEMTSolars2;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemBlockEssentiaGenerators;

public class BlockRegistry
{

	public static Block essentiaGens;
	public static Block shield;
	public static Block emtSolars;
	public static Block emtMachines;
	public static Block emtSolars2;
	public static Block portableNode;

	public static void registerEMTBlocks() {

		shield = new BlockShield(Config.shieldID).setUnlocalizedName("shield");
		portableNode = new BlockPortableNode(Config.portableNodeID).setUnlocalizedName("portablenode");

		emtSolars = new BlockEMTSolars(Config.emtSolarsID).setUnlocalizedName("emtsolars");
		essentiaGens = new BlockEssentiaGenerators(Config.essentiaGensID).setUnlocalizedName("essentiaGens");
		emtMachines = new BlockEMTMachines(Config.emtMachinesID).setUnlocalizedName("emtmachines");
		emtSolars2 = new BlockEMTSolars2(Config.emtSolars2ID).setUnlocalizedName("emtsolars2");

		GameRegistry.registerBlock(shield, "Shield Block");

		GameRegistry.registerBlock(portableNode, "Portable Node");
		GameRegistry.registerBlock(emtSolars, ItemBlockEMTSolars.class, "EMT Solar Panels");
		GameRegistry.registerBlock(essentiaGens, ItemBlockEssentiaGenerators.class, "Essentia Generators");
		GameRegistry.registerBlock(emtMachines, ItemBlockEMTMachines.class, "EMT Machines");
		GameRegistry.registerBlock(emtSolars2, ItemBlockEMTSolars2.class, "EMT Solars 2");

		LanguageRegistry.addName(new ItemStack(essentiaGens, 1, 0), "Potentia Generator");
		LanguageRegistry.addName(new ItemStack(essentiaGens, 1, 1), "Ignis Generator");
		LanguageRegistry.addName(new ItemStack(essentiaGens, 1, 2), "Auram Generator");
		LanguageRegistry.addName(new ItemStack(essentiaGens, 1, 3), "Arbor Generator");
		LanguageRegistry.addName(new ItemStack(essentiaGens, 1, 4), "Saxum Generator");
		LanguageRegistry.addName(shield, "Shield Block");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 0), "Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 1), "Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 2), "Triple Compessed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtMachines, 1, 0), "Industrial Wand Charging Station");
		LanguageRegistry.addName(new ItemStack(emtMachines, 1, 1), "Ethereal Processor");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 3), "Water Infused Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 4), "Water Infused Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 5), "Water Infused Triple Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 6), "Entropy Infused Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 7), "Entropy Infused Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 8), "Entropy Infused Triple Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 9), "Order Infused Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 10), "Order Infused Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 11), "Order Infused Triple Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 12), "Fire Infused Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 13), "Fire Infused Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 14), "Fire Infused Triple Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars, 1, 15), "Air Infused Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars2, 1, 0), "Air Infused Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars2, 1, 1), "Air Infused Triple Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars2, 1, 2), "Earth Infused Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars2, 1, 3), "Earth Infused Double Compressed Solar Panel");
		LanguageRegistry.addName(new ItemStack(emtSolars2, 1, 4), "Earth Infused Triple Compressed Solar Panel");
		LanguageRegistry.addName(portableNode, "Portable Node");
	}
}
