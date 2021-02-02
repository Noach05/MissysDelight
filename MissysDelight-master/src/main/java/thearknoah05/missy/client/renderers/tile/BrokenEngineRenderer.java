package thearknoah05.missy.client.renderers.tile;

import com.mojang.blaze3d.platform.GlStateManager;
import thearknoah05.missy.Missy;
import thearknoah05.missy.client.models.tile.BrokenEngineModel;
import thearknoah05.missy.tiles.BrokenEngineTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;

public class BrokenEngineRenderer extends TileEntityRenderer<BrokenEngineTile> {

    public static final BrokenEngineModel MODEL = new BrokenEngineModel();
    public static final ResourceLocation TEXTURE = new ResourceLocation(Missy.MODID, "textures/tiles/broken_engine.png");


    @Override
    public void render(BrokenEngineTile tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.pushMatrix();
        GlStateManager.translated(x + 0.5, y + 1.5, z + 0.5);
        GlStateManager.rotated(180, 0, 0, 1);
        this.bindTexture(TEXTURE);
        MODEL.render(tileEntityIn);
        GlStateManager.popMatrix();
    }

    @Override
    protected void bindTexture(ResourceLocation location) {
        Minecraft.getInstance().getTextureManager().bindTexture(location);
    }

}
