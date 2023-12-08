package mc.craig.software.train_details;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import mc.craig.software.train_details.blockentity.CustomWhistleBlockEntity;
import mc.craig.software.train_details.blocks.CustomWhistles;
import mc.craig.software.train_details.client.CustomWhistleBlockRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TrainDetailsBlocks {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(TrainDetails.MOD_ID);

    public static final BlockEntry<Block> THOMAS_WHISTLE = REGISTRATE.block("thomas_whistle", (NonNullFunction<BlockBehaviour.Properties, Block>) properties -> new CustomWhistles(properties, SoundEvents.THOMAS_WHISTLE)).register();
    public static final BlockEntry<Block> LADY_WHISTLE = REGISTRATE.block("lady_whistle", (NonNullFunction<BlockBehaviour.Properties, Block>) properties -> new CustomWhistles(properties, SoundEvents.LADY_WHISTLE)).register();


    public static final ItemEntry<Item> THOMAS_WHISTLE_ITEM = REGISTRATE.item("thomas_whistle", (NonNullFunction<Item.Properties, Item>) properties -> new BlockItem(THOMAS_WHISTLE.get(), properties)).register();
    public static final ItemEntry<Item> LADY_WHISTLE_ITEM = REGISTRATE.item("lady_whistle", (NonNullFunction<Item.Properties, Item>) properties -> new BlockItem(LADY_WHISTLE.get(), properties)).register();

    public static final BlockEntityEntry<CustomWhistleBlockEntity> THOMAS_WHISTLE_BE =
            REGISTRATE.blockEntity("thomas_whistle_be", CustomWhistleBlockEntity::new)
                    .validBlocks(THOMAS_WHISTLE, LADY_WHISTLE).renderer(() -> CustomWhistleBlockRenderer::new)
                    .register();




    public static void init() {
        // load the class and register everything
        TrainDetails.LOGGER.info("Registering blocks for " + TrainDetails.NAME);

    }
}
