package tombenpotter.emt.common.modules.ic2.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockEssentiaGenerator extends ItemBlock {

    public ItemBlockEssentiaGenerator(Block id) {
        super(id);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        //  list.add("");
    }
}
