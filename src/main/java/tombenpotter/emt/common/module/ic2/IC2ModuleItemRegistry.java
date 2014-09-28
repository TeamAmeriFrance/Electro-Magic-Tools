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

package tombenpotter.emt.common.module.ic2;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import thaumcraft.api.ThaumcraftApi;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.module.base.items.*;
import tombenpotter.emt.common.module.base.items.foci.ItemChristmasFocus;
import tombenpotter.emt.common.module.base.items.foci.ItemExplosionFocus;
import tombenpotter.emt.common.module.base.items.foci.ItemShieldFocus;
import tombenpotter.emt.common.module.ic2.items.ItemElectricScribingTools;
import tombenpotter.emt.common.module.ic2.items.armor.boots.ItemElectricBootsTraveller;
import tombenpotter.emt.common.module.ic2.items.armor.boots.ItemNanoBootsTraveller;
import tombenpotter.emt.common.module.ic2.items.armor.boots.ItemQuantumBootsTraveller;
import tombenpotter.emt.common.module.ic2.items.armor.goggles.ItemElectricGoggles;
import tombenpotter.emt.common.module.ic2.items.armor.goggles.ItemNanoGoggles;
import tombenpotter.emt.common.module.ic2.items.armor.goggles.ItemQuantumGoggles;
import tombenpotter.emt.common.module.ic2.items.armor.goggles.ItemSolarHelmetRevealing;
import tombenpotter.emt.common.module.ic2.items.armor.wings.ItemNanoWing;
import tombenpotter.emt.common.module.ic2.items.armor.wings.ItemQuantumWing;
import tombenpotter.emt.common.module.ic2.items.foci.ItemChargeFocus;
import tombenpotter.emt.common.module.ic2.items.foci.ItemWandChargingFocus;
import tombenpotter.emt.common.module.ic2.items.tools.ItemElectricHoeGrowth;
import tombenpotter.emt.common.module.ic2.items.tools.ItemElectricThorHammer;
import tombenpotter.emt.common.module.ic2.items.tools.chainsaws.ItemDiamondChainsaw;
import tombenpotter.emt.common.module.ic2.items.tools.chainsaws.ItemStreamChainsaw;
import tombenpotter.emt.common.module.ic2.items.tools.chainsaws.ItemThaumiumChainsaw;
import tombenpotter.emt.common.module.ic2.items.tools.drills.ItemRockbreakerDrill;
import tombenpotter.emt.common.module.ic2.items.tools.drills.ItemThaumiumDrill;
import tombenpotter.emt.common.module.ic2.items.tools.omnitools.ItemOmnitoolDiamond;
import tombenpotter.emt.common.module.ic2.items.tools.omnitools.ItemOmnitoolIron;
import tombenpotter.emt.common.module.ic2.items.tools.omnitools.ItemOmnitoolThaumium;

public class IC2ModuleItemRegistry {

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
	public static Item solarHelmetRevealing;
	public static Item thorHammer;
	public static Item taintedThorHammer;
	public static Item electricThorHammer;
	public static Item electricBootsTraveller;
	public static Item quantumBootsTraveller;
	public static Item nanoBootsTraveller;
	public static Item electricScribingTools;
	public static Item itemEMTItems;
	public static Item electricHoeGrowth;
	public static Item chargeFocus;
	public static Item emtBauble;
	public static Item wandChargeFocus;
	public static Item featherWing;
	public static Item thaumiumWing;
	public static Item nanoWing;
	public static Item quantumWing;

	public static ItemArmor.ArmorMaterial featherWingMaterial = EnumHelper.addArmorMaterial("FEATEHRWiNG", 1, new int[]{2, 2, 2, 2}, 6);

