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
package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config
{

	public static int thaumiumDrillID;
	public static int thaumiumChainsawID;
	public static int quantumThaumicHelmetID;
	public static int diamondChainsawID;
	public static int ironOmnitoolID;
	public static int diamondOmnitoolID;
	public static int thaumiumOmnitoolID;
	public static int nanoThaumicHelmetID;
	public static int explosionFocusID;
	public static int christmasFocusID;
	public static int shieldFocusID;
	public static int shieldID;
	public static int electricGogglesID;
	public static int streamChainsawID;
	public static int rockbreakerDrillID;
	public static int thaumiumPlateID;
	public static int solarHelmetRevealingID;
	public static int thorHammerID;
	public static int taintedThorHammerID;
	public static int lightningSummonerID;
	public static int electricThorHammerID;
	public static int electricBootsTravellerID;
	public static int quantumBootsTravellerID;
	public static int nanoBootsTravellerID;
	public static int electricScribingToolsID;
	public static int essentiaGeneratorsDelay;
	public static int etherealProcessorBaseSpeed;
	public static int etherealProcessorBonus;
	public static int itemEMTItemID;
	public static int electricHoeGrowthID;
	public static int chargeFocusProduction;
	public static int chargeFocusID;

	public static int emtSolarsID;
	public static int essentiaGensID;
	public static int emtMachinesID;
	public static int emtSolars2ID;
	public static int portableNodeID;

	public static double potentiaGenOutput;
	public static double arborGenOutput;
	public static double auramGenOutput;
	public static double ignisGenOutput;
	public static double saxumGenOutput;
	public static double wandChargerConsumption;
	public static double compressedSolarOutput;
	public static double doubleCompressedSolarOutput;
	public static double nanoBootsSpeed;
	public static double quantumBootsSpeed;
	public static double nanoBootsJump;
	public static double quantumBootsJump;
	public static double tripleCompressedSolarOutput;

	public static boolean capesOn;
	public static boolean toolsInBore;
	public static boolean nightVisionOff;
	public static boolean enchanting;
	public static boolean smoke;

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

	public static String CATEGORY_RESEARCH = "Research";
	public static String CATEGORY_VALUES = "Numeric Values";

	public static void create(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.addCustomCategoryComment(CATEGORY_VALUES, "The only way to change some numbers that my machines uses.");
		config.addCustomCategoryComment(CATEGORY_RESEARCH, "The only way to disable some researches. " + "Be careful, if you disable some researches, " + "all researches linked to it will be removed too. " + "Really, don't touch that unless you know exactly what you are doing.");

		config.load();

		// Random Booleans
		capesOn = config.get(Configuration.CATEGORY_GENERAL, "Enable showing capes", true, "This config option is to enable or disable capes for people who have them. " + "Seriously, you shouldn't touch that unless you have another cape and " + "it conflicts with it.").getBoolean(capesOn);

		toolsInBore = config.get(Configuration.CATEGORY_GENERAL, "Making the tools worth begin used in the Arcane Bore.", false, "This will augment the durablilty of the tools, and will also decrease the EU cost to 1. " + "The tools should have the same number of uses than before.").getBoolean(toolsInBore);

		nightVisionOff = config.get(Configuration.CATEGORY_GENERAL, "Disable totally the nightvision ability of the Nanosuit Googles of Revealing, " + "Quantum Googles of Revealing and of the Quantum Solar Helmet of Revealing", false).getBoolean(nightVisionOff);

		enchanting = config.get(Configuration.CATEGORY_GENERAL, "Disable the enchanting of my items. " + "Even if on, it will not make them be able to use the repair enchant! " + "This is disabled by default", true).getBoolean(enchanting);
		smoke = config.get(Configuration.CATEGORY_GENERAL, "Disable the smoke effect for the Electric/Nano/Quantum Boots of the Traveller", false).getBoolean(smoke);

		// Item IDs
		thaumiumDrillID = config.getItem("Thaumium Drill", 4000).getInt();
		thaumiumChainsawID = config.getItem("Thaumium Chainsaw", 4001).getInt();
		quantumThaumicHelmetID = config.getItem("Quantum Goggles of Revealing", 4002).getInt();
		diamondChainsawID = config.getItem("Diamond Chainsaw", 4003).getInt();
		ironOmnitoolID = config.getItem("Iron Omnitool", 4004).getInt();
		diamondOmnitoolID = config.getItem("Diamond Omnitool", 4005).getInt();
		thaumiumOmnitoolID = config.getItem("Thaumium Omnitool", 4006).getInt();
		nanoThaumicHelmetID = config.getItem("Nanosuit Goggles of Revealing", 4007).getInt();
		explosionFocusID = config.getItem("Explosion Focus", 4008).getInt();
		christmasFocusID = config.getItem("Kris-tmas Focus", 4009).getInt();
		shieldFocusID = config.getItem("Shield Focus", 4010).getInt();
		electricGogglesID = config.getItem("Electric Goggles of Revealing", 4011).getInt();
		streamChainsawID = config.getItem("Chainsaw of the Stream", 4012).getInt();
		rockbreakerDrillID = config.getItem("Drill of the Rockbreaker", 4013).getInt();
		thaumiumPlateID = config.getItem("Thauium Plate", 4014).getInt();
		solarHelmetRevealingID = config.getItem("Solar Helmet of Revealing", 4015).getInt();
		thorHammerID = config.getItem("Mjolnir", 4016).getInt();
		taintedThorHammerID = config.getItem("Broken Relic of Mjolnir", 4017).getInt();
		lightningSummonerID = config.getItem("Lightning Summoner", 4018).getInt();
		electricThorHammerID = config.getItem("Supercharged Mjolnir", 4020).getInt();
		electricBootsTravellerID = config.getItem("Electric Boots of the Traveller", 4021).getInt();
		nanoBootsTravellerID = config.getItem("Nano Boots of the Traveller", 4022).getInt();
		quantumBootsTravellerID = config.getItem("Quantum Boots of the Traveller", 4023).getInt();
		electricScribingToolsID = config.getItem("Electric Scribing Tools", 4024).getInt();
		itemEMTItemID = config.getItem("EMT Items", 4025).getInt();
		electricHoeGrowthID = config.getItem("Electric Hoe of Growth", 4026).getInt();
		chargeFocusID = config.getItem("Wand Focus: Charge", 4027).getInt();

		// Block IDs

		essentiaGensID = config.getBlock("Essentia Generators", 1500).getInt();
		shieldID = config.getBlock("Shield", 1501).getInt();
		emtMachinesID = config.getBlock("EMT Machines", 1502).getInt();
		emtSolarsID = config.getBlock("EMT Solars", 1503).getInt();
		emtSolars2ID = config.getBlock("EMT Solars 2", 1504).getInt();
		portableNodeID = config.getBlock("Portable Node", 1505).getInt();

		// EU Yield/Consumption modifier
		potentiaGenOutput = config.get("Numeric Values", "Potentia Generator EU Output", 3500, "This is the number you have to modify if you want to make the Potentia Generator yield " + "more or less EU per unit of essentia.").getDouble(potentiaGenOutput);

		arborGenOutput = config.get("Numeric Values", "Arbor Generator EU Output", 325, "This is the number you have to modify if you want to make the Arbor Generator yield " + "more or less EU per unit of essentia.").getDouble(arborGenOutput);

		auramGenOutput = config.get("Numeric Values", "Auram Generator EU Output", 3200, "This is the number you have to modify if you want to make the Auram Generator yield " + "more or less EU per unit of essentia.").getDouble(auramGenOutput);

		ignisGenOutput = config.get("Numeric Values", "Ignis Generator EU Output", 3200, "This is the number you have to modify if you want to make the Ignis Generator yield " + "more or less EU per unit of essentia.").getDouble(ignisGenOutput);

		saxumGenOutput = config.get("Numeric Values", "Saxum Generator Output", 350, "This is the number you have to modify if you want to make the Saxum Generator yield " + "more or less EU per unit of essentia.").getDouble(saxumGenOutput);

		wandChargerConsumption = config.get("Numeric Values", "Industrial Wand Charging Station EU Consumption", 50000, "This is the number you have to modify if you want to make the Industrial Wand Charging " + "Station use more or less EU to charge 1 unit of Vis on your wand.").getDouble(wandChargerConsumption);

		compressedSolarOutput = config.get("Numeric Values", "Compressed Solar Panel EU Output", 10, "This is the number you have to modify if you want to make the Compressed Solar Panel yield " + "more or less EU per tick. Really, you shouldn't touch that, " + "since it's pretty balanced as it is.").getDouble(compressedSolarOutput);

		doubleCompressedSolarOutput = config.get("Numeric Values", "Double Compressed Solar Panel EU Output", 100, "This is the number you have to modify if you want to make the Double Compressed Solar Panel " + "yield more or less EU per tick. Really, you shouldn't touch that, " + "since it's pretty balanced as it is.").getDouble(doubleCompressedSolarOutput);

		tripleCompressedSolarOutput = config.get("Numeric Values", "Triple Compressed Solar Panel EU Output", 1000, "This is the number you have to modify if you want to make the Triple Compressed Solar Panel " + "yield more or less EU per tick. Really, you shouldn't touch that, " + "since it's pretty balanced as it is.").getDouble(tripleCompressedSolarOutput);

		essentiaGeneratorsDelay = config.get("Numeric Values", "Essentia Generators draw rate", 120, "The number of ticks the Essentia Generators wait before using 2 Essentia. " + "If you want them to be slower, increase the number.").getInt(essentiaGeneratorsDelay);

		nanoBootsSpeed = config.get("Numeric Values", "Speed of the Nano Boots of the Traveller", 0.25, "Watch out, that goes up REALLY quickly.").getDouble(nanoBootsSpeed);

		quantumBootsSpeed = config.get("Numeric Values", "Speed of the Quantum Boots of the Traveller", 0.5, "Watch out, that goes up REALLY quickly.").getDouble(quantumBootsSpeed);

		nanoBootsJump = config.get("Numeric Values", "Jump height for the Nano Boots of the Traveller", 0.6, "Watch out, that goes up REALLY quickly.").getDouble(nanoBootsJump);

		quantumBootsJump = config.get("Numeric Values", "Jump height for the Quantum Boots of the Traveller", 0.9, "Watch out, that goes up REALLY quickly.").getDouble(nanoBootsJump);

		etherealProcessorBaseSpeed = config.get("Numeric Values", "Base Time the Etheral Processor takes to process a single item in number of ticks.", 400).getInt();

		etherealProcessorBonus = config.get("Numeric Values", "Ethereal Processor Bonus", 10, "This number is the chance of getting a Thaumium Ingot as a bonus when " + "processing an item in the machine. It is 1 out of the number you will enter. " + "The default is 1/10 chance.").getInt();

		chargeFocusProduction = config.get("Numeric Values", "Wand Focus: Charge production in EU/T", 64).getInt();

		// Disable Researches
		thaumiumDrillResearch = config.get("Research", "Thaumium Drill", false).getBoolean(thaumiumDrillResearch);

		thaumiumChainsawResearch = config.get("Research", "Thaumium Chainsaw", false).getBoolean(thaumiumChainsawResearch);

		thaumiumDrillResearch = config.get("Research", "Thaumium Omnitool", false).getBoolean(thaumiumOmnitoolResearch);

		rockbreakerDrillResearch = config.get("Research", "Drill of the Rockbreaker", false).getBoolean(rockbreakerDrillResearch);

		streamChainsawResearch = config.get("Research", "Chainsaw of the Stream", false).getBoolean(streamChainsawResearch);

		electricGooglesResearch = config.get("Research", "Electric Googles of Revealing", false).getBoolean(electricGooglesResearch);

		nanoGooglesResearch = config.get("Research", "Nanosuit Googles of Revealing", false).getBoolean(nanoGooglesResearch);

		quantumGooglesResearch = config.get("Research", "Quantum Googles of Revealing", false).getBoolean(quantumGooglesResearch);

		ironOmnitoolResearch = config.get("Research", "Omnitool", false).getBoolean(ironOmnitoolResearch);

		diamondOmnitoolResearch = config.get("Research", "Diamond Omnitool", false).getBoolean(diamondOmnitoolResearch);

		explosionFocusResearch = config.get("Research", "Explosion Focus", false).getBoolean(explosionFocusResearch);

		christmasFocusResearch = config.get("Research", "Kris-tmas Focus", false).getBoolean(christmasFocusResearch);

		shieldFocusResearch = config.get("Research", "Shield Focus", false).getBoolean(shieldFocusResearch);

		shieldBlockResearch = config.get("Research", "Shield Block", false).getBoolean(shieldBlockResearch);

		potentiaGeneratorResearch = config.get("Research", "Potentia Generator", false).getBoolean(potentiaGeneratorResearch);

		ignisGeneratorResearch = config.get("Research", "Ignis Generator", false).getBoolean(ignisGeneratorResearch);

		auramGeneratorResearch = config.get("Research", "Auram Generator", false).getBoolean(auramGeneratorResearch);

		arborGeneratorResearch = config.get("Research", "Arbor Generator", false).getBoolean(arborGeneratorResearch);

		wandChargingSationResearch = config.get("Research", "Industrial Wand Charging Station", false).getBoolean(wandChargingSationResearch);

		tinyUraniumResearch = config.get("Research", "Tiny Piles of Uranium", false).getBoolean(tinyUraniumResearch);

		thorHammerResearch = config.get("Research", "Mjolnir", false).getBoolean(thorHammerResearch);

		superchargedThorHammerResearch = config.get("Research", "Supercharged Mjolnir", false).getBoolean(superchargedThorHammerResearch);

		compressedSolarsResearch = config.get("Research", "Compressed Solars", false).getBoolean(compressedSolarsResearch);

		solarHelmetResearch = config.get("Research", "Solar Helmet of Revealing", false).getBoolean(solarHelmetResearch);

		electricBootsResearch = config.get("Research", "Electric Boots of the Traveller", false).getBoolean(electricBootsResearch);

		nanoBootsResearch = config.get("Research", "Nano Boots of the Traveller", false).getBoolean(nanoBootsResearch);

		quantumBootsResearch = config.get("Research", "Quantum Boots of the Traveller", false).getBoolean(quantumBootsResearch);

		electricScribingToolsResearch = config.get("Research", "Electric Scribing Tools", false).getBoolean(electricScribingToolsResearch);

		etherealProcessorResearch = config.get("Research", "Ethereal Processor", false).getBoolean(etherealProcessorResearch);

		waterSolarsResearch = config.get("Research", "Water Solar Panels", false).getBoolean(waterSolarsResearch);

		darkSolarsResearch = config.get("Research", "Entropy Solar Panels", false).getBoolean(darkSolarsResearch);

		orderSolarsResearch = config.get("Research", "Order Solar Panels", false).getBoolean(orderSolarsResearch);

		fireSolarsResearch = config.get("Research", "Fire Solar Panels", false).getBoolean(fireSolarsResearch);

		airSolarsResearch = config.get("Research", "Air Solar Panels", false).getBoolean(airSolarsResearch);

		earthSolarsResearch = config.get("Research", "Earth Solar Panels", false).getBoolean(earthSolarsResearch);

		saxumGenResearch = config.get("Research", "Saxum Generator", false).getBoolean(saxumGenResearch);

		uuMInfusionResearch = config.get("Research", "UU-Mater Infusion", false).getBoolean(uuMInfusionResearch);

		portableNodeResarch = config.get("Research", "Portable Node", false).getBoolean(portableNodeResarch);

		electricHoeGrowthResearch = config.get("Research", "Electric Hoe of Growth", false).getBoolean(electricHoeGrowthResearch);

		chargeFocusResearch = config.get("Research", "Wand Focus: Charging", false).getBoolean(chargeFocusResearch);

		config.save();
	}
}
