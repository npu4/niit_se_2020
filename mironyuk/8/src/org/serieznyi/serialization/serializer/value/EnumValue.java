package org.serieznyi.serialization.serializer.value;

final class EnumValue extends Value<String> {
  public EnumValue(String value) {
    super(Type.ENUM, value);
  }
}
