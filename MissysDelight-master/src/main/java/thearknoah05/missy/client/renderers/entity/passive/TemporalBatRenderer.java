package thearknoah05.missy.client.renderers.entity.passive;

import com.mojang.blaze3d.platform.GlStateManager;
import thearknoah05.missy.Missy;
import thearknoah05.missy.client.models.entity.passive.TemporalBatModel;
import thearknoah05.missy.entity.passive.TemporalBatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TemporalBatRenderer extends MobRenderer<TemporalBatEntity, TemporalBatModel> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Missy.MODID, "textures/entity/temporal_bat.png");
    public static final TemporalBatModel MODEL = new TemporalBatModel();

    public TemporalBatRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, MODEL, 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(TemporalBatEntity entity) {
        return TEXTURE;
    }

    @Override
    public void doRender(TemporalBatEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.color4f(0.7F, 0.7F, 1F, 0.5F);
            super.doRender(entity,x,y,z,entityYaw,partialTicks);
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
    }
}

