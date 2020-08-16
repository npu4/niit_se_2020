package org.serieznyi.serialization.serializer.value;

import java.util.List;

final public class ListValue extends Value<List<? extends Value<?>>> {
  public ListValue(List<? extends Value<?>> value) {
    super(Type.LIST, value);
  }
}
