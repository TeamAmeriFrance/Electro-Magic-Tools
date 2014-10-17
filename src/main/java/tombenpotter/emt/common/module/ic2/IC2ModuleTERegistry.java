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

package tombenpotter.emt.common.module.ic2;

import cpw.mods.fml.common.registry.GameRegistry;
import tombenpotter.emt.common.modules.base.tile.TileEntityPortableNode;
import tombenpotter.emt.common.module.ic2.tile.TileEntityEtherealMacerator;
import tombenpotter.emt.common.module.ic2.tile.TileEntityIndustrialWandRecharge;
import tombenpotter.emt.common.module.ic2.tile.generators.*;
import tombenpotter.emt.common.module.ic2.tile.solars.air.TileEntityAirSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.air.TileEntityDoubleAirSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.air.TileEntityTripleAirSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.compressed.TileEntityCompressedSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.compressed.TileEntityDoubleCompressedSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.compressed.TileEntityTripleCompressedSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.dark.TileEntityDarkSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.dark.TileEntityDoubleDarkSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.dark.TileEntityTripleDarkSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.earth.TileEntityDoubleEarthSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.earth.TileEntityEarthSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.earth.TileEntityTripleEarthSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.fire.TileEntityDoubleFireSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.fire.TileEntityFireSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.fire.TileEntityTripleFireSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.order.TileEntityDoubleOrderSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.order.TileEntityOrderSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.order.TileEntityTripleOrderSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.water.TileEntityDoubleWaterSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.water.TileEntityTripleWaterSolar;
import tombenpotter.emt.common.module.ic2.tile.solars.water.TileEntityWaterSolar;

public class IC2ModuleTERegistry {

    public static void registerTEs() {

        GameRegistry.registerTileEntity(TileEntityPotentiaGenerator.class, "tileentitypotentiagenerator");
        GameRegistry.registerTileEntity(TileEntityIgnisGenerator.class, "tileentityignisgenerator");
        GameRegistry.registerTileEntity(TileEntityAuramGenerator.class, "tileentityauramgenerator");
        GameRegistry.registerTileEntity(TileEntityArborGenerator.class, "tileentityarborgenerator");
        GameRegistry.registerTileEntity(TileEntityAerGenerator.class, "tileentityaergenerator");
        GameRegistry.registerTileEntity(TileEntityIndustrialWandRecharge.class, "tileentityindustrialwandrecharge");
        GameRegistry.registerTileEntity(TileEntityCompressedSolar.class, "tileentitycompressedsolar");
        GameRegistry.registerTileEntity(TileEntityDoubleCompressedSolar.class, "tileentitydoublecompressedsolar");
        GameRegistry.registerTileEntity(TileEntityTripleCompressedSolar.class, "tileentitytriplecompressedsolar");
        GameRegistry.registerTileEntity(TileEntityEtherealMacerator.class, "tileentityetherealmacerator");
        GameRegistry.registerTileEntity(TileEntityWaterSolar.class, "tileentitywatersolar");
        GameRegistry.registerTileEntity(TileEntityDoubleWaterSolar.class, "tileentitydoublewatersolar");
        GameRegistry.registerTileEntity(TileEntityTripleWaterSolar.class, "tileentitytriplewatersolar");
        GameRegistry.registerTileEntity(TileEntityDarkSolar.class, "tileentitydarksolar");
        GameRegistry.registerTileEntity(TileEntityDoubleDarkSolar.class, "tileentitydoubledarksolar");
        GameRegistry.registerTileEntity(TileEntityTripleDarkSolar.class, "tileentitytripledarksolar");
        GameRegistry.registerTileEntity(TileEntityOrderSolar.class, "tileentityordersolar");
        GameRegistry.registerTileEntity(TileEntityDoubleOrderSolar.class, "tileentitydoubleordersolar");
        GameRegistry.registerTileEntity(TileEntityTripleOrderSolar.class, "tileentitytripleordersolar");
        GameRegistry.registerTileEntity(TileEntityFireSolar.class, "tileentityfiresolar");
        GameRegistry.registerTileEntity(TileEntityDoubleFireSolar.class, "tileentitydoublefiresolar");
        GameRegistry.registerTileEntity(TileEntityTripleFireSolar.class, "tileentitytriplefiresolar");
        GameRegistry.registerTileEntity(TileEntityAirSolar.class, "tileentityairsolar");
        GameRegistry.registerTileEntity(TileEntityDoubleAirSolar.class, "tileentitydoubleairsolar");
        GameRegistry.registerTileEntity(TileEntityTripleAirSolar.class, "tileentitytripleairsolar");
        GameRegistry.registerTileEntity(TileEntityEarthSolar.class, "tileentityearthsolar");
        GameRegistry.registerTileEntity(TileEntityDoubleEarthSolar.class, "tileentitydoubleearthsolar");
        GameRegistry.registerTileEntity(TileEntityTripleEarthSolar.class, "tileentitytripleearthsolar");
        GameRegistry.registerTileEntity(TileEntityPortableNode.class, "tileentityportablenode");
        GameRegistry.registerTileEntity(TileEntityEssentiaGenerator.class, "tileentityessentiagenerator");
    }
}
