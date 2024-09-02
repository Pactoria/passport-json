package pactoria.passport.json.api.vector3;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

public class Vector3Module extends Module {

    @Override
    public String getModuleName() {
        return "Vector3Module";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, null, null, null);
    }

    @Override
    public void setupModule(SetupContext setupContext) {
        SimpleSerializers serializers = new SimpleSerializers();
        serializers.addSerializer(Vector3.class, new Vector3Serializer());
        setupContext.addSerializers(serializers);

        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Vector3.class, new Vector3Deserializer());
        setupContext.addDeserializers(deserializers);
    }
}
