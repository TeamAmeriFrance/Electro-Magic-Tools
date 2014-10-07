package tombenpotter.emt.common.module.vanilla;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

public class VanillaRecipesRegistry {

    public static IRecipe woodenDrill, stoneDrill, ironDrill, goldenDrill, diamondDrill, copperDrill, tinDrill, leadDrill, bronzeDrill;
    public static IRecipe woodenChainsaw, stoneChainsaw, ironChainsaw, goldenChainsaw, diamondChainsaw, copperChainsaw, tinChainsaw, leadChainsaw, bronzeChainsaw;
    public static IRecipe ironOmnitool, goldenOmnitool, diamondOmnitool, copperOmnitool, tinOmnitool, leadOmnitool, bronzeOmnitool;
    public static IRecipe woodenDrillTop, stoneDrillTop, ironDrillTop, goldenDrillTop, diamondDrillTop, copperDrillTop, tinDrillTop, leadDrillTop, bronzeDrillTop;
    public static IRecipe woodenChainsawTop, stoneChainsawTop, ironChainsawTop, goldenChainsawTop, diamondChainsawTop, copperChainsawTop, tinChainsawTop, leadChainsawTop, bronzeChainsawTop;
    public static IRecipe woodenCarver, stoneCarver, ironCarver, obsidianCarver, diamondCarver;

    public static void registerRecipes() {
        addMiscRecipes();
        addCarversRecipes();
        addShardsRecipes();
        addDrillTopRecipes();
        addDrillRecipe();
        addChainsawTopRecipes();
        addChainsawRecipes();
    }

    public static void addMiscRecipes() {
    }

    public static void addCarversRecipes() {
        for (int i = 0; i < OreDictionary.getOres("logWood").size(); i++) {
            woodenCarver = GameRegistry.addShapedRecipe(VanillaItemstacks.woodenCarver, " X ", "YYY", 'X', Items.flint, 'Y', OreDictionary.getOres("logWood").get(i));
        }
        stoneCarver = GameRegistry.addShapedRecipe(VanillaItemstacks.stoneCarver, " X ", "YYY", 'X', Items.flint, 'Y', Blocks.stone);
        ironCarver = GameRegistry.addShapedRecipe(VanillaItemstacks.ironCarver, " X ", "YYY", 'X', VanillaItemstacks.ironShard, 'Y', Blocks.stone);
        obsidianCarver = GameRegistry.addShapedRecipe(VanillaItemstacks.obsidianCarver, " X ", "YYY", 'X', VanillaItemstacks.ironShard, 'Y', Blocks.obsidian);
        diamondCarver = GameRegistry.addShapedRecipe(VanillaItemstacks.ironCarver, " X ", "YYY", "ZZZ", 'X', VanillaItemstacks.obsidianShard, 'Y', Items.diamond, 'Z', Blocks.obsidian);
    }

    public static void addShardsRecipes() {
        addCarverRecipe(VanillaItemstacks.woodenShard, "logWood");
        addCarverRecipe(VanillaItemstacks.stoneShard, "stone");
        addCarverRecipe(VanillaItemstacks.ironShard, "ingotIron");
        addCarverRecipe(VanillaItemstacks.goldenShard, "ingotGold");
        addCarverRecipe(VanillaItemstacks.obsidianShard, new ItemStack(Blocks.obsidian));

        if (isOreRegistered("ingotCopper"))
            addCarverRecipe(VanillaItemstacks.copperShard, "ingotCopper");
        if (isOreRegistered("ingotTin"))
            addCarverRecipe(VanillaItemstacks.tinShard, "ingotTin");
        if (isOreRegistered("ingotLead"))
            addCarverRecipe(VanillaItemstacks.leadShard, "ingotLead");
        if (isOreRegistered("ingotBronze"))
            addCarverRecipe(VanillaItemstacks.bronzeShard, "ingotBronze");
    }

