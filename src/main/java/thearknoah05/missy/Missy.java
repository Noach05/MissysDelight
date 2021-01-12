package thearknoah05.missy;

import net.tardis.mod.events.CommonEvents;
import thearknoah05.missy.data.LootTableCreation;
import thearknoah05.missy.exterior.MissyExteriors;
import thearknoah05.missy.protocols.ProtocolRegistry;
import thearknoah05.missy.proxy.ClientProxy;
import thearknoah05.missy.proxy.IProxy;
import thearknoah05.missy.proxy.ServerProxy;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tardis.mod.registries.TardisRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Missy.MODID)
public class Missy {

    public static final String MODID = "missy";

    public static IProxy proxy;

    public static final Logger LOGGER = LogManager.getLogger();



    public Missy() {

        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event){
        DistExecutor.runWhenOn(Dist.DEDICATED_SERVER, () -> {
            return () -> proxy = new ServerProxy();
        });

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
        MissyExteriors.init();
        TardisRegistries.registerRegisters(ProtocolRegistry::registerAll);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent e) {
        e.getGenerator().addProvider(new LootTableCreation(e.getGenerator()));
    }


}
