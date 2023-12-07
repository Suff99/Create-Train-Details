package mc.craig.software.train_details.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import mc.craig.software.train_details.ExampleBlocks;
import mc.craig.software.train_details.TrainDetails;
import net.fabricmc.api.ModInitializer;

public class TrainDetailsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TrainDetails.init();
        TrainDetails.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), TrainDetails.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        ExampleBlocks.REGISTRATE.register();
    }
}
