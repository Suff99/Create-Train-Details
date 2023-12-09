package mc.craig.software.train_details.blocks;

import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock;
import mc.craig.software.train_details.TrainDetailsBlocks;
import mc.craig.software.train_details.blockentity.CustomWhistleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class CustomWhistles extends WhistleBlock {

    private final Supplier<SoundEvent> soundEvent;

    public CustomWhistles(Properties properties, Supplier<SoundEvent> soundEventSupplier) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(POWERED, false)
                .setValue(WALL, false)
                .setValue(SIZE, WhistleSize.SMALL));
        this.soundEvent = soundEventSupplier;
    }

    public Supplier<SoundEvent> getSoundEvent() {
        return soundEvent;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Level level = pContext.getLevel();
        BlockPos clickedPos = pContext.getClickedPos();
        Direction face = pContext.getClickedFace();
        boolean wall = true;
        if (face.getAxis() == Direction.Axis.Y) {
            face = pContext.getHorizontalDirection()
                    .getOpposite();
            wall = false;
        }

        BlockState state = this.defaultBlockState().setValue(FACING, face)
                .setValue(POWERED, level.hasNeighborSignal(clickedPos))
                .setValue(WALL, wall);
        if (!canSurvive(state, level, clickedPos))
            return null;
        return state;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CustomWhistleBlockEntity(TrainDetailsBlocks.CUSTOM_WHISTLE_BE.get(), blockPos, blockState);
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        return super.getSoundType(state);
    }
}
