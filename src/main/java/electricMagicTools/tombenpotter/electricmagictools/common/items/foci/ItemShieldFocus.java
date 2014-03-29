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

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.BlockRegistry;

public class ItemShieldFocus extends ItemBaseFocus
{

	private static final AspectList visCost = new AspectList().add(Aspect.ORDER, 10).add(Aspect.WATER, 10).add(Aspect.AIR, 10);

	public ItemShieldFocus(int id)
	{
		super(id);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:shieldfocus");
	}

	@Override
	public int getFocusColor() {
		return 555555555;
	}

	@Override
	public boolean isUseItem() {
		return true;
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "SHIELD";
	}

	@Override
	public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int time) {
		player.motionX = 0.0D;
		player.motionY = 0.0D;
		player.motionZ = 0.0D;

		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if (wand.consumeAllVis(itemstack, player, getVisCost(), true))
		{
			int x = MathHelper.floor_double(player.posX);
			int y = MathHelper.floor_double(player.posY);
			int z = MathHelper.floor_double(player.posZ);

			if (wand.consumeAllVis(itemstack, player, getVisCost(), true))
			{
				// Player Level
				if (player.worldObj.isAirBlock(x + 1, y, z) && player.worldObj.isAirBlock(x - 1, y, z) && player.worldObj.isAirBlock(x, y, z + 1) && player.worldObj.isAirBlock(x, y, z - 1))
				{
					player.worldObj.setBlock(x + 1, y, z, BlockRegistry.shield.blockID);
					player.worldObj.setBlock(x - 1, y, z, BlockRegistry.shield.blockID);
					player.worldObj.setBlock(x, y, z + 1, BlockRegistry.shield.blockID);
					player.worldObj.setBlock(x, y, z - 1, BlockRegistry.shield.blockID);
				}

				// Above the player
				if (player.worldObj.isAirBlock(x + 1, y + 1, z) && player.worldObj.isAirBlock(x - 1, y + 1, z) && player.worldObj.isAirBlock(x, y + 1, z + 1) && player.worldObj.isAirBlock(x, y + 1, z - 1))
				{
					player.worldObj.setBlock(x + 1, y + 1, z, BlockRegistry.shield.blockID);
					player.worldObj.setBlock(x - 1, y + 1, z, BlockRegistry.shield.blockID);
					player.worldObj.setBlock(x, y + 1, z + 1, BlockRegistry.shield.blockID);
					player.worldObj.setBlock(x, y + 1, z - 1, BlockRegistry.shield.blockID);
				}
			}

		}
	}

	@Override
	public void onPlayerStoppedUsingFocus(ItemStack itemstack, World world, EntityPlayer player, int count) {
		int x = MathHelper.floor_double(player.posX);
		int y = MathHelper.floor_double(player.posY);
		int z = MathHelper.floor_double(player.posZ);

		// Player Level
		if ((player.worldObj.getBlockId(x + 1, y, z) == BlockRegistry.shield.blockID) && (player.worldObj.getBlockId(x - 1, y, z) == BlockRegistry.shield.blockID) && (player.worldObj.getBlockId(x, y, z + 1) == BlockRegistry.shield.blockID) && (player.worldObj.getBlockId(x, y, z - 1) == BlockRegistry.shield.blockID))
		{
			player.worldObj.setBlock(x + 1, y, z, 0);
			player.worldObj.setBlock(x - 1, y, z, 0);
			player.worldObj.setBlock(x, y, z + 1, 0);
			player.worldObj.setBlock(x, y, z - 1, 0);
		}

		// Above the player
		if ((player.worldObj.getBlockId(x + 1, y + 1, z) == BlockRegistry.shield.blockID) && (player.worldObj.getBlockId(x - 1, y + 1, z) == BlockRegistry.shield.blockID) && (player.worldObj.getBlockId(x, y + 1, z + 1) == BlockRegistry.shield.blockID) && (player.worldObj.getBlockId(x, y + 1, z - 1) == BlockRegistry.shield.blockID))
		{
			player.worldObj.setBlock(x + 1, y + 1, z, 0);
			player.worldObj.setBlock(x - 1, y + 1, z, 0);
			player.worldObj.setBlock(x, y + 1, z + 1, 0);
			player.worldObj.setBlock(x, y + 1, z - 1, 0);
		}

		ItemStack milk = (new ItemStack(Item.bucketMilk));
		player.curePotionEffects(milk);
	}
}
