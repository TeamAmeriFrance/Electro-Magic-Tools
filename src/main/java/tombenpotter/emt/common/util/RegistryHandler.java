package tombenpotter.emt.common.util;

import tombenpotter.emt.common.module.ic2.IC2ModuleBlockRegistry;
import tombenpotter.emt.common.module.ic2.IC2ModuleItemRegistry;
import tombenpotter.emt.common.module.ic2.IC2ModuleResearch;
import tombenpotter.emt.common.module.ic2.IC2ModuleTERegistry;
import tombenpotter.emt.common.module.vanilla.VanillaBlocksRegistry;
import tombenpotter.emt.common.module.vanilla.VanillaItemsRegistry;
import tombenpotter.emt.common.module.vanilla.VanillaRecipesRegistry;

public class RegistryHandler {

	public static void registerVanillaRegistrys() {
		VanillaBlocksRegistry.registerBlocks();
		VanillaItemsRegistry.registerItems();
		VanillaRecipesRegistry.registerRecipes();
	}

	public static void registerIc2Registrys() {
		IC2ModuleItemRegistry.registerItems();
		IC2ModuleBlockRegistry.registerBlocks();
		IC2ModuleTERegistry.registerTEs();
	}

	public static void registerIc2PostRegistrys() {
		IC2ModuleResearch.addResearchTab();
		IC2ModuleResearch.addResearch();
	}

	public static void registerTeRegistrys() {

	}
}
