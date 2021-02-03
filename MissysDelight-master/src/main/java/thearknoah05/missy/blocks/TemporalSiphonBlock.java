package thearknoah05.missy.blocks;

import thearknoah05.missy.itemgroups.MItemGroups;
import thearknoah05.missy.other.IMakeItem;
import thearknoah05.missy.tiles.TemporalSiphonTile;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.Random;

public class TemporalSiphonBlock extends TileBlock implements IMakeItem {

    private BlockItem BLOCKITEM = new BlockItem(this, new Item.Properties().group(MItemGroups.MAIN).maxDamage(255));
    private boolean isWorking = false;

    public TemporalSiphonBlock(Properties prop, SoundType soundType, float hardness, float resistance) {
        super(prop.sound(soundType).hardnessAndResistance(hardness, resistance));
    }

    public TemporalSiphonBlock(Properties prop) {
        super(prop);
    }

    @Override
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 7;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }

    @Override
    public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public Item getItem() {
        return BLOCKITEM;
    }


    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isRemote) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TemporalSiphonTile) {
                TardisHelper.getConsoleInWorld(worldIn).ifPresent(tile -> {
                    if (worldIn.getTileEntity(te.getPos().down()) instanceof ConsoleTile) {
                        tile.getInteriorManager().setAlarmOn(true);
                        ((TemporalSiphonTile) te).isWorking = true;
                        this.isWorking = true;
                    }
                });

                if (worldIn.getBlockState(te.getPos().down()).getBlock() == TBlocks.engine) {
                    ((TemporalSiphonTile) te).setDraining(true);
                }

            }

        }
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!worldIn.isRemote) {
            TemporalSiphonTile te = (TemporalSiphonTile) worldIn.getTileEntity(pos);
            if (te != null) {
                ((TemporalSiphonTile) te).isWorking = false;
                this.isWorking = false;
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        CompoundNBT nbt = stack.getTag();
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (nbt != null) {

            float artronStored = nbt.getFloat("artron_value");
            if (tileentity instanceof TemporalSiphonTile) {
                ((TemporalSiphonTile) tileentity).setArtronNumber(artronStored);
            }
        } else {
            if (tileentity instanceof TemporalSiphonTile) {
                ((TemporalSiphonTile) tileentity).setArtronNumber(0);
            }

        }
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isRemote) {

            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TemporalSiphonTile) {

                ItemStack item = new ItemStack(MBlocks.temporal_siphon);

                CompoundNBT nbt = item.getOrCreateChildTag("artron_value");
                float artron = ((TemporalSiphonTile) tileentity).getArtronNumber();
                nbt.putFloat("artron_value", artron);
                item.setTag(nbt);

                item.setDamage(255 - (int) (255 * artron / 255));
                ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), item);
                itementity.setDefaultPickupDelay();
                worldIn.addEntity(itementity);
            }

        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        TileEntity te = worldIn.getTileEntity(pos);
        if (te instanceof TemporalSiphonTile) {
            if (this.isWorking) {
                TardisHelper.getConsoleInWorld(worldIn).ifPresent(tile -> {
                    if (tile.getArtron() > 0) {
                        // Old Reliable
                        if (rand.nextDouble() < 0.15) {
                            for (int i = 0; i < 18; ++i) {
                                double angle = Math.toRadians(i * 20);
                                double x = Math.sin(angle);
                                double z = Math.cos(angle);

                                worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), TSounds.ELECTRIC_SPARK, SoundCategory.BLOCKS, 0.5F, 1F, false);
                                worldIn.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5 + x, pos.getY() + rand.nextDouble(), pos.getZ() + 0.5 + z, 0, 0, 0);
                            }
                        }
                    }
                });
            }

        }
    }

}
