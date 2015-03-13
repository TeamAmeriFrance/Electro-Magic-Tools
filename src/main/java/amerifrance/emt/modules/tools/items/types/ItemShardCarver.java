package amerifrance.emt.modules.tools.items.types;

import amerifrance.emt.ElectroMagicTools;
import net.minecraft.item.Item;

public class ItemShardCarver extends Item {

    public ItemShardCarver(int maxDamage) {
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setMaxDamage(maxDamage);
        this.setMaxStackSize(1);
        this.setNoRepair();
    }
}
