package tombenpotter.emt.common.module.ic2.items.foci;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import tombenpotter.emt.common.module.base.items.foci.ItemBaseFocus;
import tombenpotter.emt.common.util.Config;
import tombenpotter.emt.ElectroMagicTools;
import ic2.api.item.ElectricItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemWandChargingFocus extends ItemBaseFocus {

    AspectList visCost = new AspectList();

    public ItemWandChargingFocus() {
        super();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ElectroMagicTools.texturePath + ":wandchargefocus");
    }

    @Override
    public int getFocusColor() {
        return 0xFFFF450;
    }

    @Override
    public String getSortingHelper(ItemStack itemstack) {
        return "ELECTRICCHARGING";
    }

    @Override
    public boolean isVisCostPerTick() {
        return true;
    }

    @Override
    public AspectList getVisCost() {
        return visCost;
    }

    @Override
    public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int integer) {

        if (!player.worldObj.isRemote) {
            ItemWandCasting wandItem = (ItemWandCasting) itemstack.getItem();

            ItemStack armor = player.inventory.armorInventory[1];
            if (armor != null) {
                if ((ElectricItem.manager.use(armor, Config.wandChargeFocusCost / 4, player) && (ElectricItem.manager.use(armor, Config.wandChargeFocusCost / 4, player)) && (ElectricItem.manager.use(armor, Config.wandChargeFocusCost / 4, player)) && (ElectricItem.manager.use(armor, Config.wandChargeFocusCost / 4, player)))) {
                    wandItem.addVis(itemstack, Aspect.ORDER, 1, true);
                    wandItem.addVis(itemstack, Aspect.FIRE, 1, true);
                    wandItem.addVis(itemstack, Aspect.ENTROPY, 1, true);
                    wandItem.addVis(itemstack, Aspect.WATER, 1, true);
                    wandItem.addVis(itemstack, Aspect.EARTH, 1, true);
                    wandItem.addVis(itemstack, Aspect.AIR, 1, true);
                }
            }
        }
    }
}
