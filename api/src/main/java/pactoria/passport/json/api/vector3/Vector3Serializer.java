package pactoria.passport.json.api.vector3;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class Vector3Serializer extends JsonSerializer<Vector3> {
    @Override
    public void serialize(Vector3 vector3, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeArray(new double[]{vector3.x(), vector3.y(), vector3.z()}, 0, 3);
    }
}
