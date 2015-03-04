package tehnut.emt.modules.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tehnut.emt.modules.base.tile.TileMultiblock;

public class BlockMultiblock extends BlockBaseContainer {

    public BlockMultiblock(String unlocName, Material material, SoundType soundType, float hardness) {
        super(unlocName, material, soundType, hardness);
    }

    public BlockMultiblock(String unlocName, String textureName, Material material, SoundType soundType, float hardness) {
        super(unlocName, textureName, material, soundType, hardness);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileMultiblock) {
            TileMultiblock multiblock = (TileMultiblock) tile;
            if (multiblock.getMaster() != null) {
                return multiblock.getMaster().onBlockRightClicked(player, side, hitX, hitY, hitZ);
            }
        }
        return false;
    }
}
