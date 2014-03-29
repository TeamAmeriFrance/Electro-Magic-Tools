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
package electricMagicTools.tombenpotter.electricmagictools.common.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAirSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDarkSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleDarkSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleFireSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleOrderSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleWaterSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityFireSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityOrderSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleDarkSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleFireSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleOrderSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityTripleWaterSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityWaterSolar;

public class BlockEMTSolars extends BlockContainer
{

	public Icon[] compressedSolar = new Icon[3];
	public Icon[] doubleCompressedSolar = new Icon[3];
	public Icon[] tripleCompressedSolar = new Icon[3];
	public Icon[] waterSolar = new Icon[3];
	public Icon[] doubleWaterSolar = new Icon[3];
	public Icon[] tripleWaterSolar = new Icon[3];
	public Icon[] darkSolar = new Icon[3];
	public Icon[] doubleDarkSolar = new Icon[3];
	public Icon[] tripleDarkSolar = new Icon[3];
	public Icon[] orderSolar = new Icon[3];
	public Icon[] doubleOrderSolar = new Icon[3];
	public Icon[] tripleOrderSolar = new Icon[3];
	public Icon[] fireSolar = new Icon[3];
	public Icon[] doubleFireSolar = new Icon[3];
	public Icon[] tripleFireSolar = new Icon[3];
	public Icon[] airSolar = new Icon[3];

