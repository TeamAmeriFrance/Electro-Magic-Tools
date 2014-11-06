package tehnut.emt.modules.base.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tehnut.emt.modules.base.items.foci.ItemChristmasFocus;
import tehnut.emt.modules.base.items.foci.ItemShieldFocus;
import tehnut.emt.modules.base.items.tools.hammer.ItemThorHammer;
import tehnut.emt.modules.base.items.tools.hammer.ItemThorHammerBroken;

public class BaseItemRegistry {

	// Items
	public static Item baseBaubles;

	public static Item focusChristmas;
	public static Item focusShield;

	public static Item thorHammer;
	public static Item thorHammerBroken;

	public static void registerItems() {

		baseBaubles = new ItemBaseBaubles();
		GameRegistry.registerItem(baseBaubles, "ItemBaseBaubles");

		focusChristmas = new ItemChristmasFocus();
		GameRegistry.registerItem(focusChristmas, "ItemFocusChristmas");
		focusShield = new ItemShieldFocus();
		GameRegistry.registerItem(focusShield, "ItemFocusShield");

		thorHammer = new ItemThorHammer();
		GameRegistry.registerItem(thorHammer, "ItemThorHammer");
		thorHammerBroken = new ItemThorHammerBroken();
		GameRegistry.registerItem(thorHammerBroken, "ItemThorHammerBroken");
	}
}
