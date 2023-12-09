package mc.craig.software.train_details;

import com.simibubi.create.AllSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class TrainDetailsSounds {

    public static final AllSoundEvents.SoundEntry TWIN_FLUTE_WHISTLE_LOOP = create(TrainDetails.id("twin_flute_whistle_loop")).subtitle("Thomas Whistle")
            .playExisting(mc.craig.software.train_details.SoundEvents.TWIN_FLUTE_WHISTLE, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static final AllSoundEvents.SoundEntry TWIN_FLUTE_WHISTLE_END = create(TrainDetails.id("twin_flute_whistle_end")).subtitle("Thomas Whistle")
            .playExisting(mc.craig.software.train_details.SoundEvents.TWIN_FLUTE_WHISTLE_END, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static final AllSoundEvents.SoundEntry TWIN_FLUTE_WHISTLE_MAN = create(TrainDetails.id("twin_flute_whistle")).subtitle("Thomas Whistle")
            .playExisting(SoundEvents.GENERIC_EXPLODE, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static final AllSoundEvents.SoundEntry ROYAL_WHISTLE = create(TrainDetails.id("royal_whistle")).subtitle("Lady Whistle")
            .playExisting(SoundEvents.GENERIC_EXPLODE, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static void init(){
       /* TWIN_FLUTE_WHISTLE.prepare();
        TWIN_FLUTE_WHISTLE.register();*/
    }



    public static AllSoundEvents.SoundEntryBuilder create(ResourceLocation id) {
        return new AllSoundEvents.SoundEntryBuilder(id);
    }
}
