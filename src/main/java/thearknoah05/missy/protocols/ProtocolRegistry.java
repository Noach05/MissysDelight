package thearknoah05.missy.protocols;

import thearknoah05.missy.Missy;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.protocols.*;
import net.tardis.mod.registries.TardisRegistries;

public abstract class ProtocolRegistry extends Protocol {

    public static void registerAll() {
        TardisRegistries.registerRegisters(() -> {
            TardisRegistries.PROTOCOL_REGISTRY.register(new ResourceLocation(Missy.MODID, "kill_rooms"), new RoomTerminator());
        });
    }

}
