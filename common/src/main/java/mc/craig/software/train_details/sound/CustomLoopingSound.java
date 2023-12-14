package mc.craig.software.train_details.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;

public class CustomLoopingSound extends AbstractTickableSoundInstance {

    protected CustomLoopingSound(SoundEvent soundEvent, SoundSource soundSource) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        attenuation = Attenuation.LINEAR;
        looping = true;
        delay = 0;
        volume = 0.0001f;
    }

    @Override
    public void tick() {}

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    public void setLocation(Vec3 location) {
        x = location.x;
        y = location.y;
        z = location.z;
    }

    public void stopSound() {
        Minecraft.getInstance()
                .getSoundManager()
                .stop(this);
    }

}
