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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEtherealMacerator;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge;

public class BlockEMTMachines extends BlockContainer {

	public IIcon[] wandCharger = new IIcon[4];
	public IIcon[] etherealProcessor = new IIcon[4];

	public BlockEMTMachines() {
		super(Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		this.wandCharger[0] = ir.registerIcon("electricmagictools:machines/top");
		this.wandCharger[1] = ir.registerIcon("electricmagictools:machines/bottom");
		this.wandCharger[2] = ir.registerIcon("electricmagictools:machines/side");
		this.wandCharger[3] = ir.registerIcon("electricmagictools:machines/wandcharger");

		this.etherealProcessor[0] = ir.registerIcon("electricmagictools:machines/etherealmaceratortop");
		this.etherealProcessor[1] = ir.registerIcon("electricmagictools:machines/etherealmacerator");
		this.etherealProcessor[2] = ir.registerIcon("electricmagictools:machines/etherealmaceratorfront");
		this.etherealProcessor[3] = ir.registerIcon("electricmagictools:machines/etherealmaceratorfrontactive");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta == 0) {
			if (side <= 1) {
				return this.wandCharger[0];
			}
			if (side > 1) {
				return this.wandCharger[3];
			}
		}

		if (meta == 1) {
			if (side == 0) {
				return this.etherealProcessor[1];
			}
			if (side == 1) {
				return this.etherealProcessor[0];
			}
			if (side == 2) {
				return this.etherealProcessor[3];
			}
			if (side == 3) {
				return this.etherealProcessor[3];
			}
		}
		return this.etherealProcessor[2];
	}

	@Override
	public IIcon getIcon(IBlockAccess access, int i, int j, int k, int side) {
		return super.getIcon(access, i, j, k, side);
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0) {
			return new TileEntityIndustrialWandRecharge();
		}
		if (meta == 1) {
			return new TileEntityEtherealMacerator();
		}
		return super.createTileEntity(world, meta);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int md) {
		return null;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityIndustrialWandRecharge) {
			player.openGui(ElectricMagicTools.instance, 0, world, x, y, z);
		} else if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityEtherealMacerator) {
			player.openGui(ElectricMagicTools.instance, 1, world, x, y, z);
		}
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		dropItems(world, x, y, z);
		world.removeTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();

		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory)) {
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}
}
