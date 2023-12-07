package mc.craig.software.train_details.fabric.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jetbrains.annotations.Nullable;

public class TrainDetailsGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new TrainDetailsModelsProvider(fabricDataGenerator));
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return DataGeneratorEntrypoint.super.getEffectiveModId();
    }
}
