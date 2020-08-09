package org.serieznyi.serialization.serializer.value;

import java.util.Objects;

public abstract class Value<T> {
  protected final Type type;
  protected final T value;

  Value(Type type, T value) {
    this.type = type;
    this.value = value;
  }

  public Type getType() {
    return type;
  }

  public T getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Value{" + "type=" + type + ", value=" + value + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Value<?> value1 = (Value<?>) o;
    return type == value1.type && value.equals(value1.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }

  public enum Type {
    PRIMITIVE,
    OBJECT,
    NULL
  }
}
