package rings_of_saturn.github.io.press_g_to_meow.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
	public static final String KEY_CATEGORY_MEOWING = "key.category.press_g_to_meow.press_g_to_meow";


	public static final String MEOW = "key.press_g_to_meow.meow";

	public static KeyBinding meowKey;

	public static final String BARK = "key.press_g_to_meow.bark";

	public static KeyBinding barkKey;

	public static void registerKeyInputs(){
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if(client.player != null && client.player.getWorld() != null) {
				if (meowKey.wasPressed()) {
					client.player.getWorld().playSound(client.player, client.player.getBlockPos(), SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.PLAYERS,1f, (float) client.player.getWorld().getRandom().nextBetween(0, 10) /10);
                }
				if (barkKey.wasPressed()) {
					client.player.getWorld().playSound(client.player, client.player.getBlockPos(), SoundEvents.ENTITY_WOLF_AMBIENT, SoundCategory.PLAYERS,1f, (float) client.player.getWorld().getRandom().nextBetween(0, 10) /10);
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
