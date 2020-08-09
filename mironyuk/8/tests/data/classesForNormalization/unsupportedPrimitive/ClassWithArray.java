package data.classesForNormalization.unsupportedPrimitive;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize()
public class ClassWithArray {
  public int[] value = new int[] {Integer.MAX_VALUE};
}
