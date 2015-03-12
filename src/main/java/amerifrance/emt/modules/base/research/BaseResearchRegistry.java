package amerifrance.emt.modules.base.research;

import amerifrance.emt.ConfigHandler;
import amerifrance.emt.ModInformation;
import amerifrance.emt.modules.base.items.BaseItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class BaseResearchRegistry {

    public static String EMT = "EMT";

    public static void addResearchTab() {
        ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
        ResearchCategories.registerCategory(EMT, new ResourceLocation(ModInformation.TEXLOC + "textures/misc/emt.png"), background);
    }

    public static void addResearch() {
        ResearchItem researchItem;

        researchItem = new BaseResearchItem("feather_wings", EMT, new AspectList(), 2, 1, 0, new ItemStack(BaseItemRegistry.wingFeather))
                .setAutoUnlock()
                .setParents("emt_ic2")
                .setRound()
                .setPages(new ResearchPage("0")/*,Recipe Page*/)
                .registerResearchItem();
        if (ConfigHandler.nanoWingResearch) {
            researchItem = new BaseResearchItem("thaumium_wings", EMT, BaseResearchAspects.thaumiumWings, 3, 1, 1, new ItemStack(BaseItemRegistry.wingThaumium))
                    .setSecondary()
                    .setParents("feather_wings")
                    .setConcealed()
                    .setPages(new ResearchPage("0")/*,Recipe Page*/)
                    .registerResearchItem();
        }
    }
}
