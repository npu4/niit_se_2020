package data.classesForNormalization;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize(skipNull = true)
public class ClassWithNullSkipping {
  public String fieldOne = "one";
  public String fieldTwo;
}
