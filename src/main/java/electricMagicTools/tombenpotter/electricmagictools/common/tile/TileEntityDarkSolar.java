/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 * 
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/
package electricMagicTools.tombenpotter.electricmagictools.common.tile;

import ic2.api.energy.prefab.BasicSource;
import ic2.api.tile.IWrenchable;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import electricMagicTools.tombenpotter.electricmagictools.common.BlockRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class TileEntityDarkSolar extends TileEntity implements IWrenchable
{

	private BasicSource energySource = new BasicSource(this, 10000, 1);
	private static Random random = new Random();
	private boolean initialized;
	public boolean theSunIsVisible;
	private int tick;
	private boolean canRain;
	private boolean noSunlight;

	public TileEntityDarkSolar()
	{
		super();
		this.tick = random.nextInt(64);
	}

	@Override
	public void updateEntity() {
		energySource.updateEntity();
		if (!initialized && worldObj != null)
		{
			canRain = worldObj.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
			noSunlight = worldObj.provider.hasNoSky;
			initialized = true;
		}
		if (noSunlight)
		{
			return;
		}
		if (tick-- == 0)
		{
			updateSunState();
			tick = 64;
		}
		int energyProduction = 0;
		if (worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) && worldObj.isDaytime() == false && worldObj.isRaining() == false && worldObj.isThundering() == false)
		{
			energySource.addEnergy(Config.compressedSolarOutput);
		}
		energySource.addEnergy(energyProduction);
	}

	private void updateSunState() {
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

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(BlockRegistry.emtSolars, 1, 6);
	}
}
