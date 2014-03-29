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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemEMTItems;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemElectricScribingTools;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemLightningSummoner;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemThaumiumPlate;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemElectricBootsTraveller;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemElectricGoggles;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemNanoBootsTraveller;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemNanoThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemQuantumBootsTraveller;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemQuantumThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemSolarHelmetRevealing;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemChargeFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemChristmasFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemExplosionFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemShieldFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemDiamondChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemElectricHoeGrowth;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolDiamond;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolIron;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolThaumium;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemRockbreakerDrill;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemStreamChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemThaumiumChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemThaumiumDrill;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer.ItemElectricThorHammer;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer.ItemTaintedThorHammer;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer.ItemThorHammer;

public class ItemRegistry
{

	public static Item thaumiumDrill;
	public static Item thaumiumChainsaw;
	public static Item quantumThaumicHelmet;
	public static Item diamondChainsaw;
	public static Item ironOmnitool;
	public static Item diamondOmnitool;
	public static Item thaumiumOmnitool;
	public static Item nanoThaumicHelmet;
	public static Item explosionFocus;
	public static Item christmasFocus;
	public static Item shieldFocus;
	public static Item electricGoggles;
	public static Item streamChainsaw;
	public static Item rockbreakerDrill;
	public static Item thaumiumPlate;
	public static Item solarHelmetRevealing;
	public static Item thorHammer;
	public static Item taintedThorHammer;
	public static Item electricThorHammer;
	public static Item lightningSummoner;
	public static Item electricBootsTraveller;
	public static Item quantumBootsTraveller;
	public static Item nanoBootsTraveller;
	public static Item electricScribingTools;
	public static Item itemEMTItems;
	public static Item electricHoeGrowth;
	public static Item chargeFocus;

