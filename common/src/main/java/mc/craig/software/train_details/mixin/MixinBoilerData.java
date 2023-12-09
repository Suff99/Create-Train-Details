package mc.craig.software.train_details.mixin;

import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock;
import com.simibubi.create.content.fluids.tank.BoilerData;
import com.simibubi.create.content.fluids.tank.FluidTankBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.utility.Iterate;
import mc.craig.software.train_details.blocks.CustomWhistles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoilerData.class)
public class MixinBoilerData {

    @Shadow
    public int attachedEngines;

    @Inject(method = "evaluate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"))
    private void onEvaluate(FluidTankBlockEntity controller, CallbackInfoReturnable<Boolean> cir) {
        BlockPos controllerPos = controller.getBlockPos();
        Level level = controller.getLevel();

        for (int yOffset = 0; yOffset < controller.getHeight(); yOffset++) {
            for (int xOffset = 0; xOffset < controller.getWidth(); xOffset++) {
                for (int zOffset = 0; zOffset < controller.getWidth(); zOffset++) {

                    BlockPos pos = controllerPos.offset(xOffset, yOffset, zOffset);
                    BlockState blockState = level.getBlockState(pos);
                    if (!FluidTankBlock.isTank(blockState))
                        continue;
                    for (Direction d : Iterate.directions) {
                        BlockPos attachedPos = pos.relative(d);
                        BlockState attachedState = level.getBlockState(attachedPos);
                        if (attachedState.getBlock() instanceof CustomWhistles
                                && WhistleBlock.getAttachedDirection(attachedState)
                                .getOpposite() == d)
                            attachedEngines++;
                    }
                }
            }
        }

    }

}
