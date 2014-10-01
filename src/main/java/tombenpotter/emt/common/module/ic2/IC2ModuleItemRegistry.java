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
        GameRegistry.registerItem(itemEMTItems, "EMTItems");
        emtBauble = new ItemEMTBaubles().setUnlocalizedName(ModInformation.modid + ".emtbauble");
        GameRegistry.registerItem(emtBauble, "EMTBaubles");

        electricGoggles = new ItemElectricGoggles(ItemArmor.ArmorMaterial.IRON, 3, 0).setUnlocalizedName(ModInformation.modid + ".electricgoggles");
        GameRegistry.registerItem(electricGoggles, "ElectricGogglesRevealing");
        nanoThaumicHelmet = new ItemNanoGoggles(ItemArmor.ArmorMaterial.DIAMOND, 3, 0).setUnlocalizedName(ModInformation.modid + ".nanothaumichelmet");
        GameRegistry.registerItem(nanoThaumicHelmet, "NanosuitGogglesRevealing");
        quantumThaumicHelmet = new ItemQuantumGoggles(ItemArmor.ArmorMaterial.DIAMOND, 3, 0).setUnlocalizedName(ModInformation.modid + ".quantumthaumichelmet");
        GameRegistry.registerItem(quantumThaumicHelmet, "QuantumGogglesRevealing");
        solarHelmetRevealing = new ItemSolarHelmetRevealing(ItemArmor.ArmorMaterial.DIAMOND, 3, 0).setUnlocalizedName(ModInformation.modid + ".solarhelmetrevealing");
        GameRegistry.registerItem(solarHelmetRevealing, "SolarHelmetRevealing");

        electricBootsTraveller = new ItemElectricBootsTraveller(3, 3).setUnlocalizedName(ModInformation.modid + ".electricboots");
        GameRegistry.registerItem(electricBootsTraveller, "ElectricBootsTraveller");
        nanoBootsTraveller = new ItemNanoBootsTraveller(3, 3).setUnlocalizedName(ModInformation.modid + ".nanobootstraveller");
        GameRegistry.registerItem(nanoBootsTraveller, "NanoBootsTraveller");
        quantumBootsTraveller = new ItemQuantumBootsTraveller(3, 3).setUnlocalizedName(ModInformation.modid + ".quantumbootstraveller");
        GameRegistry.registerItem(quantumBootsTraveller, "QuantumBootsTraveller");

        electricScribingTools = new ItemElectricScribingTools().setUnlocalizedName(ModInformation.modid + ".electricscribingtools");
        GameRegistry.registerItem(electricScribingTools, "ElectricScribingTools");

        featherWing = new ItemFeatherWing(featherWingMaterial, 7, 1).setUnlocalizedName(ModInformation.modid + ".featherwing");
        GameRegistry.registerItem(featherWing, "FeatherWing");
        thaumiumWing = new ItemThaumiumReinforcedWing(ThaumcraftApi.armorMatThaumium, 7, 1).setUnlocalizedName(ModInformation.modid + ".thaumiumwing");
        GameRegistry.registerItem(thaumiumWing, "ThaumiumWing");
        nanoWing = new ItemNanoWing(ItemArmor.ArmorMaterial.DIAMOND, 7, 1).setUnlocalizedName(ModInformation.modid + ".nanowing");
        GameRegistry.registerItem(nanoWing, "NanosuitWing");
        quantumWing = new ItemQuantumWing(ItemArmor.ArmorMaterial.DIAMOND, 7, 1).setUnlocalizedName(ModInformation.modid + ".quantumwing");
        GameRegistry.registerItem(quantumWing, "QuantumWing");

        taintedThorHammer = new ItemTaintedThorHammer().setUnlocalizedName(ModInformation.modid + ".taintedthorhammer");
        GameRegistry.registerItem(taintedThorHammer, "TaintedMjolnir");
        thorHammer = new ItemThorHammer().setUnlocalizedName(ModInformation.modid + ".hammerthor");
        GameRegistry.registerItem(thorHammer, "Mjolnir");
        electricThorHammer = new ItemElectricThorHammer().setUnlocalizedName(ModInformation.modid + ".electricthorhammer");
        GameRegistry.registerItem(electricThorHammer, "SuperchargedMjolnir");

        thaumiumDrill = new ItemThaumiumDrill().setUnlocalizedName(ModInformation.modid + ".thaumiumdrill");
        GameRegistry.registerItem(thaumiumDrill, "ThaumiumDrill");
        diamondChainsaw = new ItemDiamondChainsaw().setUnlocalizedName(ModInformation.modid + ".diamondchainsaw");
        GameRegistry.registerItem(diamondChainsaw, "DiamondChainsaw");
        thaumiumChainsaw = new ItemThaumiumChainsaw().setUnlocalizedName(ModInformation.modid + ".thaumiumchainsaw");
        GameRegistry.registerItem(thaumiumChainsaw, "ThaumiumChainsaw");

        ironOmnitool = new ItemOmnitoolIron().setUnlocalizedName(ModInformation.modid + ".ironomnitool");
        GameRegistry.registerItem(ironOmnitool, "Omnitool");
        diamondOmnitool = new ItemOmnitoolDiamond().setUnlocalizedName(ModInformation.modid + ".diamondomnitool");
        GameRegistry.registerItem(diamondOmnitool, "Diamond Omnitool");
        thaumiumOmnitool = new ItemOmnitoolThaumium().setUnlocalizedName(ModInformation.modid + ".thaumiumomnitool");
        GameRegistry.registerItem(thaumiumOmnitool, "ThaumiumOmnitool");

        streamChainsaw = new ItemStreamChainsaw().setUnlocalizedName(ModInformation.modid + ".streamchainsaw");
        GameRegistry.registerItem(streamChainsaw, "ChainsawStream");
        rockbreakerDrill = new ItemRockbreakerDrill().setUnlocalizedName(ModInformation.modid + ".rockbreakerdrill");
        GameRegistry.registerItem(rockbreakerDrill, "DrillRockbreaker");
        electricHoeGrowth = new ItemElectricHoeGrowth().setUnlocalizedName(ModInformation.modid + ".electrichoeofgrowth");
        GameRegistry.registerItem(electricHoeGrowth, "ElectricHoeGrowth");

        explosionFocus = new ItemExplosionFocus().setUnlocalizedName(ModInformation.modid + ".laserfocus");
        GameRegistry.registerItem(explosionFocus, "ExplosionFocus");
        christmasFocus = new ItemChristmasFocus().setUnlocalizedName(ModInformation.modid + ".christmasfocus");
        GameRegistry.registerItem(christmasFocus, "ChristmasFocus");
        shieldFocus = new ItemShieldFocus().setUnlocalizedName(ModInformation.modid + ".shieldfocus");
        GameRegistry.registerItem(shieldFocus, "ShieldFocus");
        chargeFocus = new ItemChargeFocus().setUnlocalizedName(ModInformation.modid + ".chargefocus");
        GameRegistry.registerItem(chargeFocus, "ChargingFocus");
        wandChargeFocus = new ItemWandChargingFocus().setUnlocalizedName(ModInformation.modid + ".wandchargefocus");
        GameRegistry.registerItem(wandChargeFocus, "WandChargingFocus");
    }
}
