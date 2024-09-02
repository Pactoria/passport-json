package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerDamageUpdate.class)
@JsonDeserialize(as = ImmutablePlayerDamageUpdate.class)
public interface PlayerDamageUpdate extends PayloadData {

    static ImmutablePlayerDamageUpdate.Builder builder() {
        return ImmutablePlayerDamageUpdate.builder();
    }

    PlayerData player();

    PlayerData attacker();

    Double damage();

    Double health();

    Boolean critical();
}
