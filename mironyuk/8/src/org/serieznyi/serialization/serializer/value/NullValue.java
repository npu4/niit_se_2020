package org.serieznyi.serialization.serializer.value;

final class NullValue extends Value<Object> {
  public NullValue() {
    super(Value.Type.NULL, null);
  }
}
