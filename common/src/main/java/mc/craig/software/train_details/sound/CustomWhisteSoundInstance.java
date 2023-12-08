package mc.craig.software.train_details.sound;

import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock.WhistleSize;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
@Environment(EnvType.CLIENT)
public class CustomWhisteSoundInstance extends AbstractTickableSoundInstance {

    private boolean active;
    private int keepAlive;
    private WhistleSize size;

    public CustomWhisteSoundInstance(WhistleSize size, BlockPos worldPosition) {
        super((SoundEvents.ZOMBIE_DEATH), SoundSource.RECORDS, SoundInstance.createUnseededRandom());
        this.size = size;
        looping = true;
        active = true;
        volume = 0.05f;
        delay = 0;
        keepAlive();
        Vec3 v = Vec3.atCenterOf(worldPosition);
        x = v.x;
        y = v.y;
        z = v.z;
    }

    public WhistleSize getOctave() {
        return size;
    }

    public void fadeOut() {
        this.active = false;
    }

    public void keepAlive() {
        keepAlive = 2;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public void tick() {
        if (active) {
            volume = Math.min(1, volume + .25f);
            keepAlive--;
            if (keepAlive == 0)
                fadeOut();
            return;

        }
        volume = Math.max(0, volume - .25f);
        if (volume == 0)
            stop();
    }

}
