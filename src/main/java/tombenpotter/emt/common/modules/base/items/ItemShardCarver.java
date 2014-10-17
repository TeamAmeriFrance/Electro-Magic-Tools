package tombenpotter.emt.common.modules.base.items;

import net.minecraft.item.Item;
import tombenpotter.emt.ElectroMagicTools;

public class ItemShardCarver extends Item {

    public ItemShardCarver(int maxDamage) {
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setMaxDamage(maxDamage);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }
}
