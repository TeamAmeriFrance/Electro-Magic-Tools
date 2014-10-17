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

package tombenpotter.emt.common.util;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import thaumcraft.common.entities.monster.EntityTaintChicken;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.module.ic2.IC2ModuleItemRegistry;
import tombenpotter.emt.common.modules.base.items.ItemShardCarver;

public class EventHandlerEMT {

    @SubscribeEvent
    public void onEntityLivingDrops(LivingDropsEvent event) {
        if (event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer) {
            if (event.entityLiving instanceof EntityCreeper) {
                EntityCreeper creeper = (EntityCreeper) event.entityLiving;
                if (creeper.getPowered()) {
                    event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(IC2ModuleItemRegistry.itemEMTItems, 1, 6)));
                }
            }
            if (event.entityLiving instanceof EntityTaintChicken) {
                event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(IC2ModuleItemRegistry.itemEMTItems, 1, 14)));
            }
        }

        if (event.entityLiving instanceof EntityCreeper) {
            event.entityLiving.entityDropItem(new ItemStack(IC2ModuleItemRegistry.itemEMTItems, 6), 1);
        }
        if (event.entityLiving instanceof EntityTaintChicken) {
            event.entityLiving.entityDropItem(new ItemStack(IC2ModuleItemRegistry.itemEMTItems, 14), 1);
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(ModInformation.modid)) {
            ConfigHandler.syncConfig();
            ElectroMagicTools.logger.info(TextHelper.localize("console.EMT.config.refresh"));
        }
    }

    @SubscribeEvent
    public void onCraftedEvent(PlayerEvent.ItemCraftedEvent event) {
        for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
            if (event.craftMatrix.getStackInSlot(i) != null && event.craftMatrix.getStackInSlot(i).getItem() instanceof ItemShardCarver && event.player != null) {
                event.craftMatrix.getStackInSlot(i).stackSize = 2;
                event.craftMatrix.getStackInSlot(i).damageItem(1, event.player);
            }
        }
    }
}
