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

package tombenpotter.emt.common.modules.base.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import tombenpotter.emt.common.modules.base.entities.EntityLaser;

public class ItemExplosionFocus extends ItemBaseFocus {

    private static final AspectList visCost = new AspectList().add(Aspect.FIRE, 200).add(Aspect.ENTROPY, 200);

    public ItemExplosionFocus() {
        super("focus.explosion", "focus_explosion");
    }

    @Override
    public int getFocusColor() {
        return 9990;
    }

    @Override
    public AspectList getVisCost() {
        return visCost;
    }

    @Override
    public String getSortingHelper(ItemStack itemstack) {
        return "EXPLOSION";
    }

    @Override
    public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
        ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
        if (wand.consumeAllVis(itemstack, player, getVisCost(), true, true)) {
            if (!world.isRemote) {
                EntityLaser laser;
                laser = new EntityLaser(world, player, 2);
                world.spawnEntityInWorld(laser);
            }
        }
        return itemstack;
    }
}
