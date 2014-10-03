package tombenpotter.emt.common.modules.ic2.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class IC2ItemRegistry {

	public static Item ic2Baubles;

	public static void registerIC2Items() {
		ic2Baubles = new ItemIC2Baubles();
		GameRegistry.registerItem(ic2Baubles, "IC2Baubles");
	}
}
