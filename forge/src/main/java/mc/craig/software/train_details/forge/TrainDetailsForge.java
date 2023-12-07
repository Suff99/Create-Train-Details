package mc.craig.software.train_details.forge;

import mc.craig.software.train_details.ExampleBlocks;
import mc.craig.software.train_details.TrainDetails;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TrainDetails.MOD_ID)
public class TrainDetailsForge {
    public TrainDetailsForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleBlocks.REGISTRATE.registerEventListeners(eventBus);
        TrainDetails.init();
    }
}
