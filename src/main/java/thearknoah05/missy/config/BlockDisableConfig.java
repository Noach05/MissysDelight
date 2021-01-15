package thearknoah05.missy.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BlockDisableConfig {
    public static ForgeConfigSpec.BooleanValue haligan_kit;
    public static ForgeConfigSpec.BooleanValue temporal_siphon;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.push("Enabled Blocks");
        haligan_kit = server.define("haligan_kit", true);
        temporal_siphon = server.define("temporal_siphon", true);
    }
}
