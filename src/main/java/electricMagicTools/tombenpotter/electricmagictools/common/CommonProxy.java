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
package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import electricMagicTools.tombenpotter.electricmagictools.client.gui.GuiEtherealMacerator;
import electricMagicTools.tombenpotter.electricmagictools.client.gui.GuiIndustrialWandRecharger;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEtherealMacerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.container.ContainerEtheralMacerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.container.ContainerIndustrialWandRecharge;

public class CommonProxy implements IGuiHandler {

	public void load() {
		registerRenders();
	}

	public void registerRenders() {
		/* Empty in common proxy */
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		switch (ID) {
		case 0:
			if (entity != null && entity instanceof TileEntityIndustrialWandRecharge) {
				return new ContainerIndustrialWandRecharge(player.inventory, (TileEntityIndustrialWandRecharge) entity);
			} else {
				return null;
			}

		case 1:
			if (entity != null && entity instanceof TileEntityEtherealMacerator) {
				return new ContainerEtheralMacerator(player.inventory, (TileEntityEtherealMacerator) entity);
			} else {
				return null;
			}
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		switch (ID) {
		case 0:
			if (entity != null && entity instanceof TileEntityIndustrialWandRecharge) {
				return new GuiIndustrialWandRecharger(player.inventory, (TileEntityIndustrialWandRecharge) entity);
			} else {
				return null;
			}

		case 1:
			if (entity != null && entity instanceof TileEntityEtherealMacerator) {
				return new GuiEtherealMacerator(player.inventory, (TileEntityEtherealMacerator) entity);
			} else {
				return null;
			}
		default:
			return null;

		}
	}
}
