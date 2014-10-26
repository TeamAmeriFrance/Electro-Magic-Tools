package tombenpotter.emt.common.modules.base.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tombenpotter.emt.ModInformation;

public class BaseBlockRegistry {

    public static Block portableNode;
    public static Block toolRefiller;

    public static void registerBaseBlocks() {
        portableNode = new BlockPortableNode().setBlockName(ModInformation.modid + ".portablenode");
        GameRegistry.registerBlock(portableNode, "PortableNode");
        toolRefiller = new BlockToolRefiller("toolRefiller", Material.iron, "tool_refiller", Block.soundTypeMetal, 4.0F);
        GameRegistry.registerBlock(toolRefiller, "ToolRefiller");
    }
}
