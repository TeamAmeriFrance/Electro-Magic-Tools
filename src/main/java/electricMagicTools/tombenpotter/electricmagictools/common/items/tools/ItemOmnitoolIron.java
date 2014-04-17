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
package electricMagicTools.tombenpotter.electricmagictools.common.items.tools;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemOmnitoolIron extends ItemPickaxe implements IElectricItem {

	public int maxCharge = 20000;
	private int cost;
	private final int hitCost = 125;

	public ItemOmnitoolIron() {
		super(ToolMaterial.EMERALD);
		this.efficiencyOnProperMaterial = 13F;
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxStackSize(1);
		if (Config.toolsInBore == false) {
			this.setMaxDamage(27);
		} else {
			this.setMaxDamage(200);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:ironomnitool");
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 2;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 200;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List itemList) {
		ItemStack itemStack = new ItemStack(this, 1);
		if (getChargedItem(itemStack) == this) {
			ItemStack charged = new ItemStack(this, 1);
			ElectricItem.manager.charge(charged, 2147483647, 2147483647, true, false);
			itemList.add(charged);
		}
		if (getEmptyItem(itemStack) == this) {
			itemList.add(new ItemStack(this, 1, getMaxDamage()));
		}
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int par4, int par5, int par6, EntityLivingBase entityLiving)

	{
		if (Config.toolsInBore == false) {
			cost = 100;
		} else {
			cost = 1;
		}
		ElectricItem.manager.use(stack, cost, entityLiving);
		return true;
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		return Items.iron_axe.canHarvestBlock(block, stack) || Items.iron_sword.canHarvestBlock(block, stack) || Items.iron_pickaxe.canHarvestBlock(block, stack) || Items.iron_shovel.canHarvestBlock(block, stack) || Items.shears.canHarvestBlock(block, stack);
	}

	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta) {
		if (!ElectricItem.manager.canUse(stack, cost)) {
			return 1.0F;
		}

		if (Items.wooden_axe.getDigSpeed(stack, block, meta) > 1.0F || Items.wooden_sword.getDigSpeed(stack, block, meta) > 1.0F || Items.wooden_pickaxe.getDigSpeed(stack, block, meta) > 1.0F || Items.wooden_shovel.getDigSpeed(stack, block, meta) > 1.0F || Items.shears.getDigSpeed(stack, block, meta) > 1.0F) {
			return efficiencyOnProperMaterial;
		} else {
			return super.getDigSpeed(stack, block, meta);
		}
	}

	@Override
	public boolean isRepairable() {
		return false;
	}

	@Override
	public int getItemEnchantability() {
		if (Config.enchanting == false) {
			return 0;
		} else {
			return 4;
		}
	}

	@Override
	public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
		if (Config.enchanting == false) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
			entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 8F);
		}
		return false;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			ItemStack torchStack = player.inventory.mainInventory[i];
			if (torchStack == null || !torchStack.getUnlocalizedName().toLowerCase().contains("torch")) {
				continue;
			}
			Item item = torchStack.getItem();
			if (!(item instanceof ItemBlock)) {
				continue;
			}
			int oldMeta = torchStack.getItemDamage();
			int oldSize = torchStack.stackSize;
			boolean result = torchStack.tryPlaceItemIntoWorld(player, world, x, y, z, side, xOffset, yOffset, zOffset);
			if (player.capabilities.isCreativeMode) {
				torchStack.setItemDamage(oldMeta);
				torchStack.stackSize = oldSize;
			} else if (torchStack.stackSize <= 0) {
				ForgeEventFactory.onPlayerDestroyItem(player, torchStack);
				player.inventory.mainInventory[i] = null;
			}
			if (result) {
				return true;
			}
		}

		return super.onItemUse(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
	}

	@Override
	public Item getChargedItem(ItemStack itemStack) {
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) {
		return this;
	}
}
