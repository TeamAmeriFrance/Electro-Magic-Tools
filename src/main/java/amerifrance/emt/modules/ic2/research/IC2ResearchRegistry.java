package amerifrance.emt.modules.ic2.research;

import amerifrance.emt.ConfigHandler;
import amerifrance.emt.ModInformation;
import amerifrance.emt.modules.ic2.items.IC2ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class IC2ResearchRegistry {

    public static String EMT = "EMT";

    public static void addResearch() {
        ResearchItem researchItem;

        researchItem = new IC2ResearchItem("emt_ic2", EMT, new AspectList(), 1, 0, 0, new ResourceLocation(ModInformation.TEXLOC + "textures/misc/emt.png"))
                .setRound()
                .setAutoUnlock()
                .setPages(new ResearchPage("0"))
                .registerResearchItem();

        if (ConfigHandler.electricGogglesResearch) {
            researchItem = new IC2ResearchItem("electric_goggles", EMT, IC2ResearchAspects.electricGoggles, 2, 3, 1, new ItemStack(IC2ItemRegistry.armorElectricGoggles))
                    .setSecondary()
                    .setParents("emt_ic2")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch) {
            researchItem = new IC2ResearchItem("nano_goggles", EMT, IC2ResearchAspects.nanoGoggles, 3, 3, 2, new ItemStack(IC2ItemRegistry.armorNanoGoggles))
                    .setParents("electric_goggles")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch && ConfigHandler.quantumGogglesResearch) {
            researchItem = new IC2ResearchItem("quantum_goggles", EMT, IC2ResearchAspects.quantumGoggles, 4, 3, 3, new ItemStack(IC2ItemRegistry.armorQuantumGoggles))
                    .setParents("nano_goggles")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch && ConfigHandler.quantumGogglesResearch && ConfigHandler.solarHelmetResearch) {
            researchItem = new IC2ResearchItem("solar_helmet", EMT, IC2ResearchAspects.solarHelmet, 5, 3, 3, new ItemStack(IC2ItemRegistry.armorSolarGoggles))
                    .setParents("quantum_goggles")
                    .setHidden()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        if (ConfigHandler.electricBootsResearch) {
            researchItem = new IC2ResearchItem("electric_boots", EMT, IC2ResearchAspects.electricBoots, 2, 1, 1, new ItemStack(IC2ItemRegistry.armorElectricBoots))
                    .setSecondary()
                    .setParents("emt_ic2")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricBootsResearch && ConfigHandler.nanoBootsResearch) {
            researchItem = new IC2ResearchItem("nano_boots", EMT, IC2ResearchAspects.nanoBoots, 3, 1, 2, new ItemStack(IC2ItemRegistry.armorNanoBoots))
                    .setParents("electric_boots")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricBootsResearch && ConfigHandler.nanoBootsResearch && ConfigHandler.quantumBootsResearch) {
            researchItem = new IC2ResearchItem("quantum_boots", EMT, IC2ResearchAspects.quantumBoots, 4, 1, 3, new ItemStack(IC2ItemRegistry.armorQuantumBoots))
                    .setParents("nano_boots")
                    .setHidden()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }

        if (ConfigHandler.nanoWingResearch) {
            researchItem = new IC2ResearchItem("nano_wings", EMT, IC2ResearchAspects.nanoWings, 4, -1, 2, new ItemStack(IC2ItemRegistry.armorNanoWing))
                    .setParents("thaumium_wings")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.nanoWingResearch && ConfigHandler.quantumWingResearch) {
            researchItem = new IC2ResearchItem("quantum_wings", EMT, IC2ResearchAspects.quantumWings, 5, -1, 3, new ItemStack(IC2ItemRegistry.armorQuantumWing))
                    .setParents("nano_wings")
                    .setHidden()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
    }
}
