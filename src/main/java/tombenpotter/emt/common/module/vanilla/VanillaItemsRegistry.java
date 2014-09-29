package tombenpotter.emt.common.module.vanilla;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.module.vanilla.items.tools.ItemVanillaChainsaw;
import tombenpotter.emt.common.module.vanilla.items.tools.ItemVanillaDrill;

public class VanillaItemsRegistry {

    public static Item woodenDrill;
    public static Item stoneDrill;
    public static Item ironDrill;
    public static Item goldenDrill;
    public static Item diamondDrill;
    public static Item woodenChainsaw;
    public static Item stoneChainsaw;
    public static Item ironChainsaw;
    public static Item goldenChainsaw;
    public static Item diamondChainsaw;

    public static void registerItems() {
        woodenDrill = new ItemVanillaDrill(Item.ToolMaterial.WOOD, 75, "woodendrill", Item.getItemFromBlock(Blocks.planks)).setUnlocalizedName(ModInformation.modid + "woodenDrill");
        GameRegistry.registerItem(woodenDrill, "woodenDrill");
        stoneDrill = new ItemVanillaDrill(Item.ToolMaterial.STONE, 165, "stonedrill", Item.getItemFromBlock(Blocks.cobblestone)).setUnlocalizedName(ModInformation.modid + "stoneDrill");
        GameRegistry.registerItem(stoneDrill, "stoneDrill");
        ironDrill = new ItemVanillaDrill(Item.ToolMaterial.IRON, 315, "irondrill", Items.iron_ingot).setUnlocalizedName(ModInformation.modid + "ironDrill");
        GameRegistry.registerItem(ironDrill, "ironDrill");
        goldenDrill = new ItemVanillaDrill(Item.ToolMaterial.GOLD, 55, "goldendrill", Items.gold_ingot).setUnlocalizedName(ModInformation.modid + "goldenDrill");
        GameRegistry.registerItem(goldenDrill, "goldenDrill");
        diamondDrill = new ItemVanillaDrill(Item.ToolMaterial.EMERALD, 2015, "diamondDrill", Items.diamond).setUnlocalizedName(ModInformation.modid + "diamondDrill");
        GameRegistry.registerItem(diamondDrill, "diamondDrill");

        woodenChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.WOOD, 75, "woodenchainsaw", Item.getItemFromBlock(Blocks.planks)).setUnlocalizedName(ModInformation.modid + "woodenChainsaw");
        GameRegistry.registerItem(woodenChainsaw, "woodenChainsaw");
        stoneChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.STONE, 165, "stonechainsaw", Item.getItemFromBlock(Blocks.cobblestone)).setUnlocalizedName(ModInformation.modid + "stoneChainsaw");
        GameRegistry.registerItem(stoneChainsaw, "stoneChainsaw");
        ironChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.IRON, 315, "ironchainsaw", Items.iron_ingot, 3F).setUnlocalizedName(ModInformation.modid + "ironChainsaw");
        GameRegistry.registerItem(ironChainsaw, "ironChainsaw");
        goldenChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.GOLD, 55, "goldenchainsaw", Items.gold_ingot).setUnlocalizedName(ModInformation.modid + "goldenChainsaw");
        GameRegistry.registerItem(goldenChainsaw, "goldenChainsaw");
        diamondChainsaw = new ItemVanillaChainsaw(Item.ToolMaterial.EMERALD, 2015, "diamondchainsaw", Items.diamond, 5F).setUnlocalizedName(ModInformation.modid + "diamondChainsaw");
        GameRegistry.registerItem(diamondChainsaw, "diamondChainsaw");
    }
}