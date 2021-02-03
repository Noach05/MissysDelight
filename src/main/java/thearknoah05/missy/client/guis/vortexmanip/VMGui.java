package thearknoah05.missy.client.guis.vortexmanip;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.client.guis.vm.IVortexMScreen;
import net.tardis.mod.client.guis.vm.widgets.DisabledTextFieldWidget;
import net.tardis.mod.client.guis.vm.widgets.VortexMButtonCatCycleDown;
import net.tardis.mod.client.guis.vm.widgets.VortexMButtonCatCycleUp;
import net.tardis.mod.client.guis.vm.widgets.VortexMButtonClose;
import net.tardis.mod.client.guis.vm.widgets.VortexMButtonFnCycleLeft;
import net.tardis.mod.client.guis.vm.widgets.VortexMButtonFnCycleRight;
import net.tardis.mod.client.guis.vm.widgets.VortexMButtonSelect;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.misc.vm.IVortexMFunction;
import net.tardis.mod.misc.vm.ParentFunction;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.VMFunctionMessage;

public class VMGui extends Screen implements IVortexMScreen {
    public static final TranslationTextComponent title = new TranslationTextComponent("gui.vm.base", new Object[0]);
    private final TranslationTextComponent selectFunc;
    private final TranslationTextComponent closeGui;
    private final TranslationTextComponent dec_func;
    private final TranslationTextComponent inc_func;
    private final TranslationTextComponent inc_subFunc;
    private final TranslationTextComponent dec_subFunc;
    private final TranslationTextComponent selected;
    private static final ResourceLocation BACKGROUND = new ResourceLocation("tardis", "textures/gui/vm_ui.png");
    public static final TranslationTextComponent locked = new TranslationTextComponent("error.tardis.vm.function_locked", new Object[0]);
    private TextFieldWidget currentFunction;
    private Button select;
    private Button fnCycleLeft;
    private Button fnCycleRight;
    private Button catCycleUp;
    private Button catCycleDown;
    private Button closeBtn;
    private Minecraft mc;
    private int id;
    private int subIndex;
    private boolean isSubFunction;

    public VMGui() {
        this(title);
        Functions.init();
    }

    public VMGui(ITextComponent title) {
        super(title);
        this.selectFunc = new TranslationTextComponent("tooltip.gui.vm.select", new Object[0]);
        this.closeGui = new TranslationTextComponent("tooltip.gui.vm.close", new Object[0]);
        this.dec_func = new TranslationTextComponent("tooltip.gui.vm.dec_func", new Object[0]);
        this.inc_func = new TranslationTextComponent("tooltip.gui.vm.inc_func", new Object[0]);
        this.inc_subFunc = new TranslationTextComponent("tooltip.gui.vm.inc_subfunc", new Object[0]);
        this.dec_subFunc = new TranslationTextComponent("tooltip.gui.vm.dec_subfunc", new Object[0]);
        this.selected = new TranslationTextComponent("gui.vm.selected_func", new Object[0]);
        this.mc = Minecraft.getInstance();
        this.id = 0;
        this.subIndex = 0;
    }

    public void renderScreen() {
        this.renderBackground();
    }

    public int getMinY() {
        return this.height / 2 + 74;
    }

    public int getMinX() {
        return this.width / 2 - 68;
    }

    public int getMaxX() {
        return this.getMinX() + 138;
    }

    public int getMaxY() {
        return this.getMinY() - 146;
    }

    public void renderBackground() {
        Minecraft.getInstance().getTextureManager().bindTexture(BACKGROUND);
        this.blit(this.width / 2 - this.texWidth() / 2, this.height / 2 - this.texHeight() / 2, 0, 0, this.texWidth(), this.texHeight());
        this.drawCenteredString(this.font, this.selected.getFormattedText(), this.getMinX() + 70, this.getMinY() - 37, 16777215);
    }

    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        if (this.select.isMouseOver((double)mouseX, (double)mouseY)) {
            this.renderTooltip(this.selectFunc.getFormattedText(), mouseX, mouseY);
        }

        if (this.closeBtn.isMouseOver((double)mouseX, (double)mouseY)) {
            this.renderTooltip(this.closeGui.getFormattedText(), mouseX, mouseY);
        }

        if (this.fnCycleLeft.isMouseOver((double)mouseX, (double)mouseY)) {
            this.renderTooltip(this.dec_func.getFormattedText(), mouseX, mouseY);
        }

        if (this.fnCycleRight.isMouseOver((double)mouseX, (double)mouseY)) {
            this.renderTooltip(this.inc_func.getFormattedText(), mouseX, mouseY);
        }

        if (this.catCycleUp.isMouseOver((double)mouseX, (double)mouseY)) {
            this.renderTooltip(this.inc_subFunc.getFormattedText(), mouseX, mouseY);
        }

