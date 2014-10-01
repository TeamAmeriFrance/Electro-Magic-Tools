package tombenpotter.emt.common.module.vanilla;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

public class VanillaRecipesRegistry {

    public static IRecipe woodenDrill, stoneDrill, ironDrill, goldenDrill, diamondDrill, copperDrill, tinDrill, leadDrill, bronzeDrill;
    public static IRecipe woodenChainsaw, stoneChainsaw, ironChainsaw, goldenChainsaw, diamondChainsaw;
    public static IRecipe ironOmnitool, goldenOmnitool, diamondOmnitool;
    public static IRecipe woodenTop, stoneTop, ironTop, goldenTop, diamondTop, copperTop, tinTop, leadTop, bronzeTop;

    public static void registerRecipes() {
        addMiscRecipes();
        addDrillTopRecipes();
        addDrillRecipes();
        addChainsawRecipes();
        addChainsawRecipes();
    }

    public static void addMiscRecipes() {
    }

    public static void addDrillTopRecipes() {
        woodenTop = drillTopRecipe(VanillaItemstacks.woodenDrillTop, "plankWood");
        stoneTop = drillTopRecipe(VanillaItemstacks.stoneDrillTop, "stone");
        ironTop = drillTopRecipe(VanillaItemstacks.ironDrillTop, "ingotIron");
        goldenTop = drillTopRecipe(VanillaItemstacks.goldenDrillTop, "ingotGold");
        diamondTop = drillTopRecipe(VanillaItemstacks.diamondDrillTop, "gemDiamond");
        copperTop = drillTopRecipe(VanillaItemstacks.copperDrillTop, "ingotCopper");
        tinTop = drillTopRecipe(VanillaItemstacks.tinDrillTop, "ingotTin");
        leadTop = drillTopRecipe(VanillaItemstacks.leadDrillTop, "ingotLead");
        bronzeTop = drillTopRecipe(VanillaItemstacks.bronzeDrillTop, "ingotBronze");
    }

    public static void addChainsawTopRecipes() {
    }

    public static void addDrillRecipes() {
        woodenDrill = drillRecipe(VanillaItemstacks.woodenDrill, VanillaItemstacks.woodenDrillTop, "plankWood", "stickWood");
        stoneDrill = drillRecipe(VanillaItemstacks.stoneDrill, VanillaItemstacks.stoneDrillTop, "stone", "cobblestone");
        ironDrill = drillRecipe(VanillaItemstacks.ironDrill, VanillaItemstacks.ironDrillTop, "ingotIron", new ItemStack(Items.leather));
        goldenDrill = drillRecipe(VanillaItemstacks.goldenDrill, VanillaItemstacks.goldenDrillTop, "ingotGold", new ItemStack(Blocks.obsidian));
        diamondDrill = drillRecipe(VanillaItemstacks.diamondDrill, VanillaItemstacks.diamondDrillTop, "gemDiamond", "ingotGold");
        copperDrill = drillRecipe(VanillaItemstacks.copperDrill, VanillaItemstacks.copperDrillTop, "ingotCopper", "ingotTin");
        tinDrill = drillRecipe(VanillaItemstacks.tinDrill, VanillaItemstacks.tinDrillTop, "ingotTin", "ingotGold");
        leadDrill = drillRecipe(VanillaItemstacks.leadDrill, VanillaItemstacks.leadDrillTop, "ingotLead", "ingotIron");
        bronzeDrill = drillRecipe(VanillaItemstacks.bronzeDrill, VanillaItemstacks.bronzeDrillTop, "ingotBronze", new ItemStack(Blocks.obsidian));
    }

    public static void addChainsawRecipes() {
    }

    public static IRecipe drillRecipe(ItemStack output, ItemStack X, String Y, ItemStack Z) {
        for (int i = 0; i < OreDictionary.getOres(Y).size(); i++) {
            return GameRegistry.addShapedRecipe(output, " X ", " Y ", "YZY", 'X', X, 'Y', OreDictionary.getOres(Y).get(i), 'Z', Z);
        }
        return null;
    }

    public static IRecipe drillRecipe(ItemStack output, ItemStack X, String Y, String Z) {
        for (int i = 0; i < OreDictionary.getOres(Y).size(); i++) {
            for (int j = 0; j < OreDictionary.getOres(Z).size(); j++) {
                return GameRegistry.addShapedRecipe(output, " X ", " Y ", "YZY", 'X', X, 'Y', OreDictionary.getOres(Y).get(j), 'Z', OreDictionary.getOres(Z).get(i));
            }
        }
        return null;
    }

    public static IRecipe drillTopRecipe(ItemStack output, String X) {
        for (int i = 0; i < OreDictionary.getOres(X).size(); i++) {
            return GameRegistry.addShapedRecipe(output, " X ", "XXX", 'X', OreDictionary.getOres(X).get(i));
        }
        return null;
    }
}
