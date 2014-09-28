package tombenpotter.emt.common.module.ic2.items.armor.wings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

public class ItemQuantumWing extends ItemNanoWing {

	public ItemQuantumWing(ArmorMaterial material, int par3, int par4) {
		super(material, par3, par4);
		this.setMaxStackSize(1);
		this.setMaxDamage(27);
		this.setCreativeTab(ElectroMagicTools.tabEMT);
		maxCharge = 1000000;
		visDiscount = 6;
		transferLimit = 10000;
		energyPerDamage = 1000;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":quantumwings");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return ModInformation.texturePath + ":textures/models/quantumwing.png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (world.isRemote) {
			boolean isJumping = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
			boolean isHoldingJump = Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed();
			boolean isSneaking = Minecraft.getMinecraft().gameSettings.keyBindSneak.getIsKeyPressed();

			if (isJumping)
				player.motionY = 0.85;

			if (isHoldingJump && !player.onGround && player.motionY < 0 && !player.capabilities.isCreativeMode)
				player.motionY *= 0.3;

			if (player.isInWater() && !player.capabilities.isCreativeMode)
				player.motionY = -0.1;

			if ((player.worldObj.isRaining() || player.worldObj.isThundering()) && !player.capabilities.isCreativeMode)
				player.motionY = -0.05;

			if (isSneaking && isHoldingJump)
				player.motionY = 0;

			if (isSneaking && !player.onGround && !isHoldingJump)
				player.motionY = -0.6;


			if (player.fallDistance > 0.0F)
				player.fallDistance = 0F;
		}
	}
}
