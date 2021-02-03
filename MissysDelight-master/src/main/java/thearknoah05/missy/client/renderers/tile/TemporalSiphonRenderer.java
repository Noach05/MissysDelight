package thearknoah05.missy.client.renderers.tile;

import com.mojang.blaze3d.platform.GlStateManager;
import thearknoah05.missy.Missy;
import thearknoah05.missy.client.models.tile.TemporalSiphonModel;
import thearknoah05.missy.tiles.TemporalSiphonTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;

public class TemporalSiphonRenderer extends TileEntityRenderer<TemporalSiphonTile> {

    public static TemporalSiphonModel model = new TemporalSiphonModel();
    public static final ResourceLocation TEXTURE = new ResourceLocation(Missy.MODID, "textures/blocks/temporal_siphon.png");


    @Override
    public void render(TemporalSiphonTile tile, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.pushMatrix();
        GlStateManager.translated(x + 0.5, y + 2, z+ 0.5);
        GlStateManager.rotated(180,0,0,1);
        this.bindTexture(TEXTURE);
        model.render(tile);
        GlStateManager.popMatrix();
    }

    @Override
    protected void bindTexture(ResourceLocation location) {
        Minecraft.getInstance().getTextureManager().bindTexture(location);
    }

}
