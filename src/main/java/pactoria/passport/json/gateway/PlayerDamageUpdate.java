package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerDamageUpdate.class)
@JsonDeserialize(as = ImmutablePlayerDamageUpdate.class)
public interface PlayerDamageUpdate extends PayloadData {

    static ImmutablePlayerDamageUpdate.Builder builder() {
        return ImmutablePlayerDamageUpdate.builder();
    }

    String player();

    String attacker();

    Double damage();

    Double health();

    Boolean critical();
}
