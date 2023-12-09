package mc.craig.software.train_details.mixin;

import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import mc.craig.software.train_details.sound.CustomCarriageSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class MixinCarriageContraptionEntity {

    @Shadow
    public Level level;

    @Shadow
    public abstract AABB getBoundingBox();

    @Unique
    @Environment(EnvType.CLIENT)
    public CustomCarriageSounds create_multiloader_addon_tempate$myCoolWhistleNoises;

    @Inject(at = @At("HEAD"), method = "tick()V")
    protected void tickContraption(CallbackInfo ci) {
        Entity carriageContraptionEntity = (Entity) (Object) this;
        if(carriageContraptionEntity instanceof CarriageContraptionEntity carriageContraptionEntity1) {
            Carriage.DimensionalCarriageEntity dce = carriageContraptionEntity1.getCarriage().getDimensional(carriageContraptionEntity.level);

            if (create_multiloader_addon_tempate$myCoolWhistleNoises == null) {
                create_multiloader_addon_tempate$myCoolWhistleNoises = new CustomCarriageSounds(carriageContraptionEntity1);
            } else {
                if (dce.pointsInitialised && !carriageContraptionEntity1.getCarriage().train.derailed)
                    create_multiloader_addon_tempate$myCoolWhistleNoises.tick(dce);
            }

            /*List<CarriageContraptionEntity> trains = level.getEntities(AllEntityTypes.CARRIAGE_CONTRAPTION.get(), getBoundingBox().expandTowards(new Vec3(64, 0, 64)), new Predicate<Entity>() {
                @Override
                public boolean test(Entity entity) {
                    if (entity instanceof CarriageContraptionEntity carriageContraptionEntity2) {
                        return carriageContraptionEntity2.getContraption() instanceof CarriageContraption carriageContraption;
                    }
                    return false;
                }
            });

            if (carriageContraptionEntity1.getCarriage().train.honkTicks > 0) {
                for (CarriageContraptionEntity train : trains) {
                    if(train == carriageContraptionEntity1) continue;
                    if (!train.getCarriage().train.honk) {
                        train.getCarriage().train.honkTicks = 40;
                    }
                }
            }*/
        }
    }

}
