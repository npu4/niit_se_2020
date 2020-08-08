package org.serieznyi.serialization.serializer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Serialize {
  /** @return название типа класса который запишется в кодированную строку */
  String typeName();

  /** @return При false не инициализированные значения будут записаны в конечный результат */
  boolean skipNull() default true;
}
