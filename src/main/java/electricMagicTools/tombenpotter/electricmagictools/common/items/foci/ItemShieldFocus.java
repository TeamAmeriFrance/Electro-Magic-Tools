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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.BlockRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemShieldFocus extends ItemBaseFocus {

    private static final AspectList visCost = new AspectList().add(Aspect.ORDER, 10).add(Aspect.WATER, 10).add(Aspect.AIR, 10);

    public ItemShieldFocus() {
        super();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ElectricMagicTools.texturePath + ":shieldfocus");
    }

    @Override
    public int getFocusColor() {
        return 555555555;
    }

    @Override
    public boolean isUseItem() {
        return true;
    }

    @Override
    public AspectList getVisCost() {
        return visCost;
    }

    @Override
    public String getSortingHelper(ItemStack itemstack) {
        return "SHIELD";
    }

    @Override
    public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int time) {
        player.motionX = 0.0D;
        player.motionY = 0.0D;
        player.motionZ = 0.0D;

        ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
        if (wand.consumeAllVis(itemstack, player, getVisCost(), true, true)) {
            int x = MathHelper.floor_double(player.posX);
            int y = MathHelper.floor_double(player.posY);
            int z = MathHelper.floor_double(player.posZ);

            // Player Level
            if (player.worldObj.isAirBlock(x + 1, y, z) && player.worldObj.isAirBlock(x - 1, y, z) && player.worldObj.isAirBlock(x, y, z + 1) && player.worldObj.isAirBlock(x, y, z - 1)) {
                player.worldObj.setBlock(x + 1, y, z, BlockRegistry.shield);
                player.worldObj.setBlock(x - 1, y, z, BlockRegistry.shield);
                player.worldObj.setBlock(x, y, z + 1, BlockRegistry.shield);
                player.worldObj.setBlock(x, y, z - 1, BlockRegistry.shield);
            }

            // Above the player
            if (player.worldObj.isAirBlock(x + 1, y + 1, z) && player.worldObj.isAirBlock(x - 1, y + 1, z) && player.worldObj.isAirBlock(x, y + 1, z + 1) && player.worldObj.isAirBlock(x, y + 1, z - 1)) {
                player.worldObj.setBlock(x + 1, y + 1, z, BlockRegistry.shield);
                player.worldObj.setBlock(x - 1, y + 1, z, BlockRegistry.shield);
                player.worldObj.setBlock(x, y + 1, z + 1, BlockRegistry.shield);
                player.worldObj.setBlock(x, y + 1, z - 1, BlockRegistry.shield);
            }
        }

    }

    @Override
    public void onPlayerStoppedUsingFocus(ItemStack itemstack, World world, EntityPlayer player, int count) {
        int x = MathHelper.floor_double(player.posX);
        int y = MathHelper.floor_double(player.posY);
        int z = MathHelper.floor_double(player.posZ);

        // Player Level
        if ((player.worldObj.getBlock(x + 1, y, z) == BlockRegistry.shield) && (player.worldObj.getBlock(x - 1, y, z) == BlockRegistry.shield) && (player.worldObj.getBlock(x, y, z + 1) == BlockRegistry.shield) && (player.worldObj.getBlock(x, y, z - 1) == BlockRegistry.shield)) {
            player.worldObj.setBlockToAir(x + 1, y, z);
            player.worldObj.setBlockToAir(x - 1, y, z);
            player.worldObj.setBlockToAir(x, y, z + 1);
            player.worldObj.setBlockToAir(x, y, z - 1);
        }

        // Above the player
        if ((player.worldObj.getBlock(x + 1, y + 1, z) == BlockRegistry.shield) && (player.worldObj.getBlock(x - 1, y + 1, z) == BlockRegistry.shield) && (player.worldObj.getBlock(x, y + 1, z + 1) == BlockRegistry.shield) && (player.worldObj.getBlock(x, y + 1, z - 1) == BlockRegistry.shield)) {
            player.worldObj.setBlockToAir(x + 1, y + 1, z);
            player.worldObj.setBlockToAir(x - 1, y + 1, z);
            player.worldObj.setBlockToAir(x, y + 1, z + 1);
            player.worldObj.setBlockToAir(x, y + 1, z - 1);
        }

        ItemStack milk = (new ItemStack(Items.milk_bucket));
        player.curePotionEffects(milk);
    }
}
