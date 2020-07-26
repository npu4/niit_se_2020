package org.serieznyi.tuple;

import java.util.Objects;

public class Pair<V1, V2> {
  private final V1 valueOne;
  private final V2 valueTwo;

  public Pair(V1 valueOne, V2 valueTwo) {
    this.valueOne = valueOne;
    this.valueTwo = valueTwo;
  }

  public V1 getFirst() {
    return valueOne;
  }

  public V2 getSecond() {
    return valueTwo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(valueOne, pair.valueOne) && Objects.equals(valueTwo, pair.valueTwo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueOne, valueTwo);
  }
}
