package mc.craig.software.train_details;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import mc.craig.software.train_details.blockentity.CustomWhistleBlockEntity;
import mc.craig.software.train_details.blocks.CustomWhistleBlock;
import mc.craig.software.train_details.client.CustomWhistleBlockRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TrainDetailsBlocks {
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(TrainDetails.MOD_ID);

    public static final BlockEntry<Block> TWIN_FLUTE_WHISTLE = REGISTRATE.block("twin_flute_whistle", (NonNullFunction<BlockBehaviour.Properties, Block>) properties -> new CustomWhistleBlock(properties, TrainDetailsSounds.TWIN_FLUTE)).register();
    public static final BlockEntry<Block> ROYAL_WHISTLE = REGISTRATE.block("royal_whistle", (NonNullFunction<BlockBehaviour.Properties, Block>) properties -> new CustomWhistleBlock(properties, TrainDetailsSounds.ROYAL)).register();
    public static final ItemEntry<Item> TWIN_FLUTE_WHISTLE_ITEM = REGISTRATE.item("twin_flute_whistle", (NonNullFunction<Item.Properties, Item>) properties -> new BlockItem(TWIN_FLUTE_WHISTLE.get(), properties)).register();
    public static final ItemEntry<Item> ROYAL_WHISTLE_ITEM = REGISTRATE.item("royal_whistle", (NonNullFunction<Item.Properties, Item>) properties -> new BlockItem(ROYAL_WHISTLE.get(), properties)).register();
    public static final BlockEntityEntry<CustomWhistleBlockEntity> CUSTOM_WHISTLE_BE =
            REGISTRATE.blockEntity("custom_whistle_be", CustomWhistleBlockEntity::new)
                    .validBlocks(TWIN_FLUTE_WHISTLE, ROYAL_WHISTLE).renderer(() -> CustomWhistleBlockRenderer::new)
                    .register();

    static {
        REGISTRATE.creativeModeTab(() -> TrainDetailsCreativeTab.BASE_CREATIVE_TAB);
    }




    public static void init() {
        // load the class and register everything
        TrainDetails.LOGGER.info("Registering blocks for " + TrainDetails.NAME);

    }
}
