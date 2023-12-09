package mc.craig.software.train_details;

import com.simibubi.create.infrastructure.item.CreateCreativeModeTab;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TrainDetailsCreativeTab {

    public static final CreativeModeTab BASE_CREATIVE_TAB = new CreateCreativeModeTab("train_details") {

        @Override
        public void addItems(NonNullList<ItemStack> items, boolean specialItems) {
            // super.addItems(items, specialItems);
            items.add(new ItemStack(TrainDetailsBlocks.TWIN_FLUTE_WHISTLE.get()));
            items.add(new ItemStack(TrainDetailsBlocks.ROYAL_WHISTLE.get()));
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TrainDetailsBlocks.TWIN_FLUTE_WHISTLE_ITEM.get());
        }
    };


}
