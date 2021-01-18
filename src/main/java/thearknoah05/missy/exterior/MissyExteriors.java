package thearknoah05.missy.exterior;

import net.minecraft.util.ResourceLocation;
import net.tardis.mod.exterior.ExteriorRegistry;
import net.tardis.mod.exterior.IExterior;
import net.tardis.mod.exterior.TwoBlockBasicExterior;
import net.tardis.mod.misc.IDoorType;
import thearknoah05.missy.Missy;
import thearknoah05.missy.blocks.MBlocks;

import java.util.ArrayList;

public class MissyExteriors {

    public static TwoBlockBasicExterior BOOTH;


    // Registers all the exteriors.
    public static <T extends IExterior> T register(ResourceLocation key, T ext) {
        ext.setRegistryName(key);
        ExteriorRegistry.register(key, ext);
        return ext;
    }

    public static IExterior getExterior(ResourceLocation key) {return ExteriorRegistry.getExterior(key);}

    public static ArrayList<IExterior> getDefExteriors(){
        ArrayList<IExterior> list = new ArrayList<>();
        // Get all unlocked exteriors.
        for (IExterior ext : ExteriorRegistry.getRegistry().values()) {
            if(ext.isDefault())
                list.add(ext);
        }
        return list;
    }

    public static void init() {
//        BOOTH = register(new ResourceLocation(Missy.MODID, "booth"), new TwoBlockBasicExterior(() -> MBlocks.exterior_booth.getDefaultState(), true, IDoorType.EnumDoorType.TT_CAPSULE, new ResourceLocation(Missy.MODID, "textures/gui/exteriors/woah.png")));
    }

}
