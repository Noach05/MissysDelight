package thearknoah05.missy.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.registries.IRegisterable;
import net.tardis.mod.registries.TardisRegistries;

public class MInteriorHum implements IRegisterable<MInteriorHum> {
    private ResourceLocation name;
    private SoundEvent event;
    private int duration;

    private MInteriorHum(SoundEvent event, int duration) {
        this.event = event;
        this.duration = duration;
    }

    public static void registerAll() {
        TardisRegistries.registerRegisters(() -> {
        //    HumRegistry.MHUM_REGISTRY.register("missy", new MInteriorHum(MSounds.MISSYS_HUM, 1800));
});
    }

    public SoundEvent getEvent() {
        return this.event;
    }

    public int getDurationInTicks() {
        return this.duration;
    }

    public String getTranslatedName() {
        return (new TranslationTextComponent("hum." + this.name, new Object[0])).getFormattedText();
    }

    public MInteriorHum setRegistryName(ResourceLocation regName) {
        this.name = regName;
        return this;
    }

    public ResourceLocation getRegistryName() {
        return this.name;
    }
}
