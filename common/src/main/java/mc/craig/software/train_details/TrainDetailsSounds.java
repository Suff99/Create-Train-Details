package mc.craig.software.train_details;

import com.simibubi.create.AllSoundEvents;
import mc.craig.software.train_details.blocks.IWhistleSound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

import java.util.function.Supplier;

public class TrainDetailsSounds {

    public static final AllSoundEvents.SoundEntry TWIN_FLUTE_WHISTLE_LOOP = create(TrainDetails.id("twin_flute_whistle_loop")).subtitle("Thomas Whistle")
            .playExisting(mc.craig.software.train_details.SoundEvents.TWIN_FLUTE_WHISTLE, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static final AllSoundEvents.SoundEntry TWIN_FLUTE_WHISTLE_END = create(TrainDetails.id("twin_flute_whistle_end")).subtitle("Thomas Whistle")
            .playExisting(mc.craig.software.train_details.SoundEvents.TWIN_FLUTE_WHISTLE_END, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static final AllSoundEvents.SoundEntry ROYAL_WHISTLE_LOOP = create(TrainDetails.id("royal_whistle_loop")).subtitle("Lady Whistle")
            .playExisting(SoundEvents.ROYAL_WHISTLE_LOOP, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static final AllSoundEvents.SoundEntry ROYAL_WHISTLE_END = create(TrainDetails.id("royal_whistle_end")).subtitle("Lady Whistle")
            .playExisting(SoundEvents.ROYAL_WHISTLE_END, .1f, 1.1f)
            .category(SoundSource.BLOCKS)
            .build();

    public static void init(){
       /* TWIN_FLUTE_WHISTLE.prepare();
        TWIN_FLUTE_WHISTLE.register();*/
    }

    public static IWhistleSound TWIN_FLUTE = new IWhistleSound() {
        @Override
        public Supplier<SoundEvent> getArrivalSound() {
            return SoundEvents.TWIN_FLUTE_WHISTLE;
        }

        @Override
        public Supplier<SoundEvent> getLoopingSound() {
            return SoundEvents.TWIN_FLUTE_WHISTLE_LOOP;
        }

        @Override
        public AllSoundEvents.SoundEntry getEndSound() {
            return TrainDetailsSounds.TWIN_FLUTE_WHISTLE_END;
        }
    };


    public static IWhistleSound ROYAL = new IWhistleSound() {
        @Override
        public Supplier<SoundEvent> getArrivalSound() {
            return SoundEvents.ROYAL_WHISTLE;
        }

        @Override
        public Supplier<SoundEvent> getLoopingSound() {
            return SoundEvents.ROYAL_WHISTLE_LOOP;
        }

        @Override
        public AllSoundEvents.SoundEntry getEndSound() {
            return TrainDetailsSounds.ROYAL_WHISTLE_END;
        }
    };



    public static AllSoundEvents.SoundEntryBuilder create(ResourceLocation id) {
        return new AllSoundEvents.SoundEntryBuilder(id);
    }
}
