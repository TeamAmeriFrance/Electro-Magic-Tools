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
package electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thaumcraft.api.IRepairable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemThorHammer extends ItemSword implements IRepairable {

	public ItemThorHammer() {
		super(ToolMaterial.EMERALD);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxStackSize(1);
		this.setMaxDamage(2000);
		// OreDictionary.registerOre("craftingToolForgeHammer", this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("electricmagictools:hammer/thorhammer");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.swingItem();
		float f = 1.0F;
		float f1 = player.prevRotationPitch + ((player.rotationPitch - player.prevRotationPitch) * f);
		float f2 = player.prevRotationYaw + ((player.rotationYaw - player.prevRotationYaw) * f);
		double d = player.prevPosX + ((player.posX - player.prevPosX) * f);
		double d1 = (player.prevPosY + ((player.posY - player.prevPosY) * f) + 1.6200000000000001D) - player.yOffset;
		double d2 = player.prevPosZ + ((player.posZ - player.prevPosZ) * f);
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos((-f2 * 0.01745329F) - 3.141593F);
		float f4 = MathHelper.sin((-f2 * 0.01745329F) - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5000D;
		Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
		MovingObjectPosition movingobjectposition = player.worldObj.rayTraceBlocks(vec3d, vec3d1, true);
		if (movingobjectposition == null) {
			return itemstack;
		}
		if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
			int i = movingobjectposition.blockX;
			int j = movingobjectposition.blockY;
			int k = movingobjectposition.blockZ;
			world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
		} else if (movingobjectposition.typeOfHit == MovingObjectType.ENTITY) {
			Entity entityhit = movingobjectposition.entityHit;
			double x = entityhit.posX;
			double y = entityhit.posY;
			double z = entityhit.posZ;
			world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
		}
		if (player.capabilities.isCreativeMode) {
			return itemstack;
		} else {
			itemstack.damageItem(20, player);
			return itemstack;
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 12F);
		itemstack.damageItem(1, attacker);
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("The Hammer of Thor");
	}
}
