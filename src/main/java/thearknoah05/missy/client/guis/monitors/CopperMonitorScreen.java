package thearknoah05.missy.client.guis.monitors;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.client.guis.monitors.BaseMonitorScreen;
import net.tardis.mod.sounds.TSounds;


public class CopperMonitorScreen extends BaseMonitorScreen {
    @Override
    public static final ResourceLocation TEXTURE = new ResourceLocation("missy", "textures/gui/monitors/coppermonitor.png");

    public CopperMonitorScreen() {
    }

    @Override
    public void renderMonitor() {
        Minecraft.getInstance().getTextureManager().bindTexture(TEXTURE);
        this.renderBackground();
        int guiWidth = 255;
        int guiHeight = 182;
        this.blit(this.width / 2 - guiWidth / 2, this.height / 2 - guiHeight / 2, 0, 0, guiWidth, guiHeight);
    }

    protected void init() {
        super.init();
        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(TSounds.EYE_MONITOR_INTERACT, 1.0F));
    }

    @Override
    public int getMinY() {
        return this.height / 2 + 45;
    }

    @Override
    public int getMinX() {
        return this.width / 2 - 100;
    }

    @Override
    public int getMaxX() {
        return this.getMinX() + 200;
    }

    @Override
    public int getMaxY() {
        return this.getMinY() - 120;
    }

    @Override
    public int getWidth() {
        return 200;
    }

    @Override
    public int getHeight() {
        return 135;
    }

    @Override
    public int getGuiID() {
        return 8;
    }
}
