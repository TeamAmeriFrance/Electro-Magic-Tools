package tehnut.emt.modules.base.items.foci;

import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemFocusChristmas extends ItemFocusBase {

	private static final AspectList visCost = new AspectList().add(Aspect.ORDER, 500).add(Aspect.AIR, 500);

	public ItemFocusChristmas() {
		super("christmas", "focus_christmas");
	}

	@Override
	public int getFocusColor() {
		return 99999999;
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack stack) {
		return "CHRISTMAS";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack stack, World world, EntityPlayer player, MovingObjectPosition mop) {
		ItemWandCasting wand = (ItemWandCasting) stack.getItem();
		if ((mop != null) && (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)) {
			int x = mop.blockX;
			int y = mop.blockY + 1;
			int z = mop.blockZ;
			if (wand.consumeAllVis(stack, player, getVisCost(), true, true)) {
				if (!world.isRemote) {
					EntitySnowman snowman;
					snowman = new EntitySnowman(world);
					snowman.setPosition(x, y, z);
					world.spawnEntityInWorld(snowman);
				}
			}
			player.swingItem();
		}
		return stack;
	}
}
