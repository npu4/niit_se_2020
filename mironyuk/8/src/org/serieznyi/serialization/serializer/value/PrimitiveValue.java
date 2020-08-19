package org.serieznyi.serialization.serializer.value;

final class PrimitiveValue extends Value<Object> {
  public PrimitiveValue(Object value) {
    super(Value.Type.PRIMITIVE, value);
  }
}
