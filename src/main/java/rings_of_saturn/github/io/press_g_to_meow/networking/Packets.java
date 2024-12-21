package rings_of_saturn.github.io.press_g_to_meow.networking;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import rings_of_saturn.github.io.press_g_to_meow.client.PressGToMeowClient;
import rings_of_saturn.github.io.press_g_to_meow.networking.packet.MakeSoundPayload;
import rings_of_saturn.github.io.press_g_to_meow.sound.Sounds;

import java.util.Objects;

public class Packets {

    public static void registerC2SPackets(){
        PayloadTypeRegistry.playC2S().register(MakeSoundPayload.ID, MakeSoundPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(MakeSoundPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                if(payload.meowing())
                    context.server().getWorld(context.player().getWorld().getRegistryKey()).playSound((PlayerEntity) context.player(), context.player().getBlockPos(), Sounds.MEOW, SoundCategory.PLAYERS,1f, (float) context.player().getWorld().getRandom().nextBetween(0, 10) /10);
                else
                    context.server().getWorld(context.player().getWorld().getRegistryKey()).playSound((PlayerEntity) context.player(), context.player().getBlockPos(), Sounds.BARK, SoundCategory.PLAYERS,1f, (float) context.player().getWorld().getRandom().nextBetween(0, 10) /10);
            });
        });
    }
}
