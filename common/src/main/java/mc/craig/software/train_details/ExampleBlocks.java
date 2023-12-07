package mc.craig.software.train_details;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import mc.craig.software.train_details.blockentity.ThomasWhistleBlockEntity;
import mc.craig.software.train_details.blocks.ThomasWhistle;
import mc.craig.software.train_details.client.ThomasWhistleBlockEntityRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ExampleBlocks {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(TrainDetails.MOD_ID);

    public static final BlockEntry<Block> THOMAS_WHISTLE = REGISTRATE.block("thomas_whistle", (NonNullFunction<BlockBehaviour.Properties, Block>) ThomasWhistle::new).register();

    public static final ItemEntry<Item> THOMAS_WHISTLE_ITEM = REGISTRATE.item("thomas_whistle", (NonNullFunction<Item.Properties, Item>) properties -> new BlockItem(THOMAS_WHISTLE.get(), properties)).register();

    public static final BlockEntityEntry<ThomasWhistleBlockEntity> THOMAS_WHISTLE_BE =
            REGISTRATE.blockEntity("thomas_whistle_be", ThomasWhistleBlockEntity::new)
                    .validBlocks(THOMAS_WHISTLE).renderer(() -> ThomasWhistleBlockEntityRenderer::new)
                    .register();




    public static void init() {
        // load the class and register everything
        TrainDetails.LOGGER.info("Registering blocks for " + TrainDetails.NAME);

    }
}
