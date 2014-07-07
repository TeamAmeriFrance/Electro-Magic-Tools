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

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityRegistry {

    public static void registerEMTTileEntites() {

        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPotentiaGenerator.class, "tileentityessentiagenerator");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIgnisGenerator.class, "tileentityignisgenerator");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAuramGenerator.class, "tileentityauramgenerator");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityArborGenerator.class, "tileentityarborgenerator");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge.class, "tileentityindustrialwandrecharge");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityCompressedSolar.class, "tileentitycompressedsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleCompressedSolar.class, "tileentitydoublecompressedsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleCompressedSolar.class, "tileentitytriplecompressedsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEtherealMacerator.class, "tileentityetherealmacerator");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityWaterSolar.class, "tileentitywatersolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleWaterSolar.class, "tileentitydoublewatersolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleWaterSolar.class, "tileentitytriplewatersolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDarkSolar.class, "tileentitydarksolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleDarkSolar.class, "tileentitydoubledarksolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleDarkSolar.class, "tileentitytripledarksolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityOrderSolar.class, "tileentityordersolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleOrderSolar.class, "tileentitydoubleordersolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleOrderSolar.class, "tileentitytripleordersolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityFireSolar.class, "tileentityfiresolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleFireSolar.class, "tileentitydoublefiresolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleFireSolar.class, "tileentitytriplefiresolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityAirSolar.class, "tileentityairsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleAirSolar.class, "tileentitydoubleairsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleAirSolar.class, "tileentitytripleairsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityEarthSolar.class, "tileentityearthsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleEarthSolar.class, "tileentitydoubleearthsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleEarthSolar.class, "tileentitytripleearthsolar");
        GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPortableNode.class, "tileentityportablenode");
    }
}
