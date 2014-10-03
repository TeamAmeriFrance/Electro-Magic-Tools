package tombenpotter.emt.common.modules;

import tombenpotter.emt.common.modules.base.blocks.BaseBlockRegistry;
import tombenpotter.emt.common.modules.base.BaseRecipeRegistry;
import tombenpotter.emt.common.modules.base.items.BaseItemRegistry;
import tombenpotter.emt.common.modules.ic2.IC2RecipeRegistry;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.items.IC2ItemRegistry;
import tombenpotter.emt.common.modules.te.TERecipeRegistry;
import tombenpotter.emt.common.modules.te.blocks.TEBlockRegistry;
import tombenpotter.emt.common.modules.te.items.TEItemRegistry;
import tombenpotter.emt.common.util.ConfigHandler;

public class ModuleRegistry {

	public static void RegisterModules() {

		BaseBlockRegistry.registerBaseBlocks();
		BaseItemRegistry.registerBaseItems();
		BaseRecipeRegistry.registerBaseRecipes();

		if (ConfigHandler.enableIC2Module) {
			IC2BlockRegistry.registerIC2Blocks();
			IC2ItemRegistry.registerIC2Items();
			IC2RecipeRegistry.registerIC2Recipes();
		}

		if (ConfigHandler.enableTEModule) {
			TEBlockRegistry.registerTEBlocks();
			TEItemRegistry.registerTEItems();
			TERecipeRegistry.registerTERecipes();
		}
	}
}
