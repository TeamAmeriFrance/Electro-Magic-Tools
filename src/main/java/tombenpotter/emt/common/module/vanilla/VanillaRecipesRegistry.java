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

    public static void registerRecipes() {
        addMiscRecipes();
        addDrillTopRecipes();
        addDrillRecipe();
        addChainsawTopRecipes();
        addChainsawRecipes();
    }

    public static void addMiscRecipes() {
    }

    public static void addDrillTopRecipes() {
        woodenDrillTop = drillTopRecipe(VanillaItemstacks.woodenDrillTop, "plankWood", VanillaItemstacks.woodenShard);
        stoneDrillTop = drillTopRecipe(VanillaItemstacks.stoneDrillTop, "stone", VanillaItemstacks.stoneShard);
        ironDrillTop = drillTopRecipe(VanillaItemstacks.ironDrillTop, "ingotIron", VanillaItemstacks.ironShard);
        goldenDrillTop = drillTopRecipe(VanillaItemstacks.goldenDrillTop, "ingotGold", VanillaItemstacks.goldenShard);
        diamondDrillTop = drillTopRecipe(VanillaItemstacks.diamondDrillTop, "gemDiamond", VanillaItemstacks.obsidianShard);
        copperDrillTop = drillTopRecipe(VanillaItemstacks.copperDrillTop, "ingotCopper", VanillaItemstacks.copperShard);
        tinDrillTop = drillTopRecipe(VanillaItemstacks.tinDrillTop, "ingotTin", VanillaItemstacks.tinShard);
        leadDrillTop = drillTopRecipe(VanillaItemstacks.leadDrillTop, "ingotLead", VanillaItemstacks.leadShard);
        bronzeDrillTop = drillTopRecipe(VanillaItemstacks.bronzeDrillTop, "ingotBronze", VanillaItemstacks.bronzeShard);
    }

    public static void addChainsawTopRecipes() {
        woodenChainsawTop = chainsawTopRecipe(VanillaItemstacks.woodenChainsawTop, "plankWood", VanillaItemstacks.woodenShard);
        stoneChainsawTop = chainsawTopRecipe(VanillaItemstacks.stoneChainsawTop, "stone", VanillaItemstacks.stoneShard);
        ironChainsawTop = chainsawTopRecipe(VanillaItemstacks.ironChainsawTop, "ingotIron", VanillaItemstacks.ironShard);
        goldenChainsawTop = chainsawTopRecipe(VanillaItemstacks.goldenChainsawTop, "ingotGold", VanillaItemstacks.goldenShard);
        diamondChainsawTop = chainsawTopRecipe(VanillaItemstacks.diamondChainsawTop, "gemDiamond", VanillaItemstacks.obsidianShard);
        copperChainsawTop = chainsawTopRecipe(VanillaItemstacks.copperChainsawTop, "ingotCopper", VanillaItemstacks.copperShard);
        tinChainsawTop = chainsawTopRecipe(VanillaItemstacks.tinChainsawTop, "ingotTin", VanillaItemstacks.tinShard);
        leadChainsawTop = chainsawTopRecipe(VanillaItemstacks.leadChainsawTop, "ingotLead", VanillaItemstacks.leadShard);
        bronzeDrill = chainsawTopRecipe(VanillaItemstacks.bronzeChainsawTop, "ingotBronze", VanillaItemstacks.bronzeShard);
    }

    public static void addDrillRecipe() {
        woodenDrill = toolRecipe(VanillaItemstacks.woodenDrill, VanillaItemstacks.woodenDrillTop, "plankWood", "stickWood");
        stoneDrill = toolRecipe(VanillaItemstacks.stoneDrill, VanillaItemstacks.stoneDrillTop, "stone", "cobblestone");
        ironDrill = toolRecipe(VanillaItemstacks.ironDrill, VanillaItemstacks.ironDrillTop, "ingotIron", new ItemStack(Items.leather));
        goldenDrill = toolRecipe(VanillaItemstacks.goldenDrill, VanillaItemstacks.goldenDrillTop, "ingotGold", new ItemStack(Blocks.obsidian));
        diamondDrill = toolRecipe(VanillaItemstacks.diamondDrill, VanillaItemstacks.diamondDrillTop, "gemDiamond", "ingotGold");
        copperDrill = toolRecipe(VanillaItemstacks.copperDrill, VanillaItemstacks.copperDrillTop, "ingotCopper", "ingotTin");
        tinDrill = toolRecipe(VanillaItemstacks.tinDrill, VanillaItemstacks.tinDrillTop, "ingotTin", "ingotGold");
        leadDrill = toolRecipe(VanillaItemstacks.leadDrill, VanillaItemstacks.leadDrillTop, "ingotLead", "ingotIron");
        bronzeDrill = toolRecipe(VanillaItemstacks.bronzeDrill, VanillaItemstacks.bronzeDrillTop, "ingotBronze", new ItemStack(Blocks.obsidian));
    }

    public static void addChainsawRecipes() {
        woodenChainsaw = toolRecipe(VanillaItemstacks.woodenChainsaw, VanillaItemstacks.woodenChainsawTop, "plankWood", "stickWood");
        stoneChainsaw = toolRecipe(VanillaItemstacks.stoneChainsaw, VanillaItemstacks.stoneChainsawTop, "stone", "cobblestone");
        ironChainsaw = toolRecipe(VanillaItemstacks.ironChainsaw, VanillaItemstacks.ironChainsawTop, "ingotIron", new ItemStack(Items.leather));
        goldenChainsaw = toolRecipe(VanillaItemstacks.goldenChainsaw, VanillaItemstacks.goldenChainsawTop, "ingotGold", new ItemStack(Blocks.obsidian));
        diamondChainsaw = toolRecipe(VanillaItemstacks.diamondChainsaw, VanillaItemstacks.diamondChainsawTop, "gemDiamond", "ingotGold");
        copperChainsaw = toolRecipe(VanillaItemstacks.copperChainsaw, VanillaItemstacks.copperChainsawTop, "ingotCopper", "ingotTin");
        tinChainsaw = toolRecipe(VanillaItemstacks.tinChainsaw, VanillaItemstacks.tinChainsawTop, "ingotTin", "ingotGold");
        leadChainsaw = toolRecipe(VanillaItemstacks.leadChainsaw, VanillaItemstacks.leadChainsawTop, "ingotLead", "ingotIron");
        bronzeChainsaw = toolRecipe(VanillaItemstacks.bronzeChainsaw, VanillaItemstacks.bronzeChainsawTop, "ingotBronze", new ItemStack(Blocks.obsidian));
    }

    public static IRecipe toolRecipe(ItemStack output, ItemStack X, String Y, ItemStack Z) {
        for (int i = 0; i < OreDictionary.getOres(Y).size(); i++) {
            return GameRegistry.addShapedRecipe(output, " X ", " Y ", "YZY", 'X', X, 'Y', OreDictionary.getOres(Y).get(i), 'Z', Z);
        }
        return null;
    }

    public static IRecipe toolRecipe(ItemStack output, ItemStack X, String Y, String Z) {
        for (int i = 0; i < OreDictionary.getOres(Y).size(); i++) {
            for (int j = 0; j < OreDictionary.getOres(Z).size(); j++) {
                return GameRegistry.addShapedRecipe(output, " X ", " Y ", "YZY", 'X', X, 'Y', OreDictionary.getOres(Y).get(j), 'Z', OreDictionary.getOres(Z).get(i));
            }
        }
        return null;
    }

    public static IRecipe drillTopRecipe(ItemStack output, String X, ItemStack Y) {
        for (int i = 0; i < OreDictionary.getOres(X).size(); i++) {
            return GameRegistry.addShapedRecipe(output, " Y ", "XXX", 'X', OreDictionary.getOres(X).get(i), 'Y', Y);
        }
        return null;
    }

    public static IRecipe chainsawTopRecipe(ItemStack output, String X, ItemStack Y) {
        for (int i = 0; i < OreDictionary.getOres(X).size(); i++) {
            return GameRegistry.addShapedRecipe(output, " Y ", "XYX", "XYX", 'X', OreDictionary.getOres(X).get(i), 'Y', Y);
        }
        return null;
    }
}
