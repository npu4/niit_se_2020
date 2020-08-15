package data.classesForNormalization.supportedPrimitive;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize()
public class ClassWithPrimitiveWrappedInteger {
  public Integer value = Integer.MAX_VALUE;
}
