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
 * 
 * This class originally belongs to Azanor, but with his permission I took it, and modified it to make it work as I wanted to.
 ******************************************************************************/
package electricMagicTools.tombenpotter.electricmagictools.common.items.tools;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import thaumcraft.common.lib.PacketHandler;
import thaumcraft.common.lib.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemStreamChainsaw extends ItemAxe implements IElectricItem
{

	boolean alternateServer;
	boolean alternateClient;
	@SuppressWarnings("rawtypes")
	public static ArrayList oreDictLogs = new ArrayList();
	public int maxCharge = 900000;
	private final int cost = 400;
	private final int hitCost = 500;

	public ItemStreamChainsaw(int id)
	{
		super(id, EnumToolMaterial.EMERALD);
		this.efficiencyOnProperMaterial = 25F;
		alternateServer = false;
		alternateClient = false;
		setCreativeTab(CreativeTab.tabTombenpotter);
		this.maxStackSize = 1;
		this.setMaxDamage(27);
	}

	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.bow;
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		int brokenID = world.getBlockId(x, y, z);
		if (!player.isSneaking() && brokenID > 0 && Utils.isWoodLog(world, x, y, z))
		{
			if (!world.isRemote)
			{
				Utils.breakFurthestBlock(world, x, y, z, brokenID, player);
				world.playSoundEffect(x, y, z, "thaumcraft:bubble", 0.15F, 1.0F);
				ElectricItem.manager.use(itemstack, cost, player);
				alternateServer = !alternateServer;
			} else
			{
				player.swingItem();
				ElectricItem.manager.use(itemstack, cost, player);
				alternateClient = !alternateClient;
			}
		}
		return super.onItemUse(itemstack, player, world, x, y, z, par7, par8, par9, par10);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
		ElectricItem.manager.use(par1ItemStack, cost, par7EntityLivingBase);
		return true;
	}

	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		World world = ((Entity) (player)).worldObj;
		int brokenID = world.getBlockId(x, y, z);
		if (!player.isSneaking() && brokenID > 0 && Utils.isWoodLog(world, x, y, z))
		{
			if (!world.isRemote)
			{
				Utils.breakFurthestBlock(world, x, y, z, brokenID, player);
				PacketHandler.sendBlockBoilFXPacket(x, y, z, 0.33F, 0.33F, 1.0F, player);
				world.playSoundEffect(x, y, z, "thaumcraft:bubble", 0.15F, 1.0F);
			}
			ElectricItem.manager.use(itemstack, cost, player);
			return true;
		} else
		{
			return super.onBlockStartBreak(itemstack, x, y, z, player);
		}
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack) {
		return itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack) {
		return itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 3;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 900;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:streamchainsaw");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List itemList) {
		ItemStack itemStack = new ItemStack(this, 1);

		if (getChargedItemId(itemStack) == this.itemID)
		{
			ItemStack charged = new ItemStack(this, 1);
			ElectricItem.manager.charge(charged, 2147483647, 2147483647, true, false);
			itemList.add(charged);
		}

		if (getEmptyItemId(itemStack) == this.itemID)
			itemList.add(new ItemStack(this, 1, getMaxDamage()));
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		return Item.axeDiamond.canHarvestBlock(block) || Item.swordDiamond.canHarvestBlock(block);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block, int meta) {
		if (!ElectricItem.manager.canUse(stack, cost))
		{
			return 1.0F;
		}

		if (Item.axeWood.getStrVsBlock(stack, block, meta) > 1.0F || Item.swordWood.getStrVsBlock(stack, block, meta) > 1.0F)
		{
			return efficiencyOnProperMaterial;
		} else
		{
			return super.getStrVsBlock(stack, block, meta);
		}
	}

	@Override
	public boolean isRepairable() {
		return false;
	}

	@Override
	public int getItemEnchantability() {
		if (Config.enchanting == false)
		{
			return 0;
		} else
		{
			return 4;
		}
	}

	@Override
	public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
		if (Config.enchanting == false)
		{
			return false;
		} else
		{
			return true;
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (ElectricItem.manager.use(itemstack, hitCost, attacker))
		{
			entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 12F);
		}
		return false;
	}
}
