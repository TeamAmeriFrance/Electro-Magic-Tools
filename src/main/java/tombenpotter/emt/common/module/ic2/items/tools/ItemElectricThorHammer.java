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

package tombenpotter.emt.common.module.ic2.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.modules.base.entities.EntityArcher;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.TextHelper;

import java.util.List;

public class ItemElectricThorHammer extends ItemSword implements IElectricItem {

    public int maxCharge = 1000000;
    private final int hitCost = 5000;
    private final int lightningCost = 75000;

    public ItemElectricThorHammer() {
        super(ToolMaterial.EMERALD);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setMaxDamage(27);
        this.setMaxStackSize(1);
        // OreDictionary.registerOre("craftingToolForgeHammer", this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":hammer/electricthorhammer");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
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
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
        if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
            entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 19F);
        }
        return false;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(player.getCommandSenderName() + TextHelper.localize("tooltip.EMT.hammer.electric"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode) {
            return itemstack;
        } else if (ElectricItem.manager.canUse(itemstack, lightningCost)) {
            player.swingItem();
            // Corners
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ - 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ + 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ - 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ + 8));

            // Fronts
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ - 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ + 8));

            // Others
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ + 1));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ + 2));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ + 3));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ + 4));

            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ - 1));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ - 2));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 8, player.posY, player.posZ - 3));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 8, player.posY, player.posZ - 4));

            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 1, player.posY, player.posZ + 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 2, player.posY, player.posZ - 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 3, player.posY, player.posZ + 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX + 4, player.posY, player.posZ - 8));

            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 1, player.posY, player.posZ + 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 2, player.posY, player.posZ - 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 3, player.posY, player.posZ + 8));
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX - 4, player.posY, player.posZ - 8));

            EntityArcher archer;
            archer = new EntityArcher(world);
            archer.setPosition(player.posX + 8, player.posY + 2, player.posZ - 8);
            world.spawnEntityInWorld(archer);

            EntityArcher archer1;
            archer1 = new EntityArcher(world);
            archer1.setPosition(player.posX - 8, player.posY + 2, player.posZ + 8);
            world.spawnEntityInWorld(archer1);

            EntityArcher archer2;
            archer2 = new EntityArcher(world);
            archer2.setPosition(player.posX - 8, player.posY + 2, player.posZ - 8);
            world.spawnEntityInWorld(archer2);

            EntityArcher archer3;
            archer3 = new EntityArcher(world);
            archer3.setPosition(player.posX + 8, player.posY + 2, player.posZ + 8);
            world.spawnEntityInWorld(archer3);
            ElectricItem.manager.use(itemstack, lightningCost, player);
            return itemstack;
        } else {
            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
            player.addPotionEffect(new PotionEffect(Potion.harm.getId(), 1, 1));
            return itemstack;
        }
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        if (ConfigHandler.enchanting == false) {
            return 0;
        } else {
            return 4;
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
        return ConfigHandler.enchanting;
    }

    /* IC2 API METHODS */

    @Override
    public Item getChargedItem(ItemStack itemStack) {
        return this;
    }

    @Override
    public Item getEmptyItem(ItemStack itemStack) {
        return this;
    }

    @Override
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return maxCharge;
    }

    @Override
    public int getTier(ItemStack itemStack) {
        return 2;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return 100;
    }
}
