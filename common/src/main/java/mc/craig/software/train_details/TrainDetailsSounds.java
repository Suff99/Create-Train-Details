package mc.craig.software.train_details;

import com.simibubi.create.AllSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class TrainDetailsSounds {

    public static final AllSoundEvents.SoundEntry THOMAS_WHISTLE = create(TrainDetails.id("thomas_whistle")).subtitle("Thomas Whistle")
            .playExisting(SoundEvents.GENERIC_EXPLODE, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static void init(){
       /* THOMAS_WHISTLE.prepare();
        THOMAS_WHISTLE.register();*/
    }



    public static AllSoundEvents.SoundEntryBuilder create(ResourceLocation id) {
        return new AllSoundEvents.SoundEntryBuilder(id);
    }
}
