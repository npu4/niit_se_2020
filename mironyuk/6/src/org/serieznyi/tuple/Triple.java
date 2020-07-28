package org.serieznyi.tuple;

import java.util.Objects;

public class Triple<V1, V2, V3> {
  private final V1 first;
  private final V2 second;
  private final V3 third;

  public Triple(V1 first, V2 second, V3 third) {
    this.first = first;
    this.second = second;
    this.third = third;
  }

  public static <V1, V2, V3> Triple<V1, V2, V3> fromArgs(V1 first, V2 second, V3 third) {
    return new Triple<>(first, second, third);
  }

  public V1 getFirst() {
    return first;
  }

  public V2 getSecond() {
    return second;
  }

  public V3 getThird() {
    return third;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
    return Objects.equals(first, triple.first)
        && Objects.equals(second, triple.second)
        && Objects.equals(third, triple.third);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second, third);
  }

  @Override
  public String toString() {
    return "Triple{" + "first=" + first + ", second=" + second + ", third=" + third + '}';
  }
}
