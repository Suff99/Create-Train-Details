package mc.craig.software.train_details;

import com.simibubi.create.Create;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainDetails {
    public static final String MOD_ID = "train_details";
    public static final String NAME = "Create: Train Details";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ExampleExpectPlatform.platformName());
        ExampleBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        TrainDetailsSounds.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
