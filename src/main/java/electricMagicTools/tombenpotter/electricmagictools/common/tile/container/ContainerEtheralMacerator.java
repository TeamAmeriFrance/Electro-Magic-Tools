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
import net.minecraft.tileentity.TileEntity;
import thaumcraft.common.container.SlotOutput;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEtherealMacerator;

public class ContainerEtheralMacerator extends Container {

	TileEntityEtherealMacerator te;

	public ContainerEtheralMacerator(InventoryPlayer inventory, TileEntity te) {
		this.te = ((TileEntityEtherealMacerator) te);
		addSlotToContainer(new Slot(this.te, 0, 56, 26));
		addSlotToContainer(new SlotOutput(this.te, 2, 116, 26));
		addSlotToContainer(new SlotOutput(this.te, 1, 116, 53));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUseableByPlayer(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final ItemStack transferStackInSlot(EntityPlayer player, int sourceSlotIndex) {
		Slot sourceSlot = (Slot) inventorySlots.get(sourceSlotIndex);

		if (sourceSlot != null && sourceSlot.getHasStack()) {
			ItemStack sourceItemStack = sourceSlot.getStack();
			int oldSourceItemStackSize = sourceItemStack.stackSize;

			if (sourceSlot.inventory == player.inventory) { // player inventory
															// clicked
															// 0: fill input existing stacks, 1: fill input empty stacks, 2:
															// fill existing stacks, 3: fill empty stacks
				for (int run = 0; run < 4 && sourceItemStack.stackSize > 0; run++) {
					if (run < 2) {
						for (Slot targetSlot : (List<Slot>) inventorySlots) {
							if (targetSlot instanceof SlotInvSlot && ((SlotInvSlot) targetSlot).invSlot.canInput() && targetSlot.isItemValid(sourceItemStack)) {
								if (targetSlot.getStack() != null || run == 1) {
									mergeItemStack(sourceItemStack, targetSlot.slotNumber, targetSlot.slotNumber + 1, false);

									if (sourceItemStack.stackSize == 0)
										break;
								}
							}
						}
					} else {
						for (Slot targetSlot : (List<Slot>) inventorySlots) {
							if (targetSlot.inventory != player.inventory && targetSlot.isItemValid(sourceItemStack)) {
								if (targetSlot.getStack() != null || run == 3) {
									mergeItemStack(sourceItemStack, targetSlot.slotNumber, targetSlot.slotNumber + 1, false);

									if (sourceItemStack.stackSize == 0)
										break;
								}
							}
						}
					}
				}
			} else { // Shift-Click on a GUIslot of the container
				for (int run = 0; run < 2 && sourceItemStack.stackSize > 0; run++) {
					for (ListIterator<Slot> it = ((List<Slot>) inventorySlots).listIterator(inventorySlots.size()); it.hasPrevious();) {
						Slot targetSlot = it.previous();

						if (targetSlot.inventory == player.inventory && targetSlot.isItemValid(sourceItemStack)) {
							if (targetSlot.getStack() != null || run == 1) {
								mergeItemStack(sourceItemStack, targetSlot.slotNumber, targetSlot.slotNumber + 1, false);

								if (sourceItemStack.stackSize == 0)
									break;
							}
						}
					}
				}
			}

			if (sourceItemStack.stackSize != oldSourceItemStackSize) {
				if (sourceItemStack.stackSize == 0) {
					sourceSlot.putStack(null);
				} else {
					sourceSlot.onPickupFromSlot(player, sourceItemStack);
				}

				// vanilla doesn't fully re-sync after processing the slot click
				// packet,
				// causing a race condition of the client received an old state
				// through packet delay after the slot click
				// this forces a proper sync
				if (IC2.platform.isSimulating()) {
					detectAndSendChanges();
				}
			}
		}

		return null;
	}
}
