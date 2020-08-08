package org.serieznyi.serialization.serializer.classesForSerialization;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize(skipNull = false)
public class ClassWithoutNullSkipping {
    public String fieldOne = "one";
    public String fieldTwo;
}
