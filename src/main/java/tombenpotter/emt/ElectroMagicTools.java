/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package tombenpotter.emt;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tombenpotter.emt.common.commands.CommandOutputs;
import tombenpotter.emt.common.modules.ModuleRegistry;
import tombenpotter.emt.common.modules.base.entities.BaseEntityRegistry;
import tombenpotter.emt.common.modules.ic2.IC2RecipeRegistry;
import tombenpotter.emt.common.util.*;
import tombenpotter.emt.proxies.CommonProxy;

import static tombenpotter.emt.common.util.TextHelper.localize;

@Mod(modid = ModInformation.modid, name = ModInformation.name, version = ModInformation.version, guiFactory = ModInformation.guiFactory, dependencies = ModInformation.depend)
public class ElectroMagicTools {


    @SidedProxy(clientSide = ModInformation.clientProxy, serverSide = ModInformation.commonProxy)
    public static CommonProxy proxy;

    public static CreativeTabs tabEMT = new CreativeTabEMT(ModInformation.modid + ".creativeTab");
    public static Logger logger = LogManager.getLogger(ModInformation.name);

    @Instance(ModInformation.modid)
    public static ElectroMagicTools instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ElectroMagicTools.logger.info(localize("console.EMT.preInit.begin"));

        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new EventHandlerEMT());
	    ModuleRegistry.registerModules();
        EssentiasOutputs.addPrimalOutputs();
        EssentiasOutputs.addOutputs();

        ElectroMagicTools.logger.info(localize("console.EMT.preInit.end"));
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        ElectroMagicTools.logger.info(localize("console.EMT.init.begin"));

        ElectroMagicTools.logger.info(localize("console.EMT.init.loadProxies"));
        proxy.load();
        ElectroMagicTools.logger.info(localize("console.EMT.init.mobDrops"));
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        ElectroMagicTools.logger.info(localize("console.EMT.init.loot"));
        DungeonChestGenerator.generateLoot();

        ElectroMagicTools.logger.info(localize("console.EMT.init.entities"));
        BaseEntityRegistry.registerEMTEntities();
        ElectroMagicTools.logger.info(localize("console.EMT.init.guiHandler"));
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

        ElectroMagicTools.logger.info(localize("console.EMT.init.end"));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ElectroMagicTools.logger.info(localize("console.EMT.postInit.begin"));

        ElectroMagicTools.logger.info(localize("console.EMT.postInit.recipes"));
	    IC2RecipeRegistry.registerLateRecipes();
        ElectroMagicTools.logger.info(localize("console.EMT.postInit.uumatter"));
	    IC2RecipeRegistry.registerUUMInfusionRecipes();
        RegistryHandler.registerIc2PostRegistrys();

        ElectroMagicTools.logger.info(localize("console.EMT.postInit.end"));
    }

    @EventHandler
    public void onFMLServerStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandOutputs());
    }
}
