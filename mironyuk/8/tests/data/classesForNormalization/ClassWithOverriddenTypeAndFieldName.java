package data.classesForNormalization;

import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeName;

@Serialize(typeName = "NewTypeName")
public class ClassWithOverriddenTypeAndFieldName {
  @SerializeName("newFieldName")
  public String fieldOne = "one";
}
