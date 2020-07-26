package org.serieznyi.tuple;

import java.util.Objects;

public class Pair<V1, V2> {
  private final V1 first;
  private final V2 second;

  public Pair(V1 first, V2 second) {
    this.first = first;
    this.second = second;
  }

  public V1 getFirst() {
    return first;
  }

  public V2 getSecond() {
    return second;
  }

  public static <V1, V2> Pair<V1, V2> fromArgs(V1 first, V2 second)
  {
    return new Pair<>(first, second);
  }

  @Override
  public String toString() {
    return "Pair{" +
            "first=" + first +
            ", second=" + second +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }
}
