package amerifrance.emt.modules.ic2.tile.solars.order;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import amerifrance.emt.ConfigHandler;
import amerifrance.emt.modules.ic2.blocks.IC2BlockRegistry;

public class TileTripleOrderSolar extends TileOrderSolar {

    public TileTripleOrderSolar() {
        output = ConfigHandler.tripleCompressedSolarOutput;
        energySource = new BasicSource(this, 10000, 4);
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.solars1, 1, 11);
    }
}