	public static void registerEMTItems() {
		thaumiumDrill = new ItemThaumiumDrill(Config.thaumiumDrillID).setUnlocalizedName("thaumiumdrill");
		thaumiumChainsaw = new ItemThaumiumChainsaw(Config.thaumiumChainsawID).setUnlocalizedName("thaumiumchainsaw");
		quantumThaumicHelmet = new ItemQuantumThaumicHelmet(Config.quantumThaumicHelmetID, 3, 0).setUnlocalizedName("quantumthaumichelmet");
		diamondChainsaw = new ItemDiamondChainsaw(Config.diamondChainsawID).setUnlocalizedName("diamondchainsaw");
		ironOmnitool = new ItemOmnitoolIron(Config.ironOmnitoolID).setUnlocalizedName("ironomnitool");
		diamondOmnitool = new ItemOmnitoolDiamond(Config.diamondOmnitoolID).setUnlocalizedName("diamondomnitool");
		thaumiumOmnitool = new ItemOmnitoolThaumium(Config.thaumiumOmnitoolID).setUnlocalizedName("thaumiumomnitool");
		nanoThaumicHelmet = new ItemNanoThaumicHelmet(Config.nanoThaumicHelmetID, 3, 0).setUnlocalizedName("nanothaumichelmet");
		explosionFocus = new ItemExplosionFocus(Config.explosionFocusID).setUnlocalizedName("laserfocus");
		christmasFocus = new ItemChristmasFocus(Config.christmasFocusID).setUnlocalizedName("christmasfocus");
		shieldFocus = new ItemShieldFocus(Config.shieldFocusID).setUnlocalizedName("shieldfocus");
		electricGoggles = new ItemElectricGoggles(Config.electricGogglesID, 3, 0).setUnlocalizedName("electricgoggles");
		streamChainsaw = new ItemStreamChainsaw(Config.streamChainsawID).setUnlocalizedName("streamchainsaw");
		rockbreakerDrill = new ItemRockbreakerDrill(Config.rockbreakerDrillID).setUnlocalizedName("rockbreakerdrill");
		thaumiumPlate = new ItemThaumiumPlate(Config.thaumiumPlateID).setUnlocalizedName("thaumiumplate");
		solarHelmetRevealing = new ItemSolarHelmetRevealing(Config.solarHelmetRevealingID, 3, 0).setUnlocalizedName("solarhelmetrevealing");
		thorHammer = new ItemThorHammer(Config.thorHammerID).setUnlocalizedName("hammerthor");
		taintedThorHammer = new ItemTaintedThorHammer(Config.taintedThorHammerID).setUnlocalizedName("taintedthorhammer");
		lightningSummoner = new ItemLightningSummoner(Config.lightningSummonerID).setUnlocalizedName("lightningsummoner");
		electricThorHammer = new ItemElectricThorHammer(Config.electricThorHammerID).setUnlocalizedName("electricthorhammer");
		electricBootsTraveller = new ItemElectricBootsTraveller(Config.electricBootsTravellerID, 3, 3).setUnlocalizedName("electricboots");
		nanoBootsTraveller = new ItemNanoBootsTraveller(Config.nanoBootsTravellerID, 3, 3).setUnlocalizedName("nanobootstraveller");
		quantumBootsTraveller = new ItemQuantumBootsTraveller(Config.quantumBootsTravellerID, 3, 3).setUnlocalizedName("quantumbootstraveller");
		electricScribingTools = new ItemElectricScribingTools(Config.electricScribingToolsID).setUnlocalizedName("electricscribingtools");
		itemEMTItems = new ItemEMTItems(Config.itemEMTItemID).setUnlocalizedName("itememtitems");
		electricHoeGrowth = new ItemElectricHoeGrowth(Config.electricHoeGrowthID).setUnlocalizedName("electrichoeofgrowth");
		chargeFocus = new ItemChargeFocus(Config.chargeFocusID).setUnlocalizedName("chargefocus");

		LanguageRegistry.addName(thaumiumDrill, "Thaumium Drill");
		LanguageRegistry.addName(thaumiumChainsaw, "Thaumium Chainsaw");
		LanguageRegistry.addName(quantumThaumicHelmet, "Quantum Goggles of Revealing");
		LanguageRegistry.addName(diamondChainsaw, "Diamond Chainsaw");
		LanguageRegistry.addName(ironOmnitool, "Omnitool");
		LanguageRegistry.addName(diamondOmnitool, "Diamond Omnitool");
		LanguageRegistry.addName(thaumiumOmnitool, "Thaumium Omnitool");
		LanguageRegistry.addName(nanoThaumicHelmet, "Nanosuit Goggles of Revealing");
		LanguageRegistry.addName(explosionFocus, "Wand Focus: Explosion");
		LanguageRegistry.addName(christmasFocus, "Wand Focus : Kris-tmas");
		LanguageRegistry.addName(shieldFocus, "Wand Focus : Shield");
		LanguageRegistry.addName(electricGoggles, "Electric Goggles of Revealing");
		LanguageRegistry.addName(streamChainsaw, "Chainsaw of the Stream");
		LanguageRegistry.addName(rockbreakerDrill, "Drill of the Rockbreaker");
		LanguageRegistry.addName(thaumiumPlate, "Thaumium Plate");
		LanguageRegistry.addName(solarHelmetRevealing, "Quantum Solar Helmet of Revealing");
		LanguageRegistry.addName(thorHammer, "Mjolnir");
		LanguageRegistry.addName(taintedThorHammer, "Broken Relic of Mjolnir");
		LanguageRegistry.addName(lightningSummoner, "Lightning Summoner");
		LanguageRegistry.addName(electricThorHammer, "Supercharged Mjolnir");
		LanguageRegistry.addName(electricBootsTraveller, "Electric Boots of the Traveller");
		LanguageRegistry.addName(nanoBootsTraveller, "Nano Boots of the Traveller");
		LanguageRegistry.addName(quantumBootsTraveller, "Quantum Boots of the Traveller");
		LanguageRegistry.addName(electricScribingTools, "Electric Scribing Tools");
		LanguageRegistry.addName(electricHoeGrowth, "Electric Hoe of Growth");
		LanguageRegistry.addName(chargeFocus, "Wand Focus: Charging");
		LanguageRegistry.addName(new ItemStack(itemEMTItems, 1, 0), "Native Uranium Cluster");
		LanguageRegistry.addName(new ItemStack(itemEMTItems, 1, 1), "Crushed Amber Ore");
		LanguageRegistry.addName(new ItemStack(itemEMTItems, 1, 2), "Purified Crushed Amber Ore");
		LanguageRegistry.addName(new ItemStack(itemEMTItems, 1, 3), "Crushed Cinnabar Ore");
		LanguageRegistry.addName(new ItemStack(itemEMTItems, 1, 4), "Purified Crushed Cinnabar Ore");
	}
}
