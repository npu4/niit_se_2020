package org.serieznyi.serialization.serializer.classesForSerialization;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize(skipNull = true)
public class ClassWithNullSkipping {
    public String fieldOne = "one";
    public String fieldTwo;
}
