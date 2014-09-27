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
package tombenpotter.emt.proxies;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tombenpotter.emt.client.gui.GuiEtherealMacerator;
import tombenpotter.emt.client.gui.GuiIndustrialWandRecharger;
import tombenpotter.emt.client.gui.container.ContainerEtheralMacerator;
import tombenpotter.emt.client.gui.container.ContainerIndustrialWandRecharge;
import tombenpotter.emt.common.module.ic2.tile.TileEntityEtherealMacerator;
import tombenpotter.emt.common.module.ic2.tile.TileEntityIndustrialWandRecharge;

public class CommonProxy implements IGuiHandler {

    public void load() {
        registerRenders();
    }

    public void registerRenders() {
        /* Empty in base proxy */
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (ID) {
            case 0:
                if (entity != null && entity instanceof TileEntityIndustrialWandRecharge) {
                    return new ContainerIndustrialWandRecharge(player.inventory, (TileEntityIndustrialWandRecharge) entity);
                }
            case 1:
                if (entity != null && entity instanceof TileEntityEtherealMacerator) {
                    return new ContainerEtheralMacerator(player.inventory, (TileEntityEtherealMacerator) entity);
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
                }
            case 1:
                if (entity != null && entity instanceof TileEntityEtherealMacerator) {
                    return new GuiEtherealMacerator(player.inventory, (TileEntityEtherealMacerator) entity);
                }
            default:
                return null;

        }
    }
}
