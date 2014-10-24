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

package tombenpotter.emt.common.modules.ic2.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.module.ic2.blocks.*;
import tombenpotter.emt.common.module.ic2.items.blocks.*;

public class IC2BlockRegistry {

    public static Block essentiaGens;
    public static Block shield;
    public static Block emtSolars;
    public static Block emtMachines;
    public static Block emtSolars2;
    public static Block portableNode;
    public static Block essentiaGenerator;

    public static void registerBlocks() {
        shield = new BlockShield().setBlockName(ModInformation.modid + ".shield");
        GameRegistry.registerBlock(shield, "ShieldBlock");

        portableNode = new BlockPortableNode().setBlockName(ModInformation.modid + ".portablenode");
        GameRegistry.registerBlock(portableNode, "PortableNode");

        emtSolars = new BlockEMTSolars().setBlockName(ModInformation.modid + ".emtsolars");
        GameRegistry.registerBlock(emtSolars, ItemBlockEMTSolars.class, "EMTSolars");

        emtSolars2 = new BlockEMTSolars2().setBlockName(ModInformation.modid + ".emtsolars2");
        GameRegistry.registerBlock(emtSolars2, ItemBlockEMTSolars2.class, "EMTSolars2");

        emtMachines = new BlockEMTMachines().setBlockName(ModInformation.modid + ".emtmachines");
        GameRegistry.registerBlock(emtMachines, ItemBlockEMTMachines.class, "EMTMachines");

        essentiaGens = new BlockEssentiaGenerators().setBlockName(ModInformation.modid + ".essentiaGens");
        GameRegistry.registerBlock(essentiaGens, ItemBlockEssentiaGenerators.class, "EssentiaGenerators");

        essentiaGenerator = new BlockEssentiaGenerator().setBlockName(ModInformation.modid + ".essentiaGenerator");
        GameRegistry.registerBlock(essentiaGenerator, ItemBlockEssentiaGenerator.class, "Essentia Generator");
    }
}
