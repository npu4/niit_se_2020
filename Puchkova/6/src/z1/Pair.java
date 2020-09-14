package z1;

import java.util.Objects;

public class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        else if(!(obj instanceof Pair)){
            return false;
        }
        else{
            Pair<?,?> objPair = (Pair<?,?>) obj;
            return (first.equals(objPair.first) && second.equals(objPair.second));
        }
    }

    public int hashCode() {
        return Objects.hash(first, second);
    }

    public void println(){
        System.out.println("Pair: <" + getFirst() + ", " + getSecond() + ">");
    }
}
