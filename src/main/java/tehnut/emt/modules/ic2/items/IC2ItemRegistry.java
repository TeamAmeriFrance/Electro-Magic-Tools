package tehnut.emt.modules.ic2.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import tehnut.emt.modules.ic2.items.armor.boots.ItemElectricBootsTraveller;
import tehnut.emt.modules.ic2.items.armor.boots.ItemNanoBootsTraveller;
import tehnut.emt.modules.ic2.items.armor.boots.ItemQuantumBootsTraveller;
import tehnut.emt.modules.ic2.items.armor.goggles.ItemElectricGoggles;
import tehnut.emt.modules.ic2.items.armor.goggles.ItemNanoGoggles;
import tehnut.emt.modules.ic2.items.armor.goggles.ItemQuantumGoggles;
import tehnut.emt.modules.ic2.items.armor.goggles.ItemSolarGoggles;
import tehnut.emt.modules.ic2.items.tools.ItemElectricScribingTools;

public class IC2ItemRegistry {

	public static Item baubleIC2;

	public static Item toolScribingElectric;

	public static Item armorElectricGoggles;
	public static Item armorNanoGoggles;
	public static Item armorQuantumGoggles;
	public static Item armorSolarGoggles;

	public static Item armorElectricBoots;
	public static Item armorNanoBoots;
	public static Item armorQuantumBoots;

	public static void registerItems() {

		baubleIC2 = new ItemIC2Baubles();
		GameRegistry.registerItem(baubleIC2, "ItemIC2Baubles");

		toolScribingElectric = new ItemElectricScribingTools();
		GameRegistry.registerItem(toolScribingElectric, "ItemElectricScribingTools");

		armorElectricGoggles = new ItemElectricGoggles(ItemArmor.ArmorMaterial.IRON);
		GameRegistry.registerItem(armorElectricGoggles, "ItemElectricGoggles");
		armorNanoGoggles = new ItemNanoGoggles();
		GameRegistry.registerItem(armorNanoGoggles, "ItemNanoGoggles");
		armorQuantumGoggles = new ItemQuantumGoggles();
		GameRegistry.registerItem(armorQuantumGoggles, "ItemQuantumGoggles");
		armorSolarGoggles = new ItemSolarGoggles();
		GameRegistry.registerItem(armorSolarGoggles, "ItemSolarGoggles");

		armorElectricBoots = new ItemElectricBootsTraveller();
		GameRegistry.registerItem(armorElectricBoots, "ItemElectricBootsTraveller");
		armorNanoBoots = new ItemNanoBootsTraveller();
		GameRegistry.registerItem(armorNanoBoots, "ItemNanoBootsTraveller");
		armorQuantumBoots = new ItemQuantumBootsTraveller();
		GameRegistry.registerItem(armorQuantumBoots, "ItemQuantumBootsTraveller");
	}
}
