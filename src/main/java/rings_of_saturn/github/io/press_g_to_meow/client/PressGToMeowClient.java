package rings_of_saturn.github.io.press_g_to_meow.client;

import net.fabricmc.api.ClientModInitializer;
import rings_of_saturn.github.io.press_g_to_meow.event.KeyInputHandler;

public class PressGToMeowClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
