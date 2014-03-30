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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.lib.EssentiaHandler;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class TileEntityAuramGenerator extends TileEntity
{
	int x;
	int y;
	int z;
	public ForgeDirection orientation;
	public static int waitTime;
	private BasicSource energySource = new BasicSource(this, 1000000000, 3);

	public TileEntityAuramGenerator()
	{
		orientation = ForgeDirection.getOrientation(1);
		waitTime = 30;
	}

	@Override
	public void updateEntity() {
		energySource.updateEntity();

		if (waitTime > 0)
		{
			waitTime--;
		}

		if (waitTime <= 0)
		{
			if ((!this.worldObj.isRemote) && (EssentiaHandler.drainEssentia(this, Aspect.AURA, ForgeDirection.UNKNOWN, 8)))
			{
				energySource.addEnergy(Config.auramGenOutput);
			}
			waitTime = Config.essentiaGeneratorsDelay;
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
