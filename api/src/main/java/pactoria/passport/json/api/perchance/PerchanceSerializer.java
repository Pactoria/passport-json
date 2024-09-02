package pactoria.passport.json.api.perchance;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.jetbrains.annotations.Nullable;

public class PerchanceSerializer extends ReferenceTypeSerializer<Perchance<?>> {
    public PerchanceSerializer(ReferenceType fullType, boolean staticTyping, TypeSerializer typeSerializer, JsonSerializer<Object> ser) {
        super(fullType, staticTyping, typeSerializer, ser);
    }

    public PerchanceSerializer(ReferenceTypeSerializer<?> base, BeanProperty bean, TypeSerializer typeSerializer, JsonSerializer<?> serializer, NameTransformer transformer, Object suppressableValue, boolean suppressNulls) {
        super(base, bean, typeSerializer, serializer, transformer, suppressableValue, suppressNulls);
    }

    @Override
    protected PerchanceSerializer withResolved(BeanProperty prop, TypeSerializer typeSerializer, JsonSerializer<?> serializer, NameTransformer transformer) {
        return new PerchanceSerializer(this, prop, typeSerializer, serializer, transformer, _suppressableValue, _suppressNulls);
    }

    @Override
    public PerchanceSerializer withContentInclusion(Object suppressableValue, boolean suppressNulls) {
        return new PerchanceSerializer(this, _property, _valueTypeSerializer, _valueSerializer, _unwrapper, suppressableValue, suppressNulls);
    }

    @Override
    protected boolean _isValuePresent(Perchance<?> value) {
        return !value.isAbsent();
    }

    @Override
    protected Object _getReferenced(Perchance<?> value) {
        return value.get();
    }

    @Nullable
    @Override
    protected Object _getReferencedIfPresent(Perchance<?> value) {
        return value.isAbsent() ? null : value.get();
    }
}
