package tombenpotter.emt.common.modules.te.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class BlockTE extends Block {

	public BlockTE(String unlocName, Material material, String textureName, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.modid + ".module.te." + unlocName);
		setBlockTextureName(ModInformation.texturePath + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setStepSound(soundType);
		setHardness(hardness);
	}

	public BlockTE(String unlocName, Material material, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.modid + ".module.te." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setStepSound(soundType);
		setHardness(hardness);
	}
}
