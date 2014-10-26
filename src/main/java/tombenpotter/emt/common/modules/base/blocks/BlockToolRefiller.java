package tombenpotter.emt.common.modules.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockToolRefiller extends BlockBaseContainer {

    public BlockToolRefiller(String unlocName, Material material, SoundType soundType, float hardness) {
        super(unlocName, material, soundType, hardness);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
