package org.serieznyi.serialization.serializer.value;

import java.util.HashMap;
import java.util.Map;

public final class ObjectValue extends Value<Map<String, Value<?>>> {
  private final String typeName;

  public ObjectValue(String typeName) {
    super(Value.Type.OBJECT, new HashMap<>());

    this.typeName = typeName;
  }

  public void addPrimitiveValue(String name, String value) {
    this.value.put(name, new PrimitiveValue(value));
  }

  public void addNullValue(String name) {
    this.value.put(name, new NullValue());
  }

  public void addObjectValue(String name, ObjectValue value) {
    this.value.put(name, value);
  }

  public void addValue(String name, Value<?> value) {
    this.value.put(name, value);
  }

  public String getTypeName() {
    return typeName;
  }
}
