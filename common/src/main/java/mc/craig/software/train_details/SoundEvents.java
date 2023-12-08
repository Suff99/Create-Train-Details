package mc.craig.software.train_details;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import static mc.craig.software.train_details.TrainDetails.MOD_ID;

public class SoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND = DeferredRegister.create(MOD_ID, Registry.SOUND_EVENT_REGISTRY);

    public static final RegistrySupplier<SoundEvent> THOMAS_WHISTLE = SOUND.register("thomas_whistle_blow", () -> new SoundEvent(new ResourceLocation(MOD_ID, "thomas_whistle_blow")));
    public static final RegistrySupplier<SoundEvent> LADY_WHISTLE = SOUND.register("lady_whistle_blow", () -> new SoundEvent(new ResourceLocation(MOD_ID, "lady_whistle_blow")));

}
