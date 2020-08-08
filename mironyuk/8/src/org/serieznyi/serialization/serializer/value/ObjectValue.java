package org.serieznyi.serialization.serializer.value;

import org.serieznyi.serialization.serializer.Assert;

import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public final class ObjectValue extends Value<SortedMap<String, Value<?>>> {
  private final String typeName;

  public ObjectValue(String typeName) {
    super(Value.Type.OBJECT, new TreeMap<>());

    Assert.requireNotEmptyString(typeName, "Название типа не может быть пустым");
    this.typeName = typeName;
  }

  public ObjectValue addPrimitiveValue(String name, String value) {
    this.value.put(name, new PrimitiveValue(value));

    return this;
  }

  public ObjectValue addNullValue(String name) {
    this.value.put(name, new NullValue());

    return this;
  }

  public ObjectValue addObjectValue(String name, ObjectValue value) {
    this.value.put(name, value);

    return this;
  }

  public String getTypeName() {
    return typeName;
  }

  @Override
  public String toString() {
    return "ObjectValue{" +
            "typeName='" + typeName + '\'' +
            ", type=" + type +
            ", value=" + value +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ObjectValue that = (ObjectValue) o;
    return typeName.equals(that.typeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), typeName);
  }
}
