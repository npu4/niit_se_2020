package org.serieznyi.serialization.serializer.exception;

public final class NormalizerException extends RuntimeException {
  public static NormalizerException fromException(Throwable throwable) {
    return new NormalizerException(throwable);
  }

  public static NormalizerException fromMessage(String message) {
    return new NormalizerException(message);
  }

  public NormalizerException(Throwable e) {
    super(e);
  }

  public NormalizerException(String message) {
    super(message);
  }
}
