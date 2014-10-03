package tombenpotter.emt.common.modules.base.items.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import thaumcraft.common.entities.projectile.EntityAlumentum;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.TextHelper;

import java.util.List;

public class ItemThorHammerBroken extends ItemThorHammer {

	public ItemThorHammerBroken() {
		this.setUnlocalizedName(getUnlocalizedName() + ".broken");
		this.setTextureName(ModInformation.texturePath + ":hammer/taintedthorhammer");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.swingItem();
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX + 8, player.posY, player.posZ - 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX - 8, player.posY, player.posZ + 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX - 8, player.posY, player.posZ - 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX + 8, player.posY, player.posZ + 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX, player.posY + 4, player.posZ));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX, player.posY + 8, player.posZ));

		if (player.capabilities.isCreativeMode) {
			return itemstack;
		} else {
			itemstack.damageItem(20, player);
			return itemstack;
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 2F);
		itemstack.damageItem(1, attacker);
		return true;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List list, boolean par4) {
		list.add(TextHelper.localize("tooltip.EMT.hammer.broken.thor"));
		list.add(TextHelper.localize("tooltip.EMT.hammer.broken.danger"));
		if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add(TextHelper.localize("tooltip.EMT.hammer.broken.plsNoRightClick"));
		} else {
			list.add(TextHelper.localize("tooltip.EMT.hammer.broken.plsRightClick"));
		}
	}
}
