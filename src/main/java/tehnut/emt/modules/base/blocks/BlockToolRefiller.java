package tehnut.emt.modules.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockToolRefiller extends BlockBaseContainer {

	public BlockToolRefiller() {
		super("toolRefiller", "machines/side", Material.iron, soundTypeMetal, 4.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return null;
	}
}
