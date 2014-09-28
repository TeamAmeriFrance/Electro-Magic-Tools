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

package tombenpotter.emt.common.module.ic2.items.armor.goggles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.ConfigHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ItemSolarHelmetRevealing extends ItemQuantumGoggles {

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
	public ItemSolarHelmetRevealing(ArmorMaterial material, int par3, int par4) {
		super(material, par3, par4);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
		this.setCreativeTab(ElectroMagicTools.tabEMT);
		this.maxCharge = 1000000;
		this.genDay = 256;
		this.genNight = 128;
		maxCharge = 10000000;
		visDiscount = 7;
		tier = 3;
		transferLimit = 10000;
		energyPerDamage = 10000;

		potionCost.put(Integer.valueOf(Potion.poison.id), Integer.valueOf(10000));
		potionCost.put(Integer.valueOf(Potion.wither.id), Integer.valueOf(15000));
		potionCost.put(Integer.valueOf(Potion.confusion.id), Integer.valueOf(5000));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layerType) {
		return ModInformation.texturePath + ":textures/models/solarrevealinghelmet.png";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onArmorTick(World worldObj, EntityPlayer player, ItemStack itemStack) {
		if (ConfigHandler.nightVisionOff == false) {
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

		@SuppressWarnings("rawtypes") Iterator i$ = (new LinkedList(player.getActivePotionEffects())).iterator();
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
						double sentPacket = ElectricItem.manager.charge(player.inventory.armorInventory[i], energyLeft, 4, false, false);
						energyLeft -= sentPacket;
					}
				} else {
					return;
				}
			}
			for (int j = 0; j < player.inventory.mainInventory.length; j++) {
				if (energyLeft > 0) {
					if ((player.inventory.mainInventory[j] != null) && (player.inventory.mainInventory[j].getItem() instanceof IElectricItem)) {
						double sentPacket = ElectricItem.manager.charge(player.inventory.mainInventory[j], energyLeft, 4, false, false);
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
		this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":solarrevealinghelmet");
	}
}
