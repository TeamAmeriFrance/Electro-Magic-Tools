package tehnut.emt.gui;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import tehnut.emt.ModInformation;
import tehnut.emt.util.TextHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

import static tehnut.emt.ConfigHandler.*;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), ModInformation.ID, false, false, TextHelper.localize("gui.EMT.config.title"));
	}

	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements(GuiScreen parent) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		list.add(new ConfigElement<ConfigCategory>(config.getCategory(modules.toLowerCase())));
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(research.toLowerCase())));
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(values.toLowerCase())));
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(misc.toLowerCase())));
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(generators.toLowerCase())));

		return list;
	}
}