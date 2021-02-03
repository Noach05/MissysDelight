package thearknoah05.missy.tiles;

import com.google.common.base.Supplier;
import thearknoah05.missy.Missy;
import thearknoah05.missy.blocks.MBlocks;
import thearknoah05.missy.blocks.TileBlock;
import thearknoah05.missy.tiles.console.CopperConsoleTile;
import thearknoah05.missy.tiles.exterior.BoothExteriorTile;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Missy.MODID, bus = Bus.MOD)
public class MTiles {

    public static List<TileEntityType<?>> TYPES = new ArrayList<>();


    // Consoles
    public static TileEntityType<CopperConsoleTile> CONSOLE_COPPER = register(CopperConsoleTile::new, "console_copper", MBlocks.console_copper);

    // Exteriors
    public static TileEntityType<BoothExteriorTile> EXTERIOR_BOOTH = register(BoothExteriorTile::new, "exterior_booth", MBlocks.exterior_booth);

    // Devices
    public static TileEntityType<TemporalSiphonTile> TEMPORAL_SIPHON = register(TemporalSiphonTile::new, "temporal_siphon", MBlocks.temporal_siphon);
    public static TileEntityType<HalliganKitTile> HALLIGAN_KIT = register(HalliganKitTile::new, "halligan_kit", MBlocks.halligan_kit);

    // Other
    public static TileEntityType<BrokenEngineTile> BROKEN_ENGINE = register(BrokenEngineTile::new, "broken_engine", MBlocks.broken_engine);

    @SubscribeEvent
    public static void register(RegistryEvent.Register<TileEntityType<?>> event){
        for (TileEntityType<?> type : TYPES) {
            event.getRegistry().register(type);
        }
    }

    public static <T extends TileEntity> TileEntityType<T> register(Supplier<T> tile, String name, Block... validBlock) {
        TileEntityType<T> type = TileEntityType.Builder.create(tile, validBlock).build(null);
        type.setRegistryName(Missy.MODID, name);
        TYPES.add(type);
        for(Block block : validBlock) {
            if(block instanceof TileBlock) {
                ((TileBlock)block).setTileEntity(type);
            }
        }
        return type;
    }

}
