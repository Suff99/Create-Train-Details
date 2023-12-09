package mc.craig.software.train_details.mixin;

import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageSounds;
import mc.craig.software.train_details.util.whistles.WhistleUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CarriageSounds.class)
public class MixinCarriageSounds {

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/trains/entity/CarriageSounds;submitSharedSoundVolume(Lnet/minecraft/world/phys/Vec3;F)V", shift = At.Shift.AFTER), cancellable = true)
    private void onTick(Carriage.DimensionalCarriageEntity dce, CallbackInfo ci) {
        if(WhistleUtil.isFirstWhistleCustom(dce)) ci.cancel();
    }

}
