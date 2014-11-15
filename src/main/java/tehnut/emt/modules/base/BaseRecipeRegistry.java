package tehnut.emt.modules.base;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import tehnut.emt.modules.base.items.BaseItemRegistry;
import tehnut.emt.modules.base.items.BaseItemStacks;

public class BaseRecipeRegistry {

	public static IRecipe woodenDrill, stoneDrill, ironDrill, goldenDrill, diamondDrill, copperDrill, tinDrill, leadDrill, bronzeDrill;
	public static IRecipe woodenChainsaw, stoneChainsaw, ironChainsaw, goldenChainsaw, diamondChainsaw, copperChainsaw, tinChainsaw, leadChainsaw, bronzeChainsaw;
	public static IRecipe ironOmnitool, goldenOmnitool, diamondOmnitool, copperOmnitool, tinOmnitool, leadOmnitool, bronzeOmnitool;
	public static IRecipe woodenDrillTop, stoneDrillTop, ironDrillTop, goldenDrillTop, diamondDrillTop, copperDrillTop, tinDrillTop, leadDrillTop, bronzeDrillTop;
	public static IRecipe woodenChainsawTop, stoneChainsawTop, ironChainsawTop, goldenChainsawTop, diamondChainsawTop, copperChainsawTop, tinChainsawTop, leadChainsawTop, bronzeChainsawTop;
	public static IRecipe woodenCarver, stoneCarver, ironCarver, obsidianCarver, diamondCarver;

	public static void registerBaseRecipes() {
		registerShapedRecipes();
		registerShaplessRecipes();
		addChainsawRecipes();
		addChainsawTopRecipes();
		addDrillRecipes();
		addDrillTopRecipes();
		addCarversRecipes();
		addShardsRecipes();
	}

	private static void registerShapedRecipes() {

	}

	private static void registerShaplessRecipes() {

	}

	private static void addDrillTopRecipes() {
		woodenDrillTop = drillTopRecipe(BaseItemStacks.woodenDrillTop, "plankWood", BaseItemStacks.woodenShard);
		stoneDrillTop = drillTopRecipe(BaseItemStacks.stoneDrillTop, "stone", BaseItemStacks.stoneShard);
		ironDrillTop = drillTopRecipe(BaseItemStacks.ironDrillTop, "ingotIron", BaseItemStacks.ironShard);
		goldenDrillTop = drillTopRecipe(BaseItemStacks.goldenDrillTop, "ingotGold", BaseItemStacks.goldenShard);
		diamondDrillTop = drillTopRecipe(BaseItemStacks.diamondDrillTop, "gemDiamond", BaseItemStacks.obsidianShard);

		if (isOreRegistered("ingotCopper"))
			copperDrillTop = drillTopRecipe(BaseItemStacks.copperDrillTop, "ingotCopper", BaseItemStacks.copperShard);
		if (isOreRegistered("ingotTin"))
			tinDrillTop = drillTopRecipe(BaseItemStacks.tinDrillTop, "ingotTin", BaseItemStacks.tinShard);
		if (isOreRegistered("ingotLead"))
			leadDrillTop = drillTopRecipe(BaseItemStacks.leadDrillTop, "ingotLead", BaseItemStacks.leadShard);
		if (isOreRegistered("ingotBronze"))
			bronzeDrillTop = drillTopRecipe(BaseItemStacks.bronzeDrillTop, "ingotBronze", BaseItemStacks.bronzeShard);
	}

	private static void addChainsawTopRecipes() {
		woodenChainsawTop = chainsawTopRecipe(BaseItemStacks.woodenChainsawTop, "plankWood", BaseItemStacks.woodenShard);
		stoneChainsawTop = chainsawTopRecipe(BaseItemStacks.stoneChainsawTop, "stone", BaseItemStacks.stoneShard);
		ironChainsawTop = chainsawTopRecipe(BaseItemStacks.ironChainsawTop, "ingotIron", BaseItemStacks.ironShard);
		goldenChainsawTop = chainsawTopRecipe(BaseItemStacks.goldenChainsawTop, "ingotGold", BaseItemStacks.goldenShard);
		diamondChainsawTop = chainsawTopRecipe(BaseItemStacks.diamondChainsawTop, "gemDiamond", BaseItemStacks.obsidianShard);

		if (isOreRegistered("ingotCopper"))
			copperChainsawTop = chainsawTopRecipe(BaseItemStacks.copperChainsawTop, "ingotCopper", BaseItemStacks.copperShard);
		if (isOreRegistered("ingotTin"))
			tinChainsawTop = chainsawTopRecipe(BaseItemStacks.tinChainsawTop, "ingotTin", BaseItemStacks.tinShard);
		if (isOreRegistered("ingotLead"))
			leadChainsawTop = chainsawTopRecipe(BaseItemStacks.leadChainsawTop, "ingotLead", BaseItemStacks.leadShard);
		if (isOreRegistered("ingotBronze"))
			bronzeChainsawTop = chainsawTopRecipe(BaseItemStacks.bronzeChainsawTop, "ingotBronze", BaseItemStacks.bronzeShard);
	}

