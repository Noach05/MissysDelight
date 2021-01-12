package thearknoah05.missy.client;

import thearknoah05.missy.Missy;
import thearknoah05.missy.client.renderers.consoles.CopperConsoleRenderer;
import thearknoah05.missy.client.renderers.entity.adventure.WatcherRenderer;
import thearknoah05.missy.client.renderers.entity.passive.TemporalBatRenderer;
import thearknoah05.missy.client.renderers.exterior.BoothExteriorRenderer;
import thearknoah05.missy.client.renderers.tile.BrokenEngineRenderer;
import thearknoah05.missy.client.renderers.tile.TemporalSiphonRenderer;
import thearknoah05.missy.entity.adventure.WatcherEntity;
import thearknoah05.missy.entity.passive.TemporalBatEntity;
import thearknoah05.missy.tiles.BrokenEngineTile;
import thearknoah05.missy.tiles.TemporalSiphonTile;
import thearknoah05.missy.tiles.console.CopperConsoleTile;
import thearknoah05.missy.tiles.exterior.BoothExteriorTile;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Missy.MODID, bus = Bus.MOD)
public class ModelRegistry {

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(TemporalBatEntity.class, TemporalBatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WatcherEntity.class, WatcherRenderer::new);


        ClientRegistry.bindTileEntitySpecialRenderer(BoothExteriorTile.class, new BoothExteriorRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(CopperConsoleTile.class, new CopperConsoleRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TemporalSiphonTile.class, new TemporalSiphonRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(BrokenEngineTile.class, new BrokenEngineRenderer());

    }
}

