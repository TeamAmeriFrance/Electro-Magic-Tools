package tehnut.emt.modules.ic2.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import tehnut.emt.modules.ic2.tile.solars.air.TileAirSolar;
import tehnut.emt.modules.ic2.tile.solars.air.TileDoubleAirSolar;
import tehnut.emt.modules.ic2.tile.solars.air.TileTripleAirSolar;
import tehnut.emt.modules.ic2.tile.solars.compressed.TileCompressedSolar;
import tehnut.emt.modules.ic2.tile.solars.compressed.TileDoubleCompressedSolar;
import tehnut.emt.modules.ic2.tile.solars.compressed.TileTripleCompressedSolar;
import tehnut.emt.modules.ic2.tile.solars.dark.TileDarkSolar;
import tehnut.emt.modules.ic2.tile.solars.dark.TileDoubleDarkSolar;
import tehnut.emt.modules.ic2.tile.solars.dark.TileTripleDarkSolar;
import tehnut.emt.modules.ic2.tile.solars.earth.TileDoubleEarthSolar;
import tehnut.emt.modules.ic2.tile.solars.earth.TileEarthSolar;
import tehnut.emt.modules.ic2.tile.solars.earth.TileTripleEarthSolar;
import tehnut.emt.modules.ic2.tile.solars.fire.TileDoubleFireSolar;
import tehnut.emt.modules.ic2.tile.solars.fire.TileFireSolar;
import tehnut.emt.modules.ic2.tile.solars.fire.TileTripleFireSolar;
import tehnut.emt.modules.ic2.tile.solars.order.TileDoubleOrderSolar;
import tehnut.emt.modules.ic2.tile.solars.order.TileOrderSolar;
import tehnut.emt.modules.ic2.tile.solars.order.TileTripleOrderSolar;
import tehnut.emt.modules.ic2.tile.solars.water.TileDoubleWaterSolar;
import tehnut.emt.modules.ic2.tile.solars.water.TileTripleWaterSolar;
import tehnut.emt.modules.ic2.tile.solars.water.TileWaterSolar;

public class IC2TileRegistry {

	public static void registerTiles() {
		// Machines
		GameRegistry.registerTileEntity(TileEtherealMacerator.class, "TileEtherealMacerator");
		GameRegistry.registerTileEntity(TileWandRecharger.class, "TileWandRecharger");
        GameRegistry.registerTileEntity(TileEssentiaGenerator.class, "TileEssentiaGenerator");

		//Solars
		GameRegistry.registerTileEntity(TileCompressedSolar.class, "TileCompressedSolar");
		GameRegistry.registerTileEntity(TileDoubleCompressedSolar.class, "TileDoubleCompressedSolar");
		GameRegistry.registerTileEntity(TileTripleCompressedSolar.class, "TileTripleCompressedSolar");
		GameRegistry.registerTileEntity(TileWaterSolar.class, "TileWaterSolar");
		GameRegistry.registerTileEntity(TileDoubleWaterSolar.class, "TileDoubleWaterSolar");
		GameRegistry.registerTileEntity(TileTripleWaterSolar.class, "TileTripleWaterSolar");
		GameRegistry.registerTileEntity(TileDarkSolar.class, "TileDarkSolar");
		GameRegistry.registerTileEntity(TileDoubleDarkSolar.class, "TileDoubleDarkSolar");
		GameRegistry.registerTileEntity(TileTripleDarkSolar.class, "TileTripleDarkSolar");
		GameRegistry.registerTileEntity(TileOrderSolar.class, "TileOrderSolar");
		GameRegistry.registerTileEntity(TileDoubleOrderSolar.class, "TileDoubleOrderSolar");
		GameRegistry.registerTileEntity(TileTripleOrderSolar.class, "TileTripleOrderSolar");
		GameRegistry.registerTileEntity(TileFireSolar.class, "TileFireSolar");
		GameRegistry.registerTileEntity(TileDoubleFireSolar.class, "TileDoubleFireSolar");
		GameRegistry.registerTileEntity(TileTripleFireSolar.class, "TileTripleFireSolar");
		GameRegistry.registerTileEntity(TileAirSolar.class, "TileAirSolar");
		GameRegistry.registerTileEntity(TileDoubleAirSolar.class, "TileDoubleAirSolar");
		GameRegistry.registerTileEntity(TileTripleAirSolar.class, "TileTripleAirSolar");
		GameRegistry.registerTileEntity(TileEarthSolar.class, "TileEarthSolar");
		GameRegistry.registerTileEntity(TileDoubleEarthSolar.class, "TileDoubleEarthSolar");
		GameRegistry.registerTileEntity(TileTripleEarthSolar.class, "TileTripleEarthSolar");
	}
}
