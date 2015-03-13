package amerifrance.emt;

import amerifrance.emt.gui.CreativeTabEMT;
import amerifrance.emt.gui.GuiHandler;
import amerifrance.emt.modules.ModuleRegistry;
import amerifrance.emt.proxies.CommonProxy;
import amerifrance.emt.util.EventHandler;
import amerifrance.emt.util.LootHandler;
import amerifrance.emt.util.OreDictHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tterrag.core.common.Handlers;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class ElectroMagicTools {

    @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs tabEMT = new CreativeTabEMT(ModInformation.ID + ".creativeTab");
    public static Logger logger = LogManager.getLogger(ModInformation.NAME);

    @Mod.Instance
    public static ElectroMagicTools instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.INSTANCE.initialize(new File(event.getModConfigurationDirectory() + "/" + "ElectroMagicTools" + ".cfg"));
        ModuleRegistry.registerEarlyModules();
        OreDictHandler.registerOreDict();
        Handlers.addPackage("amerifrance.emt");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenders();
        LootHandler.addLootToChests();
        ModuleRegistry.registerMidModules();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        FMLCommonHandler.instance().bus().register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ModuleRegistry.registerLateModules();
    }
}
