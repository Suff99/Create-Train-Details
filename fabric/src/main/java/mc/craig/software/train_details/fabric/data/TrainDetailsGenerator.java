package mc.craig.software.train_details.fabric.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.nio.file.Path;

public class TrainDetailsGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        ExistingFileHelper helper = ExistingFileHelper.withResources(Path.of("C:\\Users\\Craig\\IdeaProjects\\Create-Train-Details\\fabric\\src\\main\\resources"));
        fabricDataGenerator.addProvider(new SoundEventProvider(fabricDataGenerator, helper));
        fabricDataGenerator.addProvider(new TrainDetailsModelsProvider(fabricDataGenerator));
    }
}
