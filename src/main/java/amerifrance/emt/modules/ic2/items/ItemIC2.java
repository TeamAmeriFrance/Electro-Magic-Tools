package amerifrance.emt.modules.ic2.items;

import amerifrance.emt.ElectroMagicTools;
import amerifrance.emt.ModInformation;
import net.minecraft.item.Item;

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