package pactoria.passport.json.gateway;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerDeathUpdate.class)
@JsonDeserialize(as = ImmutablePlayerDeathUpdate.class)
public interface PlayerDeathUpdate extends PayloadData {

    static ImmutablePlayerDeathUpdate.Builder builder() {
        return ImmutablePlayerDeathUpdate.builder();
    }

    @JsonUnwrapped
    PlayerData player();

    String attacker();

    String type();

    String message();

    Long timestamp();
}
