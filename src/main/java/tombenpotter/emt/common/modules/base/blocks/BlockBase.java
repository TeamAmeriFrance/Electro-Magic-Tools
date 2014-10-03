package tombenpotter.emt.common.modules.base.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class BlockBase extends Block {

	public BlockBase(String unlocName, Material material, String textureName, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.modid + ".module.base." + unlocName);
		setBlockTextureName(ModInformation.texturePath + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setStepSound(soundType);
		setHardness(hardness);
	}

	public BlockBase(String unlocName, Material material, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.modid + ".module.base." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setStepSound(soundType);
		setHardness(hardness);
	}
}