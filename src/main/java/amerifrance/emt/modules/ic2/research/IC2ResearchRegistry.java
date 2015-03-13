package amerifrance.emt.modules.ic2.research;

import amerifrance.emt.ConfigHandler;
import amerifrance.emt.ModInformation;
import amerifrance.emt.modules.ic2.blocks.IC2BlockRegistry;
import amerifrance.emt.modules.ic2.items.IC2ItemRegistry;
import amerifrance.emt.util.EssentiaOutputs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import java.util.ArrayList;
import java.util.List;

public class IC2ResearchRegistry {

    public static String EMT = "EMT";

    public static void addResearch() {
        ResearchItem researchItem;

        researchItem = new IC2ResearchItem("emt_ic2", EMT, new AspectList(), 1, 0, 0, new ResourceLocation(ModInformation.TEXLOC + "textures/misc/emt.png"))
                .setRound()
                .setAutoUnlock()
                .setPages(new ResearchPage("0"))
                .registerResearchItem();

        // Armors researches
        if (ConfigHandler.electricGogglesResearch) {
            researchItem = new IC2ResearchItem("electric_goggles", EMT, IC2ResearchAspects.electricGoggles, 2, 5, 1, new ItemStack(IC2ItemRegistry.armorElectricGoggles))
                    .setSecondary()
                    .setParents("emt_ic2")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch) {
            researchItem = new IC2ResearchItem("nano_goggles", EMT, IC2ResearchAspects.nanoGoggles, 3, 5, 2, new ItemStack(IC2ItemRegistry.armorNanoGoggles))
                    .setParents("electric_goggles")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch && ConfigHandler.quantumGogglesResearch) {
            researchItem = new IC2ResearchItem("quantum_goggles", EMT, IC2ResearchAspects.quantumGoggles, 4, 5, 3, new ItemStack(IC2ItemRegistry.armorQuantumGoggles))
                    .setParents("nano_goggles")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch && ConfigHandler.quantumGogglesResearch && ConfigHandler.solarHelmetResearch) {
            researchItem = new IC2ResearchItem("solar_helmet", EMT, IC2ResearchAspects.solarHelmet, 5, 5, 3, new ItemStack(IC2ItemRegistry.armorSolarGoggles))
                    .setParents("quantum_goggles")
                    .setParentsHidden("compressed_solars")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        if (ConfigHandler.electricBootsResearch) {
            researchItem = new IC2ResearchItem("electric_boots", EMT, IC2ResearchAspects.electricBoots, 2, 3, 1, new ItemStack(IC2ItemRegistry.armorElectricBoots))
                    .setSecondary()
                    .setParents("emt_ic2")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricBootsResearch && ConfigHandler.nanoBootsResearch) {
            researchItem = new IC2ResearchItem("nano_boots", EMT, IC2ResearchAspects.nanoBoots, 3, 3, 2, new ItemStack(IC2ItemRegistry.armorNanoBoots))
                    .setParents("electric_boots")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricBootsResearch && ConfigHandler.nanoBootsResearch && ConfigHandler.quantumBootsResearch) {
            researchItem = new IC2ResearchItem("quantum_boots", EMT, IC2ResearchAspects.quantumBoots, 4, 3, 3, new ItemStack(IC2ItemRegistry.armorQuantumBoots))
                    .setParents("nano_boots")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        if (ConfigHandler.nanoWingResearch) {
            researchItem = new IC2ResearchItem("nano_wings", EMT, IC2ResearchAspects.nanoWings, 4, 1, 2, new ItemStack(IC2ItemRegistry.armorNanoWing))
                    .setParents("thaumium_wings")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.nanoWingResearch && ConfigHandler.quantumWingResearch) {
            researchItem = new IC2ResearchItem("quantum_wings", EMT, IC2ResearchAspects.quantumWings, 5, 1, 3, new ItemStack(IC2ItemRegistry.armorQuantumWing))
                    .setParents("nano_wings")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        // Tools reseaches
        if (ConfigHandler.thaumiumDrillResearch) {
            researchItem = new IC2ResearchItem("thaumium_drill", EMT, IC2ResearchAspects.thaumiumDrill, 3, -1, 2, new ItemStack(IC2ItemRegistry.toolDrillThaumium))
                    .setParents("emt_ic2")
                    .setSecondary()
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.thaumiumDrillResearch && ConfigHandler.rockbreakerDrillResearch) {
            researchItem = new IC2ResearchItem("rockbreaker_drill", EMT, IC2ResearchAspects.rockbreakerDrill, 4, -1, 3, new ItemStack(IC2ItemRegistry.toolDrillRockbreaker))
                    .setParents("thaumium_drill")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        researchItem = new IC2ResearchItem("diamond_chainsaw", EMT, new AspectList(), 2, -3, 0, new ItemStack(IC2ItemRegistry.toolChainsawDiamond))
                .setParents("emt_ic2")
                .setRound()
                .setAutoUnlock()
                .setPages(new ResearchPage("0")/*,Recipe Page*/)
                .registerResearchItem();
        if (ConfigHandler.thaumiumChainsawResearch) {
            researchItem = new IC2ResearchItem("thaumium_chainsaw", EMT, IC2ResearchAspects.thaumiumChainsaw, 3, -3, 2, new ItemStack(IC2ItemRegistry.toolChainsawThaumium))
                    .setParents("diamond_chainsaw")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.thaumiumChainsawResearch && ConfigHandler.streamChainsawResearch) {
            researchItem = new IC2ResearchItem("stream_chainsaw", EMT, IC2ResearchAspects.streamChainsaw, 4, -3, 3, new ItemStack(IC2ItemRegistry.toolChainsawStream))
                    .setParents("thaumium_chainsaw")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        if (ConfigHandler.ironOmnitoolResearch) {
            researchItem = new IC2ResearchItem("iron_omnitool", EMT, new AspectList(), 2, -5, 0, new ItemStack(IC2ItemRegistry.toolOmniIron))
                    .setParents("emt_ic2")
                    .setRound()
                    .setAutoUnlock()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.ironOmnitoolResearch && ConfigHandler.diamondOmnitoolResearch) {
            researchItem = new IC2ResearchItem("diamond_omnitool", EMT, IC2ResearchAspects.diamondOmnitool, 3, -5, 2, new ItemStack(IC2ItemRegistry.toolOmniDiamond))
                    .setParents("iron_omnitool")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.ironOmnitoolResearch && ConfigHandler.diamondOmnitoolResearch && ConfigHandler.thaumiumOmnitoolResearch) {
            researchItem = new IC2ResearchItem("thaumium_omnitool", EMT, IC2ResearchAspects.thaumiumOnmitool, 4, -5, 3, new ItemStack(IC2ItemRegistry.toolOmniThaumium))
                    .setParents("diamond_omnitool")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        // Essentia Generator
        if (ConfigHandler.essentiaGeneratorResearch) {
            List<ResearchPage> pages = new ArrayList<ResearchPage>();
            pages.add(new ResearchPage("emt.ic2.page.essentia_generator.0"));
            //pages.add(/*Recipe Page*/)
            String primals = "";
            for (int i = 0; i < Aspect.getPrimalAspects().size(); i++) {
                Aspect aspect = Aspect.getPrimalAspects().get(i);
                if (aspect != null) {
                    if (i == 0) {
                        primals = aspect.getName() + ": " + String.valueOf(EssentiaOutputs.outputs.get(aspect.getTag()).intValue()) + " EU";
                    } else {
                        primals += "<BR>" + aspect.getName() + ": " + String.valueOf(EssentiaOutputs.outputs.get(aspect.getTag()).intValue()) + " EU";
                    }
                }
            }
            pages.add(new ResearchPage(primals));
            String compounds[] = new String[(Aspect.getCompoundAspects().size() / 10) + 1];
            int pageNumber = 0;
            for (int i = 0; i < Aspect.getCompoundAspects().size(); i++) {
                Aspect aspect = Aspect.getCompoundAspects().get(i);
                if (aspect != null) {
                    if (i != 0 && i % 10 == 0) pageNumber++;
                    if (i % 10 == 0) {
                        compounds[pageNumber] = aspect.getName() + ": " + String.valueOf(EssentiaOutputs.outputs.get(aspect.getTag()).intValue()) + " EU";
                    } else {
                        compounds[pageNumber] += "<BR>" + aspect.getName() + ": " + String.valueOf(EssentiaOutputs.outputs.get(aspect.getTag()).intValue()) + " EU";
                    }
                }
            }
            for (String s : compounds) pages.add(new ResearchPage(s));

            researchItem = new IC2ResearchItem.NonLocTextResearchItem("essentia_generator", EMT, IC2ResearchAspects.essentiaGenerator, 6, 0, 2, new ItemStack(IC2BlockRegistry.essentiaGen))
                    .setParents("emt_ic2")
                    .setConcealed()
                    .setPages(pages.toArray(new ResearchPage[pages.size()]))
                    .registerResearchItem();
        }

        //Solar Panels
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch) {
            researchItem = new IC2ResearchItem("compressed_solars", EMT, IC2ResearchAspects.compressedSolars, 8, 0, 3, new ItemStack(IC2BlockRegistry.solars1, 0))
                    .setParents("essentia_generator")
                    .setConcealed()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.airSolarsResearch) {
            researchItem = new IC2ResearchItem("air_solars", EMT, IC2ResearchAspects.airSolars, 8, 2, 2, new ItemStack(IC2BlockRegistry.solars1, 15))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.darkSolarsResearch) {
            researchItem = new IC2ResearchItem("dark_solars", EMT, IC2ResearchAspects.darkSolars, 8, -2, 2, new ItemStack(IC2BlockRegistry.solars1, 6))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.earthSolarsResearch) {
            researchItem = new IC2ResearchItem("earth_solars", EMT, IC2ResearchAspects.earthSolars, 9, 2, 2, new ItemStack(IC2BlockRegistry.solars2, 2))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.fireSolarsResearch) {
            researchItem = new IC2ResearchItem("fire_solars", EMT, IC2ResearchAspects.fireSolars, 9, -2, 2, new ItemStack(IC2BlockRegistry.solars1, 12))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.orderSolarsResearch) {
            researchItem = new IC2ResearchItem("order_solars", EMT, IC2ResearchAspects.orderSolars, 10, 1, 2, new ItemStack(IC2BlockRegistry.solars1, 9))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.waterSolarsResearch) {
            researchItem = new IC2ResearchItem("water_solars", EMT, IC2ResearchAspects.waterSolars, 10, -1, 2, new ItemStack(IC2BlockRegistry.solars1, 3))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }

        //Wand Charging Station
        if (ConfigHandler.essentiaGeneratorResearch && ConfigHandler.compressedSolarsResearch && ConfigHandler.wandChargingStationResearch) {
            researchItem = new IC2ResearchItem("wand_charger", EMT, IC2ResearchAspects.wandCharger, 11, 0, 3, new ItemStack(IC2BlockRegistry.machines, 0))
                    .setParents("compressed_solars")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("0"))
                    .registerResearchItem();
        }
    }
}
