package thearknoah05.missy.sounds;

import thearknoah05.missy.Missy;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.CheckForNull;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = Missy.MODID, bus = Bus.MOD)
@ObjectHolder(Missy.MODID)
public class MSounds {


    public static final SoundEvent DRILL_LOOP = null;
    public static final SoundEvent THROTTLE_BLAST = null;
    public static final SoundEvent ALERT_ALARM = null;
    public static final SoundEvent TIME_VORTEX = null;
    public static final SoundEvent BELL_RING = null;
    public static final SoundEvent MISSYS_ALARM = null;
    public static final SoundEvent MISSYS_HUM = null;
    public static final SoundEvent MISSYS_LANDING = null;
    public static final SoundEvent MISSYS_TAKE_OFF =  null;

    private static HashMap<ResourceLocation, ISoundScheme> SCHEMES = new HashMap<ResourceLocation, ISoundScheme>();

    @SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event){
        event.getRegistry().registerAll(
                // SOUNDS
            setUpSound("drill_loop"),
            setUpSound("throttle_blast"),
            setUpSound("alert_alarm"),
            setUpSound("time_vortex"),
            setUpSound("bell_ring"),
            setUpSound("missys_alarm"),
            setUpSound("missys_hum"),
            setUpSound("missys_landing"),
            setUpSound("missys_take_off")

        );
    }

    public static SoundEvent setUpSound(String soundName) {
        return new SoundEvent(new ResourceLocation(Missy.MODID, soundName)).setRegistryName(soundName);
    }

    public static void registerSoundScheme(ResourceLocation loc, ISoundScheme scheme) {
        scheme.setRegistryName(loc);
        SCHEMES.put(loc, scheme);
    }

    @CheckForNull
    public static ISoundScheme getSoundByRegistryName(ISoundScheme scheme) {
        return SCHEMES.getOrDefault(scheme, null);
    }

}
