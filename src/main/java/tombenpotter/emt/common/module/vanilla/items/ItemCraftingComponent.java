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

    public IIcon[] icon = new IIcon[100];
    public final String drillTop = "drillTop";
    public final String chainsawTop = "chainsawTop";
    public final String omnitoolTop = "omnitoolTop";
    public final String shard = "shard";

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
            case 18: {
                name = omnitoolTop + ".iron";
                break;
            }
            case 19: {
                name = omnitoolTop + ".gold";
                break;
            }
            case 20: {
                name = omnitoolTop + ".diamond";
                break;
            }
            case 21: {
                name = omnitoolTop + ".copper";
                break;
            }
            case 22: {
                name = omnitoolTop + ".tin";
                break;
            }
            case 23: {
                name = omnitoolTop + ".lead";
                break;
            }
            case 24: {
                name = omnitoolTop + ".bronze";
                break;
            }
            case 25: {
                name = shard + ".wood";
                break;
            }
            case 26: {
                name = shard + ".stone";
                break;
            }
            case 27: {
                name = shard + ".iron";
                break;
            }
            case 28: {
                name = shard + ".gold";
                break;
            }
            case 29: {
                name = shard + ".obsidian";
                break;
            }
            case 30: {
                name = shard + ".copper";
                break;
            }
            case 31: {
                name = shard + ".tin";
                break;
            }
            case 32: {
                name = shard + ".lead";
                break;
            }
            case 33: {
                name = shard + ".bronze";
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

        this.icon[18] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "iron");
        this.icon[19] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "gold");
        this.icon[20] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "diamond");
        this.icon[21] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "copper");
        this.icon[22] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "tin");
        this.icon[23] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "lead");
        this.icon[24] = ri.registerIcon(ModInformation.texturePath + ":materials/" + omnitoolTop + "_" + "bronze");

        this.icon[25] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "wood");
        this.icon[26] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "stone");
        this.icon[27] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "iron");
        this.icon[28] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "gold");
        this.icon[29] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "diamond");
        this.icon[30] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "copper");
        this.icon[31] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "tin");
        this.icon[32] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "lead");
        this.icon[33] = ri.registerIcon(ModInformation.texturePath + ":materials/" + shard + "_" + "bronze");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i <= 33; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
