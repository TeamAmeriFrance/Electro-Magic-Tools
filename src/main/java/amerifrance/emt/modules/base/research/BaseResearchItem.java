package amerifrance.emt.modules.base.research;

import amerifrance.emt.ConfigHandler;
import amerifrance.emt.util.TextHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class BaseResearchItem extends ResearchItem {

    public BaseResearchItem(String key, String category) {
        super(key, category);
    }

    public BaseResearchItem(String key, String category, AspectList tags, int col, int row, int complex, ResourceLocation icon) {
        super(key, category, tags, col, row, complex, icon);
    }

    public BaseResearchItem(String key, String category, AspectList tags, int col, int row, int complex, ItemStack icon) {
        super(key, category, tags, col, row, complex, icon);
    }

    @Override
    public String getName() {
        return TextHelper.localize("emt.base.name." + key);
    }

    @Override
    public String getText() {
        return ConfigHandler.researchTag + " " + TextHelper.localize("emt.base.tag." + key);
    }

    @Override
    public ResearchItem setPages(ResearchPage... par) {
        for (ResearchPage page : par) {
            if (page.type == ResearchPage.PageType.TEXT) page.text = "emt.base.page." + key + "." + page.text;
            if (page.type == ResearchPage.PageType.INFUSION_CRAFTING) {
                if (parentsHidden == null || parentsHidden.length == 0)
                    parentsHidden = new String[]{"INFUSION"};
                else {
                    String[] newParents = new String[parentsHidden.length + 1];
                    newParents[0] = "INFUSION";
                    for (int i = 0; i < parentsHidden.length; i++) newParents[i + 1] = parentsHidden[i];
                    parentsHidden = newParents;
                }
            }
        }
        return super.setPages(par);
    }
}