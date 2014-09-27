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
import tombenpotter.emt.common.util.Config;
import ic2.api.item.ElectricItem;
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
import tombenpotter.emt.common.util.CreativeTab;

import java.util.*;

public class ItemQuantumGoggles extends ItemNanoGoggles {
    private static final Map<Integer, Integer> potionCost = new HashMap();

    public ItemQuantumGoggles(ArmorMaterial material, int par3, int par4) {
        super(material, par3, par4);
        this.setCreativeTab(CreativeTab.tabTombenpotter);
        this.setMaxDamage(27);
        this.setMaxStackSize(1);
        maxCharge = 10000000;
        tier = 3;
        visDiscount = 8;
        transferLimit = 10000;
        energyPerDamage = 1000;

        potionCost.put(Integer.valueOf(Potion.poison.id), Integer.valueOf(10000));
        potionCost.put(Integer.valueOf(Potion.wither.id), Integer.valueOf(15000));
        potionCost.put(Integer.valueOf(Potion.confusion.id), Integer.valueOf(5000));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ElectroMagicTools.texturePath + ":quantumthaumichelmet");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ElectroMagicTools.texturePath + ":textures/models/thaumicquantumhelmet.png";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        int refill = player.getAir();
        if (ElectricItem.manager.canUse(itemStack, 1000) && refill < 100) {
            player.setAir(refill + 200);
            ElectricItem.manager.use(itemStack, 1000, null);
        }

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
    }
}
