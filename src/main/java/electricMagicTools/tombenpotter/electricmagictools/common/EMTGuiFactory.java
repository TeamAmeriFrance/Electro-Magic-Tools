package electricMagicTools.tombenpotter.electricmagictools.common;

import cpw.mods.fml.client.IModGuiFactory;
import electricMagicTools.tombenpotter.electricmagictools.client.gui.EMTGuiConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

public class EMTGuiFactory implements IModGuiFactory{
    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return EMTGuiConfig.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}
