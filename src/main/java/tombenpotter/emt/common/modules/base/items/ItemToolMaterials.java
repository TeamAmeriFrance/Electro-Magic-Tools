package tombenpotter.emt.common.modules.base.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import tombenpotter.emt.ModInformation;

import java.util.List;

public class ItemToolMaterials extends ItemBase {

	public IIcon[] icon = new IIcon[32];
	public final String drillTop = "drillTop";
	public final String chainsawTop = "chainsawTop";

	public ItemToolMaterials() {
		super("materials.tools");
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
			default:
				name = "nothing";
				break;
			case 0: {
				name = drillTop + ".wood";
				break;
			}
			case 1: {
				name = drillTop + ".stone";
				break;
			}
			case 2: {
				name = drillTop + ".iron";
				break;
			}
			case 3: {
				name = drillTop + ".gold";
				break;
			}
			case 4: {
				name = drillTop + ".diamond";
				break;
			}
			case 5: {
				name = drillTop + ".copper";
				break;
			}
			case 6: {
				name = drillTop + ".tin";
				break;
			}
			case 7: {
				name = drillTop + ".lead";
				break;
			}
			case 8: {
				name = drillTop + ".bronze";
				break;
			}
			case 9: {
				name = chainsawTop + ".wood";
				break;
			}
			case 10: {
				name = chainsawTop + ".stone";
				break;
			}
			case 11: {
				name = chainsawTop + ".iron";
				break;
			}
			case 12: {
				name = chainsawTop + ".gold";
				break;
			}
			case 13: {
				name = chainsawTop + ".diamond";
				break;
			}
			case 14: {
				name = chainsawTop + ".copper";
				break;
			}
			case 15: {
				name = chainsawTop + ".tin";
				break;
			}
			case 16: {
				name = chainsawTop + ".lead";
				break;
			}
			case 17: {
				name = chainsawTop + ".bronze";
				break;
			}
		}
		return getUnlocalizedName() + "." + name;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ri) {
		this.icon[0] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "wood");
		this.icon[1] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "stone");
		this.icon[2] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "iron");
		this.icon[3] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "gold");
		this.icon[4] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "diamond");
		this.icon[5] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "copper");
		this.icon[6] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "tin");
		this.icon[7] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "lead");
		this.icon[8] = ri.registerIcon(ModInformation.texturePath + ":materials/" + drillTop + "_" + "bronze");

		this.icon[9] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "wood");
		this.icon[10] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "stone");
		this.icon[11] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "iron");
		this.icon[12] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "gold");
		this.icon[13] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "diamond");
		this.icon[14] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "copper");
		this.icon[15] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "tin");
		this.icon[16] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "lead");
		this.icon[17] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "bronze");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return this.icon[meta];
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i <= 17; i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
}
