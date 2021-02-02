package thearknoah05.missy.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tardis.mod.registries.SoundSchemeRegistry;
import net.tardis.mod.sounds.SoundSchemeBase;
import thearknoah05.missy.Missy;


@Mod.EventBusSubscriber(
        modid = "missy",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class MSoundSchemeRegistry extends SoundSchemeRegistry {
    public static final SoundSchemeMissy MISSY =  (SoundSchemeMissy)register(new SoundSchemeMissy(), "missy");

    public MSoundSchemeRegistry() {
    }

    public static <T extends SoundSchemeBase> T register(T scheme, String name) {
        scheme.setRegistryName(new ResourceLocation(Missy.MODID, name));
        return scheme;
    }

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<SoundSchemeBase> event) {
        event.getRegistry().registerAll(new SoundSchemeBase[]{MISSY});
    }
}
