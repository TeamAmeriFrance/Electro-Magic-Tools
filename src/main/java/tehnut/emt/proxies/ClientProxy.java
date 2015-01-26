package tehnut.emt.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import tehnut.emt.model.RenderProcessor;
import tehnut.emt.modules.ic2.tile.TileProcessor;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileProcessor.class, new RenderProcessor());
    }
}
