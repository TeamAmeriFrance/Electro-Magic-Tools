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

package tombenpotter.emt.common.modules.ic2.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.modules.base.blocks.BlockBaseContainer;
import tombenpotter.emt.common.modules.ic2.tile.solars.air.TileEntityAirSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.compressed.TileEntityCompressedSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.compressed.TileEntityDoubleCompressedSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.compressed.TileEntityTripleCompressedSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.dark.TileEntityDarkSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.dark.TileEntityDoubleDarkSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.dark.TileEntityTripleDarkSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.fire.TileEntityDoubleFireSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.fire.TileEntityFireSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.fire.TileEntityTripleFireSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.order.TileEntityDoubleOrderSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.order.TileEntityOrderSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.order.TileEntityTripleOrderSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.water.TileEntityDoubleWaterSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.water.TileEntityTripleWaterSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.water.TileEntityWaterSolar;

import java.util.List;

public class BlockEMTSolars extends BlockBaseContainer {

    public BlockEMTSolars() {
        super(Material.iron);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setHardness(4.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ri) {
        this.top[0] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");
        this.top[1] = ri.registerIcon(ModInformation.texturePath + ":solars/doublesolartop");
        this.top[2] = ri.registerIcon(ModInformation.texturePath + ":solars/triplesolartop");
        this.top[3] = ri.registerIcon(ModInformation.texturePath + ":solars/water/solartop");
        this.top[4] = ri.registerIcon(ModInformation.texturePath + ":solars/water/doublesolartop");
        this.top[5] = ri.registerIcon(ModInformation.texturePath + ":solars/water/triplesolartop");
        this.top[6] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/solartop");
        this.top[7] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/doublesolartop");
        this.top[8] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/triplesolartop");
        this.top[9] = ri.registerIcon(ModInformation.texturePath + ":solars/order/solartop");
        this.top[10] = ri.registerIcon(ModInformation.texturePath + ":solars/order/doublesolartop");
        this.top[11] = ri.registerIcon(ModInformation.texturePath + ":solars/order/triplesolartop");
        this.top[12] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/solartop");
        this.top[13] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/doublesolartop");
        this.top[14] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/triplesolartop");
        this.top[15] = ri.registerIcon(ModInformation.texturePath + ":solars/air/solartop");

        this.bottom[0] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
        this.bottom[1] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
        this.bottom[2] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
        this.bottom[3] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterbottom");
        this.bottom[4] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterbottom");
        this.bottom[5] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterbottom");
        this.bottom[6] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkbottom");
        this.bottom[7] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkbottom");
        this.bottom[8] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkbottom");
        this.bottom[9] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderbottom");
        this.bottom[10] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderbottom");
        this.bottom[11] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderbottom");
        this.bottom[12] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/firebottom");
        this.bottom[13] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/firebottom");
        this.bottom[14] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/firebottom");
        this.bottom[15] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airbottom");

        this.frontOff[0] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
        this.frontOff[1] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
        this.frontOff[2] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
        this.frontOff[3] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
        this.frontOff[4] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
        this.frontOff[5] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
        this.frontOff[6] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
        this.frontOff[7] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
        this.frontOff[8] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
        this.frontOff[9] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
        this.frontOff[10] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
        this.frontOff[11] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
        this.frontOff[12] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
        this.frontOff[13] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
        this.frontOff[14] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
        this.frontOff[15] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");

        this.side[0] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
        this.side[1] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
        this.side[2] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
        this.side[3] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
        this.side[4] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
        this.side[5] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
        this.side[6] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
        this.side[7] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
        this.side[8] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
        this.side[9] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
        this.side[10] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
        this.side[11] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
        this.side[12] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
        this.side[13] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
        this.side[14] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
        this.side[15] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 15; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        if (meta == 0) {
            return new TileEntityCompressedSolar();
        }
        if (meta == 1) {
            return new TileEntityDoubleCompressedSolar();
        }
        if (meta == 2) {
            return new TileEntityTripleCompressedSolar();
        }
        if (meta == 3) {
            return new TileEntityWaterSolar();
        }
        if (meta == 4) {
            return new TileEntityDoubleWaterSolar();
        }
        if (meta == 5) {
            return new TileEntityTripleWaterSolar();
        }
        if (meta == 6) {
            return new TileEntityDarkSolar();
        }
        if (meta == 7) {
            return new TileEntityDoubleDarkSolar();
        }
        if (meta == 8) {
            return new TileEntityTripleDarkSolar();
        }
        if (meta == 9) {
            return new TileEntityOrderSolar();
        }
        if (meta == 10) {
            return new TileEntityDoubleOrderSolar();
        }
        if (meta == 11) {
            return new TileEntityTripleOrderSolar();
        }
        if (meta == 12) {
            return new TileEntityFireSolar();
        }
        if (meta == 13) {
            return new TileEntityDoubleFireSolar();
        }
        if (meta == 14) {
            return new TileEntityTripleFireSolar();
        }
        if (meta == 15) {
            return new TileEntityAirSolar();
        }
        return super.createTileEntity(world, meta);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
        world.removeTileEntity(x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }
}
