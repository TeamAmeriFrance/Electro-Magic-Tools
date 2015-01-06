package tehnut.emt.modules.ic2.tile.solars.earth;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tehnut.emt.ConfigHandler;
import tehnut.emt.modules.ic2.blocks.IC2BlockRegistry;

public class TileTripleEarthSolar extends TileEarthSolar {

    public TileTripleEarthSolar() {
        output = ConfigHandler.tripleCompressedSolarOutput;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.solars2, 1, 4);
    }
}
