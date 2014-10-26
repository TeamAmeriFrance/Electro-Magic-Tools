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
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.modules.ic2.tile.generators.*;

import java.util.List;
import java.util.Random;

public class BlockEssentiaGenerators extends BlockEMT {

    public BlockEssentiaGenerators() {
        super(Material.iron);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setHardness(4.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ri) {
        this.blockIcon = ri.registerIcon(ModInformation.texturePath + ":machines/top");

        for (int i = 0; i <= 5; i++) {
            this.top[i] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/top");
        }

        for (int i = 0; i <= 5; i++) {
            this.bottom[i] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/top");
        }

        for (int i = 0; i <= 5; i++) {
            this.side[i] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/side");
        }

        this.frontOff[0] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/potentiafront");
        this.frontOff[1] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/ignisfront");
        this.frontOff[2] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/auramfront");
        this.frontOff[3] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/arborfront");
        this.frontOff[4] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/aerfront");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        list.add(new ItemStack(id, 1, 0));
        list.add(new ItemStack(id, 1, 1));
        list.add(new ItemStack(id, 1, 2));
        list.add(new ItemStack(id, 1, 3));
        list.add(new ItemStack(id, 1, 4));
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        if (meta == 0) {
            return new TileEntityPotentiaGenerator();
        }
        if (meta == 1) {
            return new TileEntityIgnisGenerator();
        }
        if (meta == 2) {
            return new TileEntityAuramGenerator();
        }
        if (meta == 3) {
            return new TileEntityArborGenerator();
        }
        if (meta == 4) {
            return new TileEntityAerGenerator();
        }
        return super.createTileEntity(world, meta);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        float f = (float) par2 + 0.5F;
        float f1 = (float) par3 + 1.0F;
        float f2 = (float) par4 + 0.5F;
        par1World.spawnParticle("largesmoke", f, f1, f2, 0.0D, 0.0D, 0.0D);
    }
}
