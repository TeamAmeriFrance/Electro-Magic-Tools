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
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.ConfigHandler;

public class ItemNanoGoggles extends ItemElectricGoggles {

    public ItemNanoGoggles(ArmorMaterial material, int par3, int par4) {
        super(material, par3, par4);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setMaxDamage(27);
        this.setMaxStackSize(1);
        visDiscount = 6;
        tier = 3;
        maxCharge = 100000;
        energyPerDamage = 1000;
        transferLimit = 100;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":armor/goggles_nano");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ModInformation.texturePath + ":textures/models/thaumicnanohelmet.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
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
    }
}
