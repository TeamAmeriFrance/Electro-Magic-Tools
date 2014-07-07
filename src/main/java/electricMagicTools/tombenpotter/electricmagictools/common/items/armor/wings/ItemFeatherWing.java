package electricMagicTools.tombenpotter.electricmagictools.common.items.armor.wings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.client.model.ModelWings;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemFeatherWing extends ItemArmor {

    public ItemFeatherWing() {
        super(EnumHelper.addArmorMaterial("EMTWINGFEATHER", 1, new int[]{2, 2, 2, 2}, 6), 7, 1);
        this.setMaxStackSize(1);
        this.setMaxDamage(120);
        this.setCreativeTab(CreativeTab.tabTombenpotter);
        this.isDamageable();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ElectricMagicTools.texturePath + ":featherwings");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ElectricMagicTools.texturePath + ":textures/models/featherwing.png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
        return new ModelWings();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) {
            boolean isJumping = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isHoldingJump = Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed();
            boolean isSneaking = Minecraft.getMinecraft().gameSettings.keyBindSneak.getIsKeyPressed();

            if (isJumping) {
                player.motionY = 0.25;
                player.fallDistance = 0;
            }

            if (isHoldingJump && !player.onGround && player.motionY < 0 && !player.capabilities.isCreativeMode) {
                player.motionY *= 0.9;
                player.fallDistance = 0;
            }

            if (player.isInWater() && !player.capabilities.isCreativeMode)
                player.motionY = -0.6;

            if ((player.worldObj.isRaining() || player.worldObj.isThundering()) && !player.capabilities.isCreativeMode)
                player.motionY = -0.3;

            if (isSneaking && !player.onGround) {
                player.motionY = -0.6;
                player.fallDistance = 0F;
            }

            if (player.fallDistance > 0.0F)
                player.fallDistance -= 0.25F;
        }
    }
}
