package amerifrance.emt.modules.ic2.research;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class IC2ResearchAspects {

    //Armors
    public static AspectList electricGoggles = new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ENERGY, 5).add(Aspect.SENSES, 6);
    public static AspectList nanoGoggles = new AspectList().add(Aspect.ENERGY, 5).add(Aspect.SENSES, 8).add(Aspect.ARMOR, 6);
    public static AspectList quantumGoggles = new AspectList().add(Aspect.ARMOR, 8).add(Aspect.ENERGY, 4).add(Aspect.SENSES, 6);
    public static AspectList solarHelmet = new AspectList().add(Aspect.ENERGY, 5).add(Aspect.AIR, 2).add(Aspect.LIGHT, 4);

    public static AspectList electricBoots = new AspectList().add(Aspect.ENERGY, 2).add(Aspect.ARMOR, 5).add(Aspect.MOTION, 2);
    public static AspectList nanoBoots = new AspectList().add(Aspect.ENERGY, 3).add(Aspect.ARMOR, 5).add(Aspect.MOTION, 3);
    public static AspectList quantumBoots = new AspectList().add(Aspect.ENERGY, 4).add(Aspect.ARMOR, 5).add(Aspect.MOTION, 4);

    public static AspectList nanoWings = new AspectList().add(Aspect.FLIGHT, 5).add(Aspect.AIR, 5).add(Aspect.MECHANISM, 8).add(Aspect.ENERGY, 4);
    public static AspectList quantumWings = new AspectList().add(Aspect.FLIGHT, 5).add(Aspect.AIR, 5).add(Aspect.MECHANISM, 8).add(Aspect.ENERGY, 4);

    //Tools
    public static AspectList thaumiumDrill = new AspectList().add(Aspect.ENERGY, 5).add(Aspect.TOOL, 6).add(Aspect.MINE, 4);
    public static AspectList rockbreakerDrill = new AspectList().add(Aspect.ENERGY, 3).add(Aspect.FIRE, 2).add(Aspect.MINE, 3);

    public static AspectList thaumiumChainsaw = new AspectList().add(Aspect.ENERGY, 5).add(Aspect.WEAPON, 6).add(Aspect.TOOL, 4);
    public static AspectList streamChainsaw = new AspectList().add(Aspect.TOOL, 3).add(Aspect.TREE, 3).add(Aspect.WATER, 6).add(Aspect.ENERGY, 4);

    public static AspectList diamondOmnitool = new AspectList().add(Aspect.ENERGY, 2).add(Aspect.TOOL, 3).add(Aspect.MINE, 2).add(Aspect.WEAPON, 2);
    public static AspectList thaumiumOnmitool = new AspectList().add(Aspect.ENERGY, 5).add(Aspect.TOOL, 6).add(Aspect.MINE, 4).add(Aspect.WEAPON, 6);

    //Essentia Generator
    public static AspectList essentiaGenerator = new AspectList().add(Aspect.ENERGY, 4).add(Aspect.EXCHANGE, 4).add(Aspect.METAL, 3).add(Aspect.AURA, 5);

    //Solar Panels
    public static AspectList compressedSolars = new AspectList().add(Aspect.ENERGY, 4).add(Aspect.LIGHT, 3).add(Aspect.METAL, 2);
    public static AspectList airSolars = new AspectList().add(Aspect.AIR, 4).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 4);
    public static AspectList darkSolars = new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 4);
    public static AspectList earthSolars = new AspectList().add(Aspect.EARTH, 4).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 4);
    public static AspectList fireSolars = new AspectList().add(Aspect.FIRE, 4).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 4);
    public static AspectList orderSolars = new AspectList().add(Aspect.ORDER, 4).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 4);
    public static AspectList waterSolars = new AspectList().add(Aspect.WATER, 4).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 4);

    //Wand Charging Station
    public static AspectList wandCharger = new AspectList().add(Aspect.ENERGY, 4).add(Aspect.CRAFT, 2).add(Aspect.EXCHANGE, 3).add(Aspect.GREED, 5);
}
