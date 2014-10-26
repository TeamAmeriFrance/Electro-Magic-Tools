package tombenpotter.emt.common.modules.ic2.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IEssentiaContainerItem;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.modules.ic2.tile.generators.TileEntityEssentiaGenerator;

public class BlockEssentiaGenerator extends BlockEMT {

    public BlockEssentiaGenerator() {
        super(Material.iron);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setHardness(4.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ri) {
        this.blockIcon = ri.registerIcon(ModInformation.texturePath + ":machines/top");
        this.top[0] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/top");
        this.bottom[0] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/top");
        this.side[0] = ri.registerIcon(ModInformation.texturePath + ":essentiagenerator/side");
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityEssentiaGenerator();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        TileEntityEssentiaGenerator tile = (TileEntityEssentiaGenerator) world.getTileEntity(x, y, z);
        if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof IEssentiaContainerItem) {
            IEssentiaContainerItem item = (IEssentiaContainerItem) player.getHeldItem().getItem();
            Aspect aspect = item.getAspects(player.getHeldItem()).getAspects()[0];
            if (tile.isFree[0]) {
                tile.aspects[0] = aspect.getTag();
                tile.isFree[0] = false;
            } else if (tile.isFree[1]) {
                tile.aspects[1] = aspect.getTag();
                tile.isFree[1] = false;
            } else if (tile.isFree[2]) {
                tile.aspects[2] = aspect.getTag();
                tile.isFree[2] = false;
            } else if (tile.isFree[3]) {
                tile.aspects[3] = aspect.getTag();
                tile.isFree[3] = false;
            }
            return true;
        } else if (player.getHeldItem() == null && player.isSneaking()) {
            for (int i = 0; i < tile.aspects.length; i++) {
                if (!tile.isFree[i]) {
                    tile.isFree[i] = true;
                }
            }
            return true;
        }
        return false;
    }
}
