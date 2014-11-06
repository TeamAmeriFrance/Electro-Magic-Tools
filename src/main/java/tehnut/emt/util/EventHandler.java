package tehnut.emt.util;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import tehnut.emt.ElectroMagicTools;
import tehnut.emt.ConfigHandler;
import tehnut.emt.ModInformation;

public class EventHandler {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(ModInformation.ID)) {
			ConfigHandler.syncConfig();
			ElectroMagicTools.logger.info(TextHelper.localize("info.EMT.console.config.refresh"));
		}
	}
}
