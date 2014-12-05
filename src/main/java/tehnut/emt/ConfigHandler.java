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
	public static boolean electricGooglesResearch;
	public static boolean nanoGooglesResearch;
	public static boolean quantumGooglesResearch;
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
		config.addCustomCategoryComment(research, "The only way to disable some researches. Be careful, if you disable some researches, all researches linked to it will be removed too. Really, don't touch that unless you know exactly what you are doing.");
		config.addCustomCategoryComment(values, "Change outputs linked to different Essentias here");
		config.addCustomCategoryComment(misc, "Options that don't fit into the other categories.");
		config.addCustomCategoryComment(modules, "Select the modules to play with.");

		// Research
		thaumiumDrillResearch = config.get(research, "Thaumium Drill", false).getBoolean(thaumiumDrillResearch);
		thaumiumChainsawResearch = config.get(research, "Thaumium Chainsaw", false).getBoolean(thaumiumChainsawResearch);
		thaumiumDrillResearch = config.get(research, "Thaumium Omnitool", false).getBoolean(thaumiumOmnitoolResearch);
		rockbreakerDrillResearch = config.get(research, "Drill of the Rockbreaker", false).getBoolean(rockbreakerDrillResearch);
		streamChainsawResearch = config.get(research, "Chainsaw of the Stream", false).getBoolean(streamChainsawResearch);
		electricGooglesResearch = config.get(research, "Electric Googles of Revealing", false).getBoolean(electricGooglesResearch);
		nanoGooglesResearch = config.get(research, "Nanosuit Googles of Revealing", false).getBoolean(nanoGooglesResearch);
		quantumGooglesResearch = config.get(research, "Quantum Googles of Revealing", false).getBoolean(quantumGooglesResearch);
		ironOmnitoolResearch = config.get(research, "Omnitool", false).getBoolean(ironOmnitoolResearch);
		diamondOmnitoolResearch = config.get(research, "Diamond Omnitool", false).getBoolean(diamondOmnitoolResearch);
		explosionFocusResearch = config.get(research, "Explosion Focus", false).getBoolean(explosionFocusResearch);
		christmasFocusResearch = config.get(research, "Kris-tmas Focus", false).getBoolean(christmasFocusResearch);
		shieldFocusResearch = config.get(research, "Shield Focus", false).getBoolean(shieldFocusResearch);
		shieldBlockResearch = config.get(research, "Shield Block", false).getBoolean(shieldBlockResearch);
		potentiaGeneratorResearch = config.get(research, "Potentia Generator", false).getBoolean(potentiaGeneratorResearch);
		ignisGeneratorResearch = config.get(research, "Ignis Generator", false).getBoolean(ignisGeneratorResearch);
		auramGeneratorResearch = config.get(research, "Auram Generator", false).getBoolean(auramGeneratorResearch);
		arborGeneratorResearch = config.get(research, "Arbor Generator", false).getBoolean(arborGeneratorResearch);
		wandChargingSationResearch = config.get(research, "Industrial Wand Charging Station", false).getBoolean(wandChargingSationResearch);
		tinyUraniumResearch = config.get(research, "Tiny Piles of Uranium", false).getBoolean(tinyUraniumResearch);
		thorHammerResearch = config.get(research, "Mjolnir", false).getBoolean(thorHammerResearch);
		superchargedThorHammerResearch = config.get(research, "Supercharged Mjolnir", false).getBoolean(superchargedThorHammerResearch);
		compressedSolarsResearch = config.get(research, "Compressed Solars", false).getBoolean(compressedSolarsResearch);
		solarHelmetResearch = config.get(research, "Solar Helmet of Revealing", false).getBoolean(solarHelmetResearch);
		electricBootsResearch = config.get(research, "Electric Boots of the Traveller", false).getBoolean(electricBootsResearch);
		nanoBootsResearch = config.get(research, "Nano Boots of the Traveller", false).getBoolean(nanoBootsResearch);
		quantumBootsResearch = config.get(research, "Quantum Boots of the Traveller", false).getBoolean(quantumBootsResearch);
		electricScribingToolsResearch = config.get(research, "Electric Scribing Tools", false).getBoolean(electricScribingToolsResearch);
		etherealProcessorResearch = config.get(research, "Ethereal Processor", false).getBoolean(etherealProcessorResearch);
		waterSolarsResearch = config.get(research, "Water Solar Panels", false).getBoolean(waterSolarsResearch);
		darkSolarsResearch = config.get(research, "Entropy Solar Panels", false).getBoolean(darkSolarsResearch);
		orderSolarsResearch = config.get(research, "Order Solar Panels", false).getBoolean(orderSolarsResearch);
		fireSolarsResearch = config.get(research, "Fire Solar Panels", false).getBoolean(fireSolarsResearch);
		airSolarsResearch = config.get(research, "Air Solar Panels", false).getBoolean(airSolarsResearch);
		earthSolarsResearch = config.get(research, "Earth Solar Panels", false).getBoolean(earthSolarsResearch);
		saxumGenResearch = config.get(research, "Saxum Generator", false).getBoolean(saxumGenResearch);
		uuMInfusionResearch = config.get(research, "UU-Mater Infusion", false).getBoolean(uuMInfusionResearch);
		portableNodeResarch = config.get(research, "Portable Node", false).getBoolean(portableNodeResarch);
		electricHoeGrowthResearch = config.get(research, "Electric Hoe of Growth", false).getBoolean(electricHoeGrowthResearch);
		chargeFocusResearch = config.get(research, "Wand Focus: Charging", false).getBoolean(chargeFocusResearch);
		wandChargeFocusResearch = config.get(research, "Wand Focus: Wand Charging", false).getBoolean(wandChargeFocusResearch);
		inventoryChargingRing = config.get(research, "Inventory Charging Ring", false).getBoolean(inventoryChargingRing);
		armorChargingRing = config.get(research, "Armor Charging Ring", false).getBoolean(armorChargingRing);
		thaumiumWingResearch = config.get(research, "Thaumium Reinforced Wings", false).getBoolean(thaumiumWingResearch);
		nanoWingResearch = config.get(research, "Nanosuit Wings", false).getBoolean(nanoWingResearch);
		quantumWingsResearch = config.get(research, "Quantum Wings", false).getBoolean(quantumWingsResearch);
		aerGeneratorResearch = config.get(research, "Aer Generator", false).getBoolean(aerGeneratorResearch);

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
		oneRingSpawn = config.get(misc, "oneRingSpawn", false, "There is no other way to get this item.").getBoolean(oneRingSpawn);
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
