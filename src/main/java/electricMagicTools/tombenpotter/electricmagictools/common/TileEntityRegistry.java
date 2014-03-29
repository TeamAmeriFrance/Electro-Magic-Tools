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

public class TileEntityRegistry
{

	public static void registerEMTTileEntites() {

		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPotentiaGenerator.class, "tileentityessentiagenerator");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIgnisGenerator.class, "tileentityignisgenerator");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAuramGenerator.class, "tileentityauramgenerator");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityArborGenerator.class, "tileentityarborgenerator");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge.class, "tileentityindustrialwandrecharge");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityCompressedSolar.class, "tileentitycompressedsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleCompressedSolar.class, "tileentitydoublecompressedsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEtherealMacerator.class, "tileentityetherealmacerator");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityWaterSolar.class, "tileentitywatersolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleWaterSolar.class, "tileentitydoublewatersolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleWaterSolar.class, "tileentitytriplewatersolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDarkSolar.class, "tileentitydarksolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleDarkSolar.class, "tileentitydoubledarksolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleDarkSolar.class, "tileentitytripledarksolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityOrderSolar.class, "tileentityordersolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleOrderSolar.class, "tileentitydoubleordersolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleOrderSolar.class, "tileentitytripleordersolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityFireSolar.class, "tileentityfiresolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleFireSolar.class, "tileentitydoublefiresolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleFireSolar.class, "tileentitytriplefiresolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAirSolar.class, "tileentityairsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleAirSolar.class, "tileentitydoubleairsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleAirSolar.class, "tileentitytripleairsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEarthSolar.class, "tileentityearthsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleEarthSolar.class, "tileentitydoubleearthsolar");
		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleEarthSolar.class, "tileentitytripleearthsolar");

		GameRegistry.registerTileEntity(electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPortableNode.class, "tileentityportablenode");
	}

}
