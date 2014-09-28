package tombenpotter.emt.common.module.ic2.tile.generators;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.lib.events.EssentiaHandler;
import tombenpotter.emt.common.module.ic2.tile.TileEntityEMT;
import tombenpotter.emt.common.util.ConfigHandler;

public abstract class TileEntityBaseGenerator extends TileEntityEMT {

	public static int waitTime;
	public BasicSource energySource = new BasicSource(this, 1000000000, 3);
	public Aspect aspect;
	public double output;

	public TileEntityBaseGenerator() {
		waitTime = 30;
		output = 0;
	}

	@Override
	public void updateEntity() {
		energySource.updateEntity();

		if (waitTime > 0) {
			waitTime--;
		}

		if (waitTime <= 0) {
			createEnergy();
			waitTime = ConfigHandler.essentiaGeneratorsDelay;
		}
	}

	public void createEnergy() {
		if (!this.worldObj.isRemote && EssentiaHandler.drainEssentia(this, aspect, ForgeDirection.UNKNOWN, 8)) {
			energySource.addEnergy(output);
		}
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
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		energySource.readFromNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		energySource.writeToNBT(tag);
	}
}
