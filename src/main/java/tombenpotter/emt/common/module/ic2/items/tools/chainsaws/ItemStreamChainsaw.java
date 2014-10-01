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

package tombenpotter.emt.common.module.ic2.items.tools.chainsaws;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.common.lib.Utils;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.fx.PacketFXBlockBubble;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

import java.awt.*;
import java.util.ArrayList;

public class ItemStreamChainsaw extends ItemThaumiumChainsaw {

    boolean alternateServer;
    boolean alternateClient;
    @SuppressWarnings("rawtypes")
    public static ArrayList oreDictLogs = new ArrayList();

    public ItemStreamChainsaw() {
        this.efficiencyOnProperMaterial = 25F;
        alternateServer = false;
        alternateClient = false;
        setCreativeTab(ElectroMagicTools.tabEMT);
        this.maxStackSize = 1;
        this.setMaxDamage(27);
        maxCharge = 900000;
        cost = 400;
        hitCost = 500;
        tier = 3;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":tools/chainsaw_stream");
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.bow;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        Block bi = world.getBlock(x, y, z);
        if ((!player.isSneaking()) && (Utils.isWoodLog(world, x, y, z))) {
            if (!world.isRemote) {
                if (Utils.breakFurthestBlock(world, x, y, z, bi, player)) {
                    world.playSoundEffect(x, y, z, "thaumcraft:bubble", 0.15F, 1.0F);
                    ElectricItem.manager.use(itemstack, cost, player);
                    this.alternateServer = (!this.alternateServer);
                }
            } else {
                player.swingItem();
                ElectricItem.manager.use(itemstack, cost, player);
                this.alternateClient = (!this.alternateClient);
            }
        }
        return super.onItemUse(itemstack, player, world, x, y, z, par7, par8, par9, par10);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
        World world = player.worldObj;
        Block bi = world.getBlock(x, y, z);
        if ((!player.isSneaking()) && (Utils.isWoodLog(world, x, y, z))) {
            if (!world.isRemote) {
                Utils.breakFurthestBlock(world, x, y, z, bi, player);
                PacketHandler.INSTANCE.sendToAllAround(new PacketFXBlockBubble(x, y, z, new Color(0.33F, 0.33F, 1.0F).getRGB()), new NetworkRegistry.TargetPoint(world.provider.dimensionId, x, y, z, 32.0D));

                world.playSoundEffect(x, y, z, "thaumcraft:bubble", 0.15F, 1.0F);
            }
            ElectricItem.manager.use(itemstack, cost, player);
            return true;
        }
        return super.onBlockStartBreak(itemstack, x, y, z, player);
    }

    /* IC2 API METHODS */
    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return 900;
    }
}
