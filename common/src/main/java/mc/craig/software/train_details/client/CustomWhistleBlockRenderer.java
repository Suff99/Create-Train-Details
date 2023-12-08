package mc.craig.software.train_details.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.decoration.steamWhistle.WhistleBlockEntity;
import com.simibubi.create.content.decoration.steamWhistle.WhistleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;

public class CustomWhistleBlockRenderer extends WhistleRenderer {

    public CustomWhistleBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRender(WhistleBlockEntity blockEntity, Vec3 cameraPos) {
        return false;
    }

    @Override
    protected void renderSafe(WhistleBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        /*super.renderSafe(be, partialTicks, ms, buffer, light, overlay);*/

    }
}
