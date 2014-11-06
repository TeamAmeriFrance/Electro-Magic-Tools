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

package tombenpotter.emt.common.modules.ic2;

import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import tombenpotter.emt.common.modules.base.blocks.BaseBlockRegistry;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.items.IC2ItemRegistry;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.EMTResearchItem;
import tombenpotter.emt.common.util.ResearchAspects;

public class IC2Research {

    public static void addResearchTab() {
        ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
        ResearchCategories.registerCategory("EMT", new ResourceLocation("electromagictools:textures/misc/emt.png"), background);
    }

    public static void addResearch() {
        ResearchItem research;
        String text;
        // String text2;

        /** Research that can't be disabled **/
        text = "1";
        research = new EMTResearchItem("Electric Magic Tools", "EMT", new AspectList(), 0, 0, 0, new ResourceLocation("electromagictools:textures/misc/emt.png")).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("Diamond Chainsaw", "EMT", new AspectList(), 5, -6, 0, new ItemStack(IC2ItemRegistry.diamondChainsaw)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.diamondChainsaw));

        text = "1";
        research = new EMTResearchItem("Thaumium Plate", "EMT", new AspectList(), 6, -6, 0, new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumiumPlate));

        text = "1";
        research = new EMTResearchItem("Macerating Native Ore Clusters", "EMT", new AspectList(), 5, -7, 0, IC2Items.getItem("smallGoldDust")).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("The Legend", "EMT", new AspectList(), 5, -5, 0, new ItemStack(IC2ItemRegistry.taintedThorHammer)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("Lightning Summoner", "EMT", new AspectList(), 6, -5, 0, new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 6)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("The One Ring", "EMT", new AspectList(), 6, -7, 0, new ItemStack(IC2ItemRegistry.emtBauble, 1, 2)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("Feather Wings", "EMT", new AspectList(), 0, 2, 0, new ItemStack(IC2ItemRegistry.featherWing)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.rubberBall), new ResearchPage(IC2RecipeRegistry.ductTape), new ResearchPage(IC2RecipeRegistry.featherMesh), new ResearchPage(IC2RecipeRegistry.cardboard), new ResearchPage(IC2RecipeRegistry.featherWing), new ResearchPage(IC2RecipeRegistry.featherWings));

        /** Research that can be disabled **/
        if (ConfigHandler.thaumiumDrillResearch == false) {
            text = "1";
            research = new EMTResearchItem("Thaumium Drill", "EMT", ResearchAspects.thaumiumDrillResearch, -1, -2, 1, new ItemStack(IC2ItemRegistry.thaumiumDrill)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumiumDrill));
        }

        if (ConfigHandler.thaumiumChainsawResearch == false) {
            text = "1";
            research = new EMTResearchItem("Thaumium Chainsaw", "EMT", ResearchAspects.thaumiumChainsawResearch, -2, -2, 1, new ItemStack(IC2ItemRegistry.thaumiumChainsaw)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumiumChainsaw));
        }

        if (ConfigHandler.electricGooglesResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Goggles", "EMT", ResearchAspects.electricGogglesResearch, 1, -2, 1, new ItemStack(IC2ItemRegistry.electricGoggles)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.electricGoggles));
        }

        if (ConfigHandler.electricGooglesResearch == false) {
            if (ConfigHandler.nanoGooglesResearch == false) {
                text = "1";
                research = new EMTResearchItem("Nanosuit Goggles of Revealing", "EMT", ResearchAspects.thaumicNanoHelmet, 2, -2, 2, new ItemStack(IC2ItemRegistry.nanoThaumicHelmet)).setParents("Electric Goggles").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumicNanoHelmet));
            }
        }

        if (ConfigHandler.electricGooglesResearch == false) {
            if (ConfigHandler.nanoGooglesResearch == false) {
                if (ConfigHandler.quantumGooglesResearch == false) {
                    text = "1";
                    research = new EMTResearchItem("Quantum Goggles of Revealing", "EMT", ResearchAspects.thaumicQuantumHelmet, 3, -2, 3, new ItemStack(IC2ItemRegistry.quantumThaumicHelmet)).setParents("Nanosuit Goggles of Revealing").setConcealed().registerResearchItem();
                    research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumicQuantumHelmet));
                }
            }
        }

        if (ConfigHandler.ironOmnitoolResearch == false) {
            text = "1";
            research = new EMTResearchItem("Iron Omnitool", "EMT", new AspectList(), -2, 0, 0, new ItemStack(IC2ItemRegistry.ironOmnitool)).setParents("Electric Magic Tools").setRound().setAutoUnlock().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.ironOmnitool));
        }

        if (ConfigHandler.ironOmnitoolResearch == false) {
            if (ConfigHandler.diamondOmnitoolResearch == false) {
                text = "1";
                research = new EMTResearchItem("Diamond Omnitool", "EMT", ResearchAspects.diamondOmnitoolResearch, -4, 0, 1, new ItemStack(IC2ItemRegistry.diamondOmnitool)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.diamondOmnitool), new ResearchPage(IC2RecipeRegistry.ironOmnitoolToDiamond));
            }
        }

        if (ConfigHandler.thaumiumDrillResearch == false && ConfigHandler.thaumiumChainsawResearch == false) {
            if (ConfigHandler.thaumiumOmnitoolResearch == false) {
                text = "1";
                research = new EMTResearchItem("Thaumium Omnitool", "EMT", ResearchAspects.thaumiumOmnitoolResearch, -6, 0, 2, new ItemStack(IC2ItemRegistry.thaumiumOmnitool)).setParentsHidden("Thaumium Drill", "Thaumium Chainsaw").setParents("Diamond Omnitool").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumiumOmnitool), new ResearchPage(IC2RecipeRegistry.diamondOmnitoolToThaumium));
            }
        }

        if (ConfigHandler.explosionFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Explosion Focus", "EMT", ResearchAspects.laserFocusResearch, 2, 3, 2, new ItemStack(IC2ItemRegistry.explosionFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.explosionFocus));
        }

        if (ConfigHandler.christmasFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Kris-tmas Focus", "EMT", ResearchAspects.christmasFocusResearch, 3, 3, 1, new ItemStack(IC2ItemRegistry.christmasFocus)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.christmasFocus));
        }

        if (ConfigHandler.shieldFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Shield Focus", "EMT", ResearchAspects.shieldFocusResearch, 4, 3, 2, new ItemStack(IC2ItemRegistry.shieldFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.shieldFocus));
        }

        if (ConfigHandler.shieldFocusResearch == false) {
            if (ConfigHandler.shieldBlockResearch == false) {
                text = "1";
                research = new EMTResearchItem("Shield Block", "EMT", ResearchAspects.shieldBlockResearch, 4, 5, 1, new ItemStack(IC2BlockRegistry.shield)).setSecondary().setParents("Shield Focus").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.shieldBlock));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            text = "1";
            research = new EMTResearchItem("Potentia Generator", "EMT", ResearchAspects.potentiaGeneratorResearch, -2, 3, 3, new ItemStack(IC2BlockRegistry.essentiaGens, 1, 0)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.potentiaGenerator));
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.ignisGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Ignis Generator", "EMT", ResearchAspects.ignisGeneratorResearch, -3, 4, 1, new ItemStack(IC2BlockRegistry.essentiaGens, 1, 1)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.ignisGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.auramGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Auram Generator", "EMT", ResearchAspects.auramGeneratorResearch, -1, 4, 1, new ItemStack(IC2BlockRegistry.essentiaGens, 1, 2)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.auramGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.arborGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Arbor Generator", "EMT", ResearchAspects.arborGeneratorResearch, -2, 5, 1, new ItemStack(IC2BlockRegistry.essentiaGens, 1, 3)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.arborGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.aerGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Aer Generator", "EMT", ResearchAspects.aerGenerator, -2, 6, 1, new ItemStack(IC2BlockRegistry.essentiaGens, 1, 4)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.aerGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.wandChargingSationResearch == false) {
                text = "1";
                research = new EMTResearchItem("Industrial Wand Charging Station", "EMT", ResearchAspects.wandCharger, -4, 2, 3, new ItemStack(IC2BlockRegistry.emtMachines, 1, 0)).setParents("Potentia Generator").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.wandRecharger));
            }
        }

        if (ConfigHandler.thaumiumChainsawResearch == false) {
            if (ConfigHandler.streamChainsawResearch == false) {
                text = "1";
                research = new EMTResearchItem("Chainsaw of the Stream", "EMT", ResearchAspects.streamChainsawResearch, -3, -4, 3, new ItemStack(IC2ItemRegistry.streamChainsaw)).setParents("Thaumium Chainsaw").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.streamChainsaw));
            }
        }

        if (ConfigHandler.thaumiumDrillResearch == false) {
            if (ConfigHandler.rockbreakerDrillResearch == false) {
                text = "1";
                research = new EMTResearchItem("Drill of the Rockbreaker", "EMT", ResearchAspects.rockbreakerDrillResearch, 0, -4, 3, new ItemStack(IC2ItemRegistry.rockbreakerDrill)).setParents("Thaumium Drill").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.rockbreakerDrill));
            }
        }

        if (ConfigHandler.tinyUraniumResearch == false) {
            text = "1";
            research = new EMTResearchItem("Tiny Uranium", "EMT", ResearchAspects.tinyUraniumResearch, -5, -5, 1, IC2Items.getItem("Uran238")).setSecondary().setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.tinyUranium));
        }

        if (ConfigHandler.thorHammerResearch == false) {
            text = "1";
            research = new EMTResearchItem("Mjolnir", "EMT", ResearchAspects.thorHammerResearch, -5, 5, 3, new ItemStack(IC2ItemRegistry.thorHammer)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thorHammer));
        }

        if (ConfigHandler.thorHammerResearch == false) {
            if (ConfigHandler.superchargedThorHammerResearch == false) {
                text = "1";
                research = new EMTResearchItem("Supercharged Mjolnir", "EMT", ResearchAspects.superchargedThorHammerResearch, -6, 6, 3, new ItemStack(IC2ItemRegistry.electricThorHammer)).setParents("Mjolnir").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.superchargedThorHammer));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Compressed Solars", "EMT", ResearchAspects.compressedSolars, -4, -5, 2, new ItemStack(IC2BlockRegistry.emtSolars)).setParentsHidden("Potentia Generator").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.compressedSolar), new ResearchPage(IC2RecipeRegistry.doubleCompressedSolar), new ResearchPage(IC2RecipeRegistry.tripleCompressedSolar));
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.solarHelmetResearch == false) {
                text = "1";
                research = new EMTResearchItem("Solar Helmet of Revealing", "EMT", ResearchAspects.solarHelmetRevealing, -2, -5, 1, new ItemStack(IC2ItemRegistry.solarHelmetRevealing)).setSecondary().setParents("Compressed Solars").setParentsHidden("Quantum Goggles of Revealing").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.solarHelmetRevealing));
            }
        }

        if (ConfigHandler.electricBootsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Boots of the Traveller", "EMT", ResearchAspects.electricBootsTravel, 2, 0, 1, new ItemStack(IC2ItemRegistry.electricBootsTraveller)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.electricBootsTravel));
        }

        if (ConfigHandler.electricBootsResearch == false) {
            if (ConfigHandler.nanoBootsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Nano Boots of the Traveller", "EMT", ResearchAspects.nanoBootsTravel, 4, 0, 2, new ItemStack(IC2ItemRegistry.nanoBootsTraveller)).setParents("Electric Boots of the Traveller").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.nanoBootsTravel));
            }
        }

        if (ConfigHandler.electricBootsResearch == false) {
            if (ConfigHandler.nanoBootsResearch == false) {
                if (ConfigHandler.quantumBootsResearch == false) {
                    text = "1";
                    research = new EMTResearchItem("Quantum Boots of the Traveller", "EMT", ResearchAspects.quantumBootsTravel, 6, 0, 3, new ItemStack(IC2ItemRegistry.quantumBootsTraveller)).setParents("Nano Boots of the Traveller").setConcealed().registerResearchItem();
                    research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.quantumBootsTravel));
                }
            }
        }

        if (ConfigHandler.electricScribingToolsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Scribing Tools", "EMT", ResearchAspects.electricScribingTools, -6, -5, 1, new ItemStack(IC2ItemRegistry.electricScribingTools)).setSecondary().setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.electricScribingTools));
        }

        if (ConfigHandler.etherealProcessorResearch == false) {
            text = "1";
            research = new EMTResearchItem("Etheral Processor", "EMT", ResearchAspects.etherealProcessor, -1, 2, 2, new ItemStack(IC2BlockRegistry.emtMachines, 1, 1)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.etheralProcessor));
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.waterSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Water Infused Solar Panels", "EMT", ResearchAspects.waterSolars, -7, -7, 1, new ItemStack(IC2BlockRegistry.emtSolars, 1, 3)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.waterSolar), new ResearchPage(IC2RecipeRegistry.doubleWaterSolar), new ResearchPage(IC2RecipeRegistry.tripleWaterSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.darkSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Entropy Infused Solar Panels", "EMT", ResearchAspects.darkSolars, -8, -6, 1, new ItemStack(IC2BlockRegistry.emtSolars, 1, 6)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.darkSolar), new ResearchPage(IC2RecipeRegistry.doubleDarkSolar), new ResearchPage(IC2RecipeRegistry.tripleDarkSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.orderSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Order Infused Solar Panels", "EMT", ResearchAspects.orderSolars, -6, -8, 1, new ItemStack(IC2BlockRegistry.emtSolars, 1, 9)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.orderSolar), new ResearchPage(IC2RecipeRegistry.doubleOrderSolar), new ResearchPage(IC2RecipeRegistry.tripleOrderSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.fireSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Fire Infused Solar Panels", "EMT", ResearchAspects.fireSolars, -5, -7, 1, new ItemStack(IC2BlockRegistry.emtSolars, 1, 12)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.fireSolar), new ResearchPage(IC2RecipeRegistry.doubleFireSolar), new ResearchPage(IC2RecipeRegistry.tripleFireSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.airSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Air Infused Solar Panels", "EMT", ResearchAspects.airSolars, -4, -6, 1, new ItemStack(IC2BlockRegistry.emtSolars, 1, 15)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.airSolar), new ResearchPage(IC2RecipeRegistry.doubleAirSolar), new ResearchPage(IC2RecipeRegistry.tripleAirSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.earthSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Earth Infused Solar Panels", "EMT", ResearchAspects.earthSolars, -6, -7, 1, new ItemStack(IC2BlockRegistry.emtSolars2, 1, 2)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.earthSolar), new ResearchPage(IC2RecipeRegistry.doubleEarthSolar), new ResearchPage(IC2RecipeRegistry.tripleEarthSolar));
            }
        }

        if (ConfigHandler.uuMInfusionResearch == false) {
            text = "1";
            research = new EMTResearchItem("UU-Matter Infusion", "EMT", ResearchAspects.uuMInfusion, 5, 5, 3, new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 16)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.charcoalToCoal), new ResearchPage(IC2RecipeRegistry.glowstoneDustToBlock), new ResearchPage(IC2RecipeRegistry.stoneBricksToIronOre), new ResearchPage(IC2RecipeRegistry.arcaneStoneToCopperOre), new ResearchPage(IC2RecipeRegistry.arcaneStoneBricksToTinOre), new ResearchPage(IC2RecipeRegistry.amberBlockToLeadOre), new ResearchPage(IC2RecipeRegistry.amberBricksToUraniumOre), new ResearchPage(IC2RecipeRegistry.shardToResin), new ResearchPage(IC2RecipeRegistry.shardToRedstone), new ResearchPage(IC2RecipeRegistry.shardToLapis), new ResearchPage(IC2RecipeRegistry.ironToGold), new ResearchPage(IC2RecipeRegistry.goldToDiamond), new ResearchPage(IC2RecipeRegistry.diamondToUranium), new ResearchPage(IC2RecipeRegistry.uraniumToIridium));
        }

        if (ConfigHandler.portableNodeResarch == false) {
            text = "1";
            research = new EMTResearchItem("Portable Node", "EMT", ResearchAspects.portableNode, 2, 5, 3, new ItemStack(BaseBlockRegistry.portableNode)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.portableNode));
        }

        if (ConfigHandler.electricHoeGrowthResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Hoe of Growth", "EMT", ResearchAspects.electricHoeGrowth, -1, -4, 2, new ItemStack(IC2ItemRegistry.electricHoeGrowth)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.electricHoeGrowth));
        }

        if (ConfigHandler.chargeFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Wand Focus: Charging", "EMT", ResearchAspects.chargeFocus, 5, 3, 2, new ItemStack(IC2ItemRegistry.chargeFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.chargeFocus));
        }

        if (ConfigHandler.wandChargeFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Wand Focus: Wand Charging", "EMT", ResearchAspects.wandChargeFocus, 7, 3, 3, new ItemStack(IC2ItemRegistry.wandChargeFocus)).setParents("Wand Focus: Charging").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.wandChargeFocus));
        }

        if (ConfigHandler.inventoryChargingRing == false) {
            text = "1";
            research = new EMTResearchItem("Inventory Charging Ring", "EMT", ResearchAspects.inventoryChargingRing, 0, -5, 3, new ItemStack(IC2ItemRegistry.emtBauble, 1, 1)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.inventoryChargingRing));
        }

        if (ConfigHandler.armorChargingRing == false) {
            text = "1";
            research = new EMTResearchItem("Armor Charging Ring", "EMT", ResearchAspects.armorChargingRing, 0, -7, 3, new ItemStack(IC2ItemRegistry.emtBauble, 1, 0)).setSecondary().setParents("Inventory Charging Ring").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.armorChargingRing));
        }

        if (ConfigHandler.thaumiumWingResearch == false) {
            text = "1";
            research = new EMTResearchItem("Thaumium Reinforced Wings", "EMT", ResearchAspects.thaumiumWing, 0, 4, 0, new ItemStack(IC2ItemRegistry.thaumiumWing)).setSecondary().setParents("Feather Wings").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.thaumiumWing), new ResearchPage(IC2RecipeRegistry.thaumiumWings));
        }

        if (ConfigHandler.nanoWingResearch == false) {
            text = "1";
            research = new EMTResearchItem("Nanosuit Wings", "EMT", ResearchAspects.nanoWing, 0, 6, 2, new ItemStack(IC2ItemRegistry.nanoWing)).setParents("Thaumium Reinforced Wings").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.nanoWings));
        }

        if (ConfigHandler.quantumWingsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Quantum Wings", "EMT", ResearchAspects.quantumWing, 0, 8, 3, new ItemStack(IC2ItemRegistry.quantumWing)).setParents("Nanosuit Wings").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(IC2RecipeRegistry.quantumWings));
        }
    }
}
