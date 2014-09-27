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
 * This class originally belongs to Azanor, but with his permission I took it, and modified it to make it work as I wanted to.
 ******************************************************************************/
package tombenpotter.emt.common.module.ic2.items.tools.drills;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import tombenpotter.emt.common.util.Config;
import ic2.api.item.ElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.entities.EntityFollowingItem;
import thaumcraft.common.lib.Utils;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.common.util.CreativeTab;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemRockbreakerDrill extends ItemThaumiumDrill {
    private static final Block[] isEffective = {Blocks.nether_brick, Blocks.netherrack, Blocks.glowstone, Blocks.iron_block, Blocks.gold_block, Blocks.diamond_block, Blocks.lapis_block, Blocks.redstone_block, Blocks.redstone_ore, Blocks.emerald_ore, Blocks.emerald_block, Blocks.stonebrick, Blocks.glass, Blocks.stone, Blocks.gold_ore, Blocks.iron_ore, Blocks.coal_ore, Blocks.cobblestone, Blocks.diamond_ore, Blocks.lapis_ore, Blocks.dirt, Blocks.gravel, Blocks.sand, Blocks.sandstone, Blocks.soul_sand, Blocks.clay, Blocks.grass, Blocks.snow_layer, Blocks.snow, Blocks.farmland, Blocks.hardened_clay, Blocks.stained_hardened_clay, Blocks.mossy_cobblestone};
    public Icon icon;
    int side;
    public int searchCost = 1000;
    public int hitCost = 400;

    public ItemRockbreakerDrill() {
        side = 0;
        setCreativeTab(CreativeTab.tabTombenpotter);
        this.efficiencyOnProperMaterial = 25F;
        this.setMaxStackSize(1);
        if (Config.toolsInBore == false) {
            this.setMaxDamage(27);
        } else {
            this.setMaxDamage(2571);
        }
        maxCharge = 900000;
        transferLimit = 900;
        tier = 3;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ElectroMagicTools.texturePath + ":rockbreakerdrill");
    }

    private boolean isEffectiveAgainst(Block block) {
        for (int var3 = 0; var3 < isEffective.length; var3++) {
            if (isEffective[var3] == block) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
        MovingObjectPosition movingobjectposition = Utils.getTargetBlock(((Entity) (player)).worldObj, player, true);
        if (movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
            side = movingobjectposition.sideHit;
        }
        return super.onBlockStartBreak(itemstack, X, Y, Z, player);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
        if (Config.toolsInBore == false) {
            cost = 350;
        } else {
            cost = 1;
        }
        if (entityLiving.isSneaking()) {
            if (ElectricItem.manager.canUse(stack, cost)) {
                ElectricItem.manager.use(stack, cost, entityLiving);
            }
            return true;
        }
        int md = world.getBlockMetadata(x, y, z);
        if (ForgeHooks.isToolEffective(stack, block, md) || isEffectiveAgainst(block)) {
            for (int aa = -1; aa <= 1; aa++) {
                for (int bb = -1; bb <= 1; bb++) {
                    int xx = 0;
                    int yy = 0;
                    int zz = 0;
                    if (side <= 1) {
                        xx = aa;
                        zz = bb;
                    } else if (side <= 3) {
                        xx = aa;
                        yy = bb;
                    } else {
                        zz = aa;
                        yy = bb;
                    }
                    Block bl = world.getBlock(x + xx, y + yy, z + zz);
                    md = world.getBlockMetadata(x + xx, y + yy, z + zz);
                    if (!ForgeHooks.isToolEffective(stack, bl, md) && !isEffectiveAgainst(bl)) {
                        continue;
                    }
                    if (ElectricItem.manager.canUse(stack, cost)) {
                        ElectricItem.manager.use(stack, cost, entityLiving);
                    }
                    int fortune = EnchantmentHelper.getFortuneModifier(entityLiving);
                    world.setBlockToAir(x + xx, y + yy, z + zz);
                    ArrayList ret = bl.getDrops(world, x + xx, y + yy, z + zz, md, fortune);
                    boolean creative = false;
                    if ((entityLiving instanceof EntityPlayer) && ((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
                        creative = true;
                    }
                    if (ret.size() <= 0 || creative || ((Entity) (entityLiving)).worldObj.isRemote) {
                        continue;
                    }
                    ItemStack is;
                    for (Iterator i$ = ret.iterator(); i$.hasNext(); world.spawnEntityInWorld(new EntityFollowingItem(world, (double) x + (double) xx + 0.5D, (double) y + (double) yy + 0.5D, (double) z + (double) zz + 0.5D, is, entityLiving, 3))) {
                        is = (ItemStack) i$.next();
                    }
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unused")
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
        if (!player.isSneaking()) {
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
        } else {
            ElectricItem.manager.use(stack, searchCost, player);
            if (!world.isRemote) {
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "thaumcraft:wandfail", 0.2F, 0.2F + world.rand.nextFloat() * 0.2F);
                return super.onItemUse(stack, player, world, x, y, z, side, xOffset, xOffset, zOffset);
            }
            Minecraft mc = Minecraft.getMinecraft();
            Thaumcraft.instance.renderEventHandler.startScan(player, x, y, z, System.currentTimeMillis() + 5000L);
            player.swingItem();
            return super.onItemUse(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
        }

        return super.onItemUse(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (!((Entity) (player)).worldObj.isRemote && (!(entity instanceof EntityPlayer) || MinecraftServer.getServer().isPVPEnabled())) {
            entity.setFire(2);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
        if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
            entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 12F);
        }
        return false;
    }
}
