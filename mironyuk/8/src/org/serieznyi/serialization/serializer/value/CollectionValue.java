package org.serieznyi.serialization.serializer.value;

import java.util.Collection;

final class CollectionValue extends Value<Collection<Value<?>>> {
  CollectionValue(Collection<Value<?>> value) {
    super(Type.COLLECTION, value);
  }
}
