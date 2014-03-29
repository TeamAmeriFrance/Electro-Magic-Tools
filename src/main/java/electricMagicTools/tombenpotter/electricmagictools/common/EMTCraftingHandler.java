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
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.ICraftingHandler;

public class EMTCraftingHandler implements ICraftingHandler
{

	@SuppressWarnings("unused")
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {

		ItemStack taintedhammer = new ItemStack(ItemRegistry.taintedThorHammer).copy();

		for (int i = 0; i < craftMatrix.getSizeInventory(); i++)
		{
			if (craftMatrix.getStackInSlot(i) != null)
			{
				ItemStack itemstack = craftMatrix.getStackInSlot(i);
				if ((itemstack != null) && (itemstack.itemID == new ItemStack(ItemRegistry.taintedThorHammer, 1, OreDictionary.WILDCARD_VALUE).itemID))
				{
					ItemStack newitemstack = new ItemStack(ItemRegistry.taintedThorHammer, 2, itemstack.getItemDamage() + 1);
					if (newitemstack.getItemDamage() >= newitemstack.getMaxDamage())
					{
						newitemstack.stackSize -= 1;
					}
					craftMatrix.setInventorySlotContents(i, newitemstack);
					break;
				}
			}
		}

		for (int i = 0; i < craftMatrix.getSizeInventory(); i++)
		{
			if (craftMatrix.getStackInSlot(i) != null)
			{
				ItemStack itemstack = craftMatrix.getStackInSlot(i);
				if ((itemstack != null) && (itemstack.itemID == new ItemStack(ItemRegistry.thorHammer, 1, OreDictionary.WILDCARD_VALUE).itemID))
				{
					ItemStack newitemstack = new ItemStack(ItemRegistry.thorHammer, 2, itemstack.getItemDamage() + 1);
					if (newitemstack.getItemDamage() >= newitemstack.getMaxDamage())
					{
						newitemstack.stackSize -= 1;
					}
					craftMatrix.setInventorySlotContents(i, newitemstack);
					break;
				}
			}
		}

		for (int i = 0; i < craftMatrix.getSizeInventory(); i++)
		{
			if (craftMatrix.getStackInSlot(i) != null)
			{
				ItemStack itemstack = craftMatrix.getStackInSlot(i);
				if ((itemstack != null) && (itemstack.itemID == new ItemStack(ItemRegistry.electricThorHammer, 1, OreDictionary.WILDCARD_VALUE).itemID))
				{
					ItemStack newitemstack = new ItemStack(ItemRegistry.electricThorHammer, 2, itemstack.getItemDamage() + 1);
					if (newitemstack.getItemDamage() >= newitemstack.getMaxDamage())
					{
						newitemstack.stackSize -= 1;
					}
					craftMatrix.setInventorySlotContents(i, newitemstack);
					break;
				}
			}
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	}

}
