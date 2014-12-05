package tehnut.emt.modules.ic2.items;

import net.minecraft.item.Item;
import tehnut.emt.ElectroMagicTools;
import tehnut.emt.ModInformation;

public class ItemIC2 extends Item {

	public ItemIC2(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + ".module.ic2." + unlocName);
		setTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}

	public ItemIC2(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.ID + ".module.ic2." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}
}