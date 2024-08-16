package passport.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutablePlayerData.class)
@JsonDeserialize(as = ImmutablePlayerData.class)
public interface PlayerData {

    static ImmutablePlayerData.Builder builder() {
        return ImmutablePlayerData.builder();
    }

    UUID id();
}
