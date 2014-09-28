/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package tombenpotter.emt.common.module.base;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.common.module.base.entities.EntityArcher;
import tombenpotter.emt.common.module.base.entities.EntityLaser;

public class EMTEntityRegistry {

	private static int startEID = 300;
	private static int entityIDs = 0;
	private static final Class<? extends EntityLiving> ARCHER_CLASS = EntityArcher.class;

	private static int getUniqueEntityID() {

		do {
			startEID++;
		} while (EntityList.getStringFromID(startEID) != null);
		return startEID;
	}

	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int colPrim, int colSec) {
		int id = getUniqueEntityID();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, colPrim, colSec));
		return;
	}

	public static void registerEMTEntities() {

		EntityRegistry.registerModEntity(EntityLaser.class, "entityLaser", entityIDs++, ElectroMagicTools.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityArcher.class, "entityArcher", entityIDs++, ElectroMagicTools.instance, 80, 3, true);
		registerEntityEgg(ARCHER_CLASS, 0x99111F, 0xE5685);
	}
}
