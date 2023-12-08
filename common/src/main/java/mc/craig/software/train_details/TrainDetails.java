package mc.craig.software.train_details;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainDetails {
    public static final String MOD_ID = "train_details";
    public static final String NAME = "Create: Train Details";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        TrainDetailsBlocks.init();
        TrainDetailsSounds.init();
        SoundEvents.SOUND.register();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
