package tombenpotter.emt.common.modules.te.items;

import net.minecraft.item.Item;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class ItemTE extends Item {

	public ItemTE(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.modid + ".module.te." + unlocName);
		setTextureName(ModInformation.texturePath + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}

	public ItemTE(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.modid + ".module.te." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}
}
