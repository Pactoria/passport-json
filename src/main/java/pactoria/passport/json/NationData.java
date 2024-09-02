package pactoria.passport.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableNationData.class)
@JsonDeserialize(as = ImmutableNationData.class)
public interface NationData {

    static ImmutableNationData.Builder builder() {
        return ImmutableNationData.builder();
    }

    Integer id();

    String name();

    @JsonProperty("display_name")
    String displayName();
}
