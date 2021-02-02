package thearknoah05.missy.client.renderers.entity.adventure;

import com.mojang.blaze3d.platform.GlStateManager;
import thearknoah05.missy.Missy;
import thearknoah05.missy.entity.adventure.WatcherEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;

public class WatcherRenderer extends BipedRenderer<WatcherEntity, PlayerModel<WatcherEntity>> {

    public WatcherRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PlayerModel<WatcherEntity>(0.0625F, false), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(WatcherEntity entity) {
        return new ResourceLocation(Missy.MODID, "textures/entity/watcher.png");
    }

    @Override
    public void doRender(WatcherEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.color4f(1F, 1F, 1F, entity.getView());
        super.doRender(entity,x,y,z,entityYaw,partialTicks);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

}
