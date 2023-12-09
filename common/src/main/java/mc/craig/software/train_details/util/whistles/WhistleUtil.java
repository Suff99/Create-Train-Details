package mc.craig.software.train_details.util.whistles;

import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.trains.entity.Carriage;
import mc.craig.software.train_details.blocks.CustomWhistles;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class WhistleUtil {

    public static boolean isFirstWhistleCustom(Carriage.DimensionalCarriageEntity carriageContraptionEntity) {
        Contraption contraption = carriageContraptionEntity.entity.get().getContraption();

        for (StructureTemplate.StructureBlockInfo stateInfo : contraption.getBlocks().values()) {
            if (stateInfo == null)
                continue;
            BlockState state = stateInfo.state;
            if (state.getBlock() instanceof CustomWhistles) {
                return true;
            }
        }
        return false;
    }

}
