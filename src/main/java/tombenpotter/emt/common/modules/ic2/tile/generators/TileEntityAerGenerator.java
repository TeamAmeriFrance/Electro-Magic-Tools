package tombenpotter.emt.common.modules.ic2.tile.generators;

import thaumcraft.api.aspects.Aspect;
import tombenpotter.emt.common.util.EssentiasOutputs;

public class TileEntityAerGenerator extends TileEntityBaseGenerator {

    public TileEntityAerGenerator() {
        aspect = Aspect.AIR;
        EssentiasOutputs.outputs.get(aspect.getTag());
    }
}
