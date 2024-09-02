package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;
import pactoria.passport.json.TownData;
import pactoria.passport.json.api.perchance.Perchance;

@Value.Immutable
@JsonSerialize(as = ImmutableSiegeCreate.class)
@JsonDeserialize(as = ImmutableSiegeCreate.class)
public interface SiegeCreate extends PayloadData {

    static ImmutableSiegeCreate.Builder builder() {
        return ImmutableSiegeCreate.builder();
    }

    Perchance<PlayerData> attacker();

    TownData defender();

    Long timestamp();
}
