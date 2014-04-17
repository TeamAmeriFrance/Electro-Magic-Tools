package electricMagicTools.tombenpotter.electricmagictools.common.items;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemEMTBaubles extends Item implements IBauble {
	public IIcon[] icon = new IIcon[16];

	public ItemEMTBaubles() {
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "euMaker.armor";
			break;
		}
		case 1: {
			name = "euMaker.inventory";
			break;
		}
		case 2: {
			name = "oneRing";
			break;
		}
		default:
			name = "nothing";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ri) {
		this.icon[0] = ri.registerIcon("electricmagictools:armoreumaker");
		this.icon[1] = ri.registerIcon("electricmagictools:inventoryeumaker");
		this.icon[2] = ri.registerIcon("electricmagictools:onering");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return this.icon[meta];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
		list.add(new ItemStack(this, 1, 2));
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if (stack.getItemDamage() == 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public BaubleType getBaubleType(ItemStack stack) {
		if (stack.getItemDamage() <= 2) {
			return BaubleType.RING;
		} else {
			return null;
		}
	}

	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase player) {
		if (stack != null) {
			if (stack.getItemDamage() == 0) {
				if (player instanceof EntityPlayer) {
					int energyLeft = Config.armorBaubleProduction;
					for (int i = 0; i < ((EntityPlayer) player).inventory.armorInventory.length; i++) {
						if (energyLeft > 0) {
							if ((((EntityPlayer) player).inventory.armorInventory[i] != null) && (((EntityPlayer) player).inventory.armorInventory[i].getItem() instanceof IElectricItem)) {
								int sentPacket = ElectricItem.manager.charge(((EntityPlayer) player).inventory.armorInventory[i], energyLeft, 4, false, false);
								energyLeft -= sentPacket;
							}
						}
					}
				}
			}
		}
		if (stack != null) {
			if (stack.getItemDamage() == 1) {
				if (player instanceof EntityPlayer) {
					int energyLeft = Config.inventoryBaubleProdution;
					for (int i = 0; i < ((EntityPlayer) player).inventory.mainInventory.length; i++) {
						if (energyLeft > 0) {
							if ((((EntityPlayer) player).inventory.mainInventory[i] != null) && (((EntityPlayer) player).inventory.mainInventory[i].getItem() instanceof IElectricItem)) {
								int sentPacket = ElectricItem.manager.charge(((EntityPlayer) player).inventory.mainInventory[i], energyLeft, 4, false, false);
								energyLeft -= sentPacket;
							}
						}
					}
				}
			}
		}

		if (stack != null && stack.getItemDamage() == 2) {
			if (player instanceof EntityPlayer) {
				((EntityPlayer) player).capabilities.disableDamage = true;
			}
		}
	}

	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase player) {
		if (stack != null && stack.getItemDamage() == 2) {
			player.setInvisible(true);
		}
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase player) {
		if (stack != null && stack.getItemDamage() == 2) {
			player.setInvisible(false);
			if (player instanceof EntityPlayer)
				((EntityPlayer) player).capabilities.disableDamage = false;
		}
	}

	@Override
	public boolean canEquip(ItemStack stack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack stack, EntityLivingBase player) {
		return true;
	}
}
