package pactoria.passport.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import pactoria.passport.json.api.perchance.Perchance;
import pactoria.passport.json.api.vector3.Vector3;

@Value.Immutable
@JsonSerialize(as = ImmutableTownData.class)
@JsonDeserialize(as = ImmutableTownData.class)
public interface TownData {

    static ImmutableTownData.Builder builder() {
        return ImmutableTownData.builder();
    }

    Integer id();

    String name();

    @JsonProperty("display_name")
    String displayName();

    @JsonProperty("town_center_location")
    Vector3 townCenterLocation();

    Perchance<NationData> nation();
}