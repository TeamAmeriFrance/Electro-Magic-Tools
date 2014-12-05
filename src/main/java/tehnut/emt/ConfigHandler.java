package tehnut.emt;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public static Configuration config;

	// Config categories
	public static String modules = "Modules";
	public static String research = "Research";
	public static String values = "Numeric Values";
	public static String misc = "Misc Options";
	public static String generators = "Essentia Generator Outputs";

	// Config Options
	public static boolean thaumiumDrillResearch;
	public static boolean thaumiumChainsawResearch;
	public static boolean thaumiumOmnitoolResearch;
	public static boolean rockbreakerDrillResearch;
	public static boolean streamChainsawResearch;
	public static boolean electricGogglesResearch;
	public static boolean nanoGogglesResearch;
	public static boolean quantumGogglesResearch;
	public static boolean ironOmnitoolResearch;
	public static boolean diamondOmnitoolResearch;
	public static boolean explosionFocusResearch;
	public static boolean christmasFocusResearch;
	public static boolean shieldFocusResearch;
	public static boolean shieldBlockResearch;
	public static boolean potentiaGeneratorResearch;
	public static boolean ignisGeneratorResearch;
	public static boolean auramGeneratorResearch;
	public static boolean arborGeneratorResearch;
	public static boolean wandChargingSationResearch;
	public static boolean tinyUraniumResearch;
	public static boolean thorHammerResearch;
	public static boolean superchargedThorHammerResearch;
	public static boolean compressedSolarsResearch;
	public static boolean solarHelmetResearch;
	public static boolean electricBootsResearch;
	public static boolean nanoBootsResearch;
	public static boolean quantumBootsResearch;
	public static boolean electricScribingToolsResearch;
	public static boolean etherealProcessorResearch;
	public static boolean waterSolarsResearch;
	public static boolean darkSolarsResearch;
	public static boolean orderSolarsResearch;
	public static boolean fireSolarsResearch;
	public static boolean airSolarsResearch;
	public static boolean earthSolarsResearch;
	public static boolean saxumGenResearch;
	public static boolean uuMInfusionResearch;
	public static boolean portableNodeResarch;
	public static boolean electricHoeGrowthResearch;
	public static boolean chargeFocusResearch;
	public static boolean wandChargeFocusResearch;
	public static boolean inventoryChargingRing;
	public static boolean armorChargingRing;
	public static boolean thaumiumWingResearch;
	public static boolean nanoWingResearch;
	public static boolean quantumWingsResearch;
	public static boolean aerGeneratorResearch;

	public static int armorBaubleProduction;
	public static int inventoryBaubleProduction;
	public static double nanoBootsSpeed;
	public static double nanoBootsJump;
	public static double quantumBootsSpeed;
	public static double quantumBootsJump;
	public static int chargeFocusProduction;
	public static int wandChargeFocusCost;

	public static boolean oneRingSpawn;
	public static boolean thorHammerSpawn;
	public static int chanceOneRing;
	public static int chanceTaintedMjolnir;
	public static boolean allowEnchanting;
	public static boolean nightVisionOff;

	public static boolean enableIC2Module;
	public static boolean enableTEModule;
	public static boolean enableToolModule;

	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}

	public static void syncConfig() {
		config.addCustomCategoryComment(values, "The only way to change some numbers that my machines uses.");
		config.addCustomCategoryComment(research, "The only way to disable some researches. Be careful, if you disable some researches, all researches linked to it will be removed too. Really, don't touch that unless you know exactly what you are doing. If a research is part of a disabled module, don't worry about it.");
		config.addCustomCategoryComment(values, "Change outputs linked to different Essentias here");
		config.addCustomCategoryComment(misc, "Options that don't fit into the other categories.");
		config.addCustomCategoryComment(modules, "Select the modules to play with.");

		// Research
		thaumiumDrillResearch = config.get(research, "thaumiumDrillResearch", true).getBoolean(thaumiumDrillResearch);
		thaumiumChainsawResearch = config.get(research, "thaumiumChainsawResearch", true).getBoolean(thaumiumChainsawResearch);
		thaumiumDrillResearch = config.get(research, "thaumiumDrillResearch", true).getBoolean(thaumiumOmnitoolResearch);
		rockbreakerDrillResearch = config.get(research, "rockbreakerDrillResearch", true).getBoolean(rockbreakerDrillResearch);
		streamChainsawResearch = config.get(research, "streamChainsawResearch", true).getBoolean(streamChainsawResearch);
		electricGogglesResearch = config.get(research, "electricGogglesResearch", true).getBoolean(electricGogglesResearch);
		nanoGogglesResearch = config.get(research, "nanoGogglesResearch", true).getBoolean(nanoGogglesResearch);
		quantumGogglesResearch = config.get(research, "quantumGogglesResearch", true).getBoolean(quantumGogglesResearch);
		ironOmnitoolResearch = config.get(research, "ironOmnitoolResearch", true).getBoolean(ironOmnitoolResearch);
		diamondOmnitoolResearch = config.get(research, "diamondOmnitoolResearch", true).getBoolean(diamondOmnitoolResearch);
		explosionFocusResearch = config.get(research, "explosionFocusResearch", true).getBoolean(explosionFocusResearch);
		christmasFocusResearch = config.get(research, "christmasFocusResearch", true).getBoolean(christmasFocusResearch);
		shieldFocusResearch = config.get(research, "shieldFocusResearch", true).getBoolean(shieldFocusResearch);
		shieldBlockResearch = config.get(research, "shieldBlockResearch", true).getBoolean(shieldBlockResearch);
		potentiaGeneratorResearch = config.get(research, "potentiaGeneratorResearch", true).getBoolean(potentiaGeneratorResearch);
		ignisGeneratorResearch = config.get(research, "ignisGeneratorResearch", true).getBoolean(ignisGeneratorResearch);
		auramGeneratorResearch = config.get(research, "auramGeneratorResearch", true).getBoolean(auramGeneratorResearch);
		arborGeneratorResearch = config.get(research, "arborGeneratorResearch", true).getBoolean(arborGeneratorResearch);
		wandChargingSationResearch = config.get(research, "wandChargingSationResearch", true).getBoolean(wandChargingSationResearch);
		tinyUraniumResearch = config.get(research, "tinyUraniumResearch", true).getBoolean(tinyUraniumResearch);
		thorHammerResearch = config.get(research, "thorHammerResearch", true).getBoolean(thorHammerResearch);
		superchargedThorHammerResearch = config.get(research, "superchargedThorHammerResearch", true).getBoolean(superchargedThorHammerResearch);
		compressedSolarsResearch = config.get(research, "compressedSolarsResearch", true).getBoolean(compressedSolarsResearch);
		solarHelmetResearch = config.get(research, "solarHelmetResearch", true).getBoolean(solarHelmetResearch);
		electricBootsResearch = config.get(research, "electricBootsResearch", true).getBoolean(electricBootsResearch);
		nanoBootsResearch = config.get(research, "nanoBootsResearch", true).getBoolean(nanoBootsResearch);
		quantumBootsResearch = config.get(research, "quantumBootsResearch", true).getBoolean(quantumBootsResearch);
		electricScribingToolsResearch = config.get(research, "electricScribingToolsResearch", true).getBoolean(electricScribingToolsResearch);
		etherealProcessorResearch = config.get(research, "etherealProcessorResearch", true).getBoolean(etherealProcessorResearch);
		waterSolarsResearch = config.get(research, "waterSolarsResearch", true).getBoolean(waterSolarsResearch);
		darkSolarsResearch = config.get(research, "darkSolarsResearch", true).getBoolean(darkSolarsResearch);
		orderSolarsResearch = config.get(research, "orderSolarsResearch", true).getBoolean(orderSolarsResearch);
		fireSolarsResearch = config.get(research, "fireSolarsResearch", true).getBoolean(fireSolarsResearch);
		airSolarsResearch = config.get(research, "airSolarsResearch", true).getBoolean(airSolarsResearch);
		earthSolarsResearch = config.get(research, "earthSolarsResearch", true).getBoolean(earthSolarsResearch);
		saxumGenResearch = config.get(research, "saxumGenResearch", true).getBoolean(saxumGenResearch);
		uuMInfusionResearch = config.get(research, "uuMInfusionResearch", true).getBoolean(uuMInfusionResearch);
		portableNodeResarch = config.get(research, "portableNodeResarch", true).getBoolean(portableNodeResarch);
		electricHoeGrowthResearch = config.get(research, "electricHoeGrowthResearch", true).getBoolean(electricHoeGrowthResearch);
		chargeFocusResearch = config.get(research, "chargeFocusResearch", true).getBoolean(chargeFocusResearch);
		wandChargeFocusResearch = config.get(research, "wandChargeFocusResearch", true).getBoolean(wandChargeFocusResearch);
		inventoryChargingRing = config.get(research, "inventoryChargingRing", true).getBoolean(inventoryChargingRing);
		armorChargingRing = config.get(research, "armorChargingRing", true).getBoolean(armorChargingRing);
		thaumiumWingResearch = config.get(research, "thaumiumWingResearch", true).getBoolean(thaumiumWingResearch);
		nanoWingResearch = config.get(research, "nanoWingResearch", true).getBoolean(nanoWingResearch);
		quantumWingsResearch = config.get(research, "quantumWingsResearch", true).getBoolean(quantumWingsResearch);
		aerGeneratorResearch = config.get(research, "aerGeneratorResearch", true).getBoolean(aerGeneratorResearch);

		// Numeric Values
		armorBaubleProduction = config.get(values, "armorBaubleProduction", 32, "EU/t the ring will charge at. Default is 32.").getInt();
		inventoryBaubleProduction = config.get(values, "inventoryBaubleProduction", 32, "EU/t the ring will charge at. Default is 32.").getInt();
		nanoBootsSpeed = config.get(values, "nanoBootsSpeed", 0.25, "Watch out, that goes up REALLY quickly. Default is 0.25").getDouble();
		nanoBootsJump = config.get(values, "nanoBootsJump", 0.6, "Watch out, that goes up REALLY quickly. Default is 0.6").getDouble();
		quantumBootsSpeed = config.get(values, "quantumBootsSpeed", 0.5, "Watch out, that goes up REALLY quickly. Default is 0.5").getDouble();
		quantumBootsJump = config.get(values, "quantumBootsJump", 0.9, "Watch out, that goes up REALLY quickly. Default is 0.9").getDouble();
		chargeFocusProduction = config.get(values, "chargeFocusProduction", 64, "EU/t that the Wand Focus: Charging will produce. Default is 64.").getInt();
		wandChargeFocusCost = config.get(values, "wandChargeFocusCost", 40000, "EU/vis restored. Default is 40000.").getInt();

		// Misc Options
		oneRingSpawn = config.get(misc, "oneRingSpawn", true, "There is no other way to get this item.").getBoolean(oneRingSpawn);
		thorHammerSpawn = config.get(misc, "thorHammerSpawn", true, "Thre is no other way to get this item.").getBoolean(thorHammerSpawn);
		chanceTaintedMjolnir = config.get(misc, "chanceTaintedMjolnir", 25, "If you have a lot of mods adding dungeon loot, you should definetely increase this").getInt();
		chanceOneRing = config.get(misc, "chanceOneRing", 15, "If you have a lot of mods adding dungeon loot, you should definetely increase this").getInt();
		allowEnchanting = config.get(misc, "allowEnchanting", false, "Very low enchantability for tools.").getBoolean(allowEnchanting);
		nightVisionOff = config.get(misc, "nightVisionOff", false, "This was added because of mods making you totally blind if using nightvision. For example, enable that when in the Deep Dark.").getBoolean(nightVisionOff);

		// Generator Outputs

		// Modules
		enableIC2Module = config.get(modules, "enableIC2Module", true).getBoolean(enableIC2Module);
		enableTEModule = config.get(modules, "enableTEModule", false).getBoolean(enableTEModule);
		enableToolModule = config.get(modules, "enableToolModule", false).getBoolean(enableToolModule);

		config.save();
	}
}
