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

package tombenpotter.emt.common.modules.ic2;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.items.IC2ItemRegistry;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.CraftingAspects;
import tombenpotter.emt.common.util.TextHelper;

import java.util.Iterator;

public class IC2RecipeRegistry {

	public static ItemStack uuMCell = new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 16);

    private static void registerShapedRecipes() {

        /** Crafting Recipes **/
        ironOmnitool = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.ironOmnitool), "X", "Z", "Y", 'X', new ItemStack(IC2Items.getItem("chainsaw").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Y', new ItemStack(IC2Items.getItem("miningDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Z', IC2Items.getItem("plateiron"));
        diamondChainsaw = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.diamondChainsaw), " X ", "XYX", 'X', new ItemStack(Items.diamond), 'Y', new ItemStack(IC2Items.getItem("chainsaw").getItem(), 1, OreDictionary.WILDCARD_VALUE));
        ductTape = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 9), "XXX", "YYY", "XXX", 'X', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 8), 'Y', new ItemStack(Items.paper));
        featherMesh = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 7), "XYX", "YXY", "XYX", 'X', new ItemStack(Items.feather), 'Y', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 9));
        featherWing = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 12), "XYZ", "XYZ", "XYZ", 'X', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 7), 'Y', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 8), 'Z', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 11));
        featherWings = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.featherWing), "XX", 'X', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 12));
        taintedFeathers = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 14), " X ", "XYX", " X ", 'X', new ItemStack(ConfigItems.itemResource, 1, 12), 'Y', new ItemStack(Items.feather));

        if (!Loader.isModLoaded("gregtech_addon")) {
            GameRegistry.addShapedRecipe(IC2Items.getItem("diamondDrill"), " Y ", "YXY", 'Y', new ItemStack(Items.diamond), 'X', new ItemStack(IC2Items.getItem("miningDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE));
        } else {
            ElectroMagicTools.logger.info(TextHelper.localize("console.EMT.modLoaded.GT"));
        }

        GameRegistry.addRecipe(IC2Items.getItem("nanoHelmet"), "XYX", "XZX", 'X', IC2Items.getItem("carbonPlate"), 'Y', new ItemStack(IC2Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Z', new ItemStack(IC2Items.getItem("nightvisionGoggles").getItem(), 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapedRecipe(IC2Items.getItem("generator"), "X", "Y", "Z", 'X', new ItemStack(IC2Items.getItem("chargedReBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Y', IC2Items.getItem("machine"), 'Z', new ItemStack(Blocks.furnace));
        GameRegistry.addShapedRecipe(IC2Items.getItem("generator"), "X", "Y", "Z", 'X', IC2Items.getItem("reBattery"), 'Y', IC2Items.getItem("machine"), 'Z', new ItemStack(Blocks.furnace));

        /** OreDict Crafting Recipes **/
        for (int i = 0; i < OreDictionary.getOres("logWood").size(); i++) {
            cardboard = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 11), "XXX", "YYY", "XXX", 'X', new ItemStack(Items.paper), 'Y', OreDictionary.getOres("logWood").get(i));
        }
        for (int i = 0; i < OreDictionary.getOres("itemRubber").size(); i++) {
            rubberBall = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 10), "XX", "XX", 'X', OreDictionary.getOres("itemRubber").get(i));
        }

        /** Smelting Recipes **/
        GameRegistry.addSmelting(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 1), new ItemStack(ConfigItems.itemResource, 1, 6), 0.0F);
        GameRegistry.addSmelting(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 2), new ItemStack(ConfigItems.itemResource, 1, 6), 0.0F);
        GameRegistry.addSmelting(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 3), new ItemStack(ConfigItems.itemResource, 1, 3), 0.0F);
        GameRegistry.addSmelting(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 4), new ItemStack(ConfigItems.itemResource, 1, 3), 0.0F);
        GameRegistry.addSmelting(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 10), new ItemStack(IC2ItemRegistry.itemEMTItems, 2, 8), 0.0F);
    }

	private static void registerShaplessRecipes() {

	}

	private static void registerSmeltingRecipes() {

	}

	public static void registerEarlyRecipes() {
		registerShapedRecipes();
		registerShaplessRecipes();
		registerSmeltingRecipes();
	}

	public static void registerUUMInfusionRecipes() {

		ItemStack iridium = IC2Items.getItem("iridiumOre").copy();
		iridium.stackSize = 2;
		uraniumToIridium = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", iridium, 4, CraftingAspects.uuMatterInfusions, IC2Items.getItem("Uran238"), new ItemStack[]{uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell});

		ItemStack uranium = IC2Items.getItem("Uran238").copy();
		uranium.stackSize = 2;
		diamondToUranium = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", uranium, 4, CraftingAspects.lesserUUMInfusions, new ItemStack(Items.diamond), new ItemStack[]{uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell, uuMCell});

		ItemStack diamond = new ItemStack(Items.diamond).copy();
		diamond.stackSize = 1;
		goldToDiamond = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", diamond, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Items.gold_ingot), new ItemStack[]{uuMCell, uuMCell, uuMCell, uuMCell});

		ItemStack gold = new ItemStack(Items.gold_ingot).copy();
		gold.stackSize = 2;
		ironToGold = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", gold, 4, CraftingAspects.cheapestUUMInfusions, new ItemStack(Items.iron_ingot), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack ironOre = new ItemStack(Blocks.iron_ore).copy();
		ironOre.stackSize = 16;
		stoneBricksToIronOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", ironOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Blocks.stonebrick), new ItemStack[]{uuMCell, uuMCell});

		/**
		 * ItemStack copperOre = Items.getItem("copperOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack copperOre = IC2Items.getItem("crushedCopperOre").copy();
		copperOre.stackSize = 32;
		arcaneStoneToCopperOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", copperOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 6), new ItemStack[]{uuMCell, uuMCell});

		/**
		 * ItemStack tinOre = Items.getItem("tinOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack tinOre = IC2Items.getItem("crushedTinOre").copy();
		tinOre.stackSize = 32;
		arcaneStoneBricksToTinOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", tinOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 7), new ItemStack[]{uuMCell, uuMCell});

		/**
		 * ItemStack leadOre = Items.getItem("leadOre").copy(); BUGGED IN 1.6 IF IC2 OREGEN IS DISABLED
		 **/
		ItemStack leadOre = IC2Items.getItem("crushedLeadOre").copy();
		leadOre.stackSize = 32;
		amberBlockToLeadOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", leadOre, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticOpaque, 1, 0), new ItemStack[]{uuMCell, uuMCell});

		ItemStack uraniumOre = IC2Items.getItem("uraniumOre").copy();
		uraniumOre.stackSize = 8;
		amberBricksToUraniumOre = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", uraniumOre, 4, CraftingAspects.lesserUUMInfusions, new ItemStack(ConfigBlocks.blockCosmeticOpaque, 1, 1), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack coal = new ItemStack(Items.coal, 1, 0).copy();
		coal.stackSize = 16;
		charcoalToCoal = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", coal, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(Items.coal, 1, 1), new ItemStack[]{uuMCell, uuMCell});

		ItemStack stickyResin = IC2Items.getItem("resin").copy();
		stickyResin.stackSize = 21;
		shardToResin = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", stickyResin, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack redstone = new ItemStack(Items.redstone).copy();
		redstone.stackSize = 24;
		shardToRedstone = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", redstone, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack lapisLazuli = new ItemStack(Items.dye, 1, 4).copy();
		lapisLazuli.stackSize = 8;
		shardToLapis = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", lapisLazuli, 4, CraftingAspects.cheapUUMInfusions, new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{uuMCell, uuMCell, uuMCell});

		ItemStack glowstone = new ItemStack(Blocks.glowstone).copy();
		glowstone.stackSize = 1;
		glowstoneDustToBlock = ThaumcraftApi.addInfusionCraftingRecipe("UU-Matter Infusion", glowstone, 4, CraftingAspects.cheapestUUMInfusions, new ItemStack(Items.glowstone_dust), new ItemStack[]{uuMCell});
	}

	public static void registerLateRecipes() {
		/** Infusion Recipes **/

		thaumiumDrill = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Drill", new ItemStack(IC2ItemRegistry.thaumiumDrill), 5, CraftingAspects.thaumiumDrillCrafting, new ItemStack(IC2Items.getItem("diamondDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), IC2Items.getItem("denseplateiron")});

		thaumiumChainsaw = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Chainsaw", new ItemStack(IC2ItemRegistry.thaumiumChainsaw), 5, CraftingAspects.thaumiumChainsawCrafting, new ItemStack(IC2ItemRegistry.diamondChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), IC2Items.getItem("denseplateiron")});

		thaumicQuantumHelmet = ThaumcraftApi.addInfusionCraftingRecipe("Quantum Goggles of Revealing", new ItemStack(IC2ItemRegistry.quantumThaumicHelmet), 6, CraftingAspects.thaumicQuantumHelmetCrafting, new ItemStack(IC2ItemRegistry.nanoThaumicHelmet, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(Items.milk_bucket), new ItemStack(IC2Items.getItem("quantumHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), IC2Items.getItem("iridiumPlate"), IC2Items.getItem("advancedCircuit")});

		thaumicNanoHelmet = ThaumcraftApi.addInfusionCraftingRecipe("Nanosuit Goggles of Revealing", new ItemStack(IC2ItemRegistry.nanoThaumicHelmet), 5, CraftingAspects.thaumicNanoHelmetCrafting, new ItemStack(IC2ItemRegistry.electricGoggles, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(Items.gold_ingot), new ItemStack(IC2Items.getItem("nanoHelmet").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), IC2Items.getItem("carbonPlate"), IC2Items.getItem("electronicCircuit")});

		thaumiumOmnitool = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Omnitool", new ItemStack(IC2ItemRegistry.thaumiumOmnitool), 6, CraftingAspects.thaumiumOmnitoolCrafting, new ItemStack(IC2ItemRegistry.thaumiumChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(IC2ItemRegistry.thaumiumDrill, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), IC2Items.getItem("carbonPlate"), IC2Items.getItem("plateobsidian")});

		diamondOmnitoolToThaumium = ThaumcraftApi.addInfusionCraftingRecipe("Thaumium Omnitool", new ItemStack(IC2ItemRegistry.thaumiumOmnitool), 6, CraftingAspects.thaumiumOmnitoolCrafting, new ItemStack(IC2ItemRegistry.diamondOmnitool, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Blocks.diamond_block), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), new ItemStack(IC2Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("carbonPlate"), IC2Items.getItem("advancedCircuit")});

		explosionFocus = ThaumcraftApi.addInfusionCraftingRecipe("Explosion Focus", new ItemStack(IC2ItemRegistry.explosionFocus), 6, CraftingAspects.laserFocusCrafting, new ItemStack(ConfigItems.itemFocusHellbat, 1), new ItemStack[]{new ItemStack(IC2Items.getItem("miningLaser").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.arrow), new ItemStack(Items.gunpowder), new ItemStack(Items.firework_charge), new ItemStack(ConfigItems.itemResource, 1, 1)});

		shieldFocus = ThaumcraftApi.addInfusionCraftingRecipe("Shield Focus", new ItemStack(IC2ItemRegistry.shieldFocus), 4, CraftingAspects.shieldFocusCrafting, new ItemStack(ConfigItems.itemFocusPortableHole, 1), new ItemStack[]{IC2Items.getItem("reinforcedStone"), IC2Items.getItem("reinforcedGlass"), IC2Items.getItem("reinforcedStone"), IC2Items.getItem("reinforcedGlass"), new ItemStack(Blocks.soul_sand), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.obsidian)});

		potentiaGenerator = ThaumcraftApi.addInfusionCraftingRecipe("Potentia Generator", new ItemStack(IC2BlockRegistry.essentiaGens, 1, 0), 6, CraftingAspects.potentiaGeneratorCrafting, IC2Items.getItem("semifluidGenerator"), new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(ConfigItems.itemFocusTrade), new ItemStack(Blocks.hopper), new ItemStack(ConfigBlocks.blockJar), IC2Items.getItem("mvTransformer"), IC2Items.getItem("advancedMachine"), IC2Items.getItem("orewashingplant"), IC2Items.getItem("scrap")});

		streamChainsaw = ThaumcraftApi.addInfusionCraftingRecipe("Chainsaw of the Stream", new ItemStack(IC2ItemRegistry.streamChainsaw), 6, CraftingAspects.streamChaisnawCrafting, new ItemStack(IC2ItemRegistry.thaumiumChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.water_bucket), new ItemStack(ConfigItems.itemAxeElemental), new ItemStack(ConfigBlocks.blockMagicalLog), new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("iridiumPlate"), IC2Items.getItem("overclockerUpgrade")});

		rockbreakerDrill = ThaumcraftApi.addInfusionCraftingRecipe("Drill of the Rockbreaker", new ItemStack(IC2ItemRegistry.rockbreakerDrill), 6, CraftingAspects.rockbreakerDrillCrafting, new ItemStack(IC2ItemRegistry.thaumiumDrill, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.flint_and_steel), new ItemStack(Items.fire_charge), new ItemStack(ConfigItems.itemPickElemental), new ItemStack(ConfigItems.itemShovelElemental), new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("reinforcedStone"), IC2Items.getItem("iridiumPlate"), IC2Items.getItem("overclockerUpgrade")});

		thorHammer = ThaumcraftApi.addInfusionCraftingRecipe("Mjolnir", new ItemStack(IC2ItemRegistry.thorHammer), 7, CraftingAspects.thorHammerCrafting, new ItemStack(IC2ItemRegistry.taintedThorHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 6), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 6), new ItemStack(ConfigItems.itemSwordElemental), new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemFocusShock), IC2Items.getItem("rubber")});

		superchargedThorHammer = ThaumcraftApi.addInfusionCraftingRecipe("Supercharged Mjolnir", new ItemStack(IC2ItemRegistry.electricThorHammer), 10, CraftingAspects.superchargedThorHammerCrafting, new ItemStack(IC2ItemRegistry.thorHammer, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 6), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 6), new ItemStack(Blocks.web), new ItemStack(ConfigItems.itemFocusHellbat), new ItemStack(ConfigItems.itemSwordElemental), new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("iridiumPlate"), IC2Items.getItem("iridiumPlate"), new ItemStack(IC2Items.getItem("nanoSaber").getItem(), 1, OreDictionary.WILDCARD_VALUE)});

		wandRecharger = ThaumcraftApi.addInfusionCraftingRecipe("Industrial Wand Charging Station", new ItemStack(IC2BlockRegistry.emtMachines, 1, 0), 6, CraftingAspects.wandCharger, new ItemStack(ConfigBlocks.blockStoneDevice, 1, 5), new ItemStack[]{IC2Items.getItem("replicator"), IC2Items.getItem("iridiumPlate"), new ItemStack(Blocks.diamond_block), new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigBlocks.blockJar)});

		solarHelmetRevealing = ThaumcraftApi.addInfusionCraftingRecipe("Solar Helmet of Revealing", new ItemStack(IC2ItemRegistry.solarHelmetRevealing), 5, CraftingAspects.solarHelmetRevealing, new ItemStack(IC2ItemRegistry.quantumThaumicHelmet, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), IC2Items.getItem("glassFiberCableItem"), new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemShard, 1, 4)});

		electricBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe("Electric Boots of the Traveller", new ItemStack(IC2ItemRegistry.electricBootsTraveller), 2, CraftingAspects.electricBootsTravel, new ItemStack(ConfigItems.itemBootsTraveller), new ItemStack[]{new ItemStack(Items.diamond), IC2Items.getItem("elemotor"), IC2Items.getItem("coil"), IC2Items.getItem("hazmatBoots"), new ItemStack(IC2Items.getItem("advBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE)});

		nanoBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe("Nano Boots of the Traveller", new ItemStack(IC2ItemRegistry.nanoBootsTraveller), 2, CraftingAspects.nanoBootsTravel, new ItemStack(IC2ItemRegistry.electricBootsTraveller, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(IC2Items.getItem("nanoBoots").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE)});

		quantumBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe("Quantum Boots of the Traveller", new ItemStack(IC2ItemRegistry.quantumBootsTraveller), 2, CraftingAspects.quantumBootsTravel, new ItemStack(IC2ItemRegistry.nanoBootsTraveller, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{new ItemStack(Blocks.diamond_block), new ItemStack(IC2Items.getItem("quantumBoots").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("iridiumPlate")});

		etheralProcessor = ThaumcraftApi.addInfusionCraftingRecipe("Etheral Processor", new ItemStack(IC2BlockRegistry.emtMachines, 1, 1), 3, CraftingAspects.etherealProcessor, IC2Items.getItem("macerator"), new ItemStack[]{IC2Items.getItem("electroFurnace"), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 9), new ItemStack(Blocks.end_stone), new ItemStack(Blocks.end_stone), new ItemStack(Blocks.iron_block), new ItemStack(Blocks.iron_block), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5)});

		tripleCompressedSolar = ThaumcraftApi.addInfusionCraftingRecipe("Compressed Solars", new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), 2, CraftingAspects.compressedSolars, new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack[]{new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1)});

		electricHoeGrowth = ThaumcraftApi.addInfusionCraftingRecipe("Electric Hoe of Growth", new ItemStack(IC2ItemRegistry.electricHoeGrowth), 4, CraftingAspects.electricHoeGrowth, new ItemStack(ConfigItems.itemHoeElemental), new ItemStack[]{new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2Items.getItem("electricHoe").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.dye, 1, 15), IC2Items.getItem("elemotor"), IC2Items.getItem("coil"), new ItemStack(Blocks.sapling, 1, OreDictionary.WILDCARD_VALUE)});

		chargeFocus = ThaumcraftApi.addInfusionCraftingRecipe("Wand Focus: Charging", new ItemStack(IC2ItemRegistry.chargeFocus), 4, CraftingAspects.chargeFocus, new ItemStack(IC2Items.getItem("advBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{IC2Items.getItem("generator"), IC2Items.getItem("batBox"), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE)});

		wandChargeFocus = ThaumcraftApi.addInfusionCraftingRecipe("Wand Focus: Wand Charging", new ItemStack(IC2ItemRegistry.wandChargeFocus), 5, CraftingAspects.wandChargeFocus, new ItemStack(IC2BlockRegistry.emtMachines, 1, 0), new ItemStack[]{new ItemStack(IC2ItemRegistry.chargeFocus), new ItemStack(IC2Items.getItem("energyPack").getItem(), 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("iridiumPlate"), IC2Items.getItem("iridiumPlate")});

		inventoryChargingRing = ThaumcraftApi.addInfusionCraftingRecipe("Inventory Charging Ring", new ItemStack(IC2ItemRegistry.emtBauble, 1, 1), 6, CraftingAspects.inventoryChargingRing, new ItemStack(ConfigItems.itemBaubleBlanks, 1, 1), new ItemStack[]{new ItemStack(IC2ItemRegistry.thaumiumDrill, 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("generator"), IC2Items.getItem("geothermalGenerator"), IC2Items.getItem("waterMill"), IC2Items.getItem("solarPanel"), IC2Items.getItem("windMill"), IC2Items.getItem("nuclearReactor")});

		armorChargingRing = ThaumcraftApi.addInfusionCraftingRecipe("Armor Charging Ring", new ItemStack(IC2ItemRegistry.emtBauble, 1, 0), 6, CraftingAspects.armorChargingRing, new ItemStack(ConfigItems.itemBaubleBlanks, 1, 1), new ItemStack[]{new ItemStack(IC2ItemRegistry.electricBootsTraveller, 1, OreDictionary.WILDCARD_VALUE), IC2Items.getItem("generator"), IC2Items.getItem("geothermalGenerator"), IC2Items.getItem("waterMill"), IC2Items.getItem("solarPanel"), IC2Items.getItem("windMill"), IC2Items.getItem("nuclearReactor")});

		nanoWings = ThaumcraftApi.addInfusionCraftingRecipe("Nanosuit Wings", new ItemStack(IC2ItemRegistry.nanoWing), 4, CraftingAspects.nanoWing, new ItemStack(IC2ItemRegistry.thaumiumWing), new ItemStack[]{IC2Items.getItem("carbonPlate"), IC2Items.getItem("carbonPlate"), IC2Items.getItem("carbonPlate"), new ItemStack(IC2Items.getItem("nanoBodyarmor").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemResource, 1, 1)});

		quantumWings = ThaumcraftApi.addInfusionCraftingRecipe("Quantum Wings", new ItemStack(IC2ItemRegistry.quantumWing), 6, CraftingAspects.quantumWing, new ItemStack(IC2ItemRegistry.nanoWing, 1, OreDictionary.WILDCARD_VALUE), new ItemStack[]{IC2Items.getItem("iridiumPlate"), IC2Items.getItem("iridiumPlate"), IC2Items.getItem("iridiumPlate"), new ItemStack(IC2Items.getItem("quantumBodyarmor").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ConfigItems.itemResource, 1, 1)});

		/** Arcane Worktable Recipes **/

		diamondOmnitool = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Diamond Omnitool", new ItemStack(IC2ItemRegistry.diamondOmnitool), CraftingAspects.diamondOmnitoolCrafting, new ItemStack(IC2ItemRegistry.diamondChainsaw, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(IC2Items.getItem("diamondDrill").getItem(), 1, OreDictionary.WILDCARD_VALUE));

		ironOmnitoolToDiamond = ThaumcraftApi.addArcaneCraftingRecipe("Diamond Omnitool", new ItemStack(IC2ItemRegistry.diamondOmnitool), CraftingAspects.diamondOmnitoolCrafting, "XAX", "XBX", "XAX", 'X', new ItemStack(Items.diamond), 'A', IC2Items.getItem("advancedCircuit"), 'B', new ItemStack(IC2ItemRegistry.ironOmnitool, 1, OreDictionary.WILDCARD_VALUE));

		christmasFocus = ThaumcraftApi.addArcaneCraftingRecipe("Kris-tmas Focus", new ItemStack(IC2ItemRegistry.christmasFocus), CraftingAspects.christmasFocusCrafting, "XYX", "YZY", "XYX", 'X', new ItemStack(Blocks.snow), 'Y', new ItemStack(Blocks.pumpkin), 'Z', new ItemStack(ConfigItems.itemFocusFrost));

		electricGoggles = ThaumcraftApi.addArcaneCraftingRecipe("Electric Goggles", new ItemStack(IC2ItemRegistry.electricGoggles), CraftingAspects.electricGogglesCrafting, " Y ", "AZA", "BXB", 'Z', new ItemStack(ConfigItems.itemGoggles), 'X', IC2Items.getItem("electronicCircuit"), 'Y', new ItemStack(Items.diamond_helmet), 'A', new ItemStack(IC2Items.getItem("chargedReBattery").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'B', Items.repeater);

		shieldBlock = ThaumcraftApi.addArcaneCraftingRecipe("Shield Blocks", new ItemStack(IC2BlockRegistry.shield, 8), CraftingAspects.shieldBlockCrafting, "XYX", "X X", "XYX", 'X', new ItemStack(Blocks.glass), 'Y', new ItemStack(Blocks.obsidian));

		tinyUranium = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Tiny Uranium", new ItemStack(IC2Items.getItem("smallUran235").getItem(), 7), CraftingAspects.tinyUraniumCrafting, IC2Items.getItem("Uran238"));

		compressedSolar = ThaumcraftApi.addArcaneCraftingRecipe("Compressed Solars", new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.compressedSolars, "XXX", "XXX", "XXX", 'X', IC2Items.getItem("solarPanel"));

		doubleCompressedSolar = ThaumcraftApi.addArcaneCraftingRecipe("Compressed Solars", new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.compressedSolars, "XXX", "XXX", "XXX", 'X', new ItemStack(IC2BlockRegistry.emtSolars, 1, 0));

		electricScribingTools = ThaumcraftApi.addArcaneCraftingRecipe("Electric Scribing Tools", new ItemStack(IC2ItemRegistry.electricScribingTools), CraftingAspects.electricScribingTools, "YXY", "XZX", "YXY", 'Y', IC2Items.getItem("electronicCircuit"), 'X', new ItemStack(ConfigItems.itemInkwell), 'Z', new ItemStack(IC2Items.getItem("energyCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE));

		thaumiumWing = ThaumcraftApi.addArcaneCraftingRecipe("Thaumium Reinforced Wings", new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 15), CraftingAspects.thaumiumWing, "XYZ", "XYZ", "XYZ", 'X', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 14), 'Y', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), 'Z', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 13));

		thaumiumWings = ThaumcraftApi.addArcaneCraftingRecipe("Thaumium Reinforced Wings", new ItemStack(IC2ItemRegistry.thaumiumWing), CraftingAspects.thaumiumWing, "XX", 'X', new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 15));

		/** Crucible Recipes **/

		ignisGenerator = ThaumcraftApi.addCrucibleRecipe("Ignis Generator", new ItemStack(IC2BlockRegistry.essentiaGens, 1, 1), new ItemStack(IC2BlockRegistry.essentiaGens, 1, 0), CraftingAspects.ignisGeneratorCrafting);

		auramGenerator = ThaumcraftApi.addCrucibleRecipe("Auram Generator", new ItemStack(IC2BlockRegistry.essentiaGens, 1, 2), new ItemStack(IC2BlockRegistry.essentiaGens, 1, 0), CraftingAspects.auramGeneratorCrafting);

		arborGenerator = ThaumcraftApi.addCrucibleRecipe("Arbor Generator", new ItemStack(IC2BlockRegistry.essentiaGens, 1, 3), new ItemStack(IC2BlockRegistry.essentiaGens, 1, 0), CraftingAspects.arborGeneratorCrafting);

		aerGenerator = ThaumcraftApi.addCrucibleRecipe("Aer Generator", new ItemStack(IC2BlockRegistry.essentiaGens, 1, 4), new ItemStack(IC2BlockRegistry.essentiaGens, 1, 0), CraftingAspects.aerGenerator);

		waterSolar = ThaumcraftApi.addCrucibleRecipe("Water Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 3), new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.waterSolars);

		doubleWaterSolar = ThaumcraftApi.addCrucibleRecipe("Water Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 4), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.waterSolars);

		tripleWaterSolar = ThaumcraftApi.addCrucibleRecipe("Water Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 5), new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), CraftingAspects.waterSolars);

		darkSolar = ThaumcraftApi.addCrucibleRecipe("Entropy Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 6), new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.darkSolars);

		doubleDarkSolar = ThaumcraftApi.addCrucibleRecipe("Entropy Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 7), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.darkSolars);

		tripleDarkSolar = ThaumcraftApi.addCrucibleRecipe("Entropy Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 8), new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), CraftingAspects.darkSolars);

		orderSolar = ThaumcraftApi.addCrucibleRecipe("Order Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 9), new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.orderSolars);

		doubleOrderSolar = ThaumcraftApi.addCrucibleRecipe("Order Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 10), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.orderSolars);

		tripleOrderSolar = ThaumcraftApi.addCrucibleRecipe("Order Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 11), new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), CraftingAspects.orderSolars);

		fireSolar = ThaumcraftApi.addCrucibleRecipe("Fire Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 12), new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.fireSolars);

		doubleFireSolar = ThaumcraftApi.addCrucibleRecipe("Fire Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 13), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.fireSolars);

		tripleFireSolar = ThaumcraftApi.addCrucibleRecipe("Fire Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 14), new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), CraftingAspects.fireSolars);

		airSolar = ThaumcraftApi.addCrucibleRecipe("Air Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars, 1, 15), new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.airSolars);

		doubleAirSolar = ThaumcraftApi.addCrucibleRecipe("Air Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars2, 1, 0), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.airSolars);

		tripleAirSolar = ThaumcraftApi.addCrucibleRecipe("Air Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars2, 1, 1), new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), CraftingAspects.airSolars);

		earthSolar = ThaumcraftApi.addCrucibleRecipe("Earth Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars2, 1, 2), new ItemStack(IC2BlockRegistry.emtSolars, 1, 0), CraftingAspects.earthSolars);

		doubleEarthSolar = ThaumcraftApi.addCrucibleRecipe("Earth Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars2, 1, 3), new ItemStack(IC2BlockRegistry.emtSolars, 1, 1), CraftingAspects.earthSolars);

		tripleEarthSolar = ThaumcraftApi.addCrucibleRecipe("Earth Infused Solar Panels", new ItemStack(IC2BlockRegistry.emtSolars2, 1, 4), new ItemStack(IC2BlockRegistry.emtSolars, 1, 2), CraftingAspects.earthSolars);

		portableNode = ThaumcraftApi.addCrucibleRecipe("Portable Node", new ItemStack(IC2BlockRegistry.portableNode), new ItemStack(ConfigItems.itemJarFilled), CraftingAspects.portableNode);

		/** IC2 Stuff related recipes **/

		/* Ore Clusters Macerator Recipes */
		ItemStack ironClusterRecipe = IC2Items.getItem("smallIronDust").copy();
		ironClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 16)), null, ironClusterRecipe);

		ItemStack goldClusterRecipe = IC2Items.getItem("smallGoldDust").copy();
		goldClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 31)), null, goldClusterRecipe);

		ItemStack copperClusterRecipe = IC2Items.getItem("smallCopperDust").copy();
		copperClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 17)), null, copperClusterRecipe);

		ItemStack tinClusterRecipe = IC2Items.getItem("smallTinDust").copy();
		tinClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 18)), null, tinClusterRecipe);

		ItemStack silverClusterRecipe = IC2Items.getItem("smallSilverDust").copy();
		silverClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 19)), null, silverClusterRecipe);

		ItemStack leadClusterRecipe = IC2Items.getItem("smallLeadDust").copy();
		leadClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemNugget, 1, 20)), null, leadClusterRecipe);

		/* Thaumium Plates Recipes */
		thaumiumPlate = GameRegistry.addShapedRecipe(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5), "X", "Y", "Z", 'Y', new ItemStack(ConfigItems.itemResource, 1, 2), 'X', new ItemStack(IC2Items.getItem("ForgeHammer").getItem(), 1, OreDictionary.WILDCARD_VALUE), 'Z', new ItemStack(Blocks.obsidian));
		Recipes.metalformerRolling.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigItems.itemResource, 1, 2)), null, new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 5));

		/* Iron Sheet Recipe */
		Recipes.metalformerRolling.addRecipe(new RecipeInputItemStack(IC2Items.getItem("denseplateiron")), null, new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 13));

		/* Ore Processing for Amber and Cinnabar */
		if (ConfigHandler.removeAmberAndCinnabarMacerating) {
			for (Iterator<IRecipeInput> it = Recipes.macerator.getRecipes().keySet().iterator(); it.hasNext(); ) {
				IRecipeInput input = it.next();
				if (input.matches(new ItemStack(ConfigBlocks.blockCustomOre, 1, 7))) {
					it.remove();
					ElectroMagicTools.logger.info(TextHelper.localize("console.EMT.recipes.amberConflict"));
				}
			}

			for (Iterator<IRecipeInput> it = Recipes.macerator.getRecipes().keySet().iterator(); it.hasNext(); ) {
				IRecipeInput input = it.next();
				if (input.matches(new ItemStack(ConfigBlocks.blockCustomOre, 1, 0))) {
					it.remove();
					ElectroMagicTools.logger.info(TextHelper.localize("console.EMT.recipes.cinnabarConflict"));
				}
			}
		}
		ItemStack crushedAmberRecipe = new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 1);
		crushedAmberRecipe.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigBlocks.blockCustomOre, 1, 7)), null, crushedAmberRecipe);

		ItemStack crushedCinnabarRecipe = new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 3);
		crushedCinnabarRecipe.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ConfigBlocks.blockCustomOre, 1, 0)), null, crushedCinnabarRecipe);

		NBTTagCompound waterAmount = new NBTTagCompound();
		waterAmount.setInteger("amount", 1000);

		ItemStack smallCopperDust = IC2Items.getItem("smallCopperDust");
		smallCopperDust.stackSize = 2;
		ItemStack smallTinDust = IC2Items.getItem("smallTinDust");
		smallCopperDust.stackSize = 2;

		Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 1)), waterAmount, new ItemStack[]{new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 2), smallCopperDust, IC2Items.getItem("stoneDust")});
		Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 3)), waterAmount, new ItemStack[]{new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 4), smallTinDust, IC2Items.getItem("stoneDust")});

		NBTTagCompound heatAmount = new NBTTagCompound();
		heatAmount.setInteger("minHeat", 1000);

		Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 2)), heatAmount, new ItemStack[]{IC2Items.getItem("smallCopperDust"), new ItemStack(ConfigItems.itemResource, 1, 6)});
		Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(IC2ItemRegistry.itemEMTItems, 1, 4)), heatAmount, new ItemStack[]{IC2Items.getItem("smallTinDust"), new ItemStack(ConfigItems.itemResource, 1, 3)});

	}

    public static IRecipe ironOmnitool;
    public static IRecipe diamondChainsaw;
    public static IRecipe ductTape;
    public static IRecipe rubberBall;
    public static IRecipe featherMesh;
    public static IRecipe cardboard;
    public static IRecipe featherWing;
    public static IRecipe featherWings;
    public static IRecipe taintedFeathers;

	public static InfusionRecipe uraniumToIridium;
	public static InfusionRecipe diamondToUranium;
	public static InfusionRecipe goldToDiamond;
	public static InfusionRecipe ironToGold;
	public static InfusionRecipe stoneBricksToIronOre;
	public static InfusionRecipe arcaneStoneToCopperOre;
	public static InfusionRecipe arcaneStoneBricksToTinOre;
	public static InfusionRecipe amberBlockToLeadOre;
	public static InfusionRecipe amberBricksToUraniumOre;
	public static InfusionRecipe charcoalToCoal;
	public static InfusionRecipe shardToResin;
	public static InfusionRecipe shardToRedstone;
	public static InfusionRecipe shardToLapis;
	public static InfusionRecipe glowstoneDustToBlock;

	public static InfusionRecipe thaumiumDrill;
	public static InfusionRecipe thaumiumChainsaw;
	public static InfusionRecipe thaumicQuantumHelmet;
	public static InfusionRecipe thaumiumOmnitool;
	public static InfusionRecipe thaumicNanoHelmet;
	public static InfusionRecipe explosionFocus;
	public static InfusionRecipe shieldFocus;
	public static InfusionRecipe potentiaGenerator;
	public static InfusionRecipe streamChainsaw;
	public static InfusionRecipe rockbreakerDrill;
	public static InfusionRecipe thorHammer;
	public static InfusionRecipe superchargedThorHammer;
	public static InfusionRecipe wandRecharger;
	public static InfusionRecipe solarHelmetRevealing;
	public static InfusionRecipe electricBootsTravel;
	public static InfusionRecipe nanoBootsTravel;
	public static InfusionRecipe quantumBootsTravel;
	public static InfusionRecipe diamondOmnitoolToThaumium;
	public static InfusionRecipe etheralProcessor;
	public static InfusionRecipe tripleCompressedSolar;
	public static InfusionRecipe electricHoeGrowth;
	public static InfusionRecipe chargeFocus;
	public static InfusionRecipe wandChargeFocus;
	public static InfusionRecipe inventoryChargingRing;
	public static InfusionRecipe armorChargingRing;
	public static InfusionRecipe nanoWings;
	public static InfusionRecipe quantumWings;

	public static ShapelessArcaneRecipe diamondOmnitool;
	public static ShapelessArcaneRecipe tinyUranium;
	public static ShapedArcaneRecipe christmasFocus;
	public static ShapedArcaneRecipe electricGoggles;
	public static ShapedArcaneRecipe shieldBlock;
	public static ShapedArcaneRecipe compressedSolar;
	public static ShapedArcaneRecipe doubleCompressedSolar;
	public static ShapedArcaneRecipe ironOmnitoolToDiamond;
	public static ShapedArcaneRecipe electricScribingTools;
	public static ShapedArcaneRecipe thaumiumWing;
	public static ShapedArcaneRecipe thaumiumWings;

	public static CrucibleRecipe ignisGenerator;
	public static CrucibleRecipe auramGenerator;
	public static CrucibleRecipe arborGenerator;
	public static CrucibleRecipe aerGenerator;
	public static CrucibleRecipe waterSolar;
	public static CrucibleRecipe doubleWaterSolar;
	public static CrucibleRecipe tripleWaterSolar;
	public static CrucibleRecipe darkSolar;
	public static CrucibleRecipe doubleDarkSolar;
	public static CrucibleRecipe tripleDarkSolar;
	public static CrucibleRecipe orderSolar;
	public static CrucibleRecipe doubleOrderSolar;
	public static CrucibleRecipe tripleOrderSolar;
	public static CrucibleRecipe fireSolar;
	public static CrucibleRecipe doubleFireSolar;
	public static CrucibleRecipe tripleFireSolar;
	public static CrucibleRecipe airSolar;
	public static CrucibleRecipe doubleAirSolar;
	public static CrucibleRecipe tripleAirSolar;
	public static CrucibleRecipe earthSolar;
	public static CrucibleRecipe doubleEarthSolar;
	public static CrucibleRecipe tripleEarthSolar;
	public static CrucibleRecipe portableNode;

	public static IRecipe thaumiumPlate;
}
