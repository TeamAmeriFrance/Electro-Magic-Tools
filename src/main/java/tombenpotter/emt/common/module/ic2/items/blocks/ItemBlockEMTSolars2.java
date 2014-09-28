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

package tombenpotter.emt.common.module.ic2.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.TextHelper;

import java.util.List;

import static tombenpotter.emt.common.util.TextHelper.localize;

public class ItemBlockEMTSolars2 extends ItemBlock {

	public ItemBlockEMTSolars2(Block id) {
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
			case 0: {
				name = "doubleair";
				break;
			}
			case 1: {
				name = "tripleair";
				break;
			}
			case 2: {
				name = "earth";
				break;
			}
			case 3: {
				name = "doubleearth";
				break;
			}
			case 4: {
				name = "tripleearth";
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
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
		switch (itemstack.getItemDamage()) {
			case 0: {
				list.add(TextHelper.BRIGHT_BLUE + localize("tooltip.EMT.normalConditions") + ": " + TextHelper.LIGHT_GRAY + ConfigHandler.doubleCompressedSolarOutput + " " + localize("tooltip.EMT.euPerTick"));
				list.add(TextHelper.BRIGHT_GREEN + localize("tooltip.EMT.specialEffect") + ": " + TextHelper.LIGHT_GRAY + localize("tooltip.EMT.output.double.half") + " " + localize("tooltip.EMT.output.double.half.height"));
				break;
			}
			case 1: {
				list.add(TextHelper.BRIGHT_BLUE + localize("tooltip.EMT.normalConditions") + ": " + TextHelper.LIGHT_GRAY + ConfigHandler.tripleCompressedSolarOutput + " " + localize("tooltip.EMT.euPerTick"));
				list.add(TextHelper.BRIGHT_GREEN + localize("tooltip.EMT.specialEffect") + ": " + TextHelper.LIGHT_GRAY + localize("tooltip.EMT.output.double.half") + " " + localize("tooltip.EMT.output.double.half.height"));
				break;
			}
			case 2: {
				list.add(TextHelper.BRIGHT_BLUE + localize("tooltip.EMT.normalConditions") + ": " + TextHelper.LIGHT_GRAY + ConfigHandler.compressedSolarOutput + " " + localize("tooltip.EMT.euPerTick"));
				list.add(TextHelper.BRIGHT_GREEN + localize("tooltip.EMT.specialEffect") + ": " + TextHelper.LIGHT_GRAY + localize("tooltip.EMT.output.double.half") + " " + localize("tooltip.EMT.output.double.half.low"));
				break;
			}
			case 3: {
				list.add(TextHelper.BRIGHT_BLUE + localize("tooltip.EMT.normalConditions") + ": " + TextHelper.LIGHT_GRAY + ConfigHandler.doubleCompressedSolarOutput + " " + localize("tooltip.EMT.euPerTick"));
				list.add(TextHelper.BRIGHT_GREEN + localize("tooltip.EMT.specialEffect") + ": " + TextHelper.LIGHT_GRAY + localize("tooltip.EMT.output.double.half") + " " + localize("tooltip.EMT.output.double.half.low"));
				break;
			}
			case 4: {
				list.add(TextHelper.BRIGHT_BLUE + localize("tooltip.EMT.normalConditions") + ": " + TextHelper.LIGHT_GRAY + ConfigHandler.tripleCompressedSolarOutput + " " + localize("tooltip.EMT.euPerTick"));
				list.add(TextHelper.BRIGHT_GREEN + localize("tooltip.EMT.specialEffect") + ": " + TextHelper.LIGHT_GRAY + localize("tooltip.EMT.output.double.half") + " " + localize("tooltip.EMT.output.double.half.low"));
				break;
			}
			default: {
				list.add(localize("tooltip.EMT.forget"));
				break;
			}
		}
	}
}
