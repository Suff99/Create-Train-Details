package mc.craig.software.train_details.blocks;

import com.simibubi.create.AllSoundEvents;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public interface IWhistleSound {

    Supplier<SoundEvent> getArrivalSound();
    Supplier<SoundEvent> getLoopingSound();
    AllSoundEvents.SoundEntry getEndSound();

}
