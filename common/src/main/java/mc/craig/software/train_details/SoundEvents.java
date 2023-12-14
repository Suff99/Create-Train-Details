package mc.craig.software.train_details;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import static mc.craig.software.train_details.TrainDetails.MOD_ID;

public class SoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND = DeferredRegister.create(MOD_ID, Registry.SOUND_EVENT_REGISTRY);

    public static final RegistrySupplier<SoundEvent> TWIN_FLUTE_WHISTLE = SOUND.register("train/twin_flute_whistle_blow", () -> new SoundEvent(new ResourceLocation(MOD_ID, "twin_flute_whistle_blow")));
    public static final RegistrySupplier<SoundEvent> TWIN_FLUTE_WHISTLE_LOOP = SOUND.register("train/twin_flute_whistle_loop", () -> new SoundEvent(new ResourceLocation(MOD_ID, "twin_flute_whistle_loop")));
    public static final RegistrySupplier<SoundEvent> TWIN_FLUTE_WHISTLE_END = SOUND.register("train/twin_flute_whistle_end", () -> new SoundEvent(new ResourceLocation(MOD_ID, "twin_flute_whistle_end")));

    public static final RegistrySupplier<SoundEvent> ROYAL_WHISTLE = SOUND.register("train/royal_whistle_blow", () -> new SoundEvent(new ResourceLocation(MOD_ID, "royal_whistle_blow")));
    public static final RegistrySupplier<SoundEvent> ROYAL_WHISTLE_LOOP = SOUND.register("train/royal_whistle_loop", () -> new SoundEvent(new ResourceLocation(MOD_ID, "royal_whistle_loop")));
    public static final RegistrySupplier<SoundEvent> ROYAL_WHISTLE_END = SOUND.register("train/royal_whistle_end", () -> new SoundEvent(new ResourceLocation(MOD_ID, "royal_whistle_end")));

}
