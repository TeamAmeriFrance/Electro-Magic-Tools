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

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityAirSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDarkSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleDarkSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleFireSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleOrderSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleWaterSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityFireSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityOrderSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleDarkSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleFireSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleOrderSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleWaterSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityWaterSolar;

public class BlockEMTSolars extends BlockContainer {

	public IIcon[] compressedSolar = new IIcon[3];
	public IIcon[] doubleCompressedSolar = new IIcon[3];
	public IIcon[] tripleCompressedSolar = new IIcon[3];
	public IIcon[] waterSolar = new IIcon[3];
	public IIcon[] doubleWaterSolar = new IIcon[3];
	public IIcon[] tripleWaterSolar = new IIcon[3];
	public IIcon[] darkSolar = new IIcon[3];
	public IIcon[] doubleDarkSolar = new IIcon[3];
	public IIcon[] tripleDarkSolar = new IIcon[3];
	public IIcon[] orderSolar = new IIcon[3];
	public IIcon[] doubleOrderSolar = new IIcon[3];
	public IIcon[] tripleOrderSolar = new IIcon[3];
	public IIcon[] fireSolar = new IIcon[3];
	public IIcon[] doubleFireSolar = new IIcon[3];
	public IIcon[] tripleFireSolar = new IIcon[3];
	public IIcon[] airSolar = new IIcon[3];

	public BlockEMTSolars() {
		super(Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ri) {
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
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
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
	public IIcon getIcon(int side, int meta) {
		if (meta == 0) {
			if (side == 1) {
				return this.compressedSolar[0];
			}
			if (side > 1) {
				return this.compressedSolar[1];
			}
		}

		if (meta == 1) {
			if (side == 1) {
				return this.doubleCompressedSolar[0];
			}
			if (side > 1) {
				return this.doubleCompressedSolar[1];
			}
		}

		if (meta == 2) {
			if (side == 1) {
				return this.tripleCompressedSolar[0];
			}
			if (side > 1) {
				return this.tripleCompressedSolar[1];
			}
		}

		if (meta == 3) {
			if (side == 0) {
				return this.waterSolar[2];
			}
			if (side == 1) {
				return this.waterSolar[0];
			}
			if (side > 1) {
				return this.waterSolar[1];
			}
		}

		if (meta == 4) {
			if (side == 0) {
				return this.doubleWaterSolar[2];
			}
			if (side == 1) {
				return this.doubleWaterSolar[0];
			}
			if (side > 1) {
				return this.doubleWaterSolar[1];
			}
		}

		if (meta == 5) {
			if (side == 0) {
				return this.tripleWaterSolar[2];
			}
			if (side == 1) {
				return this.tripleWaterSolar[0];
			}
			if (side > 1) {
				return this.tripleWaterSolar[1];
			}
		}

		if (meta == 6) {
			if (side == 0) {
				return this.darkSolar[2];
			}
			if (side == 1) {
				return this.darkSolar[0];
			}
			if (side > 1) {
				return this.darkSolar[1];
			}
		}

		if (meta == 7) {
			if (side == 0) {
				return this.doubleDarkSolar[2];
			}
			if (side == 1) {
				return this.doubleDarkSolar[0];
			}
			if (side > 1) {
				return this.doubleDarkSolar[1];
			}
		}

		if (meta == 8) {
			if (side == 0) {
				return this.tripleDarkSolar[2];
			}
			if (side == 1) {
				return this.tripleDarkSolar[0];
			}
			if (side > 1) {
				return this.tripleDarkSolar[1];
			}
		}

		if (meta == 9) {
			if (side == 0) {
				return this.orderSolar[2];
			}
			if (side == 1) {
				return this.orderSolar[0];
			}
			if (side > 1) {
				return this.orderSolar[1];
			}
		}

		if (meta == 10) {
			if (side == 0) {
				return this.doubleOrderSolar[2];
			}
			if (side == 1) {
				return this.doubleOrderSolar[0];
			}
			if (side > 1) {
				return this.doubleOrderSolar[1];
			}
		}

		if (meta == 11) {
			if (side == 0) {
				return this.tripleOrderSolar[2];
			}
			if (side == 1) {
				return this.tripleOrderSolar[0];
			}
			if (side > 1) {
				return this.tripleOrderSolar[1];
			}
		}

		if (meta == 12) {
			if (side == 0) {
				return this.fireSolar[2];
			}
			if (side == 1) {
				return this.fireSolar[0];
			}
			if (side > 1) {
				return this.fireSolar[1];
			}
		}

		if (meta == 13) {
			if (side == 0) {
				return this.doubleFireSolar[2];
			}
			if (side == 1) {
				return this.doubleFireSolar[0];
			}
			if (side > 1) {
				return this.doubleFireSolar[1];
			}
		}

		if (meta == 14) {
			if (side == 0) {
				return this.tripleFireSolar[2];
			}
			if (side == 1) {
				return this.tripleFireSolar[0];
			}
			if (side > 1) {
				return this.tripleFireSolar[1];
			}
		}

		if (meta == 15) {
			if (side == 0) {
				return this.airSolar[2];
			}
			if (side == 1) {
				return this.airSolar[0];
			}
			if (side > 1) {
				return this.airSolar[1];
			}
		}
		return this.compressedSolar[2];
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0) {
			return new TileEntityCompressedSolar();
		}
		if (meta == 1) {
			return new TileEntityDoubleCompressedSolar();
		}
		if (meta == 2) {
			return new TileEntityTripleCompressedSolar();
		}
		if (meta == 3) {
			return new TileEntityWaterSolar();
		}
		if (meta == 4) {
			return new TileEntityDoubleWaterSolar();
		}
		if (meta == 5) {
			return new TileEntityTripleWaterSolar();
		}
		if (meta == 6) {
			return new TileEntityDarkSolar();
		}
		if (meta == 7) {
			return new TileEntityDoubleDarkSolar();
		}
		if (meta == 8) {
			return new TileEntityTripleDarkSolar();
		}
		if (meta == 9) {
			return new TileEntityOrderSolar();
		}
		if (meta == 10) {
			return new TileEntityDoubleOrderSolar();
		}
		if (meta == 11) {
			return new TileEntityTripleOrderSolar();
		}
		if (meta == 12) {
			return new TileEntityFireSolar();
		}
		if (meta == 13) {
			return new TileEntityDoubleFireSolar();
		}
		if (meta == 14) {
			return new TileEntityTripleFireSolar();
		}
		if (meta == 15) {
			return new TileEntityAirSolar();
		}

		return super.createTileEntity(world, meta);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		world.removeTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
}
