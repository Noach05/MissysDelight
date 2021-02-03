package thearknoah05.missy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.tardis.mod.misc.IDontBreak;

public class MConsoleBlock extends TileBlock implements IDontBreak {
    public MConsoleBlock() {
        super(Block.Properties.create(Material.BARRIER).variableOpacity().hardnessAndResistance(99999F, 99999F));
    }
}
