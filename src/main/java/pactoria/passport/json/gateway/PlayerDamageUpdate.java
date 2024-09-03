package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;
import pactoria.passport.json.api.perchance.Perchance;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerDamageUpdate.class)
@JsonDeserialize(as = ImmutablePlayerDamageUpdate.class)
public interface PlayerDamageUpdate extends PayloadData {

    static ImmutablePlayerDamageUpdate.Builder builder() {
        return ImmutablePlayerDamageUpdate.builder();
    }

    PlayerData player();

    Perchance<PlayerData> attacker();

    Double damage();

    Double health();

    Boolean critical();
}
