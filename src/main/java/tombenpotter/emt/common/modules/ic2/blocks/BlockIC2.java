package tombenpotter.emt.common.modules.ic2.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class BlockIC2 extends Block {

	public BlockIC2(String unlocName, Material material, String textureName, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.modid + ".module.ic2." + unlocName);
		setBlockTextureName(ModInformation.texturePath + ":" + textureName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setStepSound(soundType);
		setHardness(hardness);
	}

	public BlockIC2(String unlocName, Material material, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.modid + ".module.ic2." + unlocName);
		setCreativeTab(ElectroMagicTools.tabEMT);
		setStepSound(soundType);
		setHardness(hardness);
	}
}
