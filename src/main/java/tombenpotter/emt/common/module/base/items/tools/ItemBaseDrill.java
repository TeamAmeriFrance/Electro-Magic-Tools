package tombenpotter.emt.common.module.base.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.RandomHelper;

public class ItemBaseDrill extends ItemPickaxe {

    public String textureName;

    public ItemBaseDrill(ToolMaterial material, int maxDamage, String textureName) {
        super(material);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setMaxStackSize(1);
        this.setMaxDamage(maxDamage);
        this.textureName = textureName;
        this.efficiencyOnProperMaterial = this.toolMaterial.getEfficiencyOnProperMaterial();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + textureName);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
        if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) stack.damageItem(1, entityLiving);
        return true;
    }

    @Override
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return false;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if (block.getHarvestTool(meta) == null) {
            return efficiencyOnProperMaterial;
        } else {
            if (canHarvestBlock(block, stack) && (block.getHarvestTool(meta).equals("pickaxe") || block.getHarvestTool(meta).equals("shovel"))) {
                return efficiencyOnProperMaterial;
            }
        }
        return super.getDigSpeed(stack, block, meta);
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
        return RandomHelper.placeTorch(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        if (ConfigHandler.enchanting == false) return 0;
        else return toolMaterial.getEnchantability();
    }

    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
        return ConfigHandler.enchanting;
    }
}
