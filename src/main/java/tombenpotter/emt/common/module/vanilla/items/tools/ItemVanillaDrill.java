package tombenpotter.emt.common.module.vanilla.items.tools;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.module.base.items.tools.ItemBaseDrill;
import tombenpotter.emt.common.util.IRefillable;

public class ItemVanillaDrill extends ItemBaseDrill implements IRefillable {

    public Item repairMaterial;
    public int repairMeta;

    public ItemVanillaDrill(ToolMaterial material, int maxDamage, String textureName, Item repairMaterial) {
        super(material, maxDamage, textureName);
        this.repairMaterial = repairMaterial;
        this.repairMeta = 0;
    }

    public ItemVanillaDrill(ToolMaterial material, int maxDamage, String textureName, Item repairMaterial, int repairMeta) {
        super(material, maxDamage, textureName);
        this.repairMaterial = repairMaterial;
        this.repairMeta = repairMeta;
    }

    @Override
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return (block.getHarvestLevel(new ItemStack(Item.getItemFromBlock(block)).getItemDamage()) <= this.toolMaterial.getHarvestLevel());
    }

    @Override
    public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
        return (stack2.getItem() == repairMaterial && stack2.getItemDamage() == repairMeta) ? true : super.getIsRepairable(stack1, stack2);
    }

    @Override
    public boolean isRepairable() {
        return true;
    }
}
