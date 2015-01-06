package tehnut.emt.modules.ic2.tile.solars.water;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tehnut.emt.ConfigHandler;
import tehnut.emt.modules.ic2.blocks.IC2BlockRegistry;
import tehnut.emt.modules.ic2.tile.solars.TileEntitySolarBase;

public class TileWaterSolar extends TileEntitySolarBase {

    public TileWaterSolar() {
        output = ConfigHandler.compressedSolarOutput;
    }

    @Override
    public void createEnergy() {
        if (worldObj.isRaining() && worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) || worldObj.isThundering() && worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord)) {
            energySource.addEnergy(output);
        }
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.solars1, 1, 3);
    }
}
