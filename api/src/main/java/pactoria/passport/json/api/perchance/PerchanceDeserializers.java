package pactoria.passport.json.api.perchance;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import org.jetbrains.annotations.Nullable;

public class PerchanceDeserializers extends Deserializers.Base {

    private final boolean readNullAsAbsent;

    public PerchanceDeserializers() {
        this(false);
    }

    public PerchanceDeserializers(boolean readNullAsAbsent) {
        this.readNullAsAbsent = readNullAsAbsent;
    }

    @Nullable
    @Override
    public JsonDeserializer<?> findReferenceDeserializer(ReferenceType refType, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer contentTypeDeserializer, JsonDeserializer<?> contentDeserializer) throws JsonMappingException {
        if (refType.isTypeOrSubTypeOf(Perchance.class)) {
            return new PerchanceDeserializer(refType, null, contentTypeDeserializer, contentDeserializer,
                    readNullAsAbsent);
        }
        return null;
    }
}