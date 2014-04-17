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

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
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

@Mod(modid = ElectricMagicTools.modid, name = "Electro-MagicTools", version = "1.1.0", dependencies = "required-after:Thaumcraft ; required-after:IC2")
public class ElectricMagicTools {

	@SidedProxy(clientSide = "electricMagicTools.tombenpotter.electricmagictools.client.ClientProxy", serverSide = "electricMagicTools.tombenpotter.electricmagictools.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance(ElectricMagicTools.modid)
	public static ElectricMagicTools instance;

	public static final String modid = "Electro-MagicTools";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		/** Creating the config file **/
		Config.create(event);

		/** Items Registry **/
		ItemRegistry.registerEMTItems();

		/** Blocks registry **/
		BlockRegistry.registerEMTBlocks();

		System.out.println("[EMT] Electro-Magic Tools : Successful PreInit");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		/** Loading the proxies **/
		proxy.load();

		/** Making mobs drop additional items **/
		MinecraftForge.EVENT_BUS.register(new EMTEventHandler());

		/** Tile entities registry **/
		TileEntityRegistry.registerEMTTileEntites();

		/** Generating in dungeon chests **/
		if (Config.thorHammerResearch == false) {
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemRegistry.taintedThorHammer), 1, 1, 5));
		}
		if (Config.oneRingSpawn == false) {
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemRegistry.emtBauble, 1, 2), 1, 1, 3));
		}

		/** Adding the recipes that go in Init **/
		EMTInitRecipes.add();

		/** Entities Registry **/
		EMTEntityRegistry.registerEMTEntities();

		/** GUI Handler Registry **/
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

		/** Adds Capes **/
		if (event.getSide() == Side.CLIENT && Config.capesOn == true) {
			MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
		}

		System.out.println("[EMT] Electro-Magic Tools : Successful Init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		/** Adding the recipes that go in PostInit **/
		EMTPostInitRecipes.add();

		/** Adding the UU-Matter Infusion recipes **/
		UuMInfusionRecipes.add();

		/** Adding the EMT research tab to the Thaumonomicon **/
		ThaumonomiconResearch.addResearchTab();

		/** Adding the actual research to the game **/
		ThaumonomiconResearch.addResearch();

		System.out.println("[EMT] Electro-Magic Tools : Successful PostInit");
	}
}
