package tehnut.emt.modules.ic2.tile.solars.fire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tehnut.emt.ConfigHandler;
import tehnut.emt.modules.ic2.blocks.IC2BlockRegistry;

public class TileDoubleFireSolar extends TileFireSolar {

    public TileDoubleFireSolar() {
        output = ConfigHandler.doubleCompressedSolarOutput;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.solars1, 1, 13);
    }
}
