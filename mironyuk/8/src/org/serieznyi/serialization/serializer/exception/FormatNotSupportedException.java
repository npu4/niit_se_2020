package org.serieznyi.serialization.serializer.exception;

import org.serieznyi.serialization.serializer.Serializer;

public final class FormatNotSupportedException extends Exception {
  private final Serializer.Format format;

  public FormatNotSupportedException(Serializer.Format format) {
    super("Для формата не найден кодировщик: " + format);

    this.format = format;
  }

  public Serializer.Format getFormat() {
    return format;
  }
}
