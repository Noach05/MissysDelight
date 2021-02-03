package thearknoah05.missy.client.renderers.consoles;

import com.mojang.blaze3d.platform.GlStateManager;

import thearknoah05.missy.Missy;
import thearknoah05.missy.client.models.consoles.CopperConsoleModel;
import thearknoah05.missy.tiles.console.CopperConsoleTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;

public class CopperConsoleRenderer extends TileEntityRenderer<CopperConsoleTile> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Missy.MODID, "textures/consoles/copper.png");
	public static final CopperConsoleModel MODEL = new CopperConsoleModel();
	
	@Override
	public void render(CopperConsoleTile tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
		GlStateManager.pushMatrix();
		GlStateManager.translated(x + 0.5, y + 1.75, z + 0.5);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scaled(1.15, 1.15, 1.15);
		GlStateManager.disableRescaleNormal();
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
