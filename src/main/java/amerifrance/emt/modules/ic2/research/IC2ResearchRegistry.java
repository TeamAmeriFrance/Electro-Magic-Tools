package amerifrance.emt.modules.ic2.research;

import amerifrance.emt.ConfigHandler;
import amerifrance.emt.ModInformation;
import amerifrance.emt.modules.ic2.items.IC2ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class IC2ResearchRegistry {

    public static String EMT = "EMT";

    public static void addResearchTab() {
        ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
        ResearchCategories.registerCategory(EMT, new ResourceLocation(ModInformation.TEXLOC + "textures/misc/emt.png"), background);
    }

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
            researchItem = new IC2ResearchItem("nano_goggles", EMT, IC2ResearchAspects.nanoGoggles, 3, 3, 1, new ItemStack(IC2ItemRegistry.armorNanoGoggles))
                    .setParents("electric_goggles")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch && ConfigHandler.quantumGogglesResearch) {
            researchItem = new IC2ResearchItem("quantum_goggles", EMT, IC2ResearchAspects.quantumGoggles, 4, 3, 1, new ItemStack(IC2ItemRegistry.armorQuantumGoggles))
                    .setParents("nano_goggles")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
        if (ConfigHandler.electricGogglesResearch && ConfigHandler.nanoGogglesResearch && ConfigHandler.quantumGogglesResearch && ConfigHandler.solarHelmetResearch) {
            researchItem = new IC2ResearchItem("solar_helmet", EMT, IC2ResearchAspects.solarHelmet, 5, 3, 1, new ItemStack(IC2ItemRegistry.armorSolarGoggles))
                    .setParents("quantum_goggles")
                    .setHidden()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
    }
}
