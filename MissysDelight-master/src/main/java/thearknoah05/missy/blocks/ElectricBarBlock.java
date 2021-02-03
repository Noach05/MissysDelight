package thearknoah05.missy.blocks;

import thearknoah05.missy.damagesrc.MDamageSource;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ElectricBarBlock extends PaneBlock {

    public ElectricBarBlock(Properties prop) {
        super(prop);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {

        if (!worldIn.isRemote()){
            if (worldIn.getGameTime() % 20 == 0) {
                entityIn.attackEntityFrom(MDamageSource.ELECTRICITY, 3f);
            }
        } else {

            Random rand = new Random();
            for(int i = 0; i < 18; ++ i) {
                double angle = Math.toRadians(i * 60);
                double x = Math.sin(angle);
                double z = Math.cos(angle);
                worldIn.addParticle(ParticleTypes.SMOKE, entityIn.posX + x, entityIn.posY + rand.nextDouble(), entityIn.posZ + z, 0, 0, 0);
            }

        }

    }

}
