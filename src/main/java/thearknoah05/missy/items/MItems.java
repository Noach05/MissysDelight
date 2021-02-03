package thearknoah05.missy.items;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import thearknoah05.missy.Missy;
import thearknoah05.missy.blocks.MBlocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Missy.MODID, bus = Bus.MOD)
public class MItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(

        );

        for(Item item : MBlocks.ITEMS){
            event.getRegistry().register(item);
        }
    }

    public static <T extends Item> T createItem(T item, String name){
        item.setRegistryName(Missy.MODID, name);
        return item;
    }
}


