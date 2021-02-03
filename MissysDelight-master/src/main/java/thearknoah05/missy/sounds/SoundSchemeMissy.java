package thearknoah05.missy.sounds;

import net.tardis.mod.sounds.SoundSchemeBasic;
import net.tardis.mod.sounds.TSounds;

public class SoundSchemeMissy extends SoundSchemeBasic {
    public SoundSchemeMissy() {
        super(() -> {
            return MSounds.MISSYS_TAKE_OFF;
        }, () -> {
            return MSounds.MISSYS_LANDING;
        }, () -> {
            return TSounds.TARDIS_FLY_LOOP;
        });
    }

    public int getLandTime(){return 480;}

    public int getTakeoffTime(){return 440;}

}
