package tehnut.emt.modules.base.items;

import tehnut.emt.ElectroMagicTools;
import tehnut.emt.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + ".module.base." + unlocName);
		setTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}

	public ItemBase(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.ID + ".module.base." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}
}