	public BlockEMTSolars(int id)
	{
		super(id, Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ri) {
		this.compressedSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.compressedSolar[1] = ri.registerIcon("electricmagictools:solars/side");
		this.compressedSolar[2] = ri.registerIcon("electricmagictools:solars/bottom");

		this.doubleCompressedSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleCompressedSolar[1] = ri.registerIcon("electricmagictools:solars/side");
		this.doubleCompressedSolar[2] = ri.registerIcon("electricmagictools:solars/bottom");

		this.tripleCompressedSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleCompressedSolar[1] = ri.registerIcon("electricmagictools:solars/side");
		this.tripleCompressedSolar[2] = ri.registerIcon("electricmagictools:solars/bottom");

		this.waterSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.waterSolar[1] = ri.registerIcon("electricmagictools:solars/waterside");
		this.waterSolar[2] = ri.registerIcon("electricmagictools:solars/waterbottom");

		this.doubleWaterSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleWaterSolar[1] = ri.registerIcon("electricmagictools:solars/waterside");
		this.doubleWaterSolar[2] = ri.registerIcon("electricmagictools:solars/waterbottom");

		this.tripleWaterSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleWaterSolar[1] = ri.registerIcon("electricmagictools:solars/waterside");
		this.tripleWaterSolar[2] = ri.registerIcon("electricmagictools:solars/waterbottom");

		this.darkSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.darkSolar[1] = ri.registerIcon("electricmagictools:solars/darkside");
		this.darkSolar[2] = ri.registerIcon("electricmagictools:solars/darkbottom");

		this.doubleDarkSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleDarkSolar[1] = ri.registerIcon("electricmagictools:solars/darkside");
		this.doubleDarkSolar[2] = ri.registerIcon("electricmagictools:solars/darkbottom");

		this.tripleDarkSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleDarkSolar[1] = ri.registerIcon("electricmagictools:solars/darkside");
		this.tripleDarkSolar[2] = ri.registerIcon("electricmagictools:solars/darkbottom");

		this.orderSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.orderSolar[1] = ri.registerIcon("electricmagictools:solars/orderside");
		this.orderSolar[2] = ri.registerIcon("electricmagictools:solars/orderbottom");

		this.doubleOrderSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleOrderSolar[1] = ri.registerIcon("electricmagictools:solars/orderside");
		this.doubleOrderSolar[2] = ri.registerIcon("electricmagictools:solars/orderbottom");

		this.tripleOrderSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleOrderSolar[1] = ri.registerIcon("electricmagictools:solars/orderside");
		this.tripleOrderSolar[2] = ri.registerIcon("electricmagictools:solars/orderbottom");

		this.fireSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.fireSolar[1] = ri.registerIcon("electricmagictools:solars/fireside");
		this.fireSolar[2] = ri.registerIcon("electricmagictools:solars/firebottom");

		this.doubleFireSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleFireSolar[1] = ri.registerIcon("electricmagictools:solars/fireside");
		this.doubleFireSolar[2] = ri.registerIcon("electricmagictools:solars/firebottom");

		this.tripleFireSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleFireSolar[1] = ri.registerIcon("electricmagictools:solars/fireside");
		this.tripleFireSolar[2] = ri.registerIcon("electricmagictools:solars/firebottom");

		this.airSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.airSolar[1] = ri.registerIcon("electricmagictools:solars/airside");
		this.airSolar[2] = ri.registerIcon("electricmagictools:solars/airbottom");
	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
		list.add(new ItemStack(id, 1, 2));
		list.add(new ItemStack(id, 1, 3));
		list.add(new ItemStack(id, 1, 4));
		list.add(new ItemStack(id, 1, 5));
		list.add(new ItemStack(id, 1, 6));
		list.add(new ItemStack(id, 1, 7));
		list.add(new ItemStack(id, 1, 8));
		list.add(new ItemStack(id, 1, 9));
		list.add(new ItemStack(id, 1, 10));
		list.add(new ItemStack(id, 1, 11));
		list.add(new ItemStack(id, 1, 12));
		list.add(new ItemStack(id, 1, 13));
		list.add(new ItemStack(id, 1, 14));
		list.add(new ItemStack(id, 1, 15));
	}

	@Override
	public Icon getIcon(int side, int meta) {
		if (meta == 0)
		{
			if (side == 1)
			{
				return this.compressedSolar[0];
			}
			if (side > 1)
			{
				return this.compressedSolar[1];
			}
		}

		if (meta == 1)
		{
			if (side == 1)
			{
				return this.doubleCompressedSolar[0];
			}
			if (side > 1)
			{
				return this.doubleCompressedSolar[1];
			}
		}

		if (meta == 2)
		{
			if (side == 1)
			{
				return this.tripleCompressedSolar[0];
			}
			if (side > 1)
			{
				return this.tripleCompressedSolar[1];
			}
		}

		if (meta == 3)
		{
			if (side == 0)
			{
				return this.waterSolar[2];
			}
			if (side == 1)
			{
				return this.waterSolar[0];
			}
			if (side > 1)
			{
				return this.waterSolar[1];
			}
		}

		if (meta == 4)
		{
			if (side == 0)
			{
				return this.doubleWaterSolar[2];
			}
			if (side == 1)
			{
				return this.doubleWaterSolar[0];
			}
			if (side > 1)
			{
				return this.doubleWaterSolar[1];
			}
		}

		if (meta == 5)
		{
			if (side == 0)
			{
				return this.tripleWaterSolar[2];
			}
			if (side == 1)
			{
				return this.tripleWaterSolar[0];
			}
			if (side > 1)
			{
				return this.tripleWaterSolar[1];
			}
		}

		if (meta == 6)
		{
			if (side == 0)
			{
				return this.darkSolar[2];
			}
			if (side == 1)
			{
				return this.darkSolar[0];
			}
			if (side > 1)
			{
				return this.darkSolar[1];
			}
		}

		if (meta == 7)
		{
			if (side == 0)
			{
				return this.doubleDarkSolar[2];
			}
			if (side == 1)
			{
				return this.doubleDarkSolar[0];
			}
			if (side > 1)
			{
				return this.doubleDarkSolar[1];
			}
		}

		if (meta == 8)
		{
			if (side == 0)
			{
				return this.tripleDarkSolar[2];
			}
			if (side == 1)
			{
				return this.tripleDarkSolar[0];
			}
			if (side > 1)
			{
				return this.tripleDarkSolar[1];
			}
		}

		if (meta == 9)
		{
			if (side == 0)
			{
				return this.orderSolar[2];
			}
			if (side == 1)
			{
				return this.orderSolar[0];
			}
			if (side > 1)
			{
				return this.orderSolar[1];
			}
		}

		if (meta == 10)
		{
			if (side == 0)
			{
				return this.doubleOrderSolar[2];
			}
			if (side == 1)
			{
				return this.doubleOrderSolar[0];
			}
			if (side > 1)
			{
				return this.doubleOrderSolar[1];
			}
		}

		if (meta == 11)
		{
			if (side == 0)
			{
				return this.tripleOrderSolar[2];
			}
			if (side == 1)
			{
				return this.tripleOrderSolar[0];
			}
			if (side > 1)
			{
				return this.tripleOrderSolar[1];
			}
		}

		if (meta == 12)
		{
			if (side == 0)
			{
				return this.fireSolar[2];
			}
			if (side == 1)
			{
				return this.fireSolar[0];
			}
			if (side > 1)
			{
				return this.fireSolar[1];
			}
		}

		if (meta == 13)
		{
			if (side == 0)
			{
				return this.doubleFireSolar[2];
			}
			if (side == 1)
			{
				return this.doubleFireSolar[0];
			}
			if (side > 1)
			{
				return this.doubleFireSolar[1];
			}
		}

		if (meta == 14)
		{
			if (side == 0)
			{
				return this.tripleFireSolar[2];
			}
			if (side == 1)
			{
				return this.tripleFireSolar[0];
			}
			if (side > 1)
			{
				return this.tripleFireSolar[1];
			}
		}

		if (meta == 15)
		{
			if (side == 0)
			{
				return this.airSolar[2];
			}
			if (side == 1)
			{
				return this.airSolar[0];
			}
			if (side > 1)
			{
				return this.airSolar[1];
			}
		}
		return this.compressedSolar[2];
	}

	@Override
	public Icon getBlockTexture(IBlockAccess access, int i, int j, int k, int side) {
		return super.getBlockTexture(access, i, j, k, side);
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0)
		{
			return new TileEntityCompressedSolar();
		}
		if (meta == 1)
		{
			return new TileEntityDoubleCompressedSolar();
		}
		if (meta == 2)
		{
			return new TileEntityTripleCompressedSolar();
		}
		if (meta == 3)
		{
			return new TileEntityWaterSolar();
		}
		if (meta == 4)
		{
			return new TileEntityDoubleWaterSolar();
		}
		if (meta == 5)
		{
			return new TileEntityTripleWaterSolar();
		}
		if (meta == 6)
		{
			return new TileEntityDarkSolar();
		}
		if (meta == 7)
		{
			return new TileEntityDoubleDarkSolar();
		}
		if (meta == 8)
		{
			return new TileEntityTripleDarkSolar();
		}
		if (meta == 9)
		{
			return new TileEntityOrderSolar();
		}
		if (meta == 10)
		{
			return new TileEntityDoubleOrderSolar();
		}
		if (meta == 11)
		{
			return new TileEntityTripleOrderSolar();
		}
		if (meta == 12)
		{
			return new TileEntityFireSolar();
		}
		if (meta == 13)
		{
			return new TileEntityDoubleFireSolar();
		}
		if (meta == 14)
		{
			return new TileEntityTripleFireSolar();
		}
		if (meta == 15)
		{
			return new TileEntityAirSolar();
		}

		return super.createTileEntity(world, meta);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		world.removeBlockTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}
}
