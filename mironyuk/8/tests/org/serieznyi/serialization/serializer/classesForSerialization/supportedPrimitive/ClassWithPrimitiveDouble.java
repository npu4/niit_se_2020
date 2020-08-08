package org.serieznyi.serialization.serializer.classesForSerialization.supportedPrimitive;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize()
public class ClassWithPrimitiveDouble {
    public double value = Double.MAX_VALUE;
}
