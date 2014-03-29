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
package electricMagicTools.tombenpotter.electricmagictools.common.tile.container;

import ic2.core.IC2;
import ic2.core.slot.SlotInvSlot;

import java.util.List;
import java.util.ListIterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.slot.SlotWandOnly;

public class ContainerIndustrialWandRecharge extends Container
{

	TileEntityIndustrialWandRecharge charger;
	SlotWandOnly wandSlot;

	public ContainerIndustrialWandRecharge(InventoryPlayer invPlayer, TileEntityIndustrialWandRecharge entity)
	{
		this.charger = entity;

		for (int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}

		for (int y = 0; y < 3; y++)
		{
			for (int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}

		this.addSlotToContainer(this.wandSlot = new SlotWandOnly(this, entity, 0, 80, 35));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return charger.isUseableByPlayer(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final ItemStack transferStackInSlot(EntityPlayer player, int sourceSlotIndex) {
		Slot sourceSlot = (Slot) inventorySlots.get(sourceSlotIndex);

		if (sourceSlot != null && sourceSlot.getHasStack())
		{
			ItemStack sourceItemStack = sourceSlot.getStack();
			int oldSourceItemStackSize = sourceItemStack.stackSize;

			if (sourceSlot.inventory == player.inventory)
			{ // player inventory
				// clicked
				// 0: fill input existing stacks, 1: fill input empty stacks, 2:
				// fill existing stacks, 3: fill empty stacks
				for (int run = 0; run < 4 && sourceItemStack.stackSize > 0; run++)
				{
					if (run < 2)
					{
						for (Slot targetSlot : (List<Slot>) inventorySlots)
						{
							if (targetSlot instanceof SlotInvSlot && ((SlotInvSlot) targetSlot).invSlot.canInput() && targetSlot.isItemValid(sourceItemStack))
							{
								if (targetSlot.getStack() != null || run == 1)
								{
									mergeItemStack(sourceItemStack, targetSlot.slotNumber, targetSlot.slotNumber + 1, false);

									if (sourceItemStack.stackSize == 0)
										break;
								}
							}
						}
					} else
					{
						for (Slot targetSlot : (List<Slot>) inventorySlots)
						{
							if (targetSlot.inventory != player.inventory && targetSlot.isItemValid(sourceItemStack))
							{
								if (targetSlot.getStack() != null || run == 3)
								{
									mergeItemStack(sourceItemStack, targetSlot.slotNumber, targetSlot.slotNumber + 1, false);

									if (sourceItemStack.stackSize == 0)
										break;
								}
							}
						}
					}
				}
			} else
			{ // Shift-Click on a GUIslot of the container
				for (int run = 0; run < 2 && sourceItemStack.stackSize > 0; run++)
				{
					for (ListIterator<Slot> it = ((List<Slot>) inventorySlots).listIterator(inventorySlots.size()); it.hasPrevious();)
					{
						Slot targetSlot = it.previous();

						if (targetSlot.inventory == player.inventory && targetSlot.isItemValid(sourceItemStack))
						{
							if (targetSlot.getStack() != null || run == 1)
							{
								mergeItemStack(sourceItemStack, targetSlot.slotNumber, targetSlot.slotNumber + 1, false);

								if (sourceItemStack.stackSize == 0)
									break;
							}
						}
					}
				}
			}

			if (sourceItemStack.stackSize != oldSourceItemStackSize)
			{
				if (sourceItemStack.stackSize == 0)
				{
					sourceSlot.putStack(null);
				} else
				{
					sourceSlot.onPickupFromSlot(player, sourceItemStack);
				}

				// vanilla doesn't fully re-sync after processing the slot click
				// packet,
				// causing a race condition of the client received an old state
				// through packet delay after the slot click
				// this forces a proper sync
				if (IC2.platform.isSimulating())
				{
					detectAndSendChanges();
				}
			}
		}

		return null;
	}
}
