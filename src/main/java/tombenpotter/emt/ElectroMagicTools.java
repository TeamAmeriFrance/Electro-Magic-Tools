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

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import tombenpotter.emt.common.commands.CommandOutputs;
import tombenpotter.emt.common.module.base.EMTEntityRegistry;
import tombenpotter.emt.common.module.ic2.recipes.EMTInitRecipes;
import tombenpotter.emt.common.module.ic2.recipes.EMTPostInitRecipes;
import tombenpotter.emt.common.module.ic2.recipes.UuMInfusionRecipes;
import tombenpotter.emt.common.util.*;
import tombenpotter.emt.proxies.CommonProxy;

@Mod(modid = ElectroMagicTools.modid, name = "Electro-MagicTools", version = "1.1.4", guiFactory = "tombenpotter.emt.client.gui.config.EMTGuiFactory", dependencies = "required-after:Thaumcraft ; required-after:IC2")
public class ElectroMagicTools {

    @SidedProxy(clientSide = "tombenpotter.emt.proxies.ClientProxy", serverSide = "tombenpotter.emt.proxies.CommonProxy")
    public static CommonProxy proxy;
    @Instance(ElectroMagicTools.modid)
    public static ElectroMagicTools instance;

    public static final String modid = "Electro-MagicTools";
    public static final String texturePath = "electromagictools";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLLog.info("[EMT] Electro-Magic Tools : Starting planning the world domination");

        FMLLog.info("[EMT] Electro-Magic Tools : Creating/Reading the config file");
        Config.config = new Configuration(event.getSuggestedConfigurationFile());
        Config.create();

        RegistryHandler.registerIc2Registrys();

        EssentiasOutputs.addPrimalOutputs();
        EssentiasOutputs.addOutputs();

        FMLLog.info("[EMT] Electro-Magic Tools : Planning complete");
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        FMLLog.info("[EMT] Electro-Magic Tools : Starting gathering allies");

        FMLLog.info("[EMT] Electro-Magic Tools : Loading the proxies");
        proxy.load();
        FMLLog.info("[EMT] Electro-Magic Tools : Making mobs drop additional items");
        MinecraftForge.EVENT_BUS.register(new EMTEventHandler());
        FMLLog.info("[EMT] Electro-Magic Tools : Generating loot in dungeon chests");
        DungeonChestGenerator.generateLoot();
        FMLLog.info("[EMT] Electro-Magic Tools : Adding the Init recipes");
        EMTInitRecipes.add();
        FMLLog.info("[EMT] Electro-Magic Tools : Registering entities");
        EMTEntityRegistry.registerEMTEntities();
        FMLLog.info("[EMT] Electro-Magic Tools : Registering the GUI Handler");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

        FMLLog.info("[EMT] Electro-Magic Tools : Allies gathered.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        FMLLog.info("[EMT] Electro-Magic Tools : Starting the world takeover");

        FMLLog.info("[EMT] Electro-Magic Tools : Adding PostInit recipes");
        EMTPostInitRecipes.add();
        FMLLog.info("[EMT] Electro-Magic Tools : Adding the UU-Matter Infusion recipes");
        UuMInfusionRecipes.add();

        RegistryHandler.registerIc2PostRegistrys();

        FMLLog.info("[EMT] Electro-Magic Tools : World takeover complete. Enjoy!");
    }

    @EventHandler
    public void onFMLServerStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandOutputs());
    }
}
