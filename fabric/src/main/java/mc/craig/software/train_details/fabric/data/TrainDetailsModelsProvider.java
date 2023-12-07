package mc.craig.software.train_details.fabric.data;

import mc.craig.software.train_details.ExampleBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;

public class TrainDetailsModelsProvider extends FabricModelProvider {

    public TrainDetailsModelsProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createNonTemplateHorizontalBlock(ExampleBlocks.THOMAS_WHISTLE.get());

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
