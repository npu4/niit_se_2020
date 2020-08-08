package org.serieznyi.serialization.serializer.value;

final class PrimitiveValue extends Value<Object> {
  private final Type primitiveType;

  public PrimitiveValue(Object value, Type primitiveType) {
    super(Value.Type.PRIMITIVE, value);
    this.primitiveType = primitiveType;
  }

  public Type getPrimitiveType() {
    return primitiveType;
  }

  enum Type {
    STRING,
    BOOLEAN,
    INTEGER,
    DOUBLE,
  }
}
