package thearknoah05.missy.sounds;


import net.minecraftforge.fml.common.Mod;
import net.tardis.mod.registries.Registry;
import net.tardis.mod.sounds.InteriorHum;

@Mod.EventBusSubscriber(
        modid = "missy",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class HumRegistry {
    public static final Registry<InteriorHum> MHUM_REGISTRY = new Registry();
}
