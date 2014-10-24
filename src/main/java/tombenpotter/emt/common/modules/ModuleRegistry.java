package tombenpotter.emt.common.modules;

import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.common.modules.base.BaseRecipeRegistry;
import tombenpotter.emt.common.modules.base.blocks.BaseBlockRegistry;
import tombenpotter.emt.common.modules.base.items.BaseItemRegistry;
import tombenpotter.emt.common.modules.ic2.IC2RecipeRegistry;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.items.IC2ItemRegistry;
import tombenpotter.emt.common.modules.te.TERecipeRegistry;
import tombenpotter.emt.common.modules.te.blocks.TEBlockRegistry;
import tombenpotter.emt.common.modules.te.items.TEItemRegistry;
import tombenpotter.emt.common.util.ConfigHandler;

import static tombenpotter.emt.common.util.TextHelper.localize;

public class ModuleRegistry {

    public static void registerModules() {

        BaseBlockRegistry.registerBaseBlocks();
		BaseItemRegistry.registerItems();
		BaseRecipeRegistry.registerRecipes();

		if (ConfigHandler.enableIC2Module) {
			IC2BlockRegistry.registerBlocks();
			IC2ItemRegistry.registerItems();
			ElectroMagicTools.logger.info(localize("console.EMT.init.recipes.ic2"));
			IC2RecipeRegistry.registerEarlyRecipes();
		}

		if (ConfigHandler.enableTEModule) {
			TEBlockRegistry.registerTEBlocks();
			TEItemRegistry.registerTEItems();
			TERecipeRegistry.registerTERecipes();
		}
    }
}