	private static void addDrillRecipes() {
		woodenDrill = toolRecipe(BaseItemStacks.woodenDrill, BaseItemStacks.woodenDrillTop, "plankWood", "stickWood");
		stoneDrill = toolRecipe(BaseItemStacks.stoneDrill, BaseItemStacks.stoneDrillTop, "stone", "cobblestone");
		ironDrill = toolRecipe(BaseItemStacks.ironDrill, BaseItemStacks.ironDrillTop, "ingotIron", new ItemStack(Items.leather));
		goldenDrill = toolRecipe(BaseItemStacks.goldenDrill, BaseItemStacks.goldenDrillTop, "ingotGold", new ItemStack(Blocks.obsidian));
		diamondDrill = toolRecipe(BaseItemStacks.diamondDrill, BaseItemStacks.diamondDrillTop, "gemDiamond", "ingotGold");

		if (isOreRegistered("ingotCopper") && isOreRegistered("ingotTin"))
			copperDrill = toolRecipe(BaseItemStacks.copperDrill, BaseItemStacks.copperDrillTop, "ingotCopper", "ingotTin");
		if (isOreRegistered("ingotTin"))
			tinDrill = toolRecipe(BaseItemStacks.tinDrill, BaseItemStacks.tinDrillTop, "ingotTin", "ingotGold");
		if (isOreRegistered("ingotLead"))
			leadDrill = toolRecipe(BaseItemStacks.leadDrill, BaseItemStacks.leadDrillTop, "ingotLead", "ingotIron");
		if (isOreRegistered("ingotBronze"))
			bronzeDrill = toolRecipe(BaseItemStacks.bronzeDrill, BaseItemStacks.bronzeDrillTop, "ingotBronze", new ItemStack(Blocks.obsidian));
	}

	private static void addChainsawRecipes() {
		woodenChainsaw = toolRecipe(BaseItemStacks.woodenChainsaw, BaseItemStacks.woodenChainsawTop, "plankWood", "stickWood");
		stoneChainsaw = toolRecipe(BaseItemStacks.stoneChainsaw, BaseItemStacks.stoneChainsawTop, "stone", "cobblestone");
		ironChainsaw = toolRecipe(BaseItemStacks.ironChainsaw, BaseItemStacks.ironChainsawTop, "ingotIron", new ItemStack(Items.leather));
		goldenChainsaw = toolRecipe(BaseItemStacks.goldenChainsaw, BaseItemStacks.goldenChainsawTop, "ingotGold", new ItemStack(Blocks.obsidian));
		diamondChainsaw = toolRecipe(BaseItemStacks.diamondChainsaw, BaseItemStacks.diamondChainsawTop, "gemDiamond", "ingotGold");

		if (isOreRegistered("ingotCopper") && isOreRegistered("ingotTin"))
			copperChainsaw = toolRecipe(BaseItemStacks.copperChainsaw, BaseItemStacks.copperChainsawTop, "ingotCopper", "ingotTin");
		if (isOreRegistered("ingotTin"))
			tinChainsaw = toolRecipe(BaseItemStacks.tinChainsaw, BaseItemStacks.tinChainsawTop, "ingotTin", "ingotGold");
		if (isOreRegistered("ingotLead"))
			leadChainsaw = toolRecipe(BaseItemStacks.leadChainsaw, BaseItemStacks.leadChainsawTop, "ingotLead", "ingotIron");
		if (isOreRegistered("ingotBronze"))
			bronzeChainsaw = toolRecipe(BaseItemStacks.bronzeChainsaw, BaseItemStacks.bronzeChainsawTop, "ingotBronze", new ItemStack(Blocks.obsidian));
	}

	private static void addCarversRecipes() {
		for (int i = 0; i < OreDictionary.getOres("logWood").size(); i++) {
			woodenCarver = GameRegistry.addShapedRecipe(BaseItemStacks.woodenCarver, " X ", "YYY", 'X', Items.flint, 'Y', OreDictionary.getOres("logWood").get(i));
		}
		stoneCarver = GameRegistry.addShapedRecipe(BaseItemStacks.stoneCarver, " X ", "YYY", 'X', Items.flint, 'Y', Blocks.stone);
		ironCarver = GameRegistry.addShapedRecipe(BaseItemStacks.ironCarver, " X ", "YYY", 'X', BaseItemStacks.ironShard, 'Y', Blocks.stone);
		obsidianCarver = GameRegistry.addShapedRecipe(BaseItemStacks.obsidianCarver, " X ", "YYY", 'X', BaseItemStacks.ironShard, 'Y', Blocks.obsidian);
		diamondCarver = GameRegistry.addShapedRecipe(BaseItemStacks.diamondCarver, " X ", "YYY", "ZZZ", 'X', BaseItemStacks.obsidianShard, 'Y', Items.diamond, 'Z', Blocks.obsidian);
	}

