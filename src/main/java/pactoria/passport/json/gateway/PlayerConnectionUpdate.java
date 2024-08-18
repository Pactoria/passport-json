package pactoria.passport.json.gateway;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerConnectionUpdate.class)
@JsonDeserialize(as = ImmutablePlayerConnectionUpdate.class)
public interface PlayerConnectionUpdate extends PayloadData {

    static ImmutablePlayerConnectionUpdate.Builder builder() {
        return ImmutablePlayerConnectionUpdate.builder();
    }

    String player();

    String ip();

    Long timestamp();
}
