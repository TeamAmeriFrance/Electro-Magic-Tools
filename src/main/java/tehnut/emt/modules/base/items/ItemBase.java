package tehnut.emt.modules.base.items;

import net.minecraft.item.Item;
import tehnut.emt.ElectroMagicTools;
import tehnut.emt.ModInformation;

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
