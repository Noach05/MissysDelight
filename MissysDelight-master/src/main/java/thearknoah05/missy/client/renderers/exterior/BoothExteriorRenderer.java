package thearknoah05.missy.client.renderers.exterior;

import com.mojang.blaze3d.platform.GlStateManager;
import thearknoah05.missy.Missy;
import thearknoah05.missy.client.models.exteriors.BoothExteriorModel;
import thearknoah05.missy.tiles.exterior.BoothExteriorTile;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;


public class BoothExteriorRenderer extends ExteriorRenderer<BoothExteriorTile>{

    public static final BoothExteriorModel model = new BoothExteriorModel();

    public static final ResourceLocation TEXTURE = new ResourceLocation(Missy.MODID, "textures/exteriors/booth.png");

    @Override
    public void renderExterior(BoothExteriorTile boothExteriorTile) {
        GlStateManager.pushMatrix();
        GlStateManager.translated(0,-0.5f,0);
        GlStateManager.scaled(0.7f, 0.7f, 0.7f);
        this.bindTexture(TEXTURE);
        model.render(boothExteriorTile);
        GlStateManager.popMatrix();
    }


    @Override
    protected void bindTexture(ResourceLocation location) {
        Minecraft.getInstance().getTextureManager().bindTexture(location);
    }

}
