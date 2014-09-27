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
package tombenpotter.emt.proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;
import tombenpotter.emt.client.renderer.RenderArcher;
import tombenpotter.emt.client.renderer.RenderLaser;
import tombenpotter.emt.common.module.base.entities.EntityArcher;
import tombenpotter.emt.common.module.base.entities.EntityLaser;

public class ClientProxy extends CommonProxy {

    @Override
    public void load() {
        registerRenders();
    }

    public void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
        RenderingRegistry.registerEntityRenderingHandler(EntityArcher.class, new RenderArcher());
    }
}
