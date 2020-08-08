package org.serieznyi.serialization.serializer;

import org.serieznyi.serialization.serializer.encoder.XmlEncoder;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;

import java.util.Arrays;
import java.util.List;

public final class Serializer {
  private final Normalizer normalizer = new Normalizer();
  private final List<Encoder> encoders = Arrays.asList(new XmlEncoder());

  public Serializer() {}

  public String serialize(Object object, Format format) throws FormatNotSupportedException {
    for (Encoder encoder : encoders) {
      if (encoder.isMatch(format)) {
        return encoder.encode(normalizer.normalize(object));
      }
    }

    throw new FormatNotSupportedException(format);
  }

  public Object deserialize(String data, Class<?> clazz, Format format)
      throws FormatNotSupportedException {
    for (Encoder encoder : encoders) {
      if (encoder.isMatch(format)) {
        return normalizer.denormalize(encoder.decode(data), clazz);
      }
    }

    throw new FormatNotSupportedException(format);
  }

  public enum Format {
    XML
  }
}
