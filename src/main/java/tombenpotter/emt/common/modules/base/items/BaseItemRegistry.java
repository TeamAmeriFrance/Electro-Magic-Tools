package tombenpotter.emt.common.modules.base.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tombenpotter.emt.common.modules.base.items.foci.ItemChristmasFocus;
import tombenpotter.emt.common.modules.base.items.tools.ItemThorHammer;
import tombenpotter.emt.common.modules.base.items.tools.ItemThorHammerBroken;

public class BaseItemRegistry {

	public static Item baseBaubles;
	public static Item materials;
	public static Item toolMaterials;

	public static Item thorHammer;
	public static Item thorHammerBroken;

	public static Item focusChristmas;

	public static void registerBaseItems() {
		baseBaubles = new ItemBaseBaubles();
		GameRegistry.registerItem(baseBaubles, "BaseBaubles");
		materials = new ItemMaterials();
		GameRegistry.registerItem(materials, "Materials");
		toolMaterials = new ItemToolMaterials();
		GameRegistry.registerItem(toolMaterials, "ToolMaterials");

		thorHammer = new ItemThorHammer();
		GameRegistry.registerItem(thorHammer, "ThorHammer");
		thorHammerBroken = new ItemThorHammerBroken();
		GameRegistry.registerItem(thorHammerBroken, "ThorHammerBroken");

		focusChristmas = new ItemChristmasFocus();
		GameRegistry.registerItem(focusChristmas, "FocusChristmas");
	}
}
