package rings_of_saturn.github.io.press_g_to_meow.client;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rings_of_saturn.github.io.press_g_to_meow.event.KeyInputHandler;
import rings_of_saturn.github.io.press_g_to_meow.sound.Sounds;

import static rings_of_saturn.github.io.press_g_to_meow.networking.Packets.registerC2SPackets;

public class PressGToMeowClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("Press G To Meow");
    public static final String MOD_ID = "press_g_to_meow";


    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        Sounds.registerSounds();
    }
}
