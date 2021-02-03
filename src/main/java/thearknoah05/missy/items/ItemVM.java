package thearknoah05.missy.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.VortexManipItem;
import thearknoah05.missy.Missy;
import thearknoah05.missy.client.guis.vortexmanip.VMGui;

import javax.annotation.Nullable;
import java.util.List;

public class ItemVM extends VortexManipItem {

    public ItemVM() {
        super();
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) {
        return super.getShareTag(stack);
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack stack = player.getHeldItem(handIn);
        if (stack != ItemStack.EMPTY && worldIn.isRemote && !player.getCooldownTracker().hasCooldown(this)) {
            Minecraft.getInstance().displayGuiScreen(new VMGui());
            stack.getCapability(Capabilities.VORTEX_MANIP).ifPresent((cap) -> {
                cap.setOpen(true);
            });
        }

        return new ActionResult(ActionResultType.SUCCESS, stack);
    }
}
