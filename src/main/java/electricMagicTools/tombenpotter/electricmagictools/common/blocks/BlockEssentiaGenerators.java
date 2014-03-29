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

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityArborGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAuramGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIgnisGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPotentiaGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntitySaxumGenerator;

public class BlockEssentiaGenerators extends BlockContainer
{

	public Icon[] potentiaGen = new Icon[3];
	public Icon[] ignisGen = new Icon[3];
	public Icon[] auramGen = new Icon[3];
	public Icon[] arborGen = new Icon[3];
	public Icon[] saxumGen = new Icon[3];

	public BlockEssentiaGenerators(int id)
	{
		super(id, Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ri) {
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
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
		list.add(new ItemStack(id, 1, 2));
		list.add(new ItemStack(id, 1, 3));
		list.add(new ItemStack(id, 1, 4));
	}

	@Override
	public Icon getIcon(int side, int meta) {
		if (meta == 0)
		{
			if (side == 1)
			{
				return this.potentiaGen[2];
			}
			if (side > 1)
			{
				return this.potentiaGen[0];
			}
		}

		if (meta == 1)
		{
			if (side == 1)
			{
				return this.ignisGen[2];
			}
			if (side > 1)
			{
				return this.ignisGen[0];
			}
		}

		if (meta == 2)
		{
			if (side == 1)
			{
				return this.auramGen[2];
			}
			if (side > 1)
			{
				return this.auramGen[0];
			}
		}

		if (meta == 3)
		{
			if (side == 1)
			{
				return this.arborGen[2];
			}
			if (side > 1)
			{
				return this.arborGen[0];
			}
		}

		if (meta == 4)
		{
			if (side == 1)
			{
				return this.saxumGen[2];
			}
			if (side > 1)
			{
				return this.saxumGen[0];
			}
		}
		return this.potentiaGen[1];
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0)
		{
			return new TileEntityPotentiaGenerator();
		}
		if (meta == 1)
		{
			return new TileEntityIgnisGenerator();
		}
		if (meta == 2)
		{
			return new TileEntityAuramGenerator();
		}
		if (meta == 3)
		{
			return new TileEntityArborGenerator();
		}
		if (meta == 4)
		{
			return new TileEntitySaxumGenerator();
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
}
