package thearknoah05.missy.itemgroups;

import thearknoah05.missy.Missy;
import thearknoah05.missy.blocks.MBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Missy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MItemGroups {

    public static ItemGroup MAIN = new ItemGroup(Nissy.MODID + ".main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(MBlocks.toaster);
        }
    };

    @SubscribeEvent
    public static void registerItemGroups(FMLCommonSetupEvent event) {}

}
