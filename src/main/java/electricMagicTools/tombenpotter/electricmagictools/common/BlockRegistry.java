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
import cpw.mods.fml.common.registry.GameRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEMTMachines;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEMTSolars;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEMTSolars2;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEssentiaGenerators;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockPortableNode;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockShield;
import electricMagicTools.tombenpotter.electricmagictools.common.items.blocks.ItemBlockEMTMachines;
import electricMagicTools.tombenpotter.electricmagictools.common.items.blocks.ItemBlockEMTSolars;
import electricMagicTools.tombenpotter.electricmagictools.common.items.blocks.ItemBlockEMTSolars2;
import electricMagicTools.tombenpotter.electricmagictools.common.items.blocks.ItemBlockEssentiaGenerators;

public class BlockRegistry {
	public static Block essentiaGens;
	public static Block shield;
	public static Block emtSolars;
	public static Block emtMachines;
	public static Block emtSolars2;
	public static Block portableNode;

	public static void registerEMTBlocks() {
		shield = new BlockShield().setBlockName("shield");
		portableNode = new BlockPortableNode().setBlockName("portablenode");
		emtSolars = new BlockEMTSolars().setBlockName("emtsolars");
		essentiaGens = new BlockEssentiaGenerators().setBlockName("essentiaGens");
		emtMachines = new BlockEMTMachines().setBlockName("emtmachines");
		emtSolars2 = new BlockEMTSolars2().setBlockName("emtsolars2");

		GameRegistry.registerBlock(shield, "Shield Block");
		GameRegistry.registerBlock(portableNode, "Portable Node");
		GameRegistry.registerBlock(emtSolars, ItemBlockEMTSolars.class, "EMT Solar Panels");
		GameRegistry.registerBlock(essentiaGens, ItemBlockEssentiaGenerators.class, "Essentia Generators");
		GameRegistry.registerBlock(emtMachines, ItemBlockEMTMachines.class, "EMT Machines");
		GameRegistry.registerBlock(emtSolars2, ItemBlockEMTSolars2.class, "EMT Solars 2");
	}
}
