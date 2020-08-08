package org.serieznyi.serialization.serializer.classesForSerialization.supportedPrimitive;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize()
public class ClassWithPrimitiveFloat {
    public float value = Float.MAX_VALUE;
}
