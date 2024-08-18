package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerDeathUpdate.class)
@JsonDeserialize(as = ImmutablePlayerDeathUpdate.class)
public interface PlayerDeathUpdate extends PayloadData {

    static ImmutablePlayerDeathUpdate.Builder builder() {
        return ImmutablePlayerDeathUpdate.builder();
    }

    String player();

    String attacker();

    String type();

    String message();

    Long timestamp();
}
