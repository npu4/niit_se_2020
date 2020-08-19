package org.serieznyi.serialization.serializer.value;

final class NullValue extends Value<Object> {
  public NullValue() {
    super(Value.Type.NULL, null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    return o != null && getClass() == o.getClass();
  }
}
