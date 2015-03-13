package amerifrance.emt.modules.ic2.tile.solars.water;

import amerifrance.emt.ConfigHandler;
import amerifrance.emt.modules.ic2.blocks.IC2BlockRegistry;
import ic2.api.energy.prefab.BasicSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileTripleWaterSolar extends TileWaterSolar {

    public TileTripleWaterSolar() {
        output = ConfigHandler.tripleCompressedSolarOutput;
        energySource = new BasicSource(this, 10000, 4);
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.solars1, 1, 5);
    }
}
