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

package tombenpotter.emt.common.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.module.ic2.IC2ModuleItemRegistry;

public class CreativeTabEMT extends CreativeTabs {

	public CreativeTabEMT(String tabLabel) {
		super(tabLabel);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(IC2ModuleItemRegistry.thorHammer);
	}

	@Override
	public Item getTabIconItem() { return new Item(); }
}
