package org.serieznyi.tuple;

import java.util.Objects;

public class Triple<V1, V2, V3> {
  private final V1 valueOne;
  private final V2 valueTwo;
  private final V3 valueThree;

  public Triple(V1 valueOne, V2 valueTwo, V3 valueThree) {
    this.valueOne = valueOne;
    this.valueTwo = valueTwo;
    this.valueThree = valueThree;
  }

  public V1 getFirst() {
    return valueOne;
  }

  public V2 getSecond() {
    return valueTwo;
  }

  public V3 getValueThree() {
    return valueThree;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
    return Objects.equals(valueOne, triple.valueOne)
        && Objects.equals(valueTwo, triple.valueTwo)
        && Objects.equals(valueThree, triple.valueThree);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueOne, valueTwo, valueThree);
  }
}
