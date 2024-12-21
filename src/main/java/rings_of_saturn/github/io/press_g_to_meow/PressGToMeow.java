package rings_of_saturn.github.io.press_g_to_meow;

import net.fabricmc.api.ModInitializer;
import rings_of_saturn.github.io.press_g_to_meow.config.PressGToMeowConfig;
import rings_of_saturn.github.io.press_g_to_meow.sound.Sounds;

import static rings_of_saturn.github.io.press_g_to_meow.networking.Packets.registerC2SPackets;

public class PressGToMeow implements ModInitializer {
    public static final PressGToMeowConfig CONFIG = PressGToMeowConfig.createAndLoad();


    @Override
    public void onInitialize() {
        registerC2SPackets();
        Sounds.registerSounds();
    }
}
