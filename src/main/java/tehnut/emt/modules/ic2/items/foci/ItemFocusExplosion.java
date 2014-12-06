package tehnut.emt.modules.ic2.items.foci;

import ic2.core.item.tool.EntityMiningLaser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemFocusExplosion extends ItemFocusIC2 {

	private static final AspectList visCost = new AspectList().add(Aspect.FIRE, 200).add(Aspect.ENTROPY, 200);

	public ItemFocusExplosion() {
		super("explosion", "focus_explosion");
	}

	@Override
	public int getFocusColor() {
		return 9990;
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "EXPLOSION";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if (wand.consumeAllVis(itemstack, player, getVisCost(), true, true)) {
			if (!world.isRemote) {
				EntityMiningLaser laser;
				laser = new EntityMiningLaser(world, player, 20, 10, 5, true);
				world.spawnEntityInWorld(laser);
			}
		}
		return itemstack;
	}
}
