package tombenpotter.emt.common.util;

import tombenpotter.emt.common.modules.ic2.IC2Research;

public class RegistryHandler {

    public static void registerIc2PostRegistrys() {
        IC2Research.addResearchTab();
        IC2Research.addResearch();
    }
}
