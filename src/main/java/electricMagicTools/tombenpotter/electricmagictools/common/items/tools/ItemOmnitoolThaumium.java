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
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemOmnitoolThaumium extends ItemOmnitoolDiamond
{

	public int maxCharge = 140000;
	private int cost;
	private final int hitCost = 650;

	public ItemOmnitoolThaumium(int id)
	{
		super(id);
		this.efficiencyOnProperMaterial = 21F;
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxStackSize(1);
		if (Config.toolsInBore == false)
		{
			this.setMaxDamage(27);
		} else
		{
			this.setMaxDamage(467);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:thaumiumomnitool");
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 800;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
		if (Config.toolsInBore == false)
		{
			cost = 300;
		} else
		{
			cost = 1;
		}
		ElectricItem.manager.use(par1ItemStack, cost, par7EntityLivingBase);
		return true;
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		return Item.axeDiamond.canHarvestBlock(block) || Item.swordDiamond.canHarvestBlock(block) || Item.pickaxeDiamond.canHarvestBlock(block) || Item.shovelDiamond.canHarvestBlock(block) || Item.shears.canHarvestBlock(block);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block, int meta) {
		if (!ElectricItem.manager.canUse(stack, cost))
		{
			return 1.0F;
		}

		if (Item.axeWood.getStrVsBlock(stack, block, meta) > 1.0F || Item.swordWood.getStrVsBlock(stack, block, meta) > 1.0F || Item.pickaxeWood.getStrVsBlock(stack, block, meta) > 1.0F || Item.shovelWood.getStrVsBlock(stack, block, meta) > 1.0F || Item.shears.getStrVsBlock(stack, block, meta) > 1.0F)
		{
			return efficiencyOnProperMaterial;
		} else
		{
			return super.getStrVsBlock(stack, block, meta);
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (ElectricItem.manager.use(itemstack, hitCost, attacker))
		{
			entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 10F);
		}
		return false;
	}

}
