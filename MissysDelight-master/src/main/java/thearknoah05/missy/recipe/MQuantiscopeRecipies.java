package thearknoah05.missy.recipe;

import thearknoah05.missy.Missy;
import thearknoah05.missy.blocks.MBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.tardis.mod.recipe.WeldRecipe;

@Mod.EventBusSubscriber(modid = Missy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MQuantiscopeRecipies {

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event){
        WeldRecipe.WELD_RECIPE.add(new WeldRecipe(Item.getItemFromBlock(MBlocks.temporal_siphon), false, Items.ACACIA_LEAVES));
        WeldRecipe.WELD_RECIPE.add(new WeldRecipe(Item.getItemFromBlock(MBlocks.halligan_kit), false, Items.STONE));
    }

}
