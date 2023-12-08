package mc.craig.software.train_details.sound;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;
import com.simibubi.create.content.trains.entity.CarriageSounds;
import com.simibubi.create.content.trains.entity.Train;
import mc.craig.software.train_details.SoundEvents;
import mc.craig.software.train_details.TrainDetailsSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class CustomCarriageSounds {

    CustomLoopingSound sharedHonkSound;
    CarriageContraptionEntity entity;

    public CustomCarriageSounds(CarriageContraptionEntity entity) {
        this.entity = entity;
    }

    public void tick(Carriage.DimensionalCarriageEntity dce) {
        Train train = entity.getCarriage().train;

        if (train.honkTicks == 0) {
            if (sharedHonkSound != null) {
                sharedHonkSound.stopSound();
                sharedHonkSound = null;
            }
            return;
        }

        train.honkTicks--;
        train.determineHonk(entity.level);

        if (train.lowHonk == null)
            return;

        boolean low = train.lowHonk;
        float honkPitch = (float) Math.pow(2, train.honkPitch / 12.0);

        AllSoundEvents.SoundEntry endSound = TrainDetailsSounds.THOMAS_WHISTLE;
        AllSoundEvents.SoundEntry continuousSound = TrainDetailsSounds.THOMAS_WHISTLE;

        Minecraft mc = Minecraft.getInstance();

        Entity camEntity = mc.cameraEntity;
        if (camEntity == null)
            return;

        Vec3 cam = camEntity.getEyePosition();

        Vec3 leadingAnchor = dce.leadingAnchor();
        Vec3 trailingAnchor = dce.trailingAnchor();
        if (leadingAnchor == null || trailingAnchor == null)
            return;

        Vec3 toBogey1 = leadingAnchor.subtract(cam);
        Vec3 toBogey2 = trailingAnchor.subtract(cam);
        double distance1 = toBogey1.length();
        double distance2 = toBogey2.length();

        Vec3 toCarriage = distance1 > distance2 ? toBogey2 : toBogey1;
        Vec3 soundLocation = cam.add(toCarriage);

        if (train.honkTicks == 5)
            endSound.playAt(mc.level, soundLocation, 1, honkPitch, false);
        if (train.honkTicks == 19)
            endSound.playAt(mc.level, soundLocation, .5f, honkPitch, false);

        sharedHonkSound = playIfMissing(mc, sharedHonkSound, SoundEvents.THOMAS_WHISTLE.get());
        sharedHonkSound.setLocation(soundLocation);
        float fadeout = Mth.clamp((3 - train.honkTicks) / 3f, 0, 1);
        float fadein = Mth.clamp((train.honkTicks - 17) / 3f, 0, 1);
        sharedHonkSound.setVolume(1 - fadeout - fadein);
        sharedHonkSound.setPitch(honkPitch);

    }


    private CustomLoopingSound playIfMissing(Minecraft mc, CustomLoopingSound loopingSound, SoundEvent sound) {
        if (loopingSound == null) {
            loopingSound = new CustomLoopingSound(sound, SoundSource.NEUTRAL);
            mc.getSoundManager()
                    .play(loopingSound);
        }
        return loopingSound;
    }
}
