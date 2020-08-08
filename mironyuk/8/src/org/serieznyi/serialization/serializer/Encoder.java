package org.serieznyi.serialization.serializer;

import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;
import org.serieznyi.serialization.serializer.value.ObjectValue;

public interface Encoder {
  String encode(ObjectValue data) throws FormatNotSupportedException;

  ObjectValue decode(String data) throws FormatNotSupportedException;

  boolean isMatch(Serializer.Format format);
}
