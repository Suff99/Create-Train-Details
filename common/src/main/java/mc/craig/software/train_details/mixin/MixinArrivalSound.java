package mc.craig.software.train_details.mixin;

import com.simibubi.create.content.trains.entity.ArrivalSoundQueue;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import mc.craig.software.train_details.TrainDetailsBlocks;
import mc.craig.software.train_details.blocks.ThomasWhistle;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrivalSoundQueue.class)
public class MixinArrivalSound {

    @Inject(at = @At("HEAD"), method = "play(Lcom/simibubi/create/content/trains/entity/CarriageContraptionEntity;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplate$StructureBlockInfo;)V", cancellable = true)
    private static void play(CarriageContraptionEntity entity, StructureTemplate.StructureBlockInfo info, CallbackInfo ci) {

        if (info == null)
            return;
        BlockState state = info.state;

        if (state.getBlock() instanceof ThomasWhistle thomasWhistle) {
            if (TrainDetailsBlocks.THOMAS_WHISTLE.has(state) || TrainDetailsBlocks.LADY_WHISTLE.has(state))
                playSimple(entity, thomasWhistle.getSoundEvent().get(), 1, 1);
            ci.cancel(); //uh yeah this kinda cancels all the other sounds....yeesh
        }
    }

    @Inject(at = @At("HEAD"), method = "isPlayable(Lnet/minecraft/world/level/block/state/BlockState;)Z", cancellable = true)
    private static void isPlayable(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if(state.getBlock() instanceof ThomasWhistle thomasWhistle){
            cir.setReturnValue(true);
        }
    }

    private static void playSimple(CarriageContraptionEntity entity, SoundEvent event, float volume, float pitch) {
        entity.level.playSound(null, entity, event, SoundSource.NEUTRAL, 5 * volume, pitch);
    }

}
