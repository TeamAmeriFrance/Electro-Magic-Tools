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
package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemSolarHelmetRevealing extends ItemArmor implements ISpecialArmor, IRevealer, IVisDiscountGear, IGoggles, IElectricItem {

	public int maxCharge = 10000000;
	private int ticker;
	private int generating;
	private int genDay;
	private int genNight;
	private boolean sunIsUp;
	private boolean skyIsVisible;
	private boolean noSunWorld;
	private boolean dampPlace;

	@SuppressWarnings("rawtypes")
	private static final Map potionCost = new HashMap();

	@SuppressWarnings("unchecked")
	public ItemSolarHelmetRevealing(int par3, int par4) {
		super(ArmorMaterial.IRON, par3, par4);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.maxCharge = 1000000;
		this.genDay = 256;
		this.genNight = 128;

		potionCost.put(Integer.valueOf(Potion.poison.id), Integer.valueOf(10000));
		potionCost.put(Integer.valueOf(Potion.wither.id), Integer.valueOf(15000));
		potionCost.put(Integer.valueOf(Potion.confusion.id), Integer.valueOf(5000));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layerType) {
		return "electricmagictools:textures/models/solarrevealinghelmet.png";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onArmorTick(World worldObj, EntityPlayer player, ItemStack itemStack) {
		if (Config.nightVisionOff == false) {
			if (ElectricItem.manager.canUse(itemStack, 1 / 1000)) {

				int x = MathHelper.floor_double(player.posX);
				int z = MathHelper.floor_double(player.posZ);
				int y = MathHelper.floor_double(player.posY);

				int lightlevel = player.worldObj.getBlockLightValue(x, y, z);
				if (lightlevel >= 0)
					player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, -3));
				ElectricItem.manager.use(itemStack, 1 / 1000, player);
			} else {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 300, 0, true));
			}
		}

		int refill = player.getAir();
		if (ElectricItem.manager.canUse(itemStack, 1000) && refill < 100) {
			player.setAir(refill + 200);
			ElectricItem.manager.use(itemStack, 1000, null);
		}

		@SuppressWarnings("rawtypes")
		Iterator i$ = (new LinkedList(player.getActivePotionEffects())).iterator();
		do {
			if (!i$.hasNext()) {
				break;
			}
			{
				PotionEffect effect = (PotionEffect) i$.next();
				int id = effect.getPotionID();
				Integer cost = (Integer) potionCost.get(Integer.valueOf(id));
				if (cost != null) {
					cost = Integer.valueOf(cost.intValue() * (effect.getAmplifier() + 1));
					if (ElectricItem.manager.canUse(itemStack, cost.intValue())) {
						ElectricItem.manager.use(itemStack, cost.intValue(), null);
						ItemStack milk = (new ItemStack(Items.milk_bucket));
						player.curePotionEffects(milk);
					}
				}
			}
		} while (true);

		if (worldObj.isRemote) {
			return;
		}
		checkForSun(player);
		if (this.generating > 0) {
			int energyLeft = this.generating;
			for (int i = 0; i < player.inventory.armorInventory.length; i++) {
				if (energyLeft > 0) {
					if ((player.inventory.armorInventory[i] != null) && (player.inventory.armorInventory[i].getItem() instanceof IElectricItem)) {
						int sentPacket = ElectricItem.manager.charge(player.inventory.armorInventory[i], energyLeft, 4, false, false);
						energyLeft -= sentPacket;
					}
				} else {
					return;
				}
			}
			for (int j = 0; j < player.inventory.mainInventory.length; j++) {
				if (energyLeft > 0) {
					if ((player.inventory.mainInventory[j] != null) && (player.inventory.mainInventory[j].getItem() instanceof IElectricItem)) {
						int sentPacket = ElectricItem.manager.charge(player.inventory.mainInventory[j], energyLeft, 4, false, false);
						energyLeft -= sentPacket;
					}
				} else {
					return;
				}
			}
		}
	}

	public int checkForSun(EntityPlayer player) {
		if (this.ticker++ % tickRate() == 0) {
			updateVisibility(player);
		}
		if ((this.sunIsUp) && (this.skyIsVisible)) {
			this.generating = (0 + this.genDay);
			return this.generating;
		}
		if (this.skyIsVisible) {
			this.generating = (0 + this.genNight);
			return this.generating;
		}
		this.generating = 0;
		return this.generating;
	}

	public void updateVisibility(EntityPlayer player) {
		this.dampPlace = (player.worldObj.getWorldChunkManager().getBiomeGenAt((int) player.posX, (int) player.posZ).getIntRainfall() > 0);
		this.noSunWorld = player.worldObj.provider.hasNoSky;
		Boolean rainWeather = Boolean.valueOf((this.dampPlace) && ((player.worldObj.isRaining()) || (player.worldObj.isThundering())));
		if ((!player.worldObj.isDaytime()) || (rainWeather.booleanValue())) {
			this.sunIsUp = false;
		} else {
			this.sunIsUp = true;
		}
		if ((!player.worldObj.canBlockSeeTheSky((int) player.posX, (int) player.posY + 1, (int) player.posZ)) || (this.noSunWorld)) {
			this.skyIsVisible = false;
		} else {
			this.skyIsVisible = true;
		}
	}

	public static int tickRate() {
		return 128;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:solarrevealinghelmet");
	}

	@Override
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("Vis discount: 7%");
	}

	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect) {
		return 7;
	}

	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if (source.isUnblockable()) {
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(0, 0.0D, 0);
		} else {
			double absorptionRatio = getBaseAbsorptionRatio() * getDamageAbsorptionRatio();
			int energyPerDamage = getEnergyPerDamage();
			int damageLimit = energyPerDamage <= 0 ? 0 : (25 * ElectricItem.manager.getCharge(armor)) / energyPerDamage;
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit);
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

	public int getEnergyPerDamage() {
		return 10000;
	}

	private double getBaseAbsorptionRatio() {
		return 0.14999999999999999D;
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
	public boolean canProvideEnergy(ItemStack itemStack) {
		return true;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 1;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 1000;
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
	public Item getChargedItem(ItemStack itemStack) {
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) {
		return this;
	}
}