	public static void registerItems() {
		itemEMTItems = new ItemEMTItems().setUnlocalizedName(ModInformation.modid + ".emtitems");
		emtBauble = new ItemEMTBaubles().setUnlocalizedName(ModInformation.modid + ".emtbauble");
		electricGoggles = new ItemElectricGoggles(ItemArmor.ArmorMaterial.IRON, 3, 0).setUnlocalizedName(ModInformation.modid + ".electricgoggles");
		nanoThaumicHelmet = new ItemNanoGoggles(ItemArmor.ArmorMaterial.DIAMOND, 3, 0).setUnlocalizedName(ModInformation.modid + ".nanothaumichelmet");
		quantumThaumicHelmet = new ItemQuantumGoggles(ItemArmor.ArmorMaterial.DIAMOND, 3, 0).setUnlocalizedName(ModInformation.modid + ".quantumthaumichelmet");
		solarHelmetRevealing = new ItemSolarHelmetRevealing(ItemArmor.ArmorMaterial.DIAMOND, 3, 0).setUnlocalizedName(ModInformation.modid + ".solarhelmetrevealing");
		electricBootsTraveller = new ItemElectricBootsTraveller(3, 3).setUnlocalizedName(ModInformation.modid + ".electricboots");
		nanoBootsTraveller = new ItemNanoBootsTraveller(3, 3).setUnlocalizedName(ModInformation.modid + ".nanobootstraveller");
		quantumBootsTraveller = new ItemQuantumBootsTraveller(3, 3).setUnlocalizedName(ModInformation.modid + ".quantumbootstraveller");
		electricScribingTools = new ItemElectricScribingTools().setUnlocalizedName(ModInformation.modid + ".electricscribingtools");
		featherWing = new ItemFeatherWing(featherWingMaterial, 7, 1).setUnlocalizedName(ModInformation.modid + ".featherwing");
		thaumiumWing = new ItemThaumiumReinforcedWing(ThaumcraftApi.armorMatThaumium, 7, 1).setUnlocalizedName(ModInformation.modid + ".thaumiumwing");
		nanoWing = new ItemNanoWing(ItemArmor.ArmorMaterial.DIAMOND, 7, 1).setUnlocalizedName(ModInformation.modid + ".nanowing");
		quantumWing = new ItemQuantumWing(ItemArmor.ArmorMaterial.DIAMOND, 7, 1).setUnlocalizedName(ModInformation.modid + ".quantumwing");
		taintedThorHammer = new ItemTaintedThorHammer().setUnlocalizedName(ModInformation.modid + ".taintedthorhammer");
		thorHammer = new ItemThorHammer().setUnlocalizedName(ModInformation.modid + ".hammerthor");
		electricThorHammer = new ItemElectricThorHammer().setUnlocalizedName(ModInformation.modid + ".electricthorhammer");
		thaumiumDrill = new ItemThaumiumDrill().setUnlocalizedName(ModInformation.modid + ".thaumiumdrill");
		thaumiumChainsaw = new ItemThaumiumChainsaw().setUnlocalizedName(ModInformation.modid + ".thaumiumchainsaw");
		diamondChainsaw = new ItemDiamondChainsaw().setUnlocalizedName(ModInformation.modid + ".diamondchainsaw");
		ironOmnitool = new ItemOmnitoolIron().setUnlocalizedName(ModInformation.modid + ".ironomnitool");
		thaumiumOmnitool = new ItemOmnitoolThaumium().setUnlocalizedName(ModInformation.modid + ".thaumiumomnitool");
		diamondOmnitool = new ItemOmnitoolDiamond().setUnlocalizedName(ModInformation.modid + ".diamondomnitool");
		streamChainsaw = new ItemStreamChainsaw().setUnlocalizedName(ModInformation.modid + ".streamchainsaw");
		rockbreakerDrill = new ItemRockbreakerDrill().setUnlocalizedName(ModInformation.modid + ".rockbreakerdrill");
		electricHoeGrowth = new ItemElectricHoeGrowth().setUnlocalizedName(ModInformation.modid + ".electrichoeofgrowth");
		explosionFocus = new ItemExplosionFocus().setUnlocalizedName(ModInformation.modid + ".laserfocus");
		christmasFocus = new ItemChristmasFocus().setUnlocalizedName(ModInformation.modid + ".christmasfocus");
		shieldFocus = new ItemShieldFocus().setUnlocalizedName(ModInformation.modid + ".shieldfocus");
		chargeFocus = new ItemChargeFocus().setUnlocalizedName(ModInformation.modid + ".chargefocus");
		wandChargeFocus = new ItemWandChargingFocus().setUnlocalizedName(ModInformation.modid + ".wandchargefocus");

		GameRegistry.registerItem(itemEMTItems, "EMT Items");
		GameRegistry.registerItem(emtBauble, "EMT Baubles");
		GameRegistry.registerItem(electricGoggles, "Electric Goggles of Revealing");
		GameRegistry.registerItem(nanoThaumicHelmet, "Nanosuit Goggles of Revealing");
		GameRegistry.registerItem(quantumThaumicHelmet, "Quantum Goggles of Revealing");
		GameRegistry.registerItem(solarHelmetRevealing, "Quantum Solar Helmet of Revealing");
		GameRegistry.registerItem(electricBootsTraveller, "Electric Boots of the Traveller");
		GameRegistry.registerItem(nanoBootsTraveller, "Nano Boots of the Traveller");
		GameRegistry.registerItem(quantumBootsTraveller, "Quantum Boots of the Traveller");
		GameRegistry.registerItem(electricScribingTools, "Electric Scribing Tools");
		GameRegistry.registerItem(featherWing, "Feather Wing");
		GameRegistry.registerItem(thaumiumWing, "Thaumium Reinforced Wing");
		GameRegistry.registerItem(nanoWing, "Nanosuit Wing");
		GameRegistry.registerItem(quantumWing, "Quantum Wing");
		GameRegistry.registerItem(taintedThorHammer, "Broken Relic of Mjolnir");
		GameRegistry.registerItem(thorHammer, "Mjolnir");
		GameRegistry.registerItem(electricThorHammer, "Supercharged Mjolnir");
		GameRegistry.registerItem(thaumiumDrill, "Thaumium Drill");
		GameRegistry.registerItem(thaumiumChainsaw, "Thaumium Chainsaw");
		GameRegistry.registerItem(diamondChainsaw, "Diamond Chainsaw");
		GameRegistry.registerItem(ironOmnitool, "Omnitool");
		GameRegistry.registerItem(thaumiumOmnitool, "Thaumium Omnitool");
		GameRegistry.registerItem(diamondOmnitool, "Diamond Omnitool");
		GameRegistry.registerItem(streamChainsaw, "Chainsaw of the Stream");
		GameRegistry.registerItem(rockbreakerDrill, "Drill of the Rockbreaker");
		GameRegistry.registerItem(electricHoeGrowth, "Electric Hoe of Growth");
		GameRegistry.registerItem(explosionFocus, "Wand Focus: Explosion");
		GameRegistry.registerItem(christmasFocus, "Wand Focus: Kris-tmas");
		GameRegistry.registerItem(shieldFocus, "Wand Focus: Shield");
		GameRegistry.registerItem(chargeFocus, "Wand Focus: Charging");
		GameRegistry.registerItem(wandChargeFocus, "Wand Focus: Wand Charging");
	}

	public static ItemStack armorEuMaker = new ItemStack(emtBauble, 1, 0);
	public static ItemStack inventoryEuMaker = new ItemStack(emtBauble, 1, 1);
	public static ItemStack oneRing = new ItemStack(emtBauble, 1, 2);
}
