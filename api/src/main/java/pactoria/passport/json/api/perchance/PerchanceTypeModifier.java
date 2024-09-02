package pactoria.passport.json.api.perchance;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeModifier;

import java.lang.reflect.Type;

public class PerchanceTypeModifier extends TypeModifier {
    @Override
    public JavaType modifyType(JavaType javaType, Type type, TypeBindings typeBindings, TypeFactory typeFactory) {
        if (javaType.isReferenceType() || javaType.isContainerType()) {
            return javaType;
        }
        if (javaType.isTypeOrSubTypeOf(Perchance.class)) {
            return ReferenceType.upgradeFrom(javaType, javaType.containedTypeOrUnknown(0));
        }
        return javaType;
    }
}