    public static void addDrillTopRecipes() {
        woodenDrillTop = drillTopRecipe(VanillaItemstacks.woodenDrillTop, "plankWood", VanillaItemstacks.woodenShard);
        stoneDrillTop = drillTopRecipe(VanillaItemstacks.stoneDrillTop, "stone", VanillaItemstacks.stoneShard);
        ironDrillTop = drillTopRecipe(VanillaItemstacks.ironDrillTop, "ingotIron", VanillaItemstacks.ironShard);
        goldenDrillTop = drillTopRecipe(VanillaItemstacks.goldenDrillTop, "ingotGold", VanillaItemstacks.goldenShard);
        diamondDrillTop = drillTopRecipe(VanillaItemstacks.diamondDrillTop, "gemDiamond", VanillaItemstacks.obsidianShard);

        if (isOreRegistered("ingotCopper"))
            copperDrillTop = drillTopRecipe(VanillaItemstacks.copperDrillTop, "ingotCopper", VanillaItemstacks.copperShard);
        if (isOreRegistered("ingotTin"))
            tinDrillTop = drillTopRecipe(VanillaItemstacks.tinDrillTop, "ingotTin", VanillaItemstacks.tinShard);
        if (isOreRegistered("ingotLead"))
            leadDrillTop = drillTopRecipe(VanillaItemstacks.leadDrillTop, "ingotLead", VanillaItemstacks.leadShard);
        if (isOreRegistered("ingotBronze"))
            bronzeDrillTop = drillTopRecipe(VanillaItemstacks.bronzeDrillTop, "ingotBronze", VanillaItemstacks.bronzeShard);
    }

    public static void addChainsawTopRecipes() {
        woodenChainsawTop = chainsawTopRecipe(VanillaItemstacks.woodenChainsawTop, "plankWood", VanillaItemstacks.woodenShard);
        stoneChainsawTop = chainsawTopRecipe(VanillaItemstacks.stoneChainsawTop, "stone", VanillaItemstacks.stoneShard);
        ironChainsawTop = chainsawTopRecipe(VanillaItemstacks.ironChainsawTop, "ingotIron", VanillaItemstacks.ironShard);
        goldenChainsawTop = chainsawTopRecipe(VanillaItemstacks.goldenChainsawTop, "ingotGold", VanillaItemstacks.goldenShard);
        diamondChainsawTop = chainsawTopRecipe(VanillaItemstacks.diamondChainsawTop, "gemDiamond", VanillaItemstacks.obsidianShard);

        if (isOreRegistered("ingotCopper"))
            copperChainsawTop = chainsawTopRecipe(VanillaItemstacks.copperChainsawTop, "ingotCopper", VanillaItemstacks.copperShard);
        if (isOreRegistered("ingotTin"))
            tinChainsawTop = chainsawTopRecipe(VanillaItemstacks.tinChainsawTop, "ingotTin", VanillaItemstacks.tinShard);
        if (isOreRegistered("ingotLead"))
            leadChainsawTop = chainsawTopRecipe(VanillaItemstacks.leadChainsawTop, "ingotLead", VanillaItemstacks.leadShard);
        if (isOreRegistered("ingotBronze"))
            bronzeChainsawTop = chainsawTopRecipe(VanillaItemstacks.bronzeChainsawTop, "ingotBronze", VanillaItemstacks.bronzeShard);
    }

    public static void addDrillRecipe() {
        woodenDrill = toolRecipe(VanillaItemstacks.woodenDrill, VanillaItemstacks.woodenDrillTop, "plankWood", "stickWood");
        stoneDrill = toolRecipe(VanillaItemstacks.stoneDrill, VanillaItemstacks.stoneDrillTop, "stone", "cobblestone");
        ironDrill = toolRecipe(VanillaItemstacks.ironDrill, VanillaItemstacks.ironDrillTop, "ingotIron", new ItemStack(Items.leather));
        goldenDrill = toolRecipe(VanillaItemstacks.goldenDrill, VanillaItemstacks.goldenDrillTop, "ingotGold", new ItemStack(Blocks.obsidian));
        diamondDrill = toolRecipe(VanillaItemstacks.diamondDrill, VanillaItemstacks.diamondDrillTop, "gemDiamond", "ingotGold");

        if (isOreRegistered("ingotCopper") && isOreRegistered("ingotTin"))
            copperDrill = toolRecipe(VanillaItemstacks.copperDrill, VanillaItemstacks.copperDrillTop, "ingotCopper", "ingotTin");
        if (isOreRegistered("ingotTin"))
            tinDrill = toolRecipe(VanillaItemstacks.tinDrill, VanillaItemstacks.tinDrillTop, "ingotTin", "ingotGold");
        if (isOreRegistered("ingotLead"))
            leadDrill = toolRecipe(VanillaItemstacks.leadDrill, VanillaItemstacks.leadDrillTop, "ingotLead", "ingotIron");
        if (isOreRegistered("ingotBronze"))
            bronzeDrill = toolRecipe(VanillaItemstacks.bronzeDrill, VanillaItemstacks.bronzeDrillTop, "ingotBronze", new ItemStack(Blocks.obsidian));
    }

