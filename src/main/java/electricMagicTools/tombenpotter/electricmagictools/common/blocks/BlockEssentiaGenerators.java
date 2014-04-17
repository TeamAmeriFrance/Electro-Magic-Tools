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
import java.util.Random;

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
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityArborGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAuramGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIgnisGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPotentiaGenerator;

public class BlockEssentiaGenerators extends BlockContainer {

	public IIcon[] potentiaGen = new IIcon[3];
	public IIcon[] ignisGen = new IIcon[3];
	public IIcon[] auramGen = new IIcon[3];
	public IIcon[] arborGen = new IIcon[3];
	public IIcon[] saxumGen = new IIcon[3];

	public BlockEssentiaGenerators() {
		super(Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ri) {
		this.potentiaGen[0] = ri.registerIcon("electricmagictools:essentiagenerator/potentiafront");
		this.potentiaGen[1] = ri.registerIcon("electricmagictools:essentiagenerator/side");
		this.potentiaGen[2] = ri.registerIcon("electricmagictools:essentiagenerator/top");

		this.ignisGen[0] = ri.registerIcon("electricmagictools:essentiagenerator/ignisfront");
		this.ignisGen[1] = ri.registerIcon("electricmagictools:essentiagenerator/side");
		this.ignisGen[2] = ri.registerIcon("electricmagictools:essentiagenerator/top");

		this.auramGen[0] = ri.registerIcon("electricmagictools:essentiagenerator/auramfront");
		this.auramGen[1] = ri.registerIcon("electricmagictools:essentiagenerator/side");
		this.auramGen[2] = ri.registerIcon("electricmagictools:essentiagenerator/top");

		this.arborGen[0] = ri.registerIcon("electricmagictools:essentiagenerator/arborfront");
		this.arborGen[1] = ri.registerIcon("electricmagictools:essentiagenerator/side");
		this.arborGen[2] = ri.registerIcon("electricmagictools:essentiagenerator/top");

		this.saxumGen[0] = ri.registerIcon("electricmagictools:essentiagenerator/saxumfront");
		this.saxumGen[1] = ri.registerIcon("electricmagictools:essentiagenerator/side");
		this.saxumGen[2] = ri.registerIcon("electricmagictools:essentiagenerator/top");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
		list.add(new ItemStack(id, 1, 2));
		list.add(new ItemStack(id, 1, 3));
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta == 0) {
			if (side == 1) {
				return this.potentiaGen[2];
			}
			if (side > 1) {
				return this.potentiaGen[0];
			}
		}

		if (meta == 1) {
			if (side == 1) {
				return this.ignisGen[2];
			}
			if (side > 1) {
				return this.ignisGen[0];
			}
		}

		if (meta == 2) {
			if (side == 1) {
				return this.auramGen[2];
			}
			if (side > 1) {
				return this.auramGen[0];
			}
		}

		if (meta == 3) {
			if (side == 1) {
				return this.arborGen[2];
			}
			if (side > 1) {
				return this.arborGen[0];
			}
		}
		return this.potentiaGen[1];
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0) {
			return new TileEntityPotentiaGenerator();
		}
		if (meta == 1) {
			return new TileEntityIgnisGenerator();
		}
		if (meta == 2) {
			return new TileEntityAuramGenerator();
		}
		if (meta == 3) {
			return new TileEntityArborGenerator();
		}
		return super.createTileEntity(world, meta);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		world.removeTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		float f = (float) par2 + 0.5F;
		float f1 = (float) par3 + 1.0F;
		float f2 = (float) par4 + 0.5F;
		par1World.spawnParticle("largesmoke", f, f1, f2, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
}
