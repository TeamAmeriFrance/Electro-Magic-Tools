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
package electricMagicTools.tombenpotter.electricmagictools.common.items.foci;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class ItemChargeFocus extends ItemBaseFocus
{

	private static final AspectList visCost = new AspectList().add(Aspect.FIRE, 10).add(Aspect.WATER, 10).add(Aspect.AIR, 10).add(Aspect.EARTH, 10).add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10);

	public ItemChargeFocus(int id)
	{
		super(id);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:chargefocus");
	}

	@Override
	public int getFocusColor() {
		return 0xFFFF00;
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "CHARGING";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if (wand.consumeAllVis(itemstack, player, getVisCost(), true))
		{
			if (!world.isRemote)
			{

				int energyLeft = Config.chargeFocusProduction;
				for (int i = 0; i < player.inventory.armorInventory.length; i++)
				{
					if (energyLeft > 0)
					{
						if ((player.inventory.armorInventory[i] != null) && ((Item.itemsList[player.inventory.armorInventory[i].itemID] instanceof IElectricItem)))
						{
							int sentPacket = ElectricItem.manager.charge(player.inventory.armorInventory[i], energyLeft, 4, false, false);
							energyLeft -= sentPacket;
						}
					} else
					{
						return itemstack;
					}
				}
				for (int j = 0; j < player.inventory.mainInventory.length; j++)
				{
					if (energyLeft > 0)
					{
						if ((player.inventory.mainInventory[j] != null) && ((Item.itemsList[player.inventory.mainInventory[j].itemID] instanceof IElectricItem)))
						{
							int sentPacket = ElectricItem.manager.charge(player.inventory.mainInventory[j], energyLeft, 4, false, false);
							energyLeft -= sentPacket;
						}
					} else
					{
						return itemstack;
					}
				}
			}
		}
		return itemstack;
	}
}
