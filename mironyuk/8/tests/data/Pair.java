package data;

public class Pair<V1, V2> {
    private final V1 valueOne;
    private final V2 valueTwo;

    public Pair(V1 first, V2 second) {

        this.valueOne = first;
        this.valueTwo = second;
    }

    public V1 getFirst() {
        return valueOne;
    }

    public V2 getSecond() {
        return valueTwo;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "valueOne=" + valueOne +
                ", valueTwo=" + valueTwo +
                '}';
    }
}
