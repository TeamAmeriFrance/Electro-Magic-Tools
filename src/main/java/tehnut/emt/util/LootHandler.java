package tehnut.emt.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import tehnut.emt.ConfigHandler;
import tehnut.emt.modules.base.items.BaseItemRegistry;

public class LootHandler {

	public static void addLootToChests() {
		if (!ConfigHandler.thorHammerResearch) {
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(BaseItemRegistry.thorHammerBroken), 0, 1, ConfigHandler.chanceTaintedMjolnir));
		}
		if (!ConfigHandler.oneRingSpawn) {
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(BaseItemRegistry.baseBaubles, 1, 0), 0, 1, ConfigHandler.chanceOneRing));
		}
	}
}
