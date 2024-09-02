package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.PlayerData;
import pactoria.passport.json.TownData;
import pactoria.passport.json.api.perchance.Perchance;

@Value.Immutable
@JsonSerialize(as = ImmutableSiegeRemove.class)
@JsonDeserialize(as = ImmutableSiegeRemove.class)
public interface SiegeRemove extends PayloadData {

    static ImmutableSiegeRemove.Builder builder() {
        return ImmutableSiegeRemove.builder();
    }

    Perchance<PlayerData> attacker();

    TownData defender();

    Boolean success();

    Long timestamp();
}
