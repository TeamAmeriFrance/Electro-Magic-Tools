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

    public IIcon[] icon = new IIcon[500];
    public final String drillTop = "DrillTop";
    public final String chainsawTop = "ChainsawTop";

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
                name = "wooden" + drillTop;
                break;
            }
            case 1: {
                name = "stone" + drillTop;
                break;
            }
            case 2: {
                name = "iron" + drillTop;
                break;
            }
            case 3: {
                name = "golden" + drillTop;
                break;
            }
            case 4: {
                name = "diamond" + drillTop;
                break;
            }
            case 5: {
                name = "copper" + drillTop;
                break;
            }
            case 6: {
                name = "tin" + drillTop;
                break;
            }
            case 7: {
                name = "lead" + drillTop;
                break;
            }
            case 8: {
                name = "tin" + drillTop;
                break;
            }
            case 9: {
                name = "wooden" + chainsawTop;
                break;
            }
            case 10: {
                name = "stone" + chainsawTop;
                break;
            }
            case 11: {
                name = "iron" + chainsawTop;
                break;
            }
            case 12: {
                name = "golden" + chainsawTop;
                break;
            }
            case 13: {
                name = "diamond" + chainsawTop;
                break;
            }
            case 14: {
                name = "copper" + chainsawTop;
                break;
            }
            case 15: {
                name = "tin" + chainsawTop;
                break;
            }
            case 16: {
                name = "lead" + chainsawTop;
                break;
            }
            case 17: {
                name = "tin" + chainsawTop;
                break;
            }
        }
        return getUnlocalizedName() + "." + name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri) {
        this.icon[0] = ri.registerIcon(ModInformation.texturePath + ":wooden" + drillTop);
        this.icon[1] = ri.registerIcon(ModInformation.texturePath + ":stone" + drillTop);
        this.icon[2] = ri.registerIcon(ModInformation.texturePath + ":iron" + drillTop);
        this.icon[3] = ri.registerIcon(ModInformation.texturePath + ":golden" + drillTop);
        this.icon[4] = ri.registerIcon(ModInformation.texturePath + ":diamond" + drillTop);
        this.icon[5] = ri.registerIcon(ModInformation.texturePath + ":copper" + drillTop);
        this.icon[6] = ri.registerIcon(ModInformation.texturePath + ":tin" + drillTop);
        this.icon[7] = ri.registerIcon(ModInformation.texturePath + ":lead" + drillTop);
        this.icon[8] = ri.registerIcon(ModInformation.texturePath + ":bronze" + drillTop);

        this.icon[9] = ri.registerIcon(ModInformation.texturePath + ":wooden" + chainsawTop);
        this.icon[10] = ri.registerIcon(ModInformation.texturePath + ":stone" + chainsawTop);
        this.icon[11] = ri.registerIcon(ModInformation.texturePath + ":iron" + chainsawTop);
        this.icon[12] = ri.registerIcon(ModInformation.texturePath + ":golden" + chainsawTop);
        this.icon[13] = ri.registerIcon(ModInformation.texturePath + ":diamond" + chainsawTop);
        this.icon[14] = ri.registerIcon(ModInformation.texturePath + ":copper" + chainsawTop);
        this.icon[15] = ri.registerIcon(ModInformation.texturePath + ":tin" + chainsawTop);
        this.icon[16] = ri.registerIcon(ModInformation.texturePath + ":lead" + chainsawTop);
        this.icon[17] = ri.registerIcon(ModInformation.texturePath + ":bronze" + chainsawTop);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i <= 32; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
