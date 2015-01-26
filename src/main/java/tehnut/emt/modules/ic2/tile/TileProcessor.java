package tehnut.emt.modules.ic2.tile;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;

public class TileProcessor extends TileIC2 {

    public boolean multiblockFormed;

    public boolean isMultiblockFormed() {
        //Row 1
        if (worldObj.getBlock(xCoord - 1, yCoord, zCoord) != Blocks.end_stone) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord, zCoord) != Blocks.end_stone) return false;
        else if (worldObj.getBlock(xCoord, yCoord, zCoord - 1) != Blocks.end_stone) return false;
        else if (worldObj.getBlock(xCoord, yCoord, zCoord + 1) != Blocks.end_stone) return false;

        if (worldObj.getBlock(xCoord - 1, yCoord, zCoord - 1) != Blocks.snow) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord, zCoord - 1) != Blocks.snow) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord, zCoord + 1) != Blocks.snow) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord, zCoord + 1) != Blocks.snow) return false;

        //Row 2
        if (worldObj.getBlock(xCoord - 1, yCoord + 1, zCoord) != Blocks.iron_block) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord) != Blocks.iron_block) return false;
        else if (worldObj.getBlock(xCoord, yCoord + 1, zCoord - 1) != Blocks.iron_block) return false;
        else if (worldObj.getBlock(xCoord, yCoord + 1, zCoord + 1) != Blocks.iron_block) return false;

        if (worldObj.getBlock(xCoord - 1, yCoord + 1, zCoord - 1) != Blocks.obsidian) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord - 1) != Blocks.obsidian) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord + 1) != Blocks.obsidian) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 1, zCoord + 1) != Blocks.obsidian) return false;

        //Row3
        if (worldObj.getBlock(xCoord - 1, yCoord + 2, zCoord) != Blocks.quartz_block) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord) != Blocks.quartz_block) return false;
        else if (worldObj.getBlock(xCoord, yCoord + 2, zCoord - 1) != Blocks.quartz_block) return false;
        else if (worldObj.getBlock(xCoord, yCoord + 2, zCoord + 1) != Blocks.quartz_block) return false;

        if (worldObj.getBlock(xCoord - 1, yCoord + 2, zCoord - 1) != Blocks.iron_bars) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord - 1) != Blocks.iron_bars) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord + 1) != Blocks.iron_bars) return false;
        else if (worldObj.getBlock(xCoord + 1, yCoord + 2, zCoord + 1) != Blocks.iron_bars) return false;

        if (worldObj.getBlock(xCoord, yCoord + 2, zCoord) != Blocks.trapdoor) return false;

        return true;
    }

    @Override
    public void updateEntity() {
        if (worldObj.getWorldTime() % 60 == 0) multiblockFormed = isMultiblockFormed();
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        multiblockFormed = tagCompound.getBoolean("multiblockFormed");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setBoolean("multiblockFormed", multiblockFormed);
    }
}
