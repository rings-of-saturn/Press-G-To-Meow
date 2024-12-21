package rings_of_saturn.github.io.press_g_to_meow.networking.packet;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import static rings_of_saturn.github.io.press_g_to_meow.client.PressGToMeowClient.MOD_ID;

public record MakeSoundPayload(boolean meowing) implements CustomPayload {
    public static final Id<MakeSoundPayload> ID = new Id<>(Identifier.of(MOD_ID, "make_sound"));
    public static final PacketCodec<RegistryByteBuf, MakeSoundPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.BOOLEAN, MakeSoundPayload::meowing,
            MakeSoundPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

}
