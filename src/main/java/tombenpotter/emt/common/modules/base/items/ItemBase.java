package tombenpotter.emt.common.modules.base.items;

import net.minecraft.item.Item;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class ItemBase extends Item {

    public ItemBase(String unlocName, String textureName) {
        super();
        setUnlocalizedName(ModInformation.modid + ".module.base." + unlocName);
        setTextureName(ModInformation.texturePath + ":" + textureName);
        setCreativeTab(ElectroMagicTools.tabEMT);
    }

    public ItemBase(String unlocName) {
        super();
        setUnlocalizedName(ModInformation.modid + ".module.base." + unlocName);
        setCreativeTab(ElectroMagicTools.tabEMT);
    }
}
