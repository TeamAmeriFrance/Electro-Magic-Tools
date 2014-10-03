package tombenpotter.emt.common.modules.ic2.items;

import net.minecraft.item.Item;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class ItemIC2 extends Item {

	public ItemIC2(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.modid + ".module.ic2." + unlocName);
		setTextureName(ModInformation.texturePath + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}

	public ItemIC2(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.modid + ".module.ic2." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
	}
}
