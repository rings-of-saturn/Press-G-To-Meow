package rings_of_saturn.github.io.press_g_to_meow.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import rings_of_saturn.github.io.press_g_to_meow.config.PressGToMeowConfig;
import rings_of_saturn.github.io.press_g_to_meow.config.PressGToMeowConfigModel;
import rings_of_saturn.github.io.press_g_to_meow.networking.packet.MakeSoundPayload;
import rings_of_saturn.github.io.press_g_to_meow.sound.Sounds;

import static rings_of_saturn.github.io.press_g_to_meow.PressGToMeow.CONFIG;

public class KeyInputHandler {
	public static final String KEY_CATEGORY_MEOWING = "key.category.press_g_to_meow.press_g_to_meow";


	public static final String MEOW = "key.press_g_to_meow.meow";

	public static KeyBinding meowKey;

	public static final String BARK = "key.press_g_to_meow.bark";

	public static KeyBinding barkKey;


	public static void registerKeyInputs(){
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if(client.player != null) {
				if (barkKey.wasPressed()) {
					ClientPlayNetworking.send(new MakeSoundPayload(false));
					client.player.playSound(Sounds.BARK,1f, (float) client.player.getWorld().getRandom().nextBetween(CONFIG.pitchMin(), CONFIG.pitchMax()) /10);
				}
				if (meowKey.wasPressed()) {
					ClientPlayNetworking.send(new MakeSoundPayload(true));
					client.player.playSound(Sounds.MEOW,1f, (float) client.player.getWorld().getRandom().nextBetween(CONFIG.pitchMin(), CONFIG.pitchMax()) /10);
				}
			}
		});
	}

	public static void register(){
		meowKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			MEOW,
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_G,
			KEY_CATEGORY_MEOWING
		));

		barkKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			BARK,
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_H,
			KEY_CATEGORY_MEOWING
		));

		registerKeyInputs();
	}
}
