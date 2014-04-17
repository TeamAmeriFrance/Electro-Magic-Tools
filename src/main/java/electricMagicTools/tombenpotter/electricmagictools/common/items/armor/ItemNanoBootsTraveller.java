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
 * Attention: this class originally belongs to the ThaumicTinkerer mod.
 * All I did was modifying it to fulfill my needs.
 * 
 * ThaumicTinkerer is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * http://www.minecraftforum.net/topic/1813058-
 ******************************************************************************/
package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import thaumcraft.api.aspects.Aspect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class ItemNanoBootsTraveller extends ItemElectricBootsTraveller {

	public int maxCharge = 500000;

	public ItemNanoBootsTraveller(int par3, int par4) {
		super(par3, par4);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:nanobootstravel");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "electricmagictools:textures/models/nanobootstravel.png";
	}

	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect) {
		return 4;
	}

	@Override
	void tickPlayer(EntityPlayer player) {
		if (player.worldObj.isRemote)
			player.stepHeight = player.isSneaking() ? 0.5F : 1F;
		if ((player.onGround || player.capabilities.isFlying) && player.moveForward > 0F)
			player.moveFlying(0F, 1F, (float) (player.capabilities.isFlying ? 0.075F : Config.nanoBootsSpeed));
		player.jumpMovementFactor = player.isSprinting() ? 0.05F : 0.04F;
		player.fallDistance = 0F;
	}

	@SubscribeEvent
	@Override
	public void onPlayerJump(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			boolean hasArmor = player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == this;

			if (hasArmor) {
				player.motionY += Config.nanoBootsJump;
			}
		}
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 1000;
	}

	public int getEnergyPerDamage() {
		return 200;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("Vis discount: 4%");
	}
}
