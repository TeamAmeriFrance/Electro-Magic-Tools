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

import ic2.api.energy.prefab.BasicSink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.common.network.PacketDispatcher;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class TileEntityIndustrialWandRecharge extends TileEntity implements IInventory
{
	private BasicSink ic2EnergySink = new BasicSink(this, 100000, 4);

	ItemStack ItemStacks[];

	public TileEntityIndustrialWandRecharge()
	{
		ItemStacks = new ItemStack[1];
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return ItemStacks[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (ItemStacks[i] != null)
		{

			if (ItemStacks[i].stackSize <= j)
			{
				ItemStack itemstack = ItemStacks[i];
				ItemStacks[i] = null;
				return itemstack;
			} else
			{
				ItemStack itemstack1 = ItemStacks[i].splitStack(j);

				if (ItemStacks[i].stackSize == 0)
				{
					ItemStacks[i] = null;
				}

				return itemstack1;
			}
		} else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (ItemStacks[i] != null)
		{
			ItemStack itemstack = ItemStacks[i];
			ItemStacks[i] = null;
			return itemstack;
		} else
		{
			return null;
		}
	}

	@Override
	public void updateEntity() {
		ic2EnergySink.updateEntity();
		if (!this.worldObj.isRemote)
		{
			if (getStackInSlot(0) != null)
			{

				ItemStack wand = getStackInSlot(0);

				if (ic2EnergySink.useEnergy(Config.wandChargerConsumption))
				{
					if (wand != null && wand.getItem() instanceof ItemWandCasting)
					{
						ItemWandCasting wandItem = (ItemWandCasting) wand.getItem();
						wandItem.addVis(wand, Aspect.ORDER, 1, true);
						wandItem.addVis(wand, Aspect.FIRE, 1, true);
						wandItem.addVis(wand, Aspect.ENTROPY, 1, true);
						wandItem.addVis(wand, Aspect.WATER, 1, true);
						wandItem.addVis(wand, Aspect.EARTH, 1, true);
						wandItem.addVis(wand, Aspect.AIR, 1, true);
					}
				}
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		ItemStacks[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "Industrial Wand Charging Station";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public void openChest() {

	}

	@Override
	public void closeChest() {

	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		ic2EnergySink.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < ItemStacks.length)
			{
				ItemStacks[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		ic2EnergySink.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < ItemStacks.length; i++)
		{
			ItemStack stack = ItemStacks[i];
			if (stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		writeToNBT(nbttagcompound);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, -999, nbttagcompound);
	}

	@Override
	public void onDataPacket(INetworkManager manager, Packet132TileEntityData packet) {
		super.onDataPacket(manager, packet);
		readFromNBT(packet.data);
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		if (!worldObj.isRemote)
		{
			PacketDispatcher.sendPacketToAllInDimension(getDescriptionPacket(), worldObj.provider.dimensionId);
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
		{
			return false;
		}

		return player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	@Override
	public void invalidate() {
		ic2EnergySink.invalidate();
		super.invalidate();
	}

	@Override
	public void onChunkUnload() {
		ic2EnergySink.onChunkUnload();
	}
}
