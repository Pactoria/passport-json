package pactoria.passport.json.api.perchance;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PerchanceDeserializer extends ReferenceTypeDeserializer<Perchance<?>> {

    private final boolean readNullAsAbsent;

    public PerchanceDeserializer(JavaType fullType, @Nullable ValueInstantiator vi, TypeDeserializer typeDeser, JsonDeserializer<?> deser, boolean readNullAsAbsent) {
        super(fullType, vi, typeDeser, deser);
        this.readNullAsAbsent = readNullAsAbsent;
    }

    @Override
    protected PerchanceDeserializer withResolved(TypeDeserializer typeDeser, JsonDeserializer<?> valueDeser) {
        return new PerchanceDeserializer(_fullType, _valueInstantiator, typeDeser, valueDeser, readNullAsAbsent);
    }

    @Override
    public Perchance<?> getNullValue(DeserializationContext ctxt) {
        if (readNullAsAbsent) {
            return Perchance.absent();
        }
        return Perchance.of(Optional.empty());
    }

    @Override
    public Perchance<?> referenceValue(Object contents) {
        return Perchance.of(contents);
    }

    @Override
    public Perchance<?> updateReference(Perchance<?> reference, Object contents) {
        return Perchance.of(contents);
    }

    @Nullable
    @Override
    public Object getReferenced(Perchance<?> reference) {
        return reference.toOptional().orElse(null);
    }
}