	private static void addShardsRecipes() {
		addCarverRecipe(BaseItemStacks.woodenShard, "logWood");
		addCarverRecipe(BaseItemStacks.stoneShard, "stone");
		addCarverRecipe(BaseItemStacks.ironShard, "ingotIron");
		addCarverRecipe(BaseItemStacks.goldenShard, "ingotGold");
		addCarverRecipe(BaseItemStacks.obsidianShard, new ItemStack(Blocks.obsidian));

		if (isOreRegistered("ingotCopper"))
			addCarverRecipe(BaseItemStacks.copperShard, "ingotCopper");
		if (isOreRegistered("ingotTin"))
			addCarverRecipe(BaseItemStacks.tinShard, "ingotTin");
		if (isOreRegistered("ingotLead"))
			addCarverRecipe(BaseItemStacks.leadShard, "ingotLead");
		if (isOreRegistered("ingotBronze"))
			addCarverRecipe(BaseItemStacks.bronzeShard, "ingotBronze");
	}

	public static IRecipe toolRecipe(ItemStack output, ItemStack X, String Y, ItemStack Z) {
		if (isOreRegistered(Y)) {
			for (int i = 0; i < OreDictionary.getOres(Y).size(); i++) {
				return GameRegistry.addShapedRecipe(output, " X ", " Y ", "YZY", 'X', X, 'Y', OreDictionary.getOres(Y).get(i), 'Z', Z);
			}
		}
		return null;
	}

	public static IRecipe toolRecipe(ItemStack output, ItemStack X, String Y, String Z) {
		if (isOreRegistered(Y) && isOreRegistered(Z)) {
			for (int i = 0; i < OreDictionary.getOres(Y).size(); i++) {
				for (int j = 0; j < OreDictionary.getOres(Z).size(); j++) {
					return GameRegistry.addShapedRecipe(output, " X ", " Y ", "YZY", 'X', X, 'Y', OreDictionary.getOres(Y).get(j), 'Z', OreDictionary.getOres(Z).get(i));
				}
			}
		}
		return null;
	}

	public static IRecipe drillTopRecipe(ItemStack output, String X, ItemStack Y) {
		if (isOreRegistered(X)) {
			for (int i = 0; i < OreDictionary.getOres(X).size(); i++) {
				return GameRegistry.addShapedRecipe(output, " Y ", "XXX", 'X', OreDictionary.getOres(X).get(i), 'Y', Y);
			}
		}
		return null;
	}

	public static IRecipe chainsawTopRecipe(ItemStack output, String X, ItemStack Y) {
		if (isOreRegistered(X)) {
			for (int i = 0; i < OreDictionary.getOres(X).size(); i++) {
				return GameRegistry.addShapedRecipe(output, " Y ", "XYX", "XYX", 'X', OreDictionary.getOres(X).get(i), 'Y', Y);
			}
		}
		return null;
	}

	public static void addCarverRecipe(ItemStack output, ItemStack input) {
		GameRegistry.addShapelessRecipe(output, BaseItemStacks.woodenCarver, input);
		GameRegistry.addShapelessRecipe(output, BaseItemStacks.stoneCarver, input);
		GameRegistry.addShapelessRecipe(output, BaseItemStacks.ironCarver, input);
		GameRegistry.addShapelessRecipe(output, BaseItemStacks.obsidianCarver, input);
		GameRegistry.addShapelessRecipe(output, BaseItemStacks.diamondCarver, input);
	}

	public static void addCarverRecipe(ItemStack output, String input) {
		if (isOreRegistered(input)) {
			for (int i = 0; i < OreDictionary.getOres(input).size(); i++) {
				GameRegistry.addShapelessRecipe(output, new ItemStack(BaseItemRegistry.woodCarver), OreDictionary.getOres(input).get(i));
				GameRegistry.addShapelessRecipe(output, BaseItemStacks.stoneCarver, OreDictionary.getOres(input).get(i));
				GameRegistry.addShapelessRecipe(output, BaseItemStacks.ironCarver, OreDictionary.getOres(input).get(i));
				GameRegistry.addShapelessRecipe(output, BaseItemStacks.obsidianCarver, OreDictionary.getOres(input).get(i));
				GameRegistry.addShapelessRecipe(output, BaseItemStacks.diamondCarver, OreDictionary.getOres(input).get(i));
			}
		}
	}

	private static boolean isOreRegistered(String ore) {
		return !OreDictionary.getOres(ore).isEmpty();
	}
}