    public static void addChainsawRecipes() {
        woodenChainsaw = toolRecipe(VanillaItemstacks.woodenChainsaw, VanillaItemstacks.woodenChainsawTop, "plankWood", "stickWood");
        stoneChainsaw = toolRecipe(VanillaItemstacks.stoneChainsaw, VanillaItemstacks.stoneChainsawTop, "stone", "cobblestone");
        ironChainsaw = toolRecipe(VanillaItemstacks.ironChainsaw, VanillaItemstacks.ironChainsawTop, "ingotIron", new ItemStack(Items.leather));
        goldenChainsaw = toolRecipe(VanillaItemstacks.goldenChainsaw, VanillaItemstacks.goldenChainsawTop, "ingotGold", new ItemStack(Blocks.obsidian));
        diamondChainsaw = toolRecipe(VanillaItemstacks.diamondChainsaw, VanillaItemstacks.diamondChainsawTop, "gemDiamond", "ingotGold");

        if (isOreRegistered("ingotCopper") && isOreRegistered("ingotTin"))
            copperChainsaw = toolRecipe(VanillaItemstacks.copperChainsaw, VanillaItemstacks.copperChainsawTop, "ingotCopper", "ingotTin");
        if (isOreRegistered("ingotTin"))
            tinChainsaw = toolRecipe(VanillaItemstacks.tinChainsaw, VanillaItemstacks.tinChainsawTop, "ingotTin", "ingotGold");
        if (isOreRegistered("ingotLead"))
            leadChainsaw = toolRecipe(VanillaItemstacks.leadChainsaw, VanillaItemstacks.leadChainsawTop, "ingotLead", "ingotIron");
        if (isOreRegistered("ingotBronze"))
            bronzeChainsaw = toolRecipe(VanillaItemstacks.bronzeChainsaw, VanillaItemstacks.bronzeChainsawTop, "ingotBronze", new ItemStack(Blocks.obsidian));
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
        GameRegistry.addShapelessRecipe(output, VanillaItemstacks.woodenCarver, input);
        GameRegistry.addShapelessRecipe(output, VanillaItemstacks.stoneCarver, input);
        GameRegistry.addShapelessRecipe(output, VanillaItemstacks.ironCarver, input);
        GameRegistry.addShapelessRecipe(output, VanillaItemstacks.obsidianCarver, input);
        GameRegistry.addShapelessRecipe(output, VanillaItemstacks.diamondCarver, input);
    }

    public static void addCarverRecipe(ItemStack output, String input) {
        if (isOreRegistered(input)) {
            for (int i = 0; i < OreDictionary.getOres(input).size(); i++) {
                GameRegistry.addShapelessRecipe(output, VanillaItemstacks.woodenCarver, OreDictionary.getOres(input).get(i));
                GameRegistry.addShapelessRecipe(output, VanillaItemstacks.stoneCarver, OreDictionary.getOres(input).get(i));
                GameRegistry.addShapelessRecipe(output, VanillaItemstacks.ironCarver, OreDictionary.getOres(input).get(i));
                GameRegistry.addShapelessRecipe(output, VanillaItemstacks.obsidianCarver, OreDictionary.getOres(input).get(i));
                GameRegistry.addShapelessRecipe(output, VanillaItemstacks.diamondCarver, OreDictionary.getOres(input).get(i));
            }
        }
    }

    public static boolean isOreRegistered(String ore) {
        return !OreDictionary.getOres(ore).isEmpty();
    }
}
