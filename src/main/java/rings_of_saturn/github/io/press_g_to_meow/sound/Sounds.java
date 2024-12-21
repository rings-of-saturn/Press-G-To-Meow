package rings_of_saturn.github.io.press_g_to_meow.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static rings_of_saturn.github.io.press_g_to_meow.client.PressGToMeowClient.MOD_ID;

public class Sounds {
    public static SoundEvent MEOW = registerSoundEvent("meow", 20);
    public static SoundEvent BARK = registerSoundEvent("bark", 20);



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    private static SoundEvent registerSoundEvent(String name, int range) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id, range));
    }

    public static void registerSounds() {
    }
}
