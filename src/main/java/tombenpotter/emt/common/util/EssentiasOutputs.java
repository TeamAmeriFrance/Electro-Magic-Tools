package tombenpotter.emt.common.util;

import thaumcraft.api.aspects.Aspect;

import java.util.Collection;
import java.util.HashMap;

public class EssentiasOutputs {

    public static HashMap<String, Double> outputs = new HashMap<String, Double>();

    public static void addOutput(Aspect aspect) {
        if (!aspect.isPrimal()) {
            Aspect[] parents = aspect.getComponents();
            if (Config.outputCap == (-1)) {
                outputs.put(aspect.getTag(), (outputs.get(parents[0].getTag()) + outputs.get(parents[1].getTag())));
            } else {
                double originalOutput = (outputs.get(parents[0].getTag()) + outputs.get(parents[1].getTag()));
                if (originalOutput > Config.outputCap) outputs.put(aspect.getTag(), Config.outputCap);
            }
        }
    }

    public static void addOutputs() {
        Collection<Aspect> aspectCollection = Aspect.aspects.values();
        for (Aspect aspect : aspectCollection) {
            if (!aspect.isPrimal()) addOutput(aspect);
        }
    }

    public static void addPrimalOutputs() {
        outputs.put(Aspect.FIRE.getTag(), Config.fireOutput);
        outputs.put(Aspect.WATER.getTag(), Config.waterOutput);
        outputs.put(Aspect.ORDER.getTag(), Config.orderOutput);
        outputs.put(Aspect.ENTROPY.getTag(), Config.entropyOutput);
        outputs.put(Aspect.EARTH.getTag(), Config.earthOutput);
        outputs.put(Aspect.AIR.getTag(), Config.airOutput);
    }
}
