package mc.craig.software.train_details.blocks;

import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock;
import mc.craig.software.train_details.ExampleBlocks;
import mc.craig.software.train_details.blockentity.ThomasWhistleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ThomasWhistle extends WhistleBlock {

    public ThomasWhistle(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(POWERED, false)
                .setValue(WALL, false)
                .setValue(SIZE, WhistleSize.SMALL));
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ThomasWhistleBlockEntity(ExampleBlocks.THOMAS_WHISTLE_BE.get(), blockPos, blockState);
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        return super.getSoundType(state);
    }
}
