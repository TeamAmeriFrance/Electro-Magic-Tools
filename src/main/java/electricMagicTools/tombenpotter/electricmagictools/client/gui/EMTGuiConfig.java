package electricMagicTools.tombenpotter.electricmagictools.client.gui;

import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EMTGuiConfig extends GuiConfig {
    public EMTGuiConfig(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), ElectricMagicTools.modid, false, false, GuiConfig.getAbridgedConfigPath(Config.config.toString()));
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyConfigElement.DummyCategoryElement("General Config", "emt.config.general", GeneralEntry.class));
        list.add(new DummyConfigElement.DummyCategoryElement("Values Config", "emt.config.valuezs", ValuesEntry.class));
        list.add(new DummyConfigElement.DummyCategoryElement("Research Disabling Config", "emt.config.research.disable", ResearchEntry.class));
        return list;
    }

    public static class GeneralEntry extends GuiConfigEntries.CategoryEntry {
        public GeneralEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(Config.config.getCategory(Configuration.CATEGORY_GENERAL))).getChildElements(),
                    this.owningScreen.modID, Configuration.CATEGORY_GENERAL, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath("emt/config/general"));
        }
    }

    public static class ValuesEntry extends GuiConfigEntries.CategoryEntry {
        public ValuesEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(Config.config.getCategory(Config.CATEGORY_VALUES))).getChildElements(),
                    this.owningScreen.modID, Configuration.CATEGORY_GENERAL, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath("emt/config/values"));
        }
    }

    public static class ResearchEntry extends GuiConfigEntries.CategoryEntry {
        public ResearchEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(Config.config.getCategory(Config.CATEGORY_RESEARCH))).getChildElements(),
                    this.owningScreen.modID, Configuration.CATEGORY_GENERAL, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                    this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                    GuiConfig.getAbridgedConfigPath("emt/config/research"));
        }
    }
}
