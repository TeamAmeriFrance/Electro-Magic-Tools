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
package electricMagicTools.tombenpotter.electricmagictools.common.items.foci;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public abstract class ItemBaseFocus extends Item implements IWandFocus
{

	private Icon ornament, depth;

	public ItemBaseFocus(int id)
	{
		super(id);
		this.setMaxDamage(1);
		this.setNoRepair();
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
	}

	boolean hasOrnament() {
		return false;
	}

	boolean hasDepth() {
		return false;
	}

	@Override
	public int getFocusColor() {
		return 0;
	}

	@Override
	public boolean isItemTool(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack itemstack) {
		return EnumRarity.rare;
	}

	@Override
	public Icon getFocusDepthLayerIcon() {
		return depth;
	}

	@Override
	public Icon getOrnament() {
		return ornament;
	}

	@Override
	public WandFocusAnimation getAnimation() {
		return WandFocusAnimation.WAVE;
	}

	@Override
	public AspectList getVisCost() {
		return null;
	}

	public boolean isUseItem() {
		return isVisCostPerTick();
	}

	@Override
	public boolean isVisCostPerTick() {
		return false;
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, MovingObjectPosition paramMovingObjectPosition) {
		if (isUseItem())
			paramEntityPlayer.setItemInUse(paramItemStack, Integer.MAX_VALUE);
		return paramItemStack;
	}

	@Override
	public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int count) {

	}

	@Override
	public void onPlayerStoppedUsingFocus(ItemStack itemstack, World world, EntityPlayer player, int count) {
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "00";
	}

	@Override
	public boolean onFocusBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		return false;
	}

	@Override
	public boolean acceptsEnchant(int id) {
		return false;
	}

	@Override
	public int getItemEnchantability() {
		return 5;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		AspectList cost = getVisCost();
		if (cost != null && cost.size() > 0)
		{
			list.add(StatCollector.translateToLocal(isVisCostPerTick() ? "item.Focus.cost2" : "item.Focus.cost1"));
			for (Aspect aspect : cost.getAspectsSorted())
			{
				float amount = cost.getAmount(aspect) / 100.0F;
				list.add(" " + '\u00a7' + aspect.getChatcolor() + aspect.getName() + '\u00a7' + "r x " + amount);
			}
		}
	}
}
