package org.serieznyi.serialization.serializer.classesForSerialization.unsupportedPrimitive;

import org.serieznyi.serialization.serializer.annotation.Serialize;

import java.util.Arrays;
import java.util.Collection;

@Serialize()
public class ClassWithCollection {
  public Collection<?> value = Arrays.asList(123, 321);
}
