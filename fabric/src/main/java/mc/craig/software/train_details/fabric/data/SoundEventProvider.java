package mc.craig.software.train_details.fabric.data;

import io.github.fabricators_of_create.porting_lib.data.SoundDefinition;
import io.github.fabricators_of_create.porting_lib.data.SoundDefinitionsProvider;
import mc.craig.software.train_details.SoundEvents;
import mc.craig.software.train_details.TrainDetails;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SoundEventProvider extends SoundDefinitionsProvider {

    /**
     * Creates a new instance of this data provider.
     *
     * @param generator The data generator instance provided by the event you are initializing this provider in.
     * @param helper    The existing file helper provided by the event you are initializing this provider in.
     */
    public SoundEventProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, TrainDetails.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        add(SoundEvents.THOMAS_WHISTLE.get(), SoundDefinition.definition().with(SoundDefinition.Sound.sound(new ResourceLocation(TrainDetails.MOD_ID, "thomas_whistle_blow"), SoundDefinition.SoundType.SOUND)));
        add(SoundEvents.LADY_WHISTLE.get(), SoundDefinition.definition().with(SoundDefinition.Sound.sound(new ResourceLocation(TrainDetails.MOD_ID, "lady_whistle_blow"), SoundDefinition.SoundType.SOUND)));
    }
}
