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

import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import electricMagicTools.tombenpotter.electricmagictools.common.lib.ResearchAspects;
import electricMagicTools.tombenpotter.electricmagictools.common.recipes.EMTInitRecipes;
import electricMagicTools.tombenpotter.electricmagictools.common.recipes.EMTPostInitRecipes;
import electricMagicTools.tombenpotter.electricmagictools.common.recipes.UuMInfusionRecipes;

public class ThaumonomiconResearch {

	public static void addResearchTab() {
		ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
		ResearchCategories.registerCategory("EMT", new ResourceLocation("electricmagictools:textures/misc/emt.png"), background);
	}

	public static void addResearch() {
		ResearchItem research;
		String text;
		// String text2;

		/** Research that can't be disabled **/
		text = "1";
		research = new EMTResearchItem("Electric Magic Tools", "EMT", new AspectList(), 0, 0, 0, new ResourceLocation("electricmagictools:textures/misc/emt.png")).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text));

		text = "1";
		research = new EMTResearchItem("Diamond Chainsaw", "EMT", new AspectList(), 5, -6, 0, new ItemStack(ItemRegistry.diamondChainsaw)).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(EMTInitRecipes.diamondChainsaw));

		text = "1";
		research = new EMTResearchItem("Thaumium Plate", "EMT", new AspectList(), 6, -6, 0, new ItemStack(ItemRegistry.thaumiumPlate)).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thaumiumPlate));

		text = "1";
		research = new EMTResearchItem("Macerating Native Ore Clusters", "EMT", new AspectList(), 5, -7, 0, IC2Items.getItem("smallGoldDust")).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text));

		text = "1";
		research = new EMTResearchItem("The Legend", "EMT", new AspectList(), 5, -5, 0, new ItemStack(ItemRegistry.taintedThorHammer)).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text));

		text = "1";
		research = new EMTResearchItem("Lightning Summoner", "EMT", new AspectList(), 6, -5, 0, new ItemStack(ItemRegistry.lightningSummoner)).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text));

		text = "1";
		research = new EMTResearchItem("The One Ring", "EMT", new AspectList(), 6, -7, 0, new ItemStack(ItemRegistry.emtBauble, 1, 2)).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text));

		/** Research that can be disabled **/
		if (Config.thaumiumDrillResearch == false) {
			text = "1";
			research = new EMTResearchItem("Thaumium Drill", "EMT", ResearchAspects.thaumiumDrillResearch, -1, -2, 1, new ItemStack(ItemRegistry.thaumiumDrill)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thaumiumDrill));
		}

		if (Config.thaumiumChainsawResearch == false) {
			text = "1";
			research = new EMTResearchItem("Thaumium Chainsaw", "EMT", ResearchAspects.thaumiumChainsawResearch, -2, -2, 1, new ItemStack(ItemRegistry.thaumiumChainsaw)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thaumiumChainsaw));
		}

		if (Config.electricGooglesResearch == false) {
			text = "1";
			research = new EMTResearchItem("Electric Goggles", "EMT", ResearchAspects.electricGogglesResearch, 1, -2, 1, new ItemStack(ItemRegistry.electricGoggles)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.electricGoggles));
		}

		if (Config.electricGooglesResearch == false) {
			if (Config.nanoGooglesResearch == false) {
				text = "1";
				research = new EMTResearchItem("Nanosuit Goggles of Revealing", "EMT", ResearchAspects.thaumicNanoHelmet, 2, -2, 2, new ItemStack(ItemRegistry.nanoThaumicHelmet)).setParents("Electric Goggles").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thaumicNanoHelmet));
			}
		}

		if (Config.electricGooglesResearch == false) {
			if (Config.nanoGooglesResearch == false) {
				if (Config.quantumGooglesResearch == false) {
					text = "1";
					research = new EMTResearchItem("Quantum Goggles of Revealing", "EMT", ResearchAspects.thaumicQuantumHelmet, 3, -2, 3, new ItemStack(ItemRegistry.quantumThaumicHelmet)).setParents("Nanosuit Goggles of Revealing").setConcealed().registerResearchItem();
					research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thaumicQuantumHelmet));
				}
			}
		}

		if (Config.ironOmnitoolResearch == false) {
			text = "1";
			research = new EMTResearchItem("Iron Omnitool", "EMT", new AspectList(), -2, 0, 0, new ItemStack(ItemRegistry.ironOmnitool)).setParents("Electric Magic Tools").setRound().setAutoUnlock().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTInitRecipes.ironOmnitool));
		}

		if (Config.ironOmnitoolResearch == false) {
			if (Config.diamondOmnitoolResearch == false) {
				text = "1";
				research = new EMTResearchItem("Diamond Omnitool", "EMT", ResearchAspects.diamondOmnitoolResearch, -4, 0, 1, new ItemStack(ItemRegistry.diamondOmnitool)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.diamondOmnitool), new ResearchPage(EMTPostInitRecipes.ironOmnitoolToDiamond));
			}
		}

		if (Config.thaumiumDrillResearch == false && Config.thaumiumChainsawResearch == false) {
			if (Config.thaumiumOmnitoolResearch == false) {
				text = "1";
				research = new EMTResearchItem("Thaumium Omnitool", "EMT", ResearchAspects.thaumiumOmnitoolResearch, -6, 0, 2, new ItemStack(ItemRegistry.thaumiumOmnitool)).setParentsHidden("Thaumium Drill", "Thaumium Chainsaw").setParents("Diamond Omnitool").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thaumiumOmnitool), new ResearchPage(EMTPostInitRecipes.diamondOmnitoolToThaumium));
			}
		}

		if (Config.explosionFocusResearch == false) {
			text = "1";
			research = new EMTResearchItem("Explosion Focus", "EMT", ResearchAspects.laserFocusResearch, 2, 3, 2, new ItemStack(ItemRegistry.explosionFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.explosionFocus));
		}

		if (Config.christmasFocusResearch == false) {
			text = "1";
			research = new EMTResearchItem("Kris-tmas Focus", "EMT", ResearchAspects.christmasFocusResearch, 3, 3, 1, new ItemStack(ItemRegistry.christmasFocus)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.christmasFocus));
		}

		if (Config.shieldFocusResearch == false) {
			text = "1";
			research = new EMTResearchItem("Shield Focus", "EMT", ResearchAspects.shieldFocusResearch, 4, 3, 2, new ItemStack(ItemRegistry.shieldFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.shieldFocus));
		}

		if (Config.shieldFocusResearch == false) {
			if (Config.shieldBlockResearch == false) {
				text = "1";
				research = new EMTResearchItem("Shield Block", "EMT", ResearchAspects.shieldBlockResearch, 4, 5, 1, new ItemStack(BlockRegistry.shield)).setSecondary().setParents("Shield Focus").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.shieldBlock));
			}
		}

		if (Config.potentiaGeneratorResearch == false) {
			text = "1";
			research = new EMTResearchItem("Potentia Generator", "EMT", ResearchAspects.potentiaGeneratorResearch, -2, 3, 3, new ItemStack(BlockRegistry.essentiaGens, 1, 0)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.potentiaGenerator));
		}

		if (Config.potentiaGeneratorResearch == false) {
			if (Config.ignisGeneratorResearch == false) {
				text = "1";
				research = new EMTResearchItem("Ignis Generator", "EMT", ResearchAspects.ignisGeneratorResearch, -3, 4, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 1)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.ignisGenerator));
			}
		}

		if (Config.potentiaGeneratorResearch == false) {
			if (Config.auramGeneratorResearch == false) {
				text = "1";
				research = new EMTResearchItem("Auram Generator", "EMT", ResearchAspects.auramGeneratorResearch, -1, 4, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 2)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.auramGenerator));
			}
		}

		if (Config.potentiaGeneratorResearch == false) {
			if (Config.arborGeneratorResearch == false) {
				text = "1";
				research = new EMTResearchItem("Arbor Generator", "EMT", ResearchAspects.arborGeneratorResearch, -2, 5, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 3)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.arborGenerator));
			}
		}

		// if(Config.potentiaGeneratorResearch == false) {
		// if(Config.wandChargingSationResearch = false) {
		text = "1";
		research = new EMTResearchItem("Industrial Wand Charging Station", "EMT", ResearchAspects.wandCharger, -4, 2, 3, new ItemStack(BlockRegistry.emtMachines, 1, 0)).setParents("Potentia Generator").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.wandRecharger));
		// }
		// }

		if (Config.thaumiumChainsawResearch == false) {
			if (Config.streamChainsawResearch == false) {
				text = "1";
				research = new EMTResearchItem("Chainsaw of the Stream", "EMT", ResearchAspects.streamChainsawResearch, -3, -4, 3, new ItemStack(ItemRegistry.streamChainsaw)).setParents("Thaumium Chainsaw").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.streamChainsaw));
			}
		}

		if (Config.thaumiumDrillResearch == false) {
			if (Config.rockbreakerDrillResearch == false) {
				text = "1";
				research = new EMTResearchItem("Drill of the Rockbreaker", "EMT", ResearchAspects.rockbreakerDrillResearch, 0, -4, 3, new ItemStack(ItemRegistry.rockbreakerDrill)).setParents("Thaumium Drill").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.rockbreakerDrill));
			}
		}

		if (Config.tinyUraniumResearch == false) {
			text = "1";
			research = new EMTResearchItem("Tiny Uranium", "EMT", ResearchAspects.tinyUraniumResearch, -5, -5, 1, IC2Items.getItem("Uran238")).setSecondary().setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.tinyUranium));
		}

		if (Config.thorHammerResearch == false) {
			text = "1";
			research = new EMTResearchItem("Mjolnir", "EMT", ResearchAspects.thorHammerResearch, -5, 5, 3, new ItemStack(ItemRegistry.thorHammer)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.thorHammer));
		}

		if (Config.thorHammerResearch == false) {
			if (Config.superchargedThorHammerResearch == false) {
				text = "1";
				research = new EMTResearchItem("Supercharged Mjolnir", "EMT", ResearchAspects.superchargedThorHammerResearch, -6, 6, 3, new ItemStack(ItemRegistry.electricThorHammer)).setParents("Mjolnir").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.superchargedThorHammer));
			}
		}

		if (Config.compressedSolarsResearch == false) {
			text = "1";
			research = new EMTResearchItem("Compressed Solars", "EMT", ResearchAspects.compressedSolars, -4, -5, 2, new ItemStack(BlockRegistry.emtSolars)).setParentsHidden("Potentia Generator").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.compressedSolar), new ResearchPage(EMTPostInitRecipes.doubleCompressedSolar), new ResearchPage(EMTPostInitRecipes.tripleCompressedSolar));
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.solarHelmetResearch == false) {
				text = "1";
				research = new EMTResearchItem("Solar Helmet of Revealing", "EMT", ResearchAspects.solarHelmetRevealing, -2, -5, 1, new ItemStack(ItemRegistry.solarHelmetRevealing)).setSecondary().setParents("Compressed Solars").setParentsHidden("Quantum Goggles of Revealing").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.solarHelmetRevealing));
			}
		}

		if (Config.electricBootsResearch == false) {
			text = "1";
			research = new EMTResearchItem("Electric Boots of the Traveller", "EMT", ResearchAspects.electricBootsTravel, 2, 0, 1, new ItemStack(ItemRegistry.electricBootsTraveller)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.electricBootsTravel));
		}

		if (Config.electricBootsResearch == false) {
			if (Config.nanoBootsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Nano Boots of the Traveller", "EMT", ResearchAspects.nanoBootsTravel, 4, 0, 2, new ItemStack(ItemRegistry.nanoBootsTraveller)).setParents("Electric Boots of the Traveller").setConcealed().registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.nanoBootsTravel));
			}
		}

		if (Config.electricBootsResearch == false) {
			if (Config.nanoBootsResearch == false) {
				if (Config.quantumBootsResearch == false) {
					text = "1";
					research = new EMTResearchItem("Quantum Boots of the Traveller", "EMT", ResearchAspects.quantumBootsTravel, 6, 0, 3, new ItemStack(ItemRegistry.quantumBootsTraveller)).setParents("Nano Boots of the Traveller").setConcealed().registerResearchItem();
					research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.quantumBootsTravel));
				}
			}
		}

		if (Config.electricScribingToolsResearch == false) {
			text = "1";
			research = new EMTResearchItem("Electric Scribing Tools", "EMT", ResearchAspects.electricScribingTools, -6, -5, 1, new ItemStack(ItemRegistry.electricScribingTools)).setSecondary().setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.electricScribingTools));
		}

		if (Config.etherealProcessorResearch == false) {
			text = "1";
			research = new EMTResearchItem("Etheral Processor", "EMT", ResearchAspects.etherealProcessor, -1, 2, 2, new ItemStack(BlockRegistry.emtMachines, 1, 1)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.etheralProcessor));
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.waterSolarsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Water Infused Solar Panels", "EMT", ResearchAspects.waterSolars, -7, -7, 1, new ItemStack(BlockRegistry.emtSolars, 1, 3)).setSecondary().setParents("Compressed Solars").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.waterSolar), new ResearchPage(EMTPostInitRecipes.doubleWaterSolar), new ResearchPage(EMTPostInitRecipes.tripleWaterSolar));

			}
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.darkSolarsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Entropy Infused Solar Panels", "EMT", ResearchAspects.darkSolars, -8, -6, 1, new ItemStack(BlockRegistry.emtSolars, 1, 6)).setSecondary().setParents("Compressed Solars").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.darkSolar), new ResearchPage(EMTPostInitRecipes.doubleDarkSolar), new ResearchPage(EMTPostInitRecipes.tripleDarkSolar));
			}
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.orderSolarsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Order Infused Solar Panels", "EMT", ResearchAspects.orderSolars, -6, -8, 1, new ItemStack(BlockRegistry.emtSolars, 1, 9)).setSecondary().setParents("Compressed Solars").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.orderSolar), new ResearchPage(EMTPostInitRecipes.doubleOrderSolar), new ResearchPage(EMTPostInitRecipes.tripleOrderSolar));
			}
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.fireSolarsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Fire Infused Solar Panels", "EMT", ResearchAspects.fireSolars, -5, -7, 1, new ItemStack(BlockRegistry.emtSolars, 1, 12)).setSecondary().setParents("Compressed Solars").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.fireSolar), new ResearchPage(EMTPostInitRecipes.doubleFireSolar), new ResearchPage(EMTPostInitRecipes.tripleFireSolar));
			}
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.airSolarsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Air Infused Solar Panels", "EMT", ResearchAspects.airSolars, -4, -6, 1, new ItemStack(BlockRegistry.emtSolars, 1, 15)).setSecondary().setParents("Compressed Solars").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.airSolar), new ResearchPage(EMTPostInitRecipes.doubleAirSolar), new ResearchPage(EMTPostInitRecipes.tripleAirSolar));
			}
		}

		if (Config.compressedSolarsResearch == false) {
			if (Config.earthSolarsResearch == false) {
				text = "1";
				research = new EMTResearchItem("Earth Infused Solar Panels", "EMT", ResearchAspects.earthSolars, -6, -7, 1, new ItemStack(BlockRegistry.emtSolars2, 1, 2)).setSecondary().setParents("Compressed Solars").registerResearchItem();
				research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.earthSolar), new ResearchPage(EMTPostInitRecipes.doubleEarthSolar), new ResearchPage(EMTPostInitRecipes.tripleEarthSolar));
			}
		}

		if (Config.uuMInfusionResearch == false) {
			text = "1";
			research = new EMTResearchItem("UU-Matter Infusion", "EMT", ResearchAspects.uuMInfusion, 5, 5, 3, IC2Items.getItem("UuMatterCell")).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(UuMInfusionRecipes.charcoalToCoal), new ResearchPage(UuMInfusionRecipes.glowstoneDustToBlock), new ResearchPage(UuMInfusionRecipes.stoneBricksToIronOre), new ResearchPage(UuMInfusionRecipes.arcaneStoneToCopperOre), new ResearchPage(UuMInfusionRecipes.arcaneStoneBricksToTinOre), new ResearchPage(UuMInfusionRecipes.amberBlockToLeadOre), new ResearchPage(UuMInfusionRecipes.amberBricksToUraniumOre), new ResearchPage(UuMInfusionRecipes.shardToResin), new ResearchPage(UuMInfusionRecipes.shardToRedstone), new ResearchPage(UuMInfusionRecipes.shardToLapis), new ResearchPage(UuMInfusionRecipes.ironToGold), new ResearchPage(UuMInfusionRecipes.goldToDiamond), new ResearchPage(UuMInfusionRecipes.diamondToUranium), new ResearchPage(
					UuMInfusionRecipes.uraniumToIridium));
		}

		if (Config.portableNodeResarch == false) {
			text = "1";
			research = new EMTResearchItem("Portable Node", "EMT", ResearchAspects.portableNode, 2, 5, 3, new ItemStack(BlockRegistry.portableNode)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.portableNode));
		}

		if (Config.electricHoeGrowthResearch == false) {
			text = "1";
			research = new EMTResearchItem("Electric Hoe of Growth", "EMT", ResearchAspects.electricHoeGrowth, -1, -4, 2, new ItemStack(ItemRegistry.electricHoeGrowth)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.electricHoeGrowth));
		}

		if (Config.chargeFocusResearch == false) {
			text = "1";
			research = new EMTResearchItem("Wand Focus: Charging", "EMT", ResearchAspects.chargeFocus, 5, 3, 2, new ItemStack(ItemRegistry.chargeFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.chargeFocus));
		}

		if (Config.wandChargeFocusResearch == false) {
			text = "1";
			research = new EMTResearchItem("Wand Focus: Wand Charging", "EMT", ResearchAspects.wandChargeFocus, 7, 3, 3, new ItemStack(ItemRegistry.wandChargeFocus)).setParents("Wand Focus: Charging").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.wandChargeFocus));
		}

		if (Config.inventoryChargingRing == false) {
			text = "1";
			research = new EMTResearchItem("Inventory Charging Ring", "EMT", ResearchAspects.inventoryChargingRing, 0, -5, 3, new ItemStack(ItemRegistry.emtBauble, 1, 1)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.inventoryChargingRing));
		}

		if (Config.armorChargingRing == false) {
			text = "1";
			research = new EMTResearchItem("Armor Charging Ring", "EMT", ResearchAspects.armorChargingRing, 0, -7, 3, new ItemStack(ItemRegistry.emtBauble, 1, 0)).setSecondary().setParents("Inventory Charging Ring").setConcealed().registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(EMTPostInitRecipes.armorChargingRing));
		}
	}
}
