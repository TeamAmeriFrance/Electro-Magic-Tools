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

package tombenpotter.emt.common.module.ic2.items.foci;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.module.base.items.foci.ItemBaseFocus;
import tombenpotter.emt.common.util.ConfigHandler;

public class ItemChargeFocus extends ItemBaseFocus {

	private static final AspectList visCost = new AspectList().add(Aspect.FIRE, 10).add(Aspect.WATER, 10).add(Aspect.AIR, 10).add(Aspect.EARTH, 10).add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10);

	public ItemChargeFocus() {
		super();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":chargefocus");
	}

	@Override
	public int getFocusColor() {
		return 0xFFFF00;
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "WANDCHARGING";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if (wand.consumeAllVis(itemstack, player, getVisCost(), true, true)) {
			if (!world.isRemote) {

				int energyLeft = ConfigHandler.chargeFocusProduction;
				for (int i = 0; i < player.inventory.armorInventory.length; i++) {
					if (energyLeft > 0) {
						if ((player.inventory.armorInventory[i] != null) && (player.inventory.armorInventory[i].getItem() instanceof IElectricItem)) {
							double sentPacket = ElectricItem.manager.charge(player.inventory.armorInventory[i], energyLeft, 4, false, false);
							energyLeft -= sentPacket;
						}
					} else {
						return itemstack;
					}
				}
				for (int j = 0; j < player.inventory.mainInventory.length; j++) {
					if (energyLeft > 0) {
						if ((player.inventory.mainInventory[j] != null) && (player.inventory.mainInventory[j].getItem() instanceof IElectricItem)) {
							double sentPacket = ElectricItem.manager.charge(player.inventory.mainInventory[j], energyLeft, 4, false, false);
							energyLeft -= sentPacket;
						}
					} else {
						return itemstack;
					}
				}
			}
		}
		return itemstack;
	}
}
