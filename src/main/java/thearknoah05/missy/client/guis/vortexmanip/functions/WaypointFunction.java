package thearknoah05.missy.client.guis.vortexmanip.functions;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.containers.VMContainer;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.items.TItems;
import net.tardis.mod.items.VortexManipItem;
import net.tardis.mod.misc.vm.IVortexMFunction;
import net.tardis.mod.misc.vm.ParentFunction;

import java.util.Map;

public class WaypointFunction extends ParentFunction {
    private final TranslationTextComponent container_title = new TranslationTextComponent("container.missy.vm_Test", new Object[0]);

    public WaypointFunction(Map<Integer, IVortexMFunction> subFunctions) {
        super(subFunctions);
    }

    public WaypointFunction() {
    }

    public void onActivated(World world, PlayerEntity player) {
        player.sendMessage(new TranslationTextComponent("Test Complete"));
    }

    public void sendActionToServer(World world, ServerPlayerEntity player) {
        super.sendActionToServer(world, player);
    }

    public String getNameKey() {
        return (new TranslationTextComponent("missy.vm.waypoints", new Object[0])).getFormattedText();
    }

    public Boolean stateComplete() {
        return true;
    }

    public Boolean isServerSide() {
        return false;
    }
}
