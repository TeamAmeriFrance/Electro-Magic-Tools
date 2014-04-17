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

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemElectricBootsTraveller extends ItemArmor implements IElectricItem, IVisDiscountGear, IMetalArmor, ISpecialArmor {

	public int maxCharge = 10000;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> playersWith1Step = new ArrayList();

	public ItemElectricBootsTraveller(int par3, int par4) {
		super(ArmorMaterial.DIAMOND, par3, par4);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		if (ticks())
			MinecraftForge.EVENT_BUS.register(this);
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

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:electricboots");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "electricmagictools:textures/models/electricboots.png";
	}

	boolean ticks() {
		return true;
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack armor = player.getCurrentArmor(3 - armorType);
			if (armor != null && armor.getItem() == this)
				tickPlayer(player);
		}
	}

	void tickPlayer(EntityPlayer player) {
		if (player.worldObj.isRemote)
			player.stepHeight = player.isSneaking() ? 0.5F : 1F;
		if ((player.onGround || player.capabilities.isFlying) && player.moveForward > 0F)
			player.moveFlying(0F, 1F, player.capabilities.isFlying ? 0.075F : 0.15F);
		player.jumpMovementFactor = player.isSprinting() ? 0.05F : 0.04F;
		player.fallDistance = 0F;
	}

	@SubscribeEvent
	public void onPlayerJump(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			boolean hasArmor = player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == this;

			if (hasArmor)
				player.motionY += 0.3;
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.entityLiving instanceof EntityPlayer && event.entityLiving.worldObj.isRemote) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;

			boolean highStepListed = playersWith1Step.contains(player.getCommandSenderName());
			boolean hasHighStep = player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == this;

			if (hasHighStep && !highStepListed)
				playersWith1Step.add(player.getCommandSenderName());

			if (!hasHighStep && highStepListed) {
				playersWith1Step.remove(player.getCommandSenderName());
				player.stepHeight = 0.5F;
			}
		}
	}

	@Override
	public boolean isMetalArmor(ItemStack itemstack, EntityPlayer player) {
		return true;
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
		return 100;
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

	public int getEnergyPerDamage() {
		return 100;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if (source.isUnblockable()) {
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(0, 0.0D, 3);
		} else {
			double absorptionRatio = getBaseAbsorptionRatio() * getDamageAbsorptionRatio();
			int energyPerDamage = getEnergyPerDamage();
			int damageLimit = energyPerDamage <= 0 ? 0 : (25 * ElectricItem.manager.getCharge(armor)) / energyPerDamage;
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(3, absorptionRatio, damageLimit);
		}
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		if (ElectricItem.manager.getCharge(armor) >= getEnergyPerDamage()) {
			return (int) Math.round(20D * getBaseAbsorptionRatio() * getDamageAbsorptionRatio());
		} else {
			return 0;
		}
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		ElectricItem.manager.discharge(stack, damage * getEnergyPerDamage(), 0x7fffffff, true, false);
	}

	public double getDamageAbsorptionRatio() {
		return 1.1000000000000001D;
	}

	private double getBaseAbsorptionRatio() {
		return 0.14999999999999999D;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("Vis discount: 2%");
	}

	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect) {
		return 2;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (Config.smoke == false && player.onGround == false) {
			int miny = (int) (player.boundingBox.minY - 2.0D);
			Thaumcraft.proxy.smokeSpiral(player.worldObj, player.posX, player.boundingBox.minY + player.height / 2.0F, player.posZ, 1.5F, player.worldObj.rand.nextInt(620), miny);
		}
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