        if (this.catCycleDown.isMouseOver((double)mouseX, (double)mouseY)) {
            this.renderTooltip(this.dec_subFunc.getFormattedText(), mouseX, mouseY);
        }

    }

    public void init() {
        super.init();
        boolean btnSelectW = true;
        boolean btnSelectH = true;
        boolean btnFnCycleW = true;
        boolean btnFnCycleH = true;
        FontRenderer var10003 = this.font;
        int var10004 = this.getMinX() + 25;
        int var10005 = this.getMinY() - 25;
        this.font.getClass();
        this.currentFunction = new DisabledTextFieldWidget(var10003, var10004, var10005, 90, 9 + 2, Functions.getFunction(this.id).getNameKey());
        this.fnCycleLeft = new VortexMButtonFnCycleLeft(this.getMinX() + 22, this.getMaxY() + 63, 4, 12, "", new IPressable() {
            public void onPress(Button button) {
                VMGui.this.modFunction(-1);
            }
        });
        this.fnCycleRight = new VortexMButtonFnCycleRight(this.getMinX() + 38, this.getMaxY() + 63, 4, 12, "", new IPressable() {
            public void onPress(Button button) {
                VMGui.this.modFunction(1);
            }
        });
        this.catCycleUp = new VortexMButtonCatCycleUp(this.getMinX() + 26, this.getMaxY() + 59, 4, 12, "", new IPressable() {
            public void onPress(Button button) {
                VMGui.this.modSubFunction(1);
            }
        });
        this.catCycleDown = new VortexMButtonCatCycleDown(this.getMinX() + 26, this.getMaxY() + 74, 4, 12, "", new IPressable() {
            public void onPress(Button button) {
                VMGui.this.modSubFunction(-1);
            }
        });
        this.select = new VortexMButtonSelect(this.getMinX() + 42, this.getMaxY() + 48, 14, 14, "", new IPressable() {
            public void onPress(Button button) {
                ParentFunction function = Functions.getFunction(VMGui.this.id);
                if (function.stateComplete().equals(false)) {
                    VMGui.this.currentFunction.setText(VMGui.locked.getFormattedText());
                }

                if (function.getSubFunctionById(VMGui.this.subIndex) != null && function.getSubFunctionById(VMGui.this.subIndex).stateComplete().equals(false)) {
                    VMGui.this.currentFunction.setText(VMGui.locked.getFormattedText());
                } else if (VMGui.this.isSubFunction) {
                    Functions.getFunction(VMGui.this.id).getSubFunctionById(VMGui.this.subIndex).onActivated(VMGui.this.mc.world, VMGui.this.mc.player);
                    Network.sendToServer(new VMFunctionMessage(VMGui.this.id, VMGui.this.subIndex, true, function.getSubFunctionById(VMGui.this.subIndex).isServerSide()));
                } else {
                    Functions.getFunction(VMGui.this.id).onActivated(VMGui.this.mc.world, VMGui.this.mc.player);
                    Network.sendToServer(new VMFunctionMessage(VMGui.this.id, VMGui.this.subIndex, false, function.isServerSide()));
                }

            }
        });
        this.closeBtn = new VortexMButtonClose(this.getMinX() + 79, this.getMaxY() + 48, 14, 14, "", new IPressable() {
            public void onPress(Button button) {
                VMGui.this.onClose();
            }
        });
        this.buttons.clear();
        this.addButton(this.select);
        this.addButton(this.fnCycleLeft);
        this.addButton(this.fnCycleRight);
        this.addButton(this.catCycleUp);
        this.addButton(this.catCycleDown);
        this.addButton(this.currentFunction);
        this.addButton(this.closeBtn);
        this.currentFunction.setEnabled(false);
        this.currentFunction.setText((new StringTextComponent(Functions.getFunction(this.id).getNameKey())).applyTextStyle(TextFormatting.BLUE).getFormattedText());
        this.currentFunction.setCursorPositionZero();
    }

    public void onClose() {
        this.minecraft.displayGuiScreen((Screen)null);
        PlayerHelper.closeVMModel(this.minecraft.player);
    }

    public boolean isPauseScreen() {
        return false;
    }

    public boolean keyPressed(int keyCode, int scanCode, int bitmaskModifier) {
        boolean rightKey = true;
        boolean leftKey = true;
        boolean upKey = true;
        boolean downKey = true;
        boolean escKey = true;
        boolean enterKey = true;
        switch(keyCode) {
            case 256:
                this.onClose();
                return true;
            case 257:
                this.select.onPress();
                return true;
            case 258:
            case 259:
            case 260:
            case 261:
            default:
                return super.keyPressed(keyCode, scanCode, bitmaskModifier);
            case 262:
                this.modFunction(1);
                return true;
            case 263:
                this.modFunction(-1);
                return true;
            case 264:
                this.modSubFunction(-1);
                return true;
            case 265:
                this.modSubFunction(1);
                return true;
        }
    }

    public void modFunction(int amount) {
        if (this.id + amount > Functions.getFunctionList().size() - 1) {
            this.id = 0;
        } else if (this.id + amount < 0) {
            this.id = Functions.getFunctionList().size() - 1;
        } else {
            this.id += amount;
        }

        if (Functions.getFunctionList().containsKey(this.id)) {
            this.currentFunction.setText((new StringTextComponent(Functions.getFunction(this.id).getNameKey())).applyTextStyle(TextFormatting.BLUE).getFormattedText());
            this.currentFunction.setCursorPositionZero();
            this.subIndex = 0;
            this.isSubFunction = false;
        }

    }

    public void modSubFunction(int amount) {
        ParentFunction function = Functions.getFunction(this.id);
        if (this.subIndex + amount > function.getSubFunctionList().size() - 1) {
            this.subIndex = 0;
        } else if (this.subIndex + amount < 0) {
            this.subIndex = function.getSubFunctionList().size() - 1;
            if (function.getSubFunctionList().size() == 0) {
                this.subIndex = 0;
            }
        } else {
            this.subIndex += amount;
        }

        if (function.getSubFunctionList().containsKey(this.subIndex)) {
            IVortexMFunction subFunction = Functions.getFunction(this.id).getSubFunctionById(this.subIndex);
            this.currentFunction.setText((new StringTextComponent(subFunction.getNameKey())).applyTextStyle(TextFormatting.BLUE).getFormattedText());
            this.currentFunction.setCursorPositionZero();
            this.isSubFunction = true;
        }

    }

    public int texWidth() {
        return 138;
    }

    public int texHeight() {
        return 146;
    }
}
