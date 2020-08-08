package org.serieznyi.serialization.serializer.classesForSerialization.supportedPrimitive;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize()
public class ClassWithPrimitiveInt {
    public int value = Integer.MAX_VALUE;
}
