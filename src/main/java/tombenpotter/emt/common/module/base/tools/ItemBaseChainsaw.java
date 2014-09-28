package tombenpotter.emt.common.module.base.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.IRefillable;
import tombenpotter.emt.common.util.RandomHelper;

public class ItemBaseChainsaw extends ItemAxe implements IRefillable {

    public String textureName;

    public ItemBaseChainsaw(ToolMaterial material, int maxDamage, String textureName) {
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
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        if (stack.getItemDamage() < 1) stack.setItemDamage(1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int par4, int par5, int par6, EntityLivingBase entityLiving) {
        if (stack.getItemDamage() > 1) stack.damageItem(1, entityLiving);
        return true;
    }

    @Override
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return Items.diamond_axe.canHarvestBlock(block, stack) || Items.diamond_sword.canHarvestBlock(block, stack) || Items.shears.canHarvestBlock(block, stack);
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if (stack.getItemDamage() <= 1) return 1.0F;
        if (Items.wooden_axe.getDigSpeed(stack, block, meta) > 1.0F || Items.wooden_sword.getDigSpeed(stack, block, meta) > 1.0F) {
            return efficiencyOnProperMaterial;
        } else return super.getDigSpeed(stack, block, meta);

    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entityliving, EntityLivingBase attacker) {
        if (stack.getItemDamage() <= 1) {
            entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 12F);
            stack.damageItem(1, attacker);
        }
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
    public int getItemEnchantability() {
        if (ConfigHandler.enchanting == false) return 0;
        else return toolMaterial.getEnchantability();
    }

    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
        return ConfigHandler.enchanting;
    }
}
