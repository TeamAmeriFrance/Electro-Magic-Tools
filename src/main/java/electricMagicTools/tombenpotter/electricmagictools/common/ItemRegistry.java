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
import cpw.mods.fml.common.registry.GameRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemEMTBaubles;
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
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemWandChargingFocus;
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

public class ItemRegistry {

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
	public static Item emtBauble;
	public static Item wandChargeFocus;

	public static void registerEMTItems() {
		thaumiumDrill = new ItemThaumiumDrill().setUnlocalizedName("thaumiumdrill");
		thaumiumChainsaw = new ItemThaumiumChainsaw().setUnlocalizedName("thaumiumchainsaw");
		quantumThaumicHelmet = new ItemQuantumThaumicHelmet(3, 0).setUnlocalizedName("quantumthaumichelmet");
		diamondChainsaw = new ItemDiamondChainsaw().setUnlocalizedName("diamondchainsaw");
		ironOmnitool = new ItemOmnitoolIron().setUnlocalizedName("ironomnitool");
		diamondOmnitool = new ItemOmnitoolDiamond().setUnlocalizedName("diamondomnitool");
		thaumiumOmnitool = new ItemOmnitoolThaumium().setUnlocalizedName("thaumiumomnitool");
		nanoThaumicHelmet = new ItemNanoThaumicHelmet(3, 0).setUnlocalizedName("nanothaumichelmet");
		explosionFocus = new ItemExplosionFocus().setUnlocalizedName("laserfocus");
		christmasFocus = new ItemChristmasFocus().setUnlocalizedName("christmasfocus");
		shieldFocus = new ItemShieldFocus().setUnlocalizedName("shieldfocus");
		electricGoggles = new ItemElectricGoggles(3, 0).setUnlocalizedName("electricgoggles");
		streamChainsaw = new ItemStreamChainsaw().setUnlocalizedName("streamchainsaw");
		rockbreakerDrill = new ItemRockbreakerDrill().setUnlocalizedName("rockbreakerdrill");
		thaumiumPlate = new ItemThaumiumPlate().setUnlocalizedName("thaumiumplate");
		solarHelmetRevealing = new ItemSolarHelmetRevealing(3, 0).setUnlocalizedName("solarhelmetrevealing");
		thorHammer = new ItemThorHammer().setUnlocalizedName("hammerthor");
		taintedThorHammer = new ItemTaintedThorHammer().setUnlocalizedName("taintedthorhammer");
		lightningSummoner = new ItemLightningSummoner().setUnlocalizedName("lightningsummoner");
		electricThorHammer = new ItemElectricThorHammer().setUnlocalizedName("electricthorhammer");
		electricBootsTraveller = new ItemElectricBootsTraveller(3, 3).setUnlocalizedName("electricboots");
		nanoBootsTraveller = new ItemNanoBootsTraveller(3, 3).setUnlocalizedName("nanobootstraveller");
		quantumBootsTraveller = new ItemQuantumBootsTraveller(3, 3).setUnlocalizedName("quantumbootstraveller");
		electricScribingTools = new ItemElectricScribingTools().setUnlocalizedName("electricscribingtools");
		itemEMTItems = new ItemEMTItems().setUnlocalizedName("itememtitems");
		electricHoeGrowth = new ItemElectricHoeGrowth().setUnlocalizedName("electrichoeofgrowth");
		chargeFocus = new ItemChargeFocus().setUnlocalizedName("chargefocus");
		emtBauble = new ItemEMTBaubles().setUnlocalizedName("emtbauble");
		wandChargeFocus = new ItemWandChargingFocus().setUnlocalizedName("wandchargefocus");

		GameRegistry.registerItem(thaumiumDrill, "Thaumium Drill");
		GameRegistry.registerItem(thaumiumChainsaw, "Thaumium Chainsaw");
		GameRegistry.registerItem(quantumThaumicHelmet, "Quantum Goggles of Revealing");
		GameRegistry.registerItem(diamondChainsaw, "Diamond Chainsaw");
		GameRegistry.registerItem(ironOmnitool, "Omnitool");
		GameRegistry.registerItem(diamondOmnitool, "Diamond Omnitool");
		GameRegistry.registerItem(thaumiumOmnitool, "Thaumium Omnitool");
		GameRegistry.registerItem(nanoThaumicHelmet, "Nanosuit Goggles of Revealing");
		GameRegistry.registerItem(explosionFocus, "Wand Focus: Explosion");
		GameRegistry.registerItem(christmasFocus, "Wand Focus : Kris-tmas");
		GameRegistry.registerItem(shieldFocus, "Wand Focus : Shield");
		GameRegistry.registerItem(electricGoggles, "Electric Goggles of Revealing");
		GameRegistry.registerItem(streamChainsaw, "Chainsaw of the Stream");
		GameRegistry.registerItem(rockbreakerDrill, "Drill of the Rockbreaker");
		GameRegistry.registerItem(thaumiumPlate, "Thaumium Plate");
		GameRegistry.registerItem(solarHelmetRevealing, "Quantum Solar Helmet of Revealing");
		GameRegistry.registerItem(thorHammer, "Mjolnir");
		GameRegistry.registerItem(taintedThorHammer, "Broken Relic of Mjolnir");
		GameRegistry.registerItem(lightningSummoner, "Lightning Summoner");
		GameRegistry.registerItem(electricThorHammer, "Supercharged Mjolnir");
		GameRegistry.registerItem(electricBootsTraveller, "Electric Boots of the Traveller");
		GameRegistry.registerItem(nanoBootsTraveller, "Nano Boots of the Traveller");
		GameRegistry.registerItem(quantumBootsTraveller, "Quantum Boots of the Traveller");
		GameRegistry.registerItem(electricScribingTools, "Electric Scribing Tools");
		GameRegistry.registerItem(electricHoeGrowth, "Electric Hoe of Growth");
		GameRegistry.registerItem(chargeFocus, "Wand Focus: Charging");
		GameRegistry.registerItem(itemEMTItems, "EMT Items");
		GameRegistry.registerItem(emtBauble, "EMT Baubles");
		GameRegistry.registerItem(wandChargeFocus, "Wand Focus: Wand Charging");
	}
}
