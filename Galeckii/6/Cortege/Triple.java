import java.util.Objects;

public class Triple<S extends Comparable<S>, G extends Comparable<G>, D extends Comparable<D>> {
    private S first;
    private G second;
    private D third;

    public Triple(S first, G second, D third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public S getFirst() {
        return first;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public G getSecond() {
        return second;
    }

    public void setSecond(G second) {
        this.second = second;
    }

    public D getThird() {
        return third;
    }

    public void setThird(D third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(first, triple.first) &&
                Objects.equals(second, triple.second) &&
                Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "first=" + first +
                ", second=" + second +
                ", third=" + third;
    }
}
