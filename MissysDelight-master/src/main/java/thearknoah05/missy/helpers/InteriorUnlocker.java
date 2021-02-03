package thearknoah05.missy.helpers;

import thearknoah05.missy.Missy;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.tardis.mod.ars.ConsoleRoom;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.Helper;

public class InteriorUnlocker {

    public static void checkAchievementsForUnlock(EntityJoinWorldEvent event) {
        interiorAdvancementCheck(event, new ResourceLocation(Missy.MODID,"interior/crystalline_interior"), new ResourceLocation(Missy.MODID, "interior_crystalline"));
        interiorAdvancementCheck(event, new ResourceLocation(Missy.MODID,"interior/victorian_interior"), new ResourceLocation(Missy.MODID, "interior_victorian"));
        interiorAdvancementCheck(event, new ResourceLocation(Missy.MODID,"interior/potent_interior"), new ResourceLocation(Missy.MODID, "interior_potent"));
    }


    private static void interiorAdvancementCheck(EntityJoinWorldEvent event, ResourceLocation advancement, ResourceLocation interior)
    {
        if(event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity)event.getEntity();

            Helper.doIfAdvancementPresentOther(advancement, player, () ->{
                TardisHelper.getConsoleInWorld(event.getWorld()).ifPresent(console -> {
                    ConsoleRoom room = ConsoleRoom.REGISTRY.get(interior);
                    net.tardis.mod.helper.Helper.unlockInterior(console, player, room);
                });
            });


        }

    }
}
