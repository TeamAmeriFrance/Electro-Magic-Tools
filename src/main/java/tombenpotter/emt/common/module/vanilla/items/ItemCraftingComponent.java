package tombenpotter.emt.common.module.vanilla.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

import java.util.List;

public class ItemCraftingComponent extends Item {

    public IIcon[] icon = new IIcon[17];
    public final String drillTop = "drillTop";
    public final String chainsawTop = "chainsawTop";

    public ItemCraftingComponent() {
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
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
                name = chainsawTop + ".wood";
                break;
            }
            case 9: {
                name = chainsawTop + ".stone";
                break;
            }
            case 10: {
                name = chainsawTop + ".iron";
                break;
            }
            case 11: {
                name = chainsawTop + ".gold";
                break;
            }
            case 12: {
                name = chainsawTop + ".diamond";
                break;
            }
            case 13: {
                name = chainsawTop + ".copper";
                break;
            }
            case 14: {
                name = chainsawTop + ".tin";
                break;
            }
            case 15: {
                name = chainsawTop + ".lead";
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

	    this.icon[8] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "wood");
	    this.icon[9] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "stone");
	    this.icon[10] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "iron");
	    this.icon[11] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "gold");
	    this.icon[12] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "diamond");
	    this.icon[13] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "copper");
	    this.icon[14] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "tin");
	    this.icon[15] = ri.registerIcon(ModInformation.texturePath + ":materials/" + chainsawTop + "_" + "lead");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i <= 15; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
