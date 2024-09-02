package pactoria.passport.json.api.vector3;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class Vector3Deserializer extends JsonDeserializer<Vector3> {

    @Override
    public Vector3 deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        double[] values = jsonParser.readValueAs(double[].class);
        return new Vector3(values[0], values[1], values[2]);
    }
}
