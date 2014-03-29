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
package electricMagicTools.tombenpotter.electricmagictools.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class ItemBlockEMTSolars extends ItemBlock
{

	public ItemBlockEMTSolars(int par1)
	{
		super(par1);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage())
		{
		case 0:
		{
			name = "compressed";
			break;
		}
		case 1:
		{
			name = "doublecompressed";
			break;
		}
		case 2:
		{
			name = "triplecompressed";
			break;
		}
		case 3:
		{
			name = "water";
			break;
		}
		case 4:
		{
			name = "doublewater";
			break;
		}
		case 5:
		{
			name = "triplewater";
			break;
		}
		case 6:
		{
			name = "dark";
			break;
		}
		case 7:
		{
			name = "doubledark";
			break;
		}
		case 8:
		{
			name = "tripledark";
			break;
		}
		case 9:
		{
			name = "order";
			break;
		}
		case 10:
		{
			name = "doubleorder";
			break;
		}
		case 11:
		{
			name = "tripleorder";
			break;
		}
		case 12:
		{
			name = "fire";
			break;
		}
		case 13:
		{
			name = "doublefire";
			break;
		}
		case 14:
		{
			name = "triplefire";
			break;
		}
		case 15:
		{
			name = "air";
			break;
		}
		default:
			name = "nothing";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
		switch (itemstack.getItemDamage())
		{
		case 0:
		{
			list.add(Config.compressedSolarOutput + " EU/T");
			break;
		}
		case 1:
		{
			list.add(Config.doubleCompressedSolarOutput + " EU/T");
			break;
		}
		case 2:
		{
			list.add(Config.tripleCompressedSolarOutput + " EU/T");
			break;
		}
		case 3:
		{
			list.add("Special Effect: " + Config.compressedSolarOutput + " EU/T when raining");
			break;
		}
		case 4:
		{
			list.add("Special Effect: " + Config.doubleCompressedSolarOutput + " EU/T when raining");
			break;
		}
		case 5:
		{
			list.add("Special Effect: " + Config.tripleCompressedSolarOutput + " EU/T when raining");
			break;
		}
		case 6:
		{
			list.add("Special Effect: " + Config.compressedSolarOutput + " EU/T at night");
			break;
		}
		case 7:
		{
			list.add("Special Effect: " + Config.doubleCompressedSolarOutput + " EU/T at night");
			break;
		}
		case 8:
		{
			list.add("Special Effect: " + Config.tripleCompressedSolarOutput + " EU/T at night");
			break;
		}
		case 9:
		{
			list.add("Normal Conditions: " + Config.compressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 3");
			break;
		}
		case 10:
		{
			list.add("Normal Conditions: " + Config.doubleCompressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 3");
			break;
		}

		case 11:
		{
			list.add("Normal Conditions: " + Config.tripleCompressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 3");
			break;
		}
		case 12:
		{
			list.add("Normal Conditions: " + Config.compressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 2 when located in the nether");
			break;
		}
		case 13:
		{
			list.add("Normal Conditions: " + Config.doubleCompressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 2 when located in the nether");
			break;
		}
		case 14:
		{
			list.add("Normal Conditions: " + Config.tripleCompressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 2 when lava is on top");
			list.add("Special Effect: Output multiplied by 2 when located in the nether");
		}
		case 15:
		{
			list.add("Normal Conditions: " + Config.compressedSolarOutput + " EU/T");
			list.add("Special Effect: Output multiplied by 2.5 when the block is over Y = 160");
			break;
		}
		default:
			list.add("Didn't I forget a tooltip?");
			break;
		}
	}
}
