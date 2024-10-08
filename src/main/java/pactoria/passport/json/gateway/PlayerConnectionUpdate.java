package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerConnectionUpdate.class)
@JsonDeserialize(as = ImmutablePlayerConnectionUpdate.class)
public interface PlayerConnectionUpdate extends PayloadData {

    static ImmutablePlayerConnectionUpdate.Builder builder() {
        return ImmutablePlayerConnectionUpdate.builder();
    }

    PlayerData player();

    String ip();

    Long timestamp();
}
