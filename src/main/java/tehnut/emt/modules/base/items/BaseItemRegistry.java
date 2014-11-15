package tehnut.emt.modules.base.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import tehnut.emt.ModInformation;
import tehnut.emt.modules.base.items.armor.ItemFeatherWing;
import tehnut.emt.modules.base.items.armor.ItemThaumiumWing;
import tehnut.emt.modules.base.items.foci.ItemChristmasFocus;
import tehnut.emt.modules.base.items.foci.ItemShieldFocus;
import tehnut.emt.modules.base.items.tools.ItemBaseToolComponents;
import tehnut.emt.modules.base.items.tools.ItemVanillaChainsaw;
import tehnut.emt.modules.base.items.tools.ItemVanillaDrill;
import tehnut.emt.modules.base.items.tools.ItemVanillaOmnitool;
import tehnut.emt.modules.base.items.tools.hammer.ItemThorHammer;
import tehnut.emt.modules.base.items.tools.hammer.ItemThorHammerBroken;
import thaumcraft.api.ThaumcraftApi;

public class BaseItemRegistry {

	// Materials
	// Armor
	public static ItemArmor.ArmorMaterial featherWingMaterial = EnumHelper.addArmorMaterial("FEATEHRWiNG", 1, new int[]{2, 2, 2, 2}, 6);

	// Tools
	public static Item.ToolMaterial copperMaterial = EnumHelper.addToolMaterial("copperToolMaterial", 2, 300, 6.0F, 2.0F, 14);
	public static Item.ToolMaterial tinMaterial = EnumHelper.addToolMaterial("tinToolMatierial", 2, 200, 8.0F, 4F, 18);
	public static Item.ToolMaterial leadMaterial = EnumHelper.addToolMaterial("leadToolMaterial", 2, 250, 7.0F, 3F, 15);
	public static Item.ToolMaterial bronzeMaterial = EnumHelper.addToolMaterial("bronzeToolMaterial", 2, 350, 7.0F, 3.0F, 16);

	// Items
	public static Item woodenDrill, stoneDrill, ironDrill, goldenDrill, diamondDrill, copperDrill, tinDrill, leadDrill, bronzeDrill;
	public static Item woodenChainsaw, stoneChainsaw, ironChainsaw, goldenChainsaw, diamondChainsaw, copperChainsaw, tinChainsaw, leadChainsaw, bronzeChainsaw;
	public static Item ironOmnitool, goldenOmnitool, diamondOmnitool, copperOmnitool, tinOmnitool, leadOmnitool, bronzeOmnitool;
	public static Item woodCarver, stoneCarver, ironCarver, obsidianCarver, diamondCarver;

	public static Item baseBaubles;

	public static Item materials;
	public static Item toolComponents;

	public static Item focusChristmas;
	public static Item focusShield;

	public static Item thorHammer;
	public static Item thorHammerBroken;

	public static Item wingFeather;
	public static Item wingThaumium;

