package tombenpotter.emt.common.modules.ic2.tile.solars;

import ic2.api.energy.prefab.BasicSource;
import ic2.api.tile.IWrenchable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import tombenpotter.emt.common.modules.ic2.tile.TileEntityEMT;

import java.util.Random;

public abstract class TileEntitySolarBase extends TileEntityEMT implements IWrenchable {

    public BasicSource energySource = new BasicSource(this, 10000, 1);
    public static Random random = new Random();
    public boolean initialized;
    public boolean theSunIsVisible;
    public boolean canRain;
    public boolean noSunlight;
    public int tick;
    public double output = 0;

    public TileEntitySolarBase() {
        this.tick = random.nextInt(64);
    }

    @Override
    public void updateEntity() {
        energySource.updateEntity();
        checkConditions();
    }

    public void checkConditions() {
        if (!initialized && worldObj != null) {
            canRain = worldObj.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
            noSunlight = worldObj.provider.hasNoSky;
            initialized = true;
        }
        if (noSunlight) {
            return;
        }
        if (tick-- == 0) {
            updateSunState();
            tick = 64;
        }
        createEnergy();
    }

    public void createEnergy() {
        if (theSunIsVisible) {
            energySource.addEnergy(output);
        }
    }

    public void updateSunState() {
        boolean isRaining = canRain && (worldObj.isRaining() || worldObj.isThundering());
        theSunIsVisible = worldObj.isDaytime() && !isRaining && worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord);
    }

    @Override
    public void onChunkUnload() {
        energySource.onChunkUnload();
    }

    @Override
    public void invalidate() {
        energySource.invalidate();
        super.invalidate();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        energySource.writeToNBT(nbttagcompound);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        energySource.readFromNBT(nbttagcompound);
    }

    @Override
    public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
        return false;
    }

    @Override
    public short getFacing() {
        return 0;
    }

    @Override
    public void setFacing(short facing) {
    }

    @Override
    public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public float getWrenchDropRate() {
        return 1;
    }
}
