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
import tombenpotter.emt.common.modules.ic2.tile.solars.air.TileEntityDoubleAirSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.air.TileEntityTripleAirSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.earth.TileEntityDoubleEarthSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.earth.TileEntityEarthSolar;
import tombenpotter.emt.common.modules.ic2.tile.solars.earth.TileEntityTripleEarthSolar;

import java.util.List;

public class BlockEMTSolars2 extends BlockBaseContainer {

    public BlockEMTSolars2() {
        super(Material.iron);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setHardness(4.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ri) {
        this.top[0] = ri.registerIcon(ModInformation.texturePath + ":solars/air/doublesolartop");
        this.top[1] = ri.registerIcon(ModInformation.texturePath + ":solars/air/triplesolartop");
        this.top[2] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/solartop");
        this.top[3] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/doublesolartop");
        this.top[4] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/triplesolartop");

        this.bottom[0] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airbottom");
        this.bottom[1] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airbottom");
        this.bottom[2] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthbottom");
        this.bottom[3] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthbottom");
        this.bottom[4] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthbottom");

        this.frontOff[0] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");
        this.frontOff[1] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");
        this.frontOff[2] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthside");
        this.frontOff[3] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthside");
        this.frontOff[4] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthside");

        this.side[0] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");
        this.side[1] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");
        this.side[2] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthside");
        this.side[3] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthside");
        this.side[4] = ri.registerIcon(ModInformation.texturePath + ":solars/earth/earthside");
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 4; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        if (meta == 0) {
            return new TileEntityDoubleAirSolar();
        }
        if (meta == 1) {
            return new TileEntityTripleAirSolar();
        }
        if (meta == 2) {
            return new TileEntityEarthSolar();
        }
        if (meta == 3) {
            return new TileEntityDoubleEarthSolar();
        }
        if (meta == 4) {
            return new TileEntityTripleEarthSolar();
        }
        return super.createTileEntity(world, meta);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
        world.removeTileEntity(x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }
}
