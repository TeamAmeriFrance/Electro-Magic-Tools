package tombenpotter.emt.common.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    // sections
    public static String CATEGORY_RANDOM = "Random Configs";
    public static String CATEGORY_RESEARCH = "Research";
    public static String CATEGORY_VALUES = "Numeric Values";
    public static String CATEGORY_OUTPUTS = "Essentia Generator Outputs";
	public static String CATEGORY_MODULES = "Modules";

    public static int essentiaGeneratorsDelay;
    public static int etherealProcessorBaseSpeed;
    public static int etherealProcessorBonus;
    public static int chargeFocusProduction;
    public static int armorBaubleProduction;
    public static int inventoryBaubleProdution;
    public static int wandChargeFocusCost;

    // values
    public static double wandChargerConsumption;
    public static double compressedSolarOutput;
    public static double doubleCompressedSolarOutput;
    public static double nanoBootsSpeed;
    public static double quantumBootsSpeed;
    public static double nanoBootsJump;
    public static double quantumBootsJump;
    public static double tripleCompressedSolarOutput;

    // essentias
    public static double fireOutput;
    public static double waterOutput;
    public static double airOutput;
    public static double earthOutput;
    public static double orderOutput;
    public static double entropyOutput;
    public static double outputCap;

    // random stuff
    public static boolean capesOn;
    public static boolean toolsInBore;
    public static boolean nightVisionOff;
    public static boolean enchanting;
    public static boolean smoke;
    public static boolean oneRingSpawn;
    public static boolean removeAmberAndCinnabarMacerating;

    // loot chance
    public static int chanceOneRing;
    public static int chanceTaintedMjolnir;

    // research
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

	public static boolean enableIC2Module;
	public static boolean enableTEModule;

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {

        config.addCustomCategoryComment(CATEGORY_VALUES, "The only way to change some numbers that my machines uses.");
        config.addCustomCategoryComment(CATEGORY_RESEARCH, "The only way to disable some researches. " + "Be careful, if you disable some researches, " + "all researches linked to it will be removed too. " + "Really, don't touch that unless you know exactly what you are doing.");
        config.addCustomCategoryComment(CATEGORY_OUTPUTS, "Change outputs linked to different Essentias here");

        capesOn = config.get(CATEGORY_RANDOM, "Enable capes", true, "This config option is to enable or disable capes for people who have them. " + "Seriously, you shouldn't touch that unless you have another cape and " + "it conflicts with it.").getBoolean(capesOn);
        toolsInBore = config.get(CATEGORY_RANDOM, "Tools for Arcane Bore", false, "This will augment the durablilty of the tools, and will also decrease the EU cost to 1. " + "The tools should have the same number of uses than before.").getBoolean(toolsInBore);
        nightVisionOff = config.get(CATEGORY_RANDOM, "Disable nightvision helmets", false, "This was added because of mods making you totally blind if using nightvision. For example, enable that when in the Deep Dark.").getBoolean(nightVisionOff);
        enchanting = config.get(CATEGORY_RANDOM, "Enable enchanting tools", false, "Warning: the enchantability is low.").getBoolean(enchanting);
        smoke = config.get(CATEGORY_RANDOM, "Disable smoke effect for boots", false, "This effect only appears when the player isn't on the ground").getBoolean(smoke);
        oneRingSpawn = config.get(CATEGORY_RANDOM, "Disable One Ring in dungeon chests", false, "There is no other way to get this item.").getBoolean(oneRingSpawn);
        chanceTaintedMjolnir = config.get(CATEGORY_RANDOM, "Tainted Mjolnir spawning change", 25, "If you have a lot of mods adding dungeon loot, you should definetely increase this").getInt();
        chanceOneRing = config.get(CATEGORY_RANDOM, "One Ring spawning chance", 15, "If you have a lot of mods adding dungeon loot, you should definetely increase this").getInt();
        removeAmberAndCinnabarMacerating = config.get(CATEGORY_RANDOM, "Clear Amber/Cinnabar Macerating", true, "This is here because of conflicts between mods that add the same input and different outputs").getBoolean(removeAmberAndCinnabarMacerating);

        // DEFAULTS - Aer -  15,000  Aqua - 5,000  Ignis - 20,000  Ordo -  16,000  Perditio - 10,000  Terra - 2,000
        airOutput = config.get(CATEGORY_OUTPUTS, "Aer Output", 15000).getDouble(airOutput);
        waterOutput = config.get(CATEGORY_OUTPUTS, "Aqua Output", 5000).getDouble(waterOutput);
        fireOutput = config.get(CATEGORY_OUTPUTS, "Ignis Output", 20000).getDouble(fireOutput);
        orderOutput = config.get(CATEGORY_OUTPUTS, "Ordo Output", 16000).getDouble(orderOutput);
        entropyOutput = config.get(CATEGORY_OUTPUTS, "Perditio Output", 10000).getDouble(entropyOutput);
        earthOutput = config.get(CATEGORY_OUTPUTS, "Terra Output", 2000).getDouble(earthOutput);
        outputCap = config.get(CATEGORY_OUTPUTS, "Output Cap", -1).getDouble(outputCap);

        wandChargerConsumption = config.get(CATEGORY_VALUES, "Wand Charging Station Consumption", 50000, "This is the number you have to modify if you want to make the Industrial Wand Charging " + "Station use more or less EU to charge 1 unit of Vis on your wand.").getDouble(wandChargerConsumption);
        compressedSolarOutput = config.get(CATEGORY_VALUES, "Compressed Solar Panel Output", 10, "This is the number you have to modify if you want to make the Compressed Solar Panel yield " + "more or less EU per tick. Really, you shouldn't touch that, " + "since it's pretty balanced as it is.").getDouble(compressedSolarOutput);
        doubleCompressedSolarOutput = config.get(CATEGORY_VALUES, "Double Compressed Solar Panel Output", 100, "This is the number you have to modify if you want to make the Double Compressed Solar Panel " + "yield more or less EU per tick. Really, you shouldn't touch that, " + "since it's pretty balanced as it is.").getDouble(doubleCompressedSolarOutput);
        tripleCompressedSolarOutput = config.get(CATEGORY_VALUES, "Triple Compressed Solar Panel Output", 1000, "This is the number you have to modify if you want to make the Triple Compressed Solar Panel " + "yield more or less EU per tick. Really, you shouldn't touch that, " + "since it's pretty balanced as it is.").getDouble(tripleCompressedSolarOutput);
        essentiaGeneratorsDelay = config.get(CATEGORY_VALUES, "Essentia Generators draw rate", 120, "The number of ticks the Essentia Generators wait before using 2 Essentia. " + "If you want them to be slower, increase the number.").getInt(essentiaGeneratorsDelay);
        nanoBootsSpeed = config.get(CATEGORY_VALUES, "Nano Boots of the Traveller Speed", 0.25, "Watch out, that goes up REALLY quickly.").getDouble(nanoBootsSpeed);
        quantumBootsSpeed = config.get(CATEGORY_VALUES, "Quantum Boots of the Traveller Speed", 0.5, "Watch out, that goes up REALLY quickly.").getDouble(quantumBootsSpeed);
        nanoBootsJump = config.get(CATEGORY_VALUES, "Nano Boots of the Traveller jump", 0.6, "Watch out, that goes up REALLY quickly.").getDouble(nanoBootsJump);
        quantumBootsJump = config.get(CATEGORY_VALUES, "Quantum Boots of the Traveller jump", 0.9, "Watch out, that goes up REALLY quickly.").getDouble(nanoBootsJump);
        etherealProcessorBaseSpeed = config.get(CATEGORY_VALUES, "Etheral Processor speed", 400, "Default is 400, the double of a regular furnace").getInt();
        etherealProcessorBonus = config.get(CATEGORY_VALUES, "Ethereal Processor Bonus", 10, "This number is the chance of getting a Thaumium Ingot as a bonus when " + "processing an item in the machine. It is 1 out of the number you will enter. " + "The default is 1/10 chance.").getInt();
        chargeFocusProduction = config.get(CATEGORY_VALUES, "Wand Focus: Charge production", 64, "Default is 64").getInt();
        armorBaubleProduction = config.get(CATEGORY_VALUES, "Armor Charging Ring production", 32, "Default is 32").getInt();
        inventoryBaubleProdution = config.get(CATEGORY_VALUES, "Inventory Charging Ring production", 32, "Default is 32").getInt();
        wandChargeFocusCost = config.get(CATEGORY_VALUES, "Wand Focus: Wand Charging Cost", 40000, "Default is 40000").getInt();

        thaumiumDrillResearch = config.get(CATEGORY_RESEARCH, "Thaumium Drill", false).getBoolean(thaumiumDrillResearch);
        thaumiumChainsawResearch = config.get(CATEGORY_RESEARCH, "Thaumium Chainsaw", false).getBoolean(thaumiumChainsawResearch);
        thaumiumDrillResearch = config.get(CATEGORY_RESEARCH, "Thaumium Omnitool", false).getBoolean(thaumiumOmnitoolResearch);
        rockbreakerDrillResearch = config.get(CATEGORY_RESEARCH, "Drill of the Rockbreaker", false).getBoolean(rockbreakerDrillResearch);
        streamChainsawResearch = config.get(CATEGORY_RESEARCH, "Chainsaw of the Stream", false).getBoolean(streamChainsawResearch);
        electricGooglesResearch = config.get(CATEGORY_RESEARCH, "Electric Googles of Revealing", false).getBoolean(electricGooglesResearch);
        nanoGooglesResearch = config.get(CATEGORY_RESEARCH, "Nanosuit Googles of Revealing", false).getBoolean(nanoGooglesResearch);
        quantumGooglesResearch = config.get(CATEGORY_RESEARCH, "Quantum Googles of Revealing", false).getBoolean(quantumGooglesResearch);
        ironOmnitoolResearch = config.get(CATEGORY_RESEARCH, "Omnitool", false).getBoolean(ironOmnitoolResearch);
        diamondOmnitoolResearch = config.get(CATEGORY_RESEARCH, "Diamond Omnitool", false).getBoolean(diamondOmnitoolResearch);
        explosionFocusResearch = config.get(CATEGORY_RESEARCH, "Explosion Focus", false).getBoolean(explosionFocusResearch);
        christmasFocusResearch = config.get(CATEGORY_RESEARCH, "Kris-tmas Focus", false).getBoolean(christmasFocusResearch);
        shieldFocusResearch = config.get(CATEGORY_RESEARCH, "Shield Focus", false).getBoolean(shieldFocusResearch);
        shieldBlockResearch = config.get(CATEGORY_RESEARCH, "Shield Block", false).getBoolean(shieldBlockResearch);
        potentiaGeneratorResearch = config.get(CATEGORY_RESEARCH, "Potentia Generator", false).getBoolean(potentiaGeneratorResearch);
        ignisGeneratorResearch = config.get(CATEGORY_RESEARCH, "Ignis Generator", false).getBoolean(ignisGeneratorResearch);
        auramGeneratorResearch = config.get(CATEGORY_RESEARCH, "Auram Generator", false).getBoolean(auramGeneratorResearch);
        arborGeneratorResearch = config.get(CATEGORY_RESEARCH, "Arbor Generator", false).getBoolean(arborGeneratorResearch);
        wandChargingSationResearch = config.get(CATEGORY_RESEARCH, "Industrial Wand Charging Station", false).getBoolean(wandChargingSationResearch);
        tinyUraniumResearch = config.get(CATEGORY_RESEARCH, "Tiny Piles of Uranium", false).getBoolean(tinyUraniumResearch);
        thorHammerResearch = config.get(CATEGORY_RESEARCH, "Mjolnir", false).getBoolean(thorHammerResearch);
        superchargedThorHammerResearch = config.get(CATEGORY_RESEARCH, "Supercharged Mjolnir", false).getBoolean(superchargedThorHammerResearch);
        compressedSolarsResearch = config.get(CATEGORY_RESEARCH, "Compressed Solars", false).getBoolean(compressedSolarsResearch);
        solarHelmetResearch = config.get(CATEGORY_RESEARCH, "Solar Helmet of Revealing", false).getBoolean(solarHelmetResearch);
        electricBootsResearch = config.get(CATEGORY_RESEARCH, "Electric Boots of the Traveller", false).getBoolean(electricBootsResearch);
        nanoBootsResearch = config.get(CATEGORY_RESEARCH, "Nano Boots of the Traveller", false).getBoolean(nanoBootsResearch);
        quantumBootsResearch = config.get(CATEGORY_RESEARCH, "Quantum Boots of the Traveller", false).getBoolean(quantumBootsResearch);
        electricScribingToolsResearch = config.get(CATEGORY_RESEARCH, "Electric Scribing Tools", false).getBoolean(electricScribingToolsResearch);
        etherealProcessorResearch = config.get(CATEGORY_RESEARCH, "Ethereal Processor", false).getBoolean(etherealProcessorResearch);
        waterSolarsResearch = config.get(CATEGORY_RESEARCH, "Water Solar Panels", false).getBoolean(waterSolarsResearch);
        darkSolarsResearch = config.get(CATEGORY_RESEARCH, "Entropy Solar Panels", false).getBoolean(darkSolarsResearch);
        orderSolarsResearch = config.get(CATEGORY_RESEARCH, "Order Solar Panels", false).getBoolean(orderSolarsResearch);
        fireSolarsResearch = config.get(CATEGORY_RESEARCH, "Fire Solar Panels", false).getBoolean(fireSolarsResearch);
        airSolarsResearch = config.get(CATEGORY_RESEARCH, "Air Solar Panels", false).getBoolean(airSolarsResearch);
        earthSolarsResearch = config.get(CATEGORY_RESEARCH, "Earth Solar Panels", false).getBoolean(earthSolarsResearch);
        saxumGenResearch = config.get(CATEGORY_RESEARCH, "Saxum Generator", false).getBoolean(saxumGenResearch);
        uuMInfusionResearch = config.get(CATEGORY_RESEARCH, "UU-Mater Infusion", false).getBoolean(uuMInfusionResearch);
        portableNodeResarch = config.get(CATEGORY_RESEARCH, "Portable Node", false).getBoolean(portableNodeResarch);
        electricHoeGrowthResearch = config.get(CATEGORY_RESEARCH, "Electric Hoe of Growth", false).getBoolean(electricHoeGrowthResearch);
        chargeFocusResearch = config.get(CATEGORY_RESEARCH, "Wand Focus: Charging", false).getBoolean(chargeFocusResearch);
        wandChargeFocusResearch = config.get(CATEGORY_RESEARCH, "Wand Focus: Wand Charging", false).getBoolean(wandChargeFocusResearch);
        inventoryChargingRing = config.get(CATEGORY_RESEARCH, "Inventory Charging Ring", false).getBoolean(inventoryChargingRing);
        armorChargingRing = config.get(CATEGORY_RESEARCH, "Armor Charging Ring", false).getBoolean(armorChargingRing);
        thaumiumWingResearch = config.get(CATEGORY_RESEARCH, "Thaumium Reinforced Wings", false).getBoolean(thaumiumWingResearch);
        nanoWingResearch = config.get(CATEGORY_RESEARCH, "Nanosuit Wings", false).getBoolean(nanoWingResearch);
        quantumWingsResearch = config.get(CATEGORY_RESEARCH, "Quantum Wings", false).getBoolean(quantumWingsResearch);
        aerGeneratorResearch = config.get(CATEGORY_RESEARCH, "Aer Generator", false).getBoolean(aerGeneratorResearch);

	    enableIC2Module = config.get(CATEGORY_MODULES, "IC2 Module", true).getBoolean(enableIC2Module);
	    enableTEModule = config.get(CATEGORY_MODULES, "TE Module", true).getBoolean(enableTEModule);

        if (config.hasChanged()) {
            config.save();
        }
    }
}
