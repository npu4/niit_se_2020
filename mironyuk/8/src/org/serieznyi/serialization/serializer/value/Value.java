package org.serieznyi.serialization.serializer.value;

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

  public enum Type {
    PRIMITIVE,
    OBJECT,
    COLLECTION,
    NULL
  }
}
