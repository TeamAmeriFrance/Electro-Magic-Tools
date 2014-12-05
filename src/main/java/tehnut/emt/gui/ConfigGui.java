package tehnut.emt.gui;

import net.minecraft.client.gui.GuiScreen;
import tehnut.emt.ConfigHandler;
import tehnut.emt.ModInformation;
import tehnut.emt.util.TextHelper;
import tterrag.core.api.common.config.IConfigHandler;
import tterrag.core.client.config.BaseConfigGui;

public class ConfigGui extends BaseConfigGui {
	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen);
	}

	@Override
	protected IConfigHandler getConfigHandler() {
		return ConfigHandler.INSTANCE;
	}

	@Override
	protected String getTitle() {
		return TextHelper.localize("EMT.config.title");
	}

	@Override
	protected String getLangPrefix() {
		return ModInformation.ID + ".config.";
	}
}