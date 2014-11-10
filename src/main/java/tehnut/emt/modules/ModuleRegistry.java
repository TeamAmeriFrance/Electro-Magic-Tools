package tehnut.emt.modules;

import tehnut.emt.ConfigHandler;
import tehnut.emt.modules.base.BaseRecipeRegistry;
import tehnut.emt.modules.base.blocks.BaseBlockRegistry;
import tehnut.emt.modules.base.items.BaseItemRegistry;
import tehnut.emt.modules.base.tile.BaseTileRegistry;

public class ModuleRegistry {

	public static void registerEarlyModules() {

		BaseBlockRegistry.registerBlocks();
		BaseItemRegistry.registerItems();
		BaseRecipeRegistry.registerBaseRecipes();
		BaseTileRegistry.registerBaseTiles();

		if (ConfigHandler.enableIC2Module) {
			// Do stuff
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
