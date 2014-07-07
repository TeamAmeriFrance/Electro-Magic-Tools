package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class DungeonChestGenerator {

    public static void generateLoot() {
        if (Config.thorHammerResearch == false) {
            ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemRegistry.taintedThorHammer), 0, 1, Config.chanceTaintedMjolnir));
        }
        if (Config.oneRingSpawn == false) {
            ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemRegistry.emtBauble, 1, 2), 0, 1, Config.chanceOneRing));
        }
    }

}
