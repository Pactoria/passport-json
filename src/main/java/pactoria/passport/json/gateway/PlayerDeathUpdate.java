package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;
import pactoria.passport.json.api.perchance.Perchance;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerDeathUpdate.class)
@JsonDeserialize(as = ImmutablePlayerDeathUpdate.class)
public interface PlayerDeathUpdate extends PayloadData {

    static ImmutablePlayerDeathUpdate.Builder builder() {
        return ImmutablePlayerDeathUpdate.builder();
    }

    PlayerData player();

    Perchance<PlayerData> attacker();

    String type();

    Perchance<String> message();

    Long timestamp();
}
