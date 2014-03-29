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

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemEMTItems extends Item
{

	public Icon[] icon = new Icon[16];

	public ItemEMTItems(int id)
	{
		super(id);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(0);
		this.setMaxStackSize(64);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage())
		{
		case 0:
		{
			name = "oreClusterUranium";
			break;
		}
		case 1:
		{
			name = "crushedOreAmber";
			break;
		}
		case 2:
		{
			name = "purifiedOreAmber";
			break;
		}
		case 3:
		{
			name = "crushedOreCinnabar";
			break;
		}
		case 4:
		{
			name = "purifiedOreCinnabar";
			break;
		}
		default:
			name = "nothing";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ri) {
		this.icon[0] = ri.registerIcon("electricmagictools:clusteruranium");
		this.icon[1] = ri.registerIcon("electricmagictools:crushedamber");
		this.icon[2] = ri.registerIcon("electricmagictools:purifiedamber");
		this.icon[3] = ri.registerIcon("electricmagictools:crushedcinnabar");
		this.icon[4] = ri.registerIcon("electricmagictools:purifiedcinnabar");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {
		return this.icon[meta];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tabs, List list) {
		// list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
		list.add(new ItemStack(this, 1, 2));
		list.add(new ItemStack(this, 1, 3));
		list.add(new ItemStack(this, 1, 4));
	}
}
