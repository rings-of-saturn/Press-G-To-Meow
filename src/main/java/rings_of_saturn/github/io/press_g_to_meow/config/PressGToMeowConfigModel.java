package rings_of_saturn.github.io.press_g_to_meow.config;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Sync;

@Modmenu(modId = "press_g_to_meow")
@Config(name = "pgtm_config", wrapperName = "PressGToMeowConfig")
@Sync(Option.SyncMode.NONE)
public class PressGToMeowConfigModel {
    public int pitchMax = 10;
    public int pitchMin = 0;
}

