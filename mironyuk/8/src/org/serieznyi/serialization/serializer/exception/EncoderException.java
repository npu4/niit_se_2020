package org.serieznyi.serialization.serializer.exception;

public final class EncoderException extends RuntimeException {
  public EncoderException(Throwable e) {
    super(e);
  }

    public EncoderException(String message) {
      super(message);
    }
}
