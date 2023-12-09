package mc.craig.software.train_details.fabric.data;

import mc.craig.software.train_details.TrainDetailsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;

import static net.minecraft.data.models.BlockModelGenerators.createHorizontalFacingDispatch;

public class TrainDetailsModelsProvider extends FabricModelProvider {

    public TrainDetailsModelsProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createNonTemplateHorizontalBlock(TrainDetailsBlocks.TWIN_FLUTE_WHISTLE.get());
        blockStateModelGenerator.createNonTemplateHorizontalBlock(TrainDetailsBlocks.ROYAL_WHISTLE.get());


    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
