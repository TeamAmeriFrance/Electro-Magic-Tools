package tehnut.emt.modules.ic2.blocks;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import tehnut.emt.modules.ic2.items.blocks.*;

public class IC2BlockRegistry {

	public static Block machines;
	public static Block solars1;
	public static Block solars2;

	public static void registerBlocks() {
		machines = new BlockMachines();
		GameRegistry.registerBlock(machines, ItemBlockMachines.class, "BlockMachines");

		solars1 = new BlockSolars1();
		GameRegistry.registerBlock(solars1, ItemBlockSolars1.class, "BlockSolars1");
		solars2 = new BlockSolars2();
		GameRegistry.registerBlock(solars2, ItemBlockSolars2.class, "BlockSolars2");
	}
}
