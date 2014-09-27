package tombenpotter.emt.common.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import tombenpotter.emt.common.module.ic2.IC2ModuleItemRegistry;
import tombenpotter.emt.common.util.Config;

public class DungeonChestGenerator {

    public static void generateLoot() {
        if (Config.thorHammerResearch == false) {
            ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IC2ModuleItemRegistry.taintedThorHammer), 0, 1, Config.chanceTaintedMjolnir));
        }
        if (Config.oneRingSpawn == false) {
            ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IC2ModuleItemRegistry.emtBauble, 1, 2), 0, 1, Config.chanceOneRing));
        }
    }

}
