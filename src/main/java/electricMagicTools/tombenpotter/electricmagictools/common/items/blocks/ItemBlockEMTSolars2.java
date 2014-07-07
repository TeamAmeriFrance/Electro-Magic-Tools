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
package electricMagicTools.tombenpotter.electricmagictools.common.items.blocks;

import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockEMTSolars2 extends ItemBlock {

    public ItemBlockEMTSolars2(Block id) {
        super(id);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "doubleair";
                break;
            }
            case 1: {
                name = "tripleair";
                break;
            }
            case 2: {
                name = "earth";
                break;
            }
            case 3: {
                name = "doubleearth";
                break;
            }
            case 4: {
                name = "tripleearth";
                break;
            }
            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }

    @Override
    public int getMetadata(int par1) {
        return par1;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
        if (GuiScreen.isShiftKeyDown()) {
            switch (itemstack.getItemDamage()) {
                case 0: {
                    list.add("Normal Conditions: " + Config.doubleCompressedSolarOutput + " EU/T");
                    list.add("Special Effect: Output multiplied by 2.5 when the block is over Y = 160");
                    break;
                }
                case 1: {
                    list.add("Normal Conditions: " + Config.tripleCompressedSolarOutput + " EU/T");
                    list.add("Special Effect: Output multiplied by 2.5 when the block is over Y = 160");
                    break;
                }
                case 2: {
                    list.add("Normal Conditions: " + Config.compressedSolarOutput + " EU/T");
                    list.add("Special Effect: Output multiplied by 2.5 when the block is under Y = 10");
                    break;
                }
                case 3: {
                    list.add("Normal Conditions: " + Config.doubleCompressedSolarOutput + " EU/T");
                    list.add("Special Effect: Output multiplied by 2.5 when the block is under Y = 10");
                    break;
                }
                case 4: {
                    list.add("Normal Conditions: " + Config.tripleCompressedSolarOutput + " EU/T");
                    list.add("Special Effect: Output multiplied by 2.5 when the block is under Y = 10");
                    break;
                }
                default:
                    list.add("Didn't I forget a tooltip?");
                    break;
            }
        }
    }
}
