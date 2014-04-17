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

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import thaumcraft.common.blocks.BlockAiry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPortableNode;

public class BlockPortableNode extends BlockAiry {

	public IIcon[] texture = new IIcon[1];

	public BlockPortableNode() {
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		setBlockUnbreakable();
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileEntityPortableNode();
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	protected boolean canSilkHarvest() {
		return false;
	}

	public boolean canEntityDestroy(World world, int x, int y, int z, Entity entity) {
		return false;
	}

	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
	}

	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ri) {
		this.texture[0] = ri.registerIcon("electricmagictools:portablenode");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.texture[0];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!world.isRemote && player.isSneaking() && player.getHeldItem() == null) {
			world.setBlockToAir(x, y, z);
			world.removeTileEntity(x, y, z);
		}
		return true;
	}
}
