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

package tombenpotter.emt.common.module.ic2.tile.solars.fire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.module.ic2.IC2ModuleBlockRegistry;
import tombenpotter.emt.common.module.ic2.tile.solars.TileEntitySolarBase;
import tombenpotter.emt.common.util.ConfigHandler;

public class TileEntityFireSolar extends TileEntitySolarBase {

	public TileEntityFireSolar() {
		output = ConfigHandler.compressedSolarOutput;
	}

	@Override
	public void checkConditions() {
		if (!initialized && worldObj != null) {
			canRain = worldObj.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
			initialized = true;
		}

		if (worldObj.provider.dimensionId == -1) {
			energySource.addEnergy(output * 2);
		} else {
			if (tick-- == 0) {
				updateSunState();
				tick = 64;
			}
		}
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(IC2ModuleBlockRegistry.emtSolars, 1, 12);
	}
}