	public static void registerItems() {

		baseBaubles = new ItemBaseBaubles();
		GameRegistry.registerItem(baseBaubles, "ItemBaseBaubles");

		materials = new ItemBaseMaterials();
		GameRegistry.registerItem(materials, "ItemBaseMaterials");
		toolComponents = new ItemBaseToolComponents();
		GameRegistry.registerItem(toolComponents, "ItemBaseToolComponents");

		focusChristmas = new ItemChristmasFocus();
		GameRegistry.registerItem(focusChristmas, "ItemFocusChristmas");
		focusShield = new ItemShieldFocus();
		GameRegistry.registerItem(focusShield, "ItemFocusShield");

		thorHammer = new ItemThorHammer();
		GameRegistry.registerItem(thorHammer, "ItemThorHammer");
		thorHammerBroken = new ItemThorHammerBroken();
		GameRegistry.registerItem(thorHammerBroken, "ItemThorHammerBroken");

		wingFeather = new ItemFeatherWing(featherWingMaterial);
		GameRegistry.registerItem(wingFeather, "ItemFeatherWing");
		wingThaumium = new ItemThaumiumWing(ThaumcraftApi.armorMatThaumium);
		GameRegistry.registerItem(wingThaumium, "ItemThaumiumWing");

		woodCarver = new ItemShardCarver(8).setUnlocalizedName(ModInformation.ID + ".module.base.carver.wood");
		GameRegistry.registerItem(woodCarver, "woodCarver");
		stoneCarver = new ItemShardCarver(32).setUnlocalizedName(ModInformation.ID + ".module.base.carver.stone");
		GameRegistry.registerItem(stoneCarver, "stoneCarver");
		ironCarver = new ItemShardCarver(128).setUnlocalizedName(ModInformation.ID + ".module.base.carver.iron");
		GameRegistry.registerItem(ironCarver, "ironCarver");
		obsidianCarver = new ItemShardCarver(256).setUnlocalizedName(ModInformation.ID + ".module.base.carver.obsidian");
		GameRegistry.registerItem(obsidianCarver, "obsidianCarver");
		diamondCarver = new ItemShardCarver(1204).setUnlocalizedName(ModInformation.ID + ".module.base.carver.diamond");
		GameRegistry.registerItem(diamondCarver, "diamondCarver");

		woodenDrill = new ItemVanillaDrill(Item.ToolMaterial.WOOD, 75, "drill_wood", new ItemStack(Item.getItemFromBlock(Blocks.planks))).setUnlocalizedName(ModInformation.ID + ".module.base.drill.wood");
		GameRegistry.registerItem(woodenDrill, "woodenDrill");
		stoneDrill = new ItemVanillaDrill(Item.ToolMaterial.STONE, 165, "drill_stone", new ItemStack(Item.getItemFromBlock(Blocks.cobblestone))).setUnlocalizedName(ModInformation.ID + ".module.base.drill.stone");
		GameRegistry.registerItem(stoneDrill, "stoneDrill");
		ironDrill = new ItemVanillaDrill(Item.ToolMaterial.IRON, 400, "drill_iron", new ItemStack(Items.iron_ingot)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.iron");
		GameRegistry.registerItem(ironDrill, "ironDrill");
		goldenDrill = new ItemVanillaDrill(Item.ToolMaterial.GOLD, 55, "drill_gold", new ItemStack(Items.gold_ingot)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.gold");
		GameRegistry.registerItem(goldenDrill, "goldenDrill");
		diamondDrill = new ItemVanillaDrill(Item.ToolMaterial.EMERALD, 2015, "drill_diamond", new ItemStack(Items.diamond)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.diamond");
		GameRegistry.registerItem(diamondDrill, "diamondDrill");
		copperDrill = new ItemVanillaDrill(copperMaterial, 450, "drill_copper", OreDictionary.getOres("ingotCopper").get(0)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.copper");
		GameRegistry.registerItem(copperDrill, "copperDrill");
		tinDrill = new ItemVanillaDrill(tinMaterial, 350, "drill_tin", OreDictionary.getOres("ingotTin").get(0)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.tin");
		GameRegistry.registerItem(tinDrill, "tinDrill");
		leadDrill = new ItemVanillaDrill(leadMaterial, 400, "drill_lead", OreDictionary.getOres("ingotLead").get(0)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.lead");
		GameRegistry.registerItem(leadDrill, "leadDrill");
		bronzeDrill = new ItemVanillaDrill(bronzeMaterial, 650, "drill_bronze", OreDictionary.getOres("ingotBronze").get(0)).setUnlocalizedName(ModInformation.ID + ".module.base.drill.bronze");
		GameRegistry.registerItem(bronzeDrill, "bronzeDrill");

		woodenChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.WOOD, 75, "chainsaw_wooden", Item.getItemFromBlock(Blocks.planks)).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.wood");
		GameRegistry.registerItem(woodenChainsaw, "woodenChainsaw");
		stoneChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.STONE, 165, "chainsaw_stone", Item.getItemFromBlock(Blocks.cobblestone)).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.stone");
		GameRegistry.registerItem(stoneChainsaw, "stoneChainsaw");
		ironChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.IRON, 315, "chainsaw_iron", Items.iron_ingot, 3F).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.iron");
		GameRegistry.registerItem(ironChainsaw, "ironChainsaw");
		goldenChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.GOLD, 55, "chainsaw_gold", Items.gold_ingot).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.gold");
		GameRegistry.registerItem(goldenChainsaw, "goldenChainsaw");
		diamondChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.EMERALD, 2015, "chainsaw_diamond", Items.diamond, 6F).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.diamond");
		GameRegistry.registerItem(diamondChainsaw, "diamondChainsaw");
		copperChainsaw = new ItemVanillaChainsaw(copperMaterial, 450, "chainsaw_copper", OreDictionary.getOres("ingotCopper").get(0).getItem(), 3F).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.copper");
		GameRegistry.registerItem(copperChainsaw, "copperChainsaw");
		tinChainsaw = new ItemVanillaChainsaw(tinMaterial, 350, "chainsaw_tin", OreDictionary.getOres("ingotTin").get(0).getItem(), 5F).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.tin");
		GameRegistry.registerItem(tinChainsaw, "tinChainsaw");
		leadChainsaw = new ItemVanillaChainsaw(leadMaterial, 400, "chainsaw_lead", OreDictionary.getOres("ingotLead").get(0).getItem(), 3.5F).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.lead");
		GameRegistry.registerItem(leadChainsaw, "leadChainsaw");
		bronzeChainsaw = new ItemVanillaChainsaw(bronzeMaterial, 650, "chainsaw_bronze", OreDictionary.getOres("ingotBronze").get(0).getItem(), 4F).setUnlocalizedName(ModInformation.ID + ".module.base.chainsaw.bronze");
		GameRegistry.registerItem(bronzeChainsaw, "bronzeChainsaw");

		ironOmnitool = new ItemVanillaOmnitool(Item.ToolMaterial.IRON, 500, "omnitool_iron", Items.iron_ingot).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.iron");
		GameRegistry.registerItem(ironOmnitool, "ironOmnitool");
		goldenOmnitool = new ItemVanillaOmnitool(Item.ToolMaterial.GOLD, 100, "omnitool_gold", Items.gold_ingot).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.gold");
		GameRegistry.registerItem(goldenOmnitool, "goldenOmnitool");
		diamondOmnitool = new ItemVanillaOmnitool(Item.ToolMaterial.EMERALD, 3900, "omnitool_diamond", Items.diamond).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.diamond");
		GameRegistry.registerItem(diamondOmnitool, "diamondOmnitool");
		copperOmnitool = new ItemVanillaOmnitool(copperMaterial, 850, "omnitool_copper", OreDictionary.getOres("ingotCopper").get(0).getItem()).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.copper");
		GameRegistry.registerItem(copperOmnitool, "copperOmnitool");
		tinOmnitool = new ItemVanillaOmnitool(tinMaterial, 640, "omnitool_tin", OreDictionary.getOres("ingotTin").get(0).getItem()).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.tin");
		GameRegistry.registerItem(tinOmnitool, "tinOmnitool");
		leadOmnitool = new ItemVanillaOmnitool(leadMaterial, 700, "omnitool_lead", OreDictionary.getOres("ingotLead").get(0).getItem()).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.lead");
		GameRegistry.registerItem(leadOmnitool, "leadOmnitool");
		bronzeOmnitool = new ItemVanillaOmnitool(bronzeMaterial, 950, "omnitool_bronze", OreDictionary.getOres("ingotBronze").get(0).getItem()).setUnlocalizedName(ModInformation.ID + ".module.base.omnitool.bronze");
		GameRegistry.registerItem(bronzeOmnitool, "bronzeOmnitool");
	}
}
