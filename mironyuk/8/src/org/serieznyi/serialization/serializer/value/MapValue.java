package org.serieznyi.serialization.serializer.value;

import java.util.Map;

final public class MapValue extends Value<Map<String, ? extends Value<?>>> {
  public MapValue(Map<String, ? extends Value<?>> value) {
    super(Type.MAP, value);
  }
}
