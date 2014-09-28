package tombenpotter.emt.common.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import thaumcraft.common.entities.monster.EntityTaintChicken;
import tombenpotter.emt.common.module.ic2.IC2ModuleItemRegistry;

public class EntityEventHandler {

	@SubscribeEvent
	public void onEntityLivingDrops(LivingDropsEvent event) {

		if (event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer) {
			if (event.entityLiving instanceof EntityCreeper) {
				EntityCreeper creeper = (EntityCreeper) event.entityLiving;
				if (creeper.getPowered()) {
					event.entityLiving.entityDropItem(new ItemStack(IC2ModuleItemRegistry.itemEMTItems, 1, 6), 1);
				}
			}
			if (event.entityLiving instanceof EntityTaintChicken) {
				event.entityLiving.entityDropItem(new ItemStack(IC2ModuleItemRegistry.itemEMTItems, 1, 14), 1);
			}
		}
	}
}
