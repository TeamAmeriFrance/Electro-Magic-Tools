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
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleAirSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityDoubleEarthSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityEarthSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleAirSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.solars.TileEntityTripleEarthSolar;

public class BlockEMTSolars2 extends BlockContainer {

	public IIcon[] compressedSolar = new IIcon[3];
	public IIcon[] doubleAirSolar = new IIcon[3];
	public IIcon[] tripleAirSolar = new IIcon[3];
	public IIcon[] earthSolar = new IIcon[3];
	public IIcon[] doubleEarthSolar = new IIcon[3];
	public IIcon[] tripleEarthSolar = new IIcon[3];

	public BlockEMTSolars2() {
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

		this.doubleAirSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleAirSolar[1] = ri.registerIcon("electricmagictools:solars/airside");
		this.doubleAirSolar[2] = ri.registerIcon("electricmagictools:solars/airbottom");

		this.tripleAirSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleAirSolar[1] = ri.registerIcon("electricmagictools:solars/airside");
		this.tripleAirSolar[2] = ri.registerIcon("electricmagictools:solars/airbottom");

		this.earthSolar[0] = ri.registerIcon("electricmagictools:solars/solartop");
		this.earthSolar[1] = ri.registerIcon("electricmagictools:solars/earthside");
		this.earthSolar[2] = ri.registerIcon("electricmagictools:solars/earthbottom");

		this.doubleEarthSolar[0] = ri.registerIcon("electricmagictools:solars/doublesolartop");
		this.doubleEarthSolar[1] = ri.registerIcon("electricmagictools:solars/earthside");
		this.doubleEarthSolar[2] = ri.registerIcon("electricmagictools:solars/earthbottom");

		this.tripleEarthSolar[0] = ri.registerIcon("electricmagictools:solars/triplesolartop");
		this.tripleEarthSolar[1] = ri.registerIcon("electricmagictools:solars/earthside");
		this.tripleEarthSolar[2] = ri.registerIcon("electricmagictools:solars/earthbottom");
	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
		list.add(new ItemStack(id, 1, 2));
		list.add(new ItemStack(id, 1, 3));
		list.add(new ItemStack(id, 1, 4));

	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta == 0) {
			if (side == 1) {
				return this.doubleAirSolar[0];
			}
			if (side > 1) {
				return this.doubleAirSolar[1];
			}
		}

		if (meta == 1) {
			if (side == 1) {
				return this.tripleAirSolar[0];
			}
			if (side > 1) {
				return this.tripleAirSolar[1];
			}
		}

		if (meta == 2) {
			if (side == 1) {
				return this.earthSolar[0];
			}
			if (side > 1) {
				return this.earthSolar[1];
			}
		}

		if (meta == 3) {
			if (side == 1) {
				return this.doubleEarthSolar[0];
			}
			if (side > 1) {
				return this.doubleEarthSolar[1];
			}
		}

		if (meta == 4) {
			if (side == 1) {
				return this.tripleEarthSolar[0];
			}
			if (side > 1) {
				return this.tripleEarthSolar[1];
			}
		}
		return this.compressedSolar[2];
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0) {
			return new TileEntityDoubleAirSolar();
		}
		if (meta == 1) {
			return new TileEntityTripleAirSolar();
		}
		if (meta == 2) {
			return new TileEntityEarthSolar();
		}
		if (meta == 3) {
			return new TileEntityDoubleEarthSolar();
		}
		if (meta == 4) {
			return new TileEntityTripleEarthSolar();
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
		// TODO Auto-generated method stub
		return null;
	}
}
