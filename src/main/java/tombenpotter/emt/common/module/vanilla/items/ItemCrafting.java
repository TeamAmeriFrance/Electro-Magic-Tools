package tombenpotter.emt.common.module.vanilla.items;

import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import tombenpotter.emt.ElectroMagicTools;

public class ItemCrafting extends Item {

    public IIcon[] icon = new IIcon[500];

    public ItemCrafting() {
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
    }
}
