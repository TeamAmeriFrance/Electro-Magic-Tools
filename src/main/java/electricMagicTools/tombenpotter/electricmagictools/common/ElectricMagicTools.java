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
package electricMagicTools.tombenpotter.electricmagictools.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import electricMagicTools.tombenpotter.electricmagictools.client.CapeEventHandler;
import electricMagicTools.tombenpotter.electricmagictools.common.recipes.EMTInitRecipes;
import electricMagicTools.tombenpotter.electricmagictools.common.recipes.EMTPostInitRecipes;
import electricMagicTools.tombenpotter.electricmagictools.common.recipes.UuMInfusionRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = ElectricMagicTools.modid, name = "Electro-MagicTools", version = "1.2", guiFactory = "electricMagicTools.tombenpotter.electricmagictools.common.EMTGuiFactory",dependencies = "required-after:Thaumcraft ; required-after:IC2")
public class ElectricMagicTools {

    @SidedProxy(clientSide = "electricMagicTools.tombenpotter.electricmagictools.client.ClientProxy", serverSide = "electricMagicTools.tombenpotter.electricmagictools.common.CommonProxy")
    public static CommonProxy proxy;
    @Instance(ElectricMagicTools.modid)
    public static ElectricMagicTools instance;

    public static final String modid = "Electro-MagicTools";
    public static final String texturePath = "electricmagictools";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLLog.info("[EMT] Electro-Magic Tools : Starting planning the world domination");

        FMLLog.info("[EMT] Electro-Magic Tools : Creating/Reading the config file");
        Config.config = new Configuration(event.getSuggestedConfigurationFile());
        Config.create();
        FMLLog.info("[EMT] Electro-Magic Tools : Registering the mod items");
        ItemRegistry.registerEMTItems();
        FMLLog.info("[EMT] Electro-Magic Tools : Registering the mod blocks");
        BlockRegistry.registerEMTBlocks();

        FMLLog.info("[EMT] Electro-Magic Tools : Planning complete");
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        FMLLog.info("[EMT] Electro-Magic Tools : Starting gathering allies");

        FMLLog.info("[EMT] Electro-Magic Tools : Loading the proxies");
        proxy.load();

        FMLLog.info("[EMT] Electro-Magic Tools : Making mobs drop additional items");
        MinecraftForge.EVENT_BUS.register(new EMTEventHandler());
        FMLLog.info("[EMT] Electro-Magic Tools : Registering Tile entities");
        TileEntityRegistry.registerEMTTileEntites();
        FMLLog.info("[EMT] Electro-Magic Tools : Generating loot in dungeon chests");
        DungeonChestGenerator.generateLoot();
        FMLLog.info("[EMT] Electro-Magic Tools : Adding the Init recipes");
        EMTInitRecipes.add();
        FMLLog.info("[EMT] Electro-Magic Tools : Registering entities");
        EMTEntityRegistry.registerEMTEntities();
        FMLLog.info("[EMT] Electro-Magic Tools : Registering the GUI Handler");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
        if (event.getSide() == Side.CLIENT && Config.capesOn == true) {
            FMLLog.info("[EMT] Electro-Magic Tools : Adding capes");
            MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
        }

        FMLLog.info("[EMT] Electro-Magic Tools : Allies gathered.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        FMLLog.info("[EMT] Electro-Magic Tools : Starting the world takeover");

        FMLLog.info("[EMT] Electro-Magic Tools : Adding PostInit recipes");
        EMTPostInitRecipes.add();
        FMLLog.info("[EMT] Electro-Magic Tools : Adding the UU-Matter Infusion recipes");
        UuMInfusionRecipes.add();
        FMLLog.info("[EMT] Electro-Magic Tools : Adding the EMT research tab to the Thaumonomicon");
        ThaumonomiconResearch.addResearchTab();
        FMLLog.info("[EMT] Electro-Magic Tools : Adding research to the game");
        ThaumonomiconResearch.addResearch();

        FMLLog.info("[EMT] Electro-Magic Tools : World takeover complete. Enjoy!");
    }
}
