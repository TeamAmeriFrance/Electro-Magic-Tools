package tehnut.emt.modules;

import tehnut.emt.ConfigHandler;
import tehnut.emt.modules.base.BaseRecipeRegistry;
import tehnut.emt.modules.base.blocks.BaseBlockRegistry;
import tehnut.emt.modules.base.items.BaseItemRegistry;
import tehnut.emt.modules.base.tile.BaseTileRegistry;
import tehnut.emt.modules.ic2.IC2RecipeRegistry;
import tehnut.emt.modules.ic2.blocks.IC2BlockRegistry;
import tehnut.emt.modules.ic2.items.IC2ItemRegistry;
import tehnut.emt.modules.ic2.tile.IC2TileRegistry;

public class ModuleRegistry {

	public static void registerEarlyModules() {

		BaseBlockRegistry.registerBlocks();
		BaseItemRegistry.registerItems();
		BaseTileRegistry.registerBaseTiles();
		BaseRecipeRegistry.init();

		if (ConfigHandler.enableIC2Module) {
			IC2BlockRegistry.registerBlocks();
			IC2ItemRegistry.registerItems();
			IC2TileRegistry.registerTiles();
			IC2RecipeRegistry.init();
		}

		if (ConfigHandler.enableTEModule) {
			// Do stuff
		}
	}

	public static void registerMidModules() {

		if (ConfigHandler.enableIC2Module) {
			// Do stuff
		}

		if (ConfigHandler.enableTEModule) {
			// Do stuff
		}
	}

	public static void registerLateModules() {

		if (ConfigHandler.enableIC2Module) {
			// Do stuff
		}

		if (ConfigHandler.enableTEModule) {
			// Do stuff
		}
	}
}
