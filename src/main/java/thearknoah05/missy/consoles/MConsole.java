package thearknoah05.missy.consoles;

import net.minecraft.block.BlockState;
import thearknoah05.missy.Missy;
import thearknoah05.missy.blocks.MBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.tardis.mod.Tardis;
import net.tardis.mod.registries.IRegisterable;
import net.tardis.mod.registries.TardisRegistries;
import net.tardis.mod.registries.consoles.Console;

@Mod.EventBusSubscriber(modid = Missy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MConsole implements IRegisterable<Console> {

    public static Console COPPER;

    @Override
    public Console setRegistryName(ResourceLocation resourceLocation) {
        return null;
    }

    @Override
    public ResourceLocation getRegistryName() {
        return null;
    }

    @SubscribeEvent
    public static void eventBusSubscriber(FMLCommonSetupEvent event) {
        TardisRegistries.registerRegisters(() -> {
            COPPER = register(new Console(() -> MBlocks.console_copper.getDefaultState(), new ResourceLocation(Missy.MODID,"textures/gui/copper.png")), "copper", new ResourceLocation(Missy.MODID,"copper"));


        });
    }

    private static Console register(Console console, String name, ResourceLocation resourceLocation) {
        console.setRegistryName(new ResourceLocation(Tardis.MODID, name));
        TardisRegistries.CONSOLE_REGISTRY.register(console.getRegistryName(), console);
        return console;
    }

}
