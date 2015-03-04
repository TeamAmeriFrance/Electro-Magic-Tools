package tehnut.emt.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import tehnut.emt.ModInformation;
import tehnut.emt.modules.ic2.tile.TileProcessor;

public class RenderProcessor extends TileEntitySpecialRenderer {

    public ModelProcessor bigModel = new ModelProcessor();
    public ModelCube smallModel = new ModelCube();
    public ResourceLocation bigTexture = new ResourceLocation(ModInformation.TEXLOC + "textures/blocks/ProcessorFormed.png");
    public ResourceLocation smallTexture = new ResourceLocation(ModInformation.TEXLOC + "textures/blocks/Processor.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        TileProcessor processor = (TileProcessor) tileEntity;
        if (processor.hasMaster() && processor.isMaster()) renderBigModel(processor, x, y, z);
        else if (!processor.hasMaster()) renderSmallModel(processor, x, y, z);
    }

    public void renderBigModel(TileProcessor tile, double x, double y, double z) {
        float scale = 0.1F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5F, (float) z + 0.5f);
        GL11.glScalef(scale, scale, scale);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(bigTexture);
        bigModel.renderAll();
        GL11.glPopMatrix();
    }

    public void renderSmallModel(TileProcessor tile, double x, double y, double z) {
        float scale = 0.1F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y - 0.5F, (float) z + 0.5f);
        GL11.glScalef(scale, scale, scale);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(smallTexture);
        smallModel.renderAll();
        GL11.glPopMatrix();
    }
}
