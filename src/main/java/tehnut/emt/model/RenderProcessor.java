package tehnut.emt.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import tehnut.emt.ModInformation;

public class RenderProcessor extends TileEntitySpecialRenderer {

    public ModelProcessor model = new ModelProcessor();
    public ResourceLocation texture = new ResourceLocation(ModInformation.TEXLOC + "textures/blocks/Processor.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float p_147500_8_) {
        float scale = 0.1F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.0F, (float) z + 0.5F);
        GL11.glScalef(scale, scale, scale);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
        GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